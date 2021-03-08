package com.mindskip.xzs.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    // 更新用户信息，其实只用更新用户的选课信息就OK了（不需要用户注册的功能，直接系统可以自动注册的）
    @PostMapping("/v1/users/{userId}")
    public String updateUser(@PathVariable String userId) {
        return null;
    }

    @GetMapping("/v1/users/{userId}/sequences")
    public String getSequences(@PathVariable String userId) {
        /*
        TODO: 这个方法应该可以获取到指定用户可以使用的题目序列。

        序列应该包含以下组成部分：
        固定的序列 - 分类、科目 都指定的情况下 - 应用场景，固定的试卷；
        随机的序列 - 分类、科目（和/或）单元 批定的情况下 - 应用场景，用户刷题。

        返回的格式可以是：
        {
            "fix_seq": []
        }
        或
        {
            "unfinished": ""
        }

         */
        return null;
    }

    @GetMapping("/v1/users/{userId}/sequences/{sequenceId}")
    public String getSpecifiedSequence(@PathVariable String userId, @PathVariable String sequenceId) {
        return null;
    }

    @PostMapping("/v1/users/{userId}/sequences")
    public String createSequence(@PathVariable String userId) {
        /*
        通过传递过来的参数，生成一个Sequence。

        这个方法应该有两个操作：
        管理员可以用来新建固定序列；
        学生可以用来生成刷题序列。
         */
        return null;
    }
}
