package com.zkw.springboot_project.dao;

import com.zkw.springboot_project.entity.IndicatorOne;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IndicatorOneDao {

    //获取所有一级指标信息
    @Select("SELECT * FROM indicator_info1 WHERE findicname like #{findicname} LIMIT #{pageStart},#{pageSize}")
    List<IndicatorOne> getAllIndicatorOne(@Param("findicname") String findicname,@Param("pageStart") int pageStart, @Param("pageSize") int pageSize);

    //获取一级指标条目数
    @Select("SELECT count(*) FROM indicator_info1 WHERE findicname like #{findicname}")
    int getIndicatorOneCounts(@Param("findicname") String findicname);

    //获取选中的一级指标的全部内容信息
    @Select("SELECT * FROM indicator_info1 WHERE findicname = #{findicname}")
    IndicatorOne getUpdateIndicatorOne(@Param("findicname") String findicname);

    //添加一级指标
    @Insert("INSERT INTO indicator_info1 (fid,findicname,findicdes) VALUE (#{fid},#{findicname},#{findicdes})")
    int addIndicatorOne(IndicatorOne indicatorOne);

    //删除一级指标
    @Delete("DELETE FROM indicator_info1 WHERE findicname = #{findicname}")
    int deleteIndicatorOne(@Param("findicname") String findicname);

    //根据一级指标名称更新一级指标
    @Update("UPDATE indicator_info1 SET findicdes = #{findicdes} WHERE findicname = #{findicname}")
    int editIndicatorOne(IndicatorOne indicatorOne);

}
