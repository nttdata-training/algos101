package com.nttdata.work;

import java.util.Scanner;

public class ReverseLinkedList {
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

    Node createNode(int i) {
        Node newNode = new Node(i);
        return newNode;
    }

    void reverseList() {
        Node previous = head;
        if (head.next == null) return;
        Node current = head.next;
        head.next = null;
        while (current != null) {
            Node next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        head = previous;
    }

    void printList(){
        Node current = head;
        do {
            System.out.print(current.data + " -> ");
            current = current.next;
        } while (current != null);
        System.out.println("Null");
    }

    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        ReverseLinkedList llist = new ReverseLinkedList();
        for (int i = 1; i <= n; i++) {
            if (llist.end != null) {
                llist.end.next = llist.createNode(i);
                llist.end = llist.end.next;
            }
            else {
                llist.head = llist.createNode(i);
                llist.end = llist.head;
            }
        }
        llist.printList();
        llist.reverseList();
        llist.printList();
    }
}
