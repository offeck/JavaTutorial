
public class ShapeOperations {

	 // Given two shapes, return the shape with the largest area.
	public static Shape getLargestShape(Shape shape1, Shape shape2) {
		Shape res = shape2;
		if (shape1.area() > shape2.area()) {
			res = shape1;
		}
		return res;
	}

}
