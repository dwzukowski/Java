class SinglyLinkedList{
    private Node head; 
    //constructor
    public SinglyLinkedList(){
        head = null; 
    }
    //setter
    public void setHead(Node node){
        head = node; 
    }
    //getter
    public Node listHead(){
        return head; 
    }
    public void add(Node newNode){
        //check if list is empty; if so newNode is head
        if (head == null){
            head = newNode; 
        }
        //else instantinate while loop and use .next() method to iterate to end of list; set next attribute of final value to newNode
        else{
            Node pointer = head; 
            while(pointer.next() != null){
                pointer = pointer.next(); 
            }
            pointer.setNext(newNode);
        }
    }
    public void removeLastNode(){
        Node pointer = head; 
        while(pointer.next().next() != null){
            pointer = pointer.next();
        }
        pointer.setNext(null);
    }
    public void printAllListValues(){
        if(head == null){
            System.out.println("List is empty");
        }
        else{
            //print head then instantiate while loop to print all other nodes
            System.out.println(head.showNodeVal());
            Node pointer = head;
            while(pointer.next() != null){
                pointer = pointer.next();
                System.out.println(pointer.showNodeVal());
            }
        }
    }
    //search through list and return first node whose value equals val
    public Node find(Integer val){
        if(head == null){
            return null; 
        }
        if(head.showNodeVal() == val){
            return head; 
        }
        //if SLL is not empty and the head value does not match val, iterate through list. 
        Node pointer = head; 
        while(pointer.next() != null){
            pointer = pointer.next();
            if(pointer.showNodeVal() == val){
                return pointer; 
            }
        }
        //if value not found, return null 
        return null;
    }
    //remove the nth Node in the list
    public void removeAt(int n){
        if(n <= 0){
            System.out.println("No values removed");
        }
        else if(n == 1){
            Node pointer = head;
            this.setHead(pointer.next());
        }
        else{
            Node pointer = head; 
            int count = n;
            //instantiate while loop; stop moving pointer 1 Node before nth Node
            while(count > 2){
                pointer = pointer.next(); 
                count--; 
            }
            //after while loop, pointer is 1 Node from nth Node; use setter method to assign next attribute to Node after the nth node
            pointer.setNext(pointer.next().next());
        }
    }
}