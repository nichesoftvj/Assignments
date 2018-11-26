package assignm4Generic;

import java.io.*;
import java.util.*;

public class GenericMyLinkedList<T extends Comparable<T>> {

	public GenericLinkedNode<T> linkednode;
	public GenericLinkedNode<T> add(T data) {
		if (linkednode == null) {
			linkednode = new GenericLinkedNode<T>();
			linkednode.setData(data);
		} else {
			GenericLinkedNode<T> list = linkednode;
			GenericLinkedNode<T> temp = new GenericLinkedNode<T>();
			temp.setData(data);
			while (list.getNext() != null) {
				list = list.getNext();
			}
			list.setNext(temp);
		}
		return linkednode;
	}

	public GenericLinkedNode<T> getFirst() {
		if (linkednode != null) {
			System.out.println(linkednode.getData());
		}
		return linkednode;
	}

	public GenericLinkedNode<T> getLast() {
		GenericLinkedNode<T> list = linkednode;
		if (linkednode != null) {
			while (list.getNext() != null) {
				list = list.getNext();
			}
			System.out.println(list.getData());
		}
		return list;
	}

	public GenericLinkedNode<T> remove() {
		GenericLinkedNode<T> list = linkednode;
		while (list != null) {
			if (list.getNext().getNext() == null) {
				list.setNext(null);
			}
			list = list.getNext();
		}
		return list;
	}

	public GenericLinkedNode<T> remove(T data) {
		GenericLinkedNode<T> list = linkednode;
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

	public GenericLinkedNode<T> removeInt(int index) {
		GenericLinkedNode<T> list = linkednode;
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

	public GenericLinkedNode<T> find(T data) {
		GenericLinkedNode<T> list = linkednode;
		while (list != null) {
			if (list.getData().equals(data)) {
				break;
			}
			list = list.getNext();
		}
		return list;
	}

	public GenericLinkedNode<T> reverse() {
		GenericLinkedNode<T> prevNode = null, nextNode = null;
		GenericLinkedNode<T> curNode = linkednode;
		while (curNode != null) {
			nextNode = curNode.getNext();
			curNode.setNext(prevNode);
			prevNode = curNode;
			curNode = nextNode;
		}
		linkednode = prevNode;
		return linkednode;
	}

	public GenericLinkedNode<T> getSort(String condition) {
		T temp;
		GenericLinkedNode<T> firstlist = linkednode;
		while (firstlist != null) {
			GenericLinkedNode<T> secondlist = firstlist;
			while (secondlist != null) {
				int value = firstlist.getData().compareTo(secondlist.getData());
				if ((((condition.equals("ASC") && value >= 1)) || (condition.equals("DESC") && value <= -1))
						&& (value != 0)) {
					temp = firstlist.getData();
					firstlist.setData(secondlist.getData());
					secondlist.setData(temp);
				}
				secondlist = secondlist.getNext();
			}
			firstlist = firstlist.getNext();
		}
		return linkednode;
	}

	public void print() {
		GenericLinkedNode<T> list = linkednode;
		while (list != null) {
			System.out.println(list.getData());
			list = list.getNext();
		}
		createFile("display");
	}

	public void clear() {
		linkednode = null;
	}

	public GenericLinkedNode<T> createFile(String filename) {
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

	@SuppressWarnings("unchecked")
	public GenericLinkedNode<T> load(String file, String delimiter, String type) {
		T variable = null;
		try {
			FileReader filereader = new FileReader("C:/Users/subh/Documents/vijayalaxmi/ass4/" + file + ".txt");
			Scanner scanner = new Scanner(filereader);
			scanner.useDelimiter(delimiter);
			while (scanner.hasNext()) {
				switch (type) {
				case "string":
					variable = (T) scanner.next();
					break;
				case "double":
					variable = (T) new Double(scanner.nextDouble());
					break;
				case "integer":
					variable = (T) new Integer(scanner.nextInt());
					break;
				case "float":
					variable = (T) new Float(scanner.nextFloat());
					break;
				}
				System.out.println(variable);
				add(variable);
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return linkednode;
	}
}