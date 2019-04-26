package com.hjl.linkedList;

import java.util.Hashtable;
import java.util.LinkedList;

/**
 * @author jiale.he
 * @date 2019/03/18
 * @email jiale.he@mail.hypers.com
 */
public class SingleLinkedList {

    // 头结点
    private Node head = null;

    // 链表节点类
    public static class Node {
        // 存储数据
        private int data;
        // 指向下个节点引用
        private Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    public boolean isRinged(){
        if(head == null){
            return false;
        }
        Node fast = head;
        Node slow = head;
        while (fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

    /**
     * 返回最后一个节点
     * @return
     */
    public Node getLastNode(){
        Node q = head;
        while (q.next != null) {
            q = q.next;
        }
        return q;
    }

    /**
     * 反转链表
     */
    public void reverseLink(){
        // 当前节点
        Node cur = head;
        // 当前节点的前继节点
        Node pre = null;
        while (cur != null){
            // 抓住后继节点，防止链表断裂丢失
            Node nextNode = cur.next;
            // 当前节点指向前继节点（指针反转）
            cur.next = pre;
            // 前继节点后移
            pre = cur;
            // 当前节点后移
            cur = nextNode;

        }
        head = pre;
    }

    /**
     * 返回倒数第k个节点
     * 两个自增，第一个指针向前移动k个位置后，两个指针再一同前进
     * 当第一个指针到达末尾之时，后面的指针所在的位置就是倒数第k个位置
     * @param k
     * @return
     */
    public Node findReverNode(int k){
        if (k<0 || k>getLength()){
            return null;
        }
        Node q = head;
        Node p = head;
        for (int i = 0; i < k; i++) {
            q = q.next;
        }
        while (q != null){
            q = q.next;
            p = p.next;
        }
        return p;
    }

    /**
     * 去除链表重复元素
     * 需要额外的存储空间hashtable，调用hashtable.containsKey()来判断重复结点
     */
    public void distinchLink(){
        Node q = head;
        Node p = null;
        Hashtable<Integer,Integer> ht = new Hashtable<>();
        while (q != null){
            if (ht.contains(q.data)){
                p.next = q.next;
            }else {
                ht.put(q.data,1);
                p = q;
            }
            q = q.next;
        }
    }

    /**
     * 根据索引删除链表节点
     * @param index
     * @return
     */
    public boolean dropNode(int index) {
        if (index < 1 || index > getLength()){
            return false;
        }
        // 删除头节点
        if (index == 1) {
            head = head.next;
            return true;
        }
        Node q = head;
        // 寻找替换的节点
        int i = 1;
        while (q != null) {
            if (i == index-1){
                q.next = q.next.next;
                return true;
            }
            q = q.next;
            i++;
        }
        return true;
    }

    /**
     * 无头结点
     * 表头部插入
     * 这种操作将与输入顺序相反，逆序
     * @param value
     */
    public void addToHead(int value){
        Node newNode = new Node(value, null);
        // 空链表，插入的节点作为head
        if (head == null){
            head = newNode;
        }else {
            newNode.next=head;
            head = newNode;
        }
    }

    /**
     * 在链表末尾添加元素
     * @param value
     */
    public void addToTail(int value) {
        Node newNode = new Node(value, null);
        if (head == null){
            head = newNode;
        }else {
            // q 指向头结点,后续操作移动q即可，不需要移动head
            Node q = head;
            // q 节点后面时候有节点
            while (q.next != null){
                // 移动q
                q = q.next;
            }
            // q指向末尾节点
            q.next = newNode;
        }
    }

    public Node findByIndex(int index) {
        Node q = head;
        int n = 1;
        while (q != null && n != index){
            q = q.next;
            n++;
        }
        return q;
    }

    /**
     * 根据value找到节点
     * @param value
     * @return
     */
    public Node findByValue(int value){
        Node q = head;
        while (q != null && q.data != value){
            q = q.next;
        }
        return q;
    }

    public int getLength(){
        int len = 0;
        Node q = head;
        while (q != null){
            len ++;
            q = q.next;
        }
        return len;
    }

    /**
     * 打印链表
     */
    public void printAll(){
        cheakHead();
        Node q = head;
        while (q != null) {
            System.out.print(q.data+"   ");
            q = q.next;
        }
        System.out.println();
    }

    public void cheakHead(){
        if(head == null){
            System.out.println("Head Node Is NULL!");
            return;
        }
    }

    public static void main(String[] args) {
        SingleLinkedList list = new SingleLinkedList();
        list.addToHead(1);
        list.addToHead(2);
        list.addToHead(3);
        list.addToHead(4);
        list.printAll();
//        System.out.println(list.findByValue(3).data);
//        System.out.println(list.findByIndex(1).data);
//        System.out.println(list.getLength());
//        list.dropNode(3);
//        list.distinchLink();
//        list.printAll();
        System.out.println(list.findReverNode(2).data);
//        list.reverseLink();
        list.printAll();

        System.out.println(list.isRinged());
        //list.getLastNode().next = list.head;
        System.out.println(list.isRinged());

        list.printAll();

    }

}
