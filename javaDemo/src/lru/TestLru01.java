package lru;
//LruCache
//DiskLruCache
import java.util.HashMap;
import java.util.LinkedHashMap;
public class TestLru01 {
    public static void main(String[] args) {
      LinkedHashMap<String,Integer> map=
         //new LinkedHashMap<String,Integer>();
         new LinkedHashMap<>(3, 0.75f, true);
         map.put("A",100);
         map.put("D",200);
         map.put("C",300);
         System.out.println(map);
         //访问
         Integer n=map.get("D");
         System.out.println(map);
         map.get("C");
         map.put("E",400);
         System.out.println(map);
         
	}
}
