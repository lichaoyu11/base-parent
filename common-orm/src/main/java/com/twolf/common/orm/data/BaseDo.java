package com.twolf.common.orm.data;

import java.time.LocalDateTime;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.extension.activerecord.Model;

/**
 * 数据库基本字段
 * @Author lcy
 * @Date 2021/4/13 17:59
 */
public class BaseDo<T extends Model<?>> extends Model<T> {

    /**
     * 逻辑删除标志,0-未删除，1-已删除
     */
    @TableField(fill = FieldFill.INSERT)
    @TableLogic
    protected Integer isDelete;

    /**
     * 创建人
     */
    @TableField(fill = FieldFill.INSERT)
    protected String createBy;

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    protected LocalDateTime createTime;

    /**
     * 最后修改人
     */
    @TableField(fill = FieldFill.UPDATE)
    protected String updateBy;

    /**
     * 最后修改时间
     */
    @TableField(fill = FieldFill.UPDATE)
    protected LocalDateTime updateTime;

    public BaseDo(){
    }

    public BaseDo(Integer isDelete,String createBy,LocalDateTime createTime,String updateBy,LocalDateTime updateTime){
        this.isDelete = isDelete;
        this.createBy = createBy;
        this.createTime = createTime;
        this.updateBy = updateBy;
        this.updateTime = updateTime;
    }

    public Integer getIsDelete(){
        return isDelete;
    }

    public BaseDo<T> setIsDelete(Integer isDelete){
        this.isDelete = isDelete;
        return this;
    }

    public String getCreateBy(){
        return createBy;
    }

    public BaseDo<T> setCreateBy(String createBy){
        this.createBy = createBy;
        return this;
    }

    public LocalDateTime getCreateTime(){
        return createTime;
    }

    public BaseDo<T> setCreateTime(LocalDateTime createTime){
        this.createTime = createTime;
        return this;
    }

    public String getUpdateBy(){
        return updateBy;
    }

    public BaseDo<T> setUpdateBy(String updateBy){
        this.updateBy = updateBy;
        return this;
    }

    public LocalDateTime getUpdateTime(){
        return updateTime;
    }

    public BaseDo<T> setUpdateTime(LocalDateTime updateTime){
        this.updateTime = updateTime;
        return this;
    }

    @Override public String toString(){
        return "BaseDo{" +
                "isDelete=" + isDelete +
                ", createBy='" + createBy + '\'' +
                ", createTime=" + createTime +
                ", updateBy='" + updateBy + '\'' +
                ", updateTime=" + updateTime +
                '}';
    }
}
