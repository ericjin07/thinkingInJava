package com.eric.accesscontrol.classaccess;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 09/08/2018 12:19 PM
 */
public class ConnectManage {
    private static Connect[] connects;
    private static int index;

    static {
        connects = new Connect[10];
        for (int i = 0;i < 10; i++){
            connects[i] = Connect.getInstance(i);
        }
    }

    public static Connect getConnect(){
        if (index < 10) {
            return connects[index++];
        }else return null;
    }

    public static void main(String[] args) {
        for (int i = 0; i<20;i++){
            System.out.println(ConnectManage.getConnect());
        }
    }

}

class Connect{
    private int num;

    private Connect(int i){num = i;}

    static Connect getInstance(int i){
        return new Connect(i);
    }

    @Override
    public String toString() {
        return "Connect{" +
                "num=" + num +
                '}';
    }
}
