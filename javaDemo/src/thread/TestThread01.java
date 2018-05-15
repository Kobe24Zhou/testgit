package thread;
/**出现线程安全问题的条件？
1)多个线程并发执行
2)多个线程存在共享数据
3)多个线程对共享数据的操作不是原子操作。
多线程通讯(协作)：建立在互斥基础上
1)互斥实现：同步代码块或同步方法
2)协作实现: wait(),notity()/notifyall()

方法概念说明
1)wait: 表示等待调用此方法的线程会进入阻塞状态，同时释放锁。
2)notify/notifyall:表示通知，主要用于唤醒具备相同锁且处于wait状态的线程。
方法应用说明
1)wait,notify,notifyall 必须应用在同步代码块或同步方法中
2)wait,notify,notifyall 必须由对象锁(同步锁)调用
*/
public class TestThread01 {
	//static String lock="LOCK";
	static String content;
	public static void main(String[] args) {
		new Thread(){//生产者线程(赋值)
			@Override
			public void run() {
				synchronized (TestThread01.class) {
					content="hello world";
					TestThread01.class.notifyAll();
				}
				
			}
		}.start();//就绪状态
		//主线程：消费者线程(取值)
		synchronized (TestThread01.class) {
		 while(content==null)
		 try{TestThread01.class.wait();}catch(Exception e){e.printStackTrace();}
		 System.out.println(content.toUpperCase());
		}
	}
}





