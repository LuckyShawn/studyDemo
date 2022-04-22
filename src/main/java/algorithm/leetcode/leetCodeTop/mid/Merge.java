package algorithm.leetcode.leetCodeTop.mid;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author Shawn
 * @title: Merge 56. 合并区间
 * @projectName studyDemo
 * @description: 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
 * 请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
 *
 * 示例 1：
 *
 * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出：[[1,6],[8,10],[15,18]]
 * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2：
 *
 * 输入：intervals = [[1,4],[4,5]]
 * 输出：[[1,5]]
 * 解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
 *
 * @date 2022/4/21
 */
public class Merge {
    /**
     * 首先，我们将列表中的区间按照左端点升序排序。然后我们将第一个区间加入 merged 数组中，并按顺序依次考虑之后的每个区间：
     *
     * 如果当前区间的左端点在数组 merged 中最后一个区间的右端点之后，那么它们不会重合，我们可以直接将这个区间加入数组 merged 的末尾；
     *
     * 否则，它们重合，我们需要用当前区间的右端点更新数组 merged 中最后一个区间的右端点，将其置为二者的较大值。
     *
     *  一、排序+分类
     * 1.数组为空，直接返回空数组
     * 2.按左边界排序，compare，前-后，负数升序
     * 3.用List存结果res，遍历二维数组，分三类
     * 4.第一类：如果res为空，直接加入
     *   第二类：如果res中最后一个区间右边界小于遍历区间的左边界，说明不重合，res加入遍历区间
     *   第三类：重合情况，取res中最后一个区间的右边界和遍历区间的右边界中的最大值
     *
     *  [
     *   [1,3],
     *   [2,6],
     *   [8,10],
     *   [15,18]
     * ]
     * @param intervals
     * @return
     */
    public int[][] merge1(int[][] intervals) {
        if(intervals.length == 0 ){
            return new int[0][0];
        }
        Arrays.sort(intervals,new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];   //负数，小的放前面，升序
            }
        });
        List<int[]> res = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            int left = intervals[i][0];
            int right = intervals[i][1];
            //如果res为空，或者res最后一个数组（区间）的右端点小于当前遍历数组（区间）的左端点，那么不重合，直接给res加入区间
            if(res.size() == 0 || res.get(res.size() - 1)[1] < left){
                res.add(new int[]{left,right});
            }else{//否则重合，取res最后一个数组右端点和当前数组的最大值
                res.get(res.size() - 1)[1] = Math.max(right,res.get(res.size() - 1)[1]);
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}
