package proxy.jdk;

import proxy.User;
import proxy.UserService;

import java.lang.reflect.Proxy;

public class JdkClient {
    public static void main(String[] args) {
        User user = new User();
        user.setAge(20);
        user.setName("1ison");
        UserService us = new UserServiceImpl();
        UserServiceInterceptor usi = new UserServiceInterceptor(us);
        //1.类加载器
        //2. 服务接口信息
        //3. invocationhandler 本身
        UserService proxy = (UserService) Proxy.newProxyInstance(us.getClass().getClassLoader(), us.getClass().getInterfaces(), usi);
        //通过动态代理增强业务
        proxy.addUser(user);
        System.out.println("---------------------");
		System.out.println(proxy.hashCode());
    }
}
