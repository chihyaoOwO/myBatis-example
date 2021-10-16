package com.chihyao.demo.mapper;

import com.chihyao.demo.model.Customer;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class CustomerMapperTest {

    @Autowired
    private CustomerMapper customerMapper;

    @Test
    void insert(){
        int add = customerMapper.add(Customer.builder().name("AAA").address("高雄市").phone("0987654321").build());

        Assert.assertEquals(add, 1);
    }

    @Test
    public void FindByName() throws Exception {
        customerMapper.insert(Customer.builder().name("AAA").address("高雄市").phone("0987654321").build());

        Customer c = customerMapper.findByName("AAA");
    }

    @Test
    void update(){
        Customer c = customerMapper.findByName("AAA");
        Customer customer = Customer.builder()
                .id(c.getId())
                .name(c.getName())
                .address("台北市")
                .phone(c.getPhone())
                .build();

        customerMapper.update(customer);
    }

    @Test
    void delete(){
        int delete = customerMapper.delete(Customer.builder().id("1").build());
        Assert.assertEquals(delete, 1);
    }
}