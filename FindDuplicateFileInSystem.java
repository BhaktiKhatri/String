package String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Leetcode 609. Find Duplicate File in System
 * https://leetcode.com/problems/find-duplicate-file-in-system/description/
 * Given a list of directory info including directory path, and all the files with contents in this directory, you need to find out all the groups of duplicate files in the file system in terms of their paths.
 * A group of duplicate files consists of at least two files that have exactly the same content. A single directory info string in the input list has the following format:
 * "root/d1/d2/.../dm f1.txt(f1_content) f2.txt(f2_content) ... fn.txt(fn_content)" It means there are n files (f1.txt, f2.txt ... fn.txt with content f1_content, f2_content ... fn_content, respectively) in directory root/d1/d2/.../dm. 
 * Note that n >= 1 and m >= 0. If m = 0, it means the directory is just the root directory.
 * The output is a list of group of duplicate file paths. For each group, it contains all the file paths of the files that have the same content.
 * A file path is a string that has the following format: "directory_path/file_name.txt"
 * Input: ["root/a 1.txt(abcd) 2.txt(efgh)", "root/c 3.txt(abcd)", "root/c/d 4.txt(efgh)", "root 4.txt(efgh)"] 
 * Output: [["root/a/2.txt","root/c/d/4.txt","root/4.txt"],["root/a/1.txt","root/c/3.txt"]]
 * Note: No order is required for the final output. You may assume the directory name, file name and file content only has letters and digits, and the length of file content is in the range of [1,50].
 * The number of files given is in the range of [1,20000]. You may assume no files or directories share the same name in the same directory.
 * You may assume each given directory info represents a unique directory. Directory path and file info are separated by a single blank space.
 * Explanation and Code from: Approach #2 Using HashMap https://leetcode.com/articles/find-duplicate/
 * Time complexity : O(n*x), n strings of average length x is parsed
 * Space complexity : O(n*x), map and res size grows up to n*x
 * Medium
 * Dropbox
 */

public class FindDuplicateFileInSystem {

	/*
	 	In this approach, firstly we obtain the directory paths, the file names and their contents separately by appropriately splitting each string 
	 	in the given paths list. In order to find the files with duplicate contents, we make use of a HashMap map, which stores the data in the form 
	 	(contents,list_of_file_paths_with_this_content). Thus, for every file's contents, we check if the same content already exist in the hashmap.
	 	If so, we add the current file's path to the list of files corresponding to the current contents. Otherwise, we create a new entry in the map, 
	 	with the current contents as the key and the value being a list with only one entry(the current file's path).
	 	At the end, we find out the contents corresponding to which at least two file paths exist. We obtain the resultant list res,
	 	which is a list of lists containing these file paths corresponding to the same contents.
	 */
	public static List<List<String>> findDuplicate(String[] paths) {
        HashMap<String, List<String>> map = new HashMap<String, List<String>>();
        
        System.out.println("paths: "+Arrays.toString(paths));
        
        for(String path: paths) {
            System.out.println("path: "+path);
            
            String[] values = path.split(" ");
            System.out.println("values: "+Arrays.toString(values));
            
            for(int i=1; i<values.length; i++) {
                System.out.println("values[i]: "+values[i]);
            	
            	String[] name_cont = values[i].split("\\(");
            	System.out.println("name_cont: "+Arrays.toString(name_cont));
            	
                name_cont[1] = name_cont[1].replace(")", "");
                System.out.println("name_cont[1]: "+name_cont[1]);
                
                List<String> list = map.getOrDefault(name_cont[1], new ArrayList<String>());
                System.out.println("list: "+list+" values[0]: "+values[0]+" name_cont[0]: "+name_cont[0]);
                
                list.add(values[0] +"/"+ name_cont[0]);
                System.out.println("list: "+list+" name_cont[1]: "+name_cont[1]);
                
                map.put(name_cont[1], list);
                System.out.println("map: "+map);
            }
        }
        System.out.println("map: "+map);
        
        List<List<String>> res = new ArrayList<List<String>>();
        for(String key: map.keySet()) {
        	System.out.println("key: "+key+" map.get(key): "+map.get(key));
            
        	if(map.get(key).size() > 1) {
                res.add(map.get(key));
        	}
        }
        System.out.println("res: "+res);
        
        return res;
    }
	
	public static void main(String[] args) {
		String[] paths = {"root/a 1.txt(abcd) 2.txt(efgh)", "root/c 3.txt(abcd)", "root/c/d 4.txt(efgh)", "root 4.txt(efgh)"};
		System.out.println(findDuplicate(paths));
	}

}
