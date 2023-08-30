package com.ruoyi.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

/**
 * 实验表
 * @TableName experiment
 */
@TableName(value ="experiment")
@Data
public class Experiment implements Serializable {
    /**
     * 实验id也是本用户的第几次实验
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
     * 开始时间
     */
    private Date startTime;

    /**
     * 结束时间
     */
    private Date endTime;

    /**
     *
     */
    private BigDecimal objectiveScore;

    /**
     *
     */
    private BigDecimal subjectiveScore;

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
        Experiment other = (Experiment) that;
        return (this.getExpId() == null ? other.getExpId() == null : this.getExpId().equals(other.getExpId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getStartTime() == null ? other.getStartTime() == null : this.getStartTime().equals(other.getStartTime()))
            && (this.getEndTime() == null ? other.getEndTime() == null : this.getEndTime().equals(other.getEndTime()))
            && (this.getObjectiveScore() == null ? other.getObjectiveScore() == null : this.getObjectiveScore().equals(other.getObjectiveScore()))
            && (this.getSubjectiveScore() == null ? other.getSubjectiveScore() == null : this.getSubjectiveScore().equals(other.getSubjectiveScore()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getExpId() == null) ? 0 : getExpId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getStartTime() == null) ? 0 : getStartTime().hashCode());
        result = prime * result + ((getEndTime() == null) ? 0 : getEndTime().hashCode());
        result = prime * result + ((getObjectiveScore() == null) ? 0 : getObjectiveScore().hashCode());
        result = prime * result + ((getSubjectiveScore() == null) ? 0 : getSubjectiveScore().hashCode());
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
        sb.append(", startTime=").append(startTime);
        sb.append(", endTime=").append(endTime);
        sb.append(", objectiveScore=").append(objectiveScore);
        sb.append(", subjectiveScore=").append(subjectiveScore);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
