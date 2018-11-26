package assignm4;

import java.util.*;
import java.io.*;

public class MyLinkedList {
	public LinkedNode linkednode;

	public LinkedNode add(String data) {
		if (linkednode == null) {
			linkednode = new LinkedNode();
			linkednode.setData(data);
		} else {
			LinkedNode node = linkednode;
			LinkedNode temp = new LinkedNode();
			temp.setData(data);
			while (node.getNext() != null) {
				node = node.getNext();
			}
			node.setNext(temp);
		}
		return linkednode;
	}

	public LinkedNode getFirst() {
		System.out.println(linkednode.getData());
		return linkednode;
	}

	public LinkedNode getLast() {
		LinkedNode node = linkednode;
		while (node.getNext() != null) {
			node = node.getNext();
		}
		System.out.println(node.getData());
		return node;
	}

	public LinkedNode remove() {
		LinkedNode list = linkednode;
		while (list != null) {
			if (list.getNext().getNext() == null) {
				list.setNext(null);
			}
			list = list.getNext();
		}
		return list;
	}

	public LinkedNode remove(String data) {
		LinkedNode list = linkednode;
		if (linkednode != null) {
			while (list.getNext() != null && (!list.getData().equals(data))) {
				if (list.getNext().getData().equals(data)) {
					list.setNext(list.getNext().getNext());
					break;
				}
				list = list.getNext();
			}
			linkednode = list.getNext();
		}
		return linkednode;
	}

	public LinkedNode remove(int index) {
		LinkedNode list = new LinkedNode();
		int count = 1;
		if (linkednode != null) {
			while (linkednode.getNext() != null) {
				if ((count != index) && (index - count == 1)) {
					linkednode.setNext(linkednode.getNext().getNext());
					break;
				}
				linkednode = linkednode.getNext();
				count++;
			}
			list = linkednode.getNext();
		}
		return list;
	}

	public LinkedNode find(String data) {
		LinkedNode node = null;
		while (linkednode != null) {
			if (linkednode.getData().equals(data)) {
				node = linkednode;
				break;
			}
			linkednode = linkednode.getNext();
		}
		return node;
	}

	public LinkedNode reverse() {
		LinkedNode prevNode = null, nextNode = null;
		LinkedNode curNode = linkednode;
		while (curNode != null) {
			nextNode = curNode.getNext();
			curNode.setNext(prevNode);
			prevNode = curNode;
			curNode = nextNode;
		}
		linkednode = prevNode;
		return linkednode;
	}

	public LinkedNode getSort(String condition) {
		String temp;
		LinkedNode list1 = linkednode;
		while (list1 != null) {
			LinkedNode list2 = linkednode;
			while (list2 != null) {
				int value = myCompare(list1.getData(), list2.getData(), condition);
				if ((value == -1)) {
					temp = list1.getData();
					list1.setData(list2.getData());
					list2.setData(temp);
				}
				list2 = list2.getNext();
			}
			list1 = list1.getNext();
		}
		return linkednode;
	}

	public int myCompare(String value1, String value2, String condition) {
		int value = 0;
		if (!(value1 == null || value2 == null || value1.equals("") || value2.equals(""))) {
			char c1 = value1.charAt(0);
			char c2 = value2.charAt(0);
			if ((int) c1 > (int) c2) {
				value = (condition == "ASC") ? 1 : -1;
			} else if ((int) c1 < (int) c2) {
				value = (condition == "DESC") ? 1 : -1;
			}
		}
		return value;
	}

	public void print() {
		LinkedNode node = linkednode;
		while (node != null) {
			System.out.println(node.getData());
			node = node.getNext();
		}
	}

	public void clear() {
		linkednode = null;
	}

	public LinkedNode createFile(String filename) {
		System.out.println("To an output stream");
		try {
			System.setOut(new PrintStream(
					new FileOutputStream("C:/Users/subh/Documents/vijayalaxmi/ass4/" + filename + ".txt")));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));
		return linkednode;
	}

	public LinkedNode load(String file) {
		String str = null;
		try {
			FileReader filereader = new FileReader("C:/Users/subh/Documents/vijayalaxmi/ass4/" + file + ".txt");
			Scanner scanner = new Scanner(filereader);

			scanner.useDelimiter(" ");
			while (scanner.hasNext()) {
				str = scanner.next();
				System.out.println(str);
				add(str);
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return linkednode;
	}

	public LinkedNode load(String file, String delimiter) {
		String str = null;
		try {
			FileReader filereader = new FileReader("C:/Users/subh/Documents/vijayalaxmi/ass4/" + file + ".txt");
			Scanner scanner = new Scanner(filereader);

			scanner.useDelimiter(delimiter);
			while (scanner.hasNext()) {
				str = scanner.next();
				System.out.println(str);
				add(str);
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return linkednode;
	}
}