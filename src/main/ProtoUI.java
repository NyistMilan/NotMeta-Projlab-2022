package main;

import assets.Backpack;
import assets.field.Field;
import assets.virologist.Virologist;
import assets.virologist.VirologistBackpack;
import collectables.agent.Agent;
import collectables.equipment.Equipment;
import collectables.genome.Genome;

import java.io.*;

public class ProtoUI {
    public static void main(String[] args){
        Controller controller = new Controller(); //base controller
        final BufferedReader cbr = new BufferedReader(new InputStreamReader(System.in)); //BufferedReader for the console
        final PrintWriter cpw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)), true); //BufferedWriter for the console
        Run(controller, cpw, cbr);
    }

    private static void Run(Controller ct, PrintWriter pw, BufferedReader br) {
        boolean running = true;
        boolean started = false;    //after the game starts no more system commands are allowed
        while(running){
            try {
                String input = br.readLine();
                String[] command = input.split("\\s+");
                if(!started) {
                    switch (command[0]) {
                        case "runTest":
                            String inputFileName = "TestInputs/" + command[1] + "_Input.txt";
                            String runOutputFileName = "RunOutputs/" + command[1] + "_RunOutput.txt";
                            Controller testCt = new Controller();
                            PrintWriter testPw = new PrintWriter(new BufferedWriter(new FileWriter(runOutputFileName)));
                            BufferedReader testBr = new BufferedReader(new FileReader(inputFileName));
                            Run(testCt, testPw, testBr);
                            BufferedReader actual = new BufferedReader(new FileReader(runOutputFileName));
                            String expectedOutputFileName = "TestOutputs/" + command[1] + "_Output.txt";
                            BufferedReader expected = new BufferedReader(new FileReader(expectedOutputFileName));
                            int FDL = CompareFiles(expected, actual); //First Different Line
                            expected.close();
                            actual.close();
                            if (FDL == -1) {
                                pw.printf("test succeeded\n");

                            } else {
                                pw.printf("test failed at line %d\n", FDL);
                            }
                            break;
                        case "field":
                            if (command[1].equals("laboratory") || command[1].equals("bearlaboratory"))
                                ct.CreateLaboratory(command[1], command[2], command[3]);
                            else
                                ct.CreateField(command[1], command[2]);
                            break;
                        case "neighbor":
                            ct.NeighborFields(command[1], command[2]);
                            break;
                        case "virologist":
                            ct.CreateVirologist(command[1], command[2]);
                            break;
                        case "put":
                            switch (command[1]) {
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
                            switch (command[1]) {
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
                            switch (command[1]) {
                                case "virologist":
                                    Virologist virologist = ct.GetVirologist(command[2]);
                                    ShowVirologist(virologist, pw);
                                    break;
                                case "field":
                                    assets.field.Field field = ct.GetField(command[2]);
                                    ShowField(field, pw);
                                    break;
                            }
                            break;
                        case "new":
                            ct = new Controller();
                            pw.printf("new game created\n");

                            break;
                        case "load":
                            Controller loadedGame;
                            try {
                                ObjectInputStream in = new ObjectInputStream(new FileInputStream(command[1]));
                                loadedGame = (Controller) in.readObject();
                                ct = loadedGame;
                                pw.printf("game loaded\n");
                                in.close();
                            } catch (IOException i) {
                                i.printStackTrace();
                                break;
                            } catch (ClassNotFoundException c) {
                                pw.printf("Controller class not found\n");
                                c.printStackTrace();
                                break;
                            }
                            break;
                        case "save":
                            try {
                                ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(command[1]));
                                out.writeObject(ct);
                                pw.printf("game saved\n");
                                out.close();
                            } catch (IOException i) {
                                i.printStackTrace();
                                break;
                            }
                        case "exit":
                            br.close();
                            pw.close();
                            running = false;
                            break;
                        case "effect":
                            ct.EffectVirologist(command[1], command[2]);
                            break;
                        case "teach":
                            ct.TeachGenome(command[1], command[2]);
                            break;
                        case "start":
                            ct.Start();
                            started = true;
                            pw.printf("the game has started\n");
                            break;
                    }
                }
                else{
                    switch (command[0]){
                        case "save":
                            try{
                                ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(command[1]));
                                out.writeObject(ct);
                                pw.printf("game saved\n");
                                out.close();
                            }
                            catch (IOException i){
                                i.printStackTrace();
                                break;
                            }
                        case "exit":
                            br.close();
                            pw.close();
                            running = false;
                            break;
                        case "move":
                            if(command[1] == null){
                                Field field = ct.GetCurrentField();
                                ShowDirections(field, pw);
                                break;
                            }
                            else if(command[1].equals("randomoff")){
                                ct.MoveVirologistRandomOff(Integer.parseInt(command[2]));
                                break;
                            }
                            else
                                ct.MoveVirologist(Integer.parseInt(command[1]));
                            break;
                        case "drop":
                            if(command[1] == null){
                                Virologist virologist = ct.GetCurrentVirologist();
                                ShowVirologistBackpack(virologist, pw);
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
                                ShowFieldBackpack(field, pw);
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
                                ShowStealableVirologists(field, pw);
                                break;
                            }
                            if(command[2] == null){
                                Virologist virologist = ct.GetVirologist(command[1]);
                                ShowVirologistBackpack(virologist, pw);
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
                        case "create":
                            if(command[1] == null){
                                Virologist virologist = ct.GetCurrentVirologist();
                                ShowCreatable(virologist, pw);
                                break;
                            }
                            ct.CreateAgent(command[1]);
                            break;
                        case "infect":
                            if(command[1] == null){
                                Field field = ct.GetCurrentField();
                                ShowVirologists(field, pw);
                                break;
                            }
                            if(command[2] == null){
                                Virologist virologist = ct.GetCurrentVirologist();
                                ShowAgents(virologist, pw);
                                break;
                            }
                            if(command[2].equals("randomoff")){
                                ct.InfectVirologistRandomOff(command[1], Integer.parseInt(command[3]));
                            }
                            ct.InfectVirologist(command[1], Integer.parseInt(command[2]));
                            break;
                        case "kill":
                            if(command[1] == null){
                                Field field = ct.GetCurrentField();
                                ShowVirologists(field, pw);
                                break;
                            }
                            ct.KillVirologist(command[1]);
                        case "endTurn":
                            ct.EndTurn();
                            break;
                        case "show":
                            switch (command[1]) {
                                case "virologist":
                                    Virologist virologist = ct.GetVirologist(command[2]);
                                    ShowVirologist(virologist, pw);
                                    break;
                                case "field":
                                    assets.field.Field field = ct.GetField(command[2]);
                                    ShowField(field, pw);
                                    break;
                            }
                            break;
                    }
                }

                {




                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            br.close();
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    private static void ShowBackpack(Backpack backpack, PrintWriter pw) {
        pw.printf("materials:\naminoacid %d\nnucleotide %d\nequipments:\n", backpack.GetAminos().size(), backpack.GetNucleotide().size());
        int index = 1;
        for(Equipment e : backpack.GetEquipments()){
            if(e.GetDurability() < 0)
                pw.printf("%d. %s\n", index, e.GetName());
            else
                pw.printf("%d. %s %d\n", index, e.GetName(), e.GetDurability());
        }
    }
    /**
     * Show the Virologists the current Virologist can interact with.
     * @param field the field the Virologist is on.
     * @param pw the output will be written there
     */
    private static void ShowVirologists(Field field, PrintWriter pw) throws IOException {
        for(Virologist v : field.GetVirologists()){
            pw.printf("%s\n", v.GetName());
        }
    }

    /**
     * Show the Virologists the current Virologist can steal from.
     * @param field the field the Virologist is on.
     * @param pw the output will be written there
     */
    private static void ShowStealableVirologists(Field field, PrintWriter pw) throws IOException {
        for(Virologist v : field.GetVirologists()){
            if(v.GetGetStolenBehavior().CanStealForm())
                pw.printf("%s\n", v.GetName());
        }
    }

    /**
     * Shows the creatable Agents, their cost and the Materials the Virologist has.
     * @param virologist the current Virologist
     * @param pw the output will be written there
     */
    private static void ShowCreatable(Virologist virologist, PrintWriter pw) throws IOException {
        int aminoCount = virologist.GetBackpack().GetAminos().size();
        int nucleoCount = virologist.GetBackpack().GetNucleotide().size();
        pw.printf("you have: \t%d aminoacid \t%d nucleotide\n", aminoCount, nucleoCount);
        for(Genome g : virologist.GetLearnedGenomes()){
            pw.printf("%s \t%d aminoacid \t%d nucleotide\n",g.GetName() ,g.getAminoCost(), g.getNucleoCost());
        }
    }

    /**
     * Shows the agents that a Virologist has.
     * @param virologist the current virologist
     * @param pw the output will be written there
     */
    private static void ShowAgents(Virologist virologist, PrintWriter pw) throws IOException {
        int index = 1;
        for(Agent a : virologist.GetBackpack().GetAgents()){
            pw.printf("%d. %s %d\n", index, a.GetName(), a.getWarranty());
            index++;
        }
    }

    /**
     * Shows the items that are on the Field
     * @param field the Field the current Virologist is on
     * @param pw the output will be written there
     */
    private static void ShowFieldBackpack(Field field, PrintWriter pw) throws IOException {
        Backpack backpack = field.GetBackpack();
        ShowBackpack(backpack, pw);

    }

    /**
     * Show the Materials and Equipments that are in a Virologist's backpack
     * @param virologist the Virologist who owns the Backpack
     * @param pw the output will be written there
     */
    private static void ShowVirologistBackpack(Virologist virologist, PrintWriter pw) throws IOException {
        VirologistBackpack backpack = virologist.GetBackpack();
        ShowBackpack(backpack, pw);
    }

    /**
     * Shows the neighbors of a Field
     * @param field The Field the Current Virologist is on
     * @param pw the output will be written there
     */
    private static void ShowDirections(Field field, PrintWriter pw) throws IOException {
        for(int d: field.GetDirections()){
            pw.printf("%d - %s\n", d, field.GetNeighbour(d).GetType());
        }
    }

    /**
     * Shows every important information about the Field
     * @param field the Field
     * @param pw the output will be written there
     */
    private static void ShowField(Field field, PrintWriter pw) throws IOException {
        pw.printf("fieldId: %s\ntype: %s\n", field.GetFieldID(),field.GetType());
        if(field.GetGenome() != null){
            pw.printf("genome: %s\n", field.GetGenome());
        }
        pw.printf("virologists:\n");
        for(Virologist v : field.GetVirologists()){
            pw.printf("-%s\n", v.GetName());
        }
        Backpack backpack = field.GetBackpack();
        ShowBackpack(backpack, pw);
    }

    /**
     * Shows every important information about the Virologist
     * @param virologist the Virologist
     * @param pw the output will be written there
     */
    private static void ShowVirologist(Virologist virologist, PrintWriter pw) throws IOException {
        pw.printf("name: %s\nfield: %s\n", virologist.GetName(), virologist.GetRoute().GetLocation().GetFieldID());
        String state = "";
        switch (virologist.GetState()){
            case KILLED:
                state = "killed";
                break;
            case BEFORE_MOVE:
                state = "before_move";
                break;
            case NOT_IN_TURN:
                state = "not_in_turn";
                break;
            case AFTER_ACTION:
                state = "after_action";
                break;
            case BEFORE_ACTION:
                state = "before_action";
        }
        pw.printf("state: %s\nlearned genomes:\n", state);
        for(Genome g :virologist.GetLearnedGenomes()){
            pw.printf("-%s\n", g.GetName());
        }
        VirologistBackpack backpack = virologist.GetBackpack();
        pw.printf("backpack\ncapacity: %d", backpack.GetCapacity());
        ShowBackpack(backpack, pw);

        pw.printf("agents\n");
        int aIndex = 1;
        for(Agent a : backpack.GetAgents()){
            pw.printf("%d. %s %d\n", aIndex, a.GetName(), a.getWarranty());
        }
        pw.printf("applied agents\n");
        for(Agent a : backpack.GetAppliedAgents()){
            pw.printf("- %s %d\n", a.GetName(), a.getDuration());
        }
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
