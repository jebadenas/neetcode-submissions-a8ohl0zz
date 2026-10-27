class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        
        row = []
        col = []
        grid = {}

        for i in range(9):
            row.append(set())
            col.append(set())

        for i in range(3):
            for j in range(3):
                id =  str(i) + str(j)
                grid[id] = set()
        
        for r in range(len(board)):
            for c in range(len(board[r])):
                curVal = board[r][c]

                if curVal == ".":
                    continue

                curCol = col[c]
                if curVal in curCol:
                    return False
                curCol.add(curVal)
                
                curRow = row[r]
                if curVal in curRow:
                    return False
                curRow.add(curVal)

                boxId = str(r//3) + str(c//3)
                curBox = grid[boxId]

                if curVal in curBox:
                    return False 
                curBox.add(curVal)

        return True


