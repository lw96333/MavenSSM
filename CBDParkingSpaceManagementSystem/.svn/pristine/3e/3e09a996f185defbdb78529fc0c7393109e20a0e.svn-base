package com.java.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 在线用户统计
 * </p>
 *
 * @author 刘云升
 * @since 2019-03-21
 */
@TableName("online")
public class Online extends Model<Online> {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
	private Integer id;
    /**
     * 统计时间
     */
	private String time;
    /**
     * 在线人数
     */
	private String onlinenumber;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getOnlinenumber() {
		return onlinenumber;
	}

	public void setOnlinenumber(String onlinenumber) {
		this.onlinenumber = onlinenumber;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}
