package com.zrdh.dao.nbUser;

import com.zrdh.entity.AlarmConditions;
import com.zrdh.pojo.nbUser.VmAmeterRlgs;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Description: cti-link-dataAnalysis
 * Created by hua on 2020/3/30 13:51
 */
public interface VmAmeterRlgsMapper {

    @Select("select  * from Vw_ameter_data_to_rlgs where Meter_no = #{meterNo}")
    VmAmeterRlgs selectByMeterNo(@Param("meterNo") String meterNo);

    /**
     *根据报警信息查询
     * @param alarmConditions
     * @return
     */
    List<VmAmeterRlgs> selectByAlarmConditions(AlarmConditions alarmConditions);
}
