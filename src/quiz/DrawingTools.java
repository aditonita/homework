package quiz;

import java.util.ArrayList;
import java.util.List;

public class DrawingTools {

	List<Shape> allShapes = new ArrayList<Shape>();

	public double sumPerimeter() {
		double sum = 0;
		for (Shape s : allShapes) {
			sum += s.getPerimeter();
		}
		return sum;
	}

	public double sumSurface() {
		double sum = 0;
		for (Shape s : allShapes) {
			sum += s.getSurface();
		}
		return sum;
	}

	public void addShape(Shape shape) {
		if (!shapeExist(shape)) { // imi place ca ai facut metoda shapeExist
									//alternativ, acum stii ca poti folosi contains din List
			allShapes.add(shape);
		} else {
			System.out.println("Shape " + shape.getClass().getName() + " exist in list");
		}
	}

	private boolean shapeExist(Shape shape) {
//		boolean exist = false;
//		for (Shape s : allShapes) {
//			if (s.equals(shape)) {
//				exist = true;
//			} else {
//				exist = false;
//			}
//		}
//		return exist;

		// alternativa, cu exact aceeasi logica implementata de tine
		for (Shape s : allShapes) {
			if (s.equals(shape)) {
				return true;
			}
		}
		return false;

	}

}
