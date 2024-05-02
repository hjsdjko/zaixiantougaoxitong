package com.controller;

import java.text.SimpleDateFormat;
import java.util.*;
import javax.servlet.http.HttpServletRequest;

import com.annotation.IgnoreAuth;
import com.entity.ZhuanjiaEntity;
import com.service.TokenService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;

import com.entity.BianjiEntity;

import com.service.BianjiService;
import com.utils.PageUtils;
import com.utils.R;

/**
 * 编辑
 * 后端接口
 * @author
 * @email
 * @date 2021-05-08
*/
@RestController
@Controller
@RequestMapping("/bianji")
public class BianjiController {
    private static final Logger logger = LoggerFactory.getLogger(BianjiController.class);

    @Autowired
    private BianjiService bianjiService;
    @Autowired
    private TokenService tokenService;

    /**
     * 登录
     */
    @IgnoreAuth
    @RequestMapping(value = "/login")
    public R login(String username, String password, String captcha, HttpServletRequest request) {
        BianjiEntity user = bianjiService.selectOne(new EntityWrapper<BianjiEntity>().eq("username", username));
        if(user==null || !user.getPassword().equals(password)) {
            return R.error("账号或密码不正确");
        }
        String token = tokenService.generateToken(user.getId(),username, "users", "编辑");
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
        BianjiEntity user = bianjiService.selectById(id);
        return R.ok().put("data", user);
    }



    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params){
        logger.debug("Controller:"+this.getClass().getName()+",page方法");
        PageUtils page = bianjiService.queryPage(params);
        return R.ok().put("data", page);
    }
    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        logger.debug("Controller:"+this.getClass().getName()+",info方法");
        BianjiEntity bianji = bianjiService.selectById(id);
        if(bianji!=null){
            return R.ok().put("data", bianji);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody BianjiEntity bianji, HttpServletRequest request){
        logger.debug("Controller:"+this.getClass().getName()+",save");
        Wrapper<BianjiEntity> queryWrapper = new EntityWrapper<BianjiEntity>()
            .eq("username", bianji.getUsername())
            .eq("password", bianji.getPassword())
            .eq("bianji_name", bianji.getBianjiName())
            .eq("sex_types", bianji.getSexTypes())
            .eq("gaojian_types", bianji.getGaojianTypes())
            .eq("bianji_number", bianji.getBianjiNumber())
            .eq("bianji_phone", bianji.getBianjiPhone())
            .eq("bianji_email", bianji.getBianjiEmail())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        BianjiEntity bianjiEntity = bianjiService.selectOne(queryWrapper);
        if("".equals(bianji.getBianjiPhoto()) || "null".equals(bianji.getBianjiPhoto())){
            bianji.setBianjiPhoto(null);
        }
        if(bianjiEntity==null){
            bianjiService.insert(bianji);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody BianjiEntity bianji, HttpServletRequest request){
        logger.debug("Controller:"+this.getClass().getName()+",update");
        //根据字段查询是否有相同数据
        Wrapper<BianjiEntity> queryWrapper = new EntityWrapper<BianjiEntity>()
            .notIn("id",bianji.getId())
            .eq("username", bianji.getUsername())
            .eq("password", bianji.getPassword())
            .eq("bianji_name", bianji.getBianjiName())
            .eq("sex_types", bianji.getSexTypes())
            .eq("gaojian_types", bianji.getGaojianTypes())
            .eq("bianji_number", bianji.getBianjiNumber())
            .eq("bianji_phone", bianji.getBianjiPhone())
            .eq("bianji_email", bianji.getBianjiEmail())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        BianjiEntity bianjiEntity = bianjiService.selectOne(queryWrapper);
        if("".equals(bianji.getBianjiPhoto()) || "null".equals(bianji.getBianjiPhoto())){
                bianji.setBianjiPhoto(null);
        }
        if(bianjiEntity==null){
            bianjiService.updateById(bianji);//根据id更新
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
        bianjiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
}

