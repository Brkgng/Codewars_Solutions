public class PangramChecker {
    public boolean check(String sentence){
        // declare bool for every letter
        boolean[] checkLetter = new boolean[26];

        // iterate over every char in given sentence
        for (int i = 0; i < sentence.length(); i++) {
            // get letter's ascii value
            int idx = sentence.charAt(i) - 97;  // 'a' will be 0
            // convert uppercase letter to lowercase
            idx = idx < 0 ? idx + 32 : idx;
            // skip other characters except a-z
            if (idx < 0 || idx > 26)
                continue;

            checkLetter[idx] = true;
        }

        // if every element in checkLetter is true
        // then sentence will be pangram
        for (int i = 0; i < 26; i++)
            // if checkLetter has 'false', sentence is not pangram
            if (!checkLetter[i])
                return false;
        return true;
    }
}