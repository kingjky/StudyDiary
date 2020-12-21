import java.util.LinkedList;
import java.util.Queue;

class p60063 {
	static final int HORIZONTAL_DOWN = 0;
    static final int HORIZONTAL_UP = 1;
    static final int VERTICAL_LEFT = 2;
    static final int VERTICAL_RIGHT = 3;

    static final int HORIZONTAL = 0;
    static final int VERTICAL = 1;

    public int solution(int[][] board) {
        int answer = 0;

        int N = board.length;
        int[][][] visit = new int[N][N][2];
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                for (int k = 0; k < 2; k++)
                    visit[i][j][k] = -1;

        Queue<int[]> que = new LinkedList<int[]>();
        // r1, c1, r2, c2, distance
        que.add(new int[] { 1, 1, 1, 2, 0 });
        visit[0][0][0] = 0;

        while (!que.isEmpty()) {
            int[] cur = que.poll();
            int r1, c1, r2, c2, distance;
            r1 = cur[0];
            c1 = cur[1];
            r2 = cur[2];
            c2 = cur[3];
            distance = cur[4];

            int state = r1 == r2 ? HORIZONTAL : VERTICAL;

            if (r2 == N && c2 == N) {
                answer = distance;
                break;
            }

            int newR1, newC1, newR2, newC2;
            // 상
            newR1 = r1 - 1;
            newC1 = c1;
            newR2 = r2 - 1;
            newC2 = c2;
            if (wallCheck(newR1, newC1, newR2, newC2, board))
                if (visit[newR1 - 1][newC1 - 1][state] < 0 || visit[newR1 - 1][newC1 - 1][state] > distance + 1) {
                    visit[newR1-1][newC1-1][state] = distance+1;
                    que.add(new int[] { newR1, newC1, newR2, newC2, distance + 1 });
                }
            // 하
            newR1 = r1 + 1;
            newC1 = c1;
            newR2 = r2 + 1;
            newC2 = c2;
            if (wallCheck(newR1, newC1, newR2, newC2, board))
                if (visit[newR1 - 1][newC1 - 1][state] < 0 || visit[newR1 - 1][newC1 - 1][state] > distance + 1) {
                    visit[newR1-1][newC1-1][state] = distance+1;
                    que.add(new int[] { newR1, newC1, newR2, newC2, distance + 1 });
                }
            // 좌
            newR1 = r1;
            newC1 = c1 - 1;
            newR2 = r2;
            newC2 = c2 - 1;
            if (wallCheck(newR1, newC1, newR2, newC2, board))
                if (visit[newR1 - 1][newC1 - 1][state] < 0 || visit[newR1 - 1][newC1 - 1][state] > distance + 1) {
                    visit[newR1-1][newC1-1][state] = distance+1;
                    que.add(new int[] { newR1, newC1, newR2, newC2, distance + 1 });
                }
            // 우
            newR1 = r1;
            newC1 = c1 + 1;
            newR2 = r2;
            newC2 = c2 + 1;
            if (wallCheck(newR1, newC1, newR2, newC2, board))
                if (visit[newR1 - 1][newC1 - 1][state] < 0 || visit[newR1 - 1][newC1 - 1][state] > distance + 1) {
                    visit[newR1-1][newC1-1][state] = distance+1;
                    que.add(new int[] { newR1, newC1, newR2, newC2, distance + 1 });
                }

            if (r1 == r2) {
                // 가로 좌축 하향
                newR1 = r1;
                newC1 = c1;
                newR2 = r2 + 1;
                newC2 = c2 - 1;
                if (rotateCheck(r1, c1, r2, c2, HORIZONTAL_DOWN, board)) {
                    if (visit[newR1 - 1][newC1 - 1][VERTICAL] < 0
                            || visit[newR1 - 1][newC1 - 1][VERTICAL] > distance + 1) {
                        visit[newR1-1][newC1-1][VERTICAL] = distance+1;
                        que.add(new int[] { newR1, newC1, newR2, newC2, distance + 1 });
                    }
                }
                // 가로 좌축 상향
                newR1 = r2 - 1;
                newC1 = c2 - 1;
                newR2 = r1;
                newC2 = c1;
                if (rotateCheck(r1, c1, r2, c2, HORIZONTAL_UP, board)) {
                    if (visit[newR1 - 1][newC1 - 1][VERTICAL] < 0
                            || visit[newR1 - 1][newC1 - 1][VERTICAL] > distance + 1) {
                        visit[newR1-1][newC1-1][VERTICAL] = distance+1;
                        que.add(new int[] { newR1, newC1, newR2, newC2, distance + 1 });
                    }
                }
                // 가로 우축 하향
                newR1 = r2;
                newC1 = c2;
                newR2 = r1 + 1;
                newC2 = c1 + 1;
                if (rotateCheck(r1, c1, r2, c2, HORIZONTAL_DOWN, board)) {
                    if (visit[newR1 - 1][newC1 - 1][VERTICAL] < 0
                            || visit[newR1 - 1][newC1 - 1][VERTICAL] > distance + 1) {
                        visit[newR1-1][newC1-1][VERTICAL] = distance+1;
                        que.add(new int[] { newR1, newC1, newR2, newC2, distance + 1 });
                    }
                }
                // 가로 우축 상향
                newR1 = r1 - 1;
                newC1 = c1 + 1;
                newR2 = r2;
                newC2 = c2;
                if (rotateCheck(r1, c1, r2, c2, HORIZONTAL_UP, board)) {
                    if (visit[newR1 - 1][newC1 - 1][VERTICAL] < 0
                            || visit[newR1 - 1][newC1 - 1][VERTICAL] > distance + 1) {
                        visit[newR1-1][newC1-1][VERTICAL] = distance+1;
                        que.add(new int[] { newR1, newC1, newR2, newC2, distance + 1 });
                    }
                }
            }
            if (c1 == c2) {
                // 세로 상축 좌향
                newR1 = r2 - 1;
                newC1 = c2 - 1;
                newR2 = r1;
                newC2 = c1;
                if (rotateCheck(r1, c1, r2, c2, VERTICAL_LEFT, board)) {
                    if (visit[newR1 - 1][newC1 - 1][HORIZONTAL] < 0
                            || visit[newR1 - 1][newC1 - 1][HORIZONTAL] > distance + 1) {
                        visit[newR1-1][newC1-1][HORIZONTAL] = distance+1;
                        que.add(new int[] { newR1, newC1, newR2, newC2, distance + 1 });
                    }
                }
                // 세로 하축 좌향
                newR1 = r1 + 1;
                newC1 = c1 - 1;
                newR2 = r2;
                newC2 = c2;
                if (rotateCheck(r1, c1, r2, c2, VERTICAL_LEFT, board)) {
                    if (visit[newR1 - 1][newC1 - 1][HORIZONTAL] < 0
                            || visit[newR1 - 1][newC1 - 1][HORIZONTAL] > distance + 1) {
                        visit[newR1-1][newC1-1][HORIZONTAL] = distance+1;
                        que.add(new int[] { newR1, newC1, newR2, newC2, distance + 1 });
                    }
                }
                // 세로 상축 우향
                newR1 = r1;
                newC1 = c1;
                newR2 = r2 - 1;
                newC2 = c2 + 1;
                if (rotateCheck(r1, c1, r2, c2, VERTICAL_RIGHT, board)) {
                    if (visit[newR1 - 1][newC1 - 1][HORIZONTAL] < 0
                            || visit[newR1 - 1][newC1 - 1][HORIZONTAL] > distance + 1) {
                        visit[newR1-1][newC1-1][HORIZONTAL] = distance+1;
                        que.add(new int[] { newR1, newC1, newR2, newC2, distance + 1 });
                    }
                }
                // 세로 하축 우향
                newR1 = r2;
                newC1 = c2;
                newR2 = r1 + 1;
                newC2 = c2 + 1;
                if (rotateCheck(r1, c1, r2, c2, VERTICAL_RIGHT, board)) {
                    if (visit[newR1 - 1][newC1 - 1][HORIZONTAL] < 0
                            || visit[newR1 - 1][newC1 - 1][HORIZONTAL] > distance + 1) {
                        visit[newR1-1][newC1-1][HORIZONTAL] = distance+1;
                        que.add(new int[] { newR1, newC1, newR2, newC2, distance + 1 });
                    }
                }
            }
        }
        return answer;
    }

