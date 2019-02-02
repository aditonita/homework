package quiz;

public class Rectangle implements Shape {
	private int a;
	private int b;

	public Rectangle(int a, int b) {
		this.a = a;
		this.b = b;
	}

	@Override
	public double getPerimeter() {
		return 2 * a + 2 * b;
	}

	@Override
	public double getSurface() {
		return a * b;
	}

	@Override
	public boolean equals(Shape s) {
		boolean isEqual = false;
//		if (s.getClass().getName() == this.getClass().getName()) {
			if (s instanceof Rectangle) {
				if ((((Rectangle) s).getA() == this.a) && (((Rectangle) s).getB() == this.b)) {
					isEqual = true;
				}
			}
//		}

		return isEqual;
	}

	public int getA() {
		return this.a;
	}

	public int getB() {
		return this.b;
	}

}
