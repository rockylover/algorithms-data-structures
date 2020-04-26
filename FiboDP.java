public class Main {
	public static void main(String[] args) {
		int n = 45;
		System.out.println(fibo(n));
		int[] helper = new int[n];
		System.out.println(fiboDP(n, helper));
	}

	// worst case time complexity O(n^2)
	// space complexity -> O(n) -> n extra space
	public static int fiboDP(int n, int[] helper) {
		if (n == 0) {
			helper[n] = 0;
			return helper[n];
		} else if (n == 1) {
			helper[n] = 1;
			return helper[n];
		}
		int nMinus1Term = 0;
		if (helper[n - 1] > 0) {
			nMinus1Term = helper[n - 1];
		} else {
			nMinus1Term = fiboDP(n - 1, helper);
			helper[n - 1] = nMinus1Term;
		}
		int nMinus2Term = 0;
		if (helper[n - 2] > 0) {
			nMinus2Term = helper[n - 2];
		} else {
			nMinus2Term = fiboDP(n - 2, helper);
			helper[n - 2] = nMinus2Term;
		}
		return nMinus1Term + nMinus2Term;
	}

	// time complexity O(2^n)
	// space complexity -> no extra space
	public static int fibo(int n) {
		if (n == 0) {
			return 0;
		} else if (n == 1) {
			return 1;
		}
		return fibo(n - 1) + fibo(n - 2);
	}
}
