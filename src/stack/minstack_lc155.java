package stack;
import java.util.Stack;

public class minstack_lc155 {
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> min_val = new Stack<>();

    public void push(int val) {
        if (min_val.isEmpty() || val < min_val.peek()) {
            min_val.push(val);  //push if min
        }
        stack.push(val);
    }

    public void pop() {
        if (min_val.peek().equals (stack.peek())) {
            min_val.pop();  //pop value if the top of task is equal to the min val
        }
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min_val.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */

