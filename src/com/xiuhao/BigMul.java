package com.xiuhao;

/**
 * Created by Lenovo on 2018/8/27.
 */


    import java.util.Scanner;


    public class BigMul {

        public static String multiply(String num1, String num2){

            char chars1[] = num1.toCharArray();
            char chars2[] = num2.toCharArray();

            int result[] = new int[chars1.length + chars2.length];
            int n1[] = new int[chars1.length];
            int n2[] = new int[chars2.length];

            for(int i = 0; i < chars1.length;i++)
                n1[i] = chars1[i]-'0';
            for(int i = 0; i < chars2.length;i++)
                n2[i] = chars2[i]-'0';

            for(int i =0 ; i < chars1.length; i++){
                for(int j =0; j < chars2.length; j++){
                    result[i+j]+=n1[i]*n2[j];
                }
            }

            for(int i =result.length-1; i > 0 ;i--){
                result[i-1] += result[i] / 10;
                result[i] = result[i] % 10;
            }

            String resultStr = "";
            for(int i = 0; i < result.length-1; i++){
                resultStr+=""+result[i];
            }
            return resultStr;
        }

        public static int absNum(int x){
            if(x>0)
                return x;
            else
                return -x;
        }

        public static void main(String[] args) {
            int n;

            Scanner scanner = new Scanner(System.in);
            n = scanner.nextInt();
            int max =0;
            for(int i=0;i<n;i++){
                int x = scanner.nextInt();
                if(absNum(x)>max){
                    max = x;
                }
                int y = scanner.nextInt();
                if(absNum(y)>max){
                    max = y;
                }
            }
            System.out.println(multiply(String.valueOf(max),String.valueOf(max)));
        }
    }

