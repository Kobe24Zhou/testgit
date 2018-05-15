package io;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Date;

public class Log implements Externalizable{
	private static final long serialVersionUID = -5446343396014642262L;
	private Integer id;
	private String user;
	private String operator;
	private Date createdTime;
	private String ip;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	public Date getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	@Override
	public String toString() {
		return "Log [id=" + id + ", user=" + user + ", operator=" + operator + ", createdTime=" + createdTime + ", ip="
				+ ip + "]";
	}
	/**对象序列化时调用*/
	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		out.writeUTF(ip);
	}
	/**对象反序列化调用*/
	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		ip=in.readUTF();
	}
}
