package com.jiepi.concurrency.Immutable;

import java.util.HashMap;
import java.util.Map;

public class ImmutableExample1 {
    /**
     * 1.基本类型不能被修改
     * 2.引用类型不能被在引用其他对象
     */
    private  final static Integer a =1;
    private final  static  String b="2";
    private final  static Map  map = new HashMap();

    static {
        map.put("1",2);
        map.put("3",4);
        map.put("5",6);
    }

    public static void main(String[] args) {
//        a=2;
//        b="3";
//        map = new HashMap();
    }
}
