//: [Previous](@previous)

import Foundation

class Solution {
    func nextGreaterElement(_ nums1: [Int], _ nums2: [Int]) -> [Int] {

        var result:[Int] = []
        for num in nums1  {
            // nums1 中数字 x 的下一个更大元素是指 x 在 nums2 中对应位置的右边的第一个比 x 大的元素。如果不存在，对应位置输出 -1 。

            let index = nums2.firstIndex(of: num)!
            let array = Array(nums2.suffix(from: index))
            var contain = false
            for big in array {
                if big > num {
                    result.append(big)
                    contain = true
                    break
                }
            }
            if !contain {
                result.append(-1)
            }
        }
        return result
    }
}

//: [Next](@next)
