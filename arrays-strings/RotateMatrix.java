/*
*       Given an image represented by an NXN matrix, where each pixel in the image is 4 bytes,
*       write a method to rotate the image by 90 degrees. Can you do this in place?
*
*       [[1,2,3],[4,5,6],[7,8,9]]    ---------->     [[7,4,1],[8,5,2],[9,6,3]]
*
*       1 2 3       7 4 1
*       4 5 6       8 5 2
*       7 8 9       9 6 3
 * */

import java.util.Scanner;

public class RotateMatrix {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();    // nXn is the matrix size
        System.out.println("The size of matrix is : " + n);

        int[][] image = new int[n][n];
//  taking the elements of array as input
        for(int i = 0; i < image.length; i++){
            for(int j = 0; j < image[i].length; j++){
                image[i][j] = s.nextInt();
            }
        }
        s.close();

        printMatrix(image);

        rotateMatrix(image);

        printMatrix(image);     // print the array
    }

//      TIME COMPLEXITY  ----> O(N*N)
//      SPACE COMPLEXITY ----> O(1)

//  program to rotate nXn matrix
    public static void rotateMatrix(int [][] image){
        //  1. transpose the matrix image
        transposeMatrix(image);

        //  2. reverse each row of matrix
        rotateRow(image);
    }

//  taking the rranspose of matrix
    public static void transposeMatrix(int[][] matrix){
        for(int i = 0; i < matrix.length; i++){
            for(int j = i+1; j < matrix[i].length; j++){
                //swap  (matrix[i][j], matrix[j][i])
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

// rotating each row of matrix
    public static void rotateRow(int[][] a){
        for(int i = 0; i < a.length; i++){
            int start = 0;
            int end = a[i].length - 1;
            while(start < end){
                int temp = a[i][start];
                a[i][start++] = a[i][end];
                a[i][end--] = temp;
            }
        }
    }

    public static void printMatrix(int[][] a){
        for(int i = 0; i < a.length; i++){
            for(int j = 0; j < a[i].length; j++){
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }

}