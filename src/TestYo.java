import com.yo.Yo;

public class TestYo {
	public static void main(String[] args) {
		Yo yo = new Yo("ffb1223a-5545-7bb0-c576-ae3216008692");
		try {
			yo.yoall();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
