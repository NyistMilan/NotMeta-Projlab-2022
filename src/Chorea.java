//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Untitled
//  @ File Name : Chorea.java
//  @ Date : 2022. 03. 23.
//  @ Author : 
//
//




/** */
public class Chorea extends Agent {
	Chorea(){
		warranty = baseWarranty;
		duration = effectDuration;
	}
	private static int baseWarranty;
	private static int effectDuration;
	/** */
	public void Apply(Virologist v) {
		Skeleton.methodCall(this, "v");
		v.SetMoveBehavior(new RandomMove());
		Skeleton.methodReturn(this);
	}
}
