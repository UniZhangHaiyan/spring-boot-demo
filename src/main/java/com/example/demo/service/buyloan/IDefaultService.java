package com.example.demo.service.buyloan;

import com.example.demo.entity.buyloan.BillEntity;
import com.example.demo.util.datasource.DataSourceType;

import java.util.List;

/**
 * DefaultService
 *
 * @author zhanghaiyan 2019/2/21
 * @description
 * @modifier
 */
@DataSourceType
public interface IDefaultService {
    List<BillEntity> findBillList();
}
