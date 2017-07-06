class PersonTest{
    public static void main(String[] args) {
        Person person1 = new Person();
        Person person2 = new Person(20, "John Doe", 171);
        person1.objectMethods(person2);
    }
}