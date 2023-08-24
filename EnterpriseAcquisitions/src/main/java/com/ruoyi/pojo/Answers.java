package com.ruoyi.pojo;

import com.alibaba.fastjson2.annotation.JSONField;
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
     * 
     */
    private String picture;

    /**
     * 
     */
    private String text;

    /**
     * 
     */
    private String blank;

    /**
     * 
     */
    private String textblank;

    /**
     * 
     */
    private String singleChoice;

    /**
     * 
     */
    private String mutilChoice;

    /**
     * 
     */
    private Integer score;

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
        return (this.getExpId() == null ? other.getExpId() == null : this.getExpId().equals(other.getExpId()))
            && (this.getQuestionId() == null ? other.getQuestionId() == null : this.getQuestionId().equals(other.getQuestionId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getPicture() == null ? other.getPicture() == null : this.getPicture().equals(other.getPicture()))
            && (this.getText() == null ? other.getText() == null : this.getText().equals(other.getText()))
            && (this.getBlank() == null ? other.getBlank() == null : this.getBlank().equals(other.getBlank()))
            && (this.getTextblank() == null ? other.getTextblank() == null : this.getTextblank().equals(other.getTextblank()))
            && (this.getSingleChoice() == null ? other.getSingleChoice() == null : this.getSingleChoice().equals(other.getSingleChoice()))
            && (this.getMutilChoice() == null ? other.getMutilChoice() == null : this.getMutilChoice().equals(other.getMutilChoice()))
            && (this.getScore() == null ? other.getScore() == null : this.getScore().equals(other.getScore()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getExpId() == null) ? 0 : getExpId().hashCode());
        result = prime * result + ((getQuestionId() == null) ? 0 : getQuestionId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getPicture() == null) ? 0 : getPicture().hashCode());
        result = prime * result + ((getText() == null) ? 0 : getText().hashCode());
        result = prime * result + ((getBlank() == null) ? 0 : getBlank().hashCode());
        result = prime * result + ((getTextblank() == null) ? 0 : getTextblank().hashCode());
        result = prime * result + ((getSingleChoice() == null) ? 0 : getSingleChoice().hashCode());
        result = prime * result + ((getMutilChoice() == null) ? 0 : getMutilChoice().hashCode());
        result = prime * result + ((getScore() == null) ? 0 : getScore().hashCode());
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
        sb.append(", picture=").append(picture);
        sb.append(", text=").append(text);
        sb.append(", blank=").append(blank);
        sb.append(", textblank=").append(textblank);
        sb.append(", singleChoice=").append(singleChoice);
        sb.append(", mutilChoice=").append(mutilChoice);
        sb.append(", score=").append(score);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}