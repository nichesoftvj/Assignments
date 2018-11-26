package assignm2;

import java.io.*;
import java.util.*;
import java.util.Map.Entry;

public class PhoneDairy {
	HashMap<String, String> hashmap = new HashMap<String, String>();
	public HashMap<String, String> getHashmap() {
		return hashmap;
	}
	public void setHashmap(HashMap<String, String> hashmap) {
		this.hashmap = hashmap;
	}
	public HashMap<String, String> loadEn() {
		 hashmap.clear();
		hashmap.put("eena", "100");
		hashmap.put("meena", "200");
		hashmap.put("deeka", "300");
		hashmap.put("dai", "400");
		hashmap.put("dominika", "500");
		return hashmap;
	}
	
	public static void main(String[] args) throws IOException {
		PhoneDairy phonedairy = new PhoneDairy();
		phonedairy.setHashmap(phonedairy.loadEn());
		Set<Map.Entry<String, String>> hashmapset = phonedairy.hashmap.entrySet();
		String name, number;
		Properties props = new Properties();

		if (args.length == 1) {
			if (args[0].equals("PhoneDairy")) {
				System.out.println(hashmapset);
			}
		}
		if (args.length == 2) {
			if (args[0].equals("PhoneDairy")) {
				name = args[1];
				phonedairy.getNumber(name);
			}
		}
		if (args.length > 2) {
			if (args[0].equals("PhoneDairy") && args[1].equals("-")) {
				name = args[2];
				phonedairy.removeName(name);
				System.out.println(hashmapset);
			} else if (args[0].equals("PhoneDairy") && args[1].equals("+")) {
				name = args[2];
				number = args[3];
				phonedairy.add(name, number);
				System.out.println(hashmapset);
			} else if (args[0].equals("PhoneDairy") && args[1].equals("++")) {
				FileInputStream f = new FileInputStream(args[2]);
				props.load(f);
				phonedairy.load(props);
			}
		}
	}

	public void loadEntities() {
		 hashmap.clear();
		hashmap.put("eena", "100");
		hashmap.put("meena", "200");
		hashmap.put("deeka", "300");
		hashmap.put("dai", "400");
		hashmap.put("dominika", "500");
	}
	public boolean add(String name, String number) {
		hashmap.put(name, number);
		return hashmap.containsKey(name);
	}
	public boolean removeName(String name) {
		hashmap.remove(name);
		return hashmap.containsKey(name);
	}
	public boolean removeNumber(String number) {
		String name = "";
		Set<String> set = hashmap.keySet();
		Iterator<String> itr = set.iterator();
		while (itr.hasNext()) {
			name = itr.next();
			String temp = hashmap.get(name);
			if (temp.equals(number)) {
				hashmap.remove(name);
				break;
			}
		}
		System.out.println(hashmap);
		return hashmap.containsKey(number);
	}
	public String getNumber(String name) {
		System.out.println(hashmap.get(name));
		return hashmap.get(name);
	}
	public void load(Properties props) {
		PhoneDairy phonedairy = new PhoneDairy();
		Set<Entry<Object, Object>> phonedairy_set = props.entrySet();
		for (Entry<Object, Object> obj : phonedairy_set) {
			phonedairy.add(((String) (obj.getKey())), (String) (obj.getValue()));
		}
		System.out.println(phonedairy);
	}
}