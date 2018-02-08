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

public class DataGen {

    //searches for a specified number in inputted matrix
    //pre: matrix is n * n of integers
    //post: returns position of number if found or (-1, -1) if not
    //O(n) runtime
    public static String search(int[][] matrix, int num) {
        //set initial position to bottom corner of matrix
        int rowNum = matrix.length - 1;
        int colNum = 0;

        //as long as the position is in bounds of matrix
        try {
            while (matrix[rowNum][colNum] != num) {
                if (matrix[rowNum][colNum] < num)//move right one column if smaller than num
                    colNum += 1;
                else
                    rowNum -= 1; //move up one row if larger than num
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            return "(-1, -1)"; //num not found
        }
        return "(" + rowNum + ", " + colNum + ")"; //return position if found
    }

    //randomly generates values for an n * n matrix using the rules that if you go right,
    //# increases, & if you go down, # increases
    public static void fill(int[][] matrix) {
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix.length; c++) {
                if (r == 0 && c == 0) //if pos is in the upper left corner, randomly generate from 0-999
                    matrix[r][c] = (int) (1000 * Math.random());
                else if (r == 0) //any other # in first row, add random from 1-1000 to # on the left
                    matrix[r][c] = matrix[r][c - 1] + (int) (1000 * Math.random() + 1);
                else if (c == 0) //any other # in first column, add random from 1-1000 to # on top
                    matrix[r][c] = matrix[r - 1][c] + (int) (1000 * Math.random() + 1);
                else { //else randomly add to # above and left, see which one is larger, & use that value
                    int a = matrix[r - 1][c] + (int) (1000 * Math.random() + 1);
                    int b = matrix[r][c - 1] + (int) (1000 * Math.random() + 1);
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
        for (int k = 17000; k >= 1000; k -= 100) { //array size
            System.out.print(k + ","); //print out array size
            int[][] arr = new int[k][k]; //declare and init
            fill(arr); //fill it
            long total = 0; //total runtime
            for (int i = 0; i < 5000; i++) { //run 100 trials
                a = System.currentTimeMillis(); //measure crrnt time in ms
                search(arr, (int) ((2000 * (i - 1)) * Math.random())); //randomly search for a # based on size of arr
                b = System.currentTimeMillis(); //measure crrnt time in ms
                total += b - a; //find time took and add to total
            }
            System.out.println(total / 1000000.0); //average time for one search
        }
    }
}
