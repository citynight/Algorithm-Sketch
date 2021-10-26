//: [Previous](@previous)

import Foundation

class Solution {
    func searchMatrix(_ matrix: [[Int]], _ target: Int) -> Bool {
        let list = matrix.flatMap({$0})
        return list.contains(target)
    }
}

//: [Next](@next)
