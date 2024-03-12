import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public ListNode removeZeroSumSublists(ListNode head) {
        Deque<Pair> stack = new ArrayDeque<>();
        Pair last = null;
        while (head != null) {
            if(last != null){
                last.node.next = head;
            }
            if(stack.isEmpty() || stack.peek().sum == 0){
                stack.clear();
                if(head.val != 0){
                    stack.push(new Pair(head, head.val));
                    last = new Pair(head, head.val);
                }

            } else {
                int target = head.val;
                Deque<Pair> temp = new ArrayDeque<>();
                while (!stack.isEmpty() && target != 0){
                    target += stack.peek().node.val;
                    temp.push(stack.pop());
                }
                if(stack.isEmpty() && target == 0){
                    last = null;
                }else if(stack.isEmpty()){
                    while (!temp.isEmpty()){
                        stack.push(temp.pop());
                    }
                    stack.push(new Pair(head, stack.peek().sum + head.val));
                    last = new Pair(head, stack.peek().sum + head.val);
                }else{
                    last = stack.peek();
                }

            }
            head = head.next;
        }
        if(last !=null){
            last.node.next = null;
        }
        //System.out.println(stack);

        return stack.isEmpty() ? null : stack.peekLast().node;
    }
}
class Pair{
    ListNode node;
    int sum;

    public Pair(ListNode node, int sum) {
        this.node = node;
        this.sum = sum;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "node=" + node +
                '}';
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                '}';
    }
}
