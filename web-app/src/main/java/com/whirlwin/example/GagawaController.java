package com.whirlwin.example;

import com.hp.gagawa.java.elements.A;
import com.hp.gagawa.java.elements.Li;
import com.hp.gagawa.java.elements.Ul;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "gagawa")
public class GagawaController {

    @RequestMapping(value = "test", method = RequestMethod.GET, produces = MediaType.APPLICATION_XML_VALUE)
    @ResponseBody
    public String test() {
        Ul ul = new Ul().appendChild(
                new Li().appendChild(
                        new A().setHref("http://www.whirlwin.org")));

        return ul.write();
    }
}
