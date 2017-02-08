package FW.Views;

import FW.Model.Accounts.IAccount;
import FW.Model.Customer.ICustomer;
import FW.Observers.ICustomerChangeObserver;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

/**
 * Created by bishal on 2/6/17.
 */
public class CustomersTableView extends JTable implements ICustomerChangeObserver {

    DefaultTableModel model;

    public CustomersTableView(DefaultTableModel model1) {
        super(model1);
        model = model1;
        model.addColumn("AccountNr");
        model.addColumn("Name");
        model.addColumn("City");
        model.addColumn("Type");
        model.addColumn("Type");
        model.addColumn("Amount");
    }

    public void doUpdate(ICustomer customer, IAccount account) {
        Object rowdata[] = new Object[6];
        rowdata[0] = account.getAccountNumber();
        rowdata[1] = customer.getName();
        rowdata[2] = customer.getCity();
        rowdata[3] = customer.getAbbreviation();
        rowdata[4] = account.getAbbreviation();
        rowdata[5] = account.getBalance().toString();
        for(Object o: rowdata){
            System.out.println(o);
        }
        model.addRow(rowdata);
        getSelectionModel().setAnchorSelectionIndex(-1);
    }
}
