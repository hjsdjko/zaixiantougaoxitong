package com.entity.model;

import com.entity.ZhuanjiaEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 专家
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 * @email
 * @date 2021-05-08
 */
public class ZhuanjiaModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 账户
     */
    private String username;


    /**
     * 密码
     */
    private String password;


    /**
     * 专家姓名  Search
     */
    private String zhuanjiaName;


    /**
     * 性别
     */
    private Integer sexTypes;


    /**
     * 稿件类型 Search
     */
    private Integer gaojianTypes;


    /**
     * 身份证号
     */
    private String zhuanjiaNumber;


    /**
     * 手机号
     */
    private String zhuanjiaPhone;


    /**
     * 邮箱
     */
    private String zhuanjiaEmail;


    /**
     * 照片
     */
    private String zhuanjiaPhoto;


    /**
     * 创建时间 
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：账户
	 */
    public String getUsername() {
        return username;
    }


    /**
	 * 获取：账户
	 */

    public void setUsername(String username) {
        this.username = username;
    }
    /**
	 * 设置：密码
	 */
    public String getPassword() {
        return password;
    }


    /**
	 * 获取：密码
	 */

    public void setPassword(String password) {
        this.password = password;
    }
    /**
	 * 设置：专家姓名  Search
	 */
    public String getZhuanjiaName() {
        return zhuanjiaName;
    }


    /**
	 * 获取：专家姓名  Search
	 */

    public void setZhuanjiaName(String zhuanjiaName) {
        this.zhuanjiaName = zhuanjiaName;
    }
    /**
	 * 设置：性别
	 */
    public Integer getSexTypes() {
        return sexTypes;
    }


    /**
	 * 获取：性别
	 */

    public void setSexTypes(Integer sexTypes) {
        this.sexTypes = sexTypes;
    }
    /**
	 * 设置：稿件类型 Search
	 */
    public Integer getGaojianTypes() {
        return gaojianTypes;
    }


    /**
	 * 获取：稿件类型 Search
	 */

    public void setGaojianTypes(Integer gaojianTypes) {
        this.gaojianTypes = gaojianTypes;
    }
    /**
	 * 设置：身份证号
	 */
    public String getZhuanjiaNumber() {
        return zhuanjiaNumber;
    }


    /**
	 * 获取：身份证号
	 */

    public void setZhuanjiaNumber(String zhuanjiaNumber) {
        this.zhuanjiaNumber = zhuanjiaNumber;
    }
    /**
	 * 设置：手机号
	 */
    public String getZhuanjiaPhone() {
        return zhuanjiaPhone;
    }


    /**
	 * 获取：手机号
	 */

    public void setZhuanjiaPhone(String zhuanjiaPhone) {
        this.zhuanjiaPhone = zhuanjiaPhone;
    }
    /**
	 * 设置：邮箱
	 */
    public String getZhuanjiaEmail() {
        return zhuanjiaEmail;
    }


    /**
	 * 获取：邮箱
	 */

    public void setZhuanjiaEmail(String zhuanjiaEmail) {
        this.zhuanjiaEmail = zhuanjiaEmail;
    }
    /**
	 * 设置：照片
	 */
    public String getZhuanjiaPhoto() {
        return zhuanjiaPhoto;
    }


    /**
	 * 获取：照片
	 */

    public void setZhuanjiaPhoto(String zhuanjiaPhoto) {
        this.zhuanjiaPhoto = zhuanjiaPhoto;
    }
    /**
	 * 设置：创建时间 
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间 
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
