import java.util.*;


// containsSubstringAll(String s)
// containsSubstringKth(String s, int k)



class StringOperations{
    public static void main(String [] args){

        String given = "Welcome to programming in java.";
        stringMethodImplementation smi = new stringMethodImplementation();

        char target = 'm';
        int index = smi.indexOf(target,given);
        System.out.println("First Index of "+target + " : "+index);

        int last_index = smi.lastIndexOf(target,given);
        System.out.println("Last Index of "+target + " : "+last_index);

        List<Integer> indices = smi.allIndexOf(target, given);
        System.out.println("All Index of "+target + " : "+indices);

        int start = 3, end =19;
        String substring_created = smi.subString(start, end, given);
        System.out.println("Substring created : "+substring_created); 

        String sub = "toprogr";
        boolean contains_sub = smi.containsSubstring(sub,given);
        System.out.println("Contains substring : "+contains_sub);

        String upper = smi.convertToUpperCase(given);
        System.out.println("In upper case : "+upper);

        String lower = smi.convertToLowerCase(given);
        System.out.println("In lowercase : "+lower);

        boolean palindrome = smi.isPalindrome(given);
        System.out.println("Is PAlindrome : "+ palindrome);

        String rev = smi.reverse(given);
        System.out.println("Reversed string : "+rev);

        String char_replaced = smi.replaceCharacter('*','e',given);
        System.out.println("Replaced string : "+char_replaced);

        boolean can_Form_Palindrome = smi.canFormPalindrome(given);
        System.out.println("Can forfm palindrome : " +can_Form_Palindrome);

        smi.toInteger("43567");
        
        String to_replace = "java", replace_with = "python";
        String replacedString = smi.replaceSubString(given,to_replace, replace_with);
        System.out.println("String after replacing "+to_replace+" with "+replace_with+ " is : "+replacedString);

        List<String> palindrome_substrings = smi.allPossiblePalindrome("welcometoprogramminginjava");
        System.out.println("All palindromes in give string : "+palindrome_substrings);

    }
}

class stringMethodImplementation{

    int indexOf(char c, String s){
        for(int i = 0 ; i < s.length(); i++){
            if(s.charAt(i) == c){
                return i;
            }
        }
        return -1;
    }

    int lastIndexOf(char c, String s){
        for(int i = s.length()-1; i >=0; i--){
            if(s.charAt(i) == c){
                return i;
            }
        }
        return -1;
    }

    List<Integer> allIndexOf(char c, String s){
        List<Integer> indices = new ArrayList<Integer>();
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == c){
                indices.add(i);
            }
        }
        return indices;
    }

    String subString(int start, int end, String s){
        if(start < 0 || end > s.length() || end-start < 0){
            return " Invalid arguments";
        }
        if(start == 0 && end == s.length()-1){
            return s;
        }
        String result  = "";
        for(int i = start;i < end; i++){
            result+=s.charAt(i);            
        }
        return result;
    }

    boolean containsSubstring(String sub, String s){
        if(sub.length() > s.length()){
            return false;
        }
        int i = 0, j = 0 ;
        while( i < s.length() && j < sub.length()){
            if(s.charAt(i) == sub.charAt(j)){
                i++;
                j++;

                if(j == sub.length()){
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

    String convertToUpperCase(String s){
        StringBuilder res = new StringBuilder(); 
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c >= 'a' && c<='z'){
                res.append((char)(c-32));
            }
            else{
                res.append(c);
            }
        }
        return res.toString();
    }

    String convertToLowerCase(String s){
        StringBuilder res = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c >= 'A' && c<='Z'){
                res.append((char)(c+32));
            }
            else{
                res.append(c);
            }
        }
        return res.toString();
    }

    boolean isPalindrome(String s){
        int left = 0 , right = s.length()-1;
        while(left < right){
            if(s.charAt(left) != s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    String reverse(String s){
        StringBuilder res = new StringBuilder();
        for(int i = s.length()-1; i >=0 ; i--){
            char c = s.charAt(i);
            res.append(c);
        }
        return res.toString();
    }

    String replaceCharacter(char replace ,char target, String s){
        char[] c = s.toCharArray();
        for(int i = 0; i < c.length; i++){
            if(c[i] == target){
                c[i] = replace;
            }
        }
        return String.valueOf(c);
    }

    boolean canFormPalindrome(String s){
        List<Character> res = new ArrayList<>();
        for(int i=0; i < s.length(); i++){
            char c = s.charAt(i);
            if(res.contains(c)){
                res.remove((Character)(c));
            }
            else{
                res.add(c);
            }
        }
        if((s.length() % 2 == 0 && res.size() == 0) || (s.length() % 2 == 1 && res.size() == 1)){
            return true;
        }
        return false;
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

    String replaceSubString(String s, String target, String toReplace){
        return  s.replaceAll( target , toReplace);
    }

    boolean isPalin(String s, int left, int right){
        while(left < right){
            if(s.charAt(left) != s.charAt(right)){
                return false;
            }
            left++;right--;
        }
        return true;
    }
    List<String> allPossiblePalindrome(String s){
        List<String> palindromes = new ArrayList<>();
        int count = 0;
        for(int i = 0; i < s.length(); i++){
            for(int j = i; j < s.length(); j++){
                if(isPalin(s,i,j)){
                    String res = "";
                    for(int k = i;k <= j; k++){
                        res+=s.charAt(k);
                    }
                    palindromes.add(res);
                    count++;
                }
            }
        }
        System.out.println("Count of Palindromes  : "+count);
        return palindromes; 
    }
}