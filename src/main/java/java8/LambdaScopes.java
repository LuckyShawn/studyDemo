package java8;

/**
 * @Description Lamda 表达式作用域(Lambda Scopes)
 * @Author shawn
 * @create 2019/3/25 0025
 */
public class LambdaScopes {
    public static void main(String[] args){
        final int num = 1;
        //访问局部变量
        Converter<Integer,String > converter = (from) -> String.valueOf(from + num);
        String convert = converter.convert(5);//6
        System.out.println(convert);
    }
}

//访问字段和静态变量
class Lambda4 {
    static int outerStaticNum;
    int outerNum;

    void testScopes() {
        Converter<Integer, String> stringConverter1 = (from) -> {
            outerNum = 23;
            return String.valueOf(from);
        };
        Converter<Integer, String> stringConverter2 = (from) -> {
            outerStaticNum = 72;
            return String.valueOf(from);
        };
    }
}