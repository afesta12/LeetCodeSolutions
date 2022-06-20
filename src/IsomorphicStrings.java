import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class IsomorphicStrings {

    /**
     * Given two strings s and t, determine if they are isomorphic.
     *
     * Two strings s and t are isomorphic if the characters in s can be replaced to get t.
     *
     * All occurrences of a character must be replaced with another character while preserving the order of characters.
     * No two characters may map to the same character, but a character may map to itself.
     * @param s the first string
     * @param t the second string
     * @return true if the two strings are isomorphic
     */
    public boolean isIsomorphic(String s, String t) {

        Map<Character, Character> map = new HashMap<>();

        int len = s.length();

        for(int i = 0; i < len; i++) {

            char sCh = s.charAt(i), tCh = t.charAt(i);

            if(map.containsKey(sCh)) {

                // Check if a key is not equal to the letter it is supposed to map to
                if(map.get(sCh) != tCh) return false;

            } else {

                // If the key is not in the map, but the value is then return false
                if(map.containsValue(tCh)) return false;
                map.put(sCh, tCh);

            }

        }

        return true;
    }

    // Initial idea was to use a HashMap along with a set. If the set contains a letter that has already been mapped,
    // return false. Accepted, but kind of slow.
    public static boolean isIsomorphicInitial(String s, String t) {

        Map<Character, Character> map = new HashMap<>();
        Set<Character> set = new HashSet<>();

        int len = s.length();

        for(int i = 0; i < len; i++) {

            char sCh = s.charAt(i), tCh = t.charAt(i);
            if(map.containsKey(sCh) && map.get(sCh) != tCh) return false;
            if(!map.containsKey(sCh) && set.contains(tCh)) return false;

            map.put(sCh, tCh);
            set.add(tCh);
        }

        return true;
    }
}
