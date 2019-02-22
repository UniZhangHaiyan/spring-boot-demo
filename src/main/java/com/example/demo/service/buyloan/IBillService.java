package com.example.demo.service.buyloan;

import com.example.demo.entity.buyloan.BillEntity;
import com.example.demo.util.datasource.DataSourceType;

import java.util.List;

/**
 * IBillService
 *
 * @author zhanghaiyan 2019/1/24
 * @description 注解用于标明使用哪个数据源
 * @modifier
 */
@DataSourceType("buyloan")
public interface IBillService {
    List<BillEntity> findBillList();
}
