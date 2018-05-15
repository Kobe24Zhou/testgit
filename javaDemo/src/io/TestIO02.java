package io;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
/***
 * FAQ?
 * 1)如何在对象序列化时，对内容进行加密？
 */
class Customer implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer id;
	private int age;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	/**对象序列化时，底层会自动调用此方法*/
	private void writeObject(
		ObjectOutputStream os) throws IOException{
		//加密(加密算法:参考Base64)
		id+=1;
		//序列化
		os.defaultWriteObject();
	}
	/**反序列化时，底层会自动调用此方法*/
	private void readObject(ObjectInputStream in)
	throws IOException, ClassNotFoundException{
		//反序列化
		in.defaultReadObject();
		//解密
		id-=1;
	}
	@Override
	public String toString() {
		return "Customer [id=" + id + ", age=" + age + "]";
	}	
	
	
}

public class TestIO02 {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
	    Customer c1=new Customer();
	    c1.setId(10);
	    c1.setAge(20);
	    //1.对象序列化
	    //1.1构建流对象
	    ByteArrayOutputStream bos=
	    new ByteArrayOutputStream();//byte[]buf
	    ObjectOutputStream out=
	    new ObjectOutputStream(bos);
	    //1.2对对象进行序列化
	    out.writeObject(c1);
	    System.out.println("序列化ok");
	    //2.对象的反序列化
	    ObjectInputStream in=
	    new ObjectInputStream(
	    new ByteArrayInputStream(bos.toByteArray()));    
	    Customer c2=(Customer)in.readObject();
	    System.out.println(c2);
	}
	
	
}









