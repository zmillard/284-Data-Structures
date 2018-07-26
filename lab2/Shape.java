public abstract class Shape{
	private String id;

	public Shape (String id){
		this.id = id;
	}

	public abstract double getArea();

	public String getID(){
		return id;
	}

	public String toString(){
		return "Shape[id="+id+",area="+getArea()+"]";
	}

} //abstract, dont need to define how the functions work now, you can define it laters