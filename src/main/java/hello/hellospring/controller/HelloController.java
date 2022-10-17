package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @GetMapping("hello-String")
    @ResponseBody
    public String helloString(@RequestParam("name") String name) {
        return "hello " + name; //"hello spring"
    }

    @GetMapping("hello-api") // http://localhost:8080/hello-api?name=spring&idx=123
    @ResponseBody // View 페이지가 아닌 자바 객체를 JSON형태로 반환하고 싶을때 @ResponseBody를 사용한다
    public Hello helloApi(@RequestParam("name") String name, @RequestParam("idx") int idx) {
        Hello hello = new Hello();
        hello.setName(name);
        hello.setIdx(idx);
        return hello; // {"name":"spring","idx":123}
    }

    static class Hello {
        private String name;

        private int idx;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getIdx() {
            return idx;
        }

        public void setIdx(int idx) {
            this.idx = idx;
        }
    }
}