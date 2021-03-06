package com.mindskip.xzs.service;

import com.mindskip.xzs.domain.QuestionCtm;
import com.mindskip.xzs.viewmodel.QuestionRequest;

public interface QuestionCtmService {

    /**
     * 通过题目id查找题目。
     *
     * @param id 题目id
     * @return 指定id的题目
     */
    QuestionCtm selectById(Integer id);

    /**
     * 添加新的题目。
     *
     * @param newQuestion 新题目参数
     * @return 插入结果
     */
    QuestionCtm insert(QuestionRequest newQuestion);
}
