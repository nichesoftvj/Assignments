package assignm4;
import static org.junit.Assert.*;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import org.junit.Test;

public class MyLinkedListTest {
	MyLinkedList mylinkedlist = new MyLinkedList();
	
	public void addToList(MyLinkedList mylinkedlist) {
		mylinkedlist.add("aim");
		mylinkedlist.add("get");
		mylinkedlist.add("color");
		mylinkedlist.add("disk");
		mylinkedlist.add("ema");
	}

	@Test
	public void testAdd() {
		MyLinkedList mylinkedlist = new MyLinkedList();
		assertEquals("hello", mylinkedlist.add("hello").getData());
		mylinkedlist.linkednode = mylinkedlist.linkednode.getNext();
		assertEquals("world", mylinkedlist.add("world").getData());
		mylinkedlist.linkednode = mylinkedlist.linkednode.getNext();
		assertEquals("hi", mylinkedlist.add("hi").getData());
		mylinkedlist.linkednode = mylinkedlist.linkednode.getNext();
		assertEquals("okey", mylinkedlist.add("okey").getData());
		mylinkedlist.linkednode = mylinkedlist.linkednode.getNext();
		assertEquals("was", mylinkedlist.add("was").getData());
		mylinkedlist.add(null);
		assertEquals("was", mylinkedlist.add(null).getData());
		mylinkedlist.add(" ");
		assertEquals("was", mylinkedlist.add(null).getData());
	}

	@Test
	public void testGetFirst() {
		MyLinkedList mylinkedlist = new MyLinkedList();
		addToList(mylinkedlist);
		assertEquals("aim", mylinkedlist.getFirst().getData());
		mylinkedlist.remove("aim");
		assertEquals("get", mylinkedlist.getFirst().getData());
		mylinkedlist.remove();
		mylinkedlist.add("sia");
		mylinkedlist.remove("get");
		mylinkedlist.remove("color");
		assertEquals("disk", mylinkedlist.getFirst().getData());
		mylinkedlist.add("kia");
		mylinkedlist.remove("disk");
		mylinkedlist.add("mila");
		assertEquals("sia", mylinkedlist.getFirst().getData());
	}

	@Test
	public void testGetLast() {
		MyLinkedList mylinkedlist = new MyLinkedList();
		addToList(mylinkedlist);
		assertEquals("ema", mylinkedlist.getLast().getData());
		mylinkedlist.add("ges");
		mylinkedlist.add("hello");
		mylinkedlist.add("list");
		assertEquals("list", mylinkedlist.getLast().getData());
		mylinkedlist.remove();
		assertEquals("hello", mylinkedlist.getLast().getData());
		mylinkedlist.add("key");
		mylinkedlist.remove();
		assertEquals("hello", mylinkedlist.getLast().getData());
	}

	@Test
	public void testFind() {
		MyLinkedList mylinkedlist = new MyLinkedList();
		addToList(mylinkedlist);
		assertEquals(null, mylinkedlist.find("are"));
		addToList(mylinkedlist);
		mylinkedlist.add("are");
		assertEquals("get", mylinkedlist.find("get").getData());
		addToList(mylinkedlist);
		mylinkedlist.add("colors");
		assertEquals(null, mylinkedlist.find("qwerty"));
		addToList(mylinkedlist);
		assertEquals(null, mylinkedlist.find(null));
		addToList(mylinkedlist);
		assertEquals(null, mylinkedlist.find(""));
	}

	@Test
	public void testGetRemove() {
		MyLinkedList mylinkedlist = new MyLinkedList();
		assertNull(mylinkedlist.remove());
		addToList(mylinkedlist);
		assertEquals(null, mylinkedlist.remove());
		mylinkedlist.add("fig");
		assertEquals(null, mylinkedlist.remove());
		mylinkedlist.add("ges");
		assertEquals(null, mylinkedlist.remove());
		mylinkedlist.add(null);
		assertEquals(null, mylinkedlist.remove());
	}

	@Test
	public void testGetRemoveString() {
		MyLinkedList mylinkedlist = new MyLinkedList();
		assertNull(mylinkedlist.remove(null));
		addToList(mylinkedlist);
		mylinkedlist.remove("ema");
		assertEquals(null, mylinkedlist.find("ema"));
		mylinkedlist.remove("aim");
		assertEquals(null, mylinkedlist.find("aim"));
		mylinkedlist.remove(null);
		assertEquals(null, mylinkedlist.find(null));
		mylinkedlist.remove("");
		assertEquals(null, mylinkedlist.find(null));
		mylinkedlist.remove("hhxbBh");
		assertEquals(null, mylinkedlist.find(null));
	}

	@Test
	public void testGetRemoveIndex() {
		MyLinkedList mylinkedlist = new MyLinkedList();
		assertNull(mylinkedlist.remove(-1).getData());
		addToList(mylinkedlist);
		mylinkedlist.remove(1);
		assertEquals(null, mylinkedlist.find("aim"));
		mylinkedlist.linkednode=null;
		addToList(mylinkedlist);
		mylinkedlist.remove(2);
		assertEquals(null, mylinkedlist.find("get"));
		mylinkedlist.linkednode=null;
		addToList(mylinkedlist);
		mylinkedlist.remove(5);
		assertEquals(null, mylinkedlist.find("ema"));
		mylinkedlist.linkednode=null;
		addToList(mylinkedlist);
		mylinkedlist.remove(9);
		assertEquals(null, mylinkedlist.find(null));
	}

