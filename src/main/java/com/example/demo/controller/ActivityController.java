package com.example.demo.controller;

import com.example.demo.entity.Score;
import com.example.demo.service.activity.IScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName ActivityController
 * @Description
 * @Author zhanghaiyan
 * @Date 2019/8/6
 * @Modifier
 */
@RestController
@RequestMapping("activity")
public class ActivityController {

    @Autowired
    private IScoreService scoreService;

    @PostMapping
    public int add(@RequestBody Score score) {
        return scoreService.saveScore(score);
    }

    @DeleteMapping("/{id}")
    public int delete(@PathVariable("id") Long id) {
        return scoreService.removeScore(id);
    }

    @PutMapping
    public int put(@RequestBody Score score) {
        return scoreService.modify(score);
    }

    @GetMapping
    public List<Score> get(Score score) {
        return scoreService.findScoreList(score);
    }
}
