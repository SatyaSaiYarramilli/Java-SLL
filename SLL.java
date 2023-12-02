package sll;

//import java.util.LinkedList;
import java.util.Scanner;

public class SLL {

    public static void main(String[] args) {
        System.out.println("Sai Branch");
        Scanner sc = new Scanner(System.in);
        LinkedList ll = new LinkedList();
        int ch;
        do {
            System.out.println("1. Creation \n2. Display\n3. Insert\n4.Delete\n5.Search\n6.Exit\nEnter your choice: ");
            ch = sc.nextInt();
            switch (ch) {
                case 1:
                    ll.create();
                    break;
                case 2:
                    ll.display();
                    break;
                case 3:
                    ll.insert();
                    break;
                case 4:
                    ll.delete();
                    break;
                case 5:
                    System.out.println("Enter search key: ");
                    int key = sc.nextInt();
                    ll.search(key);
                    break;
                case 6:
                    System.exit(0);
                default:
                    System.out.println("Enter correct choice");
            }
        } while (ch != 6);
    }
}

class Node {

    int data;
    Node link;

    Node(int d) {
        data = d;
        link = null;
    }
}

class LinkedList {

    Node first, last;
    Scanner sc = new Scanner(System.in);

    LinkedList() {
        first = last = null;
    }

    void create() {
        int item;
        do {
            System.out.println("Enter number: ");
            item = sc.nextInt();
            if (item == -1) {
                break;
            }
            Node temp = new Node(item);
            if (first == null) {
                first = last = temp;
            } else {
                last.link = temp;
                last = temp;
            }
        } while (item != -1);
    }

    void display() {
        if (first == null) {
            System.out.println("List is empty");
            return;
        }
        Node temp;
        temp = first;
        while (temp != null) {
            System.out.print(temp.data + "  ");
            temp = temp.link;
        }
    }

    int length() {
        int l;
        Node temp = first;
        for (l = 1; temp != null; l++){
            temp = temp.link;
        }
        return l;
    }

    void insert() {
        System.out.println("Enter Position: ");
        int pos = sc.nextInt();
        if (pos > 0 && pos <= length()) {
            System.out.println("Enter item: ");
            int item = sc.nextInt();
            Node temp = new Node(item);
            if (pos == 1) {
                temp.link = first;
                first = temp;
            } else {
                Node prev, curr;
                prev = curr = first;
                int i = 1;
                while (i < pos) {
                    prev = curr;
                    curr = curr.link;
                    i++;
                }
                prev.link = temp;
                temp.link = curr;
            }
        } else {
            System.out.println("No such place");
        }
    }

    void delete() {
        if (first == null) {
            System.out.println("List is empty");
            return;
        }
        System.out.println("Enter position: ");
        int pos = sc.nextInt();
        if (pos > 0 && pos <= length()) {
            if (pos == 1) {
                first = first.link;
            } else {
                Node prv, curr;
                prv = curr = first;
                int i = 1;
                while (i < pos) {
                    prv = curr;
                    curr = curr.link;
                    i++;
                }
                prv.link = curr.link;
            }
        }
    }

    void search(int key) {
        Node temp;
        int flag = 0;
        temp = first;
        while (temp != null) {
            if (temp.data == key) {
                flag = 1;
                break;
            }
            temp = temp.link;
        }
        if (flag == 1) {
            System.out.println("Element found");
        } else {
            System.out.println("Not found");
        }
    }
}
