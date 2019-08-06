package com.wk.seata.account.mapper;

import com.wk.seata.account.db.AccountPo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectKey;

/**
 * @author wangkai
 * @since JDK8
 */
@Mapper
public interface AccountMapper {

//    @SelectKey(before = true, resultType = Integer.class, keyProperty = "id", keyColumn = "id", statement = "SELECT LAST_INSERT_ID()")
    @Insert("INSERT INTO `account_tbl` (`user_id`, `money`) VALUES (#{userId}, #{money})")
    void insert(AccountPo accountPo);
}
