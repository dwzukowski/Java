public abstract class AbstractClass implements InterfaceDemo{
    public void randomMethod(){
        System.out.println("Hello from the random method written in the abstract class");
    }
    //abstract method; must be implemented by subclass
    public abstract void abstractMethod();
    public void methodTwo(){
        System.out.println("method two");
    }
    //connecting static interface method so that classes that extend AbstractClass can access
    public void interfaceStatic(){
        InterfaceDemo.interfaceStatic();
    }
}