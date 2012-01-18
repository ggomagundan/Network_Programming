package pumpsoft.ibm.data;

public class WritingData {
	private String articleId;
	private String user;
	private String nick;
	private String subject;
	private String date;
	private String good;
	private String bad;
	private String type;
	private String mName;

	public WritingData(String articleId, String user, String nick, String subject, String date, String good, String bad, String type, String mName) {
		this.articleId = articleId;
		this.user = user;
		this.nick = nick;
		this.subject = subject;
		this.date = date;
		this.good = good;
		this.bad = bad;
		this.type = type;
		this.mName = mName;
	}

	public String getAticleId() {
		return articleId;
	}

	public String getUser() {
		return user;
	}

	public String getNick() {
		return nick;
	}

	public String getSubject() {
		return subject;
	}

	public String getDate() {
		return date;
	}

	public String getGood() {
		return good;
	}

	public String getBad() {
		return bad;
	}

	public String getType() {
		return type;
	}

	public String getMname() {
		return mName;
	}

}
