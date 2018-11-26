package assignm4Recursion;

import static org.junit.Assert.*;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import org.junit.Test;

public class RecursionMyLinkedListTest {

	RecursionMyLinkedList<String> recursionStrList = new RecursionMyLinkedList<String>();
	RecursionMyLinkedList<Integer> recursionIntList = new RecursionMyLinkedList<Integer>();
	RecursionMyLinkedList<Double> recursionlDoubleList = new RecursionMyLinkedList<Double>();
	RecursionMyLinkedList<Float> recursionFloatList = new RecursionMyLinkedList<Float>();

	public void addToList(RecursionMyLinkedList<String> recursionStrList) {
		recursionStrList.add("add");
		recursionStrList.add("data");
		recursionStrList.add("get");
		recursionStrList.add("words");
		recursionStrList.add("return");
	}

	public void addToListInt(RecursionMyLinkedList<Integer> recursionIntList) {
		recursionIntList.add(1);
		recursionIntList.add(17);
		recursionIntList.add(72);
		recursionIntList.add(21);
		recursionIntList.add(49);
	}

	public void addToListDou(RecursionMyLinkedList<Double> recursionlDoubleList) {
		recursionlDoubleList.add(3.0d);
		recursionlDoubleList.add(1.3d);
		recursionlDoubleList.add(7.1d);
		recursionlDoubleList.add(2.0d);
		recursionlDoubleList.add(4.6d);
	}

	public void addToListFlo(RecursionMyLinkedList<Float> recursionFloatList) {
		recursionFloatList.add(2.78f);
		recursionFloatList.add(17.36f);
		recursionFloatList.add(72.21f);
		recursionFloatList.add(21.32f);
		recursionFloatList.add(49.26f);
	}

	@Test
	public void testAdd() {
		RecursionMyLinkedList<String> recursionStrList = new RecursionMyLinkedList<String>();
		assertEquals("hello", recursionStrList.add("hello").getData());
		recursionStrList.linkednodeRec = recursionStrList.linkednodeRec.getNext();
		assertEquals("world", recursionStrList.add("world").getData());
		recursionStrList.linkednodeRec = recursionStrList.linkednodeRec.getNext();
		assertEquals("hi", recursionStrList.add("hi").getData());
		recursionStrList.linkednodeRec = recursionStrList.linkednodeRec.getNext();
		assertEquals(null, recursionStrList.add(null).getData());
		recursionStrList.linkednodeRec = recursionStrList.linkednodeRec.getNext();
		assertEquals(" ", recursionStrList.add(" ").getData());

		RecursionMyLinkedList<Integer> genericIntList = new RecursionMyLinkedList<Integer>();
		addToListInt(genericIntList);
		Integer iValue = new Integer(1);
		assertEquals(iValue, genericIntList.getFirst().getData());

		RecursionMyLinkedList<Double> recursionlDoubleList = new RecursionMyLinkedList<Double>();
		addToListDou(recursionlDoubleList);
		Double dValue = new Double(3.0);
		assertEquals(dValue, recursionlDoubleList.getFirst().getData());
		recursionlDoubleList.remove(3.0);
		dValue = new Double(1.3);
		assertEquals(dValue, recursionlDoubleList.getFirst().getData());

		RecursionMyLinkedList<Float> recursionFloatList = new RecursionMyLinkedList<Float>();
		addToListFlo(recursionFloatList);
		Float fValue = new Float(2.78f);
		assertEquals(fValue, recursionFloatList.getFirst().getData());
		recursionFloatList.remove(2.78f);
		fValue = new Float(17.36f);
		assertEquals(fValue, recursionFloatList.getFirst().getData());
	}

	@Test
	public void testGetFirst() {
		RecursionMyLinkedList<String> recursionStrList = new RecursionMyLinkedList<String>();
		assertNull(recursionStrList.getFirst());
		addToList(recursionStrList);
		assertEquals("add", recursionStrList.getFirst().getData());
		recursionStrList.remove("add");
		assertEquals("data", recursionStrList.getFirst().getData());

		RecursionMyLinkedList<Integer> recursionIntList = new RecursionMyLinkedList<Integer>();
		addToListInt(recursionIntList);
		Integer iValue = new Integer(1);
		assertEquals(iValue, recursionIntList.getFirst().getData());

		RecursionMyLinkedList<Double> recursionlDoubleList = new RecursionMyLinkedList<Double>();
		addToListDou(recursionlDoubleList);
		Double dValue = new Double(3.0);
		assertEquals(dValue, recursionlDoubleList.getFirst().getData());

		RecursionMyLinkedList<Float> recursionFloatList = new RecursionMyLinkedList<Float>();
		addToListFlo(recursionFloatList);
		Float fValue = new Float(2.78f);
		assertEquals(fValue, recursionFloatList.getFirst().getData());
	}

