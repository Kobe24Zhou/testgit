package io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;
/**
 * 对象序列化时如何对象粒度进行控制？
 * 1)100个属性，只有一个属性不序列化？(使用transient修饰)
 * 2)100个属性，只有一个属性要序列化？(让对象实现Externalizable)
 */

public class TestIO03 {
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		 //构建日志对象
		 Log log=new Log();
		 log.setId(10);
		 log.setUser("weilong");
		 log.setOperator("update role");
		 log.setIp("192.168.1.100");
		 log.setCreatedTime(new Date());
		 //对对象进行序列化
		 ObjectOutputStream out=
		 new ObjectOutputStream(
		 new FileOutputStream("f3.txt"));
		 out.writeObject(log);
		 out.close();
		 //对对象进行反序列化
		 ObjectInputStream in=
		 new ObjectInputStream(
		 new FileInputStream("f3.txt"));
		 Log log2=(Log)in.readObject();
		 System.out.println(log2);
	}
}
