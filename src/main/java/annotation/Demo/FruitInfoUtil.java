package annotation.Demo;

/**
 * @author Shawn
 * @title: FruitInfoUtil
 * @projectName studyDemo
 * @description: TODO
 * @date 2021/1/26
 */
public class FruitInfoUtil {
    public static Apple getApple(Class<?> clazz) throws Exception{
        FruitProvider fb = clazz.getAnnotation(FruitProvider.class);//通过反射获取处理注释
        //通过newInstance()生成Apple实例，利用反射的结果进行设置
        Apple ap = (Apple)clazz.newInstance();
        ap.setAppleID(fb.id());
        ap.setAppleProvidername(fb.name());
        ap.setAppleprovideraddress(fb.address());
        return ap;
    }

    public static void main(String[] args) throws  Exception{
        Apple a = FruitInfoUtil.getApple(Apple.class);
        System.out.println("苹果商的ID为："+a.getAppleID());
        System.out.println("苹果商的名字为："+a.getAppleProvidername());
        System.out.println("苹果商的地址为:"+a.getAppleprovideraddress());
    }
}
