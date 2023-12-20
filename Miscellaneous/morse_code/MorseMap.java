package morse_code;

import java.util.HashMap;

public final class MorseMap {
    HashMap<Character, MorseNode> morsePool = new HashMap<>();

    // ======================================================================================
    // ================================= CHARACTERS
    // =========================================

    // private MorseNode handleAbsent(char c) {
    //     return morsePool.putIfAbsent(c, new MorseNode(c));
    // }

    // private void insert(char parent, char left, char right) {
    //     MorseNode parentNode = handleAbsent(parent);
    //     parentNode.left = handleAbsent(left);
    //     parentNode.right = handleAbsent(right);

    //     morsePool.put(parent, parentNode);
    // }


    char[][] morseChart = { { 'A', 'W', 'R' } };
    

    public String getCode(char c) {
        return morsePool.get(c).getCode();
    }

    public boolean contains(char c) {
        return morsePool.containsKey(c);
    }
}
