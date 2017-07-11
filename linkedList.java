class Node {
  private int data;
  private Node next;
  
  public Node(int data) {
    this.data = data;
  }
  
  public void setData(int data) {
    this.data = data;
  }
  
  public void setNext(Node n) {
    this.next = n;
  }
  
  public int getData() {
    return this.data;
  }
  
  public Node getNext() {
    return this.next;
  }
  
  public void printNode() {
    System.out.println(this.data);
  }
}

class LinkedList {
  public Node head;
  public Node tail;
  
  public void append(int data) {
    if(this.head == null) {
      this.head = new Node(data);
      return;
    }
    
    if(this.tail == null) {
      this.tail = new Node(data);
      this.head.setNext(this.tail);
      return;
    }
    Node n = new Node(data);
    this.tail.setNext(n);
    this.tail = n;
  }
  
  public void traverse() {
    if(this.head == null) {
      return;
    }
    
    Node node = this.head;
    
    while(node != null) {
      node.printNode();
      node = node.getNext();
    }
  }
}

class Main {
  public static void main(String []args) {
    LinkedList l = new LinkedList();
    l.append(4);
    l.append(5);
    l.append(6);
    l.traverse();
  }
}
