package assignm4Generic;

import java.io.*;
import java.util.*;

public class GenericLinkedListDriver {
	static int count = 0;
	int index = 0;
	GenericMyLinkedList<String> genericStrList = new GenericMyLinkedList<String>();
	GenericMyLinkedList<Integer> genericIntList = new GenericMyLinkedList<Integer>();
	GenericMyLinkedList<Double> genericDoubleList = new GenericMyLinkedList<Double>();
	GenericMyLinkedList<Float> genericFloatList = new GenericMyLinkedList<Float>();

	public static void main(String[] args) throws IOException {
		GenericLinkedListDriver gendriver = new GenericLinkedListDriver();

		if (args.length == 2) {
			gendriver.genericStrList.load(args[0], args[1], "integer");
		}
		String choice;
		Scanner scan = new Scanner(System.in);
		choiceMenu();
		while (true) {
			if (count > 0) {
				break;
			}
			choice = scan.nextLine();
			gendriver.checkExpression(choice);
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
			genericStrList.clear();
			break;
		case ("1"):
			genericStrList.getFirst();
			break;
		case ("0"):
			genericStrList.getLast();
			break;
		case ("+"):
			genericStrList.add(choice);
			break;
		case (":"):
			genericStrList.print();
			break;
		case ("?"):
			GenericLinkedNode<String> node = genericStrList.find(stringArray[1]);
			System.out.println(node.getData());
			break;
		case (">"):
			genericStrList.getSort("ASC");
			genericStrList.print();
			break;
		case ("<"):
			genericStrList.getSort("DESC");
			genericStrList.print();
			break;
		case ("-"):
			if (choice.length() == 1) {
				genericStrList.remove();
			} else if (choice.length() > 1) {
				char secondWord = stringArray[1].charAt(0);
				if (secondWord > 47 && secondWord < 58) {
					genericStrList.removeInt((int) secondWord - 48);
				} else {
					genericStrList.remove(stringArray[1]);
				}
			}
			genericStrList.print();
			break;
		case (">>"):
			if (stringArray.length == 1) {
				genericStrList.print();
			} else {
				String filename = choice.substring(3);
				genericStrList.createFile(filename);
				genericStrList.print();
			}
			break;
		case ("<<"):
			genericStrList.reverse();
			genericStrList.print();
			break;
		case ("^"):
			count++;
			break;
		default:
			System.out.println("invalid expression");
		}
	}
}