class PersonTest{
    public static void main(String[] args){
        Person person1 = new Person(31, "Dave");
        //accessing class variable numberOfPeople 
        //System.out.println(Person.numberOfPeople);
        Person person2 = new Person(31, "Amanda");
        //System.out.println(Person.numberOfPeople);
        //calling class method peopleCount to access class variable numberOfPeople
        System.out.println(Person.peopleCount());
    }
}