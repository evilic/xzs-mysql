package com.mindskip.xzs.service;

import com.mindskip.xzs.domain.QuestionCtm;

public interface QuestionCtmService {

    /**
     * 通过题目id查找题目。
     *
     * @param id 题目id
     * @return 指定id的题目
     */
    QuestionCtm selectById(Integer id);
}
