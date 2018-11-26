package com.anole.web;


import com.anole.core.common.BaseResponse;
import com.anole.core.domain.test.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;


@Controller
public class testControl extends BaseControl  {
    @RequestMapping("/test")
    @ResponseBody
    public BaseResponse test() {
        BaseResponse response = new BaseResponse();
        List<Person> people = new ArrayList<>();
        Person p1 = new Person("zhangsan", 11);
        Person p2 = new Person("lisi", 22);
        Person p3 = new Person("wangwu", 33);
        people.add(p1);
        people.add(p2);
        people.add(p3);
        response.setData(people);
        return fail(response);
    }

}
