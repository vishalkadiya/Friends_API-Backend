package com.friends.utils;

import java.util.Random;

public class RandomStringGenerator {

public static String generateToken() throws Exception {
		
		String randomNumber = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder stringBuilder = new StringBuilder();
        Random random = new Random();
    	while (stringBuilder.length() < 11) { 
    		int index = (int) (random.nextFloat() * randomNumber.length());
			stringBuilder.append(randomNumber.charAt(index));
    	}
    	return stringBuilder.toString();
}
}
