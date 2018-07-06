package com.nttdata.work;

import java.util.Scanner;

public class LinkedList {
    Node head;
    Node end;

    class Node {
        int data;
        Node next;
        Node(int d) {
            this.data = d;
            this.next = null;
        }
    }

    Node getMiddle(Node start){
        Node fast = start;
        Node slow = start;
        int odd = -1;
        if (fast.next == null) return slow;
        else fast = fast.next;
        while (fast.next != null) {
            if (odd > 0 ) slow = slow.next;
            odd *= -1;
            fast = fast.next;
        }
        return slow;
    }

    Node createNode(int i) {
        Node newNode = new Node(i);
        return newNode;
    }

    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        int length = scan.nextInt();
        LinkedList llist = new LinkedList();
        for (int i = 1; i <= length; i++) {
            if (llist.end != null) {
                llist.end.next = llist.createNode(i);
                llist.end = llist.end.next;
            }
            else {
                llist.head = llist.createNode(i);
                llist.end = llist.head;
            }
        }
        System.out.println("Middle is " + llist.getMiddle(llist.head).data);
    }

}
