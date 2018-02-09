/*
  Team May-Tricks
  Alan Wang, Kevin Wang, Kaitlin Wan
  APCS2 Pd. 8
  L #00 -- But What Does the Data Say?
  2018-02-09

  Summary of Algorithm:
  Starting at the lower lefthand corner, you compare the value at the position you are at
  with the desired value. If the desired value is less than the current value, then move
  your position one column to the right. If the desired value is greater than the current
  value, you move your position one row up. Repeat until you reach the desired value and its
  position will be returned. If the desired value is not in matrix (whenever you cannot go up
  or right further), it will "(-1, -1)" will be returned.
*/

public class MFDriver {

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
    public static void fillRand(int[][] matrix) {
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix.length; c++) {
                if (r == 0 && c == 0) //if pos is in the upper left corner, randomly generate from 0-499
                    matrix[r][c] = (int) (500 * Math.random());

                else if (r == 0) //any other # in first row, add random from 1-500 to # on the left
                    matrix[r][c] = matrix[r][c - 1] + (int) (500 * Math.random() + 1);

                else if (c == 0) //any other # in first column, add random from 1-500 to # on top
                    matrix[r][c] = matrix[r - 1][c] + (int) (500 * Math.random() + 1);

                else { //else randomly add to # above and left, see which one is larger, & use that value
                    int a = matrix[r - 1][c] + (int) (500 * Math.random() + 1);
                    int b = matrix[r][c - 1] + (int) (500 * Math.random() + 1);
                    if (a > b)
                        matrix[r][c] = a;
                    else
                        matrix[r][c] = b;
                }
            }
        }
    }

    //generates values for an n * n matrix where each consecutive elmnt in each consecutive
    //row is larger than the one in the previous row and column
    public static void fillOrdered(int[][] matrix) {
        int e = 0;
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix.length; c++) {
                matrix[r][c] = e;
                e++;
            }
        }
    }

    public static void main(String[] args) {
        long a;
        long b;

        //test using the simple array filler (elmnts are consecutive #s) with worse case
        for (int n = 17000; n >= 5000; n -= 100) { //array size
            System.out.println(n + ","); //print array size
            long total = 0; //total runtime for each run
            int[][] arr = new int[n][n]; //declare and init
            fillOrdered(arr); //fill it

            for (int trial = 0; trial < 5000; trial++) { //4900 runs
                if (trial > 99) { //compensates for weird behavior for first few runs
                    a = System.currentTimeMillis();
                    search(arr, n - 1); //searches using worst case
                    b = System.currentTimeMillis();
                    total += b - a; //find time took and add to total
                }
            }
            System.out.println(total / 4900000.0); //average time for one search
        }

        //test using the simple array filler (elmnts are consecutive #s) with random search
        for (int n = 17000; n >= 5000; n -= 100) { //array size
            System.out.println(n + ","); //print array size
            long total = 0; //total runtime for each run
            int[][] arr = new int[n][n]; //declare and init
            fillOrdered(arr); //fill it

            for (int trial = 0; trial < 5000; trial++) { //4900 runs
                if (trial > 99) { //compensates for weird behavior for first few runs
                    a = System.currentTimeMillis();
                    search(arr, (int) (1000 * (n - 1) * Math.random())); //randomly search for a # based on size of arr
                    b = System.currentTimeMillis();
                    total += b - a; //find time took and add to total
                }
            }
            System.out.println(total / 4900000.0); //average time for one search
        }

	//test using the advanced array filler (elmnts are not consecutive #s) with random search
        for (int n = 17000; n >= 5000; k -= 100) { //array size
            System.out.print(n + ","); //print array size
            long total = 0; //total runtime for each run
            int[][] arr = new int[n][n]; //declare and init
            fillRand(arr); //fill it

            for (int trial = 0; trial < 5000; trial++) { //4900 runs
                a = System.currentTimeMillis();
                search(arr, (int) ((1000 * (n - 1)) * Math.random())); //randomly search for a # based on size of arr
                b = System.currentTimeMillis();
                total += b - a; //find time took and add to total
            }
            System.out.println(total / 4900000.0); //average time for one search
        }
    }
}
