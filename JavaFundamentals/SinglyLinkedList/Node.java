class Node{
    private Integer value; 
    private Node next;
    //constructor
    public Node(Integer val){
        value = val;
        next = null; 
    } 
    //getter
    public Integer showNodeVal(){
        return value;
    }
    public Node next(){
        return next; 
    }
    //setter
    public void setNext(Node node){
        next = node; 
    }
}