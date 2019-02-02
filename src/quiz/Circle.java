package quiz;

public class Circle implements Shape {

	int r;

	public Circle(int r) {
		this.r = r;
	}

	@Override
	public double getPerimeter() {

		return 2 * Math.PI * r;
	}

	@Override
	public double getSurface() {

		return Math.PI * r * r;
	}

	@Override
	public boolean equals(Shape s) {
		boolean isEqual = false;
//		if (s.getClass().getName() == this.getClass().getName()) {
			if (s instanceof Circle) {
				if (((Circle) s).getR() == this.r) {
					isEqual = true;
				}
			}
//		}
		return isEqual;
	}

	public int getR() {
		return r;
	}
}
