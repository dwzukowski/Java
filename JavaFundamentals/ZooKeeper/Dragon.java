public class Dragon extends Mammal{
    public Dragon(){
        setEnergy(300);
    }
    public void fly(){
        System.out.println("The dragon flew!");
        setEnergy(displayEnergy() - 50);
    }
    public void eatHumans(){
        System.out.println("The dragon ate a human");
        setEnergy(displayEnergy() + 25);
    }
    public void attackTown(){
        System.out.println("CRACKLE CRACKLE the town is burning!");
        setEnergy(displayEnergy() - 100);
    }
}