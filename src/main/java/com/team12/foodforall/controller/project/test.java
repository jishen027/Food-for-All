package com.team12.foodforall.controller.project;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author: Heng Gao
 * @date: 02/05/2022 17:34
 **/
public class test {
    public static void main(String[] args) {
        Path path = Paths.get(".");
        System.out.println(path.toAbsolutePath());




        String s1 = "a";

        System.out.println(String.format("a word: %s", s1));
        System.out.println("a word: " + s1);
    }
}
