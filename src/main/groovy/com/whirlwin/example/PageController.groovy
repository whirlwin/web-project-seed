package com.whirlwin.example

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.servlet.ModelAndView

import javax.servlet.http.HttpServletRequest

@Controller
class PageController {

    @RequestMapping(value = "/* ")
    def index() {
        "template"
    }

    @RequestMapping(value = "/views/**")
    def getView(HttpServletRequest request) {
        String viewName = request.getRequestURI().replaceFirst(/\\/views\\//, "")
        new ModelAndView(viewName)
    }
}