package com.hjl.linkedList;

import java.util.Scanner;

/**
 * @author jiale.he
 * @date 2019/03/19
 * @email jiale.he@mail.hypers.com
 *
 * 使用链表实现LRU缓存机制
 */
public class LRULinkedList<T> {
    // 默认链表容量
    private final static Integer DEFAULT_CAPACITY = 10;
    // 链表容量
    private Integer capacity;
    // 链表实际长度
    private Integer length;
    // 链表头结点
    private SNode head;

    private class SNode<T> {
        private T data;
        private SNode next;
        public SNode(T data, SNode next) {
            this.data = data;
            this.next = next;
        }

        public SNode() {
        }
    }

    public LRULinkedList(Integer capacity) {
        this.capacity = capacity;
        this.length = 0;
    }

    public LRULinkedList() {
        this.capacity = DEFAULT_CAPACITY;
        this.length = 0;
    }

    /**
     * 输出链表
     */
    public void printAll(){
        SNode cur = head;
        while (cur != null) {
            System.out.print(cur.data+"   ");
            cur = cur.next;
        }
        System.out.println();
    }

    /**
     * 添加方法
     * @param value
     */
    public void add(T value) {
        SNode cur = find(value);
        // 缓存中无数据
        if (cur == null) {
            if (length >= this.capacity){
                deleteTail();
            }
            addHead(value);
        }else {
            // 缓存有数据
            deleteCurNode(value);
            addHead(value);
        }
    }

    /**
     * 查找value对应的节点
     * @param value
     * @return
     */
    public SNode find(T value){
        if (head == null) {
            return null;
        }
        SNode cur = head;
        while (cur != null){
            if (value.equals(cur.data)){
                return cur;
            }
            cur = cur.next;
        }
        return null;
    }

    /**
     * 删除查找到的节点
     * @param value
     */
    public void deleteCurNode(T value){
        if (head == null) {
            return;
        }
        if(value.equals(head.data)){
            head = head.next;
            return;
        }
        SNode cur = head;
        while (cur.next!=null && cur.next.data!=value){
            cur = cur.next;
        }
        cur.next = cur.next.next;
        length --;
    }

    /**
     * 删除末尾节点
     */
    public void deleteTail(){
        // 如果是空链表，直接返回
        if (head == null){
            return;
        }
        SNode cur = head;
        // 找到倒数第二个节点
        while (cur.next.next != null) {
            cur = cur.next;
        }
        cur.next = null;
        length --;
    }

    /**
     * 头部添加节点
     * @param value
     */
    public void addHead(T value){
        SNode newNode = new SNode<>(value, null);
        if (head == null){
            head = newNode;
        }else {
            newNode.next = head;
            head = newNode;
        }
        length ++;
    }

    public static void main(String[] args) {
        LRULinkedList list = new LRULinkedList();
        Scanner sc = new Scanner(System.in);
        while (true) {
            list.add(sc.nextInt());
            list.printAll();
        }
    }
}
