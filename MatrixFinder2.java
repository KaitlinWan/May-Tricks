/*
Team May-Tricks
Alan Wang, Kevin Wang, Kaitlin Wan
APCS2 Pd. 8
HW #03 -- I AM STILL SEARCHING
2018-02-01

Summary of Algorithm:
Starting at the lower lefthand corner, you compare the value at the position you are at
with the desired value. If the desired value is less than the current value, then move
your position one column to the right. If the desired value is greater than the current
value, you move your position one row up. Repeat until you reach the desired value and its
position will be returned. If the desired value is not in matrix (whenever you cannot go up
or right further), it will "(-1, -1)" will be returned.
*/

public class MatrixFinder2 {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";

    //searches for a specified number in inputted matrix
    //pre: matrix is n * n of integers
    //post: returns position of number if found or (-1, -1) if not
    //O(n) runtime
    public static String search(int[][] matrix, int num) {
        //set initial position to bottom corner of matrix
        int rowNum = matrix.length - 1;
        int colNum = 0;
        String ary;

        //as long as the position is in bounds of matrix
        try {
            while (matrix[rowNum][colNum] != num) {
                //trace with color
                /*ary = "";
                for (int r = 0; r < matrix.length; r++) {
                    ary += "|";
                    for (int c = 0; c < matrix.length; c++) {
                        if (r == rowNum && c == colNum)
                            ary += ANSI_GREEN + matrix[r][c] + ANSI_RESET + "\t";
                        else
                            ary += matrix[r][c] + "\t";
                    }
                    ary += "|\n";
                }
                System.out.println(ary);*/

                if (matrix[rowNum][colNum] < num) { //move right one column if smaller than num
                    colNum += 1;
                } else {
                    rowNum -= 1; //move up one row is larger than num
                }
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            return "(-1, -1)"; //num not found
        }
        return "(" + rowNum + ", " + colNum + ")"; //return position if found
    }

    //formats a matrix by printing out its values
    public static String print(int[][] matrix) {
        String out = "";
        for (int[] r : matrix) {
            out += "|"; //first pipe in row
            for (int e : r)
                out += e + "\t"; //spacing btwn elmnts
            out += "|\n"; //second pipe in row
        }
        return out;
    }

    public static void fill(int[][] matrix) {
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix.length; c++) {
                if (r == 0 && c == 0)
                    matrix[r][c] = (int) (5 * Math.random());
                else if (r == 0)
                    matrix[r][c] = matrix[r][c - 1] + (int) (5 * Math.random() + 1);
                else if (c == 0)
                    matrix[r][c] = matrix[r - 1][c] + (int) (5 * Math.random() + 1);
                else {
                    int a = matrix[r - 1][c] + (int) (5 * Math.random() + 1);
                    int b = matrix[r][c - 1] + (int) (5 * Math.random() + 1);
                    if (a > b)
                        matrix[r][c] = a;
                    else
                        matrix[r][c] = b;
                }
            }
        }
    }

    public static void main(String[] args) {
        long a;
        long b;
        /*
        int[][] test = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        System.out.println("3 by 3");
        
        a = System.nanoTime();
        search(test, 1);
        b = System.nanoTime();
        System.out.println((b - a) / 1000000000.0);
        
        a = System.nanoTime();
        search(test, 2);
        b = System.nanoTime();
        System.out.println((b - a) / 1000000000.0);
        
        a = System.nanoTime();
        search(test, 3);
        b = System.nanoTime();
        System.out.println((b - a) / 1000000000.0);
        
        a = System.nanoTime();
        search(test, 4);
        b = System.nanoTime();
        System.out.println((b - a) / 1000000000.0);
        
        a = System.nanoTime();
        search(test, 5);
        b = System.nanoTime();
        System.out.println((b - a) / 1000000000.0);
        
        a = System.nanoTime();
        search(test, 6);
        b = System.nanoTime();
        System.out.println((b - a) / 1000000000.0);
        
        a = System.nanoTime();
        search(test, 7);
        b = System.nanoTime();
        System.out.println((b - a) / 1000000000.0);
        
        a = System.nanoTime();
        search(test, 8);
        b = System.nanoTime();
        System.out.println((b - a) / 1000000000.0);
        
        a = System.nanoTime();
        search(test, 9);
        b = System.nanoTime();
        System.out.println((b - a) / 1000000000.0);
        
        a = System.nanoTime();
        search(test, 0);
        b = System.nanoTime();
        System.out.println((b - a) / 1000000000.0);
        
        a = System.nanoTime();
        search(test, 10);
        b = System.nanoTime();
        System.out.println((b - a) / 1000000000.0);
        
        System.out.println();
        
        int[][] test2 = { { 1, 2, 3 }, { 2, 3, 4 }, { 3, 4, 5 } };
        System.out.println("3 by 3");
        
        a = System.nanoTime();
        search(test2, 1);
        b = System.nanoTime();
        System.out.println((b - a) / 1000000000.0);
        
        a = System.nanoTime();
        search(test2, 2);
        b = System.nanoTime();
        System.out.println((b - a) / 1000000000.0);
        
        a = System.nanoTime();
        search(test2, 3);
        b = System.nanoTime();
        System.out.println((b - a) / 1000000000.0);
        
        a = System.nanoTime();
        search(test2, 4);
        b = System.nanoTime();
        System.out.println((b - a) / 1000000000.0);
        
        a = System.nanoTime();
        search(test2, 5);
        b = System.nanoTime();
        System.out.println((b - a) / 1000000000.0);
        
        a = System.nanoTime();
        search(test2, 0);
        b = System.nanoTime();
        System.out.println((b - a) / 1000000000.0);
        
        a = System.nanoTime();
        search(test2, 6);
        b = System.nanoTime();
        System.out.println((b - a) / 1000000000.0);
        
        System.out.println();
        
        int[][] test3 = new int[0][0];
        System.out.println("0 by 0");
        
        a = System.nanoTime();
        search(test3, 0);
        b = System.nanoTime();
        System.out.println((b - a) / 1000000000.0);
        
        System.out.println();
        
        int[][] test4 = { { 34 } };
        System.out.println("1 by 1");
        
        a = System.nanoTime();
        search(test4, 15);
        b = System.nanoTime();
        System.out.println((b - a) / 1000000000.0);
        
        a = System.nanoTime();
        search(test4, 34);
        b = System.nanoTime();
        System.out.println((b - a) / 1000000000.0);
        
        a = System.nanoTime();
        search(test4, 252);
        b = System.nanoTime();
        System.out.println((b - a) / 1000000000.0);
        
        System.out.println();
        
        int[][] test5 = { { 1, 9 }, { 4, 16 } };
        System.out.println("2 by 2");
        
        a = System.nanoTime();
        search(test5, 1);
        b = System.nanoTime();
        System.out.println((b - a) / 1000000000.0);
        
        a = System.nanoTime();
        search(test5, 9);
        b = System.nanoTime();
        System.out.println((b - a) / 1000000000.0);
        
        a = System.nanoTime();
        search(test5, 4);
        b = System.nanoTime();
        System.out.println((b - a) / 1000000000.0);
        
        a = System.nanoTime();
        search(test5, 16);
        b = System.nanoTime();
        System.out.println((b - a) / 1000000000.0);
        
        a = System.nanoTime();
        search(test5, -5);
        b = System.nanoTime();
        System.out.println((b - a) / 1000000000.0);
        
        a = System.nanoTime();
        search(test5, 7);
        b = System.nanoTime();
        System.out.println((b - a) / 1000000000.0);
        
        a = System.nanoTime();
        search(test5, 20);
        b = System.nanoTime();
        System.out.println((b - a) / 1000000000.0);
        
        System.out.println();
        
        int[][] test6 = { { 1, 2, 3, 5 }, { 8, 13, 21, 34 }, { 55, 89, 144, 233 }, { 377, 610, 987, 1597 } };
        System.out.println("4 by 4");
        
        a = System.nanoTime();
        search(test6, 1);
        b = System.nanoTime();
        System.out.println((b - a) / 1000000000.0);
        
        a = System.nanoTime();
        search(test6, 2);
        b = System.nanoTime();
        System.out.println((b - a) / 1000000000.0);
        
        a = System.nanoTime();
        search(test6, 3);
        b = System.nanoTime();
        System.out.println((b - a) / 1000000000.0);
        
        a = System.nanoTime();
        search(test6, 4);
        b = System.nanoTime();
        System.out.println((b - a) / 1000000000.0);
        
        a = System.nanoTime();
        search(test6, 5);
        b = System.nanoTime();
        System.out.println((b - a) / 1000000000.0);
        
        a = System.nanoTime();
        search(test6, 144);
        b = System.nanoTime();
        System.out.println((b - a) / 1000000000.0);
        
        a = System.nanoTime();
        search(test6, 999);
        b = System.nanoTime();
        System.out.println((b - a) / 1000000000.0);
        
        a = System.nanoTime();
        search(test6, -21);
        b = System.nanoTime();
        System.out.println((b - a) / 1000000000.0);
        
        a = System.nanoTime();
        search(test6, 0);
        b = System.nanoTime();
        System.out.println((b - a) / 1000000000.0);
        
        a = System.nanoTime();
        search(test6, 89);
        b = System.nanoTime();
        System.out.println((b - a) / 1000000000.0);
        
        System.out.println();
        */
        for (int i = 1000; i < 2000; i += 5) {
            int[][] at = new int[i][i];
            fill(at);
            a = System.nanoTime();
            search(at, (int) (1024 * Math.random()));
            b = System.nanoTime();
            System.out.println((b - a) / 1000000000.0);
        }
    }
}
