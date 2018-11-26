package assignm4;

import java.io.*;
import java.util.*;

public class LinkedListDriver {
	static int count = 0;
	int index = 0;
	MyLinkedList mylinkedlist = new MyLinkedList();

	public static void main(String[] args) {
		LinkedListDriver driver = new LinkedListDriver();
		if (args.length == 1) {
			driver.mylinkedlist.load(args[0]);
		}
		if (args.length == 2) {
			driver.mylinkedlist.load(args[0], args[1]);
		}
		String choice;
		Scanner scan = new Scanner(System.in);
		choiceMenu();

		while (true) {
			if (count > 0) {
				break;
			}
			choice = scan.nextLine();
			try {
				driver.checkExpression(choice);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		scan.close();
	}

	public static void choiceMenu() {
		System.out.println("enter word to add data");
		System.out.println("enter '>' to sort list in ascending order");
		System.out.println("enter '<'  to sort list in descending order");
		System.out.println("enter '-'  to remove last data from the list");
		System.out.println("enter '-' along with data/Index to remove data/indexed data from the list");
		System.out.println("enter '<<'  to print data in reverse order");
		System.out.println("enter '>>'  to print data in order as given while input");
		System.out.println("enter '>>'  along with name to create a file of that name and load the list values");
		System.out.println("enter '^' to quit");
		System.out.println("enter your choice");
	}

	public void checkExpression(String choice) throws IOException {
		String stringArray[] = choice.split(" ");
		char word = stringArray[0].charAt(0);
		if ((word > 64 && word < 91) || (word > 96 && word < 123)) {
			stringArray[0] = "+";
			index++;
		}
		switch (stringArray[0]) {
		case ("1"):
			mylinkedlist.getFirst();
			break;
		case ("0"):
			mylinkedlist.getLast();
			break;
		case ("+"):
			mylinkedlist.add(choice);
			break;
		case (":"):
			mylinkedlist.print();
			break;
		case ("?"):
			LinkedNode node = mylinkedlist.find(stringArray[1]);
			System.out.println(node.getData());
			break;
		case (">"):
			mylinkedlist.getSort("ASC");
			mylinkedlist.print();
			break;
		case ("<"):
			mylinkedlist.getSort("DESC");
			mylinkedlist.print();
			break;
		case ("-"):
			if (choice.length() == 1) {
				mylinkedlist.remove();
			} else if (choice.length() > 1) {
				char secondWord = stringArray[1].charAt(0);
				if (secondWord > 47 && secondWord < 58) {
					mylinkedlist.remove((int) secondWord - 48);
				} else {
					mylinkedlist.remove(stringArray[1]);
				}
			}
			mylinkedlist.print();
			break;
		case (">>"):
			if (stringArray.length == 1) {
				mylinkedlist.print();
			} else {
				String filename = choice.substring(3);
				mylinkedlist.createFile(filename);
				mylinkedlist.print();
			}
			break;
		case ("<<"):
			mylinkedlist.reverse();
			mylinkedlist.print();
			break;
		case ("%"):
			mylinkedlist.clear();
			break;
		case ("^"):
			count++;
			break;
		default:
			System.out.println("invalid expression");
		}
	}
}