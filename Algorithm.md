### The algorithm has 3 parts:
1. Reach node at position left
2. Reverse nodes from left to right position
3. Connecting the whole linkedList together

# Algorithm:
1. Start
2. Initialize int k = 1, node prev = null, cur = head, next = null
3. Repeat step 4 to 6 while k < left
4. prev = cur
5. cur = cur.next
6. increment k = k + 1\
	[End of part one]
7. Intialize prev_node = prev and cur_node = cur
8. Set prev = null
9. Repeat step 10 to 14 while k <= right
10. next = cur.next
11. cur.next = prev
12. prev = cur
13. cur = next
14. increment k = k + 1\
	[End of part 2]
15. condition: prev_node != null then prev_node.next = prev
16. cur_node = cur
17. return head of linkedList\
	[End of part 3]

###Example: 
head = 1 2 3 4 5\
left = 1 right = 4\
###Solution: 
k = 1;\
prev = null, cur = 1\
prev_node = prev = null, cur_node = cur = 1\
//Reversing nodes\
1.next = null\
2.next = 1\
3.next = 2\
4.next = 3\
prev = 4 cur = 5\
prev_node == null\
cur_node.next = cur therefore, 1.next = 5\
left == 1 so return prev = 4
