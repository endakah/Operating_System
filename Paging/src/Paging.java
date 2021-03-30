/**
 * Paging is a storage mechanism that allows OS to retrieve processes
 * from the secondary storage into the main memory in the form of pages.
 */

import java.util.Scanner;

public class Paging {
    public static void main(String[] args) {
        int ms,//memory size
            ps, //page size
            nop,// average page size
            np,//number of pages
            rem,// average page sie for a process
            i,//loop
            j,//loop
            x,//process number
            y,//page number
            pa,//physical address
            offset;//offset

        int[] s = new int[10];//pages required
        int[][] fno = new int[10][20];
        //instance of scanner
        Scanner input = new Scanner(System.in);
        System.out.println("\nEnter the memory size -- ");
       //assign memory size
        ms = input.nextInt();
        System.out.println("\nEnter the page size -- ");
       // assign page size
        ps = input.nextInt();
        //formula for number of pages
        nop = ms / ps;
        System.out.println("\nThe no. of pages available in memory are -- " + nop);
        System.out.println("\nEnter number of processes -- ");

        np = input.nextInt();
        //assign number of pages to rempages
        rem = nop;
        for (i = 1; i <= np; i++) {
            System.out.println("\nEnter no. of pages required for  " + i);
            //inputing pages required
            s[i] = input.nextInt();
            //check if the new page is greater than the average page size
            if (s[i] > rem) {
                System.out.println("\nMemory is Full");
                break;
            }
            //resetting rempages
            rem = rem - s[i];
            System.out.println("\nEnter pagetable for --- " + i);
            for (j = 0; j < s[i]; j++)
                //enter pageTable and accept
                fno[i][j] = input.nextInt();
        }
        System.out.println("\nEnter Logical Address to find Physical Address ");
        System.out.println("\nEnter process no. and pagenumber and offset -- ");

        x = input.nextInt();
        y = input.nextInt();
        offset = input.nextInt();
        if (x > np || y >= s[i] || offset >= ps)
            System.out.println("\nInvalid Process or Page Number or offset");
        else {
            //formula for the physical address
            pa = fno[x][y] * ps + offset;
            System.out.println("\nThe Physical Address is -- " + pa);
        }

    }
}
