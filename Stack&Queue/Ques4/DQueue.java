package Ques4;

public class DQueue {
    DQueueNode head;
    DQueueNode tail;
    int size;

    public DQueue() {
        head = tail = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int size() {
        return size;
    }

    // inserting at first position
    public void insert_first(int element) {
        DQueueNode temp = new DQueueNode(element);
        size++;

        if (head == null) {
            head = tail = temp;
        } else {
            head.prev = temp;
            temp.next = head;
            head = temp;
        }
    }

    // Insert at last position of deque
    public void insert_last(int element) {
        DQueueNode temp = new DQueueNode(element);

        // If element is the first element
        if (head == null) {
            head = tail = temp;
            temp.next = temp.prev = null;
        } else {
            tail.next = temp;
            temp.next = null;
            temp.prev = tail;
            tail = temp;
        }
    }

}
