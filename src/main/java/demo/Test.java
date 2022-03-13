package demo;

/**
 * @author Shawn
 * @title: Test
 * @projectName studyDemo
 * @description: TODO
 * @date 2021/6/1
 */
public class Test {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        try{
           // ((Person)(Class.forName("demo.Person").newInstance())).eat();
            String str = "aaa";
            char[] a = new char[10];
            str.getChars(0,2,a,1);
            System.out.println(a);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
