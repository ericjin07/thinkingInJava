package com.eric.exceptions;

import java.util.Arrays;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 12/21/2018 10:21 PM
 */
class DynamicFieldsException extends Exception{}

public class DynamicFields {

    private Object[][] fields;

    /**
     * 初始化二维数组为空
     * @param length
     */
    public DynamicFields(int length) {
        fields = new Object[length][2];
        for (int i = 0; i < length; i++)
            fields[i] = new Object[]{null,null};
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < fields.length; i++)
            sb.append(fields[i][0]).append(" : ").append(fields[i][1]).append('\n');
        return sb.toString();
    }

    private int hasField(String id) {
        for (int i = 0; i < fields.length; i++)
            if (id.equals(fields[i][0]))
                return i;
        return -1;
    }

    private int getFieldNumber(String id) throws NoSuchFieldException {
        int fieldNumber = hasField(id);
        if (fieldNumber == -1)
            throw new NoSuchFieldException();
        return fieldNumber;
    }

    private int makeField(String id) {
        for (int i = 0; i < fields.length; i++)
            if (fields[i][0] == null) {
                fields[i][0] = id;
                return i;
            }
        //no Empty space
        Object [][] tmp = new Object[fields.length + 1][2];
        for (int i = 0; i < fields.length; i++)
            tmp[i] = fields[i];
        tmp[fields.length] = new Object[]{null,null};
        fields = tmp;
        return makeField(id);
    }

    public Object getFiled(String id) throws NoSuchFieldException {
        return fields[getFieldNumber(id)][1];
    }

    public Object setFiled(String id, Object value) throws DynamicFieldsException {
        if (value == null) {
            DynamicFieldsException dfe = new DynamicFieldsException();
            dfe.initCause(new NullPointerException());
            throw dfe;
        }

        int fieldNumber = hasField(id);
        if (fieldNumber == -1) {
            fieldNumber = makeField(id);
        }
        Object result = null;
        try {
            result = getFiled(id);
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
        fields[fieldNumber][1] = value;
        return result;
    }

    public static void main(String[] args) {
        DynamicFields df = new DynamicFields(3);
        System.out.println(df);
        try {
            df.setFiled("d","A value for d");
            df.setFiled("number1",34);
            df.setFiled("number2",47);
            System.out.println(df);
            df.setFiled("d","A new Value for d");
            df.setFiled("number3",123);
            System.out.println(df);
            System.out.println("df.getFiled(\"d\") : " + df.getFiled("d"));
            Object filed = df.setFiled("d",null);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (DynamicFieldsException e) {
            e.printStackTrace();
        }
    }
}
