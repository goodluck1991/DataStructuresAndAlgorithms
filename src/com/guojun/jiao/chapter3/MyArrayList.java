package com.guojun.jiao.chapter3;

import java.util.Iterator;

/**
 * @Author: JiaoGuojun
 * @Description:
 * @Date: Created in 15:47 2017/10/16
 */
public class MyArrayList<AnyType> implements Iterable<AnyType>{
    private static final int DEFAULT_CAPACITY = 10;
    private int theSize;
    private AnyType [] theItems;

    public MyArrayList(){
        theSize = 0;
        ensureCapacity(DEFAULT_CAPACITY);
    }

    private void doClear(){
        theSize=0;
        ensureCapacity(DEFAULT_CAPACITY);
    }

    public void clear(){
        doClear();
    }

    public int size(){
        return theSize;
    }

    public boolean isEmpty(){
        return size()==0;
    }

    public AnyType get(int idx){
        if(idx<0||idx>=size())
            throw new ArrayIndexOutOfBoundsException();
        return theItems[idx];
    }

    public AnyType set(int idx,AnyType anyType){
        if(idx<0||idx>=size())
            throw new ArrayIndexOutOfBoundsException();
        AnyType old = theItems[idx];
        theItems[idx] = anyType;
        return old;
    }

    public void ensureCapacity(int newCapacity){
        if(newCapacity<theSize)
            return ;
        AnyType [] old = theItems;
        theItems = (AnyType[]) new Object[newCapacity];
        for (int i=0;i<size();i++){
            theItems[i] = old[i];
        }
    }

    public boolean add(AnyType anyType){
        add(size(),anyType);
        return true;
    }

    public void add(int idx,AnyType anyType){
        if(size()==theItems.length)
            ensureCapacity(size()*2+1);
        theItems[idx] = anyType;
        theSize++;
    }

    public AnyType remove(int idx){
        if(idx<0||idx>=size())
            throw new ArrayIndexOutOfBoundsException();
        AnyType anyType = theItems[idx];
        for (int i=idx;i<size()-1;i++)
            theItems[i]=theItems[i+1];
        return anyType;
    }
    public Iterator<AnyType> iterator(){
        return new MyArrayListIterator();
    }

     class MyArrayListIterator implements Iterator<AnyType>{
        private int current=0;
        public boolean hasNext(){
            return current<size();
        }

        public AnyType next(){
            AnyType anyTypes = theItems[current];
            current++;
            return anyTypes;
        }

        @Override
        public void remove() {
            MyArrayList.this.remove(--current);
        }
    }
}
