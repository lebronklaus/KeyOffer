package com.xiuhao;

/**
 * 数值的整数次方
 */
public class Question16 {
    public static void main(String[] args) {
        System.out.println(Power(10,3));
    }
    public static double Power(double base,int exponent){

        if(exponent<0){
            return 1.0/powerWithUnExpinent(base,-exponent);
        }else{
            return powerWithUnExpinent(base,exponent);
        }

    }

    //用右移运算符代替除以2，用位与运算符代替求余运算
    public static double powerWithUnExpinent(double base,int exponent){
        if(exponent == 0){
            return 1;
        }
        if(exponent ==1 ){
            return base;
        }
        double result = powerWithUnExpinent(base,exponent>>1);
        result *= result;
        if((exponent&0x1)==1){
            result *= base;
        }
        return result;
    }
}
