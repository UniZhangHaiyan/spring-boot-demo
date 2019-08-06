package com.example.demo.service.activity.impl;

import com.example.demo.dao.IScoreMapperMapper;
import com.example.demo.entity.Score;
import com.example.demo.service.activity.IScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName ScoreServiceImpl
 * @Description
 * @Author zhanghaiyan
 * @Date 2019/8/6
 * @Modifier
 */
@Service
public class ScoreServiceImpl implements IScoreService {
    @Autowired
    private IScoreMapperMapper scoreMapperMapper;

    @Override
    public int saveScore(Score score) {
        return scoreMapperMapper.insertScore(score);
    }

    @Override
    public int removeScore(Long scoreId) {
        return scoreMapperMapper.delete(scoreId);
    }

    @Override
    public int modify(Score score) {
        return scoreMapperMapper.updateScore(score);
    }

    @Override
    public List<Score> findScoreList(Score score) {
        return scoreMapperMapper.queryScore(score);
    }

    @Override
    public Score findScore(Score score) {
        return scoreMapperMapper.queryScoreLimit1(score);
    }
}
