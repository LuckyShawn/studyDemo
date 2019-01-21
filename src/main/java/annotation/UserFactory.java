package annotation;


import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @Description 注解解析
 * @Author shawn
 * @create 2019/1/16 0016
 */
public class UserFactory {
    public static User create()
    {
        User user = new User();

        // 获取User类中所有的方法（getDeclaredMethods也行）
        Method[] methods = User.class.getMethods();

        try
        {
            for (Method method : methods)
            {
                // 如果此方法有注解，就把注解里面的数据赋值到user对象
                if (method.isAnnotationPresent(Init.class))
                {
                    Init init = method.getAnnotation(Init.class);
                    method.invoke(user, init.value());
                }
            }
            check(user);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }

        return user;
    }

    public static boolean check(User user)
    {
        if (user == null)
        {
            System.out.println("！！校验对象为空！！");
            return false;
        }

        // 获取User类的所有属性（如果使用getFields，就无法获取到private的属性）
        Field[] fields = User.class.getDeclaredFields();

        for (Field field : fields)
        {
            // 如果属性有注解，就进行校验
            if (field.isAnnotationPresent(Validate.class))
            {
                Validate validate = field.getAnnotation(Validate.class);
                if (field.getName().equals("age"))
                {
                    if (user.getAge() == null)
                    {
                        if (validate.isNotNull())
                        {
                            System.out.println("！！年龄可空校验不通过：不可为空！！");
                            return false;
                        }
                        else
                        {
                            System.out.println("年龄可空校验通过：可以为空");
                            continue;
                        }
                    }
                    else
                    {
                        System.out.println("年龄可空校验通过");
                    }

                    if (user.getAge() < validate.min())
                    {
                        System.out.println("！！年龄校验不通过！！年龄过小");
                        return false;
                    }
                    else
                    {
                        System.out.println("年龄符合");
                    }

                    if (user.getAge() > validate.max())
                    {
                        System.out.println("！！年龄校验不通过！！年龄过大");
                        return false;
                    }
                    else
                    {
                        System.out.println("年龄符合");
                    }
                }
                if (field.getName().equals("name"))
                {
                    if (user.getName() == null)
                    {
                        if (validate.isNotNull())
                        {
                            System.out.println("！！名字可空校验不通过：不可为空！！");
                            return false;
                        }
                        else
                        {
                            System.out.println("名字可空校验通过：可以为空");
                            continue;
                        }
                    }
                    else
                    {
                        System.out.println("名字可空校验通过");
                    }

                    if (user.getName().length() < validate.min())
                    {
                        System.out.println("！！名字最小长度校验不通过！！");
                        return false;
                    }
                    else
                    {
                        System.out.println("名字最小长度校验通过");
                    }

                    if (user.getName().length() > validate.max())
                    {
                        System.out.println("！！名字最大长度校验不通过！！");
                        return false;
                    }
                    else
                    {
                        System.out.println("名字最大长度校验通过");
                    }
                }
            }
        }

        return true;
    }

    //测试
    public static void main(String[] args){

        User user = UserFactory.create();

        System.out.println(user.getName());
        System.out.println(user.getAge());
    }
}
