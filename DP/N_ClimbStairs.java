package DP;

public class N_ClimbStairs {

	public static void main(String[] args) {
		int s = 4, m = 2;
		System.out.println("Nuber of ways = " + countWays(s, m));
	}

	public static int countWays(int s, int m) {
		return func(s + 1, m);
	}

	public static int func(int s, int m) {

		int[] dp = new int[s];

		dp[0] = 1;
		dp[1] = 1;

		for (int i = 2; i < s; i++) {

			dp[i] = 0;
			for (int j = 1; j <= m && j <= i; j++) {
				dp[i] += dp[i - j];
			}
		}

		return dp[s - 1];
	}

	public static int ans(int n) {
		if (n <= 0)
			return 0;
		if (n == 1)
			return 1;
		if (n == 2)
			return 2;

		int n1 = 2;
		int n2 = 1;
		int ans = 0;

		for (int i = 2; i < n; i++) {
			ans = n1 + n2;
			n2 = n1;
			n1 = ans;
		}
		return ans;
	}

}
