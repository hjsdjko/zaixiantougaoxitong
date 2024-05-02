package com.service;

import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.BianjiEntity;
import java.util.Map;

/**
 * 编辑 服务类
 * @since 2021-05-08
 */
public interface BianjiService extends IService<BianjiEntity> {

     PageUtils queryPage(Map<String, Object> params);

}