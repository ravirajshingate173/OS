import java.util.*;
public class FCFS {

    public static void main(String[] args) {

        //taking inputs from the user
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no. of processes: ");
        int n = sc.nextInt();

        int pid[] = new int[n];
        int at[] = new int[n];
        int ct[] = new int[n];
        int bt[] = new int[n];
        int tat[] = new int[n];
        int wt[] = new int[n];
        int temp;
        float avgwt = 0, avgtat = 0;

        for (int i = 0; i < n; i++) {
            System.out.println("Enter process" + (i+1) + " arrival time: ");
            at[i] = sc.nextInt();
            System.out.println("Enter process " + (i+1) + " burst time: ");
            bt[i] = sc.nextInt();
        }
        //sorting the processes according to the arrival times
        for (int i = 0; i < n; i++) {
            for(int j = 0; j < n-(i+1); j++) {
                if(at[j] > at[j+1]) {
                    temp = at[j];
                    at[j] = at[j+1];
                    at[j+1] = temp;

                    temp = bt[j];
                    bt[j] = bt[j+1];
                    bt[j+1] = temp;

                    temp = pid[j];
                    pid[j] = pid[j+1];
                    pid[j+1] = temp;

                }
            }
        }
        //Finding completion time 
        for(int i = 0; i < n; i++) {
            if (i == 0) {
                ct[i] = at[i] + bt[i];
            }
            else {
                if(at[i] > ct[i-1]) {
                    ct[i] = at[i] + bt[i];
                }
                else {
                    ct[i] = ct[i-1] + bt[i];
                }
            }

            tat[i] = ct[i] - at[i];
            wt[i] = tat[i] - bt[i];
            avgwt += wt[i];
            avgtat += tat[i];
        }

        System.out.println("pid   arrival   burst   complete    turnaround   waiting");

        for(int i = 0; i < n; i++) {
            System.out.println(pid[i] + "\t" + at[i] + "\t  " + bt[i] + "\t   " + ct[i] + "\t        " + tat[i] + "\t    " + wt[i]);
        }
        sc.close();

        System.out.println("\naverage waiting time: "+ (avgwt/n));
        System.out.println("\naverage turnaround time: "+ (avgtat/n));

    }
    
}
