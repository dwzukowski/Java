import java.util.ArrayList;

class BasicsTest{
    public static void main(String[] args){
        Basics test = new Basics();
        //test.print1to255();
        //test.printOdd1to255();
        //test.printSum0to255();
        int[] testArray = {2, 5, 20, -6, -30};
        //test.iterateArray(testArray);
        //test.findMax(testArray);
        //test.getAverage(testArray);
        //System.out.println(test.arrayWithOddNumbers());
        /* Squared values
        int[] squaredArray = test.squareTheValues(testArray);
        System.out.println(squaredArray);
        for(int value : squaredArray){
            System.out.println(value); 
        }*/
        /*
        int[] newArray = test.eliminateNegativeNumbers(testArray);
        for(int value : newArray){
            System.out.println(value);
        }*/
        /*int[] newArray = test.maxMinAvg(testArray);
        for(int value : newArray){
            System.out.println(value);
        }*/
        int[] newArray = test.shiftValuesInArray(testArray);
        for(int value : newArray){
            System.out.println(value);
        }
    }
}