package main;

import java.util.ArrayList;
import java.util.Scanner;
import assets.virologist.behavior.dropbehavior.*;
import assets.virologist.behavior.getinfectedbehavior.InfectBack;
import assets.virologist.behavior.getinfectedbehavior.MaybeInfected;
import assets.virologist.behavior.getinfectedbehavior.NotInfected;
import assets.virologist.behavior.getstolenbehavior.*;
import assets.virologist.behavior.learnbehavior.*;
import assets.virologist.behavior.movebehavior.*;
import assets.field.*;
import assets.virologist.*;
import assets.virologist.behavior.pickupbehavior.PickUp;
import collectables.Collectable;
import collectables.agent.Chorea;
import collectables.agent.Oblivion;
import collectables.agent.Paralysis;
import collectables.agent.Protection;
import collectables.genome.*;
import collectables.equipment.*;
import collectables.material.Aminoacid;
import collectables.material.Materials;
import collectables.material.Nucleotide;

/**
 * The main.Skeleton class helps test the Use-Cases. The class can be used for testing
 * through the console, where we can run specific use cases by inputting their number.
 * @author Milan_Nyist
 */
public class Skeleton {
    /** Keeps count of how many tabs deep we are currently.*/
    private static int tabNum = 0;
    /** Helps with scanning user input from the console.*/
    private static final Scanner scanner = new Scanner(System.in);
    /** The main use case options that the user can select from.*/
    private final String[] menu = {
            "1. Move To Field",
            "2. Move To Laboratory",
            "3. Take Aminoacid...",
            "4. Take Equipment...",
            "5. Drop Materials",
            "6. Drop Sack",
            "7. Learn",
            "8. Create Agent",
            "9. Steal",
            "10. Infect With...",
            "11. Infect Virologist that has...",
            "12. End Turn and...",
            "13. Exit This Program"
    };
    /**When the user enters 4. for the main option, and decides that his/her bag is not full, these sub-options pop up.*/
    private final String[] takeEquipmentOptions = {
            "1. Sack",
            "2. Cloak",
            "3. Gloves"
    };
    /** When the user enters 10. for the main option, these sub-options pop up.*/
    private final String[] agents = {
            "1. Oblivion",
            "2. Chorea",
            "3. Protection",
            "4. Paralysis"
    };
    /** When the user enters 11. for the main option, these sub-options pop up.*/
    private final String[] protections = {
            "1. Protected agent",
            "2. Cloak",
            "3. Gloves",
            "4. Gloves and you have Gloves as well"
    };
    /** When the user enters 12. for the main option, these sub-options pop up.*/
    private final String[] endings = {
            "1. doesn't remove anything",
            "2. remove applied Oblivion",
            "3. remove not applied Oblivion"
    };

    /** Constructor.*/
    public Skeleton(){}

    /**
     * The main method, that runs a loop as long as the user
     * is testing different use-cases.
     */
    public static void main(String[] args){
        boolean running = true;
        while(running){
            Skeleton skeleton = new Skeleton();
            running = skeleton.run();
        }
    }

    /** Indents on the console by tabNum times.*/
    public static void indent(){
        for (int i = 0; i < tabNum; i++){
            System.out.print("\t");
        }
    }

    /** A simple print method that gets indented by tabNum times.*/
    public static void printWithIndent(String message){
        indent();
        System.out.println(message);
    }

    /**
     * Prints out the class, current method and parameter names that the program is running.
     * Example: ->field.virologist.Virologist.CreateAgent(collectables.agent.Oblivion)
     * This method should be called at the start of every use-case testing method.
     *
     * @param sender reference to the class where the method was called.
     * @param parameters names of the parameters the method got.
     */
    public static void methodCall(Object sender, String... parameters){
        ++tabNum;
        indent();

        Exception e = new Exception();
        e.fillInStackTrace();

        String result = "->" + sender.getClass().getSimpleName();
        String methodName = e.getStackTrace()[1].getMethodName();
        result += "." + methodName + "(";
        if (parameters.length != 0){
            for (String parameter : parameters){
                result += parameter + ", ";
            }
            result = result.substring(0, result.length() - 2); // minus ", "
        }
        result += ")";
        System.out.println(result);
    }

