package site.luoyu.Classes;


public class ChildA extends Parent{
	public String name = "i am childA";
	
	public ChildA() {
		// TODO Auto-generated constructor stub
		System.out.println("ChildA is constructing");
	}
		
	@Override
	public String toString(){
		return "This is Child Saying";
	}
}
