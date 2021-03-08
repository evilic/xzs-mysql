package com.mindskip.xzs.repository;

import com.mindskip.xzs.domain.ctm.CategoryCondition;
import com.mindskip.xzs.domain.ctm.CategoryInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CategoryMapper {
    /**
     * 根据查询条件进行数据查询。
     *
     * @param categoryCondition 查询条件（level和parentId必须设置）
     * @return 满足条件的所有结果
     */
    List<CategoryInfo> selectByCondition(CategoryCondition categoryCondition);
}