	@Test
	public void testGetLast() {
		RecursionMyLinkedList<String> recursionStrList = new RecursionMyLinkedList<String>();
		assertNull(recursionStrList.getLast());
		addToList(recursionStrList);
		assertEquals("return", recursionStrList.getLast().getData());
		addToList(recursionStrList);
		recursionStrList.remove("return");
		recursionStrList.add("give");
		assertEquals("give", recursionStrList.getLast().getData());

		RecursionMyLinkedList<Integer> recursionIntList = new RecursionMyLinkedList<Integer>();
		addToListInt(recursionIntList);
		Integer iValue = new Integer(49);
		assertEquals(iValue, recursionIntList.getLast().getData());

		RecursionMyLinkedList<Double> recursionlDoubleList = new RecursionMyLinkedList<Double>();
		addToListDou(recursionlDoubleList);
		Double dValue = new Double(4.6);
		assertEquals(dValue, recursionlDoubleList.getLast().getData());

		RecursionMyLinkedList<Float> recursionFloatList = new RecursionMyLinkedList<Float>();
		addToListFlo(recursionFloatList);
		Float fValue = new Float(49.26f);
		assertEquals(fValue, recursionFloatList.getLast().getData());
	}

	@Test
	public void testFind() {
		RecursionMyLinkedList<String> recmylinkedlist = new RecursionMyLinkedList<String>();
		assertNull(recursionStrList.find(null));
		addToList(recmylinkedlist);
		assertEquals(null, recmylinkedlist.find("are"));
		addToList(recmylinkedlist);
		recmylinkedlist.add("are");
		assertEquals("data", recmylinkedlist.find("data").getData());
		assertEquals("get", recmylinkedlist.find("get").getData());
		assertEquals(null, recmylinkedlist.find(null));

		RecursionMyLinkedList<Integer> recursionIntList = new RecursionMyLinkedList<Integer>();
		addToListInt(recursionIntList);
		assertEquals(null, recursionIntList.find(7));

		RecursionMyLinkedList<Double> recursionlDoubleList = new RecursionMyLinkedList<Double>();
		addToListDou(recursionlDoubleList);
		assertEquals(null, recursionlDoubleList.find(7.73));

		RecursionMyLinkedList<Float> recursionFloatList = new RecursionMyLinkedList<Float>();
		addToListFlo(recursionFloatList);
		assertEquals(null, recursionFloatList.find(7.73f));
	}

	@Test
	public void testGetRemove() {
		RecursionMyLinkedList<String> recursionStrList = new RecursionMyLinkedList<String>();
		assertNull(recursionStrList.remove());
		addToList(recursionStrList);
		assertEquals(null, recursionStrList.remove());
		recursionStrList.add("give");
		assertEquals(null, recursionStrList.remove());
		recursionStrList.add(null);
		assertEquals(null, recursionStrList.remove());

		RecursionMyLinkedList<Integer> recursionIntList = new RecursionMyLinkedList<Integer>();
		addToListInt(recursionIntList);
		assertEquals(null, recursionIntList.remove());

		RecursionMyLinkedList<Double> recursionlDoubleList = new RecursionMyLinkedList<Double>();
		addToListDou(recursionlDoubleList);
		assertEquals(null, recursionlDoubleList.remove());
		recursionlDoubleList.add(3.9);
		assertEquals(null, recursionlDoubleList.remove());

		RecursionMyLinkedList<Float> recursionFloatList = new RecursionMyLinkedList<Float>();
		addToListFlo(recursionFloatList);
		assertEquals(null, recursionFloatList.remove());
		recursionFloatList.add(38.09f);
		assertEquals(null, recursionFloatList.remove());
	}

