package String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Leetcode 68. Text Justification
 * https://leetcode.com/problems/text-justification/description/
 * Given an array of words and a length L, format the text such that each line has exactly L characters and is fully (left and right) justified
 * You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces ' ' when necessary so that each line has exactly L characters
 * Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line do not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right
 * For the last line of text, it should be left justified and no extra space is inserted between words
 * For example, words: ["This", "is", "an", "example", "of", "text", "justification."], L: 16
 * Return the formatted lines as:
 *	[
 *	   "This    is    an",
 *	   "example  of text",
 *	   "justification.  "
 *	]
 * Note: Each word is guaranteed not to exceed L in length
 * Corner Cases: A line other than the last line might contain only one word. What should you do in this case? In this case, that line should be left-justified.
 * Explanation and Code from: @zhugejunwei https://leetcode.com/problems/text-justification/discuss/24873
 * @author NisuBhakti
 * Facebook, LinkedIn, Airbnb
 */

public class TextJustification {

	public static List<String> fullJustify(String[] words, int maxWidth) {
		System.out.println("words: "+Arrays.toString(words)+" maxWidth: "+maxWidth);
		
		List<String> result = new ArrayList<String>();
        
		if(words.length == 0 || maxWidth <= 0) {
            result.add(""); 												//for some reason OJ expects list with empty string for empty array input
            return result;
        }
		
		// i: the index of word 
        // w: the current index of words in the line
        // len: current total len of words in the line

        for(int i = 0, w; i < words.length; i = w) {
            int len = -1; 																	//We need to skip the space for last word hence start len = -1
            	
            for(w = i; w < words.length && len + words[w].length() + 1 <= maxWidth; w++) {	//check how many words fit into the line
                len = len + words[w].length() + 1; 												// 1 extra for the space
            }
        
            //calculate the number of extra spaces that can be equally distributed
            //also calculate number of extra spaces that need to be added to first few
            //words till we fill the line width
            //For example line width is 20 we have three words of 3 4 2 4 length
            //[our_,life_,is_,good_,_,_,_,_,] ==> [our_,_,_,life_,_,_is_,_,good] 
            //   Note _, indicates space
            //Count number of empty spaces at end of line:= width-len = 20-(15) = 5 
            //These five spaces need to be equally distributed between 4-1 = 3 gaps
            //n words will have n-1 gaps between them
            // 5 / 3 = 1 extra space between each word (in addition to default 1 space, 
            //                                          total space count = 2)
            // 5 % 3 = 2 extra spaces between first three words as shown above

            int evenlyDistributedSpaces = 1; //If we don't enter loop at line # 37 then we need to have default value
            int extraSpaces = 0;
            int numOfGapsBwWords = w-i-1; //w is already pointing to next index and -1 since
                                          //n words have n-1 gaps between them
                                          
            //Moreover we don't need to do this computation if we reached the last word
            //of array or there is only one word that can be accommodate on the line
            //then we don't need to do any justify text. In both cases text can be left,
            //left-aligned 
                                        
            if(w != i+1 && w != words.length) {
                //additional 1 for the default one space between words
                evenlyDistributedSpaces = ((maxWidth-len) / numOfGapsBwWords) + 1;
                extraSpaces = (maxWidth-len) % numOfGapsBwWords;
            }
    
            StringBuilder sb = new StringBuilder(words[i]);
            
            // not 1 char, including last line, initialize space == 1 is to deal with last line case
            for(int j = i+1; j < w; j++) {								// j: index of word in the current line
                for(int s = 0; s < evenlyDistributedSpaces; s++) {
                    sb.append(' ');										// add the "even" space
                }
                if(extraSpaces > 0) {
                    sb.append(' ');
                    extraSpaces--;
                }
                sb.append(words[j]);
            }
            
            //Handle the above two cases we skipped, where there is only one word on line
            //or we reached end of word array. Last line should remain left aligned.
            int remaining = maxWidth-sb.length();						// if it's the last line
            while(remaining > 0) {
                sb.append(' ');
                remaining--;
            }
            result.add(sb.toString());
        }
        return result;
    }
	
	public static void main(String[] args) {
		String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
		int maxWidth = 16;
		System.out.println(fullJustify(words, maxWidth));
	}

}
