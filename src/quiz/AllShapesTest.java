package quiz;

import static org.junit.Assert.*;

import org.junit.Test;

public class AllShapesTest {

	DrawingTools tool = new DrawingTools();

//	@Before
	public void setUp() {
		Shape rectangle = new Rectangle(4, 7);
		Shape square = new Square(5);
		Shape circle = new Circle(1);
		Shape triangle = new Triangle(1, 2, 3);

		tool.addShape(rectangle);

		tool.addShape(square);

		tool.addShape(circle);

		tool.addShape(triangle);

	}

	@Test
	public void testSumPerimeter() {
		double perimeter;
		setUp();
		perimeter = tool.sumPerimeter();
		assertEquals(54.283185307179586, perimeter,0.5);
	}
	
	@Test
	public void testSumSurface() {
		double surface;
		setUp();
		surface = tool.sumSurface();
		assertEquals(56.1415926535898, surface,0.2);
	}
	@Test
	public void testDuplicate() {
		setUp();
		Shape square = new Square(5);
		tool.addShape(square);
		
	}
}
