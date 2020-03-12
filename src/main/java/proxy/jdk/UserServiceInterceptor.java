package proxy.jdk;

import proxy.User;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.logging.Logger;

public class UserServiceInterceptor implements InvocationHandler {

    private static Logger logger = Logger.getLogger(UserServiceInterceptor.class.getName());

    private Object target;

    public UserServiceInterceptor (Object target){
        this.target = target;
    }

    public Object getTarget() {
        return target;
    }

    public void setTarget(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if(args!=null && args.length>0 && args[0] instanceof User){
            User user = (User) args[0];
            logger.info("传入参数" + user.toString());
            if(user.getName().trim().length()<=1){
                throw new RuntimeException("用户姓名输入长度需要大于1！");
            }
        }
        Object ret = method.invoke(target, args);
        logger.info("数据库操作成功！");
        return ret;
    }
}
