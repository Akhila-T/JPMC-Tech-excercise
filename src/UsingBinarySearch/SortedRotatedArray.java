package UsingBinarySearch;
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
		int[] results=new int[targets.length];
		
		//populate the input in to arrays
		for(int i=0; i<mainString.length;i++) {
			nums[i]=Integer.parseInt(mainString[i]);
		}
		
		for(int i=0; i<searchString.length;i++) {
			targets[i]=Integer.parseInt(searchString[i]);
		}
		
		results= getOriginalIndices(nums, targets);
		for(int i: results){
			System.out.print(i+ " ");
		}
	}

	public static int[] getOriginalIndices(int[] nums, int[] targets) {
		
		int[] res= new int[targets.length];
		
		int n =nums.length;
		
		//get the pivot index
		int pivot=getPivotIndex(nums, 0, n-1);
		
		for(int i=0; i<targets.length; i++) {
			//get the current index for each target element
			int currIndex = getCurrentIndexOfTarget(nums, targets[i], pivot, n);
		
			//if element not found, return -1
			if(currIndex==-1) {
				res[i]=-1;
			}
			else if(currIndex>=pivot) {
				res[i]= currIndex-pivot;
			}
			else {
				res[i] = n-pivot+currIndex;
			}
		}
		
		return res;
	}

	private static int getCurrentIndexOfTarget(int[] nums, int target, int pivot, int n) {
		
		//array is sorted, so original index is same as the current index
		if(pivot==0) {
			if(n==1) {
				return (nums[0]==target)? 0:-1;
			}
			return getIndexUsingBinarySearch(nums, 0, n-1, target);
		}
		else {
			if(nums[pivot]==target) {
				return pivot;
			}
			else if(nums[0] <= target && target<=nums[pivot-1]) {
				return getIndexUsingBinarySearch(nums, 0, pivot-1, target);
			}
			else if(nums[pivot+1]<=target && target <=nums[n-1]) {
				return getIndexUsingBinarySearch(nums, pivot+1, n-1, target);
			}
		}
		
		return -1;
	}


	private static int getPivotIndex(int[] nums, int low, int high) {
		
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

	//get the index of an element using binary search
	private static int getIndexUsingBinarySearch(int[] nums, int low, int high, int target) {
		
		if(low>high) {
			return -1;
		}
		
		int mid=low+(high-low)/2;
		
		if(nums[mid]==target) {
			return mid;
		}
		else if(nums[mid] >target) {
			return getIndexUsingBinarySearch(nums, low, mid-1, target);
		}
		else if(nums[mid] <target) {
			return getIndexUsingBinarySearch(nums, mid+1, high, target);
		}
		return -1;
	}

}
