package rough;

public class PdfHandling {

	public static void main(String arg[]) {
		
		String score = "39";
		float score_float1 = Float.parseFloat(score);
		float x = score_float1/4f;
		System.out.println(score_float1);
		System.out.println(x);
		System.out.println(Math.round(x));
		
	}

}