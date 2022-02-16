package algorithm.leetcode.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Shawn  来源：力扣（LeetCode）
 * @title: SubsetsWithDup 90. 子集 II
 * @projectName studyDemo
 * @description: 给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。
 *
 * 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,2]
 * 输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
 * 示例 2：
 *
 * 输入：nums = [0]
 * 输出：[[],[0]]
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 10
 * -10 <= nums[i] <= 10
 * 通过次数76,116提交次数122,163
 * @date 2021/3/31
 */
public class SubsetsWithDup {

    public static void main(String[] args) {
        subsetsWithDup02(new int[]{1,2,3});
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List res = new ArrayList();
        res.add(new int[]{});
        if(nums.length == 1){
            res.add(new int[]{nums[0]});
            return res;
        }
        return res;
    }

    static List<Integer> t = new ArrayList<Integer>();
    static List<List<Integer>> ans = new ArrayList<List<Integer>>();

    public List<List<Integer>> subsetsWithDup01(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        for (int mask = 0; mask < (1 << n); ++mask) {
            t.clear();
            boolean flag = true;
            for (int i = 0; i < n; ++i) {
                if ((mask & (1 << i)) != 0) {
                    if (i > 0 && (mask >> (i - 1) & 1) == 0 && nums[i] == nums[i - 1]) {
                        flag = false;
                        break;
                    }
                    t.add(nums[i]);
                }
            }
            if (flag) {
                ans.add(new ArrayList<Integer>(t));
            }
        }
        return ans;
    }

    public static List<List<Integer>> subsetsWithDup02(int[] nums) {
        Arrays.sort(nums);
        dfs(false, 0, nums);
        return ans;
    }

    public static void dfs(boolean choosePre, int cur, int[] nums) {
        if (cur == nums.length) {
            ans.add(new ArrayList<Integer>(t));
            return;
        }
        dfs(false, cur + 1, nums);
        if (!choosePre && cur > 0 && nums[cur - 1] == nums[cur]) { //迭代时，若发现没有选择上一个数，且当前数字与上一个数相同，则可以跳过当前生成的子集。
            return;
        }
        t.add(nums[cur]);
        dfs(true, cur + 1, nums);
        t.remove(t.size() - 1);
    }


    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup03(int[] nums) {
        Arrays.sort(nums);
        backTrace(nums, 0, new ArrayList<>());
        return res;
    }

    public void backTrace(int[] nums, int index, List<Integer> tmp){
        res.add(new ArrayList<>(tmp));
        for(int i = index; i < nums.length; ++i){
            //剔除重复元素
            if(i != index && nums[i] == nums[i - 1]){
                continue;
            }
            tmp.add(nums[i]);
            backTrace(nums, i + 1, tmp);
            tmp.remove(tmp.size() - 1);
        }
    }

}