	@Test
	public void testGetRemoveData() {
		RecursionMyLinkedList<String> recursionStrList = new RecursionMyLinkedList<String>();
		assertNull(recursionStrList.remove(null));
		addToList(recursionStrList);
		recursionStrList.remove("add");
		assertEquals(null, recursionStrList.find("add"));
		recursionStrList.linkednodeRec = null;
		addToList(recursionStrList);
		recursionStrList.remove("return");
		assertEquals(null, recursionStrList.find("return"));

		RecursionMyLinkedList<Integer> recursionIntList = new RecursionMyLinkedList<Integer>();
		addToListInt(recursionIntList);
		recursionIntList.remove(72);
		assertEquals(null, recursionIntList.find(72));
		recursionIntList.removeIndex(21);
		assertEquals(null, recursionIntList.find(21));

		RecursionMyLinkedList<Double> recursionDoubleList = new RecursionMyLinkedList<Double>();
		addToListDou(recursionDoubleList);
		recursionDoubleList.remove(1.3);
		assertEquals(null, recursionDoubleList.find(1.3));

		RecursionMyLinkedList<Float> recursionFloatList = new RecursionMyLinkedList<Float>();
		addToListFlo(recursionFloatList);
		recursionFloatList.remove(17.36f);
		assertEquals(null, recursionFloatList.find(17.36f));
	}

	@Test
	public void testGetRemoveIndex() {
		RecursionMyLinkedList<String> recursionStrList = new RecursionMyLinkedList<String>();
		assertNull(recursionStrList.removeIndex(-1));
		addToList(recursionStrList);
		recursionStrList.removeIndex(5);
		assertEquals(null, recursionStrList.find("return"));

		RecursionMyLinkedList<Integer> recursionIntList = new RecursionMyLinkedList<Integer>();
		addToListInt(recursionIntList);
		recursionIntList.removeIndex(3);
		assertEquals(null, recursionIntList.find(72));
		recursionIntList.linkednodeRec = null;
		addToListInt(recursionIntList);
		recursionIntList.removeIndex(4);
		assertEquals(null, recursionIntList.find(21));
		recursionIntList.linkednodeRec = null;
		addToListInt(recursionIntList);
		recursionIntList.removeIndex(5);
		assertEquals(null, recursionIntList.find(49));

		RecursionMyLinkedList<Double> recursionDoubleList = new RecursionMyLinkedList<Double>();
		addToListDou(recursionDoubleList);
		recursionDoubleList.removeIndex(2);
		assertEquals(null, recursionDoubleList.find(1.3));

		RecursionMyLinkedList<Float> recursionFloatList = new RecursionMyLinkedList<Float>();
		addToListFlo(recursionFloatList);
		recursionFloatList.removeIndex(2);
		assertEquals(null, recursionFloatList.find(17.36f));
	}

