package Bank.ActionListeners;

import Bank.Views.Dialogs.Deposit;
import FW.FinCo;
import FW.Views.Dialogs.JDialog_Deposit;
import FW.Model.Accounts.IAccount;
import FW.Singletons.InstanceManager;
import FW.Views.IDataAccessView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

/**
 * Created by bishal on 2/6/17.
 */
public class BankDepositButtonClicked implements ActionListener, IDataAccessView {

    FinCo parentFrame;
    private String selectedAccount;
    public BankDepositButtonClicked(FinCo parentFrame) {
        this.parentFrame = parentFrame;
    }

    public void actionPerformed(ActionEvent event) {
        // get selected name
        String selectedAccount = parentFrame.getSelectedAccount();
        if (selectedAccount != ""){
            Deposit wd = new Deposit(parentFrame, this, selectedAccount);

            wd.setBounds(430, 15, 275, 140);
            wd.show();

            // compute new amount
//            long deposit = Long.parseLong(amountDeposit);
//            String samount = (String)model.getValueAt(selection, 5);
//            long currentamount = Long.parseLong(samount);
//            long newamount=currentamount-deposit;
//            model.setValueAt(String.valueOf(newamount),selection, 5);
//            if (newamount <0){
//                JOptionPane.showMessageDialog(JButton_Withdraw, " Account "+accnr+" : balance is negative: $"+String.valueOf(newamount)+" !","Warning: negative balance",JOptionPane.WARNING_MESSAGE);
//            }
        }
    }

    public void setData(HashMap<String, String> data){
        IAccount account = InstanceManager.getDAO().getAccount(selectedAccount);
        InstanceManager.getAppInstance().deposit(account, Double.parseDouble(data.get("amountDeposit")));
    }

    public JFrame getParentFrame(){
        return parentFrame;
    }
}