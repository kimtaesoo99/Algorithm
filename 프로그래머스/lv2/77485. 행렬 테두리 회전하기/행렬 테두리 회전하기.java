class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[][] square = initSquare(rows, columns);
        return rotateNums(square, queries);
    }

    private int[] rotateNums(int[][] square, int[][] queries) {
        int[] answer = new int[queries.length];
        int index = 0;

        for (int[] query : queries) {
            int startX = query[0] - 1;
            int startY = query[1] - 1;
            int endX = query[2] - 1;
            int endY = query[3] - 1;
            int firstNum = square[startX][endY];
            int min = firstNum;

            for (int i = endY - 1; i >= startY; i--) {
                min = Math.min(min, square[startX][i]);
                square[startX][i + 1] = square[startX][i];
            }

            for (int i = startX + 1; i <= endX; i++) {
                min = Math.min(min, square[i][startY]);
                square[i - 1][startY] = square[i][startY];
            }

            for (int i = startY + 1; i <= endY; i++) {
                min = Math.min(min, square[endX][i]);
                square[endX][i - 1] = square[endX][i];
            }

            for (int i = endX - 1; i >= startX; i--) {
                min = Math.min(min, square[i][endY]);
                square[i + 1][endY] = square[i][endY];
            }

            square[startX + 1][endY] = firstNum;
            answer[index] = min;

            index++;
        }

        return answer;
    }

    private int[][] initSquare(int rows, int columns) {
        int[][] square = new int[rows][columns];
        int value = 1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                square[i][j] = value++;
            }
        }
        return square;
    }
}