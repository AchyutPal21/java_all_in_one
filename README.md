# DATA STRUCTURES & ALGORITHMS ⭐⭐⭐

My DSA practice log in Java. Each topic has its own section below.
Every question links to the problem and to my solution file — one click away.

**Base package:** `src/main/java/com/dsa/`

---

## 📋 How to add a new question

1. Solve it inside the right topic package, e.g. `src/main/java/com/dsa/dynamicprogramming/`
2. Add **one row** to that topic's table (newest on top).
3. Give it an **importance rating** — this is what you'll use to decide what to revise.

**Row template (copy-paste):**

```markdown
| [Question Name](PROBLEM_URL) | Platform | Medium | ⭐⭐⭐⭐☆ | O(n) / O(1) | YYYY-MM-DD | [File.java](src/main/java/com/dsa/<topic>/File.java) |
```

**Importance rating — how much this question matters:**

| Rating | Meaning |
| :--- | :--- |
| ⭐⭐⭐⭐⭐ | Must-know pattern. Revise before every interview. |
| ⭐⭐⭐⭐☆ | Very important. Common interview question. |
| ⭐⭐⭐☆☆ | Good practice. Solid pattern to know. |
| ⭐⭐☆☆☆ | Nice to have. Rare in interviews. |
| ⭐☆☆☆☆ | Basic / warm-up. Low priority. |

---

## 📚 Topics

