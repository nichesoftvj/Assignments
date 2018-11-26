package assignm4Recursion;

public class RecursionLinkedNode<T extends Comparable<T>> {

	private T data;
	private RecursionLinkedNode<T> next;
	RecursionLinkedNode<T> node;

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public RecursionLinkedNode<T> getNext() {
		return next;
	}

	public void setNext(RecursionLinkedNode<T> next) {
		this.next = next;
	}

	public RecursionLinkedNode<T> add(T data2) {
		if (next == null) {
			next = new RecursionLinkedNode<T>();
			next.setData(data2);
		} else {
			next.add(data2);
		}
		return next;
	}

	public RecursionLinkedNode<T> getLast() {
		if (next == null) {
			next = this;
		} else {
			if (next.getNext() != null) {
				next = next.getNext();
				getLast();
			}
		}
		return next;
	}

	public RecursionLinkedNode<T> remove() {
		if (next.getNext().getNext() == null) {
			node = next.getNext();
			next.setNext(null);
		} else if (next.getNext() != null) {
			next.remove();
		}
		return node;
	}

	public RecursionLinkedNode<T> remove(T data2) {
		if (next.getData().equals(data2)) {
			next = next.getNext();
		} else if (next.getNext().getData().equals(data2) && next.getNext().getNext() != null) {
			next.setNext(next.getNext().getNext());
		}
		next.remove();
		return node;
	}

	int count = 1;
	RecursionLinkedNode<T> list;

	public RecursionLinkedNode<T> removeIndex(int index) {
		if (node == null) {
			node = this;
			list = node;
		}
		if (count == index) {
			node = node.getNext();
			list = node;
		} else if (index - count == 1) {
			node.setNext(node.getNext().getNext());
			count++;
		} else {
			node = node.getNext();
			count++;
			removeIndex(index);
		}
		return list;
	}

	public RecursionLinkedNode<T> find(T data2) {
		if (next != null) {
			if (next.getData().equals(data2)) {
				node = next;
			} else if (next.getNext() != null) {
				node = next.find(data2);
			}
		}
		return node;
	}

	public void print() {
		if (node == null) {
			node = this;
		} else {
			System.out.println(node.getData());
			node = node.getNext();
			print();
		}
	}

	public RecursionLinkedNode<T> reverse(RecursionLinkedNode<T> prevNode, RecursionLinkedNode<T> next) {
		while (next.getNext() == null) {
			node = next;
			next.setNext(prevNode);
			return node;
		}
		RecursionLinkedNode<T> nextNode = next.getNext();
		next.setNext(prevNode);
		node = next.reverse(next, nextNode);
		return node;
	}

	public RecursionLinkedNode<T> getSort(String condition) {
		if (node == null) {
			node = this;
		}
		RecursionLinkedNode<T> list1 = node;
		T temp;
		RecursionLinkedNode<T> list2 = list1;
		if (list1.getNext() != null) {
			while (list2 != null) {
				int value = list1.getData().compareTo(list2.getData());
				if ((((condition.equals("ASC") && value >= 1)) || (condition.equals("DESC") && value <= -1))
						&& (value != 0)) {
					temp = list2.getData();
					list2.setData(list1.getData());
					list1.setData(temp);
				}
				list2 = list2.getNext();
			}
			node = node.getNext();
			node.setNext(node.getSort(condition));
		}
		return node;
	}
}