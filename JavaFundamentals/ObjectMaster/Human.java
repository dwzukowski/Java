class Human{
    private int strength;
    private int stealth;
    private int intelligence; 
    private int health;
    //constructors
    //code below works because we have another constructer that has 4 int parameters
    public Human(){
        this(3, 3, 3, 100);
    }
    public Human(int strength, int stealth, int intelligence, int health){
        this.strength = strength;
        this.stealth = stealth;
        this.intelligence = intelligence;
        this.health = health;
    }
    //setters
    public void setStrength(int val){
        strength = val; 
    }
    public void setStealth(int val){
        stealth = val; 
    }
    public void setintelligence(int val){
        intelligence = val; 
    }
    public void setHealth(int val){
        health = val; 
    }

    //getters
    public int getStrength(){
        System.out.println(strength);
        return strength;
    }
    public int getStealth(){
        System.out.println(stealth);
        return stealth;
    }
    public int getIntelligence(){
        System.out.println(intelligence);
        return intelligence;
    }
    public int getHealth(){
        System.out.println(health);
        return health;
    }
    //actions
    public void attack(Human target){
        target.setHealth(target.getHealth() - this.getStrength());
        System.out.println("You attacked an opponent. Their health is now: " + target.getHealth());
    }
}