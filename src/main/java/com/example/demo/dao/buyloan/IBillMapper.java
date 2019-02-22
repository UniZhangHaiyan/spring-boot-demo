package com.example.demo.dao.buyloan;


import com.example.demo.entity.buyloan.BillEntity;

import java.util.List;

/**
 * IBillMapper
 *
 * @author zhanghaiyan 2019/1/24
 * @description
 * @modifier
 */
public interface IBillMapper {

    List<BillEntity> selectBillList();
}
