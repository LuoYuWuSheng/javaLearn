package site.luoyu.annotation;


@MethodAnnotation
public class ClassAnnoated {
	
	String field;
	
	public static void getAnnotationField() {
		MethodAnnotation annotation = (MethodAnnotation) ClassAnnoated.class.getAnnotation(MethodAnnotation.class);
		System.out.println(annotation.name());
	}
	
	public static void main(String[] args) {
		ClassAnnoated.getAnnotationField();
	}
}
