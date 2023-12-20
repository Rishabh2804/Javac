#### Link: https://leetcode.com/discuss/interview-question/4133214/D.E.-Shaw-India-or-OA-or-Special-Array-or-Solution

Given `A`, a `2`\-dimentional array of integers with `n` row and `m` columns, any two rows can be combined as follows.

-   Pick `2` integers `i` and `j` where `(0 <= i, j < n)`
-   Merge the rows to create array `B` with `m` elements such that all `B[k] = max(A[i][k], A[j][k])` where `(0 <= k < m)`.

A special array `Z` of size `m`, is also given. Array `B` is called a good array if `B[k] >= Z[k]` for all k where `(0 <= k < m)`.

Find the number of ordered pairs `(i, j) (0 <= i, j < n)`, that merge to form a good array.

Note: An ordered pair `(i, j)` is distinct from `(j, i)` unless `i = j`. For example, `(1, 2)` and `(2, 1)` are distinct ordered pairs.

## Example

Given `n = 3, m = 2, A = [[1, 1], [4, 6], [6, 4]]` and `Z = [3, 3]`.

| Index Pair (i, j) | Array1 | Array2 | Combined Array | Remarks |
| --- | --- | --- | --- | --- |
| (0, 0) | \[1, 1\] | \[1, 1\] | \[1, 1\] | Not good |
| (0, 1) | \[1, 1\] | \[4, 1\] | \[4, 6\] | Good |
| (0, 2) | \[1, 1\] | \[6, 4\] | \[6, 4\] | Good |
| (1, 0) | \[4, 6\] | \[1, 1\] | \[4, 6\] | Good |
| (1, 1) | \[4, 6\] | \[4, 6\] | \[4, 6\] | Good |
| (1, 2) | \[4, 6\] | \[6, 4\] | \[6, 6\] | Good |
| (2, 0) | \[6, 4\] | \[1, 1\] | \[6, 4\] | Good |
| (2, 1) | \[6, 4\] | \[4, 6\] | \[6, 6\] | Good |
| (2, 2) | \[6, 4\] | \[6, 4\] | \[6, 4\] | Good |

`8` ordered pairs `(i, j)` exists such that `A[i]` and `A[j]`, combine to produce a good array Thus the answer is `8`.

## Constraints

```
1 <= n <= 10 ^ 5
1 <= m <= 8
1 <= A[i][j], Z[j] <= 10 ^ 9, where 0 <= i < n, 0 <= j < m
```

## Sample Case

```
2
3
1 2 3
4 5 6
3
8
8
8
```

## Sample Output

```
0
```

## My Solution

```python
from typing import List
from collections import defaultdict

def Solution(n: int, m: int, A: List[List[int]], Z: List[int]) -&gt; int:
    set_bits = [0 for _ in range(n)]
    
    for i in range(n):
        for j in range(m):
            if Z[j] <= A[i][j]:
                set_bits[i] |= (1 << j)
    
    mx_set = (1 << m) - 1
    freq = defaultdict(int)
    
    for element in set_bits:
        freq[element] += 1

    ans = 0
    for i in range(mx_set + 1):
        for j in range(i + 1, mx_set + 1):
            if (i | j) == mx_set:
                ans += 2 * freq[i] * freq[j]
    ans += freq[mx_set] * freq[mx_set]

    return ans

if __name__ == "__main__":
    n = int(input())
    m = int(input())
    A = [[] for _ in range(n)]
    for i in range(n):
        A[i] = list(map(int, input().split()))
    
    M = int(input())
    assert(M == m)
    Z = [0 for _ in range(M)]
    for i in range(M):
        Z[i] = int(input())

    print(Solution(n, m, A, Z))
```

**Note:** Do let me know if the above solution fails for any testcase.