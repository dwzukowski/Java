class PokeDex extends PokeAbstract{
    public String pokemonInfo(Pokemon pokemon){
        String info = "Name: " + pokemon.getName() + ", " + "Type: " + pokemon.getType() + ", " + "Health: " + Integer.toString(pokemon.getHealth());  
        return info;
    }
}