package assignm4Generic;

import static org.junit.Assert.*;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import org.junit.Test;

public class GenericMyLinkedListTest {

	GenericMyLinkedList<String> genericStrList = new GenericMyLinkedList<String>();
	GenericMyLinkedList<Integer> genericIntList = new GenericMyLinkedList<Integer>();
	GenericMyLinkedList<Double> genericlDoubleList = new GenericMyLinkedList<Double>();
	GenericMyLinkedList<Float> genericFloatList = new GenericMyLinkedList<Float>();

	public void addToListStr(GenericMyLinkedList<String> genericStrList) {
		genericStrList.add("hello");
		genericStrList.add("wish");
		genericStrList.add("get");
		genericStrList.add("disk");
		genericStrList.add("ema");
	}

	public void addToListInt(GenericMyLinkedList<Integer> genericIntList) {
		genericIntList.add(1);
		genericIntList.add(17);
		genericIntList.add(72);
		genericIntList.add(21);
		genericIntList.add(49);
	}

	public void addToListDou(GenericMyLinkedList<Double> genericlDoubleList) {
		genericlDoubleList.add(3.0d);
		genericlDoubleList.add(1.3d);
		genericlDoubleList.add(7.1d);
		genericlDoubleList.add(2.0d);
		genericlDoubleList.add(4.6d);
	}

	public void addToListFlo(GenericMyLinkedList<Float> genericFloatList) {
		genericFloatList.add(2.78f);
		genericFloatList.add(17.36f);
		genericFloatList.add(72.21f);
		genericFloatList.add(21.32f);
		genericFloatList.add(49.26f);
	}

	@Test
	public void testAdd() {
		GenericMyLinkedList<String> genericStrList = new GenericMyLinkedList<String>();
		assertEquals("hello", genericStrList.add("hello").getData());

		GenericMyLinkedList<Integer> genericIntList = new GenericMyLinkedList<Integer>();
		Integer iValue = new Integer(21);
		assertEquals(iValue, genericIntList.add(21).getData());

		GenericMyLinkedList<Double> genlistDou = new GenericMyLinkedList<Double>();
		Double dValue = new Double(2.1);
		assertEquals(dValue, genlistDou.add(2.1).getData());

		GenericMyLinkedList<Float> genericFloatList = new GenericMyLinkedList<Float>();
		Float fValue = new Float(1.36f);
		assertEquals(fValue, genericFloatList.add(1.36f).getData());
	}

	@Test
	public void testGetFirst() {
		GenericMyLinkedList<String> genericStrList = new GenericMyLinkedList<String>();
		assertNull(genericStrList.getFirst());
		addToListStr(genericStrList);
		assertEquals("hello", genericStrList.getFirst().getData());
		genericStrList.remove("hello");
		assertEquals("wish", genericStrList.getFirst().getData());
		genericStrList.remove();
		genericStrList.remove("wish");
		genericStrList.remove("get");
		assertEquals("disk", genericStrList.getFirst().getData());

		GenericMyLinkedList<Integer> genericIntList = new GenericMyLinkedList<Integer>();
		addToListInt(genericIntList);
		Integer iValue = new Integer(1);
		assertEquals(iValue, genericIntList.getFirst().getData());

		GenericMyLinkedList<Double> genericlDoubleList = new GenericMyLinkedList<Double>();
		addToListDou(genericlDoubleList);
		Double dValue = new Double(3.0);
		assertEquals(dValue, genericlDoubleList.getFirst().getData());
		genericlDoubleList.remove(3.0);
		dValue = new Double(1.3);
		assertEquals(dValue, genericlDoubleList.getFirst().getData());

		GenericMyLinkedList<Float> genericFloatList = new GenericMyLinkedList<Float>();
		addToListFlo(genericFloatList);
		Float fValue = new Float(2.78f);
		assertEquals(fValue, genericFloatList.getFirst().getData());
		genericFloatList.remove(2.78f);
		fValue = new Float(17.36f);
		assertEquals(fValue, genericFloatList.getFirst().getData());

	}

