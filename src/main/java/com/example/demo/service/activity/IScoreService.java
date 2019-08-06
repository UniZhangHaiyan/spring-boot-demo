package com.example.demo.service.activity;

import com.example.demo.entity.Score;
import com.example.demo.util.datasource.DataSourceType;

import java.util.List;

/**
 * @ClassName IScoreService
 * @Description
 * @Author zhanghaiyan
 * @Date 2019/8/6
 * @Modifier
 */
@DataSourceType(DataSourceType.activity)
public interface IScoreService {
    /**
     * 增
     *
     * @param score
     * @return
     */
    int saveScore(Score score);

    /**
     * 删
     *
     * @param scoreId
     * @return
     */
    int removeScore(Long scoreId);

    /**
     * 改
     *
     * @param score
     * @return
     */
    int modify(Score score);

    /**
     * 查询列表
     *
     * @param score
     * @return
     */
    List<Score> findScoreList(Score score);

    /**
     * 查询一个
     *
     * @param score
     * @return
     */
    Score findScore(Score score);
}
