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

    private static long headOffset = 0L;
    private static long tailOffset = 0L;

    static {
        try {
            headOffset = MyUnSafe.unsafe.objectFieldOffset(ThreadLink.class.getDeclaredField("head"));
            tailOffset = MyUnSafe.unsafe.objectFieldOffset(ThreadLink.class.getDeclaredField("tail"));
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    private boolean compareAndSetHead(Node node) {
        return MyUnSafe.unsafe.compareAndSwapObject(this, headOffset, null, node);
    }

    private boolean compareAndSetTail(Node expect, Node node) {
        return MyUnSafe.unsafe.compareAndSwapObject(this, tailOffset, expect, node);
    }

    class Node {
        volatile Thread thread;
        volatile Node prev;
        volatile Node next;

        public Node(Thread thread) {
            this.thread = thread;
        }
    }

    public Node addWaiter() {
        Node node = new Node(Thread.currentThread());
        while (true) {
            Node pred = tail;
            if (pred != null) {
                //如果链表为空，则抢设链表头部
                if (compareAndSetTail(pred, node)) {
                    //如果抢设成功。则将链表尾部指向node，并退出循环
                    node.prev = pred;
                    pred.next = node;
                    return node;
                }
            } else {
                //如果链表不为空，则抢设链表尾部
                if (compareAndSetHead(node)) {
                    //如果抢设成功，则退出循环
                    tail = node;
                    return node;
                }
            }
        }
    }

    public void release() {
        if (head != null) {
            Node oldHead = head;
            Node newHead = oldHead.next;
            head = newHead;
            oldHead.next = null;
            MyUnSafe.unsafe.unpark(oldHead.thread);
            if (newHead != null) {
                newHead.prev = null;
            }
        }
    }
}
