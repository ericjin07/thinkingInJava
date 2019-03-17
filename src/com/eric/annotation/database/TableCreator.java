package com.eric.annotation.database;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 03/15/2019 3:37 PM
 */
public class TableCreator {

    public static void main(String[] args) throws Exception {
        if (args.length < 1)
            System.out.println("arguments: annotated classes");
        for (String clzName : args){
            Class<?> clz = Class.forName(clzName);
            DBTable table = clz.getAnnotation(DBTable.class);
            if (table == null) {
                System.out.println("No DBTable annotation in class " + clzName);
                continue;
            }
            String tableName = table.name();
            if (tableName.length() < 1) {
                tableName = clz.getName().toUpperCase();
            }
            System.out.println(tableName);
            List<String> colDef = new ArrayList<>();
            //get column name
            for (Field field: clz.getDeclaredFields()){
                String colName = null;
                Annotation[] anns = field.getDeclaredAnnotations();
                if (anns.length < 1) continue;
                if (anns[0] instanceof SqlString) {
                    SqlString sqlString = (SqlString)anns[0];
                    colName = sqlString.name();
                    if (colName.length() < 1)
                        colName = field.getName().toUpperCase();
                    colDef.add(colName + " VARCHAR2(" + sqlString.value() + ")" + getConstraints(sqlString.constriants()) );
                }
                if (anns[0] instanceof SqlInteger) {
                    SqlInteger sqlInteger = (SqlInteger)anns[0];
                    colName = sqlInteger.name();
                    if (colName.length() < 1)
                        colName = field.getName().toUpperCase();
                    colDef.add(colName + " NUMBER" + getConstraints(sqlInteger.constriants()));
                }
            }
            StringBuilder sql = new StringBuilder("CREATE TABLE " + tableName + "(");
            for (String cl : colDef)
                sql.append('\n').append(cl).append(",");
            String tableCreater = sql.substring(0,sql.length()-1) + "\n);";
            System.out.println("Table Creation SQL for " +
                    clzName + " is :\n" + tableCreater);
        }
    }

    private static String getConstraints(Constriants constriants) {
        StringBuilder sb = new StringBuilder();
        if (constriants.primaryKey())
            sb.append(" PRAMARY KEY");
        if (!constriants.allowNull())
            sb.append(" NOT NULL");
        if (constriants.unique())
            sb.append(" UNIQUE");
        return sb.toString();
    }
}
