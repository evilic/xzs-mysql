package com.mindskip.xzs.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SequenceController {

    @PostMapping("/v1/sequences")
    public String createSequence() {
        /*
        通过传递过来的参数，生成一个Sequence。
        管理员可以用来新建固定序列；
         */
        return null;
    }

}
