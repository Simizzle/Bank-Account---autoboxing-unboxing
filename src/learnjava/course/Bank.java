package learnjava.course;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Bank {

    private String name;
    private ArrayList<Branches> branches;

    public Bank(String name) {
        this.name = name;
        this.branches = new ArrayList<Branches>();
    }

    //add a new branch
    public boolean addBranch(String branchName){
        if(findBranch(branchName) == null) {
            this.branches.add(new Branches(branchName));
            return true;
        }
        return false;
    }
    //add a customer to that branch with initial transaction
    public boolean addCustomer(String branchName, String customerName, double initialAmount) {
        Branches branch = findBranch(branchName);
        if(branch != null) {
            return branch.newCustomer(customerName, initialAmount);
        }
        return false;
    }
    //add a transaction for an existing customer
    public boolean addCustomerTransaction(String branchName, String customerName, double amount){
        Branches branch = findBranch(branchName);
        if(branch != null){
            return branch.addCustomerTransaction(customerName, amount);
        } return false;
    }
    private Branches findBranch(String branchName){
        for(int i=0; i<this.branches.size(); i++){
            Branches checkedBranch = this.branches.get(i);
            if(checkedBranch.getName().equals(branchName)){
                return checkedBranch;
            }
        } return null;
    }

    //show a list of customers for a particular branch and transactions

    public boolean listCustomers(String branchName, boolean showTransactions) {
        Branches branch = findBranch(branchName);
        if(branch !=null) {
            System.out.println("Customers for branch " + branch.getName());

            ArrayList<Customer> branchCustomers = branch.getCustomers();
            for(int i=0; i<branchCustomers.size(); i++){
                Customer branchCustomer = branchCustomers.get(i);
                System.out.println("Customer: " + branchCustomer.getName() + "[" + (i+1) + "]");
                if(showTransactions){
                    System.out.println("Transactions");
                    ArrayList<Double> transactions = branchCustomer.getTransactions();
                    for(int j=0; j<transactions.size(); j++){
                        System.out.println("[" + (j+1) + "] Amount " + transactions.get(j));
                    }
                }
            }
        } else {
            return false;
        }
        return true;

    }
}
