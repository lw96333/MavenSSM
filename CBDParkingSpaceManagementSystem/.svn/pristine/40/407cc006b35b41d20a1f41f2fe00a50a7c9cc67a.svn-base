package com.java.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 性能统计请求响应
 * </p>
 *
 * @author 刘云升
 * @since 2019-03-21
 */
@TableName("responsetime")
public class Responsetime extends Model<Responsetime> {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
	private Integer id;
    /**
     * 请求响应时间
     */
	private String consuming;
    /**
     * 功能名称
     */
	private String name;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getConsuming() {
		return consuming;
	}

	public void setConsuming(String consuming) {
		this.consuming = consuming;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "Responsetime [id=" + id + ", consuming=" + consuming + ", name=" + name + "]";
	}
	

}
