package Ques4;

public class DQueueNode {
    int value;
    DQueueNode prev;
    DQueueNode next;

    public DQueueNode() {
        prev = null;
        next = null;
    }

    public DQueueNode(int x) {
        value = x;
        prev = null;
        next = null;
    }

    public DQueueNode(int x, DQueueNode prev, DQueueNode next) {
        value = x;
        this.prev = prev;
        this.next = next;
    }
}
