package lru;
import java.util.LinkedHashMap;
class SqlSession{
	//.....
	private LruCache<String,Object> cache;
}
/**自己尝试实现一个基于LRU算法的小Cache*/
class LruCache<K,V> extends LinkedHashMap<K, V>{
	private int maxCapacity;
	public LruCache(int maxCapacity){
		super(maxCapacity, 0.75f, true);
		this.maxCapacity=maxCapacity;
	}
	/**移除最近最少使用的那个元素*/
	@Override
	protected boolean removeEldestEntry(java.util.Map.Entry<K, V> eldest) {	
		//System.out.println("removeEldestEntry");
		return size()>maxCapacity;//true时会移除相关元素
	}
	/*public LruCache(int initialCapacity, float loadFactor, boolean accessOrder) {
		super(initialCapacity, loadFactor, accessOrder);
		this.maxCapacity=initialCapacity;
	}*/
}
public class TestLru02 {
    public static void main(String[] args) {
	   LruCache<String,Integer> cache=
	   //new LruCache<String,Integer>(3, 0.75f, true);
	   new LruCache<String,Integer>(3);
	   cache.put("A", 100);
	   cache.put("M", 200);
	   cache.put("D", 300);
	   cache.put("C", 400);
	   
	   System.out.println(cache);//MDC
	   cache.get("M");
	   System.out.println(cache);//DCM
	   cache.put("E", 500);
	   System.out.println(cache);//CME
	}
}
