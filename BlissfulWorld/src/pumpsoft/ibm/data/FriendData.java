package pumpsoft.ibm.data;

public class FriendData {
	private String friendId;
	private String friendNick;
	private String friendPoint;
	private String friendDonationCount;

	public FriendData(String friendId, String friendNick, String friendPoint, String friendDonationCount) {
		this.friendId = friendId;
		this.friendNick = friendNick;
		this.friendPoint = friendPoint;
		this.friendDonationCount = friendDonationCount;
	}

	public String getFriendId() {
		return friendId;
	}

	public String getFriendNick() {
		return friendNick;
	}

	public String getFriendPoint() {
		return friendPoint;
	}

	public String getFriendDonationCount() {
		return friendDonationCount;
	}

}
