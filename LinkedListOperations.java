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

    Node add(int value){      
        Node n = new Node(value);  
        if(head == null){
            head = n;
            size++;
        }
        else{
            Node temp = head;
            while(temp.next != null){
               temp = temp.next;
            }
            temp.next  =  n;
            size++;
        }       
        return head;
    }

    Node insertAt(int pos,int val,LinkedList ll){
        Node n = new Node(val);
        if(pos < 0 || pos >= size){
            return head;
        }
        if(ll.head == null){
            n = ll.head;
            return head;
        }   
        if(pos == 0 ){
            n.next = ll.head;
            ll.head = n;
            return head;

        }
        Node temp = ll.head;
        for(int i = 0; i < pos-1; i ++){
            temp = temp.next;
        }
        n.next = temp.next;
        temp.next = n;
              
        return head;
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

    void print(Node head){
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

    Node deleteNode(){  //deleting last node;
        Node temp = head;
        while(temp.next.next != null){
            temp = temp.next;
        }
        temp.next= null;
        return head;
    }

    Node deleteAt(int pos){ 
        if(head == null){
            return head;
        }
        if(pos >= size){
            System.out.println("Invalid Index;");
            return head;
        }
        if(pos == 0){
            head = head.next;
            return head;
        }
        if(pos == size-1){
            deleteNode();
            return head;
        }

        Node temp = head;
        int index = 0;     
        while(temp.next != null){
            if(index == pos-1){
                temp.next = temp.next.next;
                break;
            }
            temp = temp.next;
            index++;
        }
        return head;
    }

    Node reverse(){        
        Node prev = null, next =null;
        Node current = head;
        while(current != null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        } 
        head = prev;    
        return head;   
    }

    Node swap(int posX, int posY){
        if(posX >= size || posY >=size){
            System.out.println("Invalid Position. ");
            return head;
        }
        if(head == null){
            return head;
        }
        if(posX == posY){
            return head;
        }
        Node temp = head;
        Node X_add = null;
        Node Y_add = null;
        int index = 0;
        while(temp != null){
            if(index == posX){
                X_add = temp;
                index = 0;
                temp = head;
                break;
            }
            index++;
            temp = temp.next;
        }

        while(temp != null){
            if(index == posY){
                Y_add = temp;
                index = 0;
                temp = head;
                break;
            }
            index++;
            temp = temp.next;
        }

        int intermi = X_add.value;
        System.out.println(intermi);
        X_add.value = Y_add.value;
        Y_add.value = intermi;
        return head;
    }

    Node reverseFromPos(int pos){
        if(pos >= size){
            return head;
        }
        if(head == null){
            return head;
        }
        if(pos == 0){
            reverse();
        }
        Node temp = head;
        int index = 0;
        while(temp != null){
            if(index == pos-1){
                Node current = temp.next;
                Node prev = null, next = null;
                while(current != null){
                    next = current.next;
                    current.next = prev;
                    prev = current;
                    current = next;
                }
                temp.next = prev;
                break;
            }
            index++;
            temp = temp.next;
        } 
        return head;

    }

    Node subList(int start , int end){
        if(start > end || start >= size || head == null || (start == 0 && end == size-1)){
            return head;
        }
        Node subhead = null;
        Node temp = head;
        int index = 0;
        while(temp != null){
            if(index == start){
                subhead = temp;
                if(index == end){
                    break;
                }
                temp = temp.next;
                index++;
            }
            temp = temp.next;
            index++;
        }
        return subhead;
    }

    void sortSwap(Node n1,Node n2){
        int temp = n1.value;
        n1.value = n2.value;
        n2.value = temp;
    }
    Node sort(){
        boolean isSwapped = false;
        Node current;
        if(head == null){
            return head;
        }
        do{
            isSwapped = false;
            current = head;
            while(current.next != null){
                if(current.value > current.next.value){
                    sortSwap(current, current.next);
                    isSwapped = true;
                }
                current = current.next;
            }
        }while(isSwapped);
        return head;
    }




    



}

public class LinkedListOperations {
    
    public static void main(String[] args){
        
        LinkedList ll = new LinkedList();
        Node head = null;
        head = ll.add(23);
        head = ll.add(29);
        head =ll.add(16);
        head = ll.add(12);
        head = ll.add(16);
        head = ll.insertAt(2,96,ll);  
        ll.print(head);
        int target = 16;
        int found = ll.search(target);
        System.out.println("Element "+target+" found at index : "+found);
        List<Integer> all_occurence = ll.findAll(target);  
        System.out.println("Elements "+target+" found at indices  : "+all_occurence);
        Node reveresed = ll.reverse();
        System.out.println("Reversed LinkedList : ");
        ll.print(reveresed);
        Node del = ll.deleteNode();
        System.out.println("Deleted last Node : ");
        ll.print(del);
        Node deletePos = ll.deleteAt(3); 
        System.out.println("After deleting at specific position : "); 
        ll.print(deletePos);  
        Node swapped = ll.swap(2,2);    
        System.out.println("After Swapping : ");
        ll.print(swapped);
        Node reversedPos = ll.reverseFromPos(0);
        System.out.println("List after Reversing from specific index : ");
        ll.print(reversedPos);
        Node sublist = ll.subList(1,4);
        System.out.println("Printing sublist.");
        ll.print(sublist);
        Node sorted = ll.sort();
        System.out.println("After sorting : ");
        ll.print(sorted);
        
        
       
        // Sort list
       
        
        // SubList from index i..j
        // containsSubList
        // Merge list sorted

     

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
