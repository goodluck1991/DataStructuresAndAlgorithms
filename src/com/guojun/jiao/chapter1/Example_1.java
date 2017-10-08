package com.guojun.jiao.chapter1;

/**
 * @Autor GuojunJiao
 * @Descrition :
 * @Date 19:40 2017/10/5
 */
public class Example_1 {
    public static void main(String[] args) {
        Example_1 example_1 = new Example_1();
        example_1.permute("aaa");
    }

    public void permute(String str){
        this.permute(str.toCharArray(),0,str.length());
        String tem = new StringBuffer().append(str).reverse().toString();
        this.permute(tem.toCharArray(),0,tem.length());
    }

    private void permute(char [] str, int low, int high){
        if(low == high){
            return ;
        }
        String result = "";
        for (int i=low;i<high;i++){
            result += str[i];
        }
        if(result.length()<str.length){
            int count = str.length-result.length();
            for (int i=0;i<count;i++){
                result+=str[i];
            }
        }
        System.out.println(result);
        permute(str,++low,high);
    }
}
