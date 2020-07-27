package com.example.demo.common.entity;

import java.util.Date;

/**
 * 
 * @ClassName: TestPerson
 * @Description: Fastjson使用测试类
 * @author chenjy
 * @date 2020年5月20日 上午11:43:14
 *
 */
public class TestPerson extends CommonModel {
	// @JSONField(name = "ID")
	private Integer id;
	// @JSONField(name = "FULL NAME", ordinal = 3)
	private String fullName;
	// @JSONField(name = "FIRST NAME", ordinal = 2)
	private String firstName;
	// @JSONField(name = "LAST NAME", ordinal = 1)
	private String lastName;
	// @JSONField(name = "DATE OF BIRTH", format = "dd/MM/yyyy", ordinal = 4)
	private Date dateOfBirth;
	private String dateOfBirth02;
	/**
	 * 姓名
	 */
	private String name;

	/**
	 * 年龄
	 */
	private Integer age;

	/**
	 * 邮箱
	 */
	private String email;

	/**
	 * 密码
	 */
	private String password;

	/**
	 * 次数
	 */
	private Integer num;
	// 用户编码
	private String userCode;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getDateOfBirth02() {
		return dateOfBirth02;
	}

	public void setDateOfBirth02(String dateOfBirth02) {
		this.dateOfBirth02 = dateOfBirth02;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

}
