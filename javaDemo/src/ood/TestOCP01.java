package ood;

class A{
	public void save(){
		//.....
		System.out.println("==save ok==");
	}
	public void update(){
		System.out.println("==update ok===");
	}
}
//需求：对A类中的save方法添加时间计算功能，不能违背OCP原则。

class SubA extends A{
	@Override
	public void save() {
		long start=System.nanoTime();
		super.save();
		long end=System.nanoTime();
		System.out.println("time="+(end-start));
	}
	@Override
	public void update() {
		long start=System.nanoTime();
		super.update();
		long end=System.nanoTime();
		System.out.println("time="+(end-start));
	}
}

public class TestOCP01 {

	public static void main(String[] args) {
		A a=new SubA();
		a.save();
	}
}
