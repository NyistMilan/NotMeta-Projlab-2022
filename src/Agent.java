//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Untitled
//  @ File Name : Agent.java
//  @ Date : 2022. 03. 23.
//  @ Author : 
//
//

/** */
public abstract class Agent implements Collectable {
	/** */
	private int warranty;
	
	/** */
	private String name;
	
	/** */
	private int effectDuration;
	
	/** */
	private int duration;
	
	/** */
	public int DecreaseWarranty() {return 0;}
	
	/** */
	public int DecreaseDuration() {return 0;}
	
	/** */
	public abstract void Apply(Virologist v);
	
	/** */
	public abstract void Remove(Virologist v);

	@Override
	public void RemoveFromBackpack(Backpack p) {

	}

	@Override
	public boolean AddToBackpack(Backpack p) {
		return false;
	}
}
