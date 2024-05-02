package com.controller;

import java.text.SimpleDateFormat;
import java.util.*;
import javax.servlet.http.HttpServletRequest;

import com.annotation.IgnoreAuth;
import com.entity.UserEntity;
import com.service.TokenService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;

import com.entity.ZhuanjiaEntity;

import com.service.ZhuanjiaService;
import com.utils.PageUtils;
import com.utils.R;

/**
 * 专家
 * 后端接口
 * @author
 * @email
 * @date 2021-05-08
*/
@RestController
@Controller
@RequestMapping("/zhuanjia")
public class ZhuanjiaController {
    private static final Logger logger = LoggerFactory.getLogger(ZhuanjiaController.class);

    @Autowired
    private ZhuanjiaService zhuanjiaService;
    @Autowired
    private TokenService tokenService;

    /**
     * 登录
     */
    @IgnoreAuth
    @RequestMapping(value = "/login")
    public R login(String username, String password, String captcha, HttpServletRequest request) {
        ZhuanjiaEntity user = zhuanjiaService.selectOne(new EntityWrapper<ZhuanjiaEntity>().eq("username", username));
        if(user==null || !user.getPassword().equals(password)) {
            return R.error("账号或密码不正确");
        }
        String token = tokenService.generateToken(user.getId(),username, "users", "专家");
        return R.ok().put("token", token);
    }

    /**
     * 退出
     */
    @RequestMapping(value = "logout")
    public R logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return R.ok("退出成功");
    }


    /**
     * 获取用户的session用户信息
     */
    @RequestMapping("/session")
    public R getCurrUser(HttpServletRequest request){
        Integer id = (Integer)request.getSession().getAttribute("userId");
        ZhuanjiaEntity user = zhuanjiaService.selectById(id);
        return R.ok().put("data", user);
    }



    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params){
        logger.debug("Controller:"+this.getClass().getName()+",page方法");
        PageUtils page = zhuanjiaService.queryPage(params);
        return R.ok().put("data", page);
    }
    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        logger.debug("Controller:"+this.getClass().getName()+",info方法");
        ZhuanjiaEntity zhuanjia = zhuanjiaService.selectById(id);
        if(zhuanjia!=null){
            return R.ok().put("data", zhuanjia);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody ZhuanjiaEntity zhuanjia, HttpServletRequest request){
        logger.debug("Controller:"+this.getClass().getName()+",save");
        Wrapper<ZhuanjiaEntity> queryWrapper = new EntityWrapper<ZhuanjiaEntity>()
            .eq("username", zhuanjia.getUsername())
            .eq("password", zhuanjia.getPassword())
            .eq("zhuanjia_name", zhuanjia.getZhuanjiaName())
            .eq("sex_types", zhuanjia.getSexTypes())
            .eq("gaojian_types", zhuanjia.getGaojianTypes())
            .eq("zhuanjia_number", zhuanjia.getZhuanjiaNumber())
            .eq("zhuanjia_phone", zhuanjia.getZhuanjiaPhone())
            .eq("zhuanjia_email", zhuanjia.getZhuanjiaEmail())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ZhuanjiaEntity zhuanjiaEntity = zhuanjiaService.selectOne(queryWrapper);
        if("".equals(zhuanjia.getZhuanjiaPhoto()) || "null".equals(zhuanjia.getZhuanjiaPhoto())){
            zhuanjia.setZhuanjiaPhoto(null);
        }
        if(zhuanjiaEntity==null){
            zhuanjiaService.insert(zhuanjia);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody ZhuanjiaEntity zhuanjia, HttpServletRequest request){
        logger.debug("Controller:"+this.getClass().getName()+",update");
        //根据字段查询是否有相同数据
        Wrapper<ZhuanjiaEntity> queryWrapper = new EntityWrapper<ZhuanjiaEntity>()
            .notIn("id",zhuanjia.getId())
            .eq("username", zhuanjia.getUsername())
            .eq("password", zhuanjia.getPassword())
            .eq("zhuanjia_name", zhuanjia.getZhuanjiaName())
            .eq("sex_types", zhuanjia.getSexTypes())
            .eq("gaojian_types", zhuanjia.getGaojianTypes())
            .eq("zhuanjia_number", zhuanjia.getZhuanjiaNumber())
            .eq("zhuanjia_phone", zhuanjia.getZhuanjiaPhone())
            .eq("zhuanjia_email", zhuanjia.getZhuanjiaEmail())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ZhuanjiaEntity zhuanjiaEntity = zhuanjiaService.selectOne(queryWrapper);
        if("".equals(zhuanjia.getZhuanjiaPhoto()) || "null".equals(zhuanjia.getZhuanjiaPhoto())){
                zhuanjia.setZhuanjiaPhoto(null);
        }
        if(zhuanjiaEntity==null){
            zhuanjiaService.updateById(zhuanjia);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }


    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        logger.debug("Controller:"+this.getClass().getName()+",delete");
        zhuanjiaService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
}

