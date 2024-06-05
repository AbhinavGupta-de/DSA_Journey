package questions.strings.easy;

public class FindCommonCharacter {
    public List<String>  commonChars(String[] words) {
        HashMap<Character, Integer> hashTable = new HashMap<>();

        for(int i = 0; i < words.length; i++) {
            for(char c : words[i].toCharArray()) {
               int[] freq = hashTable.getOrDefault(c, new int[words.length]);
                freq[i]++;
                hashTable.put(c, freq);
            }
        }

        List<String> result = new ArrayList<>();

        for(Map.Entry<Character, int[]> entry : hashTable.entrySet()) {
            char c = entry.getKey();
            int[] freq = entry.getValue();
            int min = Integer.MAX_VALUE;
            for(int i = 0; i < freq.length; i++) {
                min = Math.min(min, freq[i]);
            }
            for(int i = 0; i < min; i++) {
                result.add(String.valueOf(c));
            }
        }

        return result;
    }
}