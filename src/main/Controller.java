package main;//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Untitled
//  @ File Name : Game.Controller.java
//  @ Date : 2022. 03. 23.
//  @ Author : 
//
//

import assets.field.Field;
import assets.field.Normal;
import assets.virologist.Route;
import assets.virologist.State;
import assets.virologist.Virologist;
import collectables.genome.Genome;

import java.util.ArrayList;

/** Controls the Game and the turns of the players*/
public class Controller implements  java.io.Serializable{
	private static ArrayList<Field> map;
	private static ArrayList<collectables.genome.Genome>  learnableGenomes;
	private static ArrayList<Virologist> virologists;
	/** the next player*/
	private static int index;

	Controller(){
		map = new ArrayList<>();
		learnableGenomes = new ArrayList<>();
		virologists = new ArrayList<>();
	}
	/** */
	public void Start() {
		Skeleton.methodCall(this);
		Field f = new Normal();
		Virologist v = new Virologist();
		index = 0;
		NextPlayer();
		Skeleton.methodReturn(this);
	}

	public static void TestWin(Virologist v){
		if(v.GetLearnedGenomes().size() == learnableGenomes.size()){
			End();
		}
	}

	public static void AddLearnableGenome(Genome g){
			if(!learnableGenomes.contains(g))
				learnableGenomes.add(g);
	}


	/** */
	public static void End() {}
	
	/** Calls the next player and him in which directions can he move*/
	public ArrayList<Integer> NextPlayer() {
		Skeleton.methodCall(this);
		index++;
		Virologist v = virologists.get(index);
		if(v.GetState()==State.KILLED){
			virologists.remove(v);
			v = virologists.get(index);
		}
		Route r = v.GetRoute();
		Field f  = r.GetLocation();
		ArrayList<Integer> d = f.GetDirections();
		v.SetState(State.BEFORE_MOVE);
		Skeleton.methodReturn(this);
		return d;
	}

	/**
	 * Creates a field.
	 * @param type the type of the Field (normal, laboratory etc.)
	 * @param fieldID the ID of the created Field
	 */
	public void CreateField(String type, String fieldID) {
	}

	/**
	 * Makes two Field neighbors.
	 * @param fieldID1 the ID of the first Field
	 * @param fieldID2 the ID of the second Field
	 */
	public void NeighborFields(String fieldID1, String fieldID2) {
	}

	/**
	 * Create a Virologist.
	 * @param name the name of the Virologist
	 * @param fieldID the ID of the Field he will get created to
	 */
	public void CreateVirologist(String name, String fieldID) {
	}

	/**
	 * Puts some Aminoacid on a Field.
	 * @param quantity the number of the Aminoacids
	 * @param fieldID the ID of the Field
	 */
	public void PutAminoacidOnField(int quantity, String fieldID) {
	}

	/**
	 * Puts some Nucleotide on a Field.
	 * @param quantity the number of the Nucleotide
	 * @param fieldID the ID of the Field
	 */
	public void PutNucleotideOnField(int quantity, String fieldID) {
	}

	/**
	 * Put Equipment on a Field.
	 * @param type the type of the Equipment
	 * @param fieldID the ID of the Field
	 */
	public void PutEquipmentOnField(String type, String fieldID) {
	}

	/**
	 * Gives some Aminoacid to a Virologist.
	 * @param quantity the number of the Aminoacids
	 * @param name the name of the Virologist
	 */
	public void GiveAminoacidToVirologist(int quantity, String name) {
	}

	/**
	 * Gives some Nucleotide to a Virologist.
	 * @param quantity the number of the Nucleotide
	 * @param name the name of the Virologist
	 */
	public void GiveNucleotideToVirologist(int quantity, String name) {
	}

	/**
	 * Gives Equipment to a Virologist.
	 * @param type the type of the Equipment
	 * @param name the name of the Virologist
	 */
	public void GiveEquipmentToVirologist(String type, String name) {
	}

	/**
	 * Gives Agent to a Virologist.
	 * @param type the type of the Agent
	 * @param name the name of the Virologist
	 */
	public void GiveAgentToVirologist(String type, String name) {
	}

