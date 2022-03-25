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
	protected int warranty;
	
	/** */
	protected String name;
	
	/** */
	protected int duration;
	
	/** */
	public int DecreaseWarranty() {
		Skeleton.methodCall(this);
		warranty--;
		Skeleton.methodReturn(this);
		return warranty;
	}
	
	/** */
	public int DecreaseDuration() {
		Skeleton.methodCall(this);
		duration--;
		Skeleton.methodReturn(this);
		return duration;
	}
	
	/** */
	public abstract void Apply(Virologist v);
	
	/** */
	public void Remove(Virologist v) {
		Skeleton.methodCall(this, "v");
		v.RefreshEffects();
		Skeleton.methodReturn(this);
	}

	@Override
	public boolean AddToBackpack(Virologist v, Backpack b) {
		Skeleton.methodCall(this, "v", "b");
		v.GetBackpack().Add(this);
		boolean isAdded = Skeleton.yesOrNoInput("Was added?");
		Skeleton.methodReturn(this);
		return isAdded;
	}

	@Override
	public void RemoveFromBackpack(Virologist v, Backpack b) {
		Skeleton.methodCall(this, "v","b");
		Skeleton.methodReturn(this);
	}
}
