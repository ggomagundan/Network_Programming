package pumpsoft.ibm.net;

public class LoginConstant {
	private static String id = "";
	private static String pw = "";

	public static String getId() {
		return id;
	}

	public static void setId(String id) {
		LoginConstant.id = "";
		LoginConstant.id = LoginConstant.id + id;
	}

	public static String getPw() {
		return pw;
	}

	public static void setPw(String pw) {
		LoginConstant.pw = "";
		LoginConstant.pw = LoginConstant.pw + pw;
	}

}
