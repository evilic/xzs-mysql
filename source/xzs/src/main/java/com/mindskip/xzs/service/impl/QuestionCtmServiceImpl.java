package com.mindskip.xzs.service.impl;

import com.mindskip.xzs.domain.QuestionCtm;
import com.mindskip.xzs.domain.TextContentCtm;
import com.mindskip.xzs.repository.QuestionCtmMapper;
import com.mindskip.xzs.service.QuestionCtmService;
import com.mindskip.xzs.service.TextContentCtmService;
import com.mindskip.xzs.utility.JsonUtil;
import com.mindskip.xzs.utility.ModelMapperSingle;
import com.mindskip.xzs.viewmodel.QuestionRequest;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class QuestionCtmServiceImpl implements QuestionCtmService {
    private final static Logger logger = LoggerFactory.getLogger(QuestionCtmServiceImpl.class);

    protected final static ModelMapper modelMapper = ModelMapperSingle.Instance();
    private final QuestionCtmMapper questionCtmMapper;

    private final TextContentCtmService textContentCtmService;

    @Autowired
    public QuestionCtmServiceImpl(QuestionCtmMapper questionCtmMapper, TextContentCtmService textContentCtmService) {
        this.questionCtmMapper = questionCtmMapper;
        this.textContentCtmService = textContentCtmService;
    }

    @Override
    public QuestionCtm selectById(Integer id) {
        return questionCtmMapper.selectByPrimaryKey(id);
    }

    @Override
    @Transactional
    public QuestionCtm insert(QuestionRequest newQuestion) {
        // 题干、解析、选项等 插入
        TextContentCtm infoTextContent = new TextContentCtm();
        infoTextContent.setContent(JsonUtil.toJsonStr(newQuestion));
        textContentCtmService.insert(infoTextContent);
        // 插入题目
        QuestionCtm questionCtm = new QuestionCtm();
        questionCtm.setQuestionType(newQuestion.getQuestionType());
        questionCtm.setCategoryId(newQuestion.getCategoryId());
        questionCtm.setSubjectId(newQuestion.getSubjectId());
        questionCtm.setUnitId(newQuestion.getUnitId());
        questionCtm.setKnowledge(newQuestion.getKnowledge());
        questionCtm.setDifficult(newQuestion.getDifficult());
        questionCtm.setInfoTextContentId(infoTextContent.getId());
        questionCtm.setCorrect(newQuestion.getCorrectString());
        questionCtm.setDeleted(false);
        questionCtmMapper.insert(questionCtm);
        return questionCtm;
    }
}
