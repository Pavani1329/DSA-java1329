import java.util.ArrayList;
public class StackUsingArrayList<T> {
    private ArrayList<T> stackList;
    public StackUsingArrayList() {
        stackList = new ArrayList<>();
    }
    public void push(T element) {
        stackList.add(element);
    }
    public T pop() {
        if (isEmpty()) {
            return null;  
        }
        return stackList.remove(stackList.size() - 1);
    }
    public T peek() {
        if (isEmpty()) {
            return null;
        }
        return stackList.get(stackList.size() - 1);
    }
    public boolean isEmpty() {
        return stackList.isEmpty();
    }
    public int size() {
        return stackList.size();
    }
    public static void main(String[] args) {
        StackUsingArrayList<Integer> stack = new StackUsingArrayList<>();
        System.out.println(stack.pop());
        stack.push(10);
        stack.push(20);
        System.out.println("Top element:"+stack.peek()); 
        System.out.println("Popped element:"+stack.pop()); 
        System.out.println("Popped element:"+stack.pop()); 
        System.out.println("Popped element:"+stack.pop()); 
    }
}
