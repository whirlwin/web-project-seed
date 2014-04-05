package com.whirlwin.example
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping

@Controller
class PageController {

    @RequestMapping(value = "/* ")
    def index() {
        "template"
    }
}