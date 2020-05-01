package com.devChallenge.funnyStr;

import java.util.Base64;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ChallengeServices {
	private String funnyStr;
	public ChallengeServices(String funnyStr) {
		this.funnyStr = funnyStr;
	}

	public String decode() {
		Base64.Decoder decoder = Base64.getDecoder();
		String decodeStr = new String(decoder.decode(this.funnyStr));
		return decodeStr;
	}
	
	public String checkWord() throws Exception {
		String input = decode();
		Pattern pattern = Pattern.compile("[^A-Za-z\\s]");
		Matcher matcher = pattern.matcher(input);
		if(matcher.find()) {
			Exception e = new Exception("Error input is not English capital letter");
			throw(e) ;
		}
		return input.toLowerCase();
	}
	
	public String countSpace() {
		String input;
		String resultStr ="";
		int maxIndex = 0;
		int minIndex = 0;
		int sumSpace = 0;
		try {
			input = checkWord();
			char[] inputArr = input.toCharArray();
			char[] charResult = new char[inputArr.length];
			for(int i=0;i<inputArr.length;i++) {
				if(Character.isWhitespace(inputArr[i])) {
					if(maxIndex<=i) {
						maxIndex = i;
					}
					if(minIndex==0||minIndex>=i) {
						minIndex = i;
					}
				}else {
					if(minIndex>0 && maxIndex>0) {
						sumSpace = (maxIndex - minIndex)+1;
						maxIndex = 0;
						minIndex = 0;
					}
					if(sumSpace>0) {
						charResult[i-1] = String.valueOf(sumSpace).charAt(0);
						charResult[i] = inputArr[i];
						sumSpace = 0;
					}else {
						charResult[i] = inputArr[i];
					}
				}
			}
			resultStr = String.valueOf(charResult);
		} catch (Exception e) {
			e.printStackTrace();
		}
		resultStr = resultStr.replaceAll("\\s","");
		resultStr = resultStr.replaceAll("\\W","");
		return resultStr;
	}

	public String revertString() {
		String input = countSpace();
		char[] inputArr = input.toCharArray();
		char[] charResult = new char[inputArr.length];
		String resultStr = "";
		int newIndex = inputArr.length-1;
		for(int i=0;i<inputArr.length;i++) {
			charResult[newIndex] = inputArr[i];
			newIndex--;
		}
		resultStr = String.copyValueOf(charResult);
		return resultStr;
	}
	
	public String encode() {
		String input = revertString();
		String result = "";
		Base64.Encoder encoder = Base64.getEncoder();
		result = new String(encoder.encode(input.getBytes()));
		return result;
	}

	

}
