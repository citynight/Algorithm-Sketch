//: [Previous](@previous)

import Foundation

class Solution {
    private var count = 0;
    func countSubstrings(_ s: String) -> Int {
        if s.count == 0 {
            return 0
        }
        let chars = Array(s)
        for i in 0..<s.count {
            helper(chars,i,i)
            helper(chars,i,i+1)
        }
        return count;
    }

    private func helper(_ chars:[String.Element],_ left:Int,_ right:Int) {
        var l = left
        var r = right
        while l >= 0 && r < chars.count && chars[l] == chars[r]{
            count += 1
            l -= 1
            r += 1
        }
    }
}

//: [Next](@next)
