package queue;

import java.util.LinkedList;
import java.util.Queue;

public class InBuiltExample {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(3);
        queue.add(95);
        queue.add(62);
        queue.add(2);
        queue.add(29);

        System.out.println(queue.peek()); //just peeks the first element doesn't remove the element

        System.out.println(queue.remove()); //removes

        System.out.println(queue); //after removing

    }
}
