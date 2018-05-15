package io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class TestIO01 {

	public static void main(String[] args)
	throws Exception{
		//object
		Point p1=new Point();
		p1.setX(10);
		p1.setY(20);
		//序列化
/*		ObjectOutputStream out=
	    new ObjectOutputStream(
	    new FileOutputStream("f1.txt"));
		out.writeObject(p1);
		out.close();
		System.out.println("序列化OK");*/
		//反序列化
		ObjectInputStream in=
			new ObjectInputStream(
		new FileInputStream("f1.txt"));
		
		Point p2=(Point)in.readObject();
		System.out.println(p2.getX()+"/"+p2.getY());
		
		in.close();
		
		
	    
	    
	    
	    
	    
	    
	}
}
