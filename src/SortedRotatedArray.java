import java.util.Scanner;

public class SortedRotatedArray {

	public static void main(String[] args) {
		
//		Read input array from console
//		eg: [7,9,11,0,3,5,6]
//		search set [3,6,11,13] --> 1 3 6 -1
		
		Scanner scan = new Scanner(System.in);
		
		String[] mainString = scan.nextLine().split(",");
		String[] searchString = scan.nextLine().split(",");
	
		int[] nums= new int[mainString.length];
		int[] targets= new int[searchString.length];
		
		//populate the input in to arrays
		for(int i=0; i<mainString.length;i++) {
			nums[i]=Integer.parseInt(mainString[i]);
		}
		
		for(int i=0; i<searchString.length;i++) {
			targets[i]=Integer.parseInt(searchString[i]);
		}
		
		int n =nums.length;
		
		//get the pivot index
		int pivot=getPivotIndex(nums, 0, n-1);
		
		//print the result
		for(int currTarget: targets) {
			System.out.print(getOriginalIndex(nums, currTarget, pivot, n) +" ");
		}
	}

	public static int getOriginalIndex(int[] nums, int target, int pivot, int n) {
		
		int currIndex=-1;
			
		//array is sorted, so original index is same as the current index
		if(pivot==0) {
			if(n==1) {
				return (nums[0]==target)? 0:-1;
			}
			return getCurrentIndexUsingBS(nums, 0, n-1, target);
		}
		else {
			if(nums[pivot]==target) {
				currIndex= pivot;
			}
			else if(nums[0] <= target && target<=nums[pivot-1]) {
				currIndex= getCurrentIndexUsingBS(nums, 0, pivot-1, target);
			}
			else if(nums[pivot+1]<=target && target <=nums[n-1]) {
				currIndex=  getCurrentIndexUsingBS(nums, pivot+1, n-1, target);
			}
		}
		
		//if element not found, return -1
		if(currIndex==-1) {
			return -1;
		}
		else if(currIndex>=pivot) {
			return currIndex-pivot;
		}
		else {
			return n-pivot+currIndex;
		}
	}


	public static int getPivotIndex(int[] nums, int low, int high) {
		
		//if the array is not rotated, return '0' as the pivot index
		if(nums[0]<=nums[nums.length-1]) {
			return 0;
		}
		
		int mid= low+(high-low)/2;
		
		if(mid <nums.length-1 && nums[mid]>nums[mid+1]) {
			return mid+1;
		}
		else if(mid>0 && nums[mid-1]>nums[mid]) {
			return mid;
		}
		
		if(nums[low] > nums[mid]) {
			return getPivotIndex(nums, low, mid-1);
		}
		else {
			return getPivotIndex(nums, mid+1, high);
		}
	}

	private static int getCurrentIndexUsingBS(int[] nums, int low, int high, int target) {
		
		int mid=low+(high-low)/2;
		
		if(nums[mid]==target) {
			return mid;
		}
		else if(nums[low] <=target && target<nums[mid]) {
			return getCurrentIndexUsingBS(nums, low, mid-1, target);
		}
		else if(nums[mid]<target && target<=nums[high]) {
			return getCurrentIndexUsingBS(nums, mid+1, high, target);
		}
		
		return -1;
	}

}
