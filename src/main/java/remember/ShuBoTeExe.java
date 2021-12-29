package remember;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author Shawn
 * @title: ShuBoTeExe
 * @projectName studyDemo
 * @description: TODO
 * @date 2021/12/29
 */
public class ShuBoTeExe {

    public static void main(String[] args) {
        int num = 5;
        int size = num * num;
        Set<Integer> set = getRandomNumsNotRep(size);
        Object[] objs = set.toArray();
        Integer[] randArr = new Integer[objs.length];
        for (int i = 0; i < objs.length ; i++) {
            randArr[i] = (Integer) objs[i];
        }
        int [][] result = getRandomArrs(size,num,randArr);
        for (int i = 0; i < result[0].length; i++) {
            System.out.println("                                                                "+Arrays.toString(result[i]));
        }
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        Scanner sc = new Scanner(System.in);
        long st = 0;
        long et = 0;

        if(sc.nextLine() != null){
            sdf.format(System.currentTimeMillis());
            st = System.currentTimeMillis();
            System.out.println("StartTime："+sdf.format(st));
        }
        if(sc.nextLine() != null){
            et = System.currentTimeMillis();
            System.out.println("EndTime："+sdf.format(et));
        }
        System.out.println("使用时间："+(et-st)/1000 + "s");
    }

    public static int [][] getRandomArrs(int size,int num,Integer[] randArr){
        int [][] arrs = new int[num][num];
        int index = 0;
        int i = 0;
        while(index < size) {
            if(index != 0 && index % num == 0){
                i++;
            }
            arrs[i][index % num] = randArr[index++];
        }
        return arrs;
    }

    /***
     * 生成不重复的随机数
     * @param size
     * @return
     */
    public static Set<Integer> getRandomNumsNotRep(int size){
        Random random = new Random();
        random.nextInt(size +1 );
        Set<Integer> set = new LinkedHashSet<>();
        while(set.size() < size){
            set.add(random.nextInt(size)+1);
        }
        return set;
    }

}
