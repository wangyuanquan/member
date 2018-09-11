package com.rechenggit.web;

import com.alibaba.fastjson.JSONObject;
import com.rechenggit.core.dal.dataobject.Member;
import com.rechenggit.core.dal.mongodbobject.Customer;
import com.rechenggit.core.dal.mongodbobject.User;
import com.rechenggit.core.domain.NotEmptyTest;
import com.rechenggit.core.domainservice.mongodbrepository.CustomerRepository;
import com.rechenggit.core.domainservice.mongodbrepository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping(value="/example")
public class ExampleControl extends BaseControl
{
        private final static Logger logger = LoggerFactory.getLogger(ExampleControl.class);

    @Autowired
    private UserRepository userService;
    @Autowired
    private CustomerRepository customerRepository;

        @GetMapping(value = "/test", produces = {"application/json;charset=UTF-8"})
        public String test(){
            logger.info("info");
            logger.debug("debug");
            logger.error("error");
            return "1111";

        }
    @PostMapping(value = "/test", produces = {"application/json;charset=UTF-8"})
    public String test(@RequestBody Member member){
        logger.info("info");
        logger.debug("debug");
        logger.error("error");
        return "1111";

    }
    @RequestMapping("/get/{id}")
    public User getUser(@PathVariable int id) {
        return userService.getUser(id);
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        userService.remove(id);
        return "delete sucess";
    }

    @GetMapping("/add")
    public String nsert() {
        User user =new User(16, ""+16, 16);
        userService.insert(user);
        return "sucess";
    }
    @PostMapping("/example")
    public String example(@RequestBody @Validated NotEmptyTest example, BindingResult bindingResult) {
        System.out.println("example:"+JSONObject.toJSONString(example));
        return "sucess";
    }
    @RequestMapping("/insert")
    public String insertAll(String name,String pwd) {
        List<User> list = new ArrayList<>();
        for (int i = 10; i < 15; i++) {
            list.add(new User(i, "" + i, i));
        }
        userService.insertAll(list);
        return "sucess";
    }

    @RequestMapping("/find/all")
    public List<User> find(){
        return userService.findAll();
    }

    @RequestMapping("/find/{start}")
    public List<User> findByPage(@PathVariable int start, User user){
        Pageable pageable=new PageRequest(start, 2);
        return userService.findByPage(user, pageable);
    }

    @RequestMapping("/update/{id}")
    public String update(@PathVariable int id){
        User user =new User(id, ""+1, 1);
        userService.update(user);
        return "sucess";
    }
    @RequestMapping("/list")
    public List<Customer> dobegin() throws Exception {
        customerRepository.deleteAll();
        int i=0;
        while (i<100) {
            Customer customer = new Customer();
            customer.setCarNumber(new Random(10000).toString());
            customer.setId(i+"");
            customer.setName("yin");
            customerRepository.insert(customer);
            i++;
        }

        List<Customer> list =  customerRepository.findAll();
        System.out.println(JSONObject.toJSONString(list));
        PageRequest pageRequest = new PageRequest(0,1000);
        list = customerRepository.findByNameNotNull(pageRequest).getContent();
        System.out.println(JSONObject.toJSONString(list));
        list = customerRepository.findByNameLike("yin",pageRequest).getContent();
        System.out.println(JSONObject.toJSONString(list));
        customerRepository.deleteAll();
        return list;
    }
}
