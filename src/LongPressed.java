import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LongPressed {

    /**
     * Your friend is typing his name into a keyboard.
     * Sometimes, when typing a character c, the key might get long pressed, and the character will be typed 1 or more times.
     *
     * You examine the typed characters of the keyboard.
     * Return True if it is possible that it was your friends name, with some characters (possibly none) being long pressed.
     *
     * @param name the friend's name
     * @param typed how the friend typed their name
     * @return true if they typed their name with any long pressed keystrokes
     */
    public boolean isLongPressedName(String name, String typed) {

        if(name.length() > typed.length()) return false;

        // Two pointers
        int left = 0, right = 0;

        while(left < name.length() && right < typed.length()) {

            // Left keeps track of current letter of the name
            if(name.charAt(left) == typed.charAt(right)) {

                left++;
                right++;

                // If the previous letter in name == current letter in typed, then we have a long press, so
                // increment right until they are equal, then left will move to the next letter in name,
                // or false will get returned
            } else if(left > 0 && name.charAt(left - 1) == typed.charAt(right)) right++;
            else return false;

        }

        // Cover the rest of typed to make sure it equals the last letter in name
        while(right < typed.length()) {

            if (name.charAt(left - 1) != typed.charAt(right)) return false;
            right++;

        }

        return left >= name.length();
    }

}
