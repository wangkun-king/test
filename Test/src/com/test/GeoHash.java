package com.test;

import java.util.Scanner;


public class GeoHash {

	private final String base32Chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ234567";

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while(true){
			System.out.print("输入纬度：");
			System.out.println();
			int latitude = scan.nextInt();
			System.out.print("输入经度：");
			System.out.println();
			int longitude = scan.nextInt();
			GeoHash gh = new GeoHash();
			gh.getGeoHash(latitude,longitude);
			System.out.println("是否继续？（y/n)");
			String flag = scan.next();
			if(flag.equalsIgnoreCase("n")){
				scan.close();
				System.exit(0);
			}
		}
	}

	public void getGeoHash(int latitude,int longitude) {
		int[] latitudeArr = new int[181];
		int[] longitudeArr = new int[361];
		int m = 0;
		for (int i = -90; i <= 90; i++) {
			latitudeArr[m] = i;
			m++;
		}
		m = 0;
		for (int i = -180; i <= 180; i++) {
			longitudeArr[m] = i;
			m++;
		}
		
		byte[] latitudeByteArr = getBinaryCode(latitude, latitudeArr);
		byte[] longitudeByteArr = getBinaryCode(longitude, longitudeArr);
		
		for (byte b : latitudeByteArr) {
			System.out.print(b);
		}
		System.out.println();
		for (byte b : longitudeByteArr) {
			System.out.print(b);
		}
		System.out.println();
		String latitudeString = encode(latitudeByteArr);
		String longitudeString = encode(longitudeByteArr);
		System.out.println(latitudeString);
		System.out.println(longitudeString);
	}

	public byte[] getBinaryCode(int key, int[] arr) {
		// List<Byte> byteArr = new ArrayList<Byte>();
		int start = 0;
		int end = arr.length - 1;
		int length = 0;
		if (end > 180) {
			length = 7;
		} else {
			length = 6;
		}
		byte[] byteArr = new byte[length];

		int i = 0;
		while ((arr[end] - arr[start]) > 3) {
			int middle = (start + end) / 2;
			if (key < arr[middle]) {
				end = middle - 1;
				byteArr[i] = 0;
				// byteArr.add('0');
				i++;
			} else if (key > arr[middle]) {
				start = middle + 1;
				byteArr[i] = 1;
				i++;
			} else {
				byteArr[i] = 1;
				return byteArr;
			}
		}
		return byteArr;
	}

	public String encode(byte[] bytes) {
		int i = 0, index = 0, digit = 0;
		int currByte, nextByte;
		StringBuffer base32 = new StringBuffer((bytes.length + 7) * 8 / 5);
		while (i < bytes.length) {
			currByte = (bytes[i] >= 0) ? bytes[i] : (bytes[i] + 256); // unsign
			/* Is the current digit going to span a byte boundary? */
			if (index > 3) {
				if ((i + 1) < bytes.length) {
					nextByte = (bytes[i + 1] >= 0) ? bytes[i + 1] : (bytes[i + 1] + 256);
				} else {
					nextByte = 0;
				}
				digit = currByte & (0xFF >> index);
				index = (index + 5) % 8;
				digit <<= index;
				digit |= nextByte >> (8 - index);
				i++;
			} else {
				digit = (currByte >> (8 - (index + 5))) & 0x1F;
				index = (index + 5) % 8;
				if (index == 0)
					i++;
			}
			base32.append(base32Chars.charAt(digit));
		}
		return base32.toString();
	}
}
