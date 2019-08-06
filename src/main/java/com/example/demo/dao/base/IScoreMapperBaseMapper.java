package com.example.demo.dao.base;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.example.demo.entity.Score;
/**
*  @author zhanghaiyan
*/
public interface IScoreMapperBaseMapper {

    int insertScore(Score object);

    int updateScore(Score object);

    int update(Score.UpdateBuilder object);

    List<Score> queryScore(Score object);

    Score queryScoreLimit1(Score object);

}