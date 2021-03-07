package com.mindskip.xzs.repository;

import com.mindskip.xzs.domain.TextContentCtm;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TextContentCtmMapper {
    /**
     * 插入文本记录。
     *
     * @param textContentCtm 要插入的记录
     * @return
     */
    int insert(TextContentCtm textContentCtm);
}
