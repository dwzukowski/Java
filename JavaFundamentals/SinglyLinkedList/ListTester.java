class ListTester{
    public static void main(String[] args) {
        //Node testNode = new Node(2);
        SinglyLinkedList testSLL = new SinglyLinkedList();
        //System.out.println(testNode.showNodeVal());
        //System.out.println(testSLL.listHead());
        //System.out.println(testNode.next());
        Node node1 = new Node(2);
        Node node2 = new Node(4);       
        Node node3 = new Node(6);
        Node node4 = new Node(8);
        Node node5 = new Node(10);
        testSLL.add(node1);
        testSLL.add(node2);
        testSLL.add(node3);
        testSLL.add(node4);
        testSLL.add(node5);
        //System.out.println(testSLL.listHead().next().next().showNodeVal());
        //testSLL.removeLastNode();
        //System.out.println(testSLL.listHead().next().next().showNodeVal());
        //testSLL.printAllListValues();
        //System.out.println(testSLL.find(6));
        testSLL.printAllListValues();
        testSLL.removeAt(2);
        testSLL.printAllListValues();
    }
}