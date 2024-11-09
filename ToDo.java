import java.util.ArrayList;
import java.util.Scanner;

public class ToDo {
    public static void main(String[] args) {
        ToDoTasks app = new ToDoTasks();
        app.operations();
    }
}

class ToDoTasks {
    public ArrayList<String> LiveTasks = new ArrayList<String>();
    public ArrayList<String> Status = new ArrayList<String>();
    public ArrayList<String> CompletedTasks = new ArrayList<String>();
    public String Operations[] = { "Add Task", "Update Task Status", "Display Live Tasks", "Display Completed tasks",
            "Exit" };
    public Scanner s = new Scanner(System.in);

    public void operations() {
        System.out.println("S.no Operations");
        for (int i = 0; i < Operations.length; i++)
            System.out.println((i + 1) + "  " + Operations[i]);
        System.out.print("Enter the S.no to Do the Operation in TODO APP : ");
        int index = s.nextInt();
        if (index - 1 < Operations.length) {
            switch (index) {
                case 1:
                    AddTask();
                    break;
                case 2:
                    UpdateTask();
                    break;
                case 3:
                    DisplayLiveTask();
                    break;
                case 4:
                    DisplayCompleteTask();
                    break;
                case 5:
                    exit();
                    break;
                default:
                    System.out.println("Enter a proper Operation S.no !!");
            }
            this.operations();
        }
    }

    public void AddTask() {
        System.out.println("How many task do you need to add (in numbers): ");
        int count = s.nextInt();
        for (int i = 0; i < count; i++) {
            System.out.print("Enter " + (i + 1) + "th task : ");
            String task = s.nextLine();
            if (task.strip() != "") {
                LiveTasks.add(task);
                Status.add("pending");
            } else {
                System.out.println("Could you please Enter a proper task again for " + (i + 1) + "th task!!");
                i--;
            }
        }
    }

    public void UpdateTask() {
        int i = 0;
        System.out.println("Task no.        Tasks       Status");
        for (i = 0; i < LiveTasks.size(); i++)
            System.out.println((i + 1) + "      " + LiveTasks.get(i) + "        " + Status.get(i));
        System.out.println("Enter the Task No. You need to Update : ");

        int index = s.nextInt();
        if (index - 1 > LiveTasks.size()) {
            System.out.println("Enter a Valid Task Index !!");

        }
        System.out.print("Enter the Task You need to update the " + index
                + "th task Status to (Pending,Process,Completed): ");
        String Upstatus = s.next();
        if (!Upstatus.equalsIgnoreCase("pending") && !Upstatus.equalsIgnoreCase("process")
                && !Upstatus.equalsIgnoreCase("completed")) {
            System.out.println("Enter a valid Status");
            this.UpdateTask();
        } else {
            if (!Upstatus.equalsIgnoreCase("Completed"))
                Status.set(index - 1, Upstatus);
            else {
                Status.remove(index - 1);
                CompletedTasks.add(LiveTasks.remove(index - 1));
            }
        }

    }

    public void DisplayLiveTask() {
        System.out.println();
        System.out.println("Task no.        Tasks       Status");
        for (int i = 0; i < LiveTasks.size(); i++)
            System.out.println((i + 1) + "      " + LiveTasks.get(i) + "        " + Status.get(i));
        System.out.println("That's all about your completed Tasks");
        System.out.println();
    }

    public void DisplayCompleteTask() {
        System.out.println();
        System.out.println("Completed Tasks");
        for (int i = 0; i < LiveTasks.size(); i++)
            System.out.println(CompletedTasks.get(i));
        System.out.println("That's all about your completed Tasks");
        System.out.println();
    }

    public void exit() {
        System.out.println();
        System.out.println("Thank you For Using our TODO Application");
        System.out.println();
        System.exit(0);
    }
}