package org.yeasheng.componet;

/**
 * LinkNode
 *
 * @author yansh
 * @version 2023/1/8
 **/
public class LinkNode {

    Node head = null;

    class Node {
        Node next = null;
        int val;

        public Node(int val) {
            this.val = val;
        }
    }

    /**
     * 乡链表中添加数据
     *
     * @param val
     */
    public void add(int val) {
        Node newNode = new Node(val);
        if (head == null) {
            head = newNode;
            return;
        }
        // 临时保存头节点
        Node tmp = head;
        while (tmp.next != null) {
            tmp = tmp.next;
        }
        // 将新建的节点赋值
        tmp.next = newNode;
    }

    /**
     * 删除第index个节点
     *
     * @param index
     * @return
     */
    public boolean deleteNode(int index) {
        if (index < 1 || index > length()) {
            return false;
        }
        if (index == 1) {
            head = head.next;
            return true;
        }
        int i = 1;
        Node preNode = head;
        Node curNode = preNode.next;
        while (curNode.next != null) {
            if (i == index) {
                preNode.next = curNode.next;
                return true;
            }
            // 一直往后找遍历找节点
            preNode = curNode;
            curNode = curNode.next;
            i++;
        }
        return false;
    }

    /**
     * 返回链路的长度
     *
     * @return
     */
    public int length() {
        int length = 0;
        Node tmp = head;
        while (tmp != null) {
            length++;
            tmp = tmp.next;
        }
        return length;
    }

    public String iterator(LinkNode node) {
        StringBuilder sb = new StringBuilder();
        Node head = node.head;
        while (head != null) {
            sb.append(head.val);
            if (head.next != null) {
                head = head.next;
            }
        }

        return sb.toString();
    }

}
