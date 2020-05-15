package com.fslt.mycloudserver.algorithm;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @description: IsInterleaveTest
 * @date: 2020/5/15 11:22
 * @author: 林宗雄
 * @version: 1.0
 */
class IsInterleaveTest {

    @Test
    void isInterleave() {

        String s1 = "aabcc";
        String s2 = "dbbca";
        String s3 = "aadbbcbcac";

        Boolean result = new IsInterleave().isInterleave(s1, s2, s3);

        System.out.println(result);


    }
}