package quiz;

public class Square implements Shape {

	int a;

	public Square(int a) {
		this.a = a;
	}

	@Override
	public double getPerimeter() {
		return 4 * a;
	}

	@Override
	public double getSurface() {
		return a * a;
	}

	@Override
	public boolean equals(Shape s) {
		boolean isEqual = false;
//		if (s.getClass().getName() == this.getClass().getName()) {
			if (s instanceof Square) {
				if (((Square) s).getA() == this.a) {
					isEqual = true;
				}
			}
//		}
		return isEqual;
	}

	public int getA() {
		return this.a;
	}
}