	@Test
	public void testReverse() {
		RecursionMyLinkedList<String> recursionStrList = new RecursionMyLinkedList<String>();
		assertNull(recursionStrList.reverse());
		addToList(recursionStrList);
		recursionStrList.linkednodeRec = recursionStrList.reverse();
		assertEquals("return", recursionStrList.linkednodeRec.getData());
		recursionStrList.linkednodeRec = recursionStrList.linkednodeRec.getNext();
		assertEquals("words", recursionStrList.linkednodeRec.getData());
		recursionStrList.linkednodeRec = recursionStrList.linkednodeRec.getNext();
		assertEquals("get", recursionStrList.linkednodeRec.getData());
		recursionStrList.linkednodeRec = recursionStrList.linkednodeRec.getNext();
		assertEquals("data", recursionStrList.linkednodeRec.getData());
		recursionStrList.linkednodeRec = recursionStrList.linkednodeRec.getNext();
		assertEquals("add", recursionStrList.linkednodeRec.getData());

		RecursionMyLinkedList<Integer> recursionIntList = new RecursionMyLinkedList<Integer>();
		addToListInt(recursionIntList);
		recursionIntList.linkednodeRec = recursionIntList.reverse();
		Integer iValue = new Integer(49);
		assertEquals(iValue, recursionIntList.linkednodeRec.getData());
		recursionIntList.linkednodeRec = recursionIntList.linkednodeRec.getNext();
		iValue = new Integer(21);
		assertEquals(iValue, recursionIntList.linkednodeRec.getData());
		recursionIntList.linkednodeRec = recursionIntList.linkednodeRec.getNext();
		iValue = new Integer(72);
		assertEquals(iValue, recursionIntList.linkednodeRec.getData());
		recursionIntList.linkednodeRec = recursionIntList.linkednodeRec.getNext();
		iValue = new Integer(17);
		assertEquals(iValue, recursionIntList.linkednodeRec.getData());
		recursionIntList.linkednodeRec = recursionIntList.linkednodeRec.getNext();
		iValue = new Integer(1);
		assertEquals(iValue, recursionIntList.linkednodeRec.getData());
		recursionIntList.linkednodeRec = recursionIntList.linkednodeRec.getNext();

		RecursionMyLinkedList<Double> recursionlDoubleList = new RecursionMyLinkedList<Double>();
		addToListDou(recursionlDoubleList);
		recursionlDoubleList.linkednodeRec = recursionlDoubleList.reverse();
		Double dValue = new Double(4.6);
		assertEquals(dValue, recursionlDoubleList.linkednodeRec.getData());
		recursionlDoubleList.linkednodeRec = recursionlDoubleList.linkednodeRec.getNext();
		dValue = new Double(2.0);
		assertEquals(dValue, recursionlDoubleList.linkednodeRec.getData());
		recursionlDoubleList.linkednodeRec = recursionlDoubleList.linkednodeRec.getNext();
		dValue = new Double(7.1);
		assertEquals(dValue, recursionlDoubleList.linkednodeRec.getData());
		recursionlDoubleList.linkednodeRec = recursionlDoubleList.linkednodeRec.getNext();
		dValue = new Double(1.3);
		assertEquals(dValue, recursionlDoubleList.linkednodeRec.getData());
		recursionlDoubleList.linkednodeRec = recursionlDoubleList.linkednodeRec.getNext();
		dValue = new Double(3.0);
		assertEquals(dValue, recursionlDoubleList.linkednodeRec.getData());

		RecursionMyLinkedList<Float> recursionFloatList = new RecursionMyLinkedList<Float>();
		addToListFlo(recursionFloatList);
		recursionFloatList.linkednodeRec = recursionFloatList.reverse();
		Float fValue = new Float(49.26f);
		assertEquals(fValue, recursionFloatList.linkednodeRec.getData());
		recursionFloatList.linkednodeRec = recursionFloatList.linkednodeRec.getNext();
		fValue = new Float(21.32f);
		assertEquals(fValue, recursionFloatList.linkednodeRec.getData());
		recursionFloatList.linkednodeRec = recursionFloatList.linkednodeRec.getNext();
		fValue = new Float(72.21f);
		assertEquals(fValue, recursionFloatList.linkednodeRec.getData());
		recursionFloatList.linkednodeRec = recursionFloatList.linkednodeRec.getNext();
		fValue = new Float(17.36f);
		assertEquals(fValue, recursionFloatList.linkednodeRec.getData());
		recursionFloatList.linkednodeRec = recursionFloatList.linkednodeRec.getNext();
		fValue = new Float(2.78f);
		assertEquals(fValue, recursionFloatList.linkednodeRec.getData());
	}

