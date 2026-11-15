public class Assignment01Q03 {
    public static void main(String[] args) {
        int x = Integer.parseInt(args[0]); // Read first string argument
        System.out.println("The first " + x + " Fibonacci numbers are:");

        ///////////////////////////////////////////////////////////
        // Replace this code with the correct Fibonacci sequence
        ////////////////////////////////////////////////////////////////
        /// ...

        int numOdd = 0;
        int prev = -1, prevprev = -1;
        for (int i = 0; i < x; i++) {
            if (prevprev == -1) {
                prevprev = 1;
                System.out.print(prevprev);
                numOdd++;
            } else if (prev == -1) {
                prev = 1;
                System.out.print(prev);
                numOdd++;
            } else {
                System.out.print(prev + prevprev);
                int tmp = prev;
                prev = prev + prevprev;
                prevprev = tmp;
                if (prev % 2 != 0)
                    numOdd++;
            }
            if (i < x - 1)
                System.out.print(" "); // Make sure we don't print a trailing space
        }
        System.out.println();

        ///////////////////////////////////////////////////////////

        System.out.println("The number of odd numbers is: " + numOdd);
    }
}
