import java.util.Arrays;

class BankAccount{
    //member variables
    private String accountNumber;
    private long checkingBalance; 
    private long savingsBalance; 
    //class variables
    private static int numberBankAccounts = 0; 
    private static long totalFundsOnDeposit = 0;
    //constructor 
    public BankAccount(){
        numberBankAccounts++; 
        String[] randomElements = {"1","2","3","4","5","6","7","8","9","0"};
        String[] randomAccount = new String[10];
        int count = 0; 
        while(count < 10){
            int randomIndex = (int)(Math.floor(Math.random()*10));            
            randomAccount[count] = randomElements[randomIndex];
            count++;
        }
        accountNumber = Arrays.toString(randomAccount);
    }
    //getters
    public static int getNumberBankAccount(){
        System.out.println("Accounts: " + numberBankAccounts);
        return numberBankAccounts;
    }  
    public static long getTotalFundsOnDeposit(){
        System.out.println("Total Deposits: " + totalFundsOnDeposit);
        return totalFundsOnDeposit;
    }
    public String getAccountNumber(){
        System.out.println("Account number: " + accountNumber);
        return accountNumber;
    }
    public long getCheckingBalance(){
        System.out.println("Checking balance: " + checkingBalance); 
        return checkingBalance;
    }
    public long getSavingsBalance(){
        return savingsBalance;
    }
    //setters
    public void setCheckingBalance(long ammount){
        totalFundsOnDeposit-= getCheckingBalance();
        checkingBalance = ammount;
        totalFundsOnDeposit+= getCheckingBalance(); 

    }
    public void setSavingsBalance(long ammount){
        totalFundsOnDeposit-= getSavingsBalance();
        savingsBalance = ammount;
        totalFundsOnDeposit+= getSavingsBalance(); 
    }
    //methods
    public void makeCheckingDeposit(long ammount){
        setCheckingBalance(getCheckingBalance() + ammount);
    }
    public void makeCheckingWithdrawal(long ammount){
        if(getCheckingBalance() - ammount < 0){
            System.out.println("Not sufficient funds");
        }
        else{
            setCheckingBalance(getCheckingBalance() - ammount);
            System.out.println("Withdrawal made");
        }
    }
}
