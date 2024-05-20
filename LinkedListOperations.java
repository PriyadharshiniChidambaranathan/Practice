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

    Node add(int value,Node head){      
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

    Node insertAt(int pos,int val, Node head){
        Node n = new Node(val);
        if(pos < 0 || pos > size){
            return head;
        }
        if(head == null && pos == 0){
            n = head;
            return head;
        }   
        if(pos == 0 ){
            n.next = head;
            head = n;
            return head;

        }
        Node temp = head;
        for(int i = 0; i < pos-1; i ++){
            temp = temp.next;
        }
        n.next = temp.next;
        temp.next = n;
              
        return head;
    }


    int search(int target,Node head){
        if(head == null){
            return -1;
        }
        int index = 0;
        Node temp = head;
        
        while( temp != null){
            if(temp.value == target){
                return index+1;
            }
            index++;
            temp = temp.next;
        }
        return -1;
    }

    List<Integer> findAll(int target,Node head){
        List<Integer> result = new ArrayList<>();
        if(head == null){
            return null; 
        }
        int index = 0;
        Node temp = head;
        while(temp != null){
            if(temp.value == target){
                result.add(index+1);
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

    Node deleteNode(Node head){  //deleting last node;
        Node temp = head;
        while(temp.next.next != null){
            temp = temp.next;
        }
        temp.next= null;
        return head;
    }

    Node deleteAt(int pos,Node head){ 
        if(head == null){
            return null;
        }
        if(pos >= size && head != null){
            System.out.println("Invalid Index;");
            return head;
        }
        if(pos == 0){
            head = head.next;
            return head;
        }
        if(pos == size-1){
            deleteNode(head);
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

    Node reverse(Node head){        
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

    Node swap(int posX, int posY,Node head){
        if(posX >= size || posY >=size){
            System.out.println("Invalid Position. ");
            return head;
        }
        if(head == null){
            return null;
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
        X_add.value = Y_add.value;
        Y_add.value = intermi;
        return head;
    }

    Node reverseFromPos(int pos,Node head){
        if(pos >= size || pos < 0){
            return head;
        }
        if(head == null){
            return head;
        }
        if(pos == 1){
            Node result = reverse(head);
            return result;
        }
        Node temp = head;
        int index = 1;
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

    Node subList(int start , int end,Node head){
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

    Node sort(Node head){
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


    Node rotateRight(int k,Node head){
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
        if(k == len || k == 0){
            return head;
        }
        Node current = head;
        int count = 1;
        while(count < k && current != null ){
            current = current.next;
            count++;
        }
        temp.next = head;
        head = current.next;
        current.next = null;
        return head;
    }

    Node rotateLeft(int k,Node head){
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
        int count = 1;
        while(count < k && current != null){
            current = current.next;
            count++;
        }
        temp.next = head;
        head = current.next;
        current.next = null;
        return head;
    }

    Node mergeSortedList(Node head1, Node head2){
        for(int i =1;i<10;i++){
            head2 = add(i*2,head2);
        }
        if(head1 == null){
            return head2;
        }
        if(head2 == null || (head1 == null && head2 ==null)){
            return head1;
        }

        Node current1 = head1, current2 = head2, head  = null;

        while(current1 != null && current2 != null){

            if(head == null && current1.value <= current2.value){
                Node insert= new Node(current1.value);
                head = insert;
                current1 = current1.next;
            }

            else if(head == null && current2.value <= current1.value){
                Node insert = new Node(current2.value);
                head = insert;
                current2 = current2.next;
            }

            else if(head != null && current1.value <= current2.value){
                Node temp = head;
                Node insert = new Node(current1.value);
                while(temp.next != null){
                    temp = temp.next;
                }
                temp.next = insert;
                current1 = current1.next;
            }

            else{
                Node temp = head;
                Node insert = new Node(current2.value);
                while(temp.next != null){
                    temp = temp.next;
                }
                temp.next = insert;
                current2 = current2.next;
            }
        }

        while(current1 != null){
            Node temp = head;
            Node insert = new Node(current1.value);
            while(temp.next != null){
                temp = temp.next;
            }
            temp.next = insert;
            current1 = current1.next;
        }

        while(current2 != null){
            Node temp = head;
            Node insert = new Node(current2.value);
            while(temp.next != null){
                temp = temp.next;
            }
            temp.next = insert;
            current2 = current2.next;
        }

        return head;
    }      
    boolean containSublist(Node l1, Node l2){
        for(int i =1;i<5;i++){
            l1 = add(i*2,l1);
        }
       
        Node temp1 = l1, temp2 =l2;
        if (temp1 == null && temp2 == null){
            return true;
        }

        if (temp1 == null || temp2 == null){
           return false;
        }

        while (l2 != null){
            temp2 = l2;
            while(temp1 != null){
                if(temp2 == null){
                    return false;
                }
                else if(temp1.value == temp2.value){
                    temp1  = temp1.next;
                    temp2 = temp2.next;
                }
                else{
                    break;
                }  
            }
            if(temp1 == null){
                return true;
            }

            temp1 = l1;
            l2 = l2.next;            
        }      
       return false;
    }

}

public class LinkedListOperations {
    
    public static void main(String[] args){
        
        LinkedList ll = new LinkedList();
        Node head = null;
        head = ll.add(23,head);
        head = ll.add(29,head);
        head =ll.add(16,head);
        head = ll.add(12,head);
        head = ll.add(16,head);
        head = ll.insertAt(2,96,head);  
        ll.print(head);
        int target = 16;
        int found = ll.search(target,head);
        System.out.println("Element "+target+" found at index : "+found);
        List<Integer> all_occurence = ll.findAll(target,head);  
        System.out.println("Elements "+target+" found at indices  : "+all_occurence);
        head = ll.add(11,head);
        head = ll.add(56,head);
        head = ll.add(86,head);
        ll.print(head);
        Node reveresed = ll.reverse(head);
        System.out.println("Reversed LinkedList : ");
        ll.print(reveresed);
        Node del = ll.deleteNode(reveresed);
        System.out.println("Deleted last Node : ");
        ll.print(del);
        Node deletePos = ll.deleteAt(3,del); 
        System.out.println("After deleting at specific position : "); 
        ll.print(deletePos);  
        Node swapped = ll.swap(4,5,deletePos);    
        System.out.println("After Swapping : ");
        ll.print(swapped);
        Node reversedPos = ll.reverseFromPos(3,swapped);
        System.out.println("List after Reversing from specific index : ");
        ll.print(reversedPos);
        Node sublist = ll.subList(1,4,reversedPos);
        System.out.println("Printing sublist.");
        ll.print(sublist);
        Node sorted = ll.sort(reversedPos);
        System.out.println("After sorting : ");
        ll.print(sorted);   
        int k = 2;
        Node rotated_right = ll.rotateRight(k,sorted);
        System.out.println("After "+k+" rotation in right : ");
        ll.print(rotated_right);
        Node rotated_left = ll.rotateLeft(2,rotated_right);
        System.out.println("After "+k+" rotation in left : ");
        ll.print(rotated_left) ;
        Node head2 = null;
        Node newList = ll.mergeSortedList(rotated_left,head2);
        System.out.println("After merging two sorted list : ");
        ll.print(newList);
        Node h  = null;
        boolean containsSublist = ll.containSublist(h, rotated_left);
        System.out.println("ContainsSublist : "+containsSublist); 

        
       
        
         

        // splitList
        // splitList(splitPosition)
        // map() (will explain what is this)
        // Filter (will explain what is this)
        // maxWindow(will explain what is this)

    

    
    }
    
}
