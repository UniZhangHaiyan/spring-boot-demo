package com.example.demo.dao;

import com.example.demo.dao.base.IStudentMapperBaseMapper;

/**
 * @author zhanghaiyan
 */
public interface IStudentMapperMapper extends IStudentMapperBaseMapper {

    int delete(Long id);
}