import java.util.Scanner;

/**
 * MVT (Multiprogramming with a Variable number of Tasks) is the memory management technique
 * in which each job gets just the amount of memory it needs.
 */
public class MVT {
    public static void main(String[] args) {

        //MVT variables
        int memoryAvailableV,
                iV,//loop
                exFrag,//externalfagmentation
                nV = 0;//loop

        int[] availableMemory = new int[10];//This array holds the available Memory


        char ch = 'y';//character to regulate yes or no to continue the loop
        Scanner input = new Scanner(System.in);// Scanner input

        //display the output below
        System.out.println("\nEnter the total memory available (in Bytes)-- ");

        //input for Available Memory
        memoryAvailableV = input.nextInt();

        //Available Memory assign to External Fragmentation
        exFrag = memoryAvailableV;

        //Loop to Accept Process input
        for (iV = 0; ch == 'y'; iV++, nV++) {
            //display the output below
            System.out.println("\nEnter memory required for process " + (iV + 1) + " (in Bytes) -- ");
            //accepting input for availableMemory
            availableMemory[iV] = input.nextInt();

            if (availableMemory[iV] <= exFrag) {
                //display the output below
                System.out.println("\nMemory is allocated for Process " + (iV + 1) + " ");

                //calculating the external fragmentation
                exFrag = exFrag - availableMemory[iV];
            } else {
                //display the output below
                System.out.println("\nMemory is Full");
                break;
            }
            //display the output below to continue the process.
            System.out.println("\nDo you want to continue(y/n) -- ");
            //Input to continue MVP
            ch = input.next().charAt(0);

        }
        //display the output below
        System.out.println("\n\nTotal Memory Available --" + memoryAvailableV + " ");
        System.out.println("\n\n\tPROCESS\t\t MEMORY ALLOCATED ");
        //loop to display the output of the result
        for (iV = 0; iV < nV; iV++)
            System.out.println("\n \t" + (iV + 1) + "\t\t\t\t" + availableMemory[iV] + "");
        System.out.println("\n\nTotal Memory Allocated is " + (memoryAvailableV - exFrag) + "");
        System.out.println("\nTotal External Fragmentation is " + exFrag + "");

    }
}
