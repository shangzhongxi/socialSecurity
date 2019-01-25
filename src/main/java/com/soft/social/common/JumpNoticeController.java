package com.soft.social.common;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import springfox.documentation.annotations.ApiIgnore;

@Controller
public class JumpNoticeController {
    @ApiIgnore
    @RequestMapping("/notice")
    public String hello() {

        return "html/notice";
    }
}
