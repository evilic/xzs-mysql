package com.mindskip.xzs.service;

import com.mindskip.xzs.domain.ExamPaperQuestionCustomerAnswer;
import com.mindskip.xzs.domain.other.ExamPaperAnswerUpdate;
import com.mindskip.xzs.viewmodel.student.exam.ExamPaperSubmitItemVM;
import com.mindskip.xzs.viewmodel.student.question.answer.QuestionPageStudentRequestVM;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface ExamPaperQuestionCustomerAnswerService extends BaseService<ExamPaperQuestionCustomerAnswer> {

    PageInfo<ExamPaperQuestionCustomerAnswer> studentPage(QuestionPageStudentRequestVM requestVM);

    List<ExamPaperQuestionCustomerAnswer> selectListByPaperAnswerId(Integer id);

    /**
     * 试卷提交答案入库
     *
     * @param examPaperQuestionCustomerAnswers List<ExamPaperQuestionCustomerAnswer>
     */
    void insertList(List<ExamPaperQuestionCustomerAnswer> examPaperQuestionCustomerAnswers);

    /**
     * 试卷问题答题信息转成ViewModel 传给前台
     *
     * @param qa ExamPaperQuestionCustomerAnswer
     * @return ExamPaperSubmitItemVM
     */
    ExamPaperSubmitItemVM examPaperQuestionCustomerAnswerToVM(ExamPaperQuestionCustomerAnswer qa);

    int updateScore(List<ExamPaperAnswerUpdate> examPaperAnswerUpdates);
}
