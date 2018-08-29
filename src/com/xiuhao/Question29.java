package com.xiuhao;

import java.util.ArrayList;

/**
 * 顺时针打印矩阵
 */
public class Question29 {

    public static void main(String[] args) {

        int[][] array = {{1},{2},{3},{4},{5}};
        ArrayList<Integer> list = clockWisePrint(array);
        for(int i=0;i<list.size();i++){
            System.out.print(list.get(i)+" ");
        }

    }

    public static ArrayList<Integer> clockWisePrint(int[][] matrix){
        ArrayList<Integer> list = new ArrayList<>();
        int rows = matrix.length;
        int cols = matrix[0].length;
        if(matrix == null){
            return list;
        }
        int x = 0;
        int y = 0;
        while(x*2<rows&&y*2<cols){
            printMatrixInCircle(list,matrix,x,y,rows,cols);
            x++;
            y++;
        }
        return list;
    }
    public static void printMatrixInCircle(ArrayList<Integer> list,int[][] numbers,int x,int y,int rows,int cols){
        for(int i=y;i<cols-y-1;i++){
            list.add(numbers[x][i]);
        }
        if(rows-x-1>x){
            for(int i=x+1;i<=rows-x-1;i++){
                list.add(numbers[i][cols-y-1]);
            }
        }
        if(rows-x-1>x&&cols-1-y>y){
            for(int i=cols-y-2;i>=y;i--){
                list.add(numbers[rows-1-x][i]);
            }
        }
        if(cols-1-y>y&&rows-1-x>x+1){
            for(int i=rows-1-x-1;i>=x+1;i--){
                list.add(numbers[i][y]);
            }
        }
    }

    //剑指offer
    public static ArrayList<Integer> printMatrix(int[][] matrix){
        ArrayList<Integer> list = new ArrayList<>();
        int rows = matrix.length;
        int cols = matrix[0].length;
        if(matrix==null||cols<=0||rows<=0) {
            return null;
        }
        int start = 0;
        while(cols>start*2&&rows>start*2){
            printMatrixInCircle(list,matrix,cols,rows,start);
            start++;
        }
        return list;
    }

    public static void printMatrixInCircle(ArrayList<Integer> list,int[][] nums,int cols,int rows,int start){
        int endX = cols - 1 - start;
        int endY = rows - 1 - start;

        //从左往右打印一行
        for(int i=start;i<=endX;i++){
            int number = nums[start][i];
            list.add(number);
        }
        //从上往下打印一列
        if(start<endY){
            for(int i = start+1;i<=endY;i++){
                int number = nums[i][endX];
                list.add(number);
            }
        }
        //从右到左打印
        if(start<endX&&start<endY){
            for(int i=endX-1;i>=start;i--){
                int number = nums[endY][i];
                list.add(number);
            }
        }
        //从下到上打印
        if(start<endY&&start<endY-1){
            for(int i=endY-1;i>=start+1;i--){
                int number = nums[i][start];
                list.add(number);
            }
        }
    }

}
