public class Circle extends Shape{
	double radius;

	public Circle(String name, double r){
		super(name);
		radius = r;
	}
	public double getArea(){
		return Math.pow(radius, 2) * Math.PI;
	}
	public double getRadius(){
		return radius;
	}
	public void setRadius(double newRadius){
		radius = newRadius;
	}

	public String toString(){
		return "Circle[radius= " + radius + " , " +super.toString() + "]";
	}
	//static - makes it so you dont need a specific obj, in case it has yet to be defined.
	public static void main(String[] args){
		Circle circle1 = new Circle("face", 2.5);

		double circle1Area = circle1.getArea();

		System.out.println(circle1Area);
		System.out.println(circle1);
	}
}