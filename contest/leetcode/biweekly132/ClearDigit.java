package contest.leetcode.biweekly132;

public class ClearDigit {

    public String clearDigits(String s) {

        Stack<Character> stack = new Stack<>();

        for(char c : s.toCharArray()) {
           if(c == '0' || c == '1' || c == '2' || c == '3' || c == '4' || c == '5' || c == '6' || c == '7' || c == '8' || c == '9') {
               if(!stack.isEmpty()) {
                   stack.pop();
               }
           } else {
               stack.push(c);
           }
        }

        StringBuilder sb = new StringBuilder();

        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.reverse().toString();

    }

}