import java.util.Scanner;

/**
 * The Skeleton class helps test the Use-Cases. The class can be used for testing
 * through the console, where we can run specific use cases by inputting their number.
 * @author Milan_Nyist
 */
public class Skeleton {
    /** Keeps count of how many tabs deep we are currently.*/
    private static int tabNum = 0;
    /** Helps with scanning user input from the console.*/
    private static Scanner scanner = new Scanner(System.in);
    /** The main use case options that the user can select from.*/
    private String[] menu = {
            "1. Move To Field",
            "2. Move To Laboratory",
            "3. Take Aminoacid",
            "4. Take Sack",
            "5. Take Cloak",
            "6. Take Gloves",
            "7. Drop Materials",
            "8. Drop Sack",
            "9. Learn",
            "10. Create Agent",
            "11. Steal",
            "12. Infect With...",
            "13. Infect Virologist that has...",
            "14. End Turn and...",
            "15. Exit This Program"
    };
    /** When the user enters 12. for the main option, these sub-options pop up.*/
    private String[] agents = {
            "1. Oblivion",
            "2. Chorea",
            "3. Protection",
            "4. Paralysis"
    };
    /** When the user enters 13. for the main option, these sub-options pop up.*/
    private String[] protections = {
            "1. Protected agent",
            "2. Cloak",
            "3. Gloves",
            "4. Gloves and you have Gloves aswell"
    };
    /** When the user enters 14. for the main option, these sub-options pop up.*/
    private String[] endings = {
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
     * Example: ->Virologist.CreateAgent(Oblivion)
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
     * Example: <-Virologist.CreateAgent()
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
            System.out.printf("? " + message + " (Y/N): ");
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
            System.out.printf(message);
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
        boolean running = true;
        while(running){
            printList(menu);
            int input = askForInput("Input a number", 1, 14);
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
                    if (yesOrNoInput("Do you have enough space?"))
                        takeSack();
                    else
                        takeEquipmentNotEnoughSpace();
                    break;
                case 5:
                    if (yesOrNoInput("Do you have enough space?"))
                        takeCloak();
                    else
                        takeEquipmentNotEnoughSpace();
                    break;
                case 6:
                    if (yesOrNoInput("Do you have enough space?"))
                        takeGloves();
                    else
                        takeEquipmentNotEnoughSpace();
                    break;
                case 7:
                    dropMaterials();
                    break;
                case 8:
                    if (yesOrNoInput("Is there space remaining?"))
                        dropSack();
                    else
                        dropSackNotEnoughSpace();
                    break;
                case 9:
                    learn();
                    break;
                case 10:
                    if (yesOrNoInput("Do you have enough space?"))
                        createAgent();
                    else
                        createAgentWithNotEnoughMaterial();
                    break;
                case 11:
                    steal();
                    break;
                case 12:
                    printList(agents);
                    int agent = askForInput("What agent would you like to infect with?", 1, 4);
                    System.out.println("\n" + agents[agent - 1]);
                    switch(agent){
                        case 1:
                            infectWithOblivion();
                            break;
                        case 2:
                            infectWithChorea();
                            break;
                        case 3:
                            infectWithProtection();
                            break;
                        case 4:
                            infectWithParalysis();
                            break;
                    }
                    break;
                case 13:
                    printList(protections);
                    int protection = askForInput("What agent would you like to infect with?", 1, 4);
                    System.out.println("\n" + protections[protection - 1]);
                    switch(protection){
                        case 1:
                            infectProtectedVirologist();
                            break;
                        case 2:
                            infectVirologistWithCloak();
                            break;
                        case 3:
                            infectVirologistWithGloves();
                            break;
                        case 4:
                            infectVirologistWithGlovesAndYouHaveGlovesToo();
                            break;
                    }
                    break;
                case 14:
                    printList(endings);
                    int ending = askForInput("What agent would you like to infect with?", 1, 3);
                    System.out.println("\n" + endings[ending - 1]);
                    switch(ending){
                        case 1:
                            endTurnAndNoRemove();
                            break;
                        case 2:
                            endTurnAndRemoveOblivionFromAppliedAgents();
                            break;
                        case 3:
                            endTurnAndRemoveOblivionFromNotAppliedAgents();
                            break;
                    }
                    break;
                case 15:
                    return false;
            }
        }
        return true;
    }

    public void moveToField(){}
    public void moveToLaboratory(){}
    public void takeAminoacid(){}
    public void takeSack(){}
    public void takeCloak(){}
    public void takeGloves(){}
    public void takeMaterialsNotEnoughSpace(){}
    public void takeEquipmentNotEnoughSpace(){}
    public void dropMaterials(){}
    public void dropSack(){}
    public void dropSackNotEnoughSpace(){}
    public void learn(){}
    public void createAgent(){}
    public void createAgentWithNotEnoughMaterial(){}
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
