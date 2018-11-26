package assignm4Recursion;

public class RecursionMyLinkedList<T extends Comparable<T>> {
	public RecursionLinkedNode<T> linkednodeRec;
	RecursionLinkedNode<T> node;

	public RecursionLinkedNode<T> add(T data) {
		if (linkednodeRec == null) {
			linkednodeRec = new RecursionLinkedNode<T>();
			linkednodeRec.setData(data);
		} else {
			linkednodeRec.add(data);
		}
		return linkednodeRec;
	}

	public RecursionLinkedNode<T> getFirst() {
		if (linkednodeRec != null) {
			System.out.println(linkednodeRec.getData());
		}
		return linkednodeRec;
	}

	public RecursionLinkedNode<T> getLast() {
		if (linkednodeRec != null) {
			node = linkednodeRec.getLast();
		}
		return node;
	}

	public RecursionLinkedNode<T> remove() {
		if (linkednodeRec != null) {
			node = linkednodeRec.remove();
		}
		return node;
	}

	public RecursionLinkedNode<T> remove(T data) {
		if (linkednodeRec != null) {
			if (linkednodeRec.getData().equals(data)) {
				linkednodeRec = linkednodeRec.getNext();
			} else {
				linkednodeRec = linkednodeRec.remove(data);
			}
		}
		return linkednodeRec;
	}

	public RecursionLinkedNode<T> removeIndex(int index) {
		if (linkednodeRec != null) {
			node = linkednodeRec.removeIndex(index);
		}
		return node;
	}

	public RecursionLinkedNode<T> find(T data) {
		if (linkednodeRec != null) {
			if (linkednodeRec.getData().equals(data)) {
				node = linkednodeRec.getNext();
			} else {
				node = linkednodeRec.find(data);
			}
		}
		return node;
	}

	public RecursionLinkedNode<T> reverse() {
		if (linkednodeRec != null) {
			node = linkednodeRec.reverse(linkednodeRec, linkednodeRec.getNext());
			linkednodeRec = node;
		}
		return linkednodeRec;
	}

	public RecursionLinkedNode<T> print() {
		if (linkednodeRec != null) {
			linkednodeRec.print();
		}
		return node;
	}

	public RecursionLinkedNode<T> getSort(String condition) {
		if (linkednodeRec != null) {
			linkednodeRec.getSort(condition);
		}
		return linkednodeRec;
	}

	public void clear() {
		linkednodeRec = null;
	}
}