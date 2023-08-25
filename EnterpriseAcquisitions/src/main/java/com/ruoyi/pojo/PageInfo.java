package com.ruoyi.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 页面信息-用于完成继续实验的跳转功能
 * @TableName page_info
 */
@TableName(value ="page_info")
@Data
public class PageInfo implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Long pageInfoId;

    /**
     * 
     */
    private String friendbodystring;

    /**
     * 
     */
    private String payway;

    /**
     * 
     */
    private Integer controlnumber;

    /**
     * 
     */
    private Integer friendnumber;

    /**
     * 
     */
    private Integer friendsing;

    /**
     * 
     */
    private Integer isplaying;

    /**
     * 
     */
    private String randomstring;

    /**
     * 
     */
    private String workstring;

    /**
     * 
     */
    private Integer worksing;

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
        PageInfo other = (PageInfo) that;
        return (this.getPageInfoId() == null ? other.getPageInfoId() == null : this.getPageInfoId().equals(other.getPageInfoId()))
            && (this.getFriendbodystring() == null ? other.getFriendbodystring() == null : this.getFriendbodystring().equals(other.getFriendbodystring()))
            && (this.getPayway() == null ? other.getPayway() == null : this.getPayway().equals(other.getPayway()))
            && (this.getControlnumber() == null ? other.getControlnumber() == null : this.getControlnumber().equals(other.getControlnumber()))
            && (this.getFriendnumber() == null ? other.getFriendnumber() == null : this.getFriendnumber().equals(other.getFriendnumber()))
            && (this.getFriendsing() == null ? other.getFriendsing() == null : this.getFriendsing().equals(other.getFriendsing()))
            && (this.getIsplaying() == null ? other.getIsplaying() == null : this.getIsplaying().equals(other.getIsplaying()))
            && (this.getRandomstring() == null ? other.getRandomstring() == null : this.getRandomstring().equals(other.getRandomstring()))
            && (this.getWorkstring() == null ? other.getWorkstring() == null : this.getWorkstring().equals(other.getWorkstring()))
            && (this.getWorksing() == null ? other.getWorksing() == null : this.getWorksing().equals(other.getWorksing()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getPageInfoId() == null) ? 0 : getPageInfoId().hashCode());
        result = prime * result + ((getFriendbodystring() == null) ? 0 : getFriendbodystring().hashCode());
        result = prime * result + ((getPayway() == null) ? 0 : getPayway().hashCode());
        result = prime * result + ((getControlnumber() == null) ? 0 : getControlnumber().hashCode());
        result = prime * result + ((getFriendnumber() == null) ? 0 : getFriendnumber().hashCode());
        result = prime * result + ((getFriendsing() == null) ? 0 : getFriendsing().hashCode());
        result = prime * result + ((getIsplaying() == null) ? 0 : getIsplaying().hashCode());
        result = prime * result + ((getRandomstring() == null) ? 0 : getRandomstring().hashCode());
        result = prime * result + ((getWorkstring() == null) ? 0 : getWorkstring().hashCode());
        result = prime * result + ((getWorksing() == null) ? 0 : getWorksing().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", pageInfoId=").append(pageInfoId);
        sb.append(", friendbodystring=").append(friendbodystring);
        sb.append(", payway=").append(payway);
        sb.append(", controlnumber=").append(controlnumber);
        sb.append(", friendnumber=").append(friendnumber);
        sb.append(", friendsing=").append(friendsing);
        sb.append(", isplaying=").append(isplaying);
        sb.append(", randomstring=").append(randomstring);
        sb.append(", workstring=").append(workstring);
        sb.append(", worksing=").append(worksing);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}