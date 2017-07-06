public class Samurai extends Human{
    public Samurai(){
        setHealth(200);
    }
    public void deathBlow(Human target){
        target.setHealth(0);
        this.setHealth(this.getHealth() / 2);
        System.out.println("Samurai dealth a deathblow; health now: " + this.getHealth());
    }
    public void meditate(){
        setHealth(getHealth() + getHealth() / 2);
    }
}