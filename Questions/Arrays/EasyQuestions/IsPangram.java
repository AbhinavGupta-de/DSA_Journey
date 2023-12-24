package questions.arrays.easyquestions;

public class IsPangram {
 public boolean checkIfPangram(String sentence) {
  int[] arr = new int[26];
  for (int i = 0; i < sentence.length(); i++) {
   arr[sentence.charAt(i) - 'a']++;
  }
  for (int i = 0; i < 26; i++) {
   if (arr[i] == 0) {
    return false;
   }
  }
  return true;

  // * Another solutions, using set
  // Set<Character> unique_char=new HashSet<Character>();
  // int n=sentence.length();
  // for(int i=0;i<n;i++){
  // unique_char.add(sentence.charAt(i));
  // }
  // if(unique_char.size()==26){
  // return true;
  // }else{return false;}
 }
}
