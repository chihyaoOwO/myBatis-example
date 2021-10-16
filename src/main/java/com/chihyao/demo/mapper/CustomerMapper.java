package com.chihyao.demo.mapper;

import com.chihyao.demo.model.Customer;
import com.chihyao.demo.provider.CustomerProvider;
import org.apache.ibatis.annotations.*;

@Mapper
public interface CustomerMapper extends BaseMapper<Customer> {

//    @Results({
//            @Result(column="name",property="name"),
//            @Result(column="phone",property="phone"),
//            @Result(column="address",property="address")
//    })
    @Select("select * from customer where name = #{name}")
    Customer findByName(@Param("name") String name);

    @Insert("insert into customer (name, address, phone) values(#{name}, #{address}, #{phone})")
    int insert(Customer customer);

//    @UpdateProvider(type = CustomerProvider.class, method = "update")
//    int update(Customer customer);

}
