package oop;

public class TestOOP01 {

	static int doMethod01(){//12 or 11
		int a=10;
		try{
		  a++;
		  return a; //@AfterReturning
		}finally{
		  a++; //@After
		}
	}
	static int doMethod02(int b){
		int a=11;
		try{
		 a++;
		 a/=b;
		 return a;
		}catch(Exception e){
		 a++;
		 throw new RuntimeException(e.getMessage()+"a="+a);
		 //@AfterThrowing
		}finally{
		 a++; //@After
		}
	}
	public static void main(String[] args) {
		int n1=doMethod01();
		System.out.println(n1);//12
		int n2=doMethod02(0);
		System.out.println(n2);
	}
}
