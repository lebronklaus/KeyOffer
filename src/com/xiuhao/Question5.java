package com.xiuhao;

/***
 * 替换空格
 */
public class Question5 {
    public static void main(String[] args) {
        String str = "We Are the Arsenal!";
        String replaced = replaceBlank(str);
        System.out.println(replaced);
    }
    public static String replaceBlank(String str){
        int length = str.length();
        int blankCount = 0;
        if(length==0){
            return str;
        }
        for(int i=0;i<length;i++){
            if(str.charAt(i)==' '){
                blankCount++;
            }
        }
        char[] replaced = new char[length+2*blankCount];
        int pointer1 = length-1;
        int pointer2 = (length+2*blankCount)-1;
        for(int i=pointer1;i>=0;i--){
            if(str.charAt(i)!=' '){
                replaced[pointer2--] = str.charAt(i);
            }else{
                replaced[pointer2--] = '0';
                replaced[pointer2--] = '2';
                replaced[pointer2--] = '%';
            }
        }
        return String.valueOf(replaced);
    }
}
