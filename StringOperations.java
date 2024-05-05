import java.util.ArrayList;
import java.util.List;

class StringOperations{
    public static void main(String[] args){
        String str = "My name is Priyadharshini";
        StringOperations s = new StringOperations();
        s.indexOf('a',str);
        s.lastIndexOf('z',str);
        s.allIndexOf('a',str);
        s.subString(3, 8,str);
        s.convertToUpperCase(str);
        s.convertToLowerCase( str);
        s.reverse(str);
        s.replaceChar('a', '*',str);
        s.isPalindrome("aabaa");
        s.canFormPalindrome("geoesgs");
        s.toInteger(str);
        s.containsSubstring("naame", str);

        
        //containsSubstringAll(String s)
        //containsSubstringKth(String s, int k)               
        //allPossiblePalindrome(String s)        
        //replaceSubString(String target, String toReplace)

    }

    void indexOf(char c,String s){
        int index = -1;
        for(int i = 0; i < s.length(); i++){
            char val = s.charAt(i);
            if(val == c){
                index = i;
                break;
            }
        }
        if(index == -1){
            System.out.println("Element not found .");          
        }
        else{
            System.out.println("Element found at index : "+ index);
        }
    }

    void lastIndexOf(char c, String s){
        int index = -1;
        for(int i = 0; i < s.length(); i++){
            char val = s.charAt(i);
            if(val == c){
                index = i;
            }
        }
        if(index == -1){
            System.out.println("Element not found .");          
        }
        else{
            System.out.println("Element found at index : "+ index);
        }
    }

    void allIndexOf(char c, String s){
        List<Integer> index = new ArrayList<Integer>();
        for(int i = 0; i < s.length(); i++){
            char val = s.charAt(i);
            if(val == c){
                index.add(i);
            }
        }
        if(index.size() == 0){
            System.out.println("Element not found .");          
        }
        else{
            System.out.println("Element found at indices : ");
            for(int i : index){
                System.out.print(i+" ");
            }
        }
    }

    void subString(int start, int end,String s){
        if(start < 0 || start >= s.length() || end < 0 || end >=s.length() || start > end){
            System.out.println("Invalid start / end value " );
            return;
        }
        StringBuilder  result = new StringBuilder();
        for(int i = start; i < end; i++){
            result.append(s.charAt(i));
        }
        //System.out
        System.out.println(result.toString());
    }

    void convertToUpperCase(String s){
        StringBuilder result = new StringBuilder();
        for(int i = 0 ; i < s.length();i++){
            char c = s.charAt(i);
            if(c >= 'A' && c <='Z'){
                result.append(c);
            }
            else if(c == ' '){
                result.append(' ');
            }
            else{
                result.append((char)(c - 32));
            }
        }
        System.out.println(result.toString());
    }

    void convertToLowerCase(String s){
        StringBuilder result = new StringBuilder();
        for(int i = 0 ; i < s.length();i++){
            char c = s.charAt(i);
            if(c >= 'a' && c <='z'){
                result.append(c);
            }
            else if(c == ' '){
                result.append(' ');
            }
            else{
                result.append((char)(c + 32));
            }
        }
        System.out.println(result.toString());
    }

    void reverse(String s){
        StringBuilder result = new StringBuilder();
        for(int i = s.length()-1; i >= 0;i--){
            result.append(s.charAt(i));
        }
        System.out.println(result.toString());
    }

    void replaceChar(char target, char replace,String s){
        char[] result = s.toCharArray();
        for(int i = 0 ; i < result.length; i ++){
            if(result[i] == target){
                result[i] = replace;                
            }
        }
        System.out.println(String.valueOf(result));
    }

    void isPalindrome(String s){
        //StringBuilder original = new StringBuilder(s);
        StringBuilder reverse = new StringBuilder();
        for(int i = s.length()-1; i >= 0; i--){
            reverse.append(s.charAt(i));
        }
        if(s.equals(reverse.toString())){
            System.out.println(s+ " is a palindrome.");
        }
        else{
            System.out.println(s+ " is not a palindrome.");
        }    
    }

    void canFormPalindrome(String s){
        int[] count = new int[256];
        int odd = 0;
        for(int i = 0; i < s.length(); i++){
            count[s.charAt(i)]++;
        }
        for(int i = 0; i < count.length;i++){
            if((count[i] %2 )!= 0){
                odd++;
            }
            if(odd > 1){
                System.out.println("this string cannot form a palindrome ");
                return;
            }
        }
        System.out.println("Can form palindrome");
    }

    void toInteger(String s){
        try{
            System.out.println(Integer.valueOf(s));
            //System.out.println(Integer.parseInt(s));
        }
        catch (Exception e){
            System.out.println("Invalid string . Exception found : "+ e);
        }
        
    }

    void containsSubstring(String target, String s){
        int j = 0;
         for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == target.charAt(j)){
                while(j < target.length()){
                    if(s.charAt(i) != target.charAt(j)){
                        System.out.println("Not a substring .");
                        return;
                    }
                    i++;j++;
                }
                System.out.println("Substring is present. ");
                return;
            }
         }
    }





}