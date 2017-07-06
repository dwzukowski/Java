public class Gorilla extends Mammal{
    public void throwSomething(){
        System.out.println("The gorilla threw something");
        setEnergy(displayEnergy() - 5);
    }
    public void eatBananas(){
        System.out.println("The gorilla ate some bananas");
        setEnergy(displayEnergy() + 10);
    }
    public void climb(){
        System.out.println("The gorilla climbed a tree");
        setEnergy(displayEnergy() - 10);   
    }
}