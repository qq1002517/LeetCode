package cn.com.haobo56.LeetCode.day1;

/**
 * @author haobo56 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 *         请你将两个数相加，并以相同形式返回一个表示和的链表。 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。 输入：l1 =
 *         [2,4,3], l2 = [5,6,4] 输出：[7,0,8] 解释：342 + 465 = 807. 示例 2：
 * 
 *         输入：l1 = [0], l2 = [0] 输出：[0] 示例 3：
 * 
 *         输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9] 输出：[8,9,9,9,0,0,0,1]
 * 
 */
public class TwoNum {
	public static ListNode l1;
	public static ListNode l2;

	public static void main(String[] args) {
		int nums1[] ={2,4,3};
		int nums2[] ={5,6,4};
		ListNode l1 = toLinkList(nums1);
		ListNode l2 = toLinkList(nums2);
		addTwoNumbers(l1, l2);
	}

	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode head = null, tail = null;
		int carry = 0;
		while (l1 != null || l2 != null) {
			int n1 = l1 != null ? l1.val : 0;
			int n2 = l2 != null ? l2.val : 0;
			int sum = n1 + n2 + carry;
			if (head == null) {
				head = tail = new ListNode(sum % 10);
			} else {
				tail.next = new ListNode(sum % 10);
				tail = tail.next;
			}
			carry = sum / 10;
			if (l1 != null) {
				l1 = l1.next;
			}
			if (l2 != null) {
				l2 = l2.next;
			}
		}
		if (carry > 0) {
			tail.next = new ListNode(carry);
		}
		return head;

	}

	// 组链表
	public static ListNode toLinkList(int nums[]) {
		ListNode endNode = new ListNode(nums[nums.length - 1], null);
		ListNode node = null;
		for (int i = nums.length - 2; i >= 0; i--) {
			node = new ListNode(nums[i], endNode);
			endNode = node;
		}
		return node;
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
}
