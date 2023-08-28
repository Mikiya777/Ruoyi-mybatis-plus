package com.ruoyi.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 作答记录
 * @TableName answers
 */
@TableName(value ="answers")
@Data
public class Answers implements Serializable {
    /**
     * 实验id也是本用户的第几次实验
     */
    @TableId
    private Integer expId;

    /**
     * 作答顺序
     */
    @TableId
    private Integer questionId;

    /**
     * 
     */
    @TableId
    private Long userId;

    /**
     * 作答内容
     */
    private String answer;

    /**
     * 页面id
     */
    private String id;

    /**
     * 下一页id
     */
    private String nextId;

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
        Answers other = (Answers) that;
        return
            (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getNextId() == null ? other.getNextId() == null : this.getNextId().equals(other.getNextId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getExpId() == null) ? 0 : getExpId().hashCode());
        result = prime * result + ((getQuestionId() == null) ? 0 : getQuestionId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getAnswer() == null) ? 0 : getAnswer().hashCode());
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getNextId() == null) ? 0 : getNextId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", expId=").append(expId);
        sb.append(", questionId=").append(questionId);
        sb.append(", userId=").append(userId);
        sb.append(", answer=").append(answer);
        sb.append(", id=").append(id);
        sb.append(", nextId=").append(nextId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}