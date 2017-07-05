import java.util.ArrayList;
import java.util.Collections;

class PuzzleJava{
    public ArrayList<Integer> sumAndReturnGreaterThan10(int[] array){
        int sum = 0;
        ArrayList<Integer> newArray = new ArrayList<>();
        for(int i = 0; i < array.length; i++){
            sum+= array[i];
            if(array[i] > 10){
                newArray.add(array[i]); 
            } 
        }
        System.out.println(sum);
        System.out.print(newArray);
        return newArray;
    }
    public String[] shuffleAndPrint(){
        String[] names = {"Nancy", "Jinichi", "Fujibayashi", "Momochi", "Ishikawa"};
        ArrayList<String> longNames = new ArrayList<>();
        ArrayList<String> namesList = new ArrayList<>();
        for(String person : names){
            namesList.add(person);
            if(person.length() > 5){
                longNames.add(person);
            }
        }
        String[] result = new String[longNames.size()];
        result = longNames.toArray(result);
        Collections.shuffle(namesList);
        for(String name : namesList){
            System.out.println(name);
        }
        return result; 
    }
    public void alphabetArray(){
        ArrayList<String> alphalist = new ArrayList<>(); 
        String[] alphabet = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
        String[] vowels = {"A", "E", "I", "O", "U"};
        for(String letter : alphabet){
            alphalist.add(letter); 
        } 
        Collections.shuffle(alphalist);
        System.out.println(alphalist.get(0));
        System.out.println(alphalist.get(25));
        for(String vowel : vowels){
            if(vowel == alphalist.get(0)){
                System.out.println("The first letter is a vowel");
            }
        }
    }
    public int[] tenRandomNumbers(){
        int[] result;
        result = new int[10]; 
        for(int i = 0; i < 10; i++){
            result[i] = (int)(Math.random()*46 + 55);
            System.out.println(result[i]);
        }
        int min = result[0];
        int max = result[0];
        int temp; 
        for(int i = 1; i < result.length; i++){
            if(result[i] < min){
                min = result[i];
                temp = result[0];
                result[0] = result[i];
                result[i] = temp;
            }
            if(result[i] > max){
                max = result[i];
            }
        }
        System.out.println("Max: " + max);
        System.out.println("Min: " + min);
        System.out.println("Index zero: " + result[0]);
        return result;
    }
    public void randomString(){
        String[] randomElements = {"A","B,","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z","1","2","3","4","5","6","7","8","9","0"};
        int count = 0; 
        String[] randomString = new String[5];
        while(count < 5){
            int randomNumber = (int)(Math.random()*36 + 1);            
            randomString[count] = randomElements[randomNumber];
            count++;
        }
        System.out.println(randomString);
    }
}