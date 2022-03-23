package ru.vsu.cs.course1;


import java.io.FileInputStream;
import java.io.FileOutputStream;

import static java.lang.System.in;
import static java.lang.System.out;

public class Task {
//    public static void Process(int[][] arr2) {
//        for (int r = 0; r < arr2.length; r++) {
//            for (int c = 0; c < arr2[r].length; c++) {
//                arr2[r][c]++;
//            }
//        }
//    }
//
//    public static int[][] Process2(int[][] arr2) {
//        int[][] res = new int[2][2];
//        for (int r = 0; r < Math.min(arr2.length, 2); r++) {
//            for (int c = 0; c < Math.min(arr2[0].length, 2); c++) {
//                res[r][c] = arr2[r][c];
//            }
//        }
//        return res;
//    }
//
//
//    public static void reverseRows(int[][] arr2) {
//        for (int r = 0; r < arr2.length / 2; r++) {
//            int[] temp = arr2[r];
//            arr2[r] = arr2[arr2.length - r - 1];
//            arr2[arr2.length - r - 1] = temp;
//        }
//    }
//
//    public static void reverseColumns(int[][] arr2) {
//        int colsCount = arr2[0].length;
//        for (int c = 0; c < colsCount / 2; c++) {
//            swapColumns(arr2,  c, colsCount - c - 1);
//        }
//    }
//
//    public static void swapColumns(int[][] arr2, int c1, int c2) {
//        for (int[] row : arr2) {
//            int temp = row[c1];
//            row[c1] = row[c2];
//            row[c2] = temp;
//        }
//    }

 //19.	Элемент двумерного массива назовем седловой точкой, если он является наименьшим в своей строке и одновременно
 // наибольшим в своем столбце или, наоборот, является наибольшим в своей строке и наименьшим в своем столбце.
 // Для переданного двумерного массива составить новый двумерный массив такого же размера из логических значений,
 // где истина будет означать, что соответствующий элемент является седловой точкой в переданном массиве.
    public static int[][] check1(int[][] arr1){
        int width = 0;

        for (int i = 0; i < 1; i++) {
            for (int j = 0; j < arr1[i].length; j++) {
                width = j + 1;
            }
        }

        int[][] ans = new int[arr1.length][width];

        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < width; j++) {
                if ((minInRow(arr1[i][j], i, arr1, width) && maxInCol(arr1[i][j], j, arr1))
                        || (maxInRow(arr1[i][j], i, arr1, width) && minInCol(arr1[i][j], j, arr1))){
                    ans[i][j] = 1;
                }
            }
        }

        return ans;
    }

    public static int[][] check(int[][] arr1){
        int width = 0;

        for (int i = 0; i < 1; i++) {
            for (int j = 0; j < arr1[i].length; j++) {
                width = j + 1;
            }
        }

        int numColWithNull = 0;

        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < width; j++) {
                if (nullInCol(j, arr1)){
                    numColWithNull = j;
                }
            }
        }

        return changeCol(numColWithNull, arr1, width);
    }
    public static boolean nullInCol(int numCol, int[][] arr){
        for (int i = 0; i < arr.length; i++){
            if (arr[i][numCol] == 0) {
                return true;
            }
        }
        return false;
    }
    public static int[][] changeCol(int numCol, int[][] arr, int widht){
        //numCol - в данном случае это номер колонки которую надо поменять метсами с послденей
        int temp = 0;
        for (int i = 0; i < arr.length; i++){
            temp = arr[i][numCol];
            arr[i][numCol] = arr[i][widht - 1];
            arr[i][widht - 1] = temp;
        }
        return arr;
    }






    public static boolean minInRow(int a, int numRow, int[][] arr, int widht){
        int min = arr[numRow][0];
        for (int i = 0; i < widht; i++){
            if (arr[numRow][i] < min) {
                min = arr[numRow][i];
            }
        }
        return a == min;
    }
    public static boolean maxInRow(int a, int numRow, int[][] arr, int widht){
        int max = arr[numRow][0];
        for (int i = 0; i < widht; i++){
            if (arr[numRow][i] > max) {
                max = arr[numRow][i];
            }
        }
        return a == max;
    }
    public static boolean minInCol(int a, int numCol, int[][] arr){
        int min = arr[0][numCol];
        for (int i = 0; i < arr.length; i++){
            if (arr[i][numCol] < min) {
                min = arr[i][numCol];
            }
        }
        return a == min;
    }
    public static boolean maxInCol(int a, int numCol, int[][] arr){
        int max = arr[0][numCol];
        for (int i = 0; i < arr.length; i++){
            if (arr[i][numCol] > max) {
                max = arr[i][numCol];
            }
        }
        return a == max;
    }
}
