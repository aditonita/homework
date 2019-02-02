package quiz;

public class Triangle implements Shape {

	int a;
	int b;
	int c;

	public Triangle(int a, int b, int c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}

	@Override
	public double getPerimeter() {

		return a + b + c;
	}

	@Override
	public double getSurface() {
		double p = (a + b + c) / 2;
		return Math.sqrt(p * (p - a) * (p - b) * (p - c));
	}

	@Override
	public boolean equals(Shape s) {
		boolean isEqual = false;
		boolean exactA = ((Triangle) s).getA() == this.a;
		boolean exactB = ((Triangle) s).getB() == this.b;
		boolean exactC = ((Triangle) s).getC() == this.c;
//		if (s.getClass().getName() == this.getClass().getName()) {
			if (s instanceof Triangle) {
				if (exactA && exactB && exactC) {
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

	public int getC() {
		return this.c;
	}
}
