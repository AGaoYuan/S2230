package cn.spring.day08jdkdynamicproxy;

/**
 * @Author: 咖啡豆
 * @Date: 2018/10/10 17:01
 * @Description:
 */
public class SomeServiceImpl implements ISomeService {


    @Override
    public void doSome() {
        System.out.println("do something===");
    }
}
