
## 未写代码，但思考过的问题

* 30 Substring with Concatenation of All Words
    * tag
        * two pointers
        * hashTable
        * string
    * 思路
        * 把所有L的字符串存到HashTable中，扫描S，碰到一个字符串则把hashTable中对应value置为true，如果已经为true则匹配失败
        * 扫描S的时候做skip优化
            * 如果扫描到任何非L中字符串，则直接跳到下一位
            * 如果扫描到重复字符串，则跳到上一次重复的字符串的下一位

* 36 Valid Sudoku (太简单，忽略)
* 37 Sudoku Solver
    * [常规解法](http://58.20.53.45/files/files_upload/content/material_169/COLUMN_6/file_8.htm)
    
* 76 Minimum Window Substring
    * tag: two pointers
    * 思路
        * 使用两个pointer，一个start一个end来进行标记匹配的开始和结束
        * 使用Bitset来标识匹配的情况
        * 如果发现匹配成功则更新start为下一个匹配的字符继续advance end, 最终找到min len即可

* 85 Maximal Rectangle
    * [思路](http://www.cnblogs.com/lichen782/p/leetcode_maximal_rectangle.html)

* 89 Gray Code
    * 思路
        * 递归backtracking
        * [规律](http://blog.csdn.net/worldwindjp/article/details/21536103)

* 92 Reverse Linked List II
    * 思路
        * two pointer + fake node
        
* 93 Restore IP Addresses
    * 思路：dfs with backtracking即可

* 114 Flatten Binary Tree to Linked List
    * 使用dummyNode，然后DFS即可
    
* 115 Distinct Subsequences
    * [参考](http://blog.csdn.net/abcbc/article/details/8978146)
    
* 129 Sum Root to Leaf Numbers
    * 直接DFS，每一次DFS带上至此路径上的数字，到达leaf时转换成数字加到sum上即可

* 130 Surrounded Regions
    * 顺序扫描，遇到O之后BFS，如果最终没有找到出口，则全部填满

* 131 Palindrome Partitioning
    * DFS即可
    
* 132 Palindrome Partitioning II
    * 使用DP，O(N^2)复杂度

* 140 Word Break II
    * 先用DP求得所有分割方法，然后dfs backtracking
    
* 141 Linked List Cycle
    * 一个fast节点每次走两步，一个slow节点每次走一步，如果相遇，则一定有环

* 142 Linked List Cycle II
    * 同141，到达相遇点后，fast节点重新回到head处，然后每次走一步，slow节点继续每次走一步，再次相遇出则为环入口
        
## 未思考过的问题

* 87 Scramble String
