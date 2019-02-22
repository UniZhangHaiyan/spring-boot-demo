package com.example.demo.controller;

import com.example.demo.entity.buyloan.BillEntity;
import com.example.demo.service.buyloan.IDefaultService;
import com.example.demo.service.buyloan.IBillService;
import com.example.demo.util.lock.springredis.SpringBootRedisLock;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * BillController
 *
 * @author zhanghaiyan 2019/1/24
 * @description
 * @modifier
 */
@RestController
@RequestMapping("bill")
public class BillController {

    @Autowired
    private IBillService billService;

    @Autowired
    private IDefaultService defaultService;

    @Autowired
    private SpringBootRedisLock springBootRedisLock;

    @GetMapping
    public String getBillList() {
        try {
            springBootRedisLock.lock("zhy", 5L, 10 * 60 * 1000L);
        } catch (Exception e) {
            throw e;
        }
        StringBuilder bill = new StringBuilder();
        try {
            PageHelper.startPage(1, 10);
            List<BillEntity> billEntityList = billService.findBillList();
            if (!CollectionUtils.isEmpty(billEntityList)) {
                billEntityList.forEach(billEntity -> bill.append(billEntity.getBillCode()).append("\n"));
            }
        } catch (Exception e) {

        } finally {
            springBootRedisLock.unlock("zhy");
        }
        return bill.toString();
    }

    @GetMapping("default")
    public String getDefaultBillList() {
        List<BillEntity> billEntityList = defaultService.findBillList();
        StringBuilder bill = new StringBuilder();
        if (!CollectionUtils.isEmpty(billEntityList)) {
            billEntityList.forEach(billEntity -> bill.append(billEntity.getBillCode()).append("\n"));
        }
        return bill.toString();
    }
}
