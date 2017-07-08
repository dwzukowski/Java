public class Calculator implements CalcInterface{
    //member variables
    private String operandOne;
    private String operandTwo;
    private String operation;
    private String results; 
    //constructor
    public Calculator() {
    }
    //getters;
    public String getOperandOne(){
        return operandOne;
    }
    public String getOperandTwo(){
        return operandTwo;
    }
    public String getOperation(){
        return operation;
    }
    public String getResults(){
        System.out.println(results);
        return results;
    }
    //setters;
    public void setOperandOne(String operand){
        operandOne = operand; 
    }
    public void setOperation(String operation){
        if(operation == "+" || operation == "-"){
            this.operation = operation;
        }
        else{
            System.out.println("Can't perform that operation");
        } 
    }
    public void setOperandTwo(String operand){
        operandTwo = operand;
    }
    public void performOperation(){
        if(operation == "+"){
            double temp = Double.parseDouble(operandOne) + Double.parseDouble(operandTwo);
            results = Double.toString(temp);
            getResults(); 
        }
        if(operation == "-"){
            double temp = Double.parseDouble(operandOne) - Double.parseDouble(operandTwo);
            results = Double.toString(temp);
            getResults(); 
        }
    }

}