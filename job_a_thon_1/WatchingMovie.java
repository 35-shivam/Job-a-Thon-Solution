/*
N people are standing in a row. A list heights[] of N positive integers is given to you, where the i-th integer represents the height of i-th person.
There is a movie screen at the rightmost position of the row. 
The i-th person will be able to see the movie screen only if K persons, directly to the right side of the i-th person, 
have a height lesser than the height of i-th person. If there are less than K people to the right of the i-th person, 
then the height of all of them must be lesser than that of the i-th person.  

You need to count the number of people who will be able to watch the movie.

Example 1:

Input:
N = 5
K = 1
heights[] = {4, 3, 1, 2, 5}
Output: 
3
Explanation: 
The 1st ,2nd and 5-th person will be able to 
watch the movie,while the 3rd person can’t because 
of the 4th person whose height is greater than the
3rd person. 


*/
package job_a_thon_1;

import java.util.Collections;
import java.util.PriorityQueue;

class WatchingMovie {
    int solve(int N, int K, int heights[]) 
    { 
        // code here
        int ans = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int pos = N-1;
        for(int i = N-1;i >= 0;i--){
            if(pq.size() == 0){
                ans++;
            }else if(pq.peek() < heights[i]){
                ans++;
            }
            pq.add(heights[i]);
            if(pq.size() > K){
                pq.remove(heights[pos--]);
            }
        }
        return ans;
    }
}
