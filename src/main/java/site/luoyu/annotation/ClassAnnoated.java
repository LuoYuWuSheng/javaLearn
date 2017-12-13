package site.luoyu.annotation;


@MethodAnnotation(name = "test")
public class ClassAnnoated {
	
	String field;
	
	public static void getAnnotationField() {
		MethodAnnotation annotation = ClassAnnoated.class.getAnnotation(MethodAnnotation.class);
		System.out.println(annotation.name());
		System.out.println(annotation.job());
	}
	public static void main(String[] args) {
		ClassAnnoated.getAnnotationField();
	}
}
