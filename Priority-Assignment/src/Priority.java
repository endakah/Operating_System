import java.util.Scanner;

public class Priority {
    public static void main(String[] args){
        int i, k, n, temp;
        int[] p= new int[20];
        int[] bt= new int[20];
        int[] pri= new int[20];
        int[] wt= new int[20];
        int[] tat= new int[20];
        float wtavg, tatavg;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of processes --- ");

        n= input.nextInt();
        for(i=0;i<n;i++)
        {
            p[i] = i;
            System.out.println("Enter the Burst Time --- "+i);
            bt[i] = input.nextInt();
            System.out.println("Enter the Burst  Priority of Process--- "+i);
            pri[i]= input.nextInt();
        }
        for(i=0;i<n;i++)
            for(k=i+1;k<n;k++)
                if(pri[i] > pri[k])
                {
                    temp=p[i];
                    p[i]=p[k];
                    p[k]=temp;
                    temp=bt[i];
                    bt[i]=bt[k];
                    bt[k]=temp;
                    temp=pri[i];
                    pri[i]=pri[k];
                    pri[k]=temp;
                }
        wtavg = wt[0] = 0;
        tatavg = tat[0] = bt[0];
        for(i=1;i<n;i++)
        {
            wt[i] = wt[i-1] + bt[i-1];
            tat[i] = tat[i-1] + bt[i];
            wtavg = wtavg + wt[i];
            tatavg = tatavg + tat[i];
        }
        System.out.println("\nPROCESS\t\tPRIORITY\tBURST TIME\tWAITING TIME\tTURNAROUND TIME");
        for(i=0;i<n;i++)
            System.out.println("\n"+p[i]+" \t\t\t "+pri[i]+" \t\t\t\t"+bt[i]+" \t\t\t "+wt[i]+" \t\t\t\t "+tat[i]);
        System.out.println("\nAverage Waiting Time is --- "+wtavg/n);
        System.out.println("\nAverage Turnaround Time is --- "+tatavg/n);





    }
}
