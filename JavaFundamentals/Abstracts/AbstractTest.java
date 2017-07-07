public class AbstractTest{
    public static void main(String[] args) {
        SubClassOne test1 = new SubClassOne();
        SubClassTwo test2 = new SubClassTwo();
        test1.randomMethod();
        test1.abstractMethod();
        test2.abstractMethod();
        test2.methodOne();
        test2.methodTwo();
        test1.interfaceStatic();
    } 
}