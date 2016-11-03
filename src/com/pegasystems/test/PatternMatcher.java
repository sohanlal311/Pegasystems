package com.pegasystems.test;

public class PatternMatcher {

	public static void main(String[] args) {
		String searchStr = "BPM";
		System.out.println(getIndex(null, searchStr));
		System.out.println(getIndex(null, ""));
		System.out.println(getIndex("Pega has a BPM product", null));
		System.out.println(getIndex("Pega has a BPM product", ""));
		System.out.println(getIndex("Pega has a BPM product", searchStr));
		System.out.println(getIndex("BPM Pega has a BPM product", searchStr));
		System.out.println(getIndex("Pega has a product BPM", searchStr));
		System.out.println(getIndex("Pega has a BPMproduct", searchStr));
		System.out.println(getIndex("Pega has aBPM product", searchStr));
		System.out.println(getIndex(" BPM Pega has a product", searchStr));
		System.out.println(getIndex("BPMPega has a product", searchStr));
		System.out.println(getIndex("Pega has a product BPMs", searchStr));
		System.out.println(getIndex("Pega has a product BPM ", searchStr));
	}

	public static int getIndex(String input, String searchStr) {
		if (input == null || input.length() == 0 || searchStr == null || searchStr.length() == 0) {
			return -1;
		}

		int idx = -1, currIdx = 0;
		char[] charArray = input.toCharArray();
		for (int i = 0; i < charArray.length; i++) {
			if (charArray[i] == searchStr.charAt(currIdx)) {
				if (idx == -1) {
					if (i == 0 || charArray[i - 1] == ' ') {
						idx = i;
					} else {
						idx = -1;
						currIdx = 0;
					}
				}
				currIdx++;
				if (currIdx == searchStr.length()) {
					if (i == charArray.length - 1 || charArray[i + 1] == ' ') {
						break;
					} else {
						idx = -1;
						currIdx = 0;
					}
				}
			} else {
				idx = -1;
				currIdx = 0;
			}
		}
		return idx;
	}

}
