package com.jiepi.concurrency.thread;

import com.jiepi.concurrency.threadLocal.RequestHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/threadLocal")
public class ThreadTest {

    @GetMapping("/test")
    @ResponseBody
    public String test(){
        return RequestHolder.getId();
    }
}
