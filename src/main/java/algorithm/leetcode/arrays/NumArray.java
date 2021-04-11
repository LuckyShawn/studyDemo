package algorithm.leetcode.arrays;

/**
 * @author Shawn 来源：力扣（LeetCode）
 * @title: NumSumArray  303. 区域和检索 - 数组不可变 (前缀和)
 * @projectName studyDemo
 * @description: 给定一个整数数组  nums，求出数组从索引 i 到 j（i ≤ j）范围内元素的总和，包含 i、j 两点。
 * <p>
 * 实现 NumArray 类：
 * <p>
 * NumArray(int[] nums) 使用数组 nums 初始化对象
 * int sumRange(int i, int j) 返回数组 nums 从索引 i 到 j（i ≤ j）范围内元素的总和，包含 i、j 两点（也就是 sum(nums[i], nums[i + 1], ... , nums[j])）
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：
 * ["NumArray", "sumRange", "sumRange", "sumRange"]
 * [[[-2, 0, 3, -5, 2, -1]], [0, 2], [2, 5], [0, 5]]
 * 输出：
 * [null, 1, -1, -3]
 * <p>
 * 解释：
 * NumArray numArray = new NumArray([-2, 0, 3, -5, 2, -1]);
 * numArray.sumRange(0, 2); // return 1 ((-2) + 0 + 3)
 * numArray.sumRange(2, 5); // return -1 (3 + (-5) + 2 + (-1))
 * numArray.sumRange(0, 5); // return -3 ((-2) + 0 + 3 + (-5) + 2 + (-1))
 *  
 * <p>
 * 提示：
 * <p>
 * 0 <= nums.length <= 104
 * -105 <= nums[i] <= 105
 * 0 <= i <= j < nums.length
 * 最多调用 104 次 sumRange 方法
 * 通过次数84,852提交次数124,248
 * @date 2021/3/1
 */
public class NumArray {
    /**
     * 10 ms	77.14%
     * 41.3 MB 70.07%
     *
     * @param args
     */
    static int[] sums;

    public static void main(String[] args) {
        NumArray numArray = new NumArray(new int[]{-2, 0, 3, -5, 2, -1});
        System.out.println(numArray.sumRange(0,2));
        System.out.println(test(new int[]{-2, 0, 3, -5, 2, -1}, 0, 2));
    }

    public NumArray(int[] nums) {
        int length = nums.length;
        sums = new int[length + 1]; //记录前缀和
        for (int i = 0; i < length; i++) {
            sums[i + 1] = sums[i] + nums[i];
        }

    }

    public int sumRange(int i, int j) {
        return sums[j + 1] - sums[i];
    }


    public static int test(int[] nums, int i, int j) {
        int length = nums.length;
        sums = new int[length + 1];
        for (int k = 0; k < length; k++) {
            sums[k + 1] = sums[k] + nums[k];
        }
        return sums[j + 1] - sums[i];
    }

}
