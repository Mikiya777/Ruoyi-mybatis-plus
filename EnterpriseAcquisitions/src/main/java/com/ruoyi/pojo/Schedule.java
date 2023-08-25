package com.ruoyi.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 演练进度
 * @TableName schedule
 */
@TableName(value ="schedule")
@Data
public class Schedule implements Serializable {
    /**
     * 
     */
    @TableId
    private Integer expId;

    /**
     * 
     */
    @TableId
    private Long userId;

    /**
     * 0未完成，1已提交
     */
    private Boolean status;

    /**
     * 总分
     */
    private Integer sumScore;

    /**
     * 
     */
    private Long pageInfoId;

    /**
     * 
     */
    private Date startTime;

    /**
     * 
     */
    private Date endTime;

    private PageInfo pageInfo;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Schedule other = (Schedule) that;
        return (this.getExpId() == null ? other.getExpId() == null : this.getExpId().equals(other.getExpId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getSumScore() == null ? other.getSumScore() == null : this.getSumScore().equals(other.getSumScore()))
            && (this.getPageInfoId() == null ? other.getPageInfoId() == null : this.getPageInfoId().equals(other.getPageInfoId()))
            && (this.getStartTime() == null ? other.getStartTime() == null : this.getStartTime().equals(other.getStartTime()))
            && (this.getEndTime() == null ? other.getEndTime() == null : this.getEndTime().equals(other.getEndTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getExpId() == null) ? 0 : getExpId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getSumScore() == null) ? 0 : getSumScore().hashCode());
        result = prime * result + ((getPageInfoId() == null) ? 0 : getPageInfoId().hashCode());
        result = prime * result + ((getStartTime() == null) ? 0 : getStartTime().hashCode());
        result = prime * result + ((getEndTime() == null) ? 0 : getEndTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", expId=").append(expId);
        sb.append(", userId=").append(userId);
        sb.append(", status=").append(status);
        sb.append(", sumScore=").append(sumScore);
        sb.append(", pageInfoId=").append(pageInfoId);
        sb.append(", startTime=").append(startTime);
        sb.append(", endTime=").append(endTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}