package com.controller;

import java.text.SimpleDateFormat;
import java.util.*;
import javax.servlet.http.HttpServletRequest;

import com.entity.BianjiEntity;
import com.entity.ZhuanjiaEntity;
import com.service.BianjiService;
import com.service.ZhuanjiaService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;

import com.entity.GaojianEntity;

import com.service.GaojianService;
import com.utils.PageUtils;
import com.utils.R;

/**
 * 稿件信息
 * 后端接口
 * @author
 * @email
 * @date 2021-05-08
*/
@RestController
@Controller
@RequestMapping("/gaojian")
public class GaojianController {
    private static final Logger logger = LoggerFactory.getLogger(GaojianController.class);

    @Autowired
    private GaojianService gaojianService;

    @Autowired
    private ZhuanjiaService zhuanjiaService;

    @Autowired
    private BianjiService bianjiService;

    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("Controller:"+this.getClass().getName()+",page方法");
        String role = (String) request.getSession().getAttribute("role");
        if(StringUtils.isNotBlank(role) && role.equals("用户")){
            params.put("yonghuTypes",request.getSession().getAttribute("userId"));
        }else if(StringUtils.isNotBlank(role) && role.equals("编辑")){
            params.put("gaojianTypes",bianjiService.selectById((Integer) request.getSession().getAttribute("userId")).getGaojianTypes());
        }else if(StringUtils.isNotBlank(role) && role.equals("专家")){
            params.put("gaojianTypes",zhuanjiaService.selectById((Integer) request.getSession().getAttribute("userId")).getGaojianTypes());
        }
        PageUtils page = gaojianService.queryPage(params);
        return R.ok().put("data", page);
    }
    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        logger.debug("Controller:"+this.getClass().getName()+",info方法");
        GaojianEntity gaojian = gaojianService.selectById(id);
        if(gaojian!=null){
            return R.ok().put("data", gaojian);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody GaojianEntity gaojian, HttpServletRequest request){
        logger.debug("Controller:"+this.getClass().getName()+",save");
		gaojian.setZhuangtaiTypes(1);
        Wrapper<GaojianEntity> queryWrapper = new EntityWrapper<GaojianEntity>()
            .eq("gaojian_name", gaojian.getGaojianName())
            .eq("gaojian_types", gaojian.getGaojianTypes())
            .eq("yonghu_types", gaojian.getYonghuTypes())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        GaojianEntity gaojianEntity = gaojianService.selectOne(queryWrapper);
            gaojian.setInsertTime(new Date());
        if("".equals(gaojian.getGaojianFile()) || "null".equals(gaojian.getGaojianFile())){
            gaojian.setGaojianFile(null);
        }
        if(gaojianEntity==null){
            gaojianService.insert(gaojian);
            return R.ok();
        }else {
            return R.error(511,"已经添加过了");
        }
    }

    /**
    * 修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody GaojianEntity gaojian, HttpServletRequest request){
        logger.debug("Controller:"+this.getClass().getName()+",update");
        //根据字段查询是否有相同数据
        Wrapper<GaojianEntity> queryWrapper = new EntityWrapper<GaojianEntity>()
            .notIn("id",gaojian.getId())
            .eq("gaojian_name", gaojian.getGaojianName())
            .eq("gaojian_types", gaojian.getGaojianTypes())
            .eq("yonghu_types", gaojian.getYonghuTypes())
            .eq("chushen_content", gaojian.getChushenContent())
            .eq("fushen_content", gaojian.getFushenContent())
            .eq("zhuangtai_types", gaojian.getZhuangtaiTypes())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        GaojianEntity gaojianEntity = gaojianService.selectOne(queryWrapper);
                gaojian.setInsertTime(new Date());
        if("".equals(gaojian.getGaojianFile()) || "null".equals(gaojian.getGaojianFile())){
                gaojian.setGaojianFile(null);
        }
        if(gaojianEntity==null){
            gaojianService.updateById(gaojian);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }


    /**
    * 删除
    */
    @RequestMapping("/shenhe")
    public R shenhe(Integer id,Integer shenhe ,String jieguo){
        GaojianEntity gaojian = gaojianService.selectById(id);
        if(shenhe == 2){
            gaojian.setChushenContent("初审通过");
        }else if(shenhe == 3){
            gaojian.setChushenContent(jieguo);
        }else if(shenhe == 4){
            gaojian.setFushenContent("复审通过");
        }else if(shenhe == 5){
            gaojian.setFushenContent(jieguo);
        }
        gaojian.setZhuangtaiTypes(shenhe);
        boolean b = gaojianService.updateById(gaojian);
        if(b){
            return R.ok();
        }
        return R.error();
    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        logger.debug("Controller:"+this.getClass().getName()+",delete");
        gaojianService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
}

