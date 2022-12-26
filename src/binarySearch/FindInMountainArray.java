//package binarySearch;
//
//public class FindInMountainArray {
//
	/**
	 * // This is MountainArray's API interface.
	 * // You should not implement it, or speculate about its implementation
	 * interface MountainArray {
	 *     public int get(int index) {}
	 *     public int length() {}
	 * }
	 */
	 
//	class Solution {
//	    public int findInMountainArray(int target, MountainArray mountainArr) {
//	        int peakIndex = findPeak(mountainArr);
//	        int ans1= bs(mountainArr,target,0,peakIndex);
//	        int ans2 = bs2(mountainArr,target,peakIndex+1,mountainArr.length()-1);
//	        int ans = (ans1!=-1)?ans1:ans2;
//	        return ans;
//	    }
//	    private int findPeak(MountainArray arr){
//	        int  start =0,end = arr.length()-1,mid=0;
//	        while(start<=end){
//	            mid = start+(end-start)/2;
//	            if(mid<arr.length()-1 && arr.get(mid)<arr.get(mid+1)){
//	                start = mid+1;
//	            }else{
//	                end = mid-1;
//	            }
//	        }
//	        return start;
//	    }
//	    private int bs(MountainArray arr, int target, int low, int high){
//	        int mid = 0,start = low,end = high;
//	        while(start<=end){
//	            mid = start+(end-start)/2;
//	            if(arr.get(mid) == target){
//	                return mid;
//	            }else if(arr.get(mid)<target){
//	                start = mid+1;
//	            }else{
//	                end = mid-1;
//	            }
//	        }
//	        return -1;
//	    }
//	    private int bs2(MountainArray arr, int target, int low, int high){
//	        int mid = 0,start = low,end = high;
//	        while(start<=end){
//	            mid = start+(end-start)/2;
//	            if(arr.get(mid) == target){
//	                return mid;
//	            }else if(arr.get(mid)>target){
//	                start = mid+1;
//	            }else{
//	                end = mid-1;
//	            }
//	        }
//	        return -1;
//	    }
//
//	}
//
//}
