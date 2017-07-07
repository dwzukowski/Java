class Person{
    private int age;
    private String name;
    //class variable can be accessed by all objects; can be called without creating an instance of Person 
    //public static int numberOfPeople = 0;
    private static int numberOfPeople = 0;
    public Person(int ageParam, String nameParam){
        age = ageParam;
        name = nameParam;
        numberOfPeople++;
    }
    //class method to access class variable numberOfPeople
    public static int peopleCount(){
        return numberOfPeople;
    }
}