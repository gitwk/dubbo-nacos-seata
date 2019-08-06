package com.wk.seata.account.rpc;

import com.wk.seata.account.db.AccountPo;
import com.wk.seata.account.mapper.AccountMapper;
import com.wk.seata.rpc.AccountProvider;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author wangkai
 * @since JDK8
 */
@Component
@Service
public class AccountProviderImpl implements AccountProvider {

    @Resource
    private AccountMapper accountMapper;

    @Override
    public void insertAccount() {
        AccountPo accountPo = new AccountPo();
        accountPo.setUserId(123);
        accountPo.setMoney(100);
        accountMapper.insert(accountPo);
    }
}
