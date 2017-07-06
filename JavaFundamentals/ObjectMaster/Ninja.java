public class Ninja extends Human{
    public Ninja(){
        setStealth(10);
    }
    public void steal(Human target){
        target.setHealth(target.getHealth() - this.getStealth());
        this.setHealth(this.getHealth() + this.getStealth());
        System.out.println("Ninja stole health from enemy; target health now: " + target.getHealth());
    }
    public void runAway(){
        setHealth(getHealth() - 10);
        System.out.println("Ninja ran away");
    }
}