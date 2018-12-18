package com.example.demo;

import com.example.demo.entity.UserDO;

import java.util.ArrayDeque;
import java.util.Queue;

public class UserTest {

    public static void main(String[] args) {

        Queue queue=new ArrayDeque();
        queue.add("123");
        Object peek = queue.poll();
        System.out.println(peek.toString());
        System.out.println(queue.size());
    }
}
