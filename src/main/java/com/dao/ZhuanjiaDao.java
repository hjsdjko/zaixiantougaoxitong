package com.dao;

import com.entity.ZhuanjiaEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.ZhuanjiaView;

/**
 * 专家 Dao 接口
 *
 * @since 2021-05-08
 */
public interface ZhuanjiaDao extends BaseMapper<ZhuanjiaEntity> {

   List<ZhuanjiaView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
