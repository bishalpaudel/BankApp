package FW.Model.Accounts;

import FW.Model.Customer.ICustomer;
import FW.Report.IReport;
import FW.Transaction.Entry;
import FW.Transaction.IEntry;
import FW.Types.EntryType;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Akash on 2/7/2017.
 */
public abstract class Account implements  IAccount {

    private ICustomer customer;
    private String accountNumber;

    private String abbreviation = "DEF";

    private Double interestRate = 0.0;

    private List<IEntry> entries = new ArrayList<IEntry>();

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public Double getBalance() {
        return 0.0;
    }

    public Boolean withdraw(IEntry withdraw) {


        // Update the logic to withdraw
        entries.add(withdraw);
        return true;
    }

    public Boolean deposit(IEntry deposit) {

        entries.add(deposit);
        return true;
    }

//    }

    public Boolean addEntry(IEntry entry) {
        entries.add(entry);
        return true;
    }

    public List<IEntry> getEntries() {
        return entries;
    }
    public void setCustomer(ICustomer cust)
    {
        customer = cust;
    }

    public ICustomer getCustomer()
    {
        return customer;
    }

    public void generateReport(IReport report)
    {
        report.generate();
    }

    public abstract void generateInterest();
}
