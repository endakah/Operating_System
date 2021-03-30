import java.util.Scanner;

public class FCFS {
    public static void main(String[] args){
        int  n, i, j, tot=0;
        float avhm =0;
        int[] t = new int[20];
        int[] tohm = new int[20];
        Scanner input = new Scanner(System.in);

        System.out.println("enter the no.of tracks");

        n=input.nextInt();

        System.out.println("enter the tracks to be traversed");
        for(i=2;i<n+2;i++)

        t[i]=input.nextInt();
        for(i=1;i<n+1;i++)
        {
            tohm[i]=t[i+1]-t[i];
            if(tohm[i]<0)
                tohm[i]=tohm[i]*(-1);
        }
        for(i=1;i<n+1;i++)
            tot+=tohm[i];
        avhm=(float)tot/n;
        System.out.println("Tracks traversed\tDifference between tracks\n");
        for(i=1;i<n+1;i++)
            System.out.println((t[i])+"\t\t\t"+(tohm[i])+"\n");
        System.out.println("\nAverage header movements"+avhm);

    }
}