	@Test
	public void testGetLast() {
		GenericMyLinkedList<String> genericStrList = new GenericMyLinkedList<String>();
		assertNull(genericStrList.getLast());
		addToListStr(genericStrList);
		assertEquals("ema", genericStrList.getLast().getData());
		genericStrList.remove("ema");
		genericStrList.add("key");
		genericStrList.add("gig");
		assertEquals("gig", genericStrList.getLast().getData());

		GenericMyLinkedList<Integer> genericIntList = new GenericMyLinkedList<Integer>();
		addToListInt(genericIntList);
		Integer iValue = new Integer(49);
		assertEquals(iValue, genericIntList.getLast().getData());
		genericIntList.add(4);
		iValue = new Integer(4);
		assertEquals(iValue, genericIntList.getLast().getData());

		GenericMyLinkedList<Double> genericlDoubleList = new GenericMyLinkedList<Double>();
		addToListDou(genericlDoubleList);
		Double dValue = new Double(4.6);
		assertEquals(dValue, genericlDoubleList.getLast().getData());
		genericlDoubleList.remove(4.6);
		genericlDoubleList.add(4.03);
		dValue = new Double(4.03);
		assertEquals(dValue, genericlDoubleList.getLast().getData());

		GenericMyLinkedList<Float> genericFloatList = new GenericMyLinkedList<Float>();
		addToListFlo(genericFloatList);
		Float fValue = new Float(49.26f);
		assertEquals(fValue, genericFloatList.getLast().getData());
		genericFloatList.remove(49.26f);
		genericFloatList.add(4.023f);
		fValue = new Float(4.023f);
		assertEquals(fValue, genericFloatList.getLast().getData());
	}

	@Test
	public void testFind() {
		GenericMyLinkedList<String> genericStrList = new GenericMyLinkedList<String>();
		assertNull(genericStrList.find(null));
		addToListStr(genericStrList);
		assertEquals(null, genericStrList.find("are"));
		genericStrList.add("are");
		assertEquals("wish", genericStrList.find("wish").getData());
		genericStrList.add("colors");
		assertEquals(null, genericStrList.find("qwerty"));
		assertEquals(null, genericStrList.find(null));
		assertEquals("colors", genericStrList.find("colors").getData());
		assertEquals(null, genericStrList.find(""));

		GenericMyLinkedList<Integer> genericIntList = new GenericMyLinkedList<Integer>();
		addToListInt(genericIntList);
		assertEquals(null, genericIntList.find(7));
		genericIntList.add(4);
		Integer iValue = new Integer(4);
		assertEquals(iValue, genericIntList.find(4).getData());
		genericIntList.add(37);
		iValue = new Integer(1);
		assertEquals(iValue, genericIntList.find(1).getData());
		assertEquals(null, genericIntList.find(null));

		GenericMyLinkedList<Double> genericlDoubleList = new GenericMyLinkedList<Double>();
		addToListDou(genericlDoubleList);
		assertEquals(null, genericlDoubleList.find(7.73));
		genericlDoubleList.add(43.21);
		Double dValue = new Double(43.21);
		assertEquals(dValue, genericlDoubleList.find(43.21).getData());
		genericlDoubleList.add(37.37);
		dValue = new Double(37.37);
		assertEquals(dValue, genericlDoubleList.find(37.37).getData());
		assertEquals(null, genericlDoubleList.find(null));

		GenericMyLinkedList<Float> genericFloatList = new GenericMyLinkedList<Float>();
		addToListFlo(genericFloatList);
		assertEquals(null, genericFloatList.find(7.73f));
		genericFloatList.add(43.21f);
		Float fValue = new Float(43.21f);
		assertEquals(fValue, genericFloatList.find(43.21f).getData());
		genericFloatList.add(37.37f);
		fValue = new Float(37.37f);
		assertEquals(fValue, genericFloatList.find(37.37f).getData());
		assertEquals(null, genericFloatList.find(null));
	}