	@Test
	public void testSort() {
		MyLinkedList mylinkedlist = new MyLinkedList();
		assertNull(mylinkedlist.getSort("ASC"));
		addToList(mylinkedlist);
		mylinkedlist.getSort("ASC");
		assertEquals("aim", mylinkedlist.linkednode.getData());
		mylinkedlist.linkednode = mylinkedlist.linkednode.getNext();
		assertEquals("color", mylinkedlist.linkednode.getData());
		mylinkedlist.linkednode = mylinkedlist.linkednode.getNext();
		assertEquals("disk", mylinkedlist.linkednode.getData());
		mylinkedlist.linkednode = mylinkedlist.linkednode.getNext();
		assertEquals("ema", mylinkedlist.linkednode.getData());
		mylinkedlist.linkednode = mylinkedlist.linkednode.getNext();
		assertEquals("get", mylinkedlist.linkednode.getData());

		mylinkedlist.linkednode = null;
		addToList(mylinkedlist);

		mylinkedlist.linkednode = mylinkedlist.getSort("DESC");
		assertEquals("get", mylinkedlist.linkednode.getData());
		mylinkedlist.linkednode = mylinkedlist.linkednode.getNext();
		assertEquals("ema", mylinkedlist.linkednode.getData());
		mylinkedlist.linkednode = mylinkedlist.linkednode.getNext();
		assertEquals("disk", mylinkedlist.linkednode.getData());
		mylinkedlist.linkednode = mylinkedlist.linkednode.getNext();
		assertEquals("color", mylinkedlist.linkednode.getData());
		mylinkedlist.linkednode = mylinkedlist.linkednode.getNext();
		assertEquals("aim", mylinkedlist.linkednode.getData());
	}

	@Test
	public void testReverse() {
		MyLinkedList mylinkedlist = new MyLinkedList();
		assertNull(mylinkedlist.reverse());
		addToList(mylinkedlist);
		mylinkedlist.linkednode = mylinkedlist.reverse();
		assertEquals("ema", mylinkedlist.linkednode.getData());
		mylinkedlist.linkednode = mylinkedlist.linkednode.getNext();
		assertEquals("disk", mylinkedlist.linkednode.getData());
		mylinkedlist.linkednode = mylinkedlist.linkednode.getNext();
		assertEquals("color", mylinkedlist.linkednode.getData());
		mylinkedlist.linkednode = mylinkedlist.linkednode.getNext();
		assertEquals("get", mylinkedlist.linkednode.getData());
		mylinkedlist.linkednode = mylinkedlist.linkednode.getNext();
		assertEquals("aim", mylinkedlist.linkednode.getData());
	}

	@Test
	public void testCreateFile() {
		MyLinkedList mylinkedlist = new MyLinkedList();
		addToList(mylinkedlist);
		mylinkedlist.createFile("File");
		mylinkedlist.load("File");

		FileReader filereader = null;
		try {
			filereader = new FileReader("C:/Users/subh/Documents/vijayalaxmi/ass4/" + "File" + ".txt");
			Scanner scanner = new Scanner(filereader);
			scanner.useDelimiter(" ");
			while (scanner.hasNext() && mylinkedlist.linkednode != null) {
				assertEquals(scanner.next(), mylinkedlist.linkednode.getData());
				mylinkedlist.linkednode = mylinkedlist.linkednode.getNext();
			}
			scanner.close();
			filereader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testLoad() {
		MyLinkedList mylinkedlist = new MyLinkedList();
		mylinkedlist.linkednode = mylinkedlist.load("file1", "/");
		FileReader filereader = null;
		try {
			filereader = new FileReader("C:/Users/subh/Documents/vijayalaxmi/ass4/" + "file1" + ".txt");
			Scanner scanner = new Scanner(filereader);
			scanner.useDelimiter("/");
			while (scanner.hasNext() && mylinkedlist.linkednode != null) {
				assertEquals(scanner.next(), mylinkedlist.linkednode.getData());
				mylinkedlist.linkednode = mylinkedlist.linkednode.getNext();
			}
			scanner.close();
			filereader.close();

			mylinkedlist.linkednode = mylinkedlist.load("file2");
			filereader = new FileReader("C:/Users/subh/Documents/vijayalaxmi/ass4/" + "file2" + ".txt");
			scanner = new Scanner(filereader);
			scanner.useDelimiter(" ");
			while (scanner.hasNext() && mylinkedlist.linkednode != null) {
				assertEquals(scanner.next(), mylinkedlist.linkednode.getData());
				mylinkedlist.linkednode = mylinkedlist.linkednode.getNext();
			}
			scanner.close();
			filereader.close();

			mylinkedlist.linkednode = mylinkedlist.load("file3", ":");
			filereader = new FileReader("C:/Users/subh/Documents/vijayalaxmi/ass4/" + "file3" + ".txt");
			scanner = new Scanner(filereader);
			scanner.useDelimiter(":");
			while (scanner.hasNext() && mylinkedlist.linkednode != null) {
				assertEquals(scanner.next(), mylinkedlist.linkednode.getData());
				mylinkedlist.linkednode = mylinkedlist.linkednode.getNext();
			}
			scanner.close();
			filereader.close();

			mylinkedlist.linkednode = mylinkedlist.load("file4");
			filereader = new FileReader("C:/Users/subh/Documents/vijayalaxmi/ass4/" + "file4" + ".txt");
			scanner = new Scanner(filereader);
			scanner.useDelimiter(" ");
			while (scanner.hasNext() && mylinkedlist.linkednode != null) {
				assertEquals(scanner.next(), mylinkedlist.linkednode.getData());
				mylinkedlist.linkednode = mylinkedlist.linkednode.getNext();
			}
			scanner.close();
			filereader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}