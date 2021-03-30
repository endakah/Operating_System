import java.util.Scanner;

public class worstFit {

    /**
     * Worst Fit allocates a process to the partition which is largest sufficient
     * among the freely available partitions available in the main memory.
     */

    public static void main(String[] args){
        int max=25;//value to be assigned to the loops

        int i,//Counter for a loop
            j,//Counter for a loop
            nb,//Number of blocks
            nf,//Number of files
            temp =0;//Value to be assigned to Fragmentation

        int[] frag = new int[max];//Fragment
        int[] block = new int[max];//blocks size
        int[] file = new int[max];//File

        int[] bf = new int[max];
        int[] ff = new int[max];

        Scanner input = new Scanner(System.in);//Creating  Scanner instance

        //Display the following outputs below
        System.out.println("\n\tMemory Management Scheme - Worst Fit");
        System.out.println("\nEnter the number of blocks:");
        //Accepting input to the number of blocks
        nb=input.nextInt();
        System.out.println("Enter the number of files:");
        //Accepting input to number of files
        nf=input.nextInt();
        System.out.println("\nEnter the size of the blocks:-\n");
        for(i=1;i<=nb;i++)
        {
            System.out.println("Block "+i);
            //inputting to size of block.
            block[i]=input.nextInt();
        }
        System.out.println("Enter the size of the files :-\n");
        for(i=1;i<=nf;i++)
        {
            System.out.println("File "+i);
            //Accept size of file
            file[i]=input.nextInt();
        }
        for(i=1;i<=nf;i++)
        {
            for(j=1;j<=nb;j++)
            {       //use to check if the index of that array or block of that index have been processed already.
                if(bf[j]!=1)
                {   //checks if there is any fragment and assign it to temp
                    temp=block[j]-file[i];
                    //checks if the temp temp is empty
                    if(temp>=0)
                    {   // Assign the block number to  ff
                        ff[i]=j;
                        break;
                    }
                }
            }
            //temp is assigned to frag
            frag[i]=temp;
            bf[ff[i]]=1;
        }
        System.out.println("\nFile_no:\tFile_size :\tBlock_no:\tBlock_size:\tFragment");
        for(i=1;i<=nf;i++)
            System.out.println("\n  "+i+"\t\t\t\t"+file[i]+"\t\t\t"+ff[i]+"\t\t\t"+block[ff[i]]+"\t\t\t"+frag[i]);



    }
}
