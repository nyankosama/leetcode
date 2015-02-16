* 30. Substring with Concatenation of All Words
    * tag
        * two pointers
        * hashTable
        * string
    * 思路
        * 把所有L的字符串存到HashTable中，扫描S，碰到一个字符串则把hashTable中对应value置为true，如果已经为true则匹配失败
        * 扫描S的时候做skip优化
            * 如果扫描到任何非L中字符串，则直接跳到下一位
            * 如果扫描到重复字符串，则跳到上一次重复的字符串的下一位

* 36. Valid Sudoku (太简单，忽略)
* 37. Sudoku Solver
    * [常规解法](http://58.20.53.45/files/files_upload/content/material_169/COLUMN_6/file_8.htm)
    
* 76. Minimum Window Substring
    * tag: two pointers
    * 思路
        * 使用两个pointer，一个start一个end来进行标记匹配的开始和结束
        * 使用Bitset来标识匹配的情况
        * 如果发现匹配成功则更新start为下一个匹配的字符继续advance end, 最终找到min len即可

* 85. Maximal Rectangle
    * [思路](http://www.cnblogs.com/lichen782/p/leetcode_maximal_rectangle.html)



