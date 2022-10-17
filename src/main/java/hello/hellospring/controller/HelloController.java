package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {
    @GetMapping("hello")
    public String hello(Model model) { // Model 객체는 컨트롤러에서 데이터를 생성해 View에 전달한다. key와 value값을 저장한다.
        model.addAttribute("data", "hello!!");
        return "hello";
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model) { // @RequestParam은 URL로 파라미터를 전달한다. (쿼리스트링 방식)
        model.addAttribute("name", name);
        return "hello-template";
    }
}