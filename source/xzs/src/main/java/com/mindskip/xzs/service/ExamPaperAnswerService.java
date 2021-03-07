package com.mindskip.xzs.service;

import com.mindskip.xzs.domain.ExamPaperAnswer;
import com.mindskip.xzs.viewmodel.student.exampaper.ExamPaperAnswerPageVM;
import com.github.pagehelper.PageInfo;

public interface ExamPaperAnswerService extends BaseService<ExamPaperAnswer> {

    /**
     * 学生考试记录分页
     *
     * @param requestVM 过滤条件
     * @return PageInfo<ExamPaperAnswer>
     */
    PageInfo<ExamPaperAnswer> studentPage(ExamPaperAnswerPageVM requestVM);

}
