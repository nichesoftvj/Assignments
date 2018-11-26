package assignm3;

import static org.junit.Assert.*;
import org.junit.Test;
import java.io.*;
import java.util.*;

public class MyLittleSorterTest {

	public String[] load() {
		MyLittleSorter sorter = new MyLittleSorter();
		sorter.array = sorter.addToArray("ram");
		sorter.array = sorter.addToArray("siya");
		sorter.array = sorter.addToArray("aika");
		sorter.array = sorter.addToArray("lina");
		sorter.array = sorter.addToArray("xyz");
		return sorter.array;
	}

	@Test
	public void testAddToArray() {
		MyLittleSorter sorter = new MyLittleSorter();
		assertArrayEquals(new String[] { "one", null, null, null, null }, sorter.addToArray("one"));
		assertArrayEquals(new String[] { "one", "two", null, null, null }, sorter.addToArray("two"));
		assertArrayEquals(new String[] { "one", "two", "three", null, null }, sorter.addToArray("three"));
		assertArrayEquals(new String[] { "one", "two", "three", "four", null }, sorter.addToArray("four"));
		assertArrayEquals(new String[] { "one", "two", "three", "four", "five" }, sorter.addToArray("five"));
		sorter.index = sorter.array.length;
		assertArrayEquals(new String[] { "one", "two", "three", "four", "five", "six", null, null, null, null },
				sorter.addToArray("six"));
		assertArrayEquals(new String[] { "one", "two", "three", "four", "five", "six", "yes", null, null, null },
				sorter.addToArray("yes"));
	}

	@Test
	public void testSortToAscendingOrder() {
		MyLittleSorter sorter = new MyLittleSorter();
		sorter.array = load();
		sorter.index = sorter.array.length;
		assertArrayEquals(new String[] { "aika", "lina", "ram", "siya", "xyz" }, sorter.getSort("ASC"));
		sorter.array = sorter.deleteWord(3);
		assertArrayEquals(new String[] { "aika", "ram", "siya", "xyz", null, }, sorter.getSort("ASC"));
		sorter.array = sorter.addToArray("tiny");
		assertArrayEquals(new String[] { "aika", "ram", "siya", "tiny", "xyz", null, null, null, null, null },
				sorter.getSort("ASC"));
		sorter.array = sorter.deleteWord(1);
		assertArrayEquals(new String[] { "aika", "ram", "tiny", "xyz", null, null, null, null, null, null },
				sorter.getSort("ASC"));
		sorter.array = sorter.addToArray("kite");
		assertArrayEquals(new String[] { "aika", "kite", "ram", "tiny", "xyz", null, null, null, null, null },
				sorter.getSort("ASC"));
		sorter.array = sorter.addToArray("bird");
		sorter.array = sorter.addToArray("fomo");
		assertArrayEquals(new String[] { "aika", "bird", "fomo", "kite", "ram", "tiny", "xyz", null, null, null },
				sorter.getSort("ASC"));
	}

	@Test
	public void testSortToDescendingOrder() {
		MyLittleSorter sorter = new MyLittleSorter();
		sorter.array = load();
		sorter.index = sorter.array.length;
		assertArrayEquals(new String[] { "xyz", "siya", "ram", "lina", "aika" }, sorter.getSort("DESC"));
		sorter.array = sorter.addToArray("tiny");
		assertArrayEquals(new String[] { "xyz", "tiny", "siya", "ram", "lina", "aika", null, null, null, null },
				sorter.getSort("DESC"));
		sorter.array = sorter.deleteWord(3);
		assertArrayEquals(new String[] { "xyz", "tiny", "siya", "ram", "aika", null, null, null, null, null },
				sorter.getSort("DESC"));
		sorter.array = sorter.deleteWord(1);
		assertArrayEquals(new String[] { "xyz", "tiny", "ram", "aika", null, null, null, null, null, null },
				sorter.getSort("DESC"));
		sorter.array = sorter.addToArray("olaf");
		assertArrayEquals(new String[] { "xyz", "tiny", "ram", "olaf", "aika", null, null, null, null, null },
				sorter.getSort("DESC"));
		sorter.array = sorter.addToArray("ali");
		sorter.array = sorter.addToArray("add");
		assertArrayEquals(new String[] { "xyz", "tiny", "ram", "olaf", "aika", "ali", "add", null, null, null },
				sorter.getSort("DESC"));
		sorter.array = sorter.deleteWord(6);
		assertArrayEquals(new String[] { "xyz", "tiny", "ram", "aika", "ali", "add", null, null, null, null },
				sorter.getSort("DESC"));
	}

