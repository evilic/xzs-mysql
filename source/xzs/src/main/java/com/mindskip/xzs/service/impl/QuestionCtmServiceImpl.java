package com.mindskip.xzs.service.impl;

import com.mindskip.xzs.domain.QuestionCtm;
import com.mindskip.xzs.repository.QuestionCtmMapper;
import com.mindskip.xzs.service.QuestionCtmService;
import com.mindskip.xzs.utility.ModelMapperSingle;
import com.mindskip.xzs.viewmodel.QuestionRequest;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionCtmServiceImpl implements QuestionCtmService {
    protected final static ModelMapper modelMapper = ModelMapperSingle.Instance();
    private final QuestionCtmMapper questionCtmMapper;

    @Autowired
    public QuestionCtmServiceImpl(QuestionCtmMapper questionCtmMapper) {
        this.questionCtmMapper = questionCtmMapper;
    }

    @Override
    public QuestionCtm selectById(Integer id) {
        return questionCtmMapper.selectByPrimaryKey(id);
    }

    @Override
    public QuestionCtm insert(QuestionRequest newQuestion) {
        return null;
    }
}
