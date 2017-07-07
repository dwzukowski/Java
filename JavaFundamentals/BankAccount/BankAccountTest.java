class BankAccountTest{
    public static void main(String[] args) {
        BankAccount test = new BankAccount();
        test.getAccountNumber(); 
        test.makeCheckingWithdrawal(50);
        BankAccount.getTotalFundsOnDeposit();
        test.makeCheckingDeposit(100);
        test.getCheckingBalance();
        test.makeCheckingWithdrawal(80);
        test.getCheckingBalance();
        BankAccount.getTotalFundsOnDeposit();
    }
}