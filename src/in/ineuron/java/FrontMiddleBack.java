package in.ineuron.java;


import java.util.Deque;
import java.util.LinkedList;

class FrontMiddleBack {
    private Deque<Integer> deque;

    public FrontMiddleBack() {
        deque = new LinkedList<>();
    }

    public void pushFront(int val) {
        deque.addFirst(val);
    }

    public void pushMiddle(int val) {
        int size = deque.size();
        int middle = size / 2;

        // Insert at the middle position
        for (int i = 0; i < middle; i++) {
            deque.addLast(deque.removeFirst());
        }

        deque.addLast(val);

        // Move elements after the middle back to their original positions
        for (int i = 0; i < middle; i++) {
            deque.addFirst(deque.removeLast());
        }
    }

    public void pushBack(int val) {
        deque.addLast(val);
    }

    public int popFront() {
        if (deque.isEmpty()) {
            return -1;
        }
        return deque.removeFirst();
    }

    public int popMiddle() {
        if (deque.isEmpty()) {
            return -1;
        }

        int size = deque.size();
        int middle = (size - 1) / 2;

        // Move elements before the middle to the back
        for (int i = 0; i < middle; i++) {
            deque.addLast(deque.removeFirst());
        }

        int middleElement = deque.removeFirst();

        // Move elements back to their original positions
        for (int i = 0; i < middle; i++) {
            deque.addFirst(deque.removeLast());
        }

        return middleElement;
    }

    public int popBack() {
        if (deque.isEmpty()) {
            return -1;
        }
        return deque.removeLast();
    }
}
