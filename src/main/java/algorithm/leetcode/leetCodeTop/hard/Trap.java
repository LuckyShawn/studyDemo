package algorithm.leetcode.leetCodeTop.hard;

/**
 * @author Shawn    * 来源：力扣（LeetCode）
 * @title: Trap 17.21. 直方图的水量
 * @projectName studyDemo
 * @description: 给定一个直方图(也称柱状图)，假设有人从上面源源不断地倒水，最后直方图能存多少水量?直方图的宽度为 1。
 * 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的直方图，在这种情况下，可以接 6 个单位的水（蓝色部分表示水）。 感谢 Marcos 贡献此图。
 * <p>
 * 示例:
 * <p>
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出: 6
 * 通过次数11,597提交次数18,458
 * @date 2021/4/2
 */
public class Trap {

    public static void main(String[] args) {
        System.out.println(trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }

    /**
     * 双指针
     * TOP
     * 左边低，左边最大值 - 左边当前值即为答案
     * 右边低，右边最大值 - 右边当前值即为答案
     * @param height
     * @return
     */
    public static int trap(int[] height) {
        int ans = 0;
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;
        while (left < right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);
            //如果height[left]<height[right]，则必有 leftMax<rightMax，下标 left 处能接的水的量等于
            // leftMax−height[left]，将下标 left 处能接的水的量加到能接的水的总量，然后将left 加 1（即向右移动一位）；
            if (height[left] < height[right]) {
                ans += leftMax - height[left];
                ++left;
            } else {
                //如果height[left]≥height[right]，则必有leftMax≥rightMax，下标 right 处能接的水的量等于rightMax−height[right]，
                // 将下标 right 处能接的水的量加到能接的水的总量，然后将right 减 1（即向左移动一位）。
                ans += rightMax - height[right];
                --right;
            }
        }
        return ans;

    }


}
