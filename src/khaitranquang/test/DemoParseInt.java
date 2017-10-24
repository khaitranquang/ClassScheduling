package khaitranquang.test;

public class DemoParseInt {
	public static void main(String[] args) {
		String str = "101";
		int x = Integer.parseInt(str);
		int bin = Integer.parseInt(str, 2);
		System.out.println(bin);
	}
}
