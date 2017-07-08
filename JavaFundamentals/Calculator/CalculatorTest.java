public class CalculatorTest{
    public static void main(String[] args) {
        Calculator test = new Calculator();
        test.setOperandOne("1.3");
        test.setOperandTwo("1");
        test.setOperation("-");
        test.performOperation();
    }
}