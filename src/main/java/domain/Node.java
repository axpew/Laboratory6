package domain;

public class Node {

    public Object data;
    public Node next; //apuntador al nodo sgte

    //Constructor
    public Node(Object data) {
        this.data = data;
        this.next = null; //puntero al sgte nodo es nulo por default
    }

}
