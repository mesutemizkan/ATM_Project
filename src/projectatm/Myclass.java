package projectatm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;


public class Myclass {
public static void main(String[] args) {
	HashMap<String, Integer> hm = new HashMap<>();
	String str = "Heera";
	String arr[] = str.split("");
	for (String w : arr) {
		hm.computeIfPresent(w, (k,v)->v+1);
		hm.computeIfAbsent(w, k->1);
		
	}
	System.out.println(hm);
	List <Integer> ls = new ArrayList<>(hm.values());
	System.out.println(ls);
	Collections.sort(ls);
	System.out.println(ls);
	System.out.println(ls.get(ls.size()-1));
	
}
}
