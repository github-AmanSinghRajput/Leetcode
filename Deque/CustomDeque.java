package Deque;

import java.util.ArrayList;
import java.util.List;

public class CustomDeque {
    private List<Integer> deque;

    public CustomDeque() {
        deque = new ArrayList<>();
    }

    public void addFront(int val){
        deque.addFirst(val);
    }
    public void addRear(int val){
        deque.add(val);
    }

    public int removeFront(){
        if(deque.isEmpty()) throw new RuntimeException("Deque is empty");
        return deque.removeFirst();
    }

    public int removeRear() {
        if(deque.isEmpty()) throw new RuntimeException("Deque is empty");
        return deque.removeLast();
    }

    public int peekFront() {
        if(deque.isEmpty()) throw new RuntimeException("Deque is empty");
        return deque.getFirst();
    }

    public int peekRear() {
        if(deque.isEmpty()) throw new RuntimeException("Deque is empty");
        return deque.getLast();
    }

    public boolean isEmpty() {
        return deque.isEmpty();
    }

    public int size() {
        return deque.size();
    }

    public void print() {
        System.out.println("Deque: " + deque);
    }


    public static void main(String[] args) {
        CustomDeque dq = new CustomDeque();
        dq.addFront(10);
        dq.addRear(20);
        dq.addFront(5);
        dq.addRear(25);

        dq.print();  // [5, 10, 20, 25]

        System.out.println("Front: " + dq.peekFront()); // 5
        System.out.println("Rear: " + dq.peekRear());   // 25

        dq.removeFront();  // Removes 5
        dq.removeRear();   // Removes 25

        dq.print();  // [10, 20]
        System.out.println("Size: " + dq.size()); // 2
    }

}
