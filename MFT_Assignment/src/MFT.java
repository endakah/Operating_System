import java.util.Scanner;

public class MFT {
    public static void main(String[] args){
        /**
         * MFT (Multiprogramming with a Fixed number of Tasks) Is a memory  techniques in which the memory
         * is partitioned into fixed size partitions and each job is assigned to a partition.
         *
         */

        //MFT variables
        int availableMemorySize =0,
                blockSize=0,
                noBlocks,
                externalFragmentation
                ,noOfProcess=0,
                totInternalFragmentation=0;



        int[] processSize =new int[10];
        int i,processInMem=0;


        //Scanner input
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the total memory available (in Bytes) -- ");

        //Accept the available memory size
        availableMemorySize=input.nextInt();

        System.out.println("Enter the block size (in Bytes) -- ");
        //Accept the block size
        blockSize=input.nextInt();

        //Acception input for number of blocks
        noBlocks=availableMemorySize/blockSize;

        //formula for externalFragmentation
        externalFragmentation=availableMemorySize - noBlocks*blockSize;


        System.out.println("\nEnter the number of processes -- ");
        //Number of processes
        noOfProcess=input.nextInt();

        //loop to process the process sizes
          for(i=0;i<noOfProcess;i++)
        {
            System.out.println("Enter memory required for process (in Bytes)-- "+(i+1));
            //scanf("%d",&mp[i]);
            processSize[i]=input.nextInt();
        }



        //display the output below
        System.out.println("\nNo. of Blocks available in memory -- "+noBlocks+"");
        System.out.println("\n\nPROCESS\tMEMORY REQUIRED\t ALLOCATED\tINTERNAL FRAGMENTATION");


        //loop to produce the output
        for(i=0;i<noOfProcess && processInMem<noBlocks;i++)
        {
            //Display the following below
            System.out.print("\n\t" +(i+1)+"\t\t\t"+processSize[i]+"");
            if(processSize[i] > blockSize)
                System.out.print("\t\t\tNO\t\t\t\t---");
            else
            {
                System.out.print("\t\t\tYES\t\t\t\t"+(blockSize-processSize[i])+"");
                totInternalFragmentation = totInternalFragmentation + blockSize-processSize[i];
                processInMem++;
            }
        }
        if(i<noOfProcess)
            //Display the following after all the calculation is done.
            System.out.println("\nMemory is Full, Remaining Processes cannot be accomodated");
        System.out.println("\n\nTotal Internal Fragmentation is "+totInternalFragmentation+"");
        System.out.println("\nTotal External Fragmentation is "+externalFragmentation+"");

    }
}
