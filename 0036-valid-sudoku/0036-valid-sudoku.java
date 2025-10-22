class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String> visited=new HashSet<>();
        for(int ansh=0;ansh<9;ansh++){
            for(int akki=0;akki<9;akki++){
                char c=board[ansh][akki];
                if(c=='.')
                continue;
                if(!visited.add(c+"row"+ansh)||
                   !visited.add(c+"col"+akki)||
                   !visited.add(c+"box"+ansh/3+"-"+akki/3)){
                    return false;
                   }
            }

        }
        return true;
    }
}