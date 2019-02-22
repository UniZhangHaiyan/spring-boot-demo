package com.example.demo.service.buyloan.impl;

import com.example.demo.dao.buyloan.IBillMapper;
import com.example.demo.entity.buyloan.BillEntity;
import com.example.demo.service.buyloan.IBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * BillServiceImpl
 *
 * @author zhanghaiyan 2019/1/24
 * @description
 * @modifier
 */
@Service
public class BillServiceImpl implements IBillService {

    @Autowired
    private IBillMapper billMapper;

    @Override
    public List<BillEntity> findBillList() {
        return billMapper.selectBillList();
    }
}
