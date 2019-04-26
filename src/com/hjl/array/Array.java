package com.hjl.array;

/**
 * @author jiale.he
 * @date 2019/03/18
 * @email jiale.he@mail.hypers.com
 */
public class Array {
    private int data[];
    private int n;
    private int count;

    /**
     * 构造方法，定义数组大小
     * @param capacity
     */
    public Array(int capacity){
        this.data = new int[capacity];
        this.n = capacity;
        // 刚开始 数组没有数据，所以是0
        this.count = 0;
    }

    /**
     * 根据索引，找到数组中元素并返回
     * @param index
     * @return
     */
    public int find(int index){
        if (index < 0 || index >= count)
            return -1;
        return this.data[index];
    }

    /**
     * 插入元素：头部插入，尾部插入
     * @param index
     * @param value
     * @return
     */
    public boolean insert(int index, int value){
        // 数组空间已满
        if (count == n){
            System.out.println("数组已满");
            return false;
        }
        // count没满，可以插入
        // 位置不合法
        if (index < 0 || index > count){
            System.out.println("位置不合法");
            return false;
        }
        //位置合法
        for (int i = count; i > index; --i) {
            data[i] = data[i - 1];
        }
        data[index] = value;
        ++count;
        return true;
    }

    /**
     * 根据索引，删除数组中元素
     * @param index
     * @return
     */
    public boolean delete(int index){
        if (index<0 || index>=count) return false;
        // 从删除位置开始，将后面的元素向前移动一位
        for (int i = index+1; i<count; ++i) {
            data[i-1] = data[i];
        }
        --count;
        return true;
    }

    public void pringtAll() {
        for (int n : this.data) {
            System.out.print(n+"    ");
        }
        System.out.println();
    }

}
