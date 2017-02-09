package Bank.ActionListeners;

import Bank.Views.Dialogs.Deposit;
import FW.FinCo;
import FW.Model.Accounts.IAccount;
import FW.Singletons.InstanceManager;
import FW.Views.IDataAccessView;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

/**
 * Created by bishal on 2/6/17.
 */
public class BankDepositButtonClicked implements ActionListener, IDataAccessView {

    FinCo parentFrame;
    private String selectedAccount;
    private Integer selectedIndex;
    public BankDepositButtonClicked(FinCo parentFrame) {
        this.parentFrame = parentFrame;
    }

    public void actionPerformed(ActionEvent event) {
        // get selected name
        selectedIndex = parentFrame.getSelectedIndex();
        if(selectedIndex >= 0){
            selectedAccount = (String) parentFrame.getMyModel().getValueAt(selectedIndex, 0);
            if (selectedAccount != ""){
                Deposit wd = new Deposit(parentFrame, this, selectedAccount);

                wd.setBounds(430, 15, 275, 140);
                wd.show();
            }
        }
    }

    public void setData(HashMap<String, String> data){
        IAccount account = InstanceManager.getDAO().getAccount(selectedAccount);
        InstanceManager.getControllerInstance().deposit(account, Double.parseDouble(data.get("amountDeposit")));
        String balance = String.valueOf(account.getBalance());
        DefaultTableModel model = parentFrame.getMyModel();
        model.setValueAt(balance, selectedIndex, 5);
    }

    public JFrame getParentFrame(){
        return parentFrame;
    }
}