class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashMap<Integer, Set<Character>> columns = new HashMap<>();
        HashMap<Integer, Set<Character>> rows = new HashMap<>();
        HashMap<String, Set<Character>> squares = new HashMap<>();

        for (int rowIndex = 0; rowIndex < board.length ; rowIndex++){
            char[] row = board[rowIndex];
            for (int col = 0; col < row.length; col++){
                char c = board[rowIndex][col];

                if (c != '.'){
                    String squareKey = (col/3) + "," + (rowIndex/3);

                    //computeIfAbset => checks if key exists, if it doesnt will perform function and its return will be the value
                    boolean x = columns.computeIfAbsent(col, a -> new HashSet<>()).contains(c);
                    boolean y = rows.computeIfAbsent(rowIndex, a -> new HashSet<>()).contains(c);
                    boolean z = squares.computeIfAbsent(squareKey, a -> new HashSet<>()).contains(c);

                    if (x || y || z) {
                        return false;
                    }

                    rows.get(rowIndex).add(c);
                    columns.get(col).add(c);
                    squares.get(squareKey).add(c);
                }
            }
        }

        return true;
    }
}
