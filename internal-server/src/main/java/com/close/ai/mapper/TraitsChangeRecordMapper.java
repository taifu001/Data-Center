package com.close.ai.mapper;

import com.close.ai.pojo.TraitsChangeRecord;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author nbwyctf
 * @since 2025-02-07
 */
@Mapper
public interface TraitsChangeRecordMapper {
    TraitsChangeRecord selectTraitsChangeRecordById(@Param("id") Long id);

    Integer insertTraitsChangeRecord(TraitsChangeRecord traitsChangeRecord);
}
