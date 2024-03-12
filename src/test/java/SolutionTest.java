import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
    @Test
    public void test1(){
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(-3);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(1);
        ListNode expected = new ListNode(3);
        expected.next = new ListNode(1);
        boolean same = check(new Solution().removeZeroSumSublists(head), expected);

        Assert.assertTrue(same);
    }
    @Test
    public void test2(){
        ListNode head = new ListNode(5);
        head.next = new ListNode(-3);
        head.next.next = new ListNode(-4);
        head.next.next.next = new ListNode(1);
        head.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next = new ListNode(-2);
        head.next.next.next.next.next.next = new ListNode(5);
        ListNode expected = new ListNode(3);
        expected.next = new ListNode(1);
        boolean same = check(new Solution().removeZeroSumSublists(head), expected);

        Assert.assertTrue(same);
    }
    @Test
    public void test3(){
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(-3);
        head.next.next.next.next = new ListNode(-2);

        ListNode expected = new ListNode(1);

        boolean same = check(new Solution().removeZeroSumSublists(head), expected);

        Assert.assertTrue(same);
    }
    private boolean check(ListNode listNode, ListNode expected) {
        if(listNode == null && expected == null){
            return true;
        }
        while (listNode != null && expected != null){
            if(listNode.val != expected.val){
                return false;
            }
            listNode = listNode.next;
            expected = expected.next;
        }

        return listNode == null && expected == null;
    }
}
