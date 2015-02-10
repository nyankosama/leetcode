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

