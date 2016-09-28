package com.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Prime {
	List<Integer> primeArr;

	public Prime() {
		super();
		this.primeArr = new ArrayList<Integer>();
	}

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		int count = 0;
		Prime p = new Prime();
		p.getPrimeArr();
		System.out.println("输入：");
		Scanner scan = new Scanner(System.in);
		int input = scan.nextInt();
		count = getPrimeCount(count, p, input);
		System.out.println(count);

	}

	private static int getPrimeCount(int count, Prime p, int input) {
		for (int i = 0; i < p.primeArr.size(); i++) {
			for (int j = 0; j < p.primeArr.size(); j++) {
				int m = p.primeArr.get(i) + p.primeArr.get(j);
				if (input == m) {
					System.out.print(p.primeArr.get(i));
					System.out.print("  ");
					System.out.println(p.primeArr.get(j));
					count++;
				}
			}
		}
		if (p.isPrime(input / 2)) {
			count = count / 2 + 1;
		} else {
			count = count / 2;
		}
		return count;
	}

	public void getPrimeArr() {
		primeArr.add(2);
		for (int i = 3; i < 1000; i++) {
			if (isPrime(i)) {
				primeArr.add(i);
			}
		}
	}

	public boolean isPrime(int n) {
		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;

	}
}
