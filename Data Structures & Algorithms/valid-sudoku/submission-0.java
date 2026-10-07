class Solution {
    public boolean isValidSudoku(char[][] board) {

        List<Set<Character>> seenRow = new ArrayList<>();
        List<Set<Character>> seenCol = new ArrayList<>();
        List<Set<Character>> seenSqr = new ArrayList<>();

        // Initialize the sets
        for (int i = 0; i < 9; i++) {
            seenRow.add(new HashSet<>());
            seenCol.add(new HashSet<>());
            seenSqr.add(new HashSet<>());
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                char currChar = board[i][j];
                if (currChar == '.') {
                    continue;
                }

                // Calculate square
                int sqr = i/3 + j/3*3;

                if (seenRow.get(i).contains(currChar) || 
                seenCol.get(j).contains(currChar) || 
                seenSqr.get(sqr).contains(currChar)) {
                    return false;
                }

                seenRow.get(i).add(currChar);
                seenCol.get(j).add(currChar);
                seenSqr.get(sqr).add(currChar);
            }
        }

        return true;
    }
}
