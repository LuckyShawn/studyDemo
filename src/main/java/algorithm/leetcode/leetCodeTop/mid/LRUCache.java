package algorithm.leetcode.leetCodeTop.mid;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Shawn  * 来源：力扣（LeetCode）
 * @title: LRUCache 146. LRU 缓存 *****
 * @projectName studyDemo
 * @description: 请你设计并实现一个满足  LRU (最近最少使用) 缓存 约束的数据结构。
 * 实现 LRUCache 类：
 * LRUCache(int capacity) 以 正整数 作为容量 capacity 初始化 LRU 缓存
 * int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
 * void put(int key, int value) 如果关键字 key 已经存在，则变更其数据值 value ；如果不存在，则向缓存中插入该组 key-value 。如果插入操作导致关键字数量超过 capacity ，
 * 则应该 逐出 最久未使用的关键字。
 * 函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。
 *
 *  
 *
 * 示例：
 *
 * 输入
 * ["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
 * [[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
 * 输出
 * [null, null, null, 1, null, -1, null, -1, 3, 4]
 *
 * 解释
 * LRUCache lRUCache = new LRUCache(2);
 * lRUCache.put(1, 1); // 缓存是 {1=1}
 * lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
 * lRUCache.get(1);    // 返回 1
 * lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
 * lRUCache.get(2);    // 返回 -1 (未找到)
 * lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
 * lRUCache.get(1);    // 返回 -1 (未找到)
 * lRUCache.get(3);    // 返回 3
 * lRUCache.get(4);    // 返回 4
 *  
 *
 * 提示：
 *
 * 1 <= capacity <= 3000
 * 0 <= key <= 10000
 * 0 <= value <= 105
 * 最多调用 2 * 105 次 get 和 put
 * 通过次数280,011提交次数533,480
 *
 * @date 2022/2/11
 */
public class LRUCache {

    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 1); // 缓存是 {1=1}
        System.out.println(lRUCache.get(1));;    // 返回 1
        lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
        System.out.println(lRUCache.get(2));    // 返回 -1 (未找到)
        lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
        System.out.println(lRUCache.get(1));   // 返回 -1 (未找到)
        System.out.println(lRUCache.get(3));    // 返回 3
        System.out.println(lRUCache.get(4));    // 返回 4
    }

    //简单实现双向链表
    class DoubleLinkNode{
        int key;
        int value;
        DoubleLinkNode prev;
        DoubleLinkNode next;
        public DoubleLinkNode(){
        }
        public DoubleLinkNode(int key , int value){
            this.key = key;
            this.value = value;
        }
    }

    int capacity;
    int size;
    Map<Integer,DoubleLinkNode> cache = new HashMap<Integer,DoubleLinkNode>();
    DoubleLinkNode head,tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new DoubleLinkNode();
        tail = new DoubleLinkNode();
        size = 0;
        //伪头尾部互指
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        DoubleLinkNode node = cache.get(key);
        if(node == null){
            return -1;
        }
        //存在值，将获取的node节点移到第一位
        //先切断节点（切断节点后当前节点指针不变）
        //再加入到第一位
        moveToHead(node);

        return node.value;
    }

    public void put(int key, int value) {
        DoubleLinkNode node = cache.get(key);

        if(node == null){
            DoubleLinkNode newNode = new DoubleLinkNode(key,value);
            //节点移动到第一位
            addToHead(newNode);
            cache.put(key,newNode);
            ++size;
            //超过容量则删除最后一个
            if(size > capacity){
                removeTail();
                --size;
            }
        }else{
            //通过哈希定位key存在，修改value值，再移动到第一位
            node.value = value;
            //先切断节点（切断节点后当前节点指针不变）
            removeNode(node);
            //再加入到第一位
            moveToHead(node);
        }

    }
    //删除节点
    public void removeNode(DoubleLinkNode node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    //增加节点到头部
    public void addToHead(DoubleLinkNode node){
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    //移动节点到头部,先切断节点（切断节点后当前节点指针不变）再加入到第一位
    public void moveToHead(DoubleLinkNode node){
        removeNode(node);
        addToHead(node);
    }

    //移除尾部节点
    public DoubleLinkNode removeTail(){
        DoubleLinkNode tailNode = tail.prev;
        tailNode.prev.next = tailNode.next;
        tailNode.next.prev = tailNode.prev;
        cache.remove(tailNode.key);
        return tailNode;
    }
}
