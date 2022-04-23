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

import assets.field.*;
import assets.virologist.State;
import assets.virologist.Virologist;
import collectables.Collectable;
import collectables.agent.*;
import collectables.equipment.*;
import collectables.genome.*;
import collectables.material.Aminoacid;
import collectables.material.Nucleotide;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import static java.lang.Integer.valueOf;

/**
 * Controls the Game and the turns of the players
 */
public class Controller implements java.io.Serializable {
    private final ArrayList<Field> map;
    private final ArrayList<collectables.genome.Genome> learnableGenomes;
    private final ArrayList<Virologist> virologists;
    /**
     * the player
     */
    private static int index;

    Controller() {
        map = new ArrayList<>();
        learnableGenomes = new ArrayList<>();
        virologists = new ArrayList<>();
    }

    /**
     *
     */
    public void Start() {
        Skeleton.methodCall(this);
        index = virologists.size() - 1;
        NextPlayer();
        Skeleton.methodReturn(this);
    }

    public void ImportMap(String fileName){
        this.ImportFields(fileName);
        this.SetFieldNeighbours(fileName);

    }

    public void ImportFields(String fileName){
        FileReader fr = null;
        try {
            fr = new FileReader(fileName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        BufferedReader br = new BufferedReader(fr);
        while (true) {
            String line = null;
            try {
                line = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (line == null || line.equals("")) break;
            String[] field = line.split(" ");

            if(field[1] == "laboratory"){
                Genome genom = WhichGenome(field[2]);
                Field newField = new Laboratory(genom);
                newField.SetFieldId(field[0]);
            } else {
                Field newField = WhichField(field[1]);
                if(newField == null){
                    break;
                }
                newField.SetFieldId(field[0]);
            }
        }
        try {
            br.close();
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void SetFieldNeighbours(String fileName){
        FileReader fr2 = null;
        try {
            fr2 = new FileReader(fileName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        BufferedReader br2 = new BufferedReader(fr2);
        int id = 0;
        while (true) {
            String line2 = null;
            try {
                line2 = br2.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (line2 == null) break;
            String[] field = line2.split(" ");
            for (int i = 2; i<field.length; i++){
                if(field[1] == "laboratory"){
                    map.get(id).SetNeighbour(searchFieldById(field[i+1]));
                } else {
                    map.get(id).SetNeighbour(searchFieldById(field[i]));
                }

            }
        }
        try {
            br2.close();
            fr2.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Field searchFieldById (String id){
        for (int i=0; i<map.size(); i++){
            if(map.get(i).GetFieldId() == id){
                return map.get(i);
            }
        }
        return null;
    }

    public Field WhichField (String fieldName) {
        if(fieldName.equals("shelter"))
            return new Shelter();
        if(fieldName.equals("warehouse"))
            return new WareHouse();
        if(fieldName.equals("bearlaboratory")) {
            Genome genom = new GenomeChorea();
            return new BearLaboratory(genom);
        }
        if(fieldName.equals("normal"))
            return new Normal();
        return null;
    }

    public Genome WhichGenome (String genomeName) {
        if(genomeName.equals("chorea"))
            return new GenomeChorea();
        if(genomeName.equals("oblivion"))
            return new GenomeOblivion();
        if(genomeName.equals("paralysis"))
            return new GenomeParalysis();
        if(genomeName.equals("protection"))
            return new GenomeProtection();
        return null;
    }

    public void TestWin(Virologist v) {
        if (v.GetLearnedGenomes().size() == learnableGenomes.size()) {
            End();
        }
    }

    public void AddLearnableGenome(Genome g) {
        if (!learnableGenomes.contains(g))
            learnableGenomes.add(g);
    }

    //TODO
    /**
     *
     */
    public void End() {

    }

    /**
     * Calls the next player
     */
    public void NextPlayer() {
        if (virologists.size() - 1 == index) {
            index = 0;
        } else {
            index++;
        }
        Virologist v = virologists.get(index);
        if (v.GetState() == State.KILLED) {
            virologists.remove(v);
            v = virologists.get(index);
        }
        v.SetState(State.BEFORE_MOVE);
    }

    /**
     * Creates a field.
     *
     * @param type    the type of the Field (normal, laboratory etc.)
     * @param fieldID the ID of the created Field
     */
    public void CreateField(String type, String fieldID) {
        Field f;
        switch (type) {
            case "normal":
                f = new Normal();
                break;
            case "shelter":
                f = new Shelter();
                break;
            case "warehouse":
                f = new WareHouse();
                break;
            default:
                return;
        }
        f.SetFieldID(fieldID);
        //f.SetNeighbour(f);
        map.add(f);
    }

    /**
     * Creates a Laboratory
     *
     * @param genome  the Genome that can be learned in the Laboratory
     * @param fieldID the ID of the created Field
     */
    public void CreateLaboratory(String type, String genome, String fieldID) {
        Field f;
        switch (type) {
            case "laboratory":
                f = new Laboratory(StringToGenome(genome));
                break;
            case "bearlaboratory":
                f = new BearLaboratory(StringToGenome(genome));
                break;
            default:
                return;
        }
        AddLearnableGenome(StringToGenome(type));
        f.SetFieldID(fieldID);
        map.add(f);
    }

    /**
     * Makes two Field neighbors.
     *
     * @param fieldID1 the ID of the first Field
     * @param fieldID2 the ID of the second Field
     */
    public void NeighborFields(String fieldID1, String fieldID2) {
        //if (fieldID1.equals(fieldID2)) return;
        Field field1 = GetField(fieldID1);
        Field field2 = GetField(fieldID2);
        field1.SetNeighbour(field2);
        field2.SetNeighbour(field1);
    }

    /**
     * Create a Virologist.
     *
     * @param name    the name of the Virologist
     * @param fieldID the ID of the Field he will get created to
     */
    public void CreateVirologist(String name, String fieldID) {
        Virologist v = new Virologist();
        v.SetName(name);
        Field field = GetField(fieldID);
        v.GetRoute().Add(field);
        field.Accept(v);
        virologists.add(v);
    }

    /**
     * Puts some Aminoacid on a Field.
     *
     * @param quantity the number of the Aminoacids
     * @param fieldID  the ID of the Field
     */
    public void PutAminoacidOnField(int quantity, String fieldID) {
        Field field = GetField(fieldID);
        for (int i = 0; i < quantity; i++)
            field.GetBackpack().Add(new Aminoacid());
    }

    /**
     * Puts some Nucleotide on a Field.
     *
     * @param quantity the number of the Nucleotide
     * @param fieldID  the ID of the Field
     */
    public void PutNucleotideOnField(int quantity, String fieldID) {
        Field field = GetField(fieldID);
        for (int i = 0; i < quantity; i++)
            field.GetBackpack().Add(new Nucleotide());
    }

    /**
     * Put Equipment on a Field.
     *
     * @param type    the type of the Equipment
     * @param fieldID the ID of the Field
     */
    public void PutEquipmentOnField(String type, String fieldID) {
        Field field = GetField(fieldID);
        field.GetBackpack().Add(StringToEquipment(type));
    }

    /**
     * Gives some Aminoacid to a Virologist.
     *
     * @param quantity the number of the Aminoacids
     * @param name     the name of the Virologist
     */
    public void GiveAminoacidToVirologist(int quantity, String name) {
        for (Virologist v : virologists) {
            if (v.GetName().equals(name)) {
                for (int i = 0; i < quantity; i++) {
                    v.GetBackpack().Add(new Aminoacid());
                }
            }
        }
    }

    /**
     * Gives some Nucleotide to a Virologist.
     *
     * @param quantity the number of the Nucleotide
     * @param name     the name of the Virologist
     */
    public void GiveNucleotideToVirologist(int quantity, String name) {
        for (Virologist v : virologists) {
            if (v.GetName().equals(name)) {
                for (int i = 0; i < quantity; i++) {
                    v.GetBackpack().Add(new Nucleotide());
                }
            }
        }
    }

    /**
     * Gives Equipment to a Virologist.
     *
     * @param type the type of the Equipment
     * @param name the name of the Virologist
     */
    public void GiveEquipmentToVirologist(String type, String name) {

        for (Virologist v : virologists) {
            if (v.GetName().equals(name)) {
                Equipment equipment = StringToEquipment(type);
                equipment.Apply(v);
                v.GetBackpack().Add(equipment);
            }
        }
    }

    /**
     * Gives Agent to a Virologist.
     *
     * @param type the type of the Agent
     * @param name the name of the Virologist
     */
    public void GiveAgentToVirologist(String type, String name) {
        for (Virologist v : virologists) {
            if (v.GetName().equals(name)) {
                v.GetBackpack().Add(StringToAgent(type));
            }
        }

    }

    /**
     * Returns the Virologist who has the given name.
     *
     * @param name the given name
     * @return the Virologist who has that name
     */
    public Virologist GetVirologist(String name) {
        for (Virologist v : virologists) {
            if (v.GetName().equals(name)) {
                return v;
            }
        }
        return null;
    }

    /**
     * Returns the current Virologist.
     *
     * @return the current Virologist
     */
    public Virologist GetCurrentVirologist() {
        return virologists.get(index);
    }

    /**
     * Returns a Field that's ID matches the given ID.
     *
     * @param fieldID the given ID
     * @return the returned Field
     */
    public Field GetField(String fieldID) {
        for (Field field : map) {
            if (field.GetFieldID().equals(fieldID))
                return field;
        }
        return null;
    }

    /**
     * Returns the Field the current Virologist is on.
     *
     * @return the Field
     */
    public Field GetCurrentField() {
        return virologists.get(index).GetRoute().GetLocation();
    }

    /**
     * Moves the current Virologist by the given direction.
     * Calling random functions is forbidden.
     *
     * @param direction the given direction
     */
    public void MoveVirologistRandomOff(int direction) {
        virologists.get(index).MoveRandomOff(direction);
    }

    /**
     * Moves the current Virologist by the given direction.
     *
     * @param direction the given direction
     */
    public void MoveVirologist(int direction) {
        GetCurrentVirologist().Move(direction);
    }

    /**
     * The current Virologist drops some Aminoacid.
     *
     * @param quantity the number of Aminoacid
     */
    public void DropAminoacid(int quantity) {
        ArrayList<Collectable> aminos = new ArrayList<>();
        for (int i = 0; i < quantity && i < GetCurrentVirologist().GetBackpack().GetAminos().size(); i++) {
            aminos.add(GetCurrentVirologist().GetBackpack().GetAminos().get(i));
        }
        GetCurrentVirologist().DropCollectable(aminos);
    }

    /**
     * The current Virologist drops some Nucleotide.
     *
     * @param quantity the number of Nucleotide
     */
    public void DropNucleotide(int quantity) {
        ArrayList<Collectable> nucleos = new ArrayList<>();
        for (int i = 0; i < quantity && i < GetCurrentVirologist().GetBackpack().GetNucleotide().size(); i++) {
            nucleos.add(GetCurrentVirologist().GetBackpack().GetNucleotide().get(i));
        }
        GetCurrentVirologist().DropCollectable(nucleos);
    }

    /**
     * The current Virologist drops an Equipment.
     *
     * @param equipmentIndex the index of the Equipment in his Backpack
     */
    public void DropEquipment(int equipmentIndex) {
        ArrayList<Equipment> equipments = GetCurrentVirologist().GetBackpack().GetEquipments();
        Equipment eq = equipments.get(equipmentIndex - 1);
        ArrayList<Collectable> dropped = new ArrayList<>();
        dropped.add(eq);
        GetCurrentVirologist().DropCollectable(dropped);
    }

    /**
     * The current Virologist takes some Aminoacid.
     *
     * @param quantity the number of Aminoacid
     */
    public void TakeAminoacid(int quantity) {
        ArrayList<Collectable> aminos = new ArrayList<>();
        for (int i = 0; i < quantity; i++)
            aminos.add(new Aminoacid());
        GetCurrentVirologist().PickUpCollectable(aminos);
    }

    /**
     * The current Virologist takes some Nucleotide.
     *
     * @param quantity the number of Nucleotide
     */
    public void TakeNucleotide(int quantity) {
        ArrayList<Collectable> nucleotides = new ArrayList<>();
        for (int i = 0; i < quantity; i++)
            nucleotides.add(new Nucleotide());
        GetCurrentVirologist().PickUpCollectable(nucleotides);
    }

    /**
     * The current Virologist takes an Equipment.
     *
     * @param index the index of the Equipment in the Field's Backpack
     */
    public void TakeEquipment(int index) {
        ArrayList<Collectable> pickUp = new ArrayList<>();
        pickUp.add(GetCurrentField().GetBackpack().GetEquipments().get(index - 1));
        GetCurrentVirologist().PickUpCollectable(pickUp);
    }

    /**
     * The current Virologist steals some Aminoacid from another Virologist.
     *
     * @param name     the name of the Virologist he steals from
     * @param quantity the number of the Aminoacid
     */
    public void StealAminoacid(String name, int quantity) {
        Virologist vStealer = GetCurrentVirologist();
        Virologist vPoor = GetVirologist(name);
        ArrayList<Collectable> aminos = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            aminos.add(new Aminoacid());
        }
        vStealer.Steal(vPoor,aminos);
    }

    /**
     * The current Virologist steals some Nucleotide from another Virologist.
     *
     * @param name     the name of the Virologist he steals from
     * @param quantity the number of the Nucleotide
     */
    public void StealNucleotide(String name, int quantity) {
        Virologist vStealer = GetCurrentVirologist();
        Virologist vPoor = GetVirologist(name);
        ArrayList<Collectable> nucleotides = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            nucleotides.add(new Aminoacid());
        }
        vStealer.Steal(vPoor,nucleotides);
    }

    /**
     * The current Virologist steals Equipment from another Virologist.
     *
     * @param name  the name of the Virologist he steals from
     * @param index the index of the Equipment in the other Virologist's Backpack
     */
    public void StealEquipment(String name, int index) {
        Virologist vStealer = GetCurrentVirologist();
        Virologist vPoor = GetVirologist(name);
        ArrayList<Collectable> stolenEq = new ArrayList<>();
        stolenEq.add(GetVirologist(name).GetBackpack().GetEquipments().get(index - 1));
        vStealer.Steal(vPoor,stolenEq);
    }

    /**
     * The Virologist Learns the Genome of the Laboratory he stands on.
     */
    public void LearnGenome() {
        GetCurrentVirologist().Learn();
    }

    /**
     * Teach a Genome to a Virologist.
     *
     * @param type the type of the Genome
     * @param name the name of the Virologist
     */
    public void TeachGenome(String type, String name) {
        GetVirologist(name).Add(StringToGenome(type));
    }

    /**
     * The current Virologist creates an Agent.
     *
     * @param type the type of the Genome
     */
    public void CreateAgent(String type) {
        GetCurrentVirologist().CreateAgent(StringToGenome(type));
    }

    /**
     * The current Virologist infects a Virologist with an Agent.
     *
     * @param name  the name of the infected Virologist
     * @param index the index of an Agent in the current Virologist's Backpack
     */
    public void InfectVirologist(String name, int index) {
        Virologist vInfecter = GetCurrentVirologist();
        Virologist vInfected = GetVirologist(name);
        Agent agent= vInfecter.GetBackpack().GetAgents().get(index-1);
        vInfecter.Infect(vInfected, agent);
    }

    /**
     * The current Virologist infects a Virologist with an Agent.
     * Calling random functions is forbidden.
     *
     * @param name  the name of the infected Virologist
     * @param index the index of an Agent in the current Virologist's Backpack
     */
    //TODO
    public void InfectVirologistRandomOff(String name, int index) {
        Virologist vInfecter = GetCurrentVirologist();
        Virologist vInfected = GetVirologist(name);
        Agent agent= vInfecter.GetBackpack().GetAgents().get(index-1);
        vInfecter.InfectRandomOff(vInfected, agent);
    }

    /**
     * The Controller effects a Virologist with an Agent.
     *
     * @param type the Agent
     * @param name the target
     */
    public void EffectVirologist(String type, String name) {
        Virologist vInfected = GetVirologist(name);
        Agent a = StringToAgent(type);
        a.Apply(vInfected);
        vInfected.GetBackpack().AddApplied(a);

    }

    /**
     * The current Virologist kills a Virologist.
     *
     * @param name the name of the killed Virologist.
     */
    public void KillVirologist(String name) {
        Virologist vKiller = GetCurrentVirologist();
        Virologist vKilled = GetVirologist(name);

        vKiller.KillVirologist(vKilled);
    }

    /**
     * The current Virologist ends his turn.
     */
    public void EndTurn() {
        GetCurrentVirologist().SetState(State.NOT_IN_TURN);
        TestWin(GetCurrentVirologist());
        NextPlayer();
    }
    private Agent StringToAgent(String type){
        Agent a;
        switch (type) {
            case "chorea":
                a = new Chorea();
                break;
            case "oblivion":
                a = new Oblivion();
                break;
            case "paralysis":
                a = new Paralysis();
                break;
            case "protection":
                a = new Protection();
                break;
            case "bear":
                a = new Bear();
                break;
            default:
                return null;
        }
        return a;
    }

    private Genome StringToGenome(String type){
        Genome g;
        switch (type) {
            case "chorea":
                g = new GenomeChorea();
                break;
            case "oblivion":
                g = new GenomeOblivion();
                break;
            case "paralysis":
                g = new GenomeParalysis();
                break;
            case "protection":
                g = new GenomeProtection();
                break;
            default:
                return null;
        }
        return g;
    }

    private Equipment StringToEquipment(String type){
        Equipment eq;
        switch (type) {
            case "axe":
                eq = new Axe();
                break;
            case "cloak":
                eq = new Cloak();
                break;
            case "sack":
                eq = new Sack();
                break;
            case "gloves":
                eq = new Gloves();
                break;
            default:
                return null;
        }
        return eq;
    }
}
