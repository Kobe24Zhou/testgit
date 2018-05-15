package pwd;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class TestMD501 {
	public static void main(String[] args)
	throws Exception{
		String pwd=doMd5("123456");
		String s=doMd5(doMd5(pwd));
		System.out.println("s="+s);
	}
	private static String doMd5(String s1) throws NoSuchAlgorithmException {
		//构建加密对象(消息摘要对象)
		MessageDigest md=
		MessageDigest.getInstance("MD5");//不可逆的加密算法
		//对内容进行加密
		byte[] array=md.digest(s1.getBytes());
		System.out.println(array.length);//16byte=128bit
		/*for(byte a:array){
			System.out.println(Integer.toBinaryString(a));
		}*/
		//将加密结果转换为16进制
		StringBuilder sb=new StringBuilder();
	    for(byte n:array){
	    	String s=Integer.toHexString(n&0xff);
	    	if(s.length()==1){
	    		s="0"+s;
	    	}
	    	sb.append(s);
	    }
	    //e10adc3949ba59abbe56e057f20f883e
	    //e10adc3949ba59abbe56e057f20f883e
	    System.out.println(sb.toString());
	    return sb.toString();
	}
}







