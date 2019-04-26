package com.hjl.array;

import java.util.Arrays;

/**
 * @author jiale.he
 * @date 2019/03/18
 * @email jiale.he@mail.hypers.com
 */
public class GenericaArray<T> {
    private T[] data;
    private int size;

    // 根据传入容量，构造Array
    public GenericaArray(int capacity) {
        data = (T[]) new Object[capacity];
        size = 0;
    }

    // 无参构造，默认容量10
    public GenericaArray(){
        this(10);
    }

    // 获取数组容量
    public int getCapacity(){
        return data.length;
    }

    // 获取当前元素个数
    public int count(){
        return this.size;
    }

    // 判断数组时候为空
    public boolean isEmpty(){
        return size == 0;
    }

    // 修改index位置的元素
    public void set(int index, T e){
        checkIndex(index);
        data[index] = e;
    }

    // 获取对应index位置的元素
    public T get(int index) {
        checkIndex(index);
        return data[index];
    }

    // 包含
    public boolean contains(T e) {
        for (int i = 0; i < size; i++){
            if (data[i].equals(e)){
                return true;
            }
        }
        return false;
    }

    // 获取对应元素的下标
    public int find(T e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)){
                return i;
            }
        }
        return -1;
    }


    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("Array size = %d, capacity = %d \n", size, data.length));
        builder.append('[');
        for (int i = 0; i < size; i++) {
            builder.append(data[i]);
            if (i != size - 1) {
                builder.append(", ");
            }
        }
        builder.append(']');
        return builder.toString();
    }

    // 扩容方法, 时间复杂度O(n)
    private void resize(int capacity) {
        T[] newData = (T[]) new Object[capacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    // 检查下标是否合法
    private void checkIndex(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Failed! Require index >=0 and index <= size.");
        }
    }



}
