import java.util.ArrayList;
public class TaskScheduler {
    ArrayList<String> taskQueue = new ArrayList<>();
    public void addTask(String task) {
        taskQueue.add(task);
        System.out.println("Task added: " + task);
    }
    public void processTask() {
        if (taskQueue.isEmpty()) {
            System.out.println("No tasks to process.");
        } else {
            String task = taskQueue.remove(0);
            System.out.println("Processing task: " + task);
        }
}
    public static void main(String[] args) {
        TaskScheduler scheduler = new TaskScheduler();
        scheduler.addTask("Task 1: Wake up");
        scheduler.addTask("Task 2: Get Ready");
        scheduler.addTask("Task 3: Go to college");
        scheduler.processTask();
        scheduler.processTask(); 
        scheduler.processTask();  
        scheduler.processTask();  
    }
}
