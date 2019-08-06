package com.wk.seata.order.rpc;

import com.wk.seata.order.db.OrderPo;
import com.wk.seata.order.mapper.OrderMapper;
import com.wk.seata.rpc.AccountProvider;
import com.wk.seata.rpc.OrderProvider;
import org.apache.dubbo.config.annotation.Reference;
import org.apache.dubbo.config.annotation.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author wangkai
 * @since JDK8
 */
@Component
@Service
public class OrderProviderImpl implements OrderProvider {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private OrderMapper orderMapper;

    @Reference(check = false)
    private AccountProvider accountProvider;

    @Override
    public void createOrder() {

        logger.info("begin invoke insert account");
        accountProvider.insertAccount();

        OrderPo orderPo = new OrderPo();
        orderPo.setCommodityCode("test_code").setCount(1).setUserId(123).setMoney(100);
        logger.info("start createOrder...");
        orderMapper.insert(orderPo);
        logger.info("end createOrder...");
    }

}
