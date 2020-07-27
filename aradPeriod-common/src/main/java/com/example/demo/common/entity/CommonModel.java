package com.example.demo.common.entity;

/**
 * 
 * @ClassName: CommonModel
 * @Description: 通用模型对象，封装常用属性
 * @author chenjy
 * @date 2020年5月25日 下午5:18:48
 *
 */
public class CommonModel {
	/********* 查询属性 *************/
	private Integer page;// 分页：页码
	private Integer rows;// 分页：每页记录数
	private String sord;// 排序方式:asc升序,desc降序
	private String respCode; // 响应代码（0成功，1鉴权，2无权访问，3业务处理失败）
	private String respMsg; // 响应提示信息（0未登录，1已登录，2用户名密码错误，3用户名密码正确，4系统发生错误，5token校验失败，6token校验通过，7token已过期，8
							// 验证码错误）
	private String token; // 用户访问所有接口唯一凭据

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getRows() {
		return rows;
	}

	public void setRows(Integer rows) {
		this.rows = rows;
	}

	public String getSord() {
		return sord;
	}

	public void setSord(String sord) {
		this.sord = sord;
	}

	public String getRespCode() {
		return respCode;
	}

	public void setRespCode(String respCode) {
		this.respCode = respCode;
	}

	public String getRespMsg() {
		return respMsg;
	}

	public void setRespMsg(String respMsg) {
		this.respMsg = respMsg;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

}
