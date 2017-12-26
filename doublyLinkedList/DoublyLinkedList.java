public class DoublyLinkedList {

  public class Node {
    private int data;
    private Node prev;
    private Node next;

    public Node(int d) {
      data = d;
      prev = null;
      next = null;
    }

    public int getData() {
      return data;
    }

    public Node getNext() {
      return next;
    }

    public Node getPrev() {
      return prev;
    }

    public void setData(int d) {
      data = d;
    }

    public void setNext(Node n) {
      next = n;
    }

    public void setPrev(Node n) {
      prev = n;
    }
  }

  private Node head;
  private Node tail;

  public DoublyLinkedList() {
    head = null;
    tail = null;
  }

  public void append(int d) {
    Node node = new Node(d);

    if (head == null) {
      head = node;

      return;
    }

    if (tail == null) {
      tail = node;

      tail.setPrev(head);
      head.setNext(tail);

      return;
    }

    tail.setNext(node);
    node.setPrev(tail);

    tail = node;
  }

  public void prepend(int d) {
    Node node = new Node(d);
    if (head == null) {
      head = node;

      return;
    }

    node.setNext(head);
    head.setPrev(node);
    head = node;
  }

  public void traverse() {
    if (head == null) return;

    Node current = head;

    while (current != null) {
      System.out.println(current.getData());
      current = current.getNext();
    }
  }

  public void traverseInReverse() {
    if (tail == null || head == null) return;

    Node current = tail;

    while (current != null) {
      System.out.println(current.getData());
      current = current.getPrev();
    }
  }

  public static void main(String args[]) {
    DoublyLinkedList dl = new DoublyLinkedList();
    dl.append(5);
    dl.append(6);
    dl.prepend(9);
    dl.traverse();
  }
}
