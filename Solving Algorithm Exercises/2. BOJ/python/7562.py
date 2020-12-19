from collections import deque

def find(start, dest, visit):
    cur = None
    que = deque([(start[0], start[1], 0)])
    while len(que) > 0:
        cur = que.popleft()
        if cur[0] == dest[0] and cur[1] == dest[1]:
            return cur[2]
        for (a, b) in diff:
            if 0 <= cur[0] + a < l and 0 <= cur[1] + b < l and not visit[cur[0] + a][cur[1] + b]:
                visit[cur[0] + a][cur[1] + b] = True
                que.append((cur[0] + a, cur[1] + b, cur[2] + 1))

N = int(input())
diff = [(-2, -1), (-1, -2), (1, 2), (2, 1),
        (-2, 1), (-1, 2), (1, -2), (2, -1)]
for n in range(N):
    l = int(input())
    start = tuple(map(int, input().split()))
    dest = tuple(map(int, input().split()))
    visit = [[False] * l for _ in range(l)]
    print(find(start, dest, visit))