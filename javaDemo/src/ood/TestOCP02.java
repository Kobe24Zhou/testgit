package ood;
interface HelloService{
	void sayHello(String msg);
}
//为此类方法添加扩展业务或功能上的增强
final class HelloServiceImpl implements HelloService{
	@Override
	public void sayHello(String msg) {
		System.out.println("hello "+msg);
	}
}

class HelloServiceProxy implements HelloService{
	private HelloService helloService;
	public HelloServiceProxy(HelloService helloService) {
		this.helloService=helloService;
	}
	@Override
	public void sayHello(String msg) {
		long start=System.nanoTime();
		helloService.sayHello(msg);
		long end=System.currentTimeMillis();
		System.out.println("execution time "+(end-start));
	}
}

public class TestOCP02 {
	public static void main(String[] args) {
		 HelloServiceImpl helloServiceImpl=
				 new HelloServiceImpl();
		 HelloServiceProxy hProxy=
			new HelloServiceProxy(helloServiceImpl);
		 hProxy.sayHello("cgb1712");
	}
}
