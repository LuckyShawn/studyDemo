package algorithm.leetcode.hash;

import java.util.Base64;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * @author Shawn
 * @title: MyHashSet 705. 设计哈希集合
 * @projectName studyDemo
 * @description: 不使用任何内建的哈希表库设计一个哈希集合（HashSet）。
 *
 * 实现 MyHashSet 类：
 *
 * void add(key) 向哈希集合中插入值 key 。
 * bool contains(key) 返回哈希集合中是否存在这个值 key 。
 * void remove(key) 将给定值 key 从哈希集合中删除。如果哈希集合中没有这个值，什么也不做。
 *  
 * 示例：
 *
 * 输入：
 * ["MyHashSet", "add", "add", "contains", "contains", "add", "contains", "remove", "contains"]
 * [[], [1], [2], [1], [3], [2], [2], [2], [2]]
 * 输出：
 * [null, null, null, true, false, null, true, null, false]
 *
 * 解释：
 * MyHashSet myHashSet = new MyHashSet();
 * myHashSet.add(1);      // set = [1]
 * myHashSet.add(2);      // set = [1, 2]
 * myHashSet.contains(1); // 返回 True
 * myHashSet.contains(3); // 返回 False ，（未找到）
 * myHashSet.add(2);      // set = [1, 2]
 * myHashSet.contains(2); // 返回 True
 * myHashSet.remove(2);   // set = [1]
 * myHashSet.contains(2); // 返回 False ，（已移除）
 *  
 *
 * 提示：
 *
 * 0 <= key <= 106
 * 最多调用 104 次 add、remove 和 contains 。
 *  
 *
 * 进阶：你可以不使用内建的哈希集合库解决此问题吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/design-hashset
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2021/3/14 0014上午 11:33
 */
public class MyHashSet {
    //默认的容量，暂时不考虑扩容
    private static final int BASE = 769;
    //数组中的元素挂链表
    private LinkedList[] data;

    /** Initialize your data structure here. */
    public MyHashSet() {
        data = new LinkedList[BASE];
        for (int i = 0; i < BASE; i++) {
            data[i] = new LinkedList<Integer>();
        }
    }

    public void add(int key) {
        int hashVal = hash(key);
        Iterator<Integer> it = data[hashVal].iterator();
        while(it.hasNext()){
            Integer element = it.next();
            if(element == key){
                return;
            }
        }
        data[hashVal].offerLast(key);
    }

    public void remove(int key) {
        int hashVal = hash(key);
        Iterator<Integer> it = data[hashVal].iterator();
        while(it.hasNext()){
            Integer element = it.next();
            if(element == key){
                data[hashVal].remove(element);
                return;
            }
        }
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int hashVal = hash(key);
        Iterator<Integer> it = data[hashVal].iterator();
        while(it.hasNext()){
            Integer element = it.next();
            if(element == key){
                return true;
            }
        }
        return false;
    }

    public int hash(int key){
        return key % BASE;
    }
}
