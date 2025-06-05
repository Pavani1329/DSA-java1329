import java.util.ArrayList;
public class QueueUsingArraylist{
    public static void main(String[] args) {
        ArrayList<Integer> queue = new ArrayList<>();
        queue.add(10);
        queue.add(20);
        queue.add(30);
        System.out.println("Queue after adding: " + queue);
        if (!queue.isEmpty()) {
            int removed = queue.remove(0);
            System.out.println("polled:" + removed);
        } else {
            System.out.println("Queue is empty, cannot poll.");
        }
        if (!queue.isEmpty()) {
            System.out.println("Peek:"+queue.get(0));
        } else {
            System.out.println("Queue is empty,nothing to peek.");
        }
        System.out.println("Is queue empty? "+queue.isEmpty());
    }
}
