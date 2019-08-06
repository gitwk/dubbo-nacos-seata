package com.wk.seata.business.service.impl;

import com.wk.seata.business.service.BusinessService;
import com.wk.seata.rpc.OrderProvider;
import com.wk.seata.rpc.StorageProvider;
import io.seata.core.context.RootContext;
import io.seata.spring.annotation.GlobalTransactional;
import org.apache.dubbo.config.annotation.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @author wangkai
 * @since JDK8
 */
@Service
public class BusinessServiceImpl implements BusinessService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Reference(check = false)
    private StorageProvider storageProvider;
    @Reference(check = false)
    private OrderProvider orderProvider;

    @GlobalTransactional
    public Object createOrder() {
        logger.info("开始全局事务。XID=" + RootContext.getXID());
        orderProvider.createOrder();

        storageProvider.insertStorage();

        logger.info("process success...");
        return true;
    }
}
