package single;
/**
 * 设计模式：一种经验和套路总结
 * 单例模式：属于一种创建型模式(与对象创建有关)
 * 其含义是：保证一个类的对象在内存中只有一份。
 */
//方案1：饿汉单例
class Singleton01{//场景：小对象，频繁用
	//private int[] array=new int[10];
	private Singleton01(){}
	//类加载时初始化(不需要此对象也会初始化)
	private static Singleton01 instance=
			new Singleton01();
	public static Singleton01 getInstance(){
		return instance;
	}
	//public static void sayHello(){}
	//public void sayWelcome(){}
}
//方案2：懒汉单例
class Singleton02{//场景：一个线程
	private Singleton02(){}
	private static Singleton02 instance;//null
	//存在线程安全问题(多线程访问可能会创建多个实例)
	public static Singleton02 getInstance(){
		if(instance==null){
			instance=new Singleton02();
		}
		return instance;
	}//延迟加载策略(何时需要何时创建)
	//public static void sayHello(){}
	//public void sayWelcome(){}
}
//方案3
class Singleton03{//场景：大对象，稀少用
	private Singleton03(){}
	private static Singleton03 instance;//null
	//不存在线程安全问题，但存在性能问题
	public static synchronized Singleton03 getInstance(){
		if(instance==null){
			instance=new Singleton03();
		}
		return instance;
	}//存在阻塞问题
}
//方案4:
class Singleton04{//场景:大对象，稀少用（但阻塞次数会相对于方案3有减少）
	private Singleton04(){}
	private static Singleton04 instance;//null
	//不存在线程安全问题，但存在性能问题
	public static Singleton04 getInstance(){
		if(instance==null){
		 synchronized (Singleton04.class) {
			if(instance==null){
				instance=new Singleton04();
			}
		 }
		}
		return instance;
	}//存在阻塞问题(阻塞的次数会减少)
}
//方案5：思考类何时被加载(构建对象或直接访问类中属性、方法时)
class Singleton05{//场景：大对象，频繁用
	private Singleton05(){}
	//此类何时加载
	private static class Inner{
	 //Inner类加载时初始化(不需要此对象也会初始化)
	 private static Singleton05 instance=new Singleton05();
	}
	//基于内部方式实现对象的延迟加载
	public static Singleton05 getInstance(){
		return Inner.instance;
	}
/*	public static void sayHello(){
		System.out.println("sayHello");
	}
	public void sayWelcome(){
		System.out.println("sayWelcome");
	}*/
}
/**类加载时初始化*/
enum Singleton06{//特殊的类
	instance;
	private Singleton06() {}
	public void show(){}
}

public class TestSingleton01 {
    public static void main(String[] args) {
    	Singleton06.instance.show();
    	
	    for(int i=0;i<5;i++){
	    	new Thread(){
	    		public void run() {
	    			System.out.println(Singleton05.getInstance());
	    		};
	    	}.start();
	    }
	}
}
