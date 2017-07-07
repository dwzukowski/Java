public class PokeTest{
    public static void main(String[] args) {
        PokeDex testdex = new PokeDex();
        Pokemon test1 = testdex.createPokemon("Dave", 10, "Human");
        System.out.println(testdex.pokemonInfo(test1));
        Pokemon test2 = testdex.createPokemon("Pikachu", 6, "Electric");
        testdex.attackPokemon(test2);
        System.out.println(testdex.pokemonInfo(test2));
        System.out.println(Pokemon.getNumberOfPokemon());
    }
}