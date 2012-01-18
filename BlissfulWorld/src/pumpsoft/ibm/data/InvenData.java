package pumpsoft.ibm.data;

public class InvenData {
	private String id;
	private String name;
	private String count;
	private String desc;
	private String url;
	private String effect;

	public InvenData(String id, String name, String count, String desc, String url, String effect) {
		this.id = id;
		this.name = name;
		this.count = count;
		this.desc = desc;
		this.url = url;
		this.effect = effect;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getCount() {
		return count;
	}

	public String getDesc() {
		return desc;
	}

	public String getUrl() {
		return url;
	}

	public String getEffect() {
		return effect;
	}

}
