public abstract class PokeAbstract implements PokeInterface{
    public Pokemon createPokemon(String name, int health, String type){
        Pokemon aNewPokemon = new Pokemon(name, health, type);
        return aNewPokemon;
    }
    public void attackPokemon(Pokemon pokemon){
        pokemon.setHealth(pokemon.getHealth() - 10);
    }
}