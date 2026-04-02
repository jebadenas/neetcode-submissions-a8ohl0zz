class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        cols = defaultdict(set)
        rows = defaultdict(set)
        squares = defaultdict(set)

        for r in range(len(board)):
            row = board[r]
            for c in range(len(row)):
                current = board[r][c]

                if current == ".":
                    continue
                if (current in rows[r] or current in cols[c] or current in squares[(r//3, c//3)]):
                    return False

                cols[c].add(current)
                rows[r].add(current)
                squares[(r//3, c//3)].add(current)

        return True