	@Test
	public void testprint() {
		RecursionMyLinkedList<String> recursionStrList = new RecursionMyLinkedList<String>();
		assertNull(recursionStrList.print());
		addToList(recursionStrList);
		recursionStrList.print();
		FileReader filereader = null;
		try {
			filereader = new FileReader("C:/Users/subh/Documents/vijayalaxmi/ass4/" + "display1" + ".txt");
			Scanner scanner = new Scanner(filereader);
			scanner.useDelimiter(" ");
			while (scanner.hasNext() && recursionStrList.linkednodeRec != null) {
				assertEquals(scanner.next(), recursionStrList.linkednodeRec.getData());
				recursionStrList.linkednodeRec = recursionStrList.linkednodeRec.getNext();
			}
			scanner.close();
			filereader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testSort() {
		RecursionMyLinkedList<String> recursionStrList = new RecursionMyLinkedList<String>();
		assertNull(recursionStrList.getSort("ASC"));
		addToList(recursionStrList);
		recursionStrList.getSort("ASC");
		assertEquals("add", recursionStrList.linkednodeRec.getData());
		recursionStrList.linkednodeRec = recursionStrList.linkednodeRec.getNext();
		assertEquals("data", recursionStrList.linkednodeRec.getData());
		recursionStrList.linkednodeRec = recursionStrList.linkednodeRec.getNext();
		assertEquals("get", recursionStrList.linkednodeRec.getData());
		recursionStrList.linkednodeRec = recursionStrList.linkednodeRec.getNext();
		assertEquals("return", recursionStrList.linkednodeRec.getData());
		recursionStrList.linkednodeRec = recursionStrList.linkednodeRec.getNext();
		assertEquals("words", recursionStrList.linkednodeRec.getData());

		recursionStrList.linkednodeRec = null;
		addToList(recursionStrList);

		recursionStrList.getSort("DESC");
		assertEquals("words", recursionStrList.linkednodeRec.getData());

		recursionStrList.linkednodeRec = recursionStrList.linkednodeRec.getNext();
		assertEquals("return", recursionStrList.linkednodeRec.getData());
		recursionStrList.linkednodeRec = recursionStrList.linkednodeRec.getNext();
		assertEquals("get", recursionStrList.linkednodeRec.getData());
		recursionStrList.linkednodeRec = recursionStrList.linkednodeRec.getNext();
		assertEquals("data", recursionStrList.linkednodeRec.getData());
		recursionStrList.linkednodeRec = recursionStrList.linkednodeRec.getNext();
		assertEquals("add", recursionStrList.linkednodeRec.getData());

		RecursionMyLinkedList<Integer> recursionIntList = new RecursionMyLinkedList<Integer>();
		addToListInt(recursionIntList);
		recursionIntList.getSort("DESC");
		Integer iValue = new Integer(72);
		assertEquals(iValue, recursionIntList.linkednodeRec.getData());
		recursionIntList.linkednodeRec = recursionIntList.linkednodeRec.getNext();
		iValue = new Integer(49);
		assertEquals(iValue, recursionIntList.linkednodeRec.getData());
		recursionIntList.linkednodeRec = recursionIntList.linkednodeRec.getNext();
		iValue = new Integer(21);
		assertEquals(iValue, recursionIntList.linkednodeRec.getData());
		recursionIntList.linkednodeRec = recursionIntList.linkednodeRec.getNext();
		iValue = new Integer(17);
		assertEquals(iValue, recursionIntList.linkednodeRec.getData());
		recursionIntList.linkednodeRec = recursionIntList.linkednodeRec.getNext();
		iValue = new Integer(1);
		assertEquals(iValue, recursionIntList.linkednodeRec.getData());
		recursionIntList.linkednodeRec = recursionIntList.linkednodeRec.getNext();

		RecursionMyLinkedList<Double> recursionlDoubleList = new RecursionMyLinkedList<Double>();
		addToListDou(recursionlDoubleList);
		recursionlDoubleList.getSort("ASC");
		Double dValue = new Double(1.3);
		assertEquals(dValue, recursionlDoubleList.linkednodeRec.getData());
		recursionlDoubleList.linkednodeRec = recursionlDoubleList.linkednodeRec.getNext();
		dValue = new Double(2.0);
		assertEquals(dValue, recursionlDoubleList.linkednodeRec.getData());
		recursionlDoubleList.linkednodeRec = recursionlDoubleList.linkednodeRec.getNext();
		dValue = new Double(3.0);
		assertEquals(dValue, recursionlDoubleList.linkednodeRec.getData());
		recursionlDoubleList.linkednodeRec = recursionlDoubleList.linkednodeRec.getNext();
		dValue = new Double(4.6);
		assertEquals(dValue, recursionlDoubleList.linkednodeRec.getData());
		recursionlDoubleList.linkednodeRec = recursionlDoubleList.linkednodeRec.getNext();
		dValue = new Double(7.1);
		assertEquals(dValue, recursionlDoubleList.linkednodeRec.getData());

		RecursionMyLinkedList<Float> recursionFloatList = new RecursionMyLinkedList<Float>();
		addToListFlo(recursionFloatList);
		recursionFloatList.getSort("DESC");
		Float fValue = new Float(72.21f);
		assertEquals(fValue, recursionFloatList.linkednodeRec.getData());
		recursionFloatList.linkednodeRec = recursionFloatList.linkednodeRec.getNext();
		fValue = new Float(49.26f);
		assertEquals(fValue, recursionFloatList.linkednodeRec.getData());
		recursionFloatList.linkednodeRec = recursionFloatList.linkednodeRec.getNext();
		fValue = new Float(21.32f);
		assertEquals(fValue, recursionFloatList.linkednodeRec.getData());
		recursionFloatList.linkednodeRec = recursionFloatList.linkednodeRec.getNext();
		fValue = new Float(17.36f);
		assertEquals(fValue, recursionFloatList.linkednodeRec.getData());
		recursionFloatList.linkednodeRec = recursionFloatList.linkednodeRec.getNext();
		fValue = new Float(2.78f);
		assertEquals(fValue, recursionFloatList.linkednodeRec.getData());
	}
}