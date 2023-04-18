package main.linkedlist;

public class SinglyLinkedList<E> {
    private Node<E> head;
    private Node<E> currentNode;
    private int size;

    private static class Node<E> {
        E value;
        Node<E> next;

        Node(E value, Node<E> next){
            this.value = value;
            this.next = next;
        }
    }

    public void add(E element) {
        if (head == null) {
            head = new Node<>(element, null);
        }
    }
}
