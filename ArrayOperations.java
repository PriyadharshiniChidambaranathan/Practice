import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;;

// map() (will explain what is this)
// maxWindow (will explain what is this)

class ArrayOperations{
    public static void main(String [] args){
        int[] arr = {1,2,3,4,9,8,7,5,29,16,12,23,25,19,9,99,100};
        method_implementation mi = new method_implementation();

        int target = 9;
        int find = mi.find(target,arr);
        System.out.println("Element "+ target+" found at index : "+find);

        List<Integer> found = mi.findAll(target,arr);
        System.out.println("Element "+target +" found at indices : "+found);

        // mi.sortInPlace(arr);
        // System.out.println("Array sorted in-place : "+Arrays.toString(arr));

        int[] sorted_array = mi.sort(arr);
        System.out.println("Array before sorting : "+Arrays.toString(arr));
        System.out.println("array after sorting : " + Arrays.toString(sorted_array));

        int target_index = mi.binarySearch(target,arr);
        System.out.println("Element  found at index : "+target_index);

        mi.reverse(arr);
        System.out.println("Reversed array : " + Arrays.toString(arr));

        int[] sub_arr = mi.subArray(8,4,arr);
        System.out.println(" Formed subArray : "+Arrays.toString(sub_arr));

        int pos1 = 3, pos2 = 9;
        int[] swapped_Array = mi.swap(pos1,pos2,arr);
        System.out.println("Array after swapping positions  "+pos1+" and "+pos2 + " : "+Arrays.toString(swapped_Array));

        int start = 2 , end = 14;
        int index_of_target = mi.searchInRange(start, end, target,arr);
        System.out.println("Index of "+target+" between the range  "+start+ " and "+end+ " is : "+index_of_target);

        List<Integer>  indices_of_target = mi.searchAllInRange(start,end,target,arr);
        System.out.println("Element  "+target+ " present in indices  : "+indices_of_target);

        int [] mini_arr = { 12,16,20,19};
        boolean isContains = mi.containsSubArray(mini_arr,arr);     
        System.out.println("Contains subarray : "+isContains); 

        int rotate = 2;
        mi.rotate_anticlockwise(arr,rotate);
        System.out.println("After rotating anticlockwise "+ rotate+ " times : "+Arrays.toString(arr));

        mi.rotate_clockwise(arr,rotate);
        System.out.println("After rotating clockwise "+ rotate+ " times : "+Arrays.toString(arr));
    
    }
}

class method_implementation{

    int find(int target,int[] a){
        for(int i = 0; i < a.length;i++){
            if(a[i] == target){
                return i;
            }
        }
        return -1;
    }

    List<Integer> findAll(int target, int[] arr){
        List<Integer> indices = new ArrayList<Integer>();
        for(int i = 0; i < arr.length;i++){
            if(arr[i] == target){
                indices.add(i);
            }
        }
        return indices;
    }

    void sortInPlace(int[] original){
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
    }

    int[] sort(int[] arr){
        int[] original = new int[arr.length];
        for(int i = 0; i < arr.length;i++){
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
        return original;
    }

    void reverse(int[] arr){
        int left = 0, right = arr.length-1;
        while(left < right){
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left ++;
            right --;
        }
    }

    int binarySearch(int target , int[] a){
        int[] arr = sort(a);
        int left = 0, right = arr.length -1;
        while(left <= right){
            int mid = left + ((right-left)/2);
            if(arr[mid] == target){
                return mid;
            }
            else if(arr[mid]>target){
                right = mid;
            }
            else{
                left = mid+1;
            }
        }
        return -1;
    }

    int[] subArray(int start, int end, int[] arr){
        
        if(start == 0 && end == arr.length){
            return arr;
        }
        if(start < 0 || start >= arr.length || end >= arr.length || end < 0 || start > end){
            return null;
        }
        int[] sub = new int[end-start];
        for(int i = start, j = 0 ; j < sub.length; j++,i++){
            sub[j] = arr[i]; 
        }
        return sub;
    }

    int[] swap(int pos1, int pos2,int[]arr){
        if(pos1 < 0 || pos1 >= arr.length || pos2 < 0 || pos2 >= arr.length){
            return null;
        }
        int temp = arr[pos1];
        arr[pos1] = arr[pos2];
        arr[pos2] = temp;
        return arr;
    }

    int searchInRange(int start, int end,int target, int[] arr){
        if(start < 0 || start >= arr.length || end < 0 || end >= arr.length || start > end){
            return -1;
        }
        for(int i = start; i < end; i++){
            if(arr[i] == target){
                return i;
            }
        }
        return -1;
    }

    List<Integer> searchAllInRange(int start, int end, int target, int[] arr){
        List<Integer> indices = new ArrayList<Integer>();
        if(start < 0 || start >= arr.length || end >=arr.length || end < 0 || start > end){
            return null;
        }
        for(int i = start ; i < end ; i++){
            if(arr[i] == target){
                indices.add(i);
            } 
        }
        return indices;
    }

    boolean containsSubArray(int[] sub, int[] arr){
        if(sub.length > arr.length){
            return false;
        }
        int i = 0, j = 0;
        while(i < arr.length && j < sub.length){
            if(arr[i] == sub[j]){
                i++;
                j++;
                if(j == sub.length){
                    return true;
                }
            }
            else{
                i++;
                j = 0;
            }
        }
        return false;
    }

    void reverse(int[] arr, int start, int end){
        while(start < end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    void rotate_anticlockwise(int[] arr, int k){
        
        if(k > arr.length){
            k = k % arr.length;
        }
        if(k == 0 || k == arr.length){
            return;
        }
        reverse(arr, 0, k-1);
        reverse(arr, k , arr.length-1 );
        reverse(arr, 0 , arr.length-1);
    }

    void rotate_clockwise(int [] arr, int k){
        if(k > arr.length){
            k = k % arr.length;
        }
        if(k == 0 || k == arr.length){
            return;
        }
        reverse(arr, 0 , arr.length -1);
        reverse(arr, 0, k-1);
        reverse(arr,k , arr.length -1);     
    }

}