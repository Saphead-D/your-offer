package proxy.jdk;

import proxy.User;
import proxy.UserService;

public class UserServiceImpl implements UserService {
    @Override
    public void addUser(User user) {
        System.out.println("用户数据入库成功，数据为：" + user.toString());
    }
}
