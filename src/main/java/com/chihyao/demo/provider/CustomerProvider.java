package com.chihyao.demo.provider;

import com.chihyao.demo.model.Customer;
import org.apache.ibatis.jdbc.SQL;
import org.springframework.util.ObjectUtils;

import java.lang.reflect.Field;

public class CustomerProvider {

    public String update(Customer customer) {
        SQL sql = new SQL();
        String tableName = customer.getClass().getSimpleName();
        sql.UPDATE(tableName);

        Field[] fields = customer.getClass().getDeclaredFields();
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
}
