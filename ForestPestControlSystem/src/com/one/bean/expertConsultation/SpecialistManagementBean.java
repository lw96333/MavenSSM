package com.one.bean.expertConsultation;

import java.sql.Date;
/**
   * ר��һ��
 * @author 49160
 *
 */
public class SpecialistManagementBean {
	//ר��ID
	private Integer id;
	//ר������
	private String name;
	//�Ա�
	private boolean gender;
	//����
	private Date bithday;
	//��Ƭ
	private String pic;
	//ר��
	private String expertise;
	//ְ��
	private String post;
	//�绰
	private String phone;
	//������λ
	private String workUnit;
	//��ַ
	private String path;
	//����
	private String email;
	
	public SpecialistManagementBean() {
		super();
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean getGender() {
		return gender;
	}
	public void setGender(boolean gender) {
		this.gender = gender;
	}
	public Date getBithday() {
		return bithday;
	}
	public void setBithday(Date bithday) {
		this.bithday = bithday;
	}
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	public String getExpertise() {
		return expertise;
	}
	public void setExpertise(String expertise) {
		this.expertise = expertise;
	}
	public String getPost() {
		return post;
	}
	public void setPost(String post) {
		this.post = post;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getWorkUnit() {
		return workUnit;
	}
	public void setWorkUnit(String workUnit) {
		this.workUnit = workUnit;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "SpecialistManagementBean [id=" + id + ", name=" + name + ", gender=" + gender + ", bithday=" + bithday
				+ ", pic=" + pic + ", expertise=" + expertise + ", post=" + post + ", phone=" + phone + ", workUnit="
				+ workUnit + ", path=" + path + ", email=" + email + "]";
	}
	
	
}
