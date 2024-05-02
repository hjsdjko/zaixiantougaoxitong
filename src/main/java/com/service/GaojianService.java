package com.service;

import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.GaojianEntity;
import java.util.Map;

/**
 * 稿件信息 服务类
 * @since 2021-05-08
 */
public interface GaojianService extends IService<GaojianEntity> {

     PageUtils queryPage(Map<String, Object> params);

}