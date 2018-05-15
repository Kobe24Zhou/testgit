package annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import static java.lang.annotation.RetentionPolicy.*;
import java.lang.annotation.Target;

/**
 * 注解是什么？
 * JDK1.5推出的一种特殊的类
 * 注解的应用场景？
 * 描述java中元素(类，属性，方法，参数)
 * 注解如何编写
 * 1)使用@Interface定义
 * 2)内部可定义其成员属性
 */
//@Retention描述注解合适有效
@Retention(RUNTIME)
@Target(ElementType.TYPE)//约束注解的应用目标
@interface Controller{
	String value() default "";
}//Controller.class

@Retention(RUNTIME)
@Target({ElementType.FIELD,ElementType.METHOD})
@interface Autowire{}

@Controller("blogC")
class BlogController{
	@Autowire
	private BlogService blogService;
	@Autowire
	public void setBlogService(BlogService blogService) {
		this.blogService = blogService;
	}
	public void doUI(){}
}
class BlogService{}
public class TestAnnotation01 {
	public static void main(String[] args) throws Exception{
		//获取类对象
		Class<?> c=Class.forName("annotation.BlogController");
		//判定类上是否有Controller这个注解
		if(c.isAnnotationPresent(Controller.class)){
			//获取类上的Controller注解
			Controller con=
			c.getAnnotation(Controller.class);
			//输出注解中的内容
			System.out.println(con.value());
		}
	}
}
