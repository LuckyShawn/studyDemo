package datastructure;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * 稀疏数组
 * * github超超时问题：
 *  * 主要原因是因为使用了proxy代理，需要关闭代理。
 *  *
 *  *   git config --global http.proxy  //查看代理
 *  *
 *  *  结果为：localhost:1080
 *  *
 *  *   git config --global --unset http.proxy  //不设置代理
 */
public class SparseArray {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //创建一个原始的二维数组11*11//0:表示没有棋子，1表示黑子2表蓝子
        int[][] arr = new int[11][11];
        arr[1][2] = 1;
        arr[2][3] = 2;
        arr[4][5] = 2;
        //输出原始的二维数组
        for (int[] row : arr) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }

        //将二维数组转稀疏数组的思//1.先遍历二维数组得到非0数据的个数
        int sum = 0;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (arr[i][j] != 0) {
                    sum++;
                }
            }
        }
        //2.创建对应的稀疏数组
        int sparseArr[][] = new int[sum + 1][3];
        //给稀疏数组赋值
        sparseArr[0][0] = 11;
        sparseArr[0][1] = 11;
        sparseArr[0][2] = sum;

        //遍历二维数组，将非0的值存放到sparseArr中
        int count = 0;//count用于记录是第几个非0数据
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (arr[i][j] != 0) {
                    count++;
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = arr[i][j];

                }
            }
        }

        //将数据存入文件中
        FileOutputStream fos = new FileOutputStream("D:\\WorkSpace\\studyDemo\\datastracture.data");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        Map map = new HashMap();
        map.put("arr",sparseArr);
        oos.writeObject(map);
        //读取文件
        FileInputStream fis = new FileInputStream("D:\\WorkSpace\\studyDemo\\datastracture.data");
        ObjectInputStream ois = new ObjectInputStream(fis);
        Map inMap = (Map)ois.readObject();

        int sparseArrMap[][] = (int[][])inMap.get("arr");
        //输出稀疏数组的形式
        System.out.println("得到稀疏数组为===========");
        for (int i = 0; i < sparseArrMap.length; i++) {
            System.out.printf("%d\t%d\t%d\t\n", sparseArrMap[i][0], sparseArrMap[i][1], sparseArrMap[i][2]);
        }
        System.out.println();

        //将稀疏数组--》恢复成原始的二维数组
        int[][] arr2 = new int[sparseArrMap[0][0]][sparseArrMap[0][1]];
        for (int i = 1; i < sparseArrMap.length; i++) {
            arr2[sparseArrMap[i][0]][sparseArrMap[i][1]] = sparseArrMap[i][2];
        }

        //输出恢复后的二维数组
        System.out.println("恢复后的二维数组");
        for (int[] row : arr2) {
            for (int data:row) {
                System.out.printf("%d\t", data);
            } System.out.println();
        }
    }
}
