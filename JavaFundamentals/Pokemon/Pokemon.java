public class Pokemon{
    //static class variable
    private static int numberOfPokemon = 0;  
    //member variables
    private String name;
    private int health;
    private String type;
    //constructors
    public Pokemon(){
        numberOfPokemon++;
    }
    public Pokemon(String name, int health, String type){
        this.name = name;
        this.health = health;
        this.type = type;
        numberOfPokemon++;
    }
    //getters
    public static int getNumberOfPokemon(){
        return numberOfPokemon;
    }
    public String getName(){
        return name;
    }
    public int getHealth(){
        return health;
    }
    public String getType(){
        return type; 
    }
    //setters
    public void setName(String name){
        this.name = name;
    }
    public void setHealth(int health){
        this.health = health;
    }
    public void setType(String type){
        this.type = type;
    }
}