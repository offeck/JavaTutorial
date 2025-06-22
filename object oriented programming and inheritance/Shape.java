/**
 * Represent a geometrical shape.
 */
public interface Shape {
	/**
	 * Get the name of the shape
	 */
	public String name();
	/**
	 * Get the area of the shape
	 */
	public double area();
	/**
	 * Get the perimeter of the shape
	 */
	public double perimeter();

}