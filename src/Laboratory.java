//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Untitled
//  @ File Name : Laboratory.java
//  @ Date : 2022. 03. 23.
//  @ Author : 
//
//




/** */
public class Laboratory extends Field {
	/** */
	private Genome genome;
	
	/** */
	public Genome GetGenome() {
		Skeleton.methodCall(this, "g");
		Skeleton.methodReturn(this);
		return new GenomeChorea();
	}
	
	/** */
	public void Accept(Virologist v) {
		Skeleton.methodCall(this, "v");
		Skeleton.methodReturn(this);
	}
}
