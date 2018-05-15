package oom;
class Outer01{
	class Inner01 extends Thread{
		@Override
		public void run() {
			while(true){
			}
		}
	}
	public Outer01(){
		new Inner01().start();
	}
	/**对象被回收前执行*/
	@Override
	protected void finalize() throws Throwable {
		System.out.println("finalize()");
	}
}
public class TestOOM01 {
	public static void main(String[] args) {
		Outer01 o1=new Outer01();
		o1=null;
		//此时Outer01已经成为垃圾对象
		System.gc();//通知JVM
	};
}
