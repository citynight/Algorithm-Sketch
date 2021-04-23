//: [Previous](@previous)

import Foundation

class Solution {
    private var map:[Int:Int] = [:]
    func removeDuplicates1(_ nums: inout [Int]) -> Int {
        for (index,item) in nums.enumerated().reversed() {
            let count = map[item] ?? 0
            if count == 2 {
                nums.remove(at: index)
            }else {
                map[item] = count + 1
            }
        }
        return nums.count
    }
    
    func removeDuplicates(_ nums: inout [Int]) -> Int {
        // p 指向第一个无效的未知
        var p = 2
        if nums.count < 3 {
            return nums.count
        }
        for (index,num) in nums.enumerated() {
            if index < 2 { continue }
            if num != nums[p-2] {
                p+=1
                nums[p] = num
            }
        }
        return p
    }
}

//: [Next](@next)
