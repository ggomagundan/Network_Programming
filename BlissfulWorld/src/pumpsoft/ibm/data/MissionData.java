package pumpsoft.ibm.data;

public class MissionData {
	private String id;
	private String name;
	private String point;
	private String url;

	public MissionData(String id, String name, String point, String url) {
		this.id = id;
		this.name = name;
		this.point = point;
		this.url = url;
	}
	
	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getPoint() {
		return point;
	}

	public String getUrl() {
		return url;
	}

}
