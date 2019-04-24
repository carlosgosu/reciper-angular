package es.cjolalla.catalogingredients.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoderUtil {

	public static void main(String[] args) {
	      BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
	      String encoded = encoder.encode("admin");//bob's password
	      System.out.println(encoded);
	      encoded = encoder.encode("carlosgosu");//sara's password
	      System.out.println(encoded);
	      encoded = encoder.encode("guest");//sara's password
	      System.out.println(encoded);
	  }
}
