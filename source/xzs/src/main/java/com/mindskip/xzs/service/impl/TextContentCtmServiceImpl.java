package com.mindskip.xzs.service.impl;

import com.mindskip.xzs.domain.TextContentCtm;
import com.mindskip.xzs.repository.TextContentCtmMapper;
import com.mindskip.xzs.service.TextContentCtmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TextContentCtmServiceImpl implements TextContentCtmService {
    private final TextContentCtmMapper textContentCtmMapper;

    @Autowired
    public TextContentCtmServiceImpl(TextContentCtmMapper textContentCtmMapper) {
        this.textContentCtmMapper = textContentCtmMapper;
    }

    @Override
    public TextContentCtm insert(TextContentCtm newTextContent) {
        textContentCtmMapper.insert(newTextContent);
        return newTextContent;
    }
}
