package com.entity.view;

import com.entity.GaojianEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;

/**
 * 稿件信息
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @email
 * @date 2021-05-08
 */
@TableName("gaojian")
public class GaojianView extends GaojianEntity implements Serializable {
    private static final long serialVersionUID = 1L;

	public GaojianView() {

	}

	public GaojianView(GaojianEntity gaojianEntity) {
		try {
			BeanUtils.copyProperties(this, gaojianEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
