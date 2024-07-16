class Solution {
    public boolean solution(int[][] key, int[][] lock) {
        int N = lock.length;
        int[][] map = new int[N * 3][N * 3];
        int hole = 0;

        // 자물쇠를 중심으로 큰 배열에 복사
        for (int i = 0; i < N; i++) {
            System.arraycopy(lock[i], 0, map[N + i], N, N);
            for (int j = 0; j < N; j++) {
                if (lock[i][j] == 0)
                    hole++;
            }
        }

        // 키를 4번 회전하며 시도
        for (int i = 0; i < 4; i++) {
            if (slidingWindow(key, map, N, hole)) {
                return true;
            }
            key = rotate(key);
        }
        return false;
    }

    private boolean slidingWindow(int[][] key, int[][] map, int N, int h) {
        int M = key.length;
        int count = N + N;

        for (int i = 0; i < count; i++) {
            for (int j = 0; j < count; j++) {
                if (unlock(key, map, M, i, j, N, h)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean unlock(int[][] key, int[][] map, int M, int startX, int startY, int N, int hole) {
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < M; j++) {
                int mapX = startX + i;
                int mapY = startY + j;
                if (mapX >= N && mapX < 2 * N && mapY >= N && mapY < 2 * N) {
                    if (map[mapX][mapY] == 1 && key[i][j] == 1) {
                        return false;
                    }
                    if (map[mapX][mapY] == 0 && key[i][j] == 1) {
                        hole--;
                    }
                }
            }
        }
        return hole == 0;
    }

    private int[][] rotate(int[][] key) {
        int l = key.length;
        int[][] newKey = new int[l][l];

        for (int i = 0; i < l; i++) {
            for (int j = 0; j < l; j++) {
                newKey[j][l - 1 - i] = key[i][j];
            }
        }

        return newKey;
    }

}