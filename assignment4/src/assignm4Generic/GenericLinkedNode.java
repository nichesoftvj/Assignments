package assignm4Generic;

public class GenericLinkedNode<T> {

	T data;
	GenericLinkedNode<T> next;

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public GenericLinkedNode<T> getNext() {
		return next;
	}

	public void setNext(GenericLinkedNode<T> next) {
		this.next = next;
	}

	void showType() {
		System.out.println("Type of T is" + data.getClass().getName());
		System.out.println("Type of V is" + next.getClass().getName());
	}
}
