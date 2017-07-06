class Vehicle{
    private int numberOfWheels;
    private String color;
    //constructor method with no parameters
    public Vehicle(){

    }
    //overloading constructor method to allow multiple ways of instantiating object
    public Vehicle(String color){
        color = color;
    }
    public Vehicle(String color, int num){
        color = color;
        numberOfWheels = num; 
    }
    //getter method
    public int getNumberOfWheels(){
        return numberOfWheels; 
    }
    //setter method
    public void setNumberOfWheels(int number){
        numberOfWheels = number;
    }
    //getter method
    public String getColor(){
        return color;
    }
    //setter method
    public void setColor(String vehicleColor){
        color = vehicleColor; 
    }
}