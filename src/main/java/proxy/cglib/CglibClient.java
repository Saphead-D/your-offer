package proxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import proxy.User;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class CglibClient {
    public static void main(String[] args) {
        User user = new User();
        user.setAge(20);
        user.setName("1ison");
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(UserServiceImpl2.class);
        enhancer.setCallback(new UserService2Interceptor());
        //UserServiceImpl2 serviceImpl2 = (UserServiceImpl2) enhancer.create();
        //serviceImpl2.addUser(user);
        String s = "1";
        String s2 = new String("1");
        System.out.println(s.equals(s2));
        Map<String, String> map1 = new HashMap<>();
        Map<String, String> map2 = new LinkedHashMap<>();
        map2.put("1", "1");
        Map<String, String> map3 = new TreeMap<>();
    }
}
