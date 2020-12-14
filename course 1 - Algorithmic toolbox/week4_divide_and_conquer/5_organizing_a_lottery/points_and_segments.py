import sys
from collections import defaultdict


def fast_count_segments(zippedList,points):
    elements = []
    d = defaultdict(list)

    for i in zippedList:
        elements.append([i[0],'l'])
    for x in range(len(points)):
        elements.append([points[x],'p'])
    for j in zippedList:
        elements.append([j[1],'r'])

    elements.sort(key=lambda x: x[1])
    elements.sort(key=lambda x: x[0])
    print(elements)
    count = 0

    for x in elements:
        if x[1] == 'l':
            count += 1
        if x[1] == 'r':
            count -= 1
        if x[1] == 'p':
            d[x[0]] = max(count,0)
    return d


def naive_count_segments(starts, ends, points):
    cnt = [0] * len(points)
    for i in range(len(points)):
        for j in range(len(starts)):
            if starts[j] <= points[i] <= ends[j]:
                cnt[i] += 1
    return cnt

if __name__ == '__main__':
    data = list(map(int, sys.stdin.read().split()))
    n = data[0]
    m = data[1]
    starts = data[2:2 * n + 2:2]
    ends   = data[3:2 * n + 2:2]
    points = data[2 * n + 2:]
    zippedList = list(zip(starts,ends))
    cnt = fast_count_segments(zippedList, points)
    for x in points:
        print(cnt[x], end=' ')