    private boolean rotateCheck(int r1, int c1, int r2, int c2, int direction, int[][] board) {
        int N = board.length;
        int newR1, newC1, newR2, newC2;
        switch (direction) {
        case HORIZONTAL_DOWN:
            newR1 = r1 + 1;
            newR2 = r2 + 1;
            if (newR1 > N || newR2 > N)
                return false;
            return (board[newR1 - 1][c1 - 1] < 1 && board[newR2 - 1][c2 - 1] < 1);
        case HORIZONTAL_UP:
            newR1 = r1 - 1;
            newR2 = r2 - 1;
            if (newR1 < 1 || newR2 < 1)
                return false;
            return (board[newR1 - 1][c1 - 1] < 1 && board[newR2 - 1][c2 - 1] < 1);
        case VERTICAL_LEFT:
            newC1 = c1 - 1;
            newC2 = c2 - 1;
            if (newC1 < 1 || newC2 < 1)
                return false;
            return (board[r1 - 1][newC1 - 1] < 1 && board[r2 - 1][newC2 - 1] < 1);
        case VERTICAL_RIGHT:
            newC1 = c1 + 1;
            newC2 = c2 + 1;
            if (newC1 > N || newC2 > N)
                return false;
            return (board[r1 - 1][newC1 - 1] < 1 && board[r2 - 1][newC2 - 1] < 1);
        default:
            return false;
        }
    }

    boolean wallCheck(int r1, int c1, int r2, int c2, int[][] board) {
        int N = board.length;
        if (r1 < 1 || r1 > N || c1 < 1 || c1 > N || r2 < 1 || r2 > N || c2 < 1 || c2 > N)
            return false;
        return (board[r1 - 1][c1 - 1] < 1 && board[r2 - 1][c2 - 1] < 1);
    }

	public static void main(String[] args) {
		p60063 p = new p60063();
		int result;

		result = p.solution(new int[][] { { 0, 0, 0, 1, 1 }, { 0, 0, 0, 1, 0 }, { 0, 1, 0, 1, 1 }, { 1, 1, 0, 0, 1 },
				{ 0, 0, 0, 0, 0 } });
		System.out.println(result);

		result = p.solution(new int[][] { { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 } });
		System.out.println(result);
	}
}