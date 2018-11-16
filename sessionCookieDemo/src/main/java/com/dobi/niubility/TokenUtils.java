
package com.dobi.niubility;

import java.util.UUID;

public class TokenUtils {

	static public String getToken() {
		return UUID.randomUUID().toString();
	}

	public static void main(String[] args) {
		System.out.println(TokenUtils.getToken());
	}

}
