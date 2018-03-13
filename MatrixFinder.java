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

public class MatrixFinder {
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
                    rowNum -= 1; //move up one row if larger than num
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

    public static void main(String[] args) {
        int[][] test = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        System.out.println("THIS IS TEST 1\n============================");
        System.out.println(print(test));
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("1: " + search(test, 1));
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("2: " + search(test, 2));
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("3: " + search(test, 3));
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("4: " + search(test, 4));
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("5: " + search(test, 5));
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("6: " + search(test, 6));
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("7: " + search(test, 7));
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("8: " + search(test, 8));
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("9: " + search(test, 9));
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("0: " + search(test, 0));
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("10: " + search(test, 10));
        System.out.println("================================");
        System.out.println();

        int[][] test2 = { { 1, 2, 3 }, { 2, 3, 4 }, { 3, 4, 5 } };
        System.out.println("THIS IS TEST 2\n============================");
        System.out.println(print(test2));
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("1: " + search(test2, 1));
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("2: " + search(test2, 2));
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("3: " + search(test2, 3));
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("4: " + search(test2, 4));
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("5: " + search(test2, 5));
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("0: " + search(test2, 0));
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("6: " + search(test2, 6));
        System.out.println("================================");
        System.out.println();

        int[][] test3 = new int[0][0];
        System.out.println("THIS IS TEST 3\n============================");
        System.out.println(print(test3));
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("0: " + search(test3, 0));
        System.out.println("================================");
        System.out.println();

        int[][] test4 = { { 34 } };
        System.out.println("THIS IS TEST 4\n============================");
        System.out.println(print(test4));
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("12: " + search(test4, 15));
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("34: " + search(test4, 34));
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("252: " + search(test4, 252));
        System.out.println("================================");
        System.out.println();

        int[][] test5 = { { 1, 9 }, { 4, 16 } };
        System.out.println("THIS IS TEST 5\n============================");
        System.out.println(print(test5));
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("1: " + search(test5, 1));
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("9: " + search(test5, 9));
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("4: " + search(test5, 4));
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("16: " + search(test5, 16));
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("-5: " + search(test5, -5));
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("7: " + search(test5, 7));
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("20: " + search(test5, 20));
        System.out.println("================================");
        System.out.println();

        int[][] test6 = { { 1, 2, 3, 5 }, { 8, 13, 21, 34 }, { 55, 89, 144, 233 }, { 377, 610, 987, 1597 } };
        System.out.println("THIS IS TEST 6\n====================================");
        System.out.println(print(test6));
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("1: " + search(test6, 1));
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("2: " + search(test6, 2));
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("3: " + search(test6, 3));
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("4: " + search(test6, 4));
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("5: " + search(test6, 5));
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("144: " + search(test6, 144));
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("999: " + search(test6, 999));
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("-21: " + search(test6, -21));
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("0: " + search(test6, 0));
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("89: " + search(test6, 89));
        System.out.println("===================================");
        System.out.println();
    }
}