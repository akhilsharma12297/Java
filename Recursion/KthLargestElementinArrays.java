package Recursion;

import java.util.Random;

public class KthLargestElementinArrays {
	int nums[];
	Random rand = new Random();

	public int findKthLargest(int[] nums, int k) {
		this.nums = nums;
		return quickSelect(0, nums.length - 1, nums.length - k);
	}

	int quickSelect(int left, int right, int k) {
		while (true) {
			if (left >= right)
				return nums[left];

			int partIdx = left + rand.nextInt(right - left);

			partIdx = partition(left, right, partIdx);
			if (k == partIdx) {
				break;
			} else if (k < partIdx) {
				right = partIdx - 1;
			} else {
				left = partIdx + 1;
			}
		}
		return nums[k];
	}

	int partition(int l, int r, int pivotIdx) {
		int pivotVal = nums[pivotIdx];
		swap(pivotIdx, r);

		int saveIdx = l;
		for (int i = l; i < r; i++) {
			if (nums[i] < pivotVal) {
				swap(saveIdx++, i);
			}
		}
		swap(saveIdx, r);
		return saveIdx;
	}

	void swap(int i, int j) {
		int t = nums[i];
		nums[i] = nums[j];
		nums[j] = t;
	}

	public static void main(String[] args) {
		int arr[] = { 7, 10, 4, 3, 20, 15 };
		int k = 3;

		KthLargestElementinArrays kt = new KthLargestElementinArrays();

		System.out.println(kt.findKthLargest(arr, k));
	}

}