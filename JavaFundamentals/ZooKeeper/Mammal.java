class Mammal{
    private int energyLevel; 
    public Mammal(){
        energyLevel = 100; 
    }
    //getter
    public int displayEnergy(){
        System.out.println(energyLevel);
        return energyLevel; 
    }
    //setter
    public void setEnergy(int val){
        energyLevel = val; 
    }
}