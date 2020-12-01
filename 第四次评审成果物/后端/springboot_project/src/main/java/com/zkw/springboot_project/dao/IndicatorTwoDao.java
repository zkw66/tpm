package com.zkw.springboot_project.dao;
import com.zkw.springboot_project.entity.IndicatorTwo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IndicatorTwoDao {

    //获取所有二级指标信息
    @Select("SELECT * FROM indicator_info2 WHERE sindicname like #{sindicname} LIMIT #{pageStart},#{pageSize}")
    List<IndicatorTwo> getAllIndicatorTwo(@Param("sindicname") String sindicname, @Param("pageStart") int pageStart, @Param("pageSize") int pageSize);

    //获取二级指标条目数
    @Select("SELECT count(*) FROM indicator_info2 WHERE sindicname like #{sindicname}")
    int getIndicatorTwoCounts(@Param("sindicname") String sindicname);

    //获取选中的二级指标的全部内容信息
    @Select("SELECT * FROM indicator_info2 WHERE sindicname = #{sindicname}")
    IndicatorTwo getUpdateIndicatorTwo(@Param("sindicname") String sindicname);

    //添加二级指标
    @Insert("INSERT INTO indicator_info2 (fid,sid,sindicname,sindicdes) VALUE (#{fid},#{sid},#{sindicname},#{sindicdes})")
    int addIndicatorTwo(IndicatorTwo indicatorTwo);

    //删除二级指标
    @Delete("DELETE FROM indicator_info2 WHERE sindicname = #{sindicname}")
    int deleteIndicatorTwo(@Param("sindicname") String sindicname);

    //根据二级指标名称更新二级指标
    @Update("UPDATE indicator_info2 SET sindicdes = #{sindicdes} WHERE sindicname = #{sindicname}")
    int editIndicatorTwo(IndicatorTwo indicatorTwo);

}
