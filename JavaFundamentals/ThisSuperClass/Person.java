class Person{
    private int age;
    private String name;
    private int height;
    public Person() {
        this(20, "John Doe", 171);
    }
    public Person(int age, String name, int height){
        this.age = age;
        this.name = name;
        this.height = height;
    }
    public void objectMethods(Person anotherObject){
        System.out.println("Class name: " + this.getClass().getSimpleName());
        System.out.println("toString: " + this.toString());
        System.out.println("Equals: " + this.equals(anotherObject));
    }
}