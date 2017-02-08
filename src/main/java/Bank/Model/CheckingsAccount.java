package Bank.Model;

import FW.Model.Accounts.Account;
import FW.Model.Accounts.IAccount;
import FW.Model.Customer.ICustomer;
import FW.Report.IReport;
import FW.Transaction.Entry;
import FW.Transaction.IEntry;
import FW.Types.EntryType;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by bishal on 2/6/17.
 */
public class CheckingsAccount extends Account {
    private Double interestRate = 0.0;

    @Override
    public void generateInterest() {
        Double totalBalance = getBalance();
        Double interest = totalBalance * interestRate;
        IEntry entry = new Entry(EntryType.DEPOSIT, new Date().toString(), interest);
    }
}
