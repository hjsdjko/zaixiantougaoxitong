package com.service;

import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ZhuanjiaEntity;
import java.util.Map;

/**
 * 专家 服务类
 * @since 2021-05-08
 */
public interface ZhuanjiaService extends IService<ZhuanjiaEntity> {

     PageUtils queryPage(Map<String, Object> params);

}