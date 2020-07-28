package com.example.demo.web.entity.test;

import io.swagger.models.auth.In;

import java.text.DecimalFormat;
import java.util.*;

/**
 * @description:
 * @projectName:aradPeriod
 * @see:com.example.demo.web.entity.test
 * @author:陈金阳
 * @createTime:2020/7/27 17:40
 * @version:1.0
 */
public class Demo01 {
    public static void main(String[] args) {
        double result = 0;
        int[] nums1 = {1, 2, 9};
        int[] nums2 = {3, 4, 2, 3};
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums1.length; i++) {
            list.add(nums1[i]);
        }
        for (int j = 0; j < nums2.length; j++) {
            list.add(nums2[j]);
        }
        Collections.sort(list);
        if (list.size() > 0) {
            if (list.size() % 2 != 0) {
                result = list.get(list.size() / 2);
            } else {
                double a = list.get(list.size() / 2);
                double b = list.get(list.size() / 2 - 1);
                double c = 2;
                result = (a + b) / c;
            }
        }
        System.out.println(result);
    }

}
