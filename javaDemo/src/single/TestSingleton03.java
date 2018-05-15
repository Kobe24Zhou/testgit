package single;

import java.text.SimpleDateFormat;
import java.util.Date;

class DateFormatUtils{
	/**
	 * ThreadLocal对象提供了这样的一种机制
	 * 1)可以将某个对象绑定到当前线程
	 * 2)可以从某个线程获取某个对象
	 */
	private static ThreadLocal<SimpleDateFormat> td=
			new ThreadLocal<SimpleDateFormat>(){
		 /**
		  * 此方法的作用是创建一个SimplageDateFormat对象
		  * 1)此方法何时执行？
		  * 当前线程第一次访问threadlocal对象的get方法时
		  * 2)此方法执行结束以后系统还会做什么事？
		  * 将此方法返回的对象存储到当前线程(set 到map)
		  * 3)SimpleDateFormat对象绑定到当前线程时它的key是谁？
		  * ThreadLocal对象
		  * */
		 protected SimpleDateFormat initialValue() {
			 System.out.println("==initialValue()==");
			 return new SimpleDateFormat("yyyy-MM-dd");
		 };
	};

	public static String convertDate(Date date){
		   return td.get().format(date);
	}
	public static void remove(){
		td.remove();
	}
}
//Thread-->ThreadLocalMap-->Key/Value
public class TestSingleton03 {
	static SimpleDateFormat s4;
	public static void main(String[] args) throws InterruptedException {
		System.out.println("main:"+DateFormatUtils.convertDate(new Date()));
		System.out.println("main:"+DateFormatUtils.convertDate(new Date()));
		//DateFormatUtils.remove();
		new Thread(){
			public void run() {
				System.out.println("worker:"+
				DateFormatUtils.convertDate(new Date()));
			   // DateFormatUtils.remove();
			};
		}.start();
	}
}
