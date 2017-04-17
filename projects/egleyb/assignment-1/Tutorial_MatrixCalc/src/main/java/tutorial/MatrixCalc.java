//Bryce Egley
//Matrix Multiplier
package tutorial;


import java.util.Scanner;
public class MatrixCalc {
    
    //PreCondition: Asks user for valid input for two matrices to multiply
    //PostCondition: Outputs product matrix
    public static void main(String[] args) {
        // Input for Matrix
        System.out.println("Hello this program will multiply two matrices");
        int proceed = 0;
        int[] s = new int[4];
        s = inputs();
        //Matrix 1
        int[][] m1 = new int[s[0]][s[1]];
        //Matrix 2
        int[][] m2 = new int[s[2]][s[3]];
        int[][] m3 = new int[s[0]][s[3]];
        m1 = matrixInput(m1,s[0],s[1]);
        m2 = matrixInput(m2,s[2],s[3]);
        System.out.println("Matrix 1");
        printMatrix(m1,s[0],s[1]);
        System.out.println("Matrix 2");
        printMatrix(m2,s[2],s[3]);
        System.out.println("Multiplied");
        m3 = multiplyMatrices(m1,s[0],s[1],m2,s[2],s[3]);
        printMatrix(m3,s[0],s[3]);
    }
    
    //PreCondition: None
    //PostCondition: Returns dimensions of two matrices two be multiplied
    //Matrix inputs
    public static int[] inputs() {
        //array for dimensions of two matrices
        int[] input = new int[4];
        Scanner in = new Scanner(System.in);
        for (int i = 0; i < 4; i++) {
            if (i == 0) {
                System.out.println("Enter dimensions for 1st Matrix");
            }
            if (i == 2) {
                System.out.println("Enter dimensions for 2nd Matrix");
            }
            if (i < 2) {
                if (i == 0) {
                    System.out.print("Rows: ");
                } else {
                    System.out.print("Columns: ");
                }
            } else {
                if (i == 2) {
                    System.out.print("Rows: ");
                } else {
                    System.out.print("Columns: ");
                }
            }
            input[i] = in.nextInt();
        }
        return input;
    }
    
    //PreCondition: Recieves an array of ints
    //PostCondition: Prints array of ints
    //Print array
    public static void printArr(int[] var) {
        for (int i = 0; i < var.length; i++) {
            System.out.print(var[i] + " ");
        }
        System.out.println();
    }
    
    //PreCondition: Recieves an empty 2d array with dimensions matching the row and column
    //PostCondition: Returns array with the values the user enters for the matrix
    //Input for Matrix
    public static int[][] matrixInput(int[][] m, int row, int col) {
        System.out.println("Enter whole numbers for the matrix");
        Scanner in = new Scanner(System.in);
        int temp;
        //Row is how many are down, Column is how many are across
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print("Row: " + (i+1) + " Column: " + (j+1) + " = ");
                temp = in.nextInt();
                m[i][j] = temp;
            }
        }
        return m;
    }
    
    //PreCondition: Recieves a 2d array with dimensions matching the row and column
    //PostCondition: Prints contents of matrix
    //Print Matrix
    public static void printMatrix(int[][] m, int row, int col) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(m[i][j] + "\t");
            }
            System.out.println();
        }
    }
    
    //PreCondition: Recieves two matrices with data the user has entered
    //PostCondition: Returns the product matrix
    //Multiply Matrices
    public static int[][] multiplyMatrices(int[][] m1, int row1, int col1,
                                           int[][] m2, int row2, int col2) {
        int[][] m3 = new int[row1][col2];
        int sum = 0;
        //Multiply m1 rows by m2 columns, add sum
        for (int i = 0; i < col2; i++) {
            for (int j = 0; j < row1; j++) {
                for (int k = 0; k < row2; k++) {
                    sum += m1[j][k] * m2[k][i];
                }
                m3[j][i] = sum;
                sum = 0;
            }
        }
        return m3;
    }
}
