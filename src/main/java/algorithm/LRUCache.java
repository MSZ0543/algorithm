package algorithm;

import java.util.HashMap;

/**
 * @program: algorithm
 * @description: LRU缓存机制
 * @author: szm
 * @create: 2020-02-29 09:59
 **/
public class LRUCache {


    public static void main(String[] args) {
        System.out.println("----------start-----------");
        LRUCache cache = new LRUCache(2 /* 缓存容量 */);

        cache.put(2, 1);
        cache.put(1, 1);
        cache.put(2, 3);    // 该操作会使得密钥 2 作废
        cache.put(4, 1);    // 该操作会使得密钥 2 作废

        int i1 = cache.get(1);// 返回 -1 (未找到)

        int i2 = cache.get(2);// 返回 -1 (未找到)

//        int i = cache.get(2);// 返回  1
//        cache.put(3, 3);    // 该操作会使得密钥 2 作废
//        int i1 = cache.get(2);// 返回 -1 (未找到)
//        cache.put(4, 4);    // 该操作会使得密钥 1 作废
//        int i2 = cache.get(1);// 返回 -1 (未找到)
//        int i3 = cache.get(3);// 返回  3
//        int i4 = cache.get(4);// 返回  4
    }

    private int capacity;
    private int nodeNum;
    private Lnode head;
    private Lnode last;
    private HashMap<Integer, Lnode> map = new HashMap<>();


    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.nodeNum = 0;
        head = new Lnode();
        last = new Lnode();
        head.next = last;
        head.pre = null;
        last.pre = head;
        last.next = null;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Lnode lnode = map.get(key);
            moveToHead(lnode);
            return lnode.val;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (!map.containsKey(key)) {
            Lnode lnode = new Lnode(key, value);
            addHead(lnode);
            map.put(key, lnode);
            nodeNum++;
            if (nodeNum > capacity) {
                Lnode lastNode = last.pre;
                remove(lastNode);
                map.remove(lastNode.key);
                nodeNum--;
            }
        } else {
            Lnode lnode = map.get(key);
            lnode.val = value;
            // 覆盖完原值必须要记得 挪 到head
            moveToHead(lnode);
        }
        return;
    }

    // 从head新插节点
    private void addHead(Lnode lnode) {
        lnode.next = head.next;
        head.next.pre = lnode;
        lnode.pre = head;
        head.next = lnode;
    }

    // 重复访问，节点移到head
    private void moveToHead(Lnode lnode) {
        remove(lnode);
        addHead(lnode);
    }

    // 从双链表中删除节点
    private void remove(Lnode lnode) {
        lnode.next.pre = lnode.pre;
        lnode.pre.next = lnode.next;
    }

    class Lnode {
        int val;
        int key;
        Lnode next;
        Lnode pre;

        public Lnode() {
        }

        public Lnode(int key, int val) {
            this.val = val;
            this.key = key;
        }
    }
}
