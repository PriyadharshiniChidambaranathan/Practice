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

    Node addLast(int value,Node head){    //adding element at end
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

    Node addFirst(int value,Node head){
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

    Node addPos(int pos, int value,Node head){
        
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

    Node deleteLast(Node head){
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

    Node deleteFirst(Node head){
        if(head == null){
            return head;
        }
        head = head.next;
        return head;
    }

    Node deletePos(int pos,Node head){
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

    int find(int target,Node head){
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

    List<Integer> findAll(int target, Node head){
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

    
    Node rotate_Left(int k, Node head){
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

    Node rotate_Right(int k,Node head){
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

    Node swap(int posX, int posY,Node head){
        
        if(head == null){
            return head;
        }
        if(posX > size || posY > size || posX == posY || posX < 1 || posY < 1){
            return head;
        }
        Node current = head, x_node = null, y_node = null;
        int index = 1;
        while(current != null){
            if(index == posX){
                x_node = current;
                index = 1;
                current = head;
                break;
            }
            index++;
            current = current.next;           
        }

        while(current != null){
            if(index == posY){
                y_node = current;
                break;
            }
            index++;
            current = current.next;           
        }

        int temp = x_node.data;
        x_node.data = y_node.data;
        y_node.data = temp;
        return head;
    }

    Node sort(Node head){
        if(head == null){
            return head;
        }
        boolean isSwapped = false;
        Node current = head;
        do{
            isSwapped = false;
            current = head;
            while(current.next != null){
                if(current.data > current.next.data){
                    sort_swap(current, current.next);
                    isSwapped = true;
                }
                current = current.next;
            }
        }while(isSwapped);
        return head;

    }

    void sort_swap(Node x, Node y){
        int temp = x.data;
        x.data = y.data;
        y.data = temp;
        
    }
    Node subList(int start, int end, Node head){
        Node head2 = null;
        if(head == null || (start == 1 && end == size)){
            return head;
        }
        if(start > end){
            return null;
        }
        Node current = head;
        int index = 1;
        while(current != null){
            if(index == start){
                Node temp = current;
                head2 = current;
                while(temp != null){
                    if(index == end){
                        temp.next = null;
                    }
                    index++;
                    temp=temp.next;
                }
            }
            index++;
            current = current.next;
        }
        return head2;
    }


    void print(Node head){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println("\n");
    }
    
    Node reverse(Node head)
	{
        if(head == null){
            return head;
        }
		Node temp = null;
		Node current = head;
		while (current != null) 
		{
			temp = current.prev;
			current.prev = current.next;
			current.next = temp;
			current = current.prev;
		}
		head = temp.prev;
        return head;
	}

    
}


public class DoublyLinkedListOperations {
    public static void main(String[] args){
        DoublyLinkedList dll = new DoublyLinkedList();
        Node head = null;
        head = dll.addLast(23,head);
        head = dll.addLast(29,head);
        head = dll.addLast(16,head);
        dll.print(head);

        head = dll.addFirst(99,head);
        dll.print(head);

        head = dll.addPos(1,200,head);
        dll.print(head);

        Node reveresed = dll.reverse(head);
        System.out.println("Reversered List : ");
        dll.print(reveresed);

        Node delfirst = dll.deleteFirst(reveresed);
        System.out.println("After deleting 1st Node.");
        dll.print(delfirst);

        Node deleLast = dll.deleteLast(delfirst);
        System.out.println("After deleting last Node.");
        dll.print(deleLast);

        Node delepos = dll.deletePos(1,deleLast);
        System.out.println("After deleting position Node.");
        dll.print(delepos);

        int toFind = 29;
        int found = dll.find(toFind,delepos);
        System.out.println("ELement "+toFind+" found at index : "+ found+"\n");
        List<Integer> alloccur = dll.findAll(toFind,delepos);
        System.out.println("All occurence of " + toFind+" : "+alloccur+"\n");    

        head = dll.addLast(5,delepos);
        head = dll.addLast(4,head);
        head = dll.addLast(3,head);
        head = dll.addLast(2,head);
        head = dll.addLast(1,head);
        dll.print(head);

        int k = 10;
        Node left_rotate = dll.rotate_Left(k,head);
        System.out.println("After "+k+" roatation in anticlockwise : ");
        dll.print(left_rotate);

        Node right_rotate = dll.rotate_Right(k,left_rotate);
        System.out.println("After "+ k + " rotations in clockwise.");
        dll.print(right_rotate);

        Node swapped = dll.swap(2,3,right_rotate);
        System.out.println("After swapping :");
        dll.print(swapped);

        Node list2 =  dll.subList(3,7,swapped);
        System.out.println("Created sublist : ");
        dll.print(list2);

        Node sorted = dll.sort(swapped);
        System.out.println("After sort  : ");
        dll.print(sorted);


        
        

        
    }
    
}
