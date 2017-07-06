public class Wizard extends Human{
    //constructor w/ modifcations 
    public Wizard(){
        setHealth(50);
        setintelligence(8);
    }
    public void heal(Human target){
        target.setHealth(target.getHealth() + this.getIntelligence());
        System.out.println("Wizard cast healing spell; target health: " + target.getHealth());
    }
    public void fireball(Human target){
        target.setHealth(target.getHealth() - this.getIntelligence() * 3);
        System.out.println("Wizard cast fireball; target health: " + target.getHealth());
    }
}