    /**
     * Prints out the class, current method and parameter names that the program is running.
     * Example: <-field.virologist.Virologist.CreateAgent()
     * This method should be called when we are about to return from the method we are testing.
     *
     * @param sender reference to the class where the method was called.
     */
    public static void methodReturn(Object sender){
        indent();

        Exception e = new Exception();
        e.fillInStackTrace();

        String result = "<-" + sender.getClass().getSimpleName();
        String methodName = e.getStackTrace()[1].getMethodName();
        result += "." + methodName + "()";

        System.out.println(result);
        --tabNum;
    }

    /**
     * Prints the given message to the console, and waits for a YES/NO response
     * from the user.
     *
     * @param message the message we would like to display on the console. (Should be a yes/no question)
     * @return the response in boolean form.
     */
    public static boolean yesOrNoInput(String message) {
        while (true){
            indent();
            System.out.print("? " + message + " (Y/N): ");
            String answer = scanner.next();
            if (answer.equalsIgnoreCase("y"))
                return true;
            if (answer.equalsIgnoreCase("n"))
                return false;
        }
    }

    /**
     * Prints the given message to the console, and waits for an integer
     * from the user. The message pops up as long as the user does not
     * give an integer as an input.
     *
     * @param message the message we would like to display on the console.
     * @return the users input.
     */
    public static int askForInput(String message) {
        while (true){
            indent();
            System.out.print(message);
            if (scanner.hasNextInt())
                return scanner.nextInt();
            scanner.next();
        }
    }

    /**
     * Prints the given message to the console, and waits for an integer,
     * in a given range from the user. The message pops up as long as
     * the user does not give an integer as an input.
     *
     * @param message the message we would like to display on the console.
     * @param min the smallest acceptable value of the users input.
     * @param max the biggest acceptable value of the users input.
     * @return the users input.
     */
    public static int askForInput(String message, int min, int max) {
        while (true){
            int answer = askForInput(String.format("%s (%d-%d): ", message, min, max));
            if (min <= answer && answer <= max)
                return answer;
        }
    }

    /**
     * Prints out all the items in an array to the console.
     *
     * @param list array containing strings that will be printed.
     */
    public void printList(String[] list){
        for (String item : list){
            System.out.println(item);
        }
    }

    /**
     * A loop where we display all the use-case options
     * on the console and run each use-case the user selects.
     *
     * @return signals if we exit the program or not.
     */
    public boolean run(){
        while(true){
            System.out.println();
            printList(menu);
            int input = askForInput("Input a number", 1, 13);
            System.out.println("\n" + menu[input - 1]);
            switch(input){
                case 1:
                    moveToField();
                    break;
                case 2:
                    moveToLaboratory();
                    break;
                case 3:
                    if (yesOrNoInput("Do you have enough space?"))
                        takeAminoacid();
                    else
                        takeMaterialsNotEnoughSpace();
                    break;
                case 4:
                    if (yesOrNoInput("Do you have enough space?")){
                        printList(takeEquipmentOptions);
                        int takeEq = askForInput("Input a number", 1, 3);
                        System.out.println("\n" + takeEquipmentOptions[takeEq - 1]);
                        switch (takeEq) {
                            case 1 :
                                takeSack();
                                break;
                            case 2 :
                                takeCloak();
                                break;
                            case 3 :
                                takeGloves();
                                break;
                        }
                    }
                    else
                        takeEquipmentNotEnoughSpace();
                    break;
                case 5:
                    dropMaterials();
                    break;
                case 6:
                    if (yesOrNoInput("Do you have more Materials than you can store in a normal sized Backpack?"))
                        dropSackNotEnoughSpace();
                    else
                        dropSack();
                    break;
                case 7:
                    learn();
                    break;
                case 8:
                    if (yesOrNoInput("Do you have enough materials to create an Agent?"))
                        createAgent();
                    else
                        createAgentWithNotEnoughMaterial();
                    break;
                case 9:
                    steal();
                    break;
                case 10:
                    printList(agents);
                    int agent = askForInput("What agent would you like to infect with?", 1, 4);
                    System.out.println("\n" + agents[agent - 1]);
                    switch (agent) {
                        case 1 :
                            infectWithOblivion();
                            break;
                        case 2:
                            infectWithChorea();
                            break;
                        case 3 :
                            infectWithProtection();
                            break;
                        case 4:
                            infectWithParalysis();
                            break;
                    }
                    break;
                case 11:
                    printList(protections);
                    int protection = askForInput("What kind of protection the other field.virologist has?", 1, 4);
                    System.out.println("\n" + protections[protection - 1]);
                    switch (protection) {
                        case 1 :
                            infectProtectedVirologist();
                            break;
                        case 2 :
                            infectVirologistWithCloak();
                            break;
                        case 3 :
                            infectVirologistWithGloves();
                            break;
                        case 4 :
                            infectVirologistWithGlovesAndYouHaveGlovesToo();
                            break;

                    }
                    break;
                case 12:
                    printList(endings);
                    int ending = askForInput("Do you need to remove any agents after ending your turn?", 1, 3);
                    System.out.println("\n" + endings[ending - 1]);
                    switch (ending) {
                        case 1 :
                            endTurnAndNoRemove();
                            break;
                        case 2 :
                            endTurnAndRemoveOblivionFromAppliedAgents();
                            break;
                        case 3 :
                            endTurnAndRemoveOblivionFromNotAppliedAgents();
                            break;
                    }
                    break;
                case 13:
                    return false;
            }
        }
    }

   public void moveToField(){
        Field f1 = new Normal();
        Virologist v = new Virologist();
        v.SetState(State.BEFORE_MOVE);
        v.SetMoveBehavior(new Move());
        v.GetRoute().Add(f1);
        Field f2 = new Normal();
        f1.SetNeighbour(f2);
        f2.SetNeighbour(f1);
        v.Move(1);
    }
    public void moveToLaboratory(){
        Field f1 = new Normal();
        Virologist v = new Virologist();
        v.GetRoute().Add(f1);
        Field f2 = new Laboratory(new GenomeChorea());
        f1.SetNeighbour(f2);
        f2.SetNeighbour(f1);
        v.SetState(State.BEFORE_MOVE);
        v.Move(1);
    }
    public void takeAminoacid(){
        Virologist v = new Virologist();
        Materials a1 = new Aminoacid();
        Materials a2 = new Aminoacid();
        Field f = new Normal();


    }
    public void takeSack(){}
    public void takeCloak(){}
    public void takeGloves(){}
    public void takeMaterialsNotEnoughSpace(){}
    public void takeEquipmentNotEnoughSpace(){}
    public void dropMaterials(){
        Field f1 = new Normal();
        Virologist v = new Virologist();
        v.SetState(State.BEFORE_ACTION);
        v.GetRoute().Add(f1);
        v.SetDropBehavior(new Drop());
        Aminoacid aminoacid = new Aminoacid();
        v.GetBackpack().Add(aminoacid);
        ArrayList<Collectable> aminoList = new ArrayList<>();
        aminoList.add(aminoacid);
        v.DropCollectable(aminoList);
    }

    public void dropSack(){
        Field f1 = new Normal();
        Virologist v = new Virologist();
        v.SetState(State.BEFORE_ACTION);
        v.GetRoute().Add(f1);
        Sack sack = new Sack();
        v.GetBackpack().Add(sack);
        ArrayList<Collectable> sackList = new ArrayList<>();
        sackList.add(sack);
        v.DropCollectable(sackList);
    }

    public void dropSackNotEnoughSpace(){
        Virologist v = new Virologist();
        Equipment sack = new Sack();
        Field f = new Normal();
        f.getBackpack().Add(sack);
        v.GetRoute().Add(f);
        v.SetState(State.BEFORE_ACTION);
        v.SetPickUpBehavior(new PickUp());
        ArrayList<Collectable> sackList = new ArrayList<>();
        sackList.add(sack);
        v.PickUpCollectable(sackList);
        for(int i = 0; i < 6; i++){
            v.GetBackpack().Add(new Aminoacid());
        }
        for(int i = 0; i < 6; i++){
            v.GetBackpack().Add(new Nucleotide());
        }
        v.DropCollectable(sackList);
    }
    public void learn(){
        Field f1 = new Normal();
        Virologist v = new Virologist();
        v.GetRoute().Add(f1);
        v.SetLearnBehavior(new Learn());
        v.SetState(State.BEFORE_ACTION);
        v.Learn();
    }
    public void createAgent(){
        Virologist v = new Virologist();
        for(int i = 0; i<4; i++){
            v.GetBackpack().Add(new Aminoacid());
            v.GetBackpack().Add(new Nucleotide());
        }
        v.SetState(State.BEFORE_ACTION);
        v.CreateAgent(new GenomeProtection());

    }
    public void createAgentWithNotEnoughMaterial(){
        Virologist v = new Virologist();
        v.SetState(State.BEFORE_ACTION);
        v.CreateAgent(new GenomeProtection());
    }
    public void steal(){
        Virologist v1 = new Virologist();
        Virologist v2 = new Virologist();

        v2.SetGetStolenBehavior(new GetStolen());
        Cloak cloak = new Cloak();
        v2.GetBackpack().Add(cloak);
        ArrayList<Collectable> cloakList = new ArrayList<>();
        v1.Steal(v2,cloakList);

    }
    public void infectWithOblivion(){
        Virologist v1 = new Virologist();
        v1.SetState(State.BEFORE_ACTION);
        Virologist v2 = new Virologist();
        v2.SetState(State.NOT_IN_TURN);
        Oblivion oblivion = new Oblivion();
        v1.GetBackpack().Add(oblivion);
        v1.Infect(v2,oblivion);

    }
    public void infectWithChorea(){
        Virologist v1 = new Virologist();
        v1.SetState(State.BEFORE_ACTION);
        Virologist v2 = new Virologist();
        v2.SetState(State.NOT_IN_TURN);
        Chorea chorea = new Chorea();
        v1.GetBackpack().Add(chorea);
        v1.Infect(v2,chorea);
    }
    public void infectWithProtection(){
        Virologist v1 = new Virologist();
        v1.SetState(State.BEFORE_ACTION);
        Virologist v2 = new Virologist();
        v2.SetState(State.NOT_IN_TURN);
        Protection protection = new Protection();
        v1.GetBackpack().Add(protection);
        v1.Infect(v2,protection);
    }
    public void infectWithParalysis(){
        Virologist v1 = new Virologist();
        v1.SetState(State.BEFORE_ACTION);
        Virologist v2 = new Virologist();
        v2.SetState(State.NOT_IN_TURN);
        Paralysis paralysis = new Paralysis();
        v1.GetBackpack().Add(paralysis);
        v1.Infect(v2,paralysis);
    }
    public void infectProtectedVirologist(){
        Virologist v1 = new Virologist();
        v1.SetState(State.BEFORE_ACTION);
        Virologist v2 = new Virologist();
        v2.SetState(State.NOT_IN_TURN);
        v2.SetGetInfectedBehavior(new NotInfected());
        Paralysis paralysis = new Paralysis();
        v1.GetBackpack().Add(paralysis);
        v1.Infect(v2,paralysis);
    }
    public void infectVirologistWithCloak(){
        Virologist v1 = new Virologist();
        v1.SetState(State.BEFORE_ACTION);
        Virologist v2 = new Virologist();
        v2.SetState(State.NOT_IN_TURN);
        v2.SetGetInfectedBehavior(new MaybeInfected());
        Paralysis paralysis = new Paralysis();
        v1.GetBackpack().Add(paralysis);
        v1.Infect(v2,paralysis);
    }
    public void infectVirologistWithGloves(){
        Virologist v1 = new Virologist();
        v1.SetState(State.BEFORE_ACTION);
        Virologist v2 = new Virologist();
        v2.SetState(State.NOT_IN_TURN);
        v2.SetGetInfectedBehavior(new InfectBack());
        Paralysis paralysis = new Paralysis();
        v1.GetBackpack().Add(paralysis);
        v1.Infect(v2,paralysis);
    }
    public void infectVirologistWithGlovesAndYouHaveGlovesToo(){
        Virologist v1 = new Virologist();
        v1.SetState(State.BEFORE_ACTION);
        Virologist v2 = new Virologist();
        v2.SetState(State.NOT_IN_TURN);
        v1.SetGetInfectedBehavior(new InfectBack());
        v2.SetGetInfectedBehavior(new InfectBack());
        Paralysis paralysis = new Paralysis();
        v1.GetBackpack().Add(paralysis);
        v1.Infect(v2,paralysis);

    }
    public void endTurnAndNoRemove(){
        Virologist v1 = new Virologist();
        Paralysis paralysis = new Paralysis();
        v1.GetBackpack().Add(paralysis);
        Chorea chorea = new Chorea();
        v1.GetBackpack().AddApplied(chorea);
        v1.EndTurn();
    }
    public void endTurnAndRemoveOblivionFromAppliedAgents(){
        Virologist v1 = new Virologist();
        Oblivion oblivion= new Oblivion();
        v1.GetBackpack().AddApplied(oblivion);
        v1.EndTurn();
    }
    public void endTurnAndRemoveOblivionFromNotAppliedAgents(){
        Virologist v1 = new Virologist();
        Oblivion oblivion= new Oblivion();
        v1.GetBackpack().Add(oblivion);
        for(int i = 0; i < 5; i++){
            v1.EndTurn();
        }
    }
}
