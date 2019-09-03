//package String;
//
//import java.util.List;
//import java.util.Stack;
//
///**
// * Leetcode 385. Mini Parser
// * https://leetcode.com/problems/mini-parser/description/
// * Given a nested list of integers represented as a string, implement a parser to deserialize it.
// * Each element is either an integer, or a list -- whose elements may also be integers or other lists.
// * Note: You may assume that the string is well-formed: String is non-empty. String does not contain white spaces. String contains only digits 0-9, [, - ,, ].
// * Given s = "324", You should return a NestedInteger1 object which contains a single integer 324.
// * Given s = "[123,[456,[789]]]", Return a NestedInteger1 object containing a nested list with 2 elements: 1. An integer containing value 123. 
// * 2. A nested list containing two elements: i.  An integer containing value 456. ii. A nested list with one element: a. An integer containing value 789.
// * Explanation and Code from: https://leetcode.com/problems/mini-parser/discuss/86066
// * @author NisuBhakti
// * Medium
// * Airbnb
// */
//
//	// This is the interface that allows for creating nested lists.
// 	// You should not implement it, or speculate about its implementation
//interface NestedInteger1 {
//	// Constructor initializes an empty nested list.
//	//public NestedInteger1();
//
//	// Constructor initializes a single integer.
//	//public NestedInteger1(int value);
//
//	// @return true if this NestedInteger1 holds a single integer, rather than a nested list.
//	public boolean isInteger();
//
//   // @return the single integer that this NestedInteger1 holds, if it holds a single integer
//   // Return null if this NestedInteger1 holds a nested list
//   public Integer getInteger();
//
//   // Set this NestedInteger1 to hold a single integer.
//   public void setInteger(int value);
//
//   // Set this NestedInteger1 to hold a nested list and adds a nested integer to it.
//   public void add(NestedInteger1 ni);
//
//   // @return the nested list that this NestedInteger1 holds, if it holds a nested list
//   // Return null if this NestedInteger1 holds a single integer
//   public List<NestedInteger1> getList();
//}
//
//
//public class MiniParser {
//
//    public NestedInteger1 deserialize(String s) {
//        if (!s.startsWith("[")) {
//            return new NestedInteger1(Integer.valueOf(s));
//        }
//        Stack<NestedInteger1> stack = new Stack<>();
//        NestedInteger1 res = new NestedInteger1();
//        stack.push(res);
//        int start = 1;
//        for (int i = 1; i < s.length(); i ++) {
//            char c = s.charAt(i);
//            if (c == '[') {
//                NestedInteger1 ni = new NestedInteger1();
//                stack.peek().add(ni);
//                stack.push(ni);
//                start = i + 1;
//            } else if (c == ',' || c == ']') {
//                if (i > start) {
//                    Integer val = Integer.valueOf(s.substring(start, i));
//                    stack.peek().add(new NestedInteger1(val));
//                }
//                start = i + 1;
//                if (c == ']') {
//                    stack.pop();
//                }
//            } 
//        }
//        return res;
//    }
//    
//	public static void main(String[] args) {
//
//	}
//}