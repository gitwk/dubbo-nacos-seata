package com.wk.seata.storage.mapper;

import com.wk.seata.storage.db.StoragePo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectKey;

/**
 * @author wangkai
 * @since JDK8
 */
@Mapper
public interface StorageMapper {

//    @SelectKey(before = true,resultType = Integer.class,keyProperty = "id",keyColumn = "id",statement = "SELECT LAST_INSERT_ID()")
    @Insert("INSERT INTO `storage_tbl` (`commodity_code`, `count`) VALUES (#{commodityCode}, #{count})")
    void insert(StoragePo storagePo);
}
