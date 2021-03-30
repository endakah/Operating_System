/**
 * This method keeps the free/busy list in order by size – smallest to largest. In this method,
 * the operating system first searches the whole of the memory according to the size of the given job and allocates it to the closest-fitting
 * free partition in the memory, making it able to use memory efficiently. Here the jobs are in the order from smalest job to largest job.
 */

import java.util.Scanner;

public class BestFit {
public static void main(String[] args){

    int max=25;
    int i, // loop
        j,//loop
        nb,//number of blocks
        nf,//number of files
        temp,
        lowest=10000;

    int[] frag = new int[max]; //fragment
    int[] block = new int[max]; //block sizes
    int[] file = new int[max];//file sizes

    int[] bf = new int[max]; //check file
    int[] ff = new int[max];//check block

    //instance of the Scanner class
    Scanner input = new Scanner(System.in);
    //Displays the following
    System.out.println("\nEnter the number of blocks:");
    //Accept input to number of blocks
    nb=input.nextInt();
    System.out.println("Enter the number of files:");
    //Accept input to number of files
    nf=input.nextInt();
    System.out.println("\nEnter the size of the blocks:-\n");
    //loops based on number of blocks
    for(i=1;i<=nb;i++) {
        System.out.println("Block " + i);
        //accept input to block size
        block[i] = input.nextInt();
    }
    System.out.println("Enter the size of the files :-\n");
    for(i=1;i<=nf;i++)
    {
        System.out.println("File "+i);
        //accept input to file size
        file[i]=input.nextInt();
    }
    for(i=1;i<=nf;i++)
    {
        for(j=1;j<=nb;j++)
        {   //checks if that index for block has been processed
            if(bf[j]!=1)
            {   //assign fragment to temp
                temp=block[j]-file[i];
                //checks if the temp is empty or not
                if(temp>=0)

                    if(lowest>temp)
                    {   //assign block index to ff
                        ff[i]=j;
                        lowest=temp;
                    }
            }
        }

        frag[i]=lowest;
        //assign 1 to show that block index has been processed
        bf[ff[i]]=1;
        lowest=10000;
    }
    //Displays the output
    System.out.println("\nFile No\tFile Size \tBlock No\tBlock Size\tFragment");
    for(i=1;i<=nf && ff[i]!=0;i++)
        System.out.println("\n  "+i+"\t\t\t"+file[i]+"\t\t\t"+ff[i]+"\t\t\t"+block[ff[i]]+"\t\t\t"+frag[i]);

}
}
