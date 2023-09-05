import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.javaweb.entity.Person;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Type;
import java.util.*;

/**
 * {@code @description:}
 */
public class JSONTest {
    @Test
    public void javaBeanAndJson() {
        Person person = new Person(1, "hcx");
        Gson gson = new Gson();

        String jsonString = gson.toJson(person);
        System.out.println(jsonString);// {"id":1,"name":"hcx"}

        Person jsonObject = gson.fromJson(jsonString, Person.class);
        System.out.println(jsonObject);// Person{id=1, name='hcx'}
    }

    @Test
    public void listAndJson() {
        List<Person> personList = new ArrayList<>();
        personList.add(new Person(1, "zhangsan"));
        personList.add(new Person(2, "lisi"));

        Gson gson = new Gson();
        String jsonString = gson.toJson(personList);
        System.out.println(jsonString);// [{"id":1,"name":"zhangsan"},{"id":2,"name":"lisi"}]

        // 匿名内部类
        Type type = new TypeToken<ArrayList<Person>>() {
        }.getType();

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
        String jsonString = gson.toJson(personMap);
        System.out.println(jsonString);// {"2":{"id":2,"name":"lisi"},"1":{"id":1,"name":"zhangsan"}}

        // 匿名内部类
        Type type = new TypeToken<HashMap<Integer, Person>>() {
        }.getType();

        Map<Integer, Person> map = gson.fromJson(jsonString, type);
        Person person = map.get(1);
        System.out.println(person);// Person{id=1, name='zhangsan'}
    }
}