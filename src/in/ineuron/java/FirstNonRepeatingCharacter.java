package in.ineuron.java;


public class FirstNonRepeatingCharacter {
    public static int firstUniqChar(String s) {
        int[] frequency = new int[26];

        // Count the frequency of each character
        for (char c : s.toCharArray()) {
            frequency[c - 'a']++;
        }

        // Find the index of the first non-repeating character
        for (int i = 0; i < s.length(); i++) {
            if (frequency[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }

        return -1; // If no non-repeating character found
    }

    public static void main(String[] args) {
        String input = "leetcode";
        int index = firstUniqChar(input);
        if (index != -1) {
            System.out.println("First non-repeating character found at index: " + index);
            System.out.println("Character: " + input.charAt(index));
        } else {
            System.out.println("No non-repeating character found.");
        }
    }
}
