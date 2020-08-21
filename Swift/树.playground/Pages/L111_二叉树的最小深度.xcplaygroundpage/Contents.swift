//: [Previous](@previous)

import Foundation

public class TreeNode {
    public var val: Int
    public var left: TreeNode?
    public var right: TreeNode?
    public init(_ val: Int) {
        self.val = val
        self.left = nil
        self.right = nil
    }
}

class Solution {
    func minDepth(_ root: TreeNode?) -> Int {
        guard let root = root else { return 0 }
        if root.left == nil || root.right == nil {
            return 1 + max(minDepth(root.left),minDepth(root.right))
        }
        return 1 + min(minDepth(root.left),minDepth(root.right))
    }
}

//: [Next](@next)
