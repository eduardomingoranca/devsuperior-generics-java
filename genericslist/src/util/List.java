package util;

public class List<T> {
    private Node<T> head;

    public void add(T value) {
        Node<T> node = new Node<>();
        node.setValue(value);
        node.setNext(head);
        head = node;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");

        Node<T> p = head;
        while (p != null) {
            sb.append(p.getValue()).append(" ");
            p = p.getNext();
        }

        sb.append("]");
        return sb.toString();
    }

}
