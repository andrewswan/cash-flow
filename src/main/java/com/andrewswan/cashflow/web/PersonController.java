package com.andrewswan.cashflow.web;

import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.andrewswan.cashflow.domain.Person;

@RooWebScaffold(path = "person", formBackingObject = Person.class)
@RequestMapping("/person/**")
@Controller
public class PersonController {
}
