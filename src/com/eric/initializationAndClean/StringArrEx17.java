package com.eric.initializationAndClean;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 09/05/2018 10:06 PM
 */
public class StringArrEx17 {

    public static void main(String[] args) {
        StringArr[] arrs = new StringArr[3];
        int i = 0;
        for (StringArr arr: arrs){
            arr = new StringArr("fir" + i);
            i++;
        }
        printArr(new Object[]{new Integer(45),new Float(87.6), new Double(98.4)});
        printArr(new Object[]{new StringArr(""),new Float(87.6), new Double(98.4)});
        printArr((Object[]) new Integer[]{1,2,3});
    }

    static void printArr(Object...objs){
        for (Object o: objs)
            System.out.print(o + " ");
        System.out.println();
    }
}

class StringArr{

    String str;

    {
        str = "a filed of Arr";
    }

    public StringArr(String str) {
        this.str = str;
        System.out.println(str);
    }


}
