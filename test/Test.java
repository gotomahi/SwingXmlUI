import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class Test {

	public static void main(String[] args)throws Exception{
		List l = new ArrayList();
		l.add("qqqq");
		l.add("qq");
		l.add(null);
		l.add("qqqq");
		l.add(null);
		l.add("qqq");
		Collections.sort(l, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				int val = 0;
				if(o2 != null && (o1 == null || o1.length() < o2.length())){
					val = -1;
				}else if(o1 != null && (o2 == null || o2.length() < o1.length())){
					val = 1;
				}
				return val;
			}
		});
		System.out.println(l);
	}
}
