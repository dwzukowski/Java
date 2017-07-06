class VehicleTest{
    public static void main(String[] args){
        Vehicle bike = new Vehicle();
        Vehicle car = new Vehicle();
        bike.setColor("red");
        bike.setNumberOfWheels(2);
        int bikeWheels = bike.getNumberOfWheels();
        String bikeColor = bike.getColor();
        System.out.println("Bike Object - Wheels: " + bikeWheels + ", Color: " + bikeColor);
    }
}