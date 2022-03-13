package algorithm.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Shawn  * 来源：力扣（LeetCode）
 * @title: Generate 118杨辉三角
 * @projectName studyDemo
 * @description: 给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。
 *
 * 在「杨辉三角」中，每个数是它左上方和右上方的数的和。
 * 示例 1:
 *
 * 输入: numRows = 5
 * 输出: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
 * 示例 2:
 *
 * 输入: numRows = 1
 * 输出: [[1]]
 *  
 *
 * 提示:
 *
 * 1 <= numRows <= 30
 * 通过次数253,496提交次数342,785
 *
 * @date 2022/1/21
 */
public class Generate {

    public static void main(String[] args) {
        generate(5);
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> list = new ArrayList<Integer>();
            for (int j = 0; j <= i; j++) {
                if(j == 0 || i == j){
                    list.add(1);
                }else{
                    list.add(result.get(i - 1).get(j - 1) + result.get(i - 1).get(j) );
                }
            }
            result.add(list);
        }
        return result;
    }



}
