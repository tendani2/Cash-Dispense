package fnb.coin.dispenser.util;

public class Greeting {

    private String id;
    private String content;
    
    public Greeting(String id, String content) {
		this.id = id;
		this.content = content;
	}

	public String getId() {
        return this.id;
    }

    public String getContent() {
        return this.content;
    }

    @Override
    public String toString() {
        return "Greeting{" +
                "id='" + id + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
