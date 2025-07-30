package Day_029_Date_2025_12_21.LinkedList;

import java.util.ArrayList;
import java.util.List;

public class LinkedList {
    Node head;
    Node tail;
    int size = 0;

    public LinkedList(int data){
        Node newNode = new Node(data);
        head = newNode;
        tail = head;
        size++;
    }

    public void addLast(int data){
        Node newNode = new Node(data);
        if(tail==null){
            tail = newNode;
            size++;
            return;
        }
        tail.next = newNode;
        tail = newNode;
        size++;
    }

    public void addFirst(int data){
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
        size++;
    }

    public void deleteLast(){
        Node temp = head;
        //while
        List<Integer> list = new ArrayList<>();
        int[] arr = list.stream().mapToInt(Integer::intValue).toArray();
    }
    public void deleteFirst(){
        if(head!=null){
            head = head.next;
            size--;
        }
    }
    public int find(int data){
        Node temp = head;
        int index = 0;

        while(temp!=null){
            if(temp.data == data){
                return index;
            }
            index++;
            temp = temp.next;
        }
        return -1;
    }

    public void printAll(){
        Node temp = head;
        while(temp!=null){
            if(temp.next==null){
                System.out.println(temp.data);
                break;
            }
            System.out.print(temp.data+"->");
            temp = temp.next;
        }
    }
}
