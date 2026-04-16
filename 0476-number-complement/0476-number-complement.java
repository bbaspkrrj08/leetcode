class Solution {
    public int findComplement(int num) {
        String binary = toBinary(num);
        String flipped = flip(binary);
        return toInteger(flipped);        
    }

    private String toBinary(int n) {
        if (n == 0) return "0";
        StringBuilder sb = new StringBuilder();

        while (n > 0) {
            sb.append(n % 2);
            n /= 2;
        }

        return sb.reverse().toString();
    }

    private String flip(String binary) {
        StringBuilder sb = new StringBuilder();

        for (char c : binary.toCharArray()) {
            if (c == '0') sb.append('1');
            else sb.append('0');
        }

        return sb.toString();
    }

    private int toInteger(String binary) {
        int result = 0;

        for (char c : binary.toCharArray()) {
            result = result * 2 + (c - '0');
        }

        return result;
    }

}