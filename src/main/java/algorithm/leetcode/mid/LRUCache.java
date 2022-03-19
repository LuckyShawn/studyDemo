package algorithm.leetcode.mid;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Description TODO
 * @Authod shawn
 * @create 2022/3/16 0016
 */
public class LRUCache{

    class DBLinkedList{
        int key;
        int value;
        DBLinkedList prev;
        DBLinkedList next;
        public DBLinkedList(){

        }
        DBLinkedList(int key,int value){
            this.key = key;
            this.value = value;
        }
    }

    private int capacity ;
    private int size;
    private  DBLinkedList head;
    private DBLinkedList tail;
    Map<Integer,DBLinkedList> cache = new HashMap<Integer,DBLinkedList>();


    public LRUCache(int capacity ){
        this.capacity  = capacity ;
        int size = 0;
        head = new DBLinkedList();
        tail = new DBLinkedList();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key){
        DBLinkedList node = cache.get(key);
        if(node == null){
           return -1;
        }
        //节点移动到头部 1.先移出 2.在插入
        removeNode(node);
        addToHead(node);
        return node.value;
    }

    public void put(int key,int value){
        DBLinkedList node = cache.get(key);
        if(node ==null){
            DBLinkedList newNode = new DBLinkedList(key,value);
            cache.put(key,newNode);
            addToHead(newNode);
            ++size;
            if(size > capacity ){//超过容量，删除最后一个
                cache.remove(tail.prev.key);
                removeNode(tail.prev);
                --size;
            }
        }else{
            node.value = value;
            removeNode(node);
            addToHead(node);
        }

    }

    public void removeNode(DBLinkedList node){
        node.next.prev = node.prev;
        node.prev.next = node.next;
    }

    public void addToHead(DBLinkedList node){
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;

        String xml = "\\<DataInfo bostype=\"37C67DFC\" op=\"4\"\\>" +
                "\\<DataHead\\><creator>user</creator><createTime>2023-03-17 14:13:46</createTime>" +
                "<CU>JT</CU><name>113065</name><browseGroup>123</browseGroup><usedStatus>0</usedStatus><v" +
                "ersion>2</version><isInternalCompany>0</isInternalCompany><busiExequatur>生产许可证</busiExequatur><bizRegisterNo>1111111</bizRegisterNo><busiLicence>yingye</busiLicence><taxRegisterNo>222222</taxRegisterNo></DataHead><DataEntries><entry><supplierGroupStandard>supplierGroupStandard</supplierGroupStandard><supplierGroup>123</supplierGroup><supplierGroupFullName>123</supplierGroupFullName></entry></DataEntries></DataInfo>";
        xml.compareTo(xml);
    }

}






