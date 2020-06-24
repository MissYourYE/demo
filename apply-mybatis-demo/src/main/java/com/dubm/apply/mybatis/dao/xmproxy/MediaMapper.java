package com.dubm.apply.mybatis.dao.xmproxy;

import com.dubm.apply.mybatis.po.Media;

public interface MediaMapper {
    int insert(Media record);

    int insertSelective(Media record);

    Media selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Media record);

    int updateByPrimaryKey(Media record);
}