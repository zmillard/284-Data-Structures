public class Rectangle extends Shape{
	private double width, height;

	public Rectangle(String name, double w, double h){
		super(name);
		width = w;
		height = h;
	}
	public double getArea(){
		return width*height;
	}
	public double getWidth(){
		return width;
	}
	public double getHeight(){
		return height;
	}
	public void setWidthHeight(double newWidth, double newHeight){
		width = newWidth;
		height = newHeight;
	}
	//static - makes it so you dont need a specific obj, in case it has yet to be defined.
	public static void main(String[] args){
		Rectangle rect1 = new Rectangle("rectagle 1", 1.0, 1.0);

		double rect1Area = rect1.getArea();

		System.out.println(rect1Area);
		System.out.println(rect1);
	}
}