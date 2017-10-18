package com.guojun.jiao.chapter3;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

/**
 * @Author: JiaoGuojun
 * @Description:
 * @Date: Created in 14:48 2017/10/18
 */
public class MyLinkedList<AnyType> implements Iterable<AnyType>{
    private Node<AnyType> startMarker;//开始节点
    private Node<AnyType> endMarker;//结束节点
    private int theSize;//总长度
    private int modCount;//修改次数,每次add,set,remove时递增,防止迭代器迭代时,数据进行修改

    //封装节点类
    private static class Node<AnyType>{
        public AnyType data;
        public Node<AnyType> prev;
        public Node<AnyType> next;
        public Node(AnyType data,Node<AnyType> prev,Node<AnyType> next){
            this.data = data;
            this.prev = prev;
            this.next = next;
        }
    }

    public int size(){
        return theSize;
    }

    public boolean isEmpty(){
        return size()==0;
    }

    public void clear() {
        doClear();
    }

    private void doClear(){
        startMarker = new Node<AnyType>(null,null,null);
        endMarker = new Node<AnyType>(null,startMarker,null);
        startMarker.next = endMarker;

        theSize = 0;
        modCount++;
    }

    public boolean add(AnyType anyType){
        addBefore(get(size()),anyType);
        return true;
    }

    public void addBefore(Node<AnyType> node,AnyType anyType){
        Node<AnyType> newNode = new Node<AnyType>(anyType,node.prev,node);
        node.prev.next = newNode;
        node.prev = newNode;
        theSize++;
        modCount++;
    }

    public AnyType set(int idx,AnyType anyType){
        Node<AnyType> oldNode = get(idx);
        oldNode.data = anyType;
        modCount++;
        return oldNode.data;
    }

    public AnyType remove(int idx){
        return remove(get(idx));
    }

    private AnyType remove(Node<AnyType> node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
        theSize--;
        modCount++;
        return node.data;
    }

    public Node<AnyType> get(int idx){
        return getNode(idx,0,size());
    }

    private Node<AnyType> getNode(int idx,int lower,int upper){
        if(idx<idx||idx>upper)
            throw new ArrayIndexOutOfBoundsException();
        Node<AnyType> currentNode ;
        if(idx<size()/2){//正向查找
            currentNode = startMarker.next;
            for(int i=0;i<idx;i++)
                currentNode = currentNode.next;
        }else{//逆向查找
            currentNode = endMarker;
            for(int i=size();i>idx;i--)
                currentNode = currentNode.prev;
        }
        return currentNode;
    }

    //初始化空链表
    public MyLinkedList(){
        doClear();
    }


    @Override
    public Iterator<AnyType> iterator() {
        return new MyLinkedListIterator();
    }

    private class MyLinkedListIterator implements Iterator<AnyType>{
        private Node<AnyType> currentNode = startMarker.next;
        private int expectedModCount = modCount;
        private boolean okToRemove = false;
        @Override
        public boolean hasNext() {
            return currentNode!=endMarker;
        }

        @Override
        public AnyType next() {
            if(expectedModCount!=modCount)
                throw new ConcurrentModificationException();
            if(!hasNext())
                throw new ArrayIndexOutOfBoundsException();
            okToRemove = true;
            currentNode = currentNode.next;
            return currentNode.prev.data;
        }

        @Override
        public void remove() {
            if(expectedModCount!=modCount)
                throw new ConcurrentModificationException();
            if(!okToRemove)
                throw new IllegalStateException();
            MyLinkedList.this.remove(currentNode.prev);
            okToRemove = false;
            expectedModCount++;
        }
    }
}
