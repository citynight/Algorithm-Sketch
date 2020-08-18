//: [Previous](@previous)

import Foundation

public class ListNode {
    public var val: Int
    public var next: ListNode?
    public init() { self.val = 0; self.next = nil; }
    public init(_ val: Int) { self.val = val; self.next = nil; }
    public init(_ val: Int, _ next: ListNode?) { self.val = val; self.next = next; }
}
 

public class TreeNode {
    public var val: Int
    public var left: TreeNode?
    public var right: TreeNode?
    public init() { self.val = 0; self.left = nil; self.right = nil; }
    public init(_ val: Int) { self.val = val; self.left = nil; self.right = nil; }
    public init(_ val: Int, _ left: TreeNode?, _ right: TreeNode?) {
        self.val = val
        self.left = left
        self.right = right
    }
}
class Solution {
    func sortedListToBST(_ head: ListNode?) -> TreeNode? {
        if head == nil {
            return nil
        }
        var curr = head
        var nums = [Int]()
        while curr != nil {
            nums.append(curr!.val)
            curr = curr!.next
        }
        return helper(nums,0,nums.count - 1)
    }
    
    private func helper(_ nums:[Int], _ start:Int, _ end: Int) -> TreeNode? {
        if start > end {
            return nil
        }
        
        let mid = start + (end - start)/2
        let root = TreeNode(nums[mid])
        root.left = helper(nums,start,mid - 1)
        root.right = helper(nums,mid + 1,end)
        return root
    }
}
//: [Next](@next)
