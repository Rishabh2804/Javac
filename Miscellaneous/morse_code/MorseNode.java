package morse_code;

public class MorseNode {
    char value;
    private String code;

    MorseNode left;
    MorseNode right;

    public MorseNode(char value) {
        this.value = value;
    }

    public MorseNode(char value, MorseNode left, MorseNode right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    char getValue() {
        return value;
    }

    String getCode() {
        return code;
    }

    @Override
    public String toString() {
        return value + " --> " + code;
    }

}
