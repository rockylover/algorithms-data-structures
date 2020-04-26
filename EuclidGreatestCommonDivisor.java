public class Main {
	/*
    * find greatest common divisor using euclid's algo
    */
	public static void main(String[] args) {
		// constraint here is: dividend >= divisor
		System.out.println(euclid_gcd(900, 27));
	}

	public static int euclid_gcd(int dividend, int divisor) {
		// if divisor completely divides dividend
		// then remainder = 0
		// if that's the case, then divisor is the gcd
		int remainder = dividend % divisor;
		if (remainder == 0) {
			// return divisor, in case remainder is 0
			return divisor;
		}
		// else recursively call the method with divisor as dividend
		// and remainder as divisor
		return euclid_gcd(divisor, remainder);
	}
}
