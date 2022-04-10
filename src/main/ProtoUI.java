package main;

import assets.field.Field;
import assets.virologist.Virologist;

import java.io.*;

public class ProtoUI {
    public static void main(String[] args){
        boolean running = true;
        Controller controller = new Controller(); //base controller when a test ends this will be in control
        final BufferedReader cbr = new BufferedReader(new InputStreamReader(System.in)); //BufferedReader for the console
        final BufferedWriter cbw = new BufferedWriter(new OutputStreamWriter(System.out)); //BufferedWriter for the console
        Controller ct = controller; //the currently used Controller
        BufferedReader br = cbr; //the currently used BufferedReader
        BufferedWriter bw = cbw; //the currently used BufferedWriter
        while(running){
            try {
                String input = br.readLine();
                String[] command = input.split("\\s+");
                switch (command[0]){
                    case "runTest":
                        ct = new Controller();
                        br = new BufferedReader(new FileReader(command[1]));
                        bw = new BufferedWriter(new FileWriter("testOutput.txt"));
                        break;
                    case "endTest":
                        br = cbr;
                        bw = cbw;
                        ct = controller;
                        BufferedReader expected = new BufferedReader(new FileReader(command[1]));
                        BufferedReader actual = new BufferedReader(new FileReader("testOutput.txt"));
                        int FDL = CompareFiles(expected, actual); //First Different Line
                        if(FDL == -1){
                            bw.write("test succeeded\n");
                        }
                        else{
                            bw.write("test failed at line " + FDL);
                        }
                        break;
                    case "field":
                        ct.CreateField(command[1], command[2]);
                        break;
                    case "neighbor":
                        ct.NeighborFields(command[1], command[2]);
                        break;
                    case "virologist":
                        ct.CreateVirologist(command[1], command[2]);
                        break;
                    case "put":
                        switch (command[1]){
                            case "aminoacid":
                                ct.PutAminoacidOnField(Integer.parseInt(command[2]), command[3]);
                                break;
                            case "nucleotide":
                                ct.PutNucleotideOnField(Integer.parseInt(command[2]), command[3]);
                                break;
                            case "equipment":
                                ct.PutEquipmentOnField(command[2], command[3]);
                                break;
                        }
                        break;
                    case "give":
                        switch (command[1]){
                            case "aminoacid":
                                ct.GiveAminoacidToVirologist(Integer.parseInt(command[2]), command[3]);
                                break;
                            case "nucleotide":
                                ct.GiveNucleotideToVirologist(Integer.parseInt(command[2]), command[3]);
                                break;
                            case "equipment":
                                ct.GiveEquipmentToVirologist(command[2], command[3]);
                                break;
                            case "agent":
                                ct.GiveAgentToVirologist(command[2], command[3]);
                                break;
                        }
                        break;
                    case "show":
                        switch (command[1]){
                            case "virologist":
                                Virologist virologist = ct.GetVirologist(command[2]);
                                ShowVirologist(virologist, bw);
                                break;
                            case "field":
                                assets.field.Field field = ct.GetField(command[2]);
                                ShowField(field, bw);
                                break;
                        }
                        break;
                    case "new":
                        controller = new Controller();
                        ct = controller;
                        bw.write("new game created");
                        break;
                    case "load":
                        Controller loadedGame;
                        try{
                            ObjectInputStream in = new ObjectInputStream(new FileInputStream(command[1]));
                            loadedGame = (Controller) in.readObject();
                            controller = loadedGame;
                            ct = controller;
                            bw.write("game loaded");
                            in.close();
                        }
                        catch (IOException i){
                            i.printStackTrace();
                            break;
                        }
                        catch (ClassNotFoundException c) {
                            System.out.println("Controller class not found");
                            c.printStackTrace();
                            break;
                        }
                        break;
                    case "save":
                        try{
                            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(command[1]));
                            out.writeObject(controller);
                            bw.write("game saved");
                            out.close();
                        }
                        catch (IOException i){
                            i.printStackTrace();
                            break;
                        }
                    case "exit":
                        running = false;
                        break;
                    case "start":
                        ct.Start();
                        break;
                    case "move":
                        if(command[1] == null){
                            Field field = ct.GetCurrentField();
                            ShowDirections(field, bw);
                            break;
                        }
                        if(command[1].equals("randomoff")){
                            ct.MoveVirologistRandomOff(Integer.parseInt(command[2]));
                            break;
                        }
                        ct.MoveVirologist(Integer.parseInt(command[1]));
                        break;
                    case "drop":
                        if(command[1] == null){
                            Virologist virologist = ct.GetCurrentVirologist();
                            ShowVirologistBackpack(virologist, bw);
                            break;
                        }
                        switch (command[1]){
                            case "aminoacid":
                                ct.DropAminoacid(Integer.parseInt(command[2]));
                                break;
                            case "nucleotide":
                                ct.DropNucleotide(Integer.parseInt(command[2]));
                                break;
                            case "equipment":
                                ct.DropEquipment(Integer.parseInt(command[2]));
                                break;
                        }
                        break;
                    case "take":
                        if(command[1] == null){
                            Field field = ct.GetCurrentField();
                            ShowFieldBackpack(field, bw);
                            break;
                        }
                        switch (command[1]){
                            case "aminoacid":
                                ct.TakeAminoacid(Integer.parseInt(command[2]));
                                break;
                            case "nucleotide":
                                ct.TakeNucleotide(Integer.parseInt(command[2]));
                                break;
                            case "equipment":
                                ct.TakeEquipment(Integer.parseInt(command[2]));
                                break;
                        }
                        break;
                    case "steal":
                        if(command[1] == null){
                            Field field = ct.GetCurrentField();
                            ShowStealableVirologists(field, bw);
                            break;
                        }
                        if(command[2] == null){
                            Virologist virologist = ct.GetVirologist(command[1]);
                            ShowVirologistBackpack(virologist, bw);
                            break;
                        }
                        switch (command[1]){
                            case "aminoacid":
                                ct.StealAminoacid(command[1], Integer.parseInt(command[2]));
                                break;
                            case "nucleotide":
                                ct.StealNucleotide(command[1], Integer.parseInt(command[2]));
                                break;
                            case "equipment":
                                ct.StealEquipment(command[1], Integer.parseInt(command[2]));
                                break;
                        }
                        break;
                    case "learn":
                        ct.LearnGenome();
                        break;
                    case "teach":
                        ct.TeachGenome(command[1], command[2]);
                        break;
                    case "create":
                        if(command[1] == null){
                            Virologist virologist = ct.GetCurrentVirologist();
                            ShowCreatable(virologist, bw);
                            break;
                        }
                        ct.CreateAgent(command[1]);
                        break;
                    case "infect":
                        if(command[1] == null){
                            Field field = ct.GetCurrentField();
                            ShowVirologists(field, bw);
                            break;
                        }
                        if(command[2] == null){
                            Virologist virologist = ct.GetCurrentVirologist();
                            ShowAgents(virologist, bw);
                            break;
                        }
                        if(command[2].equals("randomoff")){
                            ct.InfectVirologistRandomOff(command[1], Integer.parseInt(command[3]));
                        }
                        ct.InfectVirologist(command[1], Integer.parseInt(command[2]));
                        break;
                    case "effect":
                        ct.EffectVirologist(command[1], command[2]);
                    case "kill":
                        if(command[1] == null){
                            Field field = ct.GetCurrentField();
                            ShowVirologists(field, bw);
                            break;
                        }
                        ct.KillVirologist(command[1]);
                    case "endTurn":
                        ct.EndTurn();



                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    /**
     * Show the Virologists the current Virologist can interact with.
     * @param field the field the Virologist is on.
     * @param bw the output will be written there
     */
    private static void ShowVirologists(Field field, BufferedWriter bw) {

    }

    /**
     * Show the Virologists the current Virologist can steal from.
     * @param field the field the Virologist is on.
     * @param bw the output will be written there
     */
    private static void ShowStealableVirologists(Field field, BufferedWriter bw) {

    }

    /**
     * Shows the creatable Agents, their cost and the Materials the Virologist has.
     * @param virologist the current Virologist
     * @param bw the output will be written there
     */
    private static void ShowCreatable(Virologist virologist, BufferedWriter bw) {

    }

    /**
     * Shows the agents that a Virologist has.
     * @param virologist the current virologist
     * @param bw the output will be written there
     */
    private static void ShowAgents(Virologist virologist, BufferedWriter bw) {

    }

    /**
     * Shows the items that are on the Field
     * @param field the Field the current Virologist is on
     * @param bw the output will be written there
     */
    private static void ShowFieldBackpack(Field field, BufferedWriter bw) {

    }

    /**
     * Show the Materials and Equipments that are in a Virologist's backpack
     * @param virologist the Virologist who owns the Backpack
     * @param bw the output will be written there
     */
    private static void ShowVirologistBackpack(Virologist virologist, BufferedWriter bw) {

    }

    /**
     * Shows the neighbors of a Field
     * @param field The Field the Current Virologist is on
     * @param bw the output will be written there
     */
    private static void ShowDirections(Field field, BufferedWriter bw) {

    }

    /**
     * Shows every important information about the Field
     * @param field the Field
     * @param bw the output will be written there
     */
    private static void ShowField(Field field, BufferedWriter bw) {

    }

    /**
     * Shows every important information about the Virologist
     * @param virologist the Vriologist
     * @param bw the output will be written there
     */
    private static void ShowVirologist(Virologist virologist, BufferedWriter bw) {

    }

    /**
     * Compares the content of two files.
     * @param expected reader for the expected output
     * @param actual reader for the actual output
     * @return the first line of mismatch if the files are different. else -1
     * @throws IOException reading failed
     */
    private static int CompareFiles(BufferedReader expected, BufferedReader actual) throws IOException {
        int lineNumber = 1;
        String line1, line2;
        while ((line1 = expected.readLine()) != null) {
            line2 = actual.readLine();
            if (line2 == null || !line1.equals(line2)) {
                return lineNumber;
            }
            lineNumber++;
        }
        if (actual.readLine() == null) {
            return -1;
        }
        else {
            return lineNumber;
        }
    }
}
