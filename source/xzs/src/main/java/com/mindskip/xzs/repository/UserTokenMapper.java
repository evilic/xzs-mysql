package com.mindskip.xzs.repository;

import com.mindskip.xzs.domain.UserToken;
import org.apache.ibatis.annotations.Mapper;

/*
这个接口我没有找到实现呀。
暂时不知道 Mapper 注解的作用。暂时留着不删除。
 */

@Mapper
public interface UserTokenMapper extends BaseMapper<UserToken> {
    int deleteByPrimaryKey(Integer id);

    int insert(UserToken record);

    int insertSelective(UserToken record);

    UserToken selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserToken record);

    int updateByPrimaryKey(UserToken record);

    UserToken getToken(String token);
}
