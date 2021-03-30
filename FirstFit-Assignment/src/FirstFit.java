/**
 * This method keeps the free/busy list of jobs organized by memory location, low-ordered to high-ordered memory.
 * In this method, first job claims the first available memory with space more than or equal to it’s size. The operating system
 * doesn’t search for appropriate partition but just
 * allocate the job to the nearest memory partition available with sufficient size.
 */

import java.util.Scanner;

public class FirstFit {

    public static void main(String[] args) {
        int max = 25;
        int i,//loop
                j,//loop
                nb,//number of blocks
                nf,//number of files
                temp, highest = 0;
        int[] frag = new int[max];//fragment
        int[] b = new int[max];//block sizes
        int[] f = new int[max];//file sizes


        int[] bf = new int[max];//check file
        int[] ff = new int[max];//check file

        Scanner input = new Scanner(System.in);

        //Displays the following
        System.out.println("\n\tMemory Management Scheme - First Fit");
        System.out.println("\nEnter the number of blocks:");
        //accept input to number blocks
        nb = input.nextInt();
        System.out.println("Enter the number of files:");
        //accept input to number files
        nf = input.nextInt();
        System.out.println("\nEnter the size of the blocks:-\n");
        for (i = 1; i <= nb; i++) {
            System.out.println("Block :" + i);
            //accept input to block size
            b[i] = input.nextInt();
        }
        System.out.println("Enter the size of the files :-\n");
        for (i = 1; i <= nf; i++) {
            System.out.println("File :" + i);
            //accept input to file size
            f[i] = input.nextInt();
        }
        for (i = 1; i <= nf; i++) {
            for (j = 1; j <= nb; j++) {
                if (bf[j] != 1) //check if block index has been processed already
                {
                    temp = b[j] - f[i];//check for fragment
                    if (temp >= 0)
                        if (highest < temp) {
                            ff[i] = j;//assign block index to ff
                            highest = temp;
                        }
                }
            }
            frag[i] = highest;
            //assign 1 to show that block index has been processed
            bf[ff[i]] = 1;
            highest = 0;
        }
        //Displays the output
        System.out.println("\nFile_no:\tFile_size :\tBlock_no:\tBlock_size:\tFragement");
        for (i = 1; i <= nf; i++) {
            System.out.println("\n  " + i + "\t\t\t\t" + f[i] + "\t\t\t" + ff[i] + "\t\t\t" + b[ff[i]] + "\t\t\t" + frag[i]);

        }

    }
}
