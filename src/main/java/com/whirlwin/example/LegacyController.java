package com.whirlwin.example;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LegacyController {

    @RequestMapping(value = "legacy", method = RequestMethod.GET)
    @ResponseBody
    public String index() {
        return "foo, bar, baz";
    }
}
