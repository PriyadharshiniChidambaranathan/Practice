import java.util.*;
class Node {
    int value;
    Node next;
    public Node(int val){
        this.value = val;
        this.next = null;
    }
}

class LinkedList{
    Node head;
    int size = 0;

    LinkedList add(int value,LinkedList ll){      
        Node n = new Node(value);  
        if(ll.head == null){
            ll.head = n;
            size++;
        }
        else{
            Node temp = ll.head;
            while(temp.next != null){
               temp = temp.next;
            }
            temp.next  =  n;
            size++;
        }       
        return ll;
    }

    void insertAt(int pos,int val,LinkedList ll){
        Node n = new Node(val);
        if(pos < 0 || pos >= size){
            return;
        }
        if(ll.head == null){
            n = ll.head;
            return;
        }   
        if(pos == 0 ){
            n.next = ll.head;
            ll.head = n;
            return;

        }
        Node temp = ll.head;
        for(int i = 0; i < pos-1; i ++){
            temp = temp.next;
        }
        n.next = temp.next;
        temp.next = n;
              
        return ;
    }


    int search(int target){
        if(head == null){
            return -1;
        }
        int index = 0;
        Node temp = head;
        
        while( temp != null){
            if(temp.value == target){
                return index;
            }
            index++;
            temp = temp.next;
        }
        return -1;
    }

    List<Integer> findAll(int target){
        List<Integer> result = new ArrayList<>();
        if(head == null){
            return result; 
        }
        int index = 0;
        Node temp = head;
        while(temp != null){
            if(temp.value == target){
                result.add(index);
            }
            index++;
            temp = temp.next;
        }
        return result;
    }

    void print(){
        if(head == null){
            return;
        }
        Node temp = head;
        while(temp != null){
            System.out.print(temp.value+" ");
            temp = temp.next;
        }
        System.out.println("\n");
    }

    void deleteNode(){  //deleting last node;
        Node temp = head;
        while(temp.next.next != null){
            temp = temp.next;
        }
        temp.next= null;
    }

    void deleteAt(int pos){ 
        if(head == null){
            return;
        }
        if(pos >= size){
            System.out.println("Invalid Index;");
            return;
        }
        if(pos == 0){
            head = head.next;
            return;
        }
        if(pos == size-1){
            deleteNode();
            return;
        }

        Node temp = head;
        int index = 0;     
        while(temp.next != null){
            if(index == pos-1){
                temp.next = null;
                break;
            }
            temp = temp.next;
            index++;
        }
    }

    void reverse(){        
        Node prev = null, next =null;
        Node current = head;
        while(current != null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        } 
        head = prev;       
    }




    



}

public class LinkedListOperations {
    
    public static void main(String[] args){
        
        LinkedList ll = new LinkedList();
        ll= ll.add(23,ll);
        ll = ll.add(29,ll);
        ll = ll.add(16,ll);
        ll = ll.add(12,ll);
        ll = ll.add(16,ll);
        ll.insertAt(2,96,ll);  // negative values check to be done.
        ll.print();
        int target = 16;
        int found = ll.search(target);
        System.out.println("Element "+target+" found at index : "+found);
        List<Integer> all_occurence = ll.findAll(target);  
        System.out.println("Elements "+target+" found at indices  : "+all_occurence);
        ll.reverse();
        ll.print();
        ll.deleteNode();
        ll.deleteAt(3); 
        ll.print();      
        
        
       
        // Sort list
       
        
        // SubList from index i..j
        // containsSubList
        // Merge list sorted
        // ReverseList(startPosition)
        // swap(int posX, int posY)

        // Rotate array clockwise n times
        // Rotate array anticlockwise n times

        // splitList
        // splitList(splitPosition)
        // map() (will explain what is this)
        // Filter (will explain what is this)
        // maxWindow(will explain what is this)

    

    
    }

    

    Node insertAt(int pos,int val, Node head){
        Node n = new Node(val);
        Node temp = head;
        boolean posValid = true;
        if(pos == 1 ){
            n.next = temp;
            head = n;
            return head;

        }
        for(int i = 1; i < pos-1; i ++){
            temp = temp.next;
            if(temp.next == null){
                System.out.println("invalid position.");
                posValid = false;
                break;
            }
        }
        if(posValid){
            n.next = temp.next;
            temp.next = n;
        }        
        return head;
    }

    

    
    // void deleteAt(int pos, Node head){
    //     Node temp = head;
    //     int index = 0;
    //     while(temp.next != null){
    //         if(index == pos-1){
    //             temp.next = null;
    //             break;
    //         }
    //         temp = temp.next;
    //         index++;
    //     }
    //     System.out.println("After deleteing node at pos : "+ pos);
    //     print(head);
    // }
    
}
