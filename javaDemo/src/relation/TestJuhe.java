package relation;
class Child{}
class Famliy{
	//has a (存在整体部分关系)
	//关联关系中的聚合关系
	private Child[] childs;
}
//=====================================
class Brain{}
class Person{
	//has a (存在整体部分关系吗)
	//Brain对象的生命周期依赖于Person对象
	//聚合中组合(强聚合)
	private Brain brain=new Brain();
}

public class TestJuhe {

}