	/**
	 * Returns the Virologist who has the given name.
	 * @param name the given name
	 * @return the Virologist who has that name
	 */
	public Virologist GetVirologist(String name) {
		return null;
	}

	/**
	 * Returns the current Virologist.
	 * @return the current Virologist
	 */
	public Virologist GetCurrentVirologist() {
		return null;
	}

	/**
	 * Returns a Field that's ID matches the given ID.
	 * @param fieldID the given ID
	 * @return the returned Field
	 */
	public Field GetField(String fieldID) {
		return null;
	}

	/**
	 * Returns the Field the current Virologist is on.
	 * @return the Field
	 */
	public Field GetCurrentField() {
		return null;
	}

	/**
	 * Moves the current Virologist by the given direction.
	 * Calling random functions is forbidden.
	 * @param direction the given direction
	 */
	public void MoveVirologistRandomOff(int direction) {
	}

	/**
	 * Moves the current Virologist by the given direction.
	 * @param direction the given direction
	 */
	public void MoveVirologist(int direction) {
	}

	/**
	 * The current Virologist drops some Aminoacid.
	 * @param quantity the number of Aminoacid
	 */
	public void DropAminoacid(int quantity) {
	}

	/**
	 * The current Virologist drops some Nucleotide.
	 * @param quantity the number of Nucleotide
	 */
	public void DropNucleotide(int quantity) {
	}

	/**
	 * The current Virologist drops an Equipment.
	 * @param index the index of the Equipment in his Backpack
	 */
	public void DropEquipment(int index) {
	}

	/**
	 * The current Virologist takes some Aminoacid.
	 * @param quantity the number of Aminoacid
	 */
	public void TakeAminoacid(int quantity) {
	}

	/**
	 * The current Virologist takes some Nucleotide.
	 * @param quantity the number of Nucleotide
	 */
	public void TakeNucleotide(int quantity) {
	}

	/**
	 * The current Virologist drops an Equipment.
	 * @param index the index of the Equipment in the Field's Backpack
	 */
	public void TakeEquipment(int index) {
	}

	/**
	 * The current Virologist steals some Aminoacid from another Virologist.
	 * @param name the name of the Virologist he steals from
	 * @param quantity the number of the Aminoacid
	 */
	public void StealAminoacid(String name, int quantity) {
	}

	/**
	 * The current Virologist steals some Nucleotide from another Virologist.
	 * @param name the name of the Virologist he steals from
	 * @param quantity the number of the Nucleotide
	 */
	public void StealNucleotide(String name, int quantity) {
	}

	/**
	 * The current Virologist steals Equipment from another Virologist.
	 * @param name the name of the Virologist he steals from
	 * @param index the index of the Equipment in the other Virologist's Backpack
	 */
	public void StealEquipment(String name, int index) {
	}

	/**
	 * The Virologist Learns the Genome of the Laboratory he stands on.
	 */
	public void LearnGenome() {
	}

	/**
	 * Teach a Genome to a Virologist.
	 * @param type the type of the Genome
	 * @param name the name of the Virologist
	 */
	public void TeachGenome(String type, String name) {
	}

	/**
	 * The current Virologist creates a Genome.
	 * @param type the type of the Genome
	 */
	public void CreateAgent(String type) {
	}

	/**
	 * The current Virologist infects a Virologist with an Agent.
	 * @param name the name of the infected Virologist
	 * @param index the index of an Agent in the current Virologist's Backpack
	 */
	public void InfectVirologist(String name, int index) {
	}

	/**
	 * The current Virologist infects a Virologist with an Agent.
	 * Calling random functions is forbidden.
	 * @param name the name of the infected Virologist
	 * @param index the index of an Agent in the current Virologist's Backpack
	 */
	public void InfectVirologistRandomOff(String name, int index) {
	}

	/**
	 * The Controller effects a Virologist with an Agent.
	 * @param type the Agent
	 * @param name the target
	 */
	public void EffectVirologist(String type, String name){

	}
	/**
	 * The current Virologist kills a Virologist.
	 * @param name the name of the killed Virologist.
	 */
	public void KillVirologist(String name) {
	}

	/**
	 * The current Virologist ends his turn.
	 */
	public void EndTurn() {
	}


}
