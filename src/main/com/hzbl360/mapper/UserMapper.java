package com.hzbl360.mapper;

import com.hzbl360.model.SysRole;
import com.hzbl360.model.SysUser;
import org.apache.ibatis.annotations.Param;
import org.junit.Test;

import java.util.List;
import java.util.Map;

public interface UserMapper {

    SysUser selectById(Long id);

    List<SysUser> selectAll();

    List<SysRole> selectRoleByUserId(Long userId);


    int insert(SysUser sysUser);

    int updateById(SysUser sysUser);

    /**
     * 根据用户id和角色的enavled 状态获取用户的角色
     */

    List<SysRole> selectRolesByUserIdAndRoleEnabled(@Param("userId") Long userId,@Param("enabled") Long enabled);


    List<SysRole> selectRolesByUserAndRole(@Param("user")SysUser user,@Param("role")SysRole role);


    SysUser selectByIdOrUserName(SysUser sysUser);

    SysUser selectByUser(@Param("userName") String userName,@Param("userEmail")String userEmail);

    List<SysUser> selectByIdList(List<Long> idList);

    int insertList(List<SysUser> userList);

    int updateByMap(@Param("map") Map<String,Object> map);

    List<SysUser> selectUserAndRoleById(Long id);
}
