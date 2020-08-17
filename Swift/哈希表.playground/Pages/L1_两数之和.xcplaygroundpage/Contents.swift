//: [Previous](@previous)

import Foundation

/*
 思路: 查找遍历过的数据中是否存在当前元素所对应的目标元素，如果存在说明找到了对应的解，直接返回
 */
class Solution {
    // version 1: 使用 enumerated 遍历
    func twoSum1(_ nums: [Int], _ target: Int) -> [Int] {
        var map:[Int: Int] = [:]
        for (index,num) in nums.enumerated() {
            let complement = target - num
            if map[complement] == nil {
                map[num] = index
            }else {
                return [map[complement]!, index]
            }
        }
        return []
    }
    // version 2: 直接遍历索引
    func twoSum(_ nums: [Int], _ target: Int) -> [Int] {
        if nums.count < 2 {
            return []
        }
        var map:[Int: Int] = [:]
        for index in 0..<nums.count {
            let complement = target - nums[index]
            if map[complement] == nil {
                map[nums[index]] = index
            }else {
                return [map[complement]!, index]
            }
        }
        return []
    }
}

//: [Next](@next)
