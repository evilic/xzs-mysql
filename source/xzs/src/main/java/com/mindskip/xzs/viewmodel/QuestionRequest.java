package com.mindskip.xzs.viewmodel;

import com.mindskip.xzs.domain.enums.QuestionTypeEnum;
import com.mindskip.xzs.utility.ExamUtil;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * 新建题目时前台传来的Json。<br>
 * <p>
 * 原项目传来的参数大概样子是这样的：<br>
 * {<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;"id": null,<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;"questionType": 1,<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;"gradeLevel": 1,<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;"subjectId": 1,<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;"title": "API题干",<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;"items": [{<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"prefix": "A",<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"content": "API A"<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;}, {<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"prefix": "B",<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"content": "API B"<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;}, {<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"prefix": "C",<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"content": "API C"<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;}, {<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"prefix": "D",<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"content": "API D"<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;}],<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;"analyze": "API ANA",<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;"correct": "B",<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;"score": 5,<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;"difficult": 4<br>
 * }
 */
public class QuestionRequest {
    private Integer id;
    // 类型
    @NotNull
    private Integer questionType;
    // 分类-科目-单元
    @NotNull
    private Integer categoryId;
    @NotNull
    private Integer subjectId;
    private Integer unitId;
    // 标题-选项-正确答案-知识点-解析
    @NotBlank
    private String title;
    @Valid
    private List<QuestionItemRequest> items;
    private String correct; // 单选题目使用
    private List<String> correctArray; // 多选题目使用
    private String knowledge;
    private String analyze;
    // 难度划分
    private Integer difficult;

    public String getCorrectString() {
        return getQuestionType() == QuestionTypeEnum.MultipleChoice.getCode() ?
                ExamUtil.contentToString(getCorrectArray()) : getCorrect();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQuestionType() {
        return questionType;
    }

    public void setQuestionType(Integer questionType) {
        this.questionType = questionType;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Integer subjectId) {
        this.subjectId = subjectId;
    }

    public Integer getUnitId() {
        return unitId;
    }

    public void setUnitId(Integer unitId) {
        this.unitId = unitId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<QuestionItemRequest> getItems() {
        return items;
    }

    public void setItems(List<QuestionItemRequest> items) {
        this.items = items;
    }

    public String getCorrect() {
        return correct;
    }

    public void setCorrect(String correct) {
        this.correct = correct;
    }

    public List<String> getCorrectArray() {
        return correctArray;
    }

    public void setCorrectArray(List<String> correctArray) {
        this.correctArray = correctArray;
    }

    public String getKnowledge() {
        return knowledge;
    }

    public void setKnowledge(String knowledge) {
        this.knowledge = knowledge;
    }

    public String getAnalyze() {
        return analyze;
    }

    public void setAnalyze(String analyze) {
        this.analyze = analyze;
    }

    public Integer getDifficult() {
        return difficult;
    }

    public void setDifficult(Integer difficult) {
        this.difficult = difficult;
    }
}
