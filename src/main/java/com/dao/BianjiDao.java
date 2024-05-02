package com.dao;

import com.entity.BianjiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.BianjiView;

/**
 * 编辑 Dao 接口
 *
 * @since 2021-05-08
 */
public interface BianjiDao extends BaseMapper<BianjiEntity> {

   List<BianjiView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
