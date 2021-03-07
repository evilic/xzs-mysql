package com.mindskip.xzs.repository;

import com.mindskip.xzs.domain.QuestionCtm;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface QuestionCtmMapper {
    /**
     * 根据id主键查询数据库。
     *
     * @param id 主键
     * @return QuestionCtm对象
     */
    QuestionCtm selectByPrimaryKey(Integer id);

    /**
     * 向数据库插入新数据。
     *
     * @param record 要插入数据库的对象
     * @return
     */
    int insert(QuestionCtm record);
}
