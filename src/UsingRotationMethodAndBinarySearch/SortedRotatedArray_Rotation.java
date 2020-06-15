package UsingRotationMethodAndBinarySearch;
import java.util.ArrayList;
import java.util.Scanner;

public class SortedRotatedArray_Rotation {

	public static void main(String[] args) {

		//		Read input array from console
		//		eg: Main list {7,9,11,0,3,5,6}
		//			search List {3,6,11,13} --> Expected result : {1 3 6 -1}

		Scanner scan = new Scanner(System.in);

		ArrayList<Integer> nums = new ArrayList<>();
		ArrayList<Integer> targets = new ArrayList<>();
		ArrayList<Integer> results = new ArrayList<>();

		for(String s: scan.nextLine().split(",")){
			nums.add(Integer.parseInt(s));
		}

		for(String s: scan.nextLine().split(",")){
			targets.add(Integer.parseInt(s));
		}

		results = getResults(nums, targets);
		for(int i: results) {
			System.out.print(i+ " ");
		}
	}


	public static ArrayList<Integer> getResults(ArrayList<Integer> nums, ArrayList<Integer> targets) {
		
		ArrayList<Integer> res = new ArrayList<>();
		
		int n =nums.size();

		//get the pivot index
		int pivot=getPivotIndex(nums, 0, n-1);

		//rotate array by pivot number of times
		if(pivot!=0) {
			nums = getRotatedArray(nums,pivot, n);
		}
		
		//get the current index of the targets
		for(int currTarget: targets) {
			res.add(getCurrentIndexUsingBS(nums, 0, n-1, currTarget));
		}
		
		return res;
	}


	private static int getPivotIndex(ArrayList<Integer> nums, int low, int high) {

		//if the array is not rotated, return '0' as the pivot index
		if(nums.get(0)<=nums.get(nums.size()-1)) {
			return 0;
		}

		int mid= low+(high-low)/2;

		if(mid <nums.size()-1 && nums.get(mid)>nums.get(mid+1)) {
			return mid+1;
		}
		else if(mid>0 && nums.get(mid-1)>nums.get(mid)) {
			return mid;
		}

		if(nums.get(low) > nums.get(mid)) {
			return getPivotIndex(nums, low, mid-1);
		}
		else {
			return getPivotIndex(nums, mid+1, high);
		}
	}

	private static ArrayList<Integer> getRotatedArray(ArrayList<Integer> nums, int pivot, int n) {

		reverse(nums,0, pivot-1);
		reverse(nums,pivot,n-1);
		reverse(nums,0,n-1);
		return nums;
	}

	private static ArrayList<Integer> reverse(ArrayList<Integer> nums, int left, int right) {

		while(left<right) {
			int temp=nums.get(left);
			nums.set(left, nums.get(right));
			nums.set(right, temp);
			left++;
			right--;
		}
		return nums;
	}

	private static int getCurrentIndexUsingBS(ArrayList<Integer> nums, int low, int high, int target) {

		if(low>high) {
			return -1;
		}

		int mid=low+(high-low)/2;

		if(nums.get(mid)==target) {
			return mid;
		}
		else if(nums.get(mid) >target) {
			return getCurrentIndexUsingBS(nums, low, mid-1, target);
		}
		else if(nums.get(mid) <target) {
			return getCurrentIndexUsingBS(nums, mid+1, high, target);
		}
		return -1;
	}



}
