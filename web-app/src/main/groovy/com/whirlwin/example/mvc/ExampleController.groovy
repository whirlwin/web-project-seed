package com.whirlwin.example.mvc

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.ResponseStatus

import javax.annotation.Resource

@Controller
class ExampleController {

    @Resource
    private ExampleConstrettoBean exampleConstrettoBean

    private final ExampleService exampleService

    @Autowired
    ExampleController(ExampleService exampleService) {
        this.exampleService = exampleService
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    @ResponseBody
    def findUsers() {
        exampleService.findUsers()
    }

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    def createUser() {
        exampleService.insertUser(new User(name: 'John Doe', age: 21))
        new ResponseEntity<String>("linkToResource", HttpStatus.CREATED)
    }
}