	@Test
	public void testDeleteWord() {
		MyLittleSorter sorter = new MyLittleSorter();
		sorter.array = load();
		sorter.index = sorter.array.length;
		assertArrayEquals(new String[] { "ram", "siya", "aika", "xyz", null }, sorter.deleteWord(3));
		sorter.addToArray("color");
		assertArrayEquals(new String[] { "ram", "siya", "aika", "xyz", "color", null, null, null, null, null },
				sorter.deleteWord(3));
		assertArrayEquals(new String[] { "siya", "aika", "lina", "xyz", "color", null, null, null, null, null },
				sorter.deleteWord(0));
		sorter.array = sorter.addToArray("red");
		assertArrayEquals(new String[] { "siya", "aika", "lina", "xyz", "color", "red", null, null, null, null },
				sorter.deleteWord(0));
		sorter.array = sorter.addToArray("two");
		assertArrayEquals(new String[] { "ram", "aika", "lina", "xyz", "color", "red", "two", null, null, null },
				sorter.deleteWord(1));
		sorter.array = sorter.addToArray("joy");
		assertArrayEquals(new String[] { "ram", "siya", "aika", "lina", "color", "red", "two", "joy", null, null },
				sorter.deleteWord(4));
		sorter.array = sorter.deleteWord(5);
		assertArrayEquals(new String[] { "ram", "aika", "lina", "xyz", "red", "two", "joy", null, null, null, },
				sorter.deleteWord(1));
		sorter.array = sorter.addToArray("kiwi");
		assertArrayEquals(new String[] { "ram", "siya", "lina", "xyz", "red", "two", "joy", "kiwi", null, null },
				sorter.deleteWord(2));
	}

	@Test
	public void testCreateFile() throws IOException {
		MyLittleSorter sorter = new MyLittleSorter();
		sorter.array = load();
		sorter.index = sorter.array.length;
		assertEquals("ram siya aika lina xyz", sorter.createFile("color"));
	}

	@Test
	public void testGetWordDelimiter() throws IOException {
		MyLittleSorter sorter = new MyLittleSorter();
		sorter.array = load();
		sorter.createFile("hi");
		assertArrayEquals(new String[] { "ram", "siya", "aika", "lina", "xyz" }, sorter.getWordDelimiter("file1"));
		System.out.println();
		assertArrayEquals(new String[] { "red", "hys", "nsj", "pos", "kia" }, sorter.getWordDelimiter("file2"));
		System.out.println();
		assertArrayEquals(new String[] { "hi", "hello", "hi", "hello", "hi" }, sorter.getWordDelimiter("file3"));
	}

	@Test
	public void testGetGivenWordDelimiter() throws IOException {
		MyLittleSorter sorter = new MyLittleSorter();
		assertArrayEquals(new String[] { "ra", "m siy", "a aik", "a li", "na ", "xyz" },
				sorter.getGivenWordDelimiter("f1", "/"));
		System.out.println();
		assertArrayEquals(new String[] { "ra", "m siy", "a aik", "a l", "ina x", "yz" },
				sorter.getGivenWordDelimiter("f2", ":"));
		System.out.println();
		assertArrayEquals(new String[] { "r", "am s", "iya a", "ika l", "ina xy", "z" },
				sorter.getGivenWordDelimiter("f3", "!"));
	}

	@Test
	public void testMyCompare() {
		MyLittleSorter sorter = new MyLittleSorter();
		assertEquals(-1, sorter.myCompare("big", "small", "ASC"));
		assertEquals(0, sorter.myCompare(null, null, "ASC"));
		assertEquals(0, sorter.myCompare("", "small", "ASC"));
		assertEquals(1, sorter.myCompare("ola", "giva", "ASC"));
		assertEquals(0, sorter.myCompare("ola", null, "ASC"));
		assertEquals(0, sorter.myCompare("", "", "ASC"));
		assertEquals(1, sorter.myCompare("bear", "dear", "DESC"));
		assertEquals(1, sorter.myCompare("zink", "giva", "ASC"));
		assertEquals(0, sorter.myCompare("ola", "ola", "ASC"));
	}

	@Test
	public void testCheckExpression() throws IOException {
		MyLittleSorter sorter = new MyLittleSorter();
		sorter.array = load();
		sorter.index = sorter.array.length;
		FileInputStream fin = new FileInputStream("C:/Users/subh/Documents/vijayalaxmi/ass3/abc.txt");
		Scanner scanner = new Scanner(fin);
		while (scanner.hasNext()) {
			String s = scanner.next();
			switch (s) {
			case (">"):
				assertArrayEquals(new String[] { "aika", "lina", "ram", "siya", "xyz" }, sorter.checkExpression(s));
				break;
			case ("<"):
				assertArrayEquals(new String[] { "xyz", "siya", "ram", "lina", "aika" }, sorter.checkExpression(s));
				break;
			case ("-"):
				assertArrayEquals(new String[] { "ram", "siya", "aika", "lina", null }, sorter.checkExpression(s));
				break;
			case ("- ram"):
				assertArrayEquals(new String[] { null, "siya", "aika", "lina", "xyz" }, sorter.checkExpression(s));
				break;
			case (">>"):
				assertArrayEquals(new String[] { "ram", "siya", "aika", "lina", "xyz" }, sorter.checkExpression(s));
				break;
			case (">> abc"):
				assertArrayEquals(new String[] { "ram", "siya", "aika", "lina", "xyz" }, sorter.checkExpression(s));
				break;
			}
		}
		scanner.close();
	}
}