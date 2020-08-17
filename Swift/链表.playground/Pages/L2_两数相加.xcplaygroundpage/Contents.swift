//: [Previous](@previous)

import Foundation

class Solution {
    
    // Version 1
    func addTwoNumbers1(_ l1: ListNode?, _ l2: ListNode?) -> ListNode? {
        // 判空
        guard let l1 = l1 else {
            return l2
        }
        guard let l2 = l2 else {
            return l1
        }

        let value = l1.val + l2.val
        if value > 9{
            l1.val = value - 10
            l1.next = addOne(l1.next)
        }else {
            l1.val = value
        }
        l1.next = addTwoNumbers(l1.next, l2.next)
        return l1
    }

    private func addOne(_ node:ListNode?) -> ListNode {
        guard let node = node else {
            return ListNode(1)
        }
        if node.val == 9 {
            node.val = 0
            node.next = addOne(node.next)
        }else{
            node.val = node.val + 1
        }
        return node
    }
    
    // Version 2
    func addTwoNumbers(_ l1: ListNode?, _ l2: ListNode?) -> ListNode? {
        let dummayHead = ListNode(0)
        var p = l1
        var q = l2
        var current = dummayHead
        var carry = 0
        
        while p != nil || q != nil {
            let x = (p != nil) ? p!.val : 0
            let y = (q != nil) ? q!.val : 0
            let sum = x + y + carry
            carry = sum / 10
            current.next = ListNode(sum % 10)
            current = current.next!
            if p != nil { p = p!.next }
            if q != nil { q = q!.next }
        }
        
        if carry > 0 {
            current.next = ListNode(carry)
        }
        return dummayHead.next
    }
}

//: [Next](@next)
