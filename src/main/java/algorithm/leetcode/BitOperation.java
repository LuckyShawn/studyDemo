package algorithm.leetcode;

/**
 * @author Shawn
 * @title: BitOperation 位运算
 * @projectName studyDemo
 * @description: TODO
 * @date 2021/3/31
 */
public class BitOperation {

    public static void main(String[] args) {
        //异或
        //yihuo();

        //按位与
        //anWeiYu();

        //按位或
        anWeiHuo();
    }

    /**
     * 异或运算 ^
     *  1.用于交换
     *  2.一个数与另一个数异或两次是其本身
     *  3.逆序数组，比如[1,0,1]异或1 ->[0,1,0]
     */
    public static void yihuo(){
        //异或运算 1.用于交换  加减法也可以用来交换a=a+b; b=a-b; a=a-b;
        int a = 10;
        int b = 20;
        int swapTemp = a ^ b;
        a = swapTemp ^ a;
        b = swapTemp ^ b;
        System.out.println(a);  //20
        System.out.println(b);  //10
        //简化
        a = 10;
        b = 20;
        a = a ^ b ^ a;
        b = 10 ^ b ^ b;
        System.out.println(a);
        System.out.println(b);
        //再简化
//        a = 10;
//        b = 20;
//        a^=b^=a^=b;
//        System.out.println(a);
//        System.out.println(b);

        //异或运算 2.一个数与另一个数异或两次是其本身
        System.out.println(10 ^ 20 ^ 20 );
    }

    /**
     * 按位与运算 &
     * 1.清零，与0 按位与
     * 2.取一个数的指定位
     */
    public static void anWeiYu(){
        //1.清零
        int a = 10;
        System.out.println(10 & 0);

        //2.取一个数的指定位
        System.out.println(Integer.toBinaryString(174));    //10101110
        System.out.println(Integer.toBinaryString(15));     //00001111
        //取1010 1110的低4位
        System.out.println(Integer.toBinaryString(174 & 15));

        //3.保留指定的位置
        System.out.println(Integer.toBinaryString(84));     //01010100
        System.out.println(Integer.toBinaryString(59));     //00111011 保留其3 4 5 7 8位,对应位数保留1即可
        System.out.println(Integer.toBinaryString(84 & 59));//00010000

        //4.取余运算 key % M = key & （M-1）  此用法待验证！！
        System.out.println(20 % 3);
        System.out.println(Integer.toBinaryString(20 & 2));



    }

    /**
     *  按位与运算 |
     *  负数按补码形式参加按位或运算。
     *  1.常用来对一个数据的某些位  置1
     */
    public static void anWeiHuo(){
        System.out.println(Integer.toBinaryString(160));    //10100000
        System.out.println(Integer.toBinaryString(15));   //0000 1111
        System.out.println(Integer.toBinaryString(160 | 15)); //10101111  -->  175
        System.out.println(160 | 15);
    }


}
