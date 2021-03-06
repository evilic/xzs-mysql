package com.mindskip.xzs.controller;

import com.mindskip.xzs.base.RestResponse;
import com.mindskip.xzs.domain.QuestionCtm;
import com.mindskip.xzs.service.QuestionCtmService;
import com.mindskip.xzs.viewmodel.QuestionRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author Emerson
 */
@RestController
public class QuestionController {

    // TODO: 先统一替换原有的 QuestionController.java
    private final QuestionCtmService questionCtmService;

    @Autowired
    public QuestionController(QuestionCtmService questionCtmService) {
        this.questionCtmService = questionCtmService;
    }

    @GetMapping("/v1/questions/{questionId}")
    public QuestionCtm getQuestion(@PathVariable Integer questionId) {
        return questionCtmService.selectById(questionId);
//        return RestResponse.ok(page);
    }


    @PostMapping("/v1/questions")
    public RestResponse edit(@RequestBody @Valid QuestionRequest model) {
        // TODO: 验证
        questionCtmService.insert(model);
        return RestResponse.ok();
    }

//    @RequestMapping(value = "/select/{id}", method = RequestMethod.POST)
//    public RestResponse<QuestionEditRequestVM> select(@PathVariable Integer id) {
//        QuestionEditRequestVM newVM = questionService.getQuestionEditRequestVM(id);
//        return RestResponse.ok(newVM);
//    }


//    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
//    public RestResponse delete(@PathVariable Integer id) {
//        Question question = questionService.selectById(id);
//        question.setDeleted(true);
//        questionService.updateByIdFilter(question);
//        return RestResponse.ok();
//    }

//    private RestResponse validQuestionEditRequestVM(QuestionEditRequestVM model) {
//        int qType = model.getQuestionType().intValue();
//        // 单选题 或 判断题
//        boolean requireCorrect = qType == QuestionTypeEnum.SingleChoice.getCode() ||
//                qType == QuestionTypeEnum.TrueFalse.getCode();
//        if (requireCorrect) {
//            if (StringUtils.isBlank(model.getCorrect())) {
//                String errorMsg = ErrorUtil.parameterErrorFormat("correct", "不能为空");
//                return new RestResponse<>(SystemCode.ParameterValidError.getCode(), errorMsg);
//            }
//        }
//        // 填空题
//        if (qType == QuestionTypeEnum.GapFilling.getCode()) {
//            Integer fillSumScore = model.getItems().stream().mapToInt(d -> ExamUtil.scoreFromVM(d.getScore())).sum();
//            Integer questionScore = ExamUtil.scoreFromVM(model.getScore());
//            if (!fillSumScore.equals(questionScore)) {
//                String errorMsg = ErrorUtil.parameterErrorFormat("score", "空分数和与题目总分不相等");
//                return new RestResponse<>(SystemCode.ParameterValidError.getCode(), errorMsg);
//            }
//        }
//        return RestResponse.ok();
//    }
}
