package com.fslt.mycloudserver.algorithm;

/**
 * @description: IsInterleave
 * 是否为交叉字符串
 * https://www.lintcode.com/problem/interleaving-string/description
 * @date: 2020/5/15 11:11
 * @author: 林宗雄
 * @version: 1.0
 */
public class IsInterleave {

    /**
     * @param s1: A string
     * @param s2: A string
     * @param s3: A string
     * @return: Determine whether s3 is formed by interleaving of s1 and s2
     */
    public boolean isInterleave(String s1, String s2, String s3) {

        int length1 = s1.length();
        int length2 = s2.length();
        int length3 = s3.length();

        if (length1 + length2 != length3) {
            return false;
        }

        if (length1 * length2 == 0) {
            return s1.equals(s3) || s2.equals(s3);
        }

        int pointer1 = 0;
        int pointer2 = 0;
        int pointer3 = 0;

        int temp = 0;

        while (pointer3 < length3) {
            if (pointer1 < length1 && s1.charAt(pointer1) == s3.charAt(pointer3)) {
                if (s1.charAt(pointer1) == s2.charAt(pointer2)) {
                    pointer1++;
                    pointer2++;
                    pointer3++;
                    temp++;
                    continue;
                } else {
                    pointer1++;
                    pointer3++;
                    pointer1 -= temp;
                    pointer2 -= temp;
                    pointer3 -= temp;
                    temp = 0;
                }
            } else if (pointer2 < length2 && s2.charAt(pointer2) == s3.charAt(pointer3)) {
                if (s1.charAt(pointer1) == s2.charAt(pointer2)) {
                    pointer1++;
                    pointer2++;
                    pointer3++;
                    temp++;
                    continue;
                } else {
                    pointer2++;
                    pointer3++;
                    pointer1 -= temp;
                    pointer2 -= temp;
                    pointer3 -= temp;
                    temp = 0;
                }
            } else {
                if (temp == 0) {
                    return false;
                } else {
                    if (s3.charAt(pointer3) == s1.charAt(pointer1 - temp)) {
                        //1、保留s2
                        pointer1 -= temp;
                        pointer1++;
                        pointer3++;
                        temp = 0;
                    } else if (s3.charAt(pointer3) == s2.charAt(pointer2 - temp)) {
                        //2、保留s1
                        pointer2 -= temp;
                        pointer2++;
                        pointer3++;
                        temp = 0;
                    } else {
                        return false;
                    }

                }
            }

        }

//        if (s1.length() == 0 && s2.length() != 0) {
//            return signleIsInterleave(s2, s3);
//        } else if (s1.length() != 0 && s2.length() == 0) {
//            return signleIsInterleave(s1, s3);
//        } else {
//            return signleIsInterleave(s1, s3) && signleIsInterleave(s2, s3);
//        }

        return true;
    }

    public boolean signleIsInterleave(String s1, String s2) {
        int length1 = s1.length();
        int length2 = s2.length();

        int pointer1 = 0;
        int pointer2 = 0;

        while (pointer2 < length2) {
            if (pointer1 == length1 - 1) {
                return true;
            }
            if (s1.charAt(pointer1) == s2.charAt(pointer2)) {
                pointer1++;
                pointer2++;
            } else {
                pointer2++;
                continue;
            }
        }


        if (pointer1 == length1 - 1 || pointer1 == length1) {
            return true;
        } else {
            return false;
        }

    }

}
