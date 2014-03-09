package com.whirlwin.example.mvc

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.ResponseStatus

@Controller
class ExampleController {

    @Autowired
    private ExampleRepository exampleRepository;

    @RequestMapping(value = "users", method = RequestMethod.GET)
    @ResponseBody
    def findUsers() {
        exampleRepository.findUsers()
    }

    @RequestMapping(value = "users", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    def createUser() {
        exampleRepository.insertSomeUser()
        "redirect:/"
    }
}
