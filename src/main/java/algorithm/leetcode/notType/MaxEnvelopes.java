package algorithm.leetcode.notType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author Shawn
 * @title: MaxEnvelopes 354. 俄罗斯套娃信封问题
 * @projectName studyDemo
 * @description: hard
 * 给定一些标记了宽度和高度的信封，宽度和高度以整数对形式 (w, h) 出现。当另一个信封的宽度和高度都比这个信封大的时候，这个信封就可以放进另一个信封里，如同俄罗斯套娃一样。
 *
 * 请计算最多能有多少个信封能组成一组“俄罗斯套娃”信封（即可以把一个信封放到另一个信封里面）。
 *
 * 说明:
 * 不允许旋转信封。
 *
 * 示例:
 *
 * 输入: envelopes = [[5,4],[6,4],[6,7],[2,3]]
 * 输出: 3
 * 解释: 最多信封的个数为 3, 组合为: [2,3] => [5,4] => [6,7]。
 * 通过次数27,221提交次数68,601
 *
 * 来源：力扣（LeetCode）
 * @date 2021/3/4
 */
public class MaxEnvelopes {

    /**
     * 方法二：基于二分查找的动态规划
     * 思路与算法
     *
     * 设 f[j] 表示 h 的前 i 个元素可以组成的长度为 j 的最长严格递增子序列的末尾元素的最小值，如果不存在长度为 j 的最长严格递增子序列，对应的 f 值无定义。
     * 在定义范围内，可以看出 f 值是严格单调递增的，因为越长的子序列的末尾元素显然越大。
     * 在进行状态转移时，我们考虑当前的元素 hi：如果 hi大于 f 中的最大值，那么 hi就可以接在 f 中的最大值之后，形成一个长度更长的严格递增子序列；否则我们找出 f 中比 hi严格小的最大的元素 f[j0]，即f[j0]<hi≤f[j0+1]，
     * 那么hi可以接在f[j0] 之后，形成一个长度为j0+1 的严格递增子序列，因此需要对 f[j0+1] 进行更新：f[j0+1]=hi
     * 我们可以在 f 上进行二分查找，找出满足要求的j0。
     * 在遍历所有的 hi之后，f 中最后一个有定义的元素的下标增加 1（下标从 0 开始）即为最长严格递增子序列的长度。
     * @param envelopes
     * @return
     */
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes.length == 0) {
            return 0;
        }

        int n = envelopes.length;
        Arrays.sort(envelopes, new Comparator<int[]>() {
            public int compare(int[] e1, int[] e2) {
                if (e1[0] != e2[0]) {
                    return e1[0] - e2[0];
                } else {
                    return e2[1] - e1[1];
                }
            }
        });

        List<Integer> f = new ArrayList<Integer>();
        f.add(envelopes[0][1]);
        for (int i = 1; i < n; ++i) {
            int num = envelopes[i][1];
            if (num > f.get(f.size() - 1)) {
                f.add(num);
            } else {
                int index = binarySearch(f, num);
                f.set(index, num);
            }
        }
        return f.size();
    }

    public int binarySearch(List<Integer> f, int target) {
        int low = 0, high = f.size() - 1;
        while (low < high) {
            int mid = (high - low) / 2 + low;
            if (f.get(mid) < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

}
