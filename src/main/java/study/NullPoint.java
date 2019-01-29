package study;

/**
 * @Description 数组三种空指针情况
 * @Author shawn
 * @create 2019/1/28 0028
 */
public class NullPoint {
    public static void main(String[] args){
        //第一种：
//		boolean[] b = new boolean[3];
//		b = null;
//		System.out.println(b[0]);

        //第二种：
		String[] str = new String[4];
//		//str[3] = new String("AA");//str[3] = "AA";
		System.out.println(str[3].toString());

        //第三种：
        //int[][] j = new int[3][];
        //j[2][0] = 12;
    }
}