	@Test
	public void testGetRemove() {
		GenericMyLinkedList<String> genericStrList = new GenericMyLinkedList<String>();
		assertNull(genericStrList.remove());
		addToListStr(genericStrList);
		assertEquals(null, genericStrList.remove());
		genericStrList.add("fig");
		assertEquals(null, genericStrList.remove());
		genericStrList.add("gig");
		assertEquals(null, genericStrList.remove());
		genericStrList.add(null);
		assertEquals(null, genericStrList.remove());

		GenericMyLinkedList<Integer> genericIntList = new GenericMyLinkedList<Integer>();
		addToListInt(genericIntList);
		assertEquals(null, genericIntList.remove());
		genericIntList.add(38);
		assertEquals(null, genericIntList.remove());
		genericIntList.add(23);
		assertEquals(null, genericIntList.remove());
		genericIntList.add(7);
		assertEquals(null, genericIntList.remove());

		GenericMyLinkedList<Double> genericlDoubleList = new GenericMyLinkedList<Double>();
		addToListDou(genericlDoubleList);
		assertEquals(null, genericlDoubleList.remove());
		genericlDoubleList.add(3.9);
		assertEquals(null, genericlDoubleList.remove());
		genericlDoubleList.add(3.2);
		assertEquals(null, genericlDoubleList.remove());
		genericlDoubleList.add(7.01);
		assertEquals(null, genericlDoubleList.remove());

		GenericMyLinkedList<Float> genericFloatList = new GenericMyLinkedList<Float>();
		addToListFlo(genericFloatList);
		assertEquals(null, genericFloatList.remove());
		genericFloatList.add(38.09f);
		assertEquals(null, genericFloatList.remove());
		genericFloatList.add(23.22f);
		assertEquals(null, genericFloatList.remove());
		genericFloatList.add(7.11f);
		assertEquals(null, genericFloatList.remove());
	}

	@Test
	public void testGetRemoveData() {
		GenericMyLinkedList<String> genericStrList = new GenericMyLinkedList<String>();
		assertNull(genericStrList.remove(null));
		addToListStr(genericStrList);
		genericStrList.remove("disk");
		assertEquals(null, genericStrList.find("disk"));
		genericStrList.linkednode=null;
		addToListStr(genericStrList);
		genericStrList.remove("hello");
		assertEquals(null, genericStrList.find("hello"));
		genericStrList.remove(null);
		assertEquals(null, genericStrList.find(null));
		genericStrList.remove("");
		assertEquals(null, genericStrList.find(null));
		genericStrList.remove("hhxbBh");
		assertEquals(null, genericStrList.find(null));

		GenericMyLinkedList<Integer> genericIntList = new GenericMyLinkedList<Integer>();
		addToListInt(genericIntList);
		genericIntList.remove(72);
		assertEquals(null, genericIntList.find(72));

		GenericMyLinkedList<Double> genericDoubleList = new GenericMyLinkedList<Double>();
		addToListDou(genericDoubleList);
		genericDoubleList.remove(1.3);
		assertEquals(null, genericDoubleList.find(1.3));

		GenericMyLinkedList<Float> genericFloatList = new GenericMyLinkedList<Float>();
		addToListFlo(genericFloatList);
		genericFloatList.remove(17.36f);
		assertEquals(null, genericFloatList.find(17.36f));
	}

	@Test
	public void testGetRemoveIndex() {
		GenericMyLinkedList<String> genericStrList = new GenericMyLinkedList<String>();
		assertNull(genericStrList.removeInt(-1));
		addToListStr(genericStrList);
		genericStrList.removeInt(1);
		assertEquals(null, genericStrList.find("hello"));
		genericStrList.linkednode=null;
		addToListStr(genericStrList);
		genericStrList.removeInt(5);
		assertEquals(null, genericStrList.find("ema"));

		GenericMyLinkedList<Integer> genericIntList = new GenericMyLinkedList<Integer>();
		addToListInt(genericIntList);
		genericIntList.removeInt(3);
		assertEquals(null, genericIntList.find(72));
		genericIntList.removeInt(4);
		assertEquals(null, genericIntList.find(21));

		GenericMyLinkedList<Double> genericDoubleList = new GenericMyLinkedList<Double>();
		addToListDou(genericDoubleList);
		genericDoubleList.removeInt(2);
		assertEquals(null, genericDoubleList.find(1.3));
		genericDoubleList.linkednode = null;
		addToListDou(genericDoubleList);
		genericDoubleList.removeInt(4);
		assertEquals(null, genericDoubleList.find(2.0));

		GenericMyLinkedList<Float> genericFloatList = new GenericMyLinkedList<Float>();
		addToListFlo(genericFloatList);
		genericFloatList.removeInt(2);
		assertEquals(null, genericFloatList.find(17.36f));
		genericFloatList.linkednode = null;
		addToListFlo(genericFloatList);
		genericFloatList.removeInt(4);
		assertEquals(null, genericFloatList.find(21.32f));
	}

