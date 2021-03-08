package com.mindskip.xzs.controller.wx.student;

import com.mindskip.xzs.base.RestResponse;
import com.mindskip.xzs.controller.wx.BaseWXApiController;
import com.mindskip.xzs.domain.TextContent;
import com.mindskip.xzs.domain.User;
import com.mindskip.xzs.domain.enums.ExamPaperTypeEnum;
import com.mindskip.xzs.service.ExamPaperService;
import com.mindskip.xzs.service.TextContentService;
import com.mindskip.xzs.viewmodel.student.dashboard.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
