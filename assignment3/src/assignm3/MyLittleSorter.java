package assignm3;

import java.io.*;
import java.util.*;

public class MyLittleSorter {
	int index = 0;
	static int count = 0;
	String array[] = new String[5];

	public static void main(String[] args) throws IOException {
		MyLittleSorter sorter = new MyLittleSorter();
		String command;
		Scanner scan = new Scanner(System.in);
		System.out.println("enter words");
		System.out.println("enter '^' to quit");
		if (args.length == 1) {
			sorter.getWordDelimiter(args[0]);
		} else if (args.length > 1) {
			sorter.getGivenWordDelimiter(args[0], args[1]);
		}
		while (true) {
			if (count > 0) {
				break;
			}
			command = scan.nextLine();
			sorter.checkExpression(command);
		}
		scan.close();
	}

	public String[] checkExpression(String expression) throws IOException {
		String[] result = new String[5];
		String stringArray[] = expression.split(" ");
		char word = stringArray[0].charAt(0);
		if ((word > 64 && word < 91) || (word > 91 && word < 123)) {
			stringArray[0] = "+";
		}
		switch (stringArray[0]) {
		case (">"):
			String ascending[] = getSort("ASC");
			display(ascending, ascending.length);
			result = ascending;
			break;
		case ("<"):
			String descending[] = getSort("DESC");
			display(descending, descending.length);
			result = descending;
			break;
		case ("-"):
			if (stringArray.length == 1) {
				String array1[] = deleteWord(index - 1);
				display(array1, array1.length);
				result = array1;
			} else {
				String deleteWord = stringArray[1];
				int position = -1;
				for (int i = 0; i < index; i++) {
					if (array[i].equals(deleteWord)) {
						position = i;
					}
				}
				if (position != -1) {
					String array2[] = deleteWord(position);
					result = array2;
					display(array2, array2.length);
				} else {
					System.out.println("given word is not present in array");
				}
			}
			break;
		case (">>"):
			if (expression.length() == 2) {
				result = array;
				display(array, array.length);
			} else {
				String filename = expression.substring(3);
				createFile(filename);
				result = array;
			}
			break;
		case ("^"):
			count++;
			break;
		case ("+"):
			addToArray(expression);
			result = array;
			break;
		default:
			System.out.println("invalid expression");
		}
		return result;
	}

	public String[] addToArray(String expression) {
		if (index >= array.length) {
			array = resizeArray(array, expression);
		}
		array[index++] = expression;
		return array;
	}

	public String[] resizeArray(String[] array, String expression) {
		String newStr[] = new String[index + 5];
		for (int i = 0; i < array.length; i++) {
			newStr[i] = array[i];
		}
		array = newStr;
		return array;
	}

	public void display(String[] array, int length) {
		for (int b = 0; b < length; b++) {
			System.out.println(array[b]);
		}
	}

	public String[] getSort(String condition) {
		String temp;
		String[] sortedArray = array.clone();
		for (int i = 0; i < sortedArray.length; i++) {
			for (int m = i; m < sortedArray.length; m++) {
				int value = myCompare(sortedArray[i], sortedArray[m], condition);
				if ((value == 1)) {
					temp = sortedArray[m];
					sortedArray[m] = sortedArray[i];
					sortedArray[i] = temp;
				}
			}
		}
		sortedArray = modificationForNull(sortedArray);
		return sortedArray;
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

	public String[] deleteWord(int wordIndex) {
		String[] modifiedArray = array.clone();
		modifiedArray = modificationForNull(modifiedArray);
		for (int i = 0; i < array.length - 1; i++) {
			if (modifiedArray[i].equals(array[wordIndex])) {
				String temp1 = modifiedArray[i];
				modifiedArray[i] = modifiedArray[i + 1];
				modifiedArray[i + 1] = temp1;
			}
		}
		modifiedArray[modifiedArray.length - 1] = null;
		return modifiedArray;
	}

	public String createFile(String filename) throws IOException {
		String str = "";
		for (int i = 0; i < array.length; i++) {
			str = str + array[i];
			if (i != (array.length - 1)) {
				str = str + " ";
			}
		}
		System.out.println("To an output stream");
		FileOutputStream fout = new FileOutputStream("C:/Users/subh/Documents/vijayalaxmi/ass3/" + filename + ".txt");
		fout.write(str.getBytes());
		System.out.println("File " + filename + " is created and data is printed");
		fout.close();
		return str;
	}

	public String[] modificationForNull(String[] modifiedArray) {
		for (int i = 0; i < array.length - 1; i++) {
			if (modifiedArray[i] == null) {
				String variable = modifiedArray[i];
				modifiedArray[i] = modifiedArray[i + 1];
				modifiedArray[i + 1] = variable;
			}
			if (modifiedArray[i] == null && modifiedArray[i + 1] == null && (i != array.length - 2)) {
				String variable = modifiedArray[i];
				modifiedArray[i] = modifiedArray[i + 2];
				modifiedArray[i + 2] = variable;
			}
		}
		return modifiedArray;
	}

	public String[] getWordDelimiter(String filename) throws IOException {
		String contentArray[] = new String[array.length];
		FileInputStream fin = new FileInputStream("C:/Users/subh/Documents/vijayalaxmi/ass3/" + filename + ".txt");
		Scanner scanner = new Scanner(fin);
		scanner.useDelimiter(" ");
		int i = -1;
		while (scanner.hasNext()) {
			i++;
			String s = scanner.next();
			contentArray[i] = s;
		}
		scanner.close();
		return contentArray;
	}

	public String[] getGivenWordDelimiter(String filename, String delimiter) throws IOException {
		String contentArray[] = new String[array.length + 1];
		FileInputStream fin = new FileInputStream(filename + ".txt");
		Scanner scanner = new Scanner(fin);
		scanner.useDelimiter(delimiter);
		int i = -1;
		while (scanner.hasNext()) {
			i++;
			String s = scanner.next();
			contentArray[i] = s;
		}
		scanner.close();
		return contentArray;
	}
}