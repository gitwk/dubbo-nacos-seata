package com.wk.seata.order.mapper;

import com.wk.seata.order.db.OrderPo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectKey;

/**
 * @author wangkai
 * @since JDK8
 */
@Mapper
public interface OrderMapper {

//    @SelectKey(before = true,resultType = Integer.class,keyProperty = "id",keyColumn = "id",statement = "SELECT LAST_INSERT_ID()")
    @Insert("INSERT INTO `order_tbl` (`user_id`, `commodity_code`, `count`, `money`) VALUES (#{userId}, #{commodityCode}, #{count}, #{money})")
    void insert(OrderPo orderPo);
}
