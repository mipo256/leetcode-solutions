public class Solution {
    
    public String encode(List<String> strs) {
        StringBuilder builder = new StringBuilder();
        for (var s : strs) {
            int tokenLength = s.length();
            builder.append(tokenLength);
            builder.append('#');
            builder.append(s);
        }
        return builder.toString();
    }

    /*
     * @param str: A string
     * @return: decodes a single string to a list of strings
     * 012345678901234
     * 4#nshd6#kkweoij
     */
    public List<String> decode(String str) {

        int length, barrier, pointer = 0;

        List<String> result = new LinkedList<>();

        StringBuilder currentWord = new StringBuilder();

        while (pointer < str.length()) {
            length = readTokenLength(str, pointer);
            pointer += String.valueOf(length).length() + 1;
            barrier = length + pointer - 1;

            for (; pointer <= barrier; pointer++) {
                currentWord.append(str.charAt(pointer));
            }
            result.add(currentWord.toString());
            currentWord.setLength(0);
        }
        return result;
    }

    private int readTokenLength(String s, int index) {
        int i = index;
        StringBuilder builder = new StringBuilder();
        while (i < s.length()) {
            char symbol = s.charAt(i);
            if (symbol >= '0' && symbol <= '9') {
                builder.append(symbol);
                i++;
            } else if (symbol == '#') {
                return Integer.parseInt(builder.toString());
            } else throw new RuntimeException("Malformed input");
        }
        throw new RuntimeException("Malformed input");
    }

}
