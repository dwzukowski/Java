import java.util.ArrayList;

class Basics{
    public void print1to255(){
        for(int i = 1; i < 256; i++){
            System.out.println(i);
        }
    } 
    public void printOdd1to255(){
        for(int i = 1; i < 256; i++){
            if(i % 2 != 0){
                System.out.println(i);
            }
        }
    }
    public void printSum0to255(){
        int sum = 0; 
        for(int i = 0; i < 256; i++){
            System.out.println("New number: " + i);
            sum+= i; 
            System.out.println("Sum: " + sum); 
        }
    }
    public void iterateArray(int[] array){
        for(int i=0; i < array.length; i++){
            System.out.println(array[i]);
        }
    }
    public void findMax(int[] array){
        int max= array[0];
        for(int i = 1; i < array.length; i++){
            if(array[i] > max){
                max = array[i];
            }
        }
        System.out.println("The max value is: " + max);
    }
    public void getAverage(int[] array){
        int sum = 0; 
        for(int i = 0; i < array.length; i++){
            sum+= array[i];
        }
        //computing average and casting int sum to double. Casting has precedence over divison and occurs first
        double average = (double)sum/array.length; 
        System.out.println(average);
    }
    public ArrayList<Integer> arrayWithOddNumbers(){
        ArrayList<Integer> oddArray = new ArrayList<>();
        for(int i=1; i < 255; i++){
            if(i % 2 != 0){
                oddArray.add(i);
            }
        }
        return oddArray; 
    }
    public int greaterThanY(int[] array, int y){
        int count = 0;
        for(int i = 0; i < array.length; i++){
            if(array[i] > y){
                count++;
            }
        }
        return count;
    }
    public int[] squareTheValues(int[] array){
        for(int i = 0; i < array.length; i++){
            array[i]*= array[i];
        }
        return array;
    }
    public int[] eliminateNegativeNumbers(int[] array){
        for(int i = 0; i < array.length; i++){
            if(array[i] < 0){
                array[i] = 0;
            }
        }
        return array; 
    }
    public int[] maxMinAvg(int[] array){
        int max = array[0];
        int min = array[0];
        int avg = 0; 
        int sum = 0;  
        for(int i = 0; i < array.length; i++){
            if(array[i] > max){
                max = array[i];
            }
            if(array[i] < min){
                min = array[i];
            }
            sum+= i; 
        }
        avg= sum/array.length; 
        int[] result = {max, min, avg};
        return result; 
    }
    public int[] shiftValuesInArray(int[] array){
        for(int i = 0; i < array.length - 1; i++){
            array[i] = array[i + 1];
        }
        array[array.length-1] = 0; 
        return array;
    }
}