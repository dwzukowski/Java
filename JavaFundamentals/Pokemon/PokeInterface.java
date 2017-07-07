public interface PokeInterface{
    //abstract interface methods
    Pokemon createPokemon(String name, int health, String type);
    void attackPokemon(Pokemon pokemon);
    String pokemonInfo(Pokemon pokemon);
    //static method
    public static void interfaceStatic(){
        System.out.println("Hello from the interface");
    }
}
