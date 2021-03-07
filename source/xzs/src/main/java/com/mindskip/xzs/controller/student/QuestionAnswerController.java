package com.mindskip.xzs.controller.student;

import com.mindskip.xzs.base.BaseApiController;
import com.mindskip.xzs.service.QuestionService;
import com.mindskip.xzs.service.SubjectService;
import com.mindskip.xzs.service.TextContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController("StudentQuestionAnswerController")
@RequestMapping(value = "/api/student/question/answer")
public class QuestionAnswerController extends BaseApiController {

//    private final ExamPaperQuestionCustomerAnswerService examPaperQuestionCustomerAnswerService;
    private final QuestionService questionService;
    private final TextContentService textContentService;
    private final SubjectService subjectService;

    @Autowired
    public QuestionAnswerController( QuestionService questionService, TextContentService textContentService, SubjectService subjectService) {
        this.questionService = questionService;
        this.textContentService = textContentService;
        this.subjectService = subjectService;
    }

//    @RequestMapping(value = "/page", method = RequestMethod.POST)
//    public RestResponse<PageInfo<QuestionPageStudentResponseVM>> pageList(@RequestBody QuestionPageStudentRequestVM model) {
//        model.setCreateUser(getCurrentUser().getId());
//        PageInfo<ExamPaperQuestionCustomerAnswer> pageInfo = examPaperQuestionCustomerAnswerService.studentPage(model);
//        PageInfo<QuestionPageStudentResponseVM> page = PageInfoHelper.copyMap(pageInfo, q -> {
//            Subject subject = subjectService.selectById(q.getSubjectId());
//            QuestionPageStudentResponseVM vm = modelMapper.map(q, QuestionPageStudentResponseVM.class);
//            vm.setCreateTime(DateTimeUtil.dateFormat(q.getCreateTime()));
//            TextContent textContent = textContentService.selectById(q.getQuestionTextContentId());
//            QuestionObject questionObject = JsonUtil.toJsonObject(textContent.getContent(), QuestionObject.class);
//            String clearHtml = HtmlUtil.clear(questionObject.getTitleContent());
//            vm.setShortTitle(clearHtml);
//            vm.setSubjectName(subject.getName());
//            return vm;
//        });
//        return RestResponse.ok(page);
//    }
//
//
//    @RequestMapping(value = "/select/{id}", method = RequestMethod.POST)
//    public RestResponse<QuestionAnswerVM> select(@PathVariable Integer id) {
//        QuestionAnswerVM vm = new QuestionAnswerVM();
//        ExamPaperQuestionCustomerAnswer examPaperQuestionCustomerAnswer = examPaperQuestionCustomerAnswerService.selectById(id);
//        ExamPaperSubmitItemVM questionAnswerVM = examPaperQuestionCustomerAnswerService.examPaperQuestionCustomerAnswerToVM(examPaperQuestionCustomerAnswer);
//        QuestionEditRequestVM questionVM = questionService.getQuestionEditRequestVM(examPaperQuestionCustomerAnswer.getQuestionId());
//        vm.setQuestionVM(questionVM);
//        vm.setQuestionAnswerVM(questionAnswerVM);
//        return RestResponse.ok(vm);
//    }

}
