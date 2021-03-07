package com.mindskip.xzs.service;

import com.mindskip.xzs.domain.TextContentCtm;

public interface TextContentCtmService {
    /**
     * 插入字符串到数据库。
     *
     * @param newTextContent 新的字符串
     * @return 插入后的对象
     */
    TextContentCtm insert(TextContentCtm newTextContent);
}
