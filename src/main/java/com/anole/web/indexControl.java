package com.anole.web;


import com.anole.core.domain.test.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;


@Controller
public class indexControl {
    @RequestMapping("/")
    public String index(Model model) {
        Person single = new Person("xingming", 11);
        List<Person> people = new ArrayList<>();
        Person p1 = new Person("zhangsan", 11);
        Person p2 = new Person("lisi", 22);
        Person p3 = new Person("wangwu", 33);
        people.add(p1);
        people.add(p2);
        people.add(p3);
        model.addAttribute("singlePerson", single);
        model.addAttribute("people", people);
        return "index";
    }
    @RequestMapping("/index")
    public String mallindex(Model model) {
        Person single = new Person("aa", 11);
        List<Person> people = new ArrayList<>();
        Person p1 = new Person("zhangsan", 11);
        Person p2 = new Person("lisi", 22);
        Person p3 = new Person("wangwu", 33);
        people.add(p1);
        people.add(p2);
        people.add(p3);
        model.addAttribute("singlePerson", single);
        model.addAttribute("people", people);
        return "mall/index";
    }
    @RequestMapping("/login")
    public String login(Model model) {

        return "mall/login";
    }
    @RequestMapping("/erjiclass")
    public String erji(Model model) {

        return "mall/erji-class";
    }
    @RequestMapping("/ping")
    public String ping(Model model) {

        return "mall/my-p";
    }
}
