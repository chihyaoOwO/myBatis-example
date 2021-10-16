package com.chihyao.demo.provider;

import com.chihyao.demo.model.Customer;
import org.apache.ibatis.jdbc.SQL;

import java.lang.reflect.Field;

public class BaseProvider {

    public String add(Object bean) {
        SQL sql = new SQL();
        String tableName = bean.getClass().getSimpleName();
        sql.INSERT_INTO(tableName);

        Field[] fields = bean.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            String columnName = field.getName();

            try {
                if (field.get(bean) != null && !"".equals(field.get(bean)))
                    sql.VALUES(columnName, " = #{" + columnName + "}");
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }

        }
        return sql.toString();
    }

    public String update(Object bean) {
        SQL sql = new SQL();
        String tableName = bean.getClass().getSimpleName();
        sql.UPDATE(tableName);

        Field[] fields = bean.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            String columnName = field.getName();

            if ("id".equals(columnName)){
                sql.WHERE(columnName + " = #{" + columnName + "}");
            }else {
                sql.SET(columnName + " = #{" + columnName + "}");
            }
        }
        return sql.toString();
    }

    public String delete(Object bean) {
        SQL sql = new SQL();
        String tableName = bean.getClass().getSimpleName();
        sql.DELETE_FROM(tableName);

        Field[] fields = bean.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            String columnName = field.getName();

            if ("id".equals(columnName)){
                sql.WHERE(columnName + " = #{" + columnName + "}");
            }
        }

        return sql.toString();
    }
}
