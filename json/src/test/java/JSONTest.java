import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.javaweb.pojo.Person;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Type;
import java.util.*;

/**
 * {@code @Description:}
 */
public class JSONTest {
    
    @Test
    public void javaBeanAndJson() {
        Person person = new Person(1, "hcx");
        Gson gson = new Gson();
        
        // toJson()方法可以把Java对象转换为json字符串形式
        String jsonString = gson.toJson(person);
        System.out.println(jsonString);//{"id":1,"name":"hcx"}
        
        // fromJson()方法可以把json字符串转换为Java对象
        // 第一个参数是json字符串，第二个是转换回去的Java对象类型
        Person personFromJson = gson.fromJson(jsonString, Person.class);
        System.out.println(personFromJson);// Person{id=1, name='hcx'}
    }
    
    
    @Test
    public void listAndJson() {
        
        List<Person> personList = new ArrayList<>();
        personList.add(new Person(1, "zhangsan"));
        personList.add(new Person(2, "lisi"));
        
        Gson gson = new Gson();
        // toJson()方法可以把List集合转换为json字符串形式
        String jsonString = gson.toJson(personList);
        System.out.println(jsonString);//[{"id":1,"name":"zhangsan"},{"id":2,"name":"lisi"}]
        
        // 匿名内部类
        Type type = new TypeToken<ArrayList<Person>>() {
        }.getType();
        
        // 将json字符串转换为集合
        List<Person> list = gson.fromJson(jsonString, type);
        Person person = list.get(0);
        System.out.println(person);// Person{id=1, name='zhangsan'}
    }
    
    
    @Test
    public void mapAndJson() {
        
        Map<Integer, Person> personMap = new Hashtable<>();
        personMap.put(1, new Person(1, "zhangsan"));
        personMap.put(2, new Person(2, "lisi"));
        
        Gson gson = new Gson();
        // toJson()方法可以把Java对象转换为json字符串形式
        String jsonString = gson.toJson(personMap);
        System.out.println(jsonString);//{"2":{"id":2,"name":"lisi"},"1":{"id":1,"name":"zhangsan"}}
        
        // 匿名内部类
        Type type = new TypeToken<HashMap<Integer, Person>>() {
        }.getType();
        
        // 将json字符串转换为集合
        Map<Integer, Person> map = gson.fromJson(jsonString, type);
        Person person = map.get(1);
        System.out.println(person);// Person{id=1, name='zhangsan'}
    }
    
    
}