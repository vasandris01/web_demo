package com.example.web_demo.controller;

import com.example.web_demo.model.Person;
import com.example.web_demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PageController {
    private PersonService personService;

    @Autowired
    public PageController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping({"","/home","/"})
    private String getHome(Model model){
        model.addAttribute("persons", personService.getPersons());
        model.addAttribute("new_person", new Person());
        model.addAttribute("message","Hello Thymeleaf");
        return "home";
    }

    @PostMapping("/new")
    public String createPerson(@ModelAttribute("new_person") Person person){
        personService.savePerson(person);
        return "redirect:/home";
    }

    @PostMapping("/delete")
    public String deletePerson(@RequestParam("actual") String name){
        personService.deletePersonByName(name);
        return "redirect:/home";
    }
}
