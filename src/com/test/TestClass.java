package com.test;

import com.guojun.jiao.chapter3.MyArrayList;
import com.guojun.jiao.chapter3.MyLinkedList;
import com.sun.xml.internal.ws.api.WSService;

import java.util.*;

/**
 * @Author: JiaoGuojun
 * @Description:
 * @Date: Created in 9:42 2017/10/17
 */
public class TestClass {
    public static void main(String[] args) {

//        myArrayListTest();
//        array();
        myLinkedList();


    }


    public static String arr2String(Object[] arr){
        StringBuffer sb = new StringBuffer();
        sb.append("[");
        for (Object obj:arr){
            sb.append(obj.toString()).append(",");
        }
        return sb.substring(0,sb.lastIndexOf(","))+"]";
    }

    public static String toString(MyLinkedList myLinkedList){
        Iterator<String> iterator = myLinkedList.iterator();
        StringBuffer sb = new StringBuffer();
        sb.append("[");
        while(iterator.hasNext()){
            sb.append(iterator.next());
            sb.append(",");
        }
        return sb.substring(0,sb.lastIndexOf(","))+"]";
    }

    public static void myLinkedList(){
        MyLinkedList<String> myLinkedList = new MyLinkedList<String>();
        System.out.println(myLinkedList.size());
        myLinkedList.add("1");
        myLinkedList.add("2");
        myLinkedList.add("3");
        System.out.println(toString(myLinkedList));
    }

    public static void array(){
        String [] arr1 = new String[]{"1","2","3"};
        String [] arr2 = {"a","b","c"};
        System.out.println("arr1:"+arr2String(arr1));
        System.out.println("arr2:"+arr2String(arr2));
        System.out.println("arr1:"+arr1.toString()+"......"+"arr2:"+arr2.toString());
        arr1 = arr2;
        arr1[0]="1";
        System.out.println("arr1:"+arr2String(arr1));
        System.out.println("arr2:"+arr2String(arr2));
        System.out.println("arr1:"+arr1.toString()+"......"+"arr2:"+arr2.toString());
    }

    public static void myArrayListTest(){
        List<String> arrayList = new ArrayList<String>();
        arrayList.add("1");
        arrayList.add("2");
        arrayList.add("3");
        arrayList.add("4");
        arrayList.add("5");
        System.out.println(arrayList);
        System.out.println(arrayList.size());
        arrayList.clear();
        System.out.println(arrayList);
        System.out.println(arrayList.size());

        System.out.println("----------自定义arrayList集合------------");
        MyArrayList<String> myArrayList = new MyArrayList<String>();
        myArrayList.add("a");
        myArrayList.add("b");
        myArrayList.add("c");
        myArrayList.add("d");
        myArrayList.add("e");
        myArrayList.add("f");
        myArrayList.add("g");
        myArrayList.add("h");
        myArrayList.add("i");
        System.out.println(myArrayList.size());
        System.out.println(myArrayList.get(4));
       // System.out.println(toString(myArrayList));
        System.out.println(myArrayList.isEmpty());
        myArrayList.set(4,"f");
        //System.out.println(toString(myArrayList));
        myArrayList.clear();
        System.out.println(myArrayList.size());
        System.out.println(myArrayList.isEmpty());
    }
}
