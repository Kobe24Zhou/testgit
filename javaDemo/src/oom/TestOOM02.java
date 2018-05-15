package oom;
import java.lang.ref.WeakReference;

class TQueue{
	private Outer02 outer;
	public TQueue(Outer02 outer){
		   this.outer=outer;
	}
	@Override
	protected void finalize() throws Throwable {
		System.out.println("TQueue.finalize()");
	}
}
class Outer02{
	public Outer02() {
		new Inner02(new TQueue(this)).start();
	}
	static class Inner02 extends Thread{
		/*private TQueue tQueue;
		public Inner02(TQueue tQueue){
			this.tQueue=tQueue;
		}*/
		//弱引用
		private WeakReference<TQueue> weakR;
		public Inner02(TQueue tQueue){
			this.weakR=new WeakReference<TQueue>(tQueue);
		}
		@Override
		public void run() {
			while(true){
				//获取弱引用引用的对象
				System.out.println(this.weakR.get());
				try{
				Thread.sleep(1000);
				}catch(Exception e){}
			}
		}
	}
	@Override
	protected void finalize() throws Throwable {
		System.out.println("finalize()");
	}
}

public class TestOOM02 {
	public static void main(String[] args) {
		 //强引用
		 Outer02 o2=new Outer02();
		 o2=null;
		 System.gc();
		// while(true){}
		 
	}
}
