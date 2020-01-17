package sv.mh.fe.security;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.stereotype.Component;

@Component
public class Cryptographic {
	

	final static private String SHA256 = "SHA-256";
	
	public String encrypt(String p) throws NoSuchAlgorithmException {
		MessageDigest diget = MessageDigest.getInstance(SHA256);
		byte[] encodedhash = diget.digest(p.getBytes(StandardCharsets.UTF_8));
		return bytesToHex(encodedhash);
	}
	
	private static String bytesToHex(byte[] hash) {
		StringBuffer hexString = new StringBuffer();
		for (int i = 0; i < hash.length; i++) {
			String hex = Integer.toHexString(0xff & hash[i]);
			if(hex.length() == 1) hexString.append('0');
			hexString.append(hex);
		}
		return hexString.toString();
	}	
}
