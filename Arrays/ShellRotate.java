/*

link: https://www.pepcoding.com/resources/online-java-foundation/2d-arrays/shell-rotate-official/ojquestion#

1. You are given a number n, representing the number of rows of a matrix.
2. You are given a number m, representing the number of columns of a matrix.
3. You are given n * m numbers, representing elements of 2d array a.

shell-rotate

4. You are given a shell number s. For details check image.
5. You are given a number r, representing number of anti-clockwise rotations (for +ve numbers) of the shell s.
6. You are required to rotate the sth shell of matrix by r rotations and display the matrix using display function.

*/



import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = scn.nextInt();
            }
        }
        int s = scn.nextInt();
        int r = scn.nextInt();

        shellRotate(arr,s,r);

        display(arr);
    }

    public static void shellRotate(int[][] arr, int s, int r) {
        int[] oned = onedFromShell(arr, s);
        rotate(oned, r);
        shellFromOned(arr, oned, s);
    }

    public static int[] onedFromShell(int[][] arr, int s) {
        int minr = s - 1;
        int minc = s - 1;
        int maxr = arr.length - 1 - (s - 1);
        int maxc = arr[0].length - 1 - (s - 1);

        int size = 2 * ((maxr - minr) + (maxc - minc));
        int[] oned = new int[size];
        int idx = 0;

        for (int i = minr; i <= maxr; i++) {
            oned[idx] = arr[i][minc];
            idx++;
        }
        for (int i = minc + 1; i <= maxc; i++) {
            oned[idx] = arr[maxr][i];
            idx++;
        }
        for (int i = maxr - 1; i >= minr; i--) {
            oned[idx] = arr[i][maxc];
            idx++;
        }
        for (int i = maxc - 1; i >= minc+1; i--) {
            oned[idx] = arr[minr][i];
            idx++;
        }

        return oned;

    }

    public static void rotate(int[] oned, int r) {
        r = r % oned.length;
        if (r < 0) {
            r += oned.length;
        }

        reverse(oned, 0, oned.length - r - 1);
        reverse(oned, oned.length - r, oned.length - 1);
        reverse(oned, 0, oned.length - 1);
    }

    public static void reverse(int[] oned, int left, int right) {
        while (left < right) {
            int temp = oned[left];
            oned[left] = oned[right];
            oned[right] = temp;

            left++;
            right--;
        }
    }

    public static void shellFromOned(int[][] arr, int[] oned, int s) {
        int minr = s - 1;
        int minc = s - 1;
        int maxr = arr.length - 1 - (s - 1);
        int maxc = arr[0].length - 1 - (s - 1);

        int idx = 0;

        for (int i = minr; i <= maxr; i++) {
            arr[i][minc] = oned[idx];
            idx++;
        }
        for (int i = minc + 1; i <= maxc; i++) {
            arr[maxr][i] = oned[idx];
            idx++;
        }
        for (int i = maxr - 1; i >= minr; i--) {
            arr[i][maxc] = oned[idx];
            idx++;
        }
        for (int i = maxc - 1; i >= minc+1; i--) {
            arr[minr][i] = oned[idx];
            idx++;
        }
    }

    public static void display(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

}