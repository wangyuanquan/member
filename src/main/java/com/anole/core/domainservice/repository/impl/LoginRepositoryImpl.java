package com.anole.core.domainservice.repository.impl;

import com.anole.core.dal.dataobject.UserInfo;
import com.anole.core.dal.mapper.UserInfoMapper;
import com.anole.core.domainservice.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Repository
public class LoginRepositoryImpl implements LoginRepository {
    @Autowired
    UserInfoMapper userInfoMapper;

    @Override
    public UserInfo queryUserInfoByName(String loginName){
        //cm_user_info
        Example exampleUserInfo = new Example(UserInfo.class);
        exampleUserInfo.createCriteria().andEqualTo("loginName", loginName);
        List<UserInfo> UserInfoList = userInfoMapper.selectByExample(exampleUserInfo);
        if (UserInfoList.isEmpty()){
            return null;
        }
        return UserInfoList.get(0);
    }
}
