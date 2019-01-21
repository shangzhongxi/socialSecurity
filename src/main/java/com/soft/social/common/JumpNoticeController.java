package com.soft.social.common;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JumpNoticeController {
    @RequestMapping("/notice")
    public String hello() {

        return "/html/notice";
    }
}
