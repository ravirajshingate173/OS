import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Process {
    int processId;
    int burstTime;
    int priority;

    public Process(int processId, int burstTime, int priority) {
        this.processId = processId;
        this.burstTime = burstTime;
        this.priority = priority;

    }
}

public class Priority {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Process> processes = new ArrayList<>();
        System.out.println("Enter the number of processes: ");
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            System.out.println("Enter burst time for process" + i + ": ");
            int burstTime = sc.nextInt();

            System.out.println("Enter priority for process " + i + ": ");
            int priority = sc.nextInt();

            processes.add(new Process(i, burstTime, priority));
        }

        Collections.sort(processes, (p1, p2) -> p2.priority - p1.priority);
        int waitingTime = 0;
        int turnaroundTime;

        System.out.println("Pid\tBt\tPr\tWt\tTat");

        for (Process process : processes) {
            turnaroundTime = waitingTime + process.burstTime;
            System.out.println(process.processId + "\t" + process.burstTime + "\t" + process.priority + "\t"
                    + waitingTime + "\t" + turnaroundTime);
            waitingTime += process.burstTime;
        }
        sc.close();
    }
}