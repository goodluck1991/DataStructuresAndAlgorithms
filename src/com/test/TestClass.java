package com.test;

import com.guojun.jiao.chapter3.MyArrayList;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @Author: JiaoGuojun
 * @Description:
 * @Date: Created in 9:42 2017/10/17
 */
public class TestClass {
    public static void main(String[] args) {

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
        System.out.println(toString(myArrayList));
        System.out.println(myArrayList.isEmpty());
        myArrayList.set(4,"f");
        System.out.println(toString(myArrayList));
        myArrayList.clear();
        System.out.println(myArrayList.size());
        System.out.println(myArrayList.isEmpty());


    }

    public static String toString(MyArrayList myArrayList){
        Iterator<String> iterator = myArrayList.iterator();
        StringBuffer sb = new StringBuffer();
        sb.append("[");
        while(iterator.hasNext()){
            sb.append(iterator.next());
            sb.append(",");
        }
        return sb.substring(0,sb.lastIndexOf(","))+"]";
    }
}
