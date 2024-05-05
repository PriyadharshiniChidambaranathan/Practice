import java.util.ArrayList;
import java.util.List;

public class ArrayOperations {
    public static void main(String[] args){
        int[] arr = {1,2,3,4,5,6,7,8,9,10,2,12,22};
        ArrayOperations a = new ArrayOperations();
        a.findElement(2,arr);
        a.findAllOccurence(2,arr);
        int[] reversed_Array = a.reverse(arr);
        a.sort(arr);  //in-place using bubble sort
        int[] sorted_array = a.sortResult(arr);
        a.binarySearch(3,sorted_array);  
        a.swap(2,3,arr);
        a.searchInRange(2,7,3,arr);
        a.searchAllInRange(1,19,2,arr);
        //a.rotateClockwise(2,arr);
        // a.rotateAnticlockwise(2,arr);
        int[] sub_arr = {6,7,18,9};
        a.subArray(3,9,arr);
        a.containsSubArray(arr,sub_arr);       
             
        
        // map() (will explain what is this)
        // maxWindow (will explain what is this)
    }

    void findElement(int target, int[] arr){
        int index = -1;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == target){
                index = i;
                break;
            }
        }
        if(index == -1){
            System.out.println("\nElement not found ");
        }
        else{
            System.out.println("\n Element  found at index : "+ index);
        }

    }

    void findAllOccurence(int target, int[] arr){
        List<Integer> index = new ArrayList<>();
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == target){
                index.add(i);
            }
        }
        if(index.size() == 0){
            System.out.println("Element not found ");
        }
        else{
            System.out.println("Element  found at indices : ");
            for(int i : index){
                System.out.print(i + " ");
            }
        }
    }

    int[] reverse(int[] arr){
        int [] reversed_array = new int[arr.length];
        for(int i = 0; i < reversed_array.length; i++){
            reversed_array[i] = arr[i]; 
        }
        for(int i = 0 ; i < reversed_array.length/2; i++){
            int temp = reversed_array[i];
            reversed_array[i] = reversed_array[reversed_array.length - i -1];
            reversed_array[reversed_array.length -i -1] = temp;
        }
        System.out.println("\nreversed array : ");
        for(int i = 0 ; i < reversed_array.length; i++){
            System.out.print(reversed_array[i]+ " ");
        }
        return reversed_array;
    }

    void sort(int[] arr){
        int [] original = new int[arr.length];
        for(int i = 0; i < original.length; i++){
            original[i] = arr[i]; 
        }
        for(int i = 0; i < original.length-1; i++){
            boolean flag = true;
            for(int j = 0; j < original.length - i -1; j++){
                if(original[j] > original[j+1]){
                    int temp = original[j];
                    original[j] = original[j+1];
                    original[j+1] = temp;
                    flag = false;
                }
            }
            if(flag){
                break;
            }
        }
        System.out.println("\nSorted array : ");
        for(int i : original){
            System.out.print(i+ " ");
        }

    }

    int[] sortResult(int[] arr){
        int [] result = new int[arr.length];
        for(int i = 0; i < result.length; i++){
            result[i] = arr[i]; 
        }
        for(int i = 0; i < result.length-1; i++){
            boolean flag = true;
            for(int j = 0; j < result.length - i -1; j++){
                if(result[j] > result[j+1]){
                    int temp = result[j];
                    result[j] = result[j+1];
                    result[j+1] = temp;
                    flag = false;
                }
            }
            if(flag){
                break;
            }
        }
        return result;

    }

    void binarySearch(int target, int[] arr){
        int left = 0 , right = arr.length-1;
        int index = -1;
        while(left <= right){
            int mid = left + ((right - left)/2);
            if(arr[mid] == target){
                index = mid;
                break;
            }
            else if(target > arr[mid]){
                left = mid+1;
            }
            else{
                right = mid -1;
            }
        }
        if(index == -1){
            System.out.println("Element not found .");
        }
        else{
            System.out.println("\nElement found at index : "+index);
        }

    }

    void swap(int posX, int posY, int[] a){
        if(posX < 0 || posX >= a.length || posY < 0 || posY >=a.length){
            System.out.println("Invalid posX / posY value " );
            return;
        }
        int temp = a[posX];
        a[posX] = a[posY];
        a[posY] = temp;
        System.out.println("Array after swap : ");
        for(int i : a){
            System.out.print(i + " ");
        }
    }

    void searchInRange(int start, int end, int target,int[] arr){
        if(start < 0 || start >= arr.length || end < 0 || end >=arr.length || start > end){
            System.out.println("Invalid start / end value " );
            return;
        }
        int index = -1;
        for(int i = start; i <= end; i++){
            if(arr[i] == target){
                index = i;
                break;
            }
        }
        if( index == -1){
            System.out.println("Element not found . ");
        }
        else{
            System.out.println("Element found at index : "+ index);
        }

    }

    void searchAllInRange(int start, int end, int target, int[] arr){
        if(start < 0 || start >= arr.length || end < 0 || end >=arr.length || start > end){
            System.out.println("Invalid start / end value " );
            return;
        }
        List<Integer> result = new ArrayList<>();
        for(int i = start; i <= end; i++){
            if(arr[i] == target){
                result.add(i);
            }
        }
        if( result.size() == 0){
            System.out.println("Element not found . ");
        }
        else{
            System.out.println("Element found at indices: ");
            for(int i : result){
                System.out.print(i + " ");
            }
        }
    }

    void subArray(int start, int end, int[] arr){
        if(start < 0 || start >= arr.length || end < 0 || end > arr.length ){
            System.out.println("Invalid start / end values ");
            return;
        }
        int[] sub = new int[end - start];
        for( int i = start, j = 0; j < sub.length; i++,j++){
            sub[j] = arr[i];
        }
        System.out.println("Sub array formed in range "+start + " , "+end+ "  is :");
        for(int i : sub){
            System.out.print(i + " ");
        }
     }

     void containsSubArray(int[] arr, int[] sub_arr){
        if(sub_arr.length > arr.length){
            System.out.println("does not contain sub array . ");
            return;
        }
        for(int i = 0 ; i < arr.length;i++){
            if(arr[i]==sub_arr[0]){
                for(int j = 0;j < sub_arr.length;j++,i++){
                    if(arr[i] != sub_arr[j]){
                        System.out.println("\ndoes not contain sub array . ");
                        return;
                    }
                }
            }
        }
        System.out.println("\nSub array is present.");
     }


    
}
