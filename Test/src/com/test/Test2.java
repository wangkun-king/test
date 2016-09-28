package com.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Test2 {

	// public Test2() {
	// this.inputArr = new ArrayList<Integer>();
	// }
	public static void main(String[] args) {
		Test2 t2 = new Test2();
		List<Integer> inputArr = new ArrayList<Integer>();
		List<Integer> countArr = new ArrayList<Integer>();
		Scanner scan = new Scanner(System.in);
		String line = scan.nextLine();
		String[] split = line.split(" ");
		int money = Integer.parseInt(split[split.length - 1]);
		for (int i = 0; i < split.length - 1; i++) {
			inputArr.add(Integer.parseInt(split[i]));
			countArr.add(0);
		}
		Collections.sort(inputArr);
		Collections.reverse(inputArr);
		scan.close();
		for (Integer number : inputArr) {
			System.out.println(number);
		}
		t2.fun(money, 0, inputArr, countArr, 0, 0);
		System.out.println();
		t2.fun(money, 0, inputArr, countArr, 1, 0);
			
	}

	public void fun(int money, int current, List<Integer> inputArr, List<Integer> countArr, int index, int count) {
		if (index >= inputArr.size()) {
			int MinIndex = countArr.size() - 1;
			countArr.set(MinIndex, 0);
			int secondMin = 0;
			for (int i = 1; i <= MinIndex; i++) {
				int count1 = countArr.get(MinIndex - i);
				if (count1 != 0) {
					secondMin = MinIndex - i;
					count1--;
					countArr.set(secondMin, count1);
					break;
				}
				secondMin = MinIndex;
			}
			int nowCurrent = 0;
			for (int i = 0; i < inputArr.size(); i++) {
				nowCurrent = nowCurrent + inputArr.get(i) * countArr.get(i);
			}
			if (secondMin != MinIndex) {
				fun(money, nowCurrent, inputArr, countArr, ++secondMin, 0);
			}else{
				System.out.println(-1);
			}
		} else {

			 System.out.print(current+"\t"+"+"+"\t"+inputArr.get(index)+"\t");
//			 System.out.println(countArr.get(index));
			current += inputArr.get(index);
			count++;
			System.out.print(current-money>0?">":"<");
			System.out.print(money+"\tcount["+index+"]:");
			if (current == money) {
				countArr.set(index, count);
				System.out.println(countArr.get(index));
				int sumCount = 0;
				for (Integer integer : countArr) {
					System.out.println(integer);
					sumCount += integer;
				}
				System.out.println(sumCount);
			} else if (current < money) {
				countArr.set(index, count);
				System.out.println(countArr.get(index));
				fun(money, current, inputArr, countArr, index, count);
			} else {
				count--;
				countArr.set(index, count);
				System.out.println(countArr.get(index));
				count = 0;
				current -= inputArr.get(index);
				fun(money, current, inputArr, countArr, ++index, count);
			}
		}
		
	}
}
