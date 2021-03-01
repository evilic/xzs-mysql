package com.mindskip.xzs.controller.wx.student;

import com.mindskip.xzs.base.RestResponse;
import com.mindskip.xzs.controller.wx.BaseWXApiController;
import com.mindskip.xzs.domain.TextContent;
import com.mindskip.xzs.domain.User;
import com.mindskip.xzs.domain.enums.ExamPaperTypeEnum;
import com.mindskip.xzs.domain.task.TaskItemAnswerObject;
import com.mindskip.xzs.domain.task.TaskItemObject;
import com.mindskip.xzs.service.ExamPaperService;
import com.mindskip.xzs.service.TextContentService;
import com.mindskip.xzs.utility.DateTimeUtil;
import com.mindskip.xzs.utility.JsonUtil;
import com.mindskip.xzs.viewmodel.student.dashboard.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


@Controller("WXStudentDashboardController")
@RequestMapping(value = "/api/wx/student/dashboard")
@ResponseBody
public class DashboardController extends BaseWXApiController {

    private final ExamPaperService examPaperService;
    private final TextContentService textContentService;

    @Autowired
    public DashboardController(ExamPaperService examPaperService, TextContentService textContentService) {
        this.examPaperService = examPaperService;
        this.textContentService = textContentService;
    }

    @RequestMapping(value = "/index", method = RequestMethod.POST)
    public RestResponse<IndexVM> index() {
        IndexVM indexVM = new IndexVM();
        User user = getCurrentUser();

        PaperFilter fixedPaperFilter = new PaperFilter();
        fixedPaperFilter.setGradeLevel(user.getUserLevel());
        fixedPaperFilter.setExamPaperType(ExamPaperTypeEnum.Fixed.getCode());
        indexVM.setFixedPaper(examPaperService.indexPaper(fixedPaperFilter));

        return RestResponse.ok(indexVM);
    }

//    @RequestMapping(value = "/task", method = RequestMethod.POST)
//    public RestResponse<List<TaskItemVm>> task() {
//        User user = getCurrentUser();
//        List<TaskExam> taskExams = taskExamService.getByGradeLevel(user.getUserLevel());
//        if (taskExams.size() == 0) {
//            return RestResponse.ok(new ArrayList<>());
//        }
//        List<Integer> tIds = taskExams.stream().map(taskExam -> taskExam.getId()).collect(Collectors.toList());
//        List<TaskExamCustomerAnswer> taskExamCustomerAnswers = taskExamCustomerAnswerService.selectByTUid(tIds, user.getId());
//        List<TaskItemVm> vm = taskExams.stream().map(t -> {
//            TaskItemVm itemVm = new TaskItemVm();
//            itemVm.setId(t.getId());
//            itemVm.setTitle(t.getTitle());
//            TaskExamCustomerAnswer taskExamCustomerAnswer = taskExamCustomerAnswers.stream()
//                    .filter(tc -> tc.getTaskExamId().equals(t.getId())).findFirst().orElse(null);
//            List<TaskItemPaperVm> paperItemVMS = getTaskItemPaperVm(t.getFrameTextContentId(), taskExamCustomerAnswer);
//            itemVm.setPaperItems(paperItemVMS);
//            return itemVm;
//        }).collect(Collectors.toList());
//        return RestResponse.ok(vm);
//    }

//
//    private List<TaskItemPaperVm> getTaskItemPaperVm(Integer tFrameId, TaskExamCustomerAnswer taskExamCustomerAnswers) {
//        TextContent textContent = textContentService.selectById(tFrameId);
//        List<TaskItemObject> paperItems = JsonUtil.toJsonListObject(textContent.getContent(), TaskItemObject.class);
//
//        List<TaskItemAnswerObject> answerPaperItems = null;
//        if (null != taskExamCustomerAnswers) {
//            TextContent answerTextContent = textContentService.selectById(taskExamCustomerAnswers.getTextContentId());
//            answerPaperItems = JsonUtil.toJsonListObject(answerTextContent.getContent(), TaskItemAnswerObject.class);
//        }
//
//
//        List<TaskItemAnswerObject> finalAnswerPaperItems = answerPaperItems;
//        return paperItems.stream().map(p -> {
//                    TaskItemPaperVm ivm = new TaskItemPaperVm();
//                    ivm.setExamPaperId(p.getExamPaperId());
//                    ivm.setExamPaperName(p.getExamPaperName());
//                    if (null != finalAnswerPaperItems) {
//                        finalAnswerPaperItems.stream()
//                                .filter(a -> a.getExamPaperId().equals(p.getExamPaperId()))
//                                .findFirst()
//                                .ifPresent(a -> {
//                                    ivm.setExamPaperAnswerId(a.getExamPaperAnswerId());
//                                    ivm.setStatus(a.getStatus());
//                                });
//                    }
//                    return ivm;
//                }
//        ).collect(Collectors.toList());
//    }


}
