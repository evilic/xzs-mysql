package com.mindskip.xzs.domain;

import com.mindskip.xzs.domain.enums.QuestionTypeEnum;
import com.mindskip.xzs.utility.ExamUtil;

import java.io.Serializable;
import java.util.List;

public class QuestionCtm implements Serializable {

    private static final long serialVersionUID = -7886834704926187142L;

    private Integer id;
    // 1.单选题 2.多选题 3.判断题 4.填空题 5.简答题
    private Integer questionType;
    // 分类（对应原系统的级别）
    private Integer categoryId;
    // 学科/专业/科目
    private Integer subjectId;
    // 章节/单元
    private Integer unitId;
    // 知识点/标签
    private String knowledge;
    // 题目难度
    private Integer difficult;
    // 题目 - 填空、 题干、解析、答案等信息
    private Integer infoTextContentId;
    // 正确答案
    private String correct;
    // 是否删除
    private Boolean deleted;
    // TODO: hash

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

    public String getKnowledge() {
        return knowledge;
    }

    public void setKnowledge(String knowledge) {
        this.knowledge = knowledge == null ? null : knowledge.trim();
    }

    public Integer getDifficult() {
        return difficult;
    }

    public void setDifficult(Integer difficult) {
        this.difficult = difficult;
    }

    public Integer getInfoTextContentId() {
        return infoTextContentId;
    }

    public void setInfoTextContentId(Integer infoTextContentId) {
        this.infoTextContentId = infoTextContentId;
    }

    public String getCorrect() {
        return correct;
    }

    public void setCorrect(String correct) {
        this.correct = correct == null ? null : correct.trim();
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }
}
