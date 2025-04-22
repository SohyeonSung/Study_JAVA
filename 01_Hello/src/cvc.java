
public class cvc {
	public static void main(String[] args) {
		A x = new A();
		x.display();
	}
}


class A {
	A() {
		this(10);
		System.out.print("A");
	}
	A(int x) { System.out.print("B"+x); }
	void display() {System.out.print("C"); }
}

class B extends A {
	B() { System.out.print("D"); }
	B(String m) {System.out.print("E");}
	void display() {System.out.print("F"); }
}

