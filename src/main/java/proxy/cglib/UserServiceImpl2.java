package proxy.cglib;

import proxy.User;
import proxy.UserService;

public class UserServiceImpl2 {

    public void addUser(User user) {
        System.out.println("用户数据入库成功，数据为：" + user.toString());
    }
}
