import java.util.Scanner;

public class roundR {
    public static void main(String[]  args){
        int i,j,n,t,max;
        int[] bu=new int[10];
        int[] wa=new int[10];
        int[] tat=new int[10];
        int[] ct=new int[10];
        Scanner input = new Scanner(System.in);
        double awt=0,att=0,temp=0;

        System.out.println("Enter the no of processes -- ");

        n=input.nextInt();
        for(i=0;i<n;i++)
        {
            System.out.println("\nEnter Burst Time for process  -- "+ (i+1));

            bu[i]=input.nextInt();
            ct[i]=bu[i];
        }
        System.out.println("\nEnter the size of time slice -- ");

        t=input.nextInt();
        max=bu[0];
        for(i=1;i<n;i++)
            if(max<bu[i])
                max=bu[i];
        for(j=0;j<(max/t)+1;j++)
            for(i=0;i<n;i++)
                if(bu[i]!=0)
                    if(bu[i]<=t)
                    {
                        tat[i]= (int) (temp+bu[i]);
                        temp=temp+bu[i];
                        bu[i]=0;
                    }
                    else
                    {
                        bu[i]=bu[i]-t;
                        temp=temp+t;
                    }
        for(i=0;i<n;i++)
        {
            wa[i]=tat[i]-ct[i];
            att+=tat[i];
            awt+=wa[i];

        }
        System.out.println("\nThe Average Turnaround time is -- "+att/n);
        System.out.println("\nThe Average Waiting time is --  "+awt/n);
        System.out.println("\n\tPROCESS\t BURST TIME \t WAITING TIME\tTURNAROUND TIME\n");
        for(i=0;i<n;i++)
            System.out.println("\t  "+(i+1)+" \t\t "+(ct[i])+" \t\t\t\t"+(wa[i])+" \t\t\t\t "+(tat[i])+ "\n");

    }
}
