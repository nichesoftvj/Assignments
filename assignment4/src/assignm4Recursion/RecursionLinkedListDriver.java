package assignm4Recursion;

import java.io.*;
import java.util.*;

public class RecursionLinkedListDriver {
	static int count = 0;
	int index = 0;
	RecursionMyLinkedList<String> recursionMyLinkedList = new RecursionMyLinkedList<String>();
	public static void main(String[] args) throws IOException {

		RecursionLinkedListDriver recursionDriver = new RecursionLinkedListDriver();
		String choice;
		Scanner scan = new Scanner(System.in);
		choiceMenu();

		while (true) {
			if (count > 0) {
				break;
			}
			choice = scan.nextLine();
			recursionDriver.checkExpression(choice);
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
		case ("%"):
			recursionMyLinkedList.clear();
			break;
		case ("1"):
			recursionMyLinkedList.getFirst();
			break;
		case ("0"):
			RecursionLinkedNode<String> node = recursionMyLinkedList.getLast();
			System.out.println(node.getData());
			break;
		case ("+"):
			recursionMyLinkedList.linkednodeRec = recursionMyLinkedList.add(choice);
			break;
		case (":"):
			recursionMyLinkedList.print();
			break;
		case ("?"):
			RecursionLinkedNode<String> node1 = recursionMyLinkedList.find(stringArray[1]);
			if (node1 == null) {
				System.out.println(node1);
			} else {
				System.out.println(node1.getData());
			}
			break;
		case (">"):
			recursionMyLinkedList.getSort("ASC");
			recursionMyLinkedList.print();
			break;
		case ("<"):
			recursionMyLinkedList.getSort("DESC");
			recursionMyLinkedList.print();
			break;
		case ("-"):
			if (choice.length() == 1) {
				recursionMyLinkedList.remove();
			} else if (choice.length() > 1) {
				char secondWord = stringArray[1].charAt(0);
				if (secondWord > 47 && secondWord < 58) {
					recursionMyLinkedList.removeIndex((int) secondWord - 48);
				} else {
					recursionMyLinkedList.remove(stringArray[1]);
				}
			}
			recursionMyLinkedList.print();
			break;
		case (">>"):
			if (stringArray.length == 1) {
				recursionMyLinkedList.print();
			} 
			break;
		case ("<<"):
			recursionMyLinkedList.reverse();
			recursionMyLinkedList.print();
			break;
		case ("^"):
			count++;
			break;
		default:
			System.out.println("invalid expression");
		}
	}
}