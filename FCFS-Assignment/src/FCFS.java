import java.util.Scanner;

public class FCFS {
    public static void main(String[] args){

        int  i, n;
        int[] bt = new int[20];
        int[] wt = new int[20];
        int[] tat = new int[20];
        float wtavg, tatavg;
        Scanner input = new Scanner(System.in);
        System.out.println("\nEnter the number of processes -- ");

        n = input.nextInt();
        for(i=0;i<n;i++)
        {
            System.out.println("\nEnter Burst Time for Process  -- "+ i);

            bt[i] = input.nextInt();
        }
        wt[0] = (int) (wtavg = 0);
        tat[0] = (int) (tatavg = bt[0]);
        for(i=1;i<n;i++)
        {
            wt[i] = wt[i-1] +bt[i-1];
            tat[i] = tat[i-1] +bt[i];
            wtavg = wtavg + wt[i];
            tatavg = tatavg + tat[i];
        }
        System.out.println("\t PROCESS \tBURST TIME \t WAITING TIME\t TURNAROUND TIME\n");
        for(i=0;i<n;i++)
            System.out.println("  \n\t\t "+i+" \t\t\t "+bt[i]+" \t\t\t "+wt[i]+" \t\t\t "+ tat[i]);
        System.out.println("\nAverage Waiting Time -- "+ wtavg/n);
        System.out.println("\nAverage Turnaround Time -- "+ tatavg+"\n\n");


    }
}
