//Time complexity O(log(n))
//Space complexity O(1)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
        int n1 = nums1.length;
        int n2 = nums2.length;
        
        if(n1 > n2){
            
          return  findMedianSortedArrays(nums2, nums1);
        }
        int left = 0;
        int right = n1;
        
        while(left <= right){
          
        int partX = left + (right - left) / 2;
        int partY = (n1 + n2) / 2 - partX;
        double l1 = partX == 0 ? Integer.MIN_VALUE : nums1[partX - 1];
        double r1 = partX == n1 ? Integer.MAX_VALUE : nums1[partX]; 
        double l2 = partY == 0 ? Integer.MIN_VALUE : nums2[partY - 1];
        double r2 = partY == n2 ? Integer.MAX_VALUE : nums2[partY]; 
                
            
            if(l1 <= r2 && l2 <= r1){
                
                //median found
                if((n1 + n2) % 2 == 0){//even
                    
                    return (Math.max(l1,l2) + Math.min(r1,r2))/2;
                }
                else {//odd
                    
                    return Math.min(r1,r2);
                }
            }
            
            else if(l2 > r1){
                
                left = partX + 1;
            }
            
            else {
                
                right =  partX - 1;
            }
            
        }
        
        return -1.00;
    }
}