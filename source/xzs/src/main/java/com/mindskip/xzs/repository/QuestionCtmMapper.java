package com.mindskip.xzs.repository;

import com.mindskip.xzs.domain.QuestionCtm;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface QuestionCtmMapper {
    QuestionCtm selectByPrimaryKey(Integer id);
}
