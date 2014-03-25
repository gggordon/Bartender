package com.caribresort.classes;

public interface Roleable {
	
	/**
	 * @param username - string
	 * @param password - string
	 * <h4>Login</h4>
	 * <p>When implemented should assign respective role and direct <br />
	 *    user to respective section of application or other initial <br />
	 *    functions depending on access control method utilized and <br />
	 *    objects being secured</p>
	 * */
    boolean Login(String username,String password);
}
