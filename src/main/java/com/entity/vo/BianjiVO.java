package com.entity.vo;

import com.entity.BianjiEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 编辑
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 * @email
 * @date 2021-05-08
 */
@TableName("bianji")
public class BianjiVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 账户
     */

    @TableField(value = "username")
    private String username;


    /**
     * 密码
     */

    @TableField(value = "password")
    private String password;


    /**
     * 编辑姓名  Search
     */

    @TableField(value = "bianji_name")
    private String bianjiName;


    /**
     * 性别
     */

    @TableField(value = "sex_types")
    private Integer sexTypes;


    /**
     * 稿件类型 Search
     */

    @TableField(value = "gaojian_types")
    private Integer gaojianTypes;


    /**
     * 身份证号
     */

    @TableField(value = "bianji_number")
    private String bianjiNumber;


    /**
     * 手机号
     */

    @TableField(value = "bianji_phone")
    private String bianjiPhone;


    /**
     * 邮箱
     */

    @TableField(value = "bianji_email")
    private String bianjiEmail;


    /**
     * 照片
     */

    @TableField(value = "bianji_photo")
    private String bianjiPhoto;


    /**
     * 创建时间 
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
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
	 * 设置：编辑姓名  Search
	 */
    public String getBianjiName() {
        return bianjiName;
    }


    /**
	 * 获取：编辑姓名  Search
	 */

    public void setBianjiName(String bianjiName) {
        this.bianjiName = bianjiName;
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
    public String getBianjiNumber() {
        return bianjiNumber;
    }


    /**
	 * 获取：身份证号
	 */

    public void setBianjiNumber(String bianjiNumber) {
        this.bianjiNumber = bianjiNumber;
    }
    /**
	 * 设置：手机号
	 */
    public String getBianjiPhone() {
        return bianjiPhone;
    }


    /**
	 * 获取：手机号
	 */

    public void setBianjiPhone(String bianjiPhone) {
        this.bianjiPhone = bianjiPhone;
    }
    /**
	 * 设置：邮箱
	 */
    public String getBianjiEmail() {
        return bianjiEmail;
    }


    /**
	 * 获取：邮箱
	 */

    public void setBianjiEmail(String bianjiEmail) {
        this.bianjiEmail = bianjiEmail;
    }
    /**
	 * 设置：照片
	 */
    public String getBianjiPhoto() {
        return bianjiPhoto;
    }


    /**
	 * 获取：照片
	 */

    public void setBianjiPhoto(String bianjiPhoto) {
        this.bianjiPhoto = bianjiPhoto;
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
