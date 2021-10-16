package com.chihyao.demo.mapper;

import com.chihyao.demo.provider.BaseProvider;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.UpdateProvider;

public interface BaseMapper<T> {

    @InsertProvider(type = BaseProvider.class, method = "add")
    int add(T t);
    @UpdateProvider(type = BaseProvider.class, method = "update")
    int update(T t);
    @DeleteProvider(type = BaseProvider.class, method = "delete")
    int delete(T t);
}
