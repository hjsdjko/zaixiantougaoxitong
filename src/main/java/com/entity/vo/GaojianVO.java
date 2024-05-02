package com.entity.vo;

import com.entity.GaojianEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 稿件信息
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 * @email
 * @date 2021-05-08
 */
@TableName("gaojian")
public class GaojianVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 稿件标题 Search
     */

    @TableField(value = "gaojian_name")
    private String gaojianName;


    /**
     * 稿件类型 Search
     */

    @TableField(value = "gaojian_types")
    private Integer gaojianTypes;


    /**
     * 上传时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
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
     * 稿件状态 Search
     */

    @TableField(value = "zhuangtai_types")
    private Integer zhuangtaiTypes;


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
	 * 设置：稿件标题 Search
	 */
    public String getGaojianName() {
        return gaojianName;
    }


    /**
	 * 获取：稿件标题 Search
	 */

    public void setGaojianName(String gaojianName) {
        this.gaojianName = gaojianName;
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
	 * 设置：稿件状态 Search
	 */
    public Integer getZhuangtaiTypes() {
        return zhuangtaiTypes;
    }


    /**
	 * 获取：稿件状态 Search
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

}
