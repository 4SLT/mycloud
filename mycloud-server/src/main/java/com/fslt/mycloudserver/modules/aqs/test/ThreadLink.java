package com.fslt.mycloudserver.modules.aqs.test;


/**
 * @description: ThreadLink
 * @date: 2020/5/13 18:00
 * @author: 林宗雄
 * @version: 1.0
 */
public class ThreadLink {

    volatile Node head;
    volatile Node tail;

    class Node {
        volatile Thread thread;
        volatile Node prev;
        volatile Node next;

        public Node(Thread thread) {
            this.thread = thread;
        }

    }
}
