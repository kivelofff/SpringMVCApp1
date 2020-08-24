package ru.test.springcurse.config.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class FirstController {
    @GetMapping("/hello")
    public String helloPage(HttpServletRequest request) {
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");

        System.out.println(name + " " + surname);
        return "first/hello";
    }
    @GetMapping("/goodbye")
    public String goodByePage(@RequestParam("name") String name, @RequestParam("surname") String surname, Model model) {
        //System.out.println("bye, " + name + " " + surname);
        model.addAttribute("message", "bye, " + name + " " + surname);
        return "first/goodbye";
    }

    @GetMapping("/calc")
    public String calculator(@RequestParam("a") int a,
                             @RequestParam("b") int b,
                             @RequestParam("operation") String operation,
                             Model model) {
        switch (operation) {
            case "addition":
                model.addAttribute("result", Integer.toString(a+b));
                break;
            case "multiplication":
                model.addAttribute("result", Integer.toString(a*b));
                break;
            case "subtraction":
                model.addAttribute("result", Integer.toString(a-b));
                break;
            case "division":
                model.addAttribute("result", Double.toString(a*1.0/b));
                break;
            default:
                model.addAttribute("result", "wrong operation");
        }
        return "first/calc";
    }
}
