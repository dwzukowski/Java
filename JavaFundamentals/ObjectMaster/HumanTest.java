import javax.naming.NoInitialContextException;

class HumanTest{
    public static void main(String[] args) {
        Human hero = new Human();
        hero.getHealth();
        hero.getStrength();
        Human enemy = new Human();
        hero.attack(enemy);
        Wizard merlin = new Wizard();
        merlin.getIntelligence();
        merlin.getHealth();
        merlin.heal(hero);
        merlin.fireball(enemy);
        Ninja dojo = new Ninja();
        dojo.steal(enemy);
        dojo.runAway();
        dojo.getHealth();
        Samurai sam = new Samurai();
        sam.deathBlow(enemy);
        enemy.getHealth();
    }
}