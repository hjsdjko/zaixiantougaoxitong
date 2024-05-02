package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * 稿件信息
 *
 * @email
 * @date 2021-05-08
 */
@TableName("gaojian")
public class GaojianEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


    public GaojianEntity() {

    }

    public GaojianEntity(T t) {
    try {
    BeanUtils.copyProperties(this, t);
    } catch (IllegalAccessException | InvocationTargetException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
    }
    }


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @TableField(value = "id")

    private Integer id;


    /**
     * 稿件标题
     */
    @TableField(value = "gaojian_name")

    private String gaojianName;


    /**
     * 稿件类型
     */
    @TableField(value = "gaojian_types")

    private Integer gaojianTypes;


    /**
     * 上传时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 上传用户
     */
    @TableField(value = "yonghu_types")

    private Integer yonghuTypes;


    /**
     * 文件
     */
    @TableField(value = "gaojian_file")

    private String gaojianFile;


    /**
     * 初审结果
     */
    @TableField(value = "chushen_content")

    private String chushenContent;


    /**
     * 复审结果
     */
    @TableField(value = "fushen_content")

    private String fushenContent;


    /**
     * 稿件状态
     */
    @TableField(value = "zhuangtai_types")

    private Integer zhuangtaiTypes;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "create_time",fill = FieldFill.INSERT)

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
	 * 设置：稿件标题
	 */
    public String getGaojianName() {
        return gaojianName;
    }


    /**
	 * 获取：稿件标题
	 */

    public void setGaojianName(String gaojianName) {
        this.gaojianName = gaojianName;
    }
    /**
	 * 设置：稿件类型
	 */
    public Integer getGaojianTypes() {
        return gaojianTypes;
    }


    /**
	 * 获取：稿件类型
	 */

    public void setGaojianTypes(Integer gaojianTypes) {
        this.gaojianTypes = gaojianTypes;
    }
    /**
	 * 设置：上传时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：上传时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：上传用户
	 */
    public Integer getYonghuTypes() {
        return yonghuTypes;
    }


    /**
	 * 获取：上传用户
	 */

    public void setYonghuTypes(Integer yonghuTypes) {
        this.yonghuTypes = yonghuTypes;
    }
    /**
	 * 设置：文件
	 */
    public String getGaojianFile() {
        return gaojianFile;
    }


    /**
	 * 获取：文件
	 */

    public void setGaojianFile(String gaojianFile) {
        this.gaojianFile = gaojianFile;
    }
    /**
	 * 设置：初审结果
	 */
    public String getChushenContent() {
        return chushenContent;
    }


    /**
	 * 获取：初审结果
	 */

    public void setChushenContent(String chushenContent) {
        this.chushenContent = chushenContent;
    }
    /**
	 * 设置：复审结果
	 */
    public String getFushenContent() {
        return fushenContent;
    }


    /**
	 * 获取：复审结果
	 */

    public void setFushenContent(String fushenContent) {
        this.fushenContent = fushenContent;
    }
    /**
	 * 设置：稿件状态
	 */
    public Integer getZhuangtaiTypes() {
        return zhuangtaiTypes;
    }


    /**
	 * 获取：稿件状态
	 */

    public void setZhuangtaiTypes(Integer zhuangtaiTypes) {
        this.zhuangtaiTypes = zhuangtaiTypes;
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

    @Override
    public String toString() {
    return "Gaojian{" +
            "id=" + id +
            ", gaojianName=" + gaojianName +
            ", gaojianTypes=" + gaojianTypes +
            ", insertTime=" + insertTime +
            ", yonghuTypes=" + yonghuTypes +
            ", gaojianFile=" + gaojianFile +
            ", chushenContent=" + chushenContent +
            ", fushenContent=" + fushenContent +
            ", zhuangtaiTypes=" + zhuangtaiTypes +
            ", createTime=" + createTime +
    "}";
    }
    }
