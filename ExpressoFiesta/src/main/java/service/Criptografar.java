package service;

import java.math.BigInteger;
import java.security.MessageDigest;

public class Criptografar {
	
	public static String criptografar(String pw) {
		
		String retorno = "";
		MessageDigest md;
		try {
			md = MessageDigest.getInstance("MD5");
			BigInteger hash = new BigInteger(1,md.digest(pw.getBytes()));
			retorno = hash.toString(16);
		} catch (Exception e) {
			System.out.println("Erro ao criptografar!");
		}
		
		
		
		
		return retorno;
	}
}
