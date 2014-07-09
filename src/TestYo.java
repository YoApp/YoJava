import com.yo.Yo;

public class TestYo {
	public static void main(String[] args) {
		Yo yo = new Yo(""); // Enter API Key here!
		try {
			yo.yoall();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
