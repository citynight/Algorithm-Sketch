//: [Previous](@previous)

import Foundation

/*
 3. 无重复字符的最长子串
 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。

 示例 1:

 输入: "abcabcbb"
 输出: 3
 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 示例 2:

 输入: "bbbbb"
 输出: 1
 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 示例 3:

 输入: "pwwkew"
 输出: 3
 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。

 https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 */


class Solution {
    func lengthOfLongestSubstring(_ s: String) -> Int {
        var max = 0
        let chars = Array(s)
        var start = 0
        var map:[String.Element:Int] = [:]
        for i in 0..<chars.count {
            let char = chars[i]
            let index = map[char] ?? -1
            if index >= start {
                let curr = i - start
                max = max > curr ? max : curr
                start = index + 1
            }
            map[char] = i
        }
        let curr = chars.count - start
        max = max > curr ? max : curr
        return max
    }
}

//: [Next](@next)