| Topic | Solved |
| :--- | :---: |
| [Dynamic Programming](#-dynamic-programming) | 4 |
| [Recursion & Backtracking](#-recursion--backtracking) | 4 |
| [Sorting](#-sorting) | 2 |
| [Arrays & Math](#-arrays--math) | 4 |
| [Two Pointers](#-two-pointers) | 1 |
| [Linked List](#-linked-list) | 2 |

---

## 🧠 Dynamic Programming

📁 [`src/main/java/com/dsa/dynamicprogramming/`](src/main/java/com/dsa/dynamicprogramming/)

| Question | Platform | Difficulty | Importance | TC / SC | Date | Solution |
| :--- | :--- | :--- | :--- | :--- | :--- | :--- |
| [Climbing Stairs II](https://leetcode.com/problems/climbing-stairs-ii/description/) | LeetCode | Medium | ⭐⭐⭐⭐⭐ | O(n) / O(1) | 2026-08-12 | [ClimbingStairsII.java](src/main/java/com/dsa/dynamicprogramming/ClimbingStairsII.java) |
| [Climbing Stairs](https://leetcode.com/problems/climbing-stairs/description/) | LeetCode | Easy | ⭐⭐⭐⭐⭐ | O(n) / O(n) | — | [ClimbingStairs.java](src/main/java/com/dsa/dynamicprogramming/ClimbingStairs.java) |
| [Fibonacci Number](https://leetcode.com/problems/fibonacci-number/description/) | LeetCode | Easy | ⭐⭐⭐⭐⭐ | O(n) / O(1) | — | [FibonacciNumber.java](src/main/java/com/dsa/dynamicprogramming/FibonacciNumber.java) |
| [Distinct Subsequences](https://leetcode.com/problems/distinct-subsequences/description/) | LeetCode | Hard | ⭐⭐⭐☆☆ | O(n·m) / O(n·m) | — | [DistinctSubsequences.java](src/main/java/com/dsa/dynamicprogramming/DistinctSubsequences.java) |

---

## 🔁 Recursion & Backtracking

📁 [`src/main/java/com/dsa/recursion/`](src/main/java/com/dsa/recursion/)

| Question | Platform | Difficulty | Importance | TC / SC | Date | Solution |
| :--- | :--- | :--- | :--- | :--- | :--- | :--- |
| [Combination Sum](https://leetcode.com/problems/combination-sum/description/) | LeetCode | Medium | ⭐⭐⭐⭐⭐ | O(2^t) / O(t) | — | [CombinationSum.java](src/main/java/com/dsa/recursion/CombinationSum.java) |
| [Combination Sum II](https://leetcode.com/problems/combination-sum-ii/description/) | LeetCode | Medium | ⭐⭐⭐⭐☆ | O(2^n · k) / O(n) | — | [CombinationSumII.java](src/main/java/com/dsa/recursion/CombinationSumII.java) |
| Print / Count Subsequences | — | Easy | ⭐⭐⭐⭐☆ | O(2^n) / O(n) | — | [SubSequenceByRec.java](src/main/java/com/dsa/recursion/SubSequenceByRec.java) |
| Backtracking basics | — | Easy | ⭐⭐⭐☆☆ | — | — | [Backtracking.java](src/main/java/com/dsa/recursion/Backtracking.java) |

---

## 🔀 Sorting

📁 [`src/main/java/com/dsa/recursion/`](src/main/java/com/dsa/recursion/)

| Question | Platform | Difficulty | Importance | TC / SC | Date | Solution |
| :--- | :--- | :--- | :--- | :--- | :--- | :--- |
| Merge Sort | — | Medium | ⭐⭐⭐⭐⭐ | O(n log n) / O(n) | — | [MergeSort.java](src/main/java/com/dsa/recursion/MergeSort.java) |
| Quick Sort | — | Medium | ⭐⭐⭐⭐⭐ | O(n log n) / O(log n) | — | [QuickSort.java](src/main/java/com/dsa/recursion/QuickSort.java) |

---

## 🔢 Arrays & Math

📁 [`src/main/java/com/dsa/array/simple/`](src/main/java/com/dsa/array/simple/)

| Question | Platform | Difficulty | Importance | TC / SC | Date | Solution |
| :--- | :--- | :--- | :--- | :--- | :--- | :--- |
| Elements greater than itself | — | Easy | ⭐⭐☆☆☆ | — | — | [ElementGreaterThenItself.java](src/main/java/com/dsa/array/simple/ElementGreaterThenItself.java) |
| Find all factors | — | Easy | ⭐⭐☆☆☆ | O(√n) / O(1) | — | [FindFactor.java](src/main/java/com/dsa/array/simple/FindFactor.java) |
| Square root of a number | — | Easy | ⭐⭐⭐☆☆ | O(log n) / O(1) | — | [FindSqrtRoot.java](src/main/java/com/dsa/array/simple/FindSqrtRoot.java) |
| Check prime number | — | Easy | ⭐⭐☆☆☆ | O(√n) / O(1) | — | [IsPrime.java](src/main/java/com/dsa/array/simple/IsPrime.java) |

---

## ↔️ Two Pointers

📁 [`src/main/java/com/dsa/twopointers/`](src/main/java/com/dsa/twopointers/)

| Question | Platform | Difficulty | Importance | TC / SC | Date | Solution |
| :--- | :--- | :--- | :--- | :--- | :--- | :--- |
| Two pointers practice | — | Easy | ⭐⭐⭐☆☆ | — | — | [SolveOne.java](src/main/java/com/dsa/twopointers/SolveOne.java) |

---

## 🔗 Linked List

📁 [`src/main/java/com/dsa/linkedlist/`](src/main/java/com/dsa/linkedlist/)

| Question | Platform | Difficulty | Importance | TC / SC | Date | Solution |
| :--- | :--- | :--- | :--- | :--- | :--- | :--- |
| Singly Linked List implementation | — | Easy | ⭐⭐⭐⭐☆ | — | — | [LinkedList.java](src/main/java/com/dsa/linkedlist/LinkedList.java) |
| Singly Node structure | — | Easy | ⭐⭐☆☆☆ | — | — | [SinglyNode.java](src/main/java/com/dsa/linkedlist/SinglyNode.java) |

---

## 🚀 Running the code

```bash
mvn -q compile                                    # compile
mvn -q exec:java -Dexec.mainClass=com.dsa.Main    # run Main
```
