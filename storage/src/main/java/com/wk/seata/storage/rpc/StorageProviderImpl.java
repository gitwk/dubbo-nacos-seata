package com.wk.seata.storage.rpc;

import com.wk.seata.rpc.StorageProvider;
import com.wk.seata.storage.db.StoragePo;
import com.wk.seata.storage.mapper.StorageMapper;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author wangkai
 * @since JDK8
 */
@Component
@Service
public class StorageProviderImpl implements StorageProvider {

    @Resource
    private StorageMapper storageMapper;

    @Override
    public void insertStorage() {
        StoragePo storagePo = new StoragePo();
        storagePo.setCommodityCode("test_code");
        storagePo.setCount(1);
        storageMapper.insert(storagePo);
    }

}
