package com.mindskip.xzs.viewmodel;

import com.mindskip.xzs.viewmodel.admin.question.QuestionEditItemVM;
import org.hibernate.validator.constraints.Range;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

public class QuestionRequest {
    private Integer id;
    @NotNull
    private Integer questionType;
    @NotNull
    private Integer categoryId;
    @NotBlank
    private String subjectId;
    private Integer unitId;
    private String knowledge;
    private Integer difficult;
    private Integer infoTextContentId;
    private String correct;

    @Valid
    private List<QuestionEditItemVM> items;
    @NotBlank
    private String analyze;

    private List<String> correctArray;

    private Integer itemOrder;
}
