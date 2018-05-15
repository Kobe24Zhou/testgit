package io;

import java.io.Serializable;
/***
 * 对象序列化：
 * 1)类中为什么要添加序列化的版本ID
 * @author we are young
 *
 */

public class Point implements Serializable{
	private static final long serialVersionUID = -7454603946365975232L;
	private int x;
    private int y;
    private int z;
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
    
}
