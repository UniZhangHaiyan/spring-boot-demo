package com.example.demo.service.buyloan.impl;

import com.example.demo.dao.buyloan.IBillMapper;
import com.example.demo.entity.buyloan.BillEntity;
import com.example.demo.service.buyloan.IDefaultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * DefaultServiceImpl
 *
 * @author zhanghaiyan 2019/2/21
 * @description
 * @modifier
 */
@Service
public class DefaultServiceImpl implements IDefaultService {
    @Autowired
    private IBillMapper billMapper;

    @Override
    public List<BillEntity> findBillList() {
        return billMapper.selectBillList();
    }
}
