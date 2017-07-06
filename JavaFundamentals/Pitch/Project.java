class Project{
    private String name; 
    private String description; 
    private double initialCost;
    //constructors
    public Project(){
    }
    public Project(String name){
        this.name= name;
    }
    public Project(String name, String description){
        this.name = name;
        this.description = description; 
    }
    public Project(String name, String description, double initialCost){
        this.name = name;
        this.description = description; 
        this.initialCost = initialCost; 
    }
    //setters
    public void setName(String name){
        this.name = name; 
    }
    public void setDescription(String description){
        this.description = description;
    }
    public void setInitialCost(double initialCost){
        this.initialCost = initialCost;
    }
    //getters 
    public String getName(){
        return name;
    }
    public String getDescription(){
        return description; 
    }
    public double getinitialCost(){
        return initialCost; 
    }
    //methods 
    public void elevatorPitch(){
        System.out.println(getName() + "(" + getinitialCost() + ")" + " : " + getDescription());  
    }
}