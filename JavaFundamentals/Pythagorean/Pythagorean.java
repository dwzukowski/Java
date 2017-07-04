import java.lang.Math;
class Pythagorean{
    public double calculateHypotenuse(int sideA, int sideB){
        double a = Math.pow(sideA, 2);
        double b = Math.pow(sideB, 2);
        double c = Math.sqrt(a + b);
        return c; 
    }
}