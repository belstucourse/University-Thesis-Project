package com.belstu.thesisproject.vcs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class VideoCallController {
    @RequestMapping(method = RequestMethod.GET, value = "/2")
    public String index() {
        return "static/index.html";
    }
}