	@Test
	public void testprint() {
		GenericMyLinkedList<String> genericStrList = new GenericMyLinkedList<String>();
		addToListStr(genericStrList);
		genericStrList.print();
		FileReader filereader = null;
		try {
			filereader = new FileReader("C:/Users/subh/Documents/vijayalaxmi/ass4/" + "display" + ".txt");
			Scanner scanner = new Scanner(filereader);
			scanner.useDelimiter(" ");
			while (scanner.hasNext() && genericStrList.linkednode != null) {
				assertEquals(scanner.next(), genericStrList.linkednode.getData());
				genericStrList.linkednode = genericStrList.linkednode.getNext();
			}
			scanner.close();
			filereader.close();

			GenericMyLinkedList<Integer> genericIntList = new GenericMyLinkedList<Integer>();
			addToListInt(genericIntList);
			genericIntList.print();
			filereader = new FileReader("C:/Users/subh/Documents/vijayalaxmi/ass4/" + "display" + ".txt");
			scanner = new Scanner(filereader);
			scanner.useDelimiter(" ");
			while (scanner.hasNext() && genericIntList.linkednode != null) {
				assertEquals(scanner.next(), genericIntList.linkednode.getData());
				genericIntList.linkednode = genericIntList.linkednode.getNext();
			}
			scanner.close();
			filereader.close();

			GenericMyLinkedList<Double> genericlDoubleList = new GenericMyLinkedList<Double>();
			addToListDou(genericlDoubleList);
			genericlDoubleList.print();
			filereader = new FileReader("C:/Users/subh/Documents/vijayalaxmi/ass4/" + "display" + ".txt");
			scanner = new Scanner(filereader);
			scanner.useDelimiter(" ");
			while (scanner.hasNext() && genericlDoubleList.linkednode != null) {
				assertEquals(scanner.next(), genericlDoubleList.linkednode.getData());
				genericlDoubleList.linkednode = genericlDoubleList.linkednode.getNext();
			}
			scanner.close();
			filereader.close();

			GenericMyLinkedList<Float> genericFloatList = new GenericMyLinkedList<Float>();
			addToListFlo(genericFloatList);
			genericFloatList.print();
			filereader = new FileReader("C:/Users/subh/Documents/vijayalaxmi/ass4/" + "display" + ".txt");
			scanner = new Scanner(filereader);
			scanner.useDelimiter(" ");
			while (scanner.hasNext() && genericFloatList.linkednode != null) {
				assertEquals(scanner.next(), genericFloatList.linkednode.getData());
				genericFloatList.linkednode = genericFloatList.linkednode.getNext();
			}
			scanner.close();
			filereader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testSort() {
		GenericMyLinkedList<String> genericStrList = new GenericMyLinkedList<String>();
		assertNull(genericStrList.getSort("ASC"));
		addToListStr(genericStrList);
		genericStrList.getSort("ASC");
		assertEquals("disk", genericStrList.linkednode.getData());
		genericStrList.linkednode = genericStrList.linkednode.getNext();
		assertEquals("ema", genericStrList.linkednode.getData());
		genericStrList.linkednode = genericStrList.linkednode.getNext();
		assertEquals("get", genericStrList.linkednode.getData());
		genericStrList.linkednode = genericStrList.linkednode.getNext();
		assertEquals("hello", genericStrList.linkednode.getData());
		genericStrList.linkednode = genericStrList.linkednode.getNext();
		assertEquals("wish", genericStrList.linkednode.getData());

		GenericMyLinkedList<Integer> genericIntList = new GenericMyLinkedList<Integer>();
		addToListInt(genericIntList);
		genericIntList.getSort("DESC");
		Integer iValue = new Integer(72);
		assertEquals(iValue, genericIntList.linkednode.getData());
		genericIntList.linkednode = genericIntList.linkednode.getNext();
		iValue = new Integer(49);
		assertEquals(iValue, genericIntList.linkednode.getData());
		genericIntList.linkednode = genericIntList.linkednode.getNext();
		iValue = new Integer(21);
		assertEquals(iValue, genericIntList.linkednode.getData());
		genericIntList.linkednode = genericIntList.linkednode.getNext();
		iValue = new Integer(17);
		assertEquals(iValue, genericIntList.linkednode.getData());
		genericIntList.linkednode = genericIntList.linkednode.getNext();
		iValue = new Integer(1);
		assertEquals(iValue, genericIntList.linkednode.getData());
		genericIntList.linkednode = genericIntList.linkednode.getNext();

		GenericMyLinkedList<Double> genericlDoubleList = new GenericMyLinkedList<Double>();
		addToListDou(genericlDoubleList);
		genericlDoubleList.getSort("ASC");
		Double dValue = new Double(1.3);
		assertEquals(dValue, genericlDoubleList.linkednode.getData());
		genericlDoubleList.linkednode = genericlDoubleList.linkednode.getNext();
		dValue = new Double(2.0);
		assertEquals(dValue, genericlDoubleList.linkednode.getData());
		genericlDoubleList.linkednode = genericlDoubleList.linkednode.getNext();
		dValue = new Double(3.0);
		assertEquals(dValue, genericlDoubleList.linkednode.getData());
		genericlDoubleList.linkednode = genericlDoubleList.linkednode.getNext();
		dValue = new Double(4.6);
		assertEquals(dValue, genericlDoubleList.linkednode.getData());
		genericlDoubleList.linkednode = genericlDoubleList.linkednode.getNext();
		dValue = new Double(7.1);
		assertEquals(dValue, genericlDoubleList.linkednode.getData());

		GenericMyLinkedList<Float> genericFloatList = new GenericMyLinkedList<Float>();
		addToListFlo(genericFloatList);
		genericFloatList.getSort("DESC");
		Float fValue = new Float(72.21f);
		assertEquals(fValue, genericFloatList.linkednode.getData());
		genericFloatList.linkednode = genericFloatList.linkednode.getNext();
		fValue = new Float(49.26f);
		assertEquals(fValue, genericFloatList.linkednode.getData());
		genericFloatList.linkednode = genericFloatList.linkednode.getNext();
		fValue = new Float(21.32f);
		assertEquals(fValue, genericFloatList.linkednode.getData());
		genericFloatList.linkednode = genericFloatList.linkednode.getNext();
		fValue = new Float(17.36f);
		assertEquals(fValue, genericFloatList.linkednode.getData());
		genericFloatList.linkednode = genericFloatList.linkednode.getNext();
		fValue = new Float(2.78f);
		assertEquals(fValue, genericFloatList.linkednode.getData());
	}

	@Test
	public void testReverse() {
		GenericMyLinkedList<String> genericStrList = new GenericMyLinkedList<String>();
		assertNull(genericStrList.reverse());
		addToListStr(genericStrList);
		genericStrList.linkednode = genericStrList.reverse();
		assertEquals("ema", genericStrList.linkednode.getData());
		genericStrList.linkednode = genericStrList.linkednode.getNext();
		assertEquals("disk", genericStrList.linkednode.getData());
		genericStrList.linkednode = genericStrList.linkednode.getNext();
		assertEquals("get", genericStrList.linkednode.getData());
		genericStrList.linkednode = genericStrList.linkednode.getNext();
		assertEquals("wish", genericStrList.linkednode.getData());
		genericStrList.linkednode = genericStrList.linkednode.getNext();
		assertEquals("hello", genericStrList.linkednode.getData());

		GenericMyLinkedList<Integer> genericIntList = new GenericMyLinkedList<Integer>();
		addToListInt(genericIntList);
		genericIntList.linkednode = genericIntList.reverse();
		Integer iValue = new Integer(49);
		assertEquals(iValue, genericIntList.linkednode.getData());
		genericIntList.linkednode = genericIntList.linkednode.getNext();
		iValue = new Integer(21);
		assertEquals(iValue, genericIntList.linkednode.getData());
		genericIntList.linkednode = genericIntList.linkednode.getNext();
		iValue = new Integer(72);
		assertEquals(iValue, genericIntList.linkednode.getData());
		genericIntList.linkednode = genericIntList.linkednode.getNext();
		iValue = new Integer(17);
		assertEquals(iValue, genericIntList.linkednode.getData());
		genericIntList.linkednode = genericIntList.linkednode.getNext();
		iValue = new Integer(1);
		assertEquals(iValue, genericIntList.linkednode.getData());
		genericIntList.linkednode = genericIntList.linkednode.getNext();

		GenericMyLinkedList<Double> genericlDoubleList = new GenericMyLinkedList<Double>();
		addToListDou(genericlDoubleList);
		genericlDoubleList.linkednode = genericlDoubleList.reverse();
		Double dValue = new Double(4.6);
		assertEquals(dValue, genericlDoubleList.linkednode.getData());
		genericlDoubleList.linkednode = genericlDoubleList.linkednode.getNext();
		dValue = new Double(2.0);
		assertEquals(dValue, genericlDoubleList.linkednode.getData());
		genericlDoubleList.linkednode = genericlDoubleList.linkednode.getNext();
		dValue = new Double(7.1);
		assertEquals(dValue, genericlDoubleList.linkednode.getData());
		genericlDoubleList.linkednode = genericlDoubleList.linkednode.getNext();
		dValue = new Double(1.3);
		assertEquals(dValue, genericlDoubleList.linkednode.getData());
		genericlDoubleList.linkednode = genericlDoubleList.linkednode.getNext();
		dValue = new Double(3.0);
		assertEquals(dValue, genericlDoubleList.linkednode.getData());

		GenericMyLinkedList<Float> genericFloatList = new GenericMyLinkedList<Float>();
		addToListFlo(genericFloatList);
		genericFloatList.linkednode = genericFloatList.reverse();
		Float fValue = new Float(49.26f);
		assertEquals(fValue, genericFloatList.linkednode.getData());
		genericFloatList.linkednode = genericFloatList.linkednode.getNext();
		fValue = new Float(21.32f);
		assertEquals(fValue, genericFloatList.linkednode.getData());
		genericFloatList.linkednode = genericFloatList.linkednode.getNext();
		fValue = new Float(72.21f);
		assertEquals(fValue, genericFloatList.linkednode.getData());
		genericFloatList.linkednode = genericFloatList.linkednode.getNext();
		fValue = new Float(17.36f);
		assertEquals(fValue, genericFloatList.linkednode.getData());
		genericFloatList.linkednode = genericFloatList.linkednode.getNext();
		fValue = new Float(2.78f);
		assertEquals(fValue, genericFloatList.linkednode.getData());
	}

	@Test
	public void testCreateFile() {
		GenericMyLinkedList<String> genericStrList = new GenericMyLinkedList<String>();
		assertNull(genericStrList.createFile("xyz"));
		addToListStr(genericStrList);
		genericStrList.createFile("GenFile1");

		genericStrList.linkednode = genericStrList.load("GenFile1", " ", "string");
		FileReader filereader = null;
		try {
			filereader = new FileReader("C:/Users/subh/Documents/vijayalaxmi/ass4/" + "GenFile1" + ".txt");
			Scanner scanner = new Scanner(filereader);
			scanner.useDelimiter(" ");
			while (scanner.hasNext() && genericStrList.linkednode != null) {
				assertEquals(scanner.next(), genericStrList.linkednode.getData());
				genericStrList.linkednode = genericStrList.linkednode.getNext();
			}
			scanner.close();

			GenericMyLinkedList<Integer> genericIntList = new GenericMyLinkedList<Integer>();
			addToListInt(genericIntList);
			genericIntList.createFile("GenFile2");
			genericIntList.linkednode = genericIntList.load("GenFile2", " ", "integer");
			filereader = new FileReader("C:/Users/subh/Documents/vijayalaxmi/ass4/" + "GenFile2" + ".txt");
			scanner = new Scanner(filereader);
			scanner.useDelimiter(" ");
			while (scanner.hasNext() && genericFloatList.linkednode != null) {
				assertEquals(new Integer(scanner.nextInt()), genericIntList.linkednode.getData());
				genericIntList.linkednode = genericIntList.linkednode.getNext();
			}
			scanner.close();

			GenericMyLinkedList<Double> genericDoubleList = new GenericMyLinkedList<Double>();
			addToListDou(genericDoubleList);
			genericDoubleList.createFile("GenFile3");
			genericDoubleList.linkednode = genericDoubleList.load("GenFile3", " ", "double");
			filereader = new FileReader("C:/Users/subh/Documents/vijayalaxmi/ass4/" + "GenFile3" + ".txt");
			scanner = new Scanner(filereader);
			scanner.useDelimiter(" ");
			while (scanner.hasNext() && genericDoubleList.linkednode != null) {
				assertEquals(new Double(scanner.nextDouble()), genericDoubleList.linkednode.getData());
				genericDoubleList.linkednode = genericDoubleList.linkednode.getNext();

			}
			scanner.close();

			GenericMyLinkedList<Float> genericFloatList = new GenericMyLinkedList<Float>();
			addToListFlo(genericFloatList);
			genericFloatList.createFile("GenFile4");
			genericFloatList.linkednode = genericFloatList.load("GenFile4", " ", "float");
			filereader = new FileReader("C:/Users/subh/Documents/vijayalaxmi/ass4/" + "GenFile4" + ".txt");
			scanner = new Scanner(filereader);
			scanner.useDelimiter(" ");
			while (scanner.hasNext() && genericFloatList.linkednode != null) {
				assertEquals(new Float(scanner.nextFloat()), genericFloatList.linkednode.getData());
				genericFloatList.linkednode = genericFloatList.linkednode.getNext();
			}
			scanner.close();
			filereader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testLoad() {
		GenericMyLinkedList<String> genericStrList = new GenericMyLinkedList<String>();
		genericStrList.linkednode = genericStrList.load("file2", " ", "string");
		FileReader filereader = null;
		try {
			filereader = new FileReader("C:/Users/subh/Documents/vijayalaxmi/ass4/" + "file2" + ".txt");
			Scanner scanner = new Scanner(filereader);
			scanner.useDelimiter(" ");
			while (scanner.hasNext() && genericStrList.linkednode != null) {
				assertEquals(scanner.next(), genericStrList.linkednode.getData());
				genericStrList.linkednode = genericStrList.linkednode.getNext();
			}
			scanner.close();

			GenericMyLinkedList<Integer> genericIntList = new GenericMyLinkedList<Integer>();
			genericIntList.linkednode = genericIntList.load("IntFile", " ", "integer");
			filereader = new FileReader("C:/Users/subh/Documents/vijayalaxmi/ass4/" + "IntFile" + ".txt");
			scanner = new Scanner(filereader);
			scanner.useDelimiter(" ");
			while (scanner.hasNext() && genericIntList.linkednode != null) {
				assertEquals(new Integer(scanner.nextInt()), genericIntList.linkednode.getData());
				genericIntList.linkednode = genericIntList.linkednode.getNext();
			}
			scanner.close();

			GenericMyLinkedList<Double> genericlDoubleList = new GenericMyLinkedList<Double>();
			genericlDoubleList.linkednode = genericlDoubleList.load("GenFile3", " ", "double");
			filereader = new FileReader("C:/Users/subh/Documents/vijayalaxmi/ass4/" + "GenFile3" + ".txt");
			scanner = new Scanner(filereader);
			scanner.useDelimiter(" ");
			while (scanner.hasNext() && genericFloatList.linkednode != null) {
				assertEquals(new Double(scanner.nextDouble()), genericlDoubleList.linkednode.getData());
				genericlDoubleList.linkednode = genericlDoubleList.linkednode.getNext();

			}
			scanner.close();

			GenericMyLinkedList<Float> genericFloatList = new GenericMyLinkedList<Float>();
			genericFloatList.linkednode = genericFloatList.load("GenFile4", " ", "float");
			filereader = new FileReader("C:/Users/subh/Documents/vijayalaxmi/ass4/" + "GenFile4" + ".txt");
			scanner = new Scanner(filereader);
			scanner.useDelimiter(" ");
			while (scanner.hasNext() && genericFloatList.linkednode != null) {
				assertEquals(new Float(scanner.nextFloat()), genericFloatList.linkednode.getData());
				genericFloatList.linkednode = genericFloatList.linkednode.getNext();
			}
			scanner.close();
			filereader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}