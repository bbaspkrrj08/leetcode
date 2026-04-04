class Solution {
    public String decodeCiphertext(String encodedText, int rows) {
        int n = encodedText.length();
        int cols = n / rows;
        StringBuilder sb = new StringBuilder(n);
        
        
        for (int startCol = 0; startCol < cols; startCol++) {
            for (int r = 0; r < rows; r++) {
                int c = startCol + r;
                if (c < cols) {
                   
                    sb.append(encodedText.charAt(r * cols + c));
                }
            }
        }
        
        
        int end = sb.length();
        while (end > 0 && sb.charAt(end - 1) == ' ') {
            end--;
        }
        return sb.substring(0, end);
    }
}