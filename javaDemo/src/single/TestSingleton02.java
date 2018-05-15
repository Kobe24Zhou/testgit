package single;

import java.text.SimpleDateFormat;
import java.util.Date;

class DateUtils{
	/**SimpleDateFormat对象
	 * 1)线程不安全
	 * 2)此对象不能被多线程共享
	 * 3)可以将此对象设置为线程内部单例(每个线程有一份)
	 * */
	//private static SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
	/**
	 * ThreadLocal对象提供了这样的一种机制
	 * 1)可以将某个对象绑定到当前线程
	 * 2)可以从某个线程获取某个对象
	 */
	private static ThreadLocal<SimpleDateFormat> td=
			new ThreadLocal<>();
	//线程内部单例
	public static SimpleDateFormat getInstance(){
		//1.从当前线程获取对象
		SimpleDateFormat sdf=td.get();
		//2.当前线程没有则创建对象，并绑定到当前线程
		if(sdf==null){
			sdf=new SimpleDateFormat("yyyy-MM-dd");
			//将对象绑定到线程
			td.set(sdf);
		}
		return sdf;
	}
	public static String convertDate(Date date){
		   return getInstance().format(date);
	}
}

public class TestSingleton02 {
	static SimpleDateFormat s4;
	public static void main(String[] args) throws InterruptedException {
		SimpleDateFormat s1=DateUtils.getInstance();
		SimpleDateFormat s2=DateUtils.getInstance();
		SimpleDateFormat s3=DateUtils.getInstance();
		System.out.println(s1==s2);
		System.out.println(s2==s3);
		System.out.println("s1="+s1);
		
		Thread t=new Thread(){
			public void run() {
				s4=DateUtils.getInstance();
				SimpleDateFormat s5=DateUtils.getInstance();
				SimpleDateFormat s6=DateUtils.getInstance();
				System.out.println("s4="+s4);
				System.out.println(s4==s5);
				System.out.println(s5==s6);
			};
		};
		t.start();
		t.join();
		System.out.println(s1==s4);
	}
}
