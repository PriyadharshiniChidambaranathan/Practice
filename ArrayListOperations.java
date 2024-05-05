import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArrayListOperations {
    public static void main(String[] args){
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i = 1; i <= 10; i++){
            arr.add(i);
        }
        System.out.println(arr);
        ArrayListOperations aL = new ArrayListOperations();
        aL.insert(100,arr);
        aL.insertAt(2,8,arr);
        aL.deleteElement(6,arr); //delete given element.
        aL.deleteAt(0,arr);//delete element at position
        aL.find(100,arr);
        aL.FindAll(2,arr);
        aL.sort(arr);        
        aL.reverse(arr); 
        aL.swap(0,9,arr);
        aL.subList(2,6,arr);
        aL.findMid(arr);
        aL.reverseList(3,arr);

        System.out.println(arr);

                
            
                
                
            
            // Rotate array clockwise n times
            // Rotate array anticlockwise n times               
            // containsSubList  -----(to check presence of element /  presence of element in order)
              
            // splitList
            // splitList(splitPosition)
            // Merge list sorted

            // map() (will explain what is this)
            // Filter (will explain what is this)
            // maxWindow(will explain what is this)

    }
    
    void insert(int value, ArrayList<Integer> a){
        a.add(value);
        System.out.println(a);
    }

    void insertAt(int value, int pos, ArrayList<Integer> a){
        if(pos < 0 || pos >=a.size()){
            System.out.println("Invalid position .");
            return;
        }
        a.add(pos,value);
        System.out.println(a);        
    }

    void deleteElement(int value, ArrayList<Integer> a){
        a.remove((Integer) 3);
        System.out.println(" After deleteElement : "+a);
    }
    void deleteAt(int pos, ArrayList<Integer> a){
        if(pos < 0 || pos >=a.size()){
            System.out.println("Invalid position .");
            return;
        }        
        a.remove(pos);
        System.out.println(a);
    }

    void find(int value, ArrayList<Integer> a){
        int index = a.indexOf(value);
        if(index == -1){
            System.out.println(" Element not found . ");
        }
        else{
            System.out.println("Element "+value+" found at index :  "+index);
        }      
    }

    void FindAll(int value, ArrayList<Integer> a){
        ArrayList<Integer> result = new ArrayList<> ();
        for(int i = 0; i < a.size(); i++){
            if(a.get(i) == value){
                result.add(i);
            }
        }
        System.out.println("Element  "+value + " found at indices : "+ result);
    }

    void sort(ArrayList<Integer> a){
        ArrayList<Integer> result = new ArrayList<>();
        for(int i : a){
            result.add(i);
        } 
        Collections.sort(result);
        System.out.println(result);
    }

    void reverse(ArrayList<Integer> a){
        System.out.println("reversed List : ");
        for( int i = a.size()-1; i >= 0; i--){
            System.out.print(a.get(i)+" ");
        }
        //Collections.reverse(a);
    }

    void swap(int posX, int posY, ArrayList<Integer> a){
        if(posX < 0 || posX >= a.size() || posY < 0 || posY >= a.size() ){
            System.out.println("invalid positions . ");
            return;
        }
        Collections.swap(a,posX, posY);
        System.out.println(a);
    }

    void subList(int start, int end, ArrayList<Integer> a){
        if(start > end ||start < 0 || start >= a.size() || end >= a.size() || end < 0 ){
            System.out.println("Invalid start / end position . ");
            return;
        }
        List<Integer> result = a.subList(start, end );
        System.out.println("SubList formed:  " +result);
    }

   

    void findMid(ArrayList<Integer> a){
        System.out.println("Mind element : "+a.get(a.size()/2));
    }

    void reverseList(int startPos, ArrayList<Integer> a){
        ArrayList<Integer> result = new ArrayList<>();
        for(int i = 0 ; i < a.size() ; i++){
            if(i == startPos){
                for(int j = a.size()-1; j >= startPos; j--){
                    result.add(a.get(j));
                    i++;
                }
            }
            else{
                result.add(a.get(i));
            }
            
        }
        System.out.println("Result : " +result);
    }












}
