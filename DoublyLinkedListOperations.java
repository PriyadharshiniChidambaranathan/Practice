import java.util.ArrayList;
import java.util.List;

class Node{
    int data;
    Node next;
    Node prev;
    Node(int data){
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}
class DoublyLinkedList{
    Node head;
    int size = 0;

    Node addLast(int value){    //adding element at end
        Node n = new Node(value);
        if(head == null){
            n.prev = null;
            head =n;
            size++;
            return head;
        }
        Node temp = head;
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = n;
        n.prev = temp;
        size++;
        return head;
    }

    Node addFirst(int value){
        Node n = new Node(value);
        if(head == null){
            n.prev = null;
            head = n;
            size++;
            return head;
        }
        n.prev = null;
        n.next = head;
        head = n;   
        size++; 
        return head;    
    }

    Node addPos(int pos, int value){
        
        Node n = new Node(value);
        if(head == null){
            return null;
        }
        if(pos > size || pos < 0 ){
            return head;
        }
        Node temp = head;
        int index = 0;
        while(temp != null){
            if(index == pos -1){
                temp.next.prev = n;
                n.next = temp.next;
                n.prev = temp;
                temp.next = n;
                size++;
                return head;
            }
            index++;
            temp = temp.next;
        }
        size++;
        return head;
    }

    Node deleteLast(){
        if(head == null){
            return null;
        }
        Node temp = head;
        while(temp.next.next != null){
            temp = temp.next;
        }
        temp.next = null;
        return head;
    }

    Node deleteFirst(){
        if(head == null){
            return head;
        }
        head = head.next;
        return head;
    }

    Node deletePos(int pos){
        if(head == null){
            return null; 
        }
        if(pos < 0){
            return head;
        }
        Node temp = head;
        int index = 0;
        while(temp != null){
            if(index == pos - 1){ 
                temp.next  = temp.next.next;
                temp.next.prev = temp;
                return head;
            }
            temp = temp.next;
            index++;
        }    
        return head;    
    }

    int find(int target){
        if(head == null){
            return -1;
        }
        Node temp = head;
        int index = 0;
        while(temp != null){
            if(temp.data == target){
                return index+1;
            }
            index++;
            temp = temp.next;
        }
        return index+1;
    }

    List<Integer> findAll(int target){
        List<Integer> result = new ArrayList<>();
        if(head == null){
            return result;
        }
        Node temp = head;
        int index = 0;
        while(temp != null){
            if(temp.data == target){
                result.add(index+1);
            }
            index ++;
            temp = temp.next;
        }
        return result;        
    }

    
    Node rotate_Left(int k){
        if(head == null){
            return head;
        }
        int len = 1;
        Node temp = head;
        while(temp.next != null){
            temp = temp.next;
            len++;
        }
        if(k > len){
            k = k % len;
        }
        if(k == 0 || k == len){
            return head;
        }

        Node current = head;
        while(k > 1 && current != null){
            current = current.next;
            k--;
        }
 
        temp.next = head;
        head.prev = temp;
        head = current.next;
        current.next = null;
        return head;
    }

    Node rotate_Right(int k){
        if(head == null){
            return head;
        }
        int len = 1;
        Node temp = head;
        while(temp.next != null){
            temp = temp.next;
            len++;
        }
        if(k > len){
            k = k % len; 
        }
        k = len - k;
        if( k == 0 || k == len){
            return head;
        }

        Node current = head;
        while(k > 1 && current != null){
            current = current.next;
            k--;
        }

        temp.next = head;
        (head).prev  = temp;
        head =  current.next; 
        current.next = null;
        return head; 
    }

    Node swap(int posX, int posY){
        return head;
    }
    Node sort(){
        return head;

    }
    Node subList(int start, int end){
        return head;
    }


    void print(Node head){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println("\n");
    }


}


public class DoublyLinkedListOperations {
    public static void main(String[] args){
        DoublyLinkedList dll = new DoublyLinkedList();
        Node head = null;
        head = dll.addLast(23);
        head = dll.addLast(29);
        head = dll.addLast(16);
        dll.print(head);
        head = dll.addFirst(99);
        dll.print(head);
        head = dll.addPos(1,200);
        dll.print(head);
        Node delfirst = dll.deleteFirst();
        System.out.println("After deleting 1st Node.");
        dll.print(delfirst);
        Node deleLast = dll.deleteLast();
        System.out.println("After deleting last Node.");
        dll.print(deleLast);
        Node delepos = dll.deletePos(1);
        System.out.println("After deleting position Node.");
        dll.print(delepos);
        int found = dll.find(29);
        System.out.println("ELement found at index : "+ found+"\n");
        List<Integer> alloccur = dll.findAll(29);
        System.out.println("All occurence : "+alloccur+"\n");
        
        head = dll.addLast(5);
        head = dll.addLast(4);
        head = dll.addLast(3);
        head = dll.addLast(2);
        head = dll.addLast(1);
        dll.print(head);
        int k = 10;
        Node left_rotate = dll.rotate_Left(k);
        System.out.println("After "+k+" roatation in anticlockwise : ");
        dll.print(left_rotate);
        Node right_rotate = dll.rotate_Right(k);
        System.out.println("After "+ k + " rotations in clockwise.");
        dll.print(right_rotate);
        Node swapped = dll.swap(2,3);
        System.out.println("After swapping :");
        dll.print(swapped);
        Node list2 =  dll.subList(2,5);
        System.out.println("Created sublist : ");
        dll.print(list2);
        Node sorted = dll.sort();
        System.out.println("After sort  : ");
        dll.print(sorted);
        
    }
    
}
