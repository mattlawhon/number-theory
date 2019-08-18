import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.io.*;

public class NumberTheoryExtraCredit {
    public static void main(String[] args) throws FileNotFoundException {

		int prime;
		int upperBound = 20000;
		Scanner s = new Scanner(new File("100000.txt"));
        ArrayList<Integer> primes = new ArrayList<Integer>();
        for (int i = 0; s.hasNext(); i++) {
            if (i < 16) {
                s.next();
                continue;
            }
			else {
				prime = s.nextInt();
				primes.add(prime);
				if (prime > upperBound)
					break;
			}
        }
		s.close();
		
		ArrayList<Integer> primesOfForm11 = new ArrayList<Integer>();//primes = x^2 + 11y^2
		primesOfForm11 = getPrimeNumbersOfForm(upperBound, primes);

		System.out.print("\n"+"Primes for which p = x^2 + 11*y^2: "+primesOfForm11);

		ArrayList<Integer> formsMod44 = new ArrayList<Integer>();//all possible mod 44 of any prime = x^2 + 11y^2
		for (Integer a : primesOfForm11) {
			if (!formsMod44.contains(a%44))
				formsMod44.add(a%44);
		}
		Collections.sort(formsMod44);
		System.out.println("\n\nMod 44 of the above primes: " +formsMod44);

		ArrayList<Integer> primesOfForm44 = new ArrayList<Integer>();//primes with proper mod 44
		for (Integer a : primes) {
			if (formsMod44.contains(a%44))
				primesOfForm44.add(a);
		}
		System.out.println("\n"+"All the primes of the proper mod 44: "+primesOfForm44);

		ArrayList<Integer> primesOfOnly44 = new ArrayList<Integer>();
		for (Integer a : primesOfForm44) {
			if (!primesOfForm11.contains(a))
				primesOfOnly44.add(a);
		}
		System.out.println("\n"+"Primes with the proper mod 44 that are not of the form p = x^2 + 11*y^2: "+primesOfOnly44+"\n");
//----------------------------------------------------------------------------------------------------------------------------//

		Boolean check = true;
		int k0 = 0;
		int k1 = 0;
		int k2 = 0;
		int k3 = 0;
		int k4 = 0;
		int k5 = 0;
		int k6 = 0;
		int k7 = 0;
		int k8 = 0;

		int upper7 = 5;
		int lower7 = 0;
		int upper6 = 5;
		int lower6 = 0;
		int upper5 = 5;
		int lower5 = 0;
		int upper4 = 5;
		int lower4 = 0;
		int upper3 = 5;
		int lower3 = 0;

		outerloop:
		for (int n8 = 1; n8 >= 0; n8--) {//System.out.println(".");
			if (n8 == 0) {
			upper7 = 1;
			lower7 = 0;
			}

			for (int n7 = upper7; n7 >= lower7; n7--) {//System.out.println("..");
				if (n7 == 0) {
				upper6 = 1;
				lower6 = 0;
				}

				for (int n6 = upper6; n6 >= lower6; n6--) {//System.out.println("...");
					if (n6 == 0) {
						upper5 = 1;
						lower5 = 0;
					}

					for (int n5 = upper5; n5 >= lower5; n5--) {
						if (n5 == 0) {
							upper4 = 1;
							lower4 = 0;
						}

						for (int n4 = upper4; n4 >= lower4; n4--) {
							if (n4 == 0) {
								upper3 = 1;
								lower3 = 0;
							}

							for (int n3 = upper3; n3 >= lower3; n3--) {
								for (int n2 = 0; n2 <= 10; n2++) {
									for (int n1 = 0; n1 <= 10; n1++) {
										for (int n0 = 0; n0 <= 10 ; n0++) {
											check = true;

											for (Integer p : primesOfForm11) {
												//System.out.println(n0 + " "+ n1+ " "+ n2+ " "+ n3+ " "+ n4+ " "+ n5+ " "+ n6 + " "+ n7+ " "+ n8 + ", p ="+ p +polynomialCaseTester(n0, n1, n2, n3, n4, n5, n6, n7, n8, p, true));
												if (!polynomialCaseTester(n0, n1, n2, n3, n4, n5, n6, n7, n8, p)) {
													check = false;
													break;
												}
											}
											
											if (check) {
												for (Integer q : primesOfOnly44) {
													//System.out.println("n0 = " + n0 + ", n3 = "+ n4 + ", n8 =  "+ n8 +", q = "+ q +polynomialCaseTester(n0, n1, n2, n3, n4, n5, n6, n7, n8, q, true));
													if (polynomialCaseTester(n0, n1, n2, n3, n4, n5, n6, n7, n8, q)) {
														check = false;
														break;
													}
												}
											}

											if (check) {
												k0 = n0;
												k1 = n1;
												k2 = n2;
												k3 = n3;
												k4 = n4;
												k5 = n5;
												k6 = n6;
												k7 = n7;
												k8 = n8;
												System.out.println("We got one: k0 = " + k0 + ", k1 = " + k1+ ", k2 = " + k2 + ", k3 = " + k3 + ", k4 = " + k4+ ", k5 = " + k5+ ", k6 = " + k6 + ", k7 = " + k7 + ", k8 = " + k8);
												//break outerloop;
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
		/*
		if (check)
			System.out.println("We got one: k0 = " + k0 + ", k1 = " + k1+ ", k2 = " + k2 + ", k3 = " + k3
					+ ", k4 = " + k4+ ", k5 = " + k5+ ", k6 = " + k6 + ", k7 = " + k7 + ", k8 = " + k8);
		else
			System.out.println("We did not get one: k = 0");
		*/
	}

	public static ArrayList<Integer> getPrimeNumbersOfForm(int number, ArrayList<Integer> primes) {
		ArrayList<Integer> primesOfForm = new ArrayList<Integer>();
		for (Integer prime: primes){
			if (isOfForm(prime))
				primesOfForm.add(prime);
		}
		return primesOfForm;
	}


	public static Boolean isOfForm(int n) {
		for(int i = 1; i < n; i++) {
			if (((long) 11*i*i) > n)
				break;
			for (int j = 1; j < n; j++) {
				if ((long) j*j + (long) 11*i*i == n) 
					return true;
				else if (((long) j*j + (long) 11*i*i) > n)
					break;
			}
		}
		return false;
	}

	public static Boolean polynomialCaseTester(int n0, int n1, int n2, int n3, int n4, int n5, int n6, int n7, int n8, int p) {
		for (int x = 0; x < p; x++) {

			if (((Math.pow(x, 8)*n8 + Math.pow(x, 7)*n7 + Math.pow(x, 6)*n6 + Math.pow(x, 5)*n5 
			+ Math.pow(x, 4)*n4 + Math.pow(x, 3)*n3 + Math.pow(x, 2)*n2 + x*n1 + n0) %p == 0) && 
			((n8 == 1) || (n8 == 0 && n7 == 1) || (n7 == 0 && n6 == 1) || (n6 == 0 && n5 == 1)
			|| (n5 == 0 && n4 == 1) || (n4 == 0 && n3 == 1) ||(n3 == 0 && n2 == 1) || (n2 == 0 && n1 == 1)))
				return true;
		}
		return false;
	}
}
/*
  	public static ArrayList<Integer> getPrimeNumbers(int number) {
		ArrayList<Integer> primeNumbers = new ArrayList<Integer>();
		Boolean val = true;

		primeNumbers.add(2);
		primeNumbers.add(3);
		primeNumbers.add(5);
		for (int i = 6; i <= number; i++) {
			for (Integer a : primeNumbers) {
				if(i % a == 0 || 2*a > i) {
					val = false;
					break;
				}
			}
			if (val) {
			primeNumbers.add(i);
			}
		}
		return primeNumbers;
  	}

	public static Boolean isPrime(int n) {
		for(int i = 2; i < n; i++) {
			if(n%i==0)
				return false;
		}
		return true;
	}
*/