package main;

import java.util.ArrayList;
import java.util.Scanner;
import assets.virologist.behavior.createbehavior.*;
import assets.virologist.behavior.dropbehavior.*;
import assets.virologist.behavior.getinfectedbehavior.*;
import assets.virologist.behavior.getstolenbehavior.*;
import assets.virologist.behavior.infectbehavior.*;
import assets.virologist.behavior.learnhevior.*;
import assets.virologist.behavior.movebehavior.*;
import assets.virologist.behavior.pickupbehavior.*;
import assets.virologist.behavior.stealbehavior.*;
import assets.field.*;
import assets.virologist.*;
import collectables.Collectable;
import collectables.agent.*;
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
            "1. field.virologist.behavior.movebehavior.Move To field.field.Field",
            "2. field.virologist.behavior.movebehavior.Move To field.field.Laboratory",
            "3. Take collectables.material.Aminoacid...",
            "4. Take collectables.equipment.Equipment...",
            "5. field.virologist.behavior.dropbehavior.Drop collectables.material.Materials",
            "6. field.virologist.behavior.dropbehavior.Drop collectables.equipment.Sack",
            "7. field.virologist.behavior.learnhevior.Learn",
            "8. field.virologist.behavior.createbehavior.Create collectables.agent.Agent",
            "9. field.virologist.behavior.stealbehavior.Steal",
            "10. field.virologist.behavior.infectbehavior.Infect With...",
            "11. field.virologist.behavior.infectbehavior.Infect field.virologist.Virologist that has...",
            "12. End Turn and...",
            "13. Exit This Program"
    };
    /**When the user enters 4. for the main option, and decides that his/her bag is not full, these sub-options pop up.*/
    private final String[] takeEquipmentOptions = {
            "1. collectables.equipment.Sack",
            "2. collectables.equipment.Cloak",
            "3. collectables.equipment.Gloves"
    };
    /** When the user enters 10. for the main option, these sub-options pop up.*/
    private final String[] agents = {
            "1. collectables.agent.Oblivion",
            "2. collectables.agent.Chorea",
            "3. collectables.agent.Protection",
            "4. collectables.agent.Paralysis"
    };
    /** When the user enters 11. for the main option, these sub-options pop up.*/
    private final String[] protections = {
            "1. Protected agent",
            "2. collectables.equipment.Cloak",
            "3. collectables.equipment.Gloves",
            "4. collectables.equipment.Gloves and you have collectables.equipment.Gloves as well"
    };
    /** When the user enters 12. for the main option, these sub-options pop up.*/
    private final String[] endings = {
            "1. doesn't remove anything",
            "2. remove applied collectables.agent.Oblivion",
            "3. remove not applied collectables.agent.Oblivion"
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
                            case 1 -> takeSack();
                            case 2 -> takeCloak();
                            case 3 -> takeGloves();
                        }
                    }
                    else
                        takeEquipmentNotEnoughSpace();
                    break;
                case 5:
                    dropMaterials();
                    break;
                case 6:
                    if (yesOrNoInput("Can you store your items in your normal backpack?"))
                        dropSack();
                    else
                        dropSackNotEnoughSpace();
                    break;
                case 7:
                    learn();
                    break;
                case 8:
                    if (yesOrNoInput("Do you have enough materials?"))
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
                        case 1 -> infectWithOblivion();
                        case 2 -> infectWithChorea();
                        case 3 -> infectWithProtection();
                        case 4 -> infectWithParalysis();
                    }
                    break;
                case 11:
                    printList(protections);
                    int protection = askForInput("What kind of protection the other field.virologist has?", 1, 4);
                    System.out.println("\n" + protections[protection - 1]);
                    switch (protection) {
                        case 1 -> infectProtectedVirologist();
                        case 2 -> infectVirologistWithCloak();
                        case 3 -> infectVirologistWithGloves();
                        case 4 -> infectVirologistWithGlovesAndYouHaveGlovesToo();
                    }
                    break;
                case 12:
                    printList(endings);
                    int ending = askForInput("Do you need to remove any agents after ending your turn?", 1, 3);
                    System.out.println("\n" + endings[ending - 1]);
                    switch (ending) {
                        case 1 -> endTurnAndNoRemove();
                        case 2 -> endTurnAndRemoveOblivionFromAppliedAgents();
                        case 3 -> endTurnAndRemoveOblivionFromNotAppliedAgents();
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
    public void moveToLaboratory(){}
    public void takeAminoacid(){}
    public void takeSack(){}
    public void takeCloak(){}
    public void takeGloves(){}
    public void takeMaterialsNotEnoughSpace(){}
    public void takeEquipmentNotEnoughSpace(){}
    public void dropMaterials(){
        Field f1 = new Normal();
        Virologist v = new Virologist();
        v.GetRoute().Add(f1);
        v.SetDropBehavior(new Drop());
        Aminoacid aminoacid = new Aminoacid();
        v.GetBackpack().Add(aminoacid);
        ArrayList<Collectable> aminoList = new ArrayList<>();
        aminoList.add(aminoacid);
        v.DropCollectable(aminoList);
    }
    //nincs megírva a táska bővítés
    public void dropSack(){
        Field f1 = new Normal();
        Virologist v = new Virologist();
        v.GetRoute().Add(f1);
        Sack sack = new Sack();
        v.GetBackpack().Add(sack);
        ArrayList<Collectable> sackList = new ArrayList<>();
        sackList.add(sack);
        v.DropCollectable(sackList);
    }
    //nincs megírva a táska bővítés
    public void dropSackNotEnoughSpace(){
        Field f1 = new Normal();
        Virologist v = new Virologist();
        v.GetRoute().Add(f1);


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
        v.GetBackpack().Add(new Aminoacid());
        v.GetBackpack().Add(new Aminoacid());
        v.GetBackpack().Add(new Aminoacid());
        v.GetBackpack().Add(new Aminoacid());
        v.GetBackpack().Add(new Nucleotide());
        v.GetBackpack().Add(new Nucleotide());
        v.GetBackpack().Add(new Nucleotide());
        v.GetBackpack().Add(new Nucleotide());
        v.SetState(State.BEFORE_ACTION);
        v.CreateAgent(new GenomeProtection());

    }
    public void createAgentWithNotEnoughMaterial(){
        Virologist v = new Virologist();
        v.SetState(State.BEFORE_ACTION);
        v.CreateAgent(new GenomeProtection());
    }
    public void steal(){}
    public void infectWithOblivion(){}
    public void infectWithChorea(){}
    public void infectWithProtection(){}
    public void infectWithParalysis(){}
    public void infectProtectedVirologist(){}
    public void infectVirologistWithCloak(){}
    public void infectVirologistWithGloves(){}
    public void infectVirologistWithGlovesAndYouHaveGlovesToo(){}
    public void endTurnAndNoRemove(){}
    public void endTurnAndRemoveOblivionFromAppliedAgents(){}
    public void endTurnAndRemoveOblivionFromNotAppliedAgents(){}
}
