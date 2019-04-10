package com.java.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 消息推送
 * </p>
 *
 * @author 刘云升
 * @since 2019-03-21
 */
@TableName("information")
public class Information extends Model<Information> {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
	private Integer infoid;
    /**
     * 用户ID
     */
	private Integer userid;
    /**
     * 消息内容
     */
	private String comtent;


	public Integer getInfoid() {
		return infoid;
	}

	public void setInfoid(Integer infoid) {
		this.infoid = infoid;
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public String getComtent() {
		return comtent;
	}

	public void setComtent(String comtent) {
		this.comtent = comtent;
	}

	@Override
	protected Serializable pkVal() {
		return this.infoid;
	}

}
