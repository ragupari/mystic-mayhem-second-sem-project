import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        //Hello
        createDefaultPlayers();
        String userName = Player.playerLogin();
        Player currentPlayer = new Player(userName);
        welcomePage(currentPlayer);
    }
    public static void displayProfile(Player Player) {
        System.out.println("--------------------------------------");
        System.out.println("\nHi "+Player.getName()+"!\nWelcome to Mystic Mayhem Game");
        System.out.println("* Current Gold coins:\t"+Player.getGC());
        System.out.println("* Current XP:\t\t"+Player.getXP());
        System.out.println();
    }
    public static void chooseAction(Player Player){
        Scanner scanner = new Scanner(System.in);
        System.out.println("--------------------------------------");
        System.out.println("Select your action: ");
        System.out.println("\t1. Show my army");
        
        System.out.println("\t2. Buy army");
        System.out.println("\t3. Buy equipment");
        System.out.println("\t4. Sell army");
        System.out.println("\t5. Set my homeground");

        System.out.println("\t6. Show other players (You can declare war with other players here)");
        System.out.println("\t7. Go to War");
        String choice = scanner.next();
        switch (choice){
        case "1":
        ShowArmy.showArmy(Player);
        case "2":
        Buy.buyArmy(Player);
        case "3":
        Buy.buyEquip(Player);
        case "4":
        Sell.sellArmy(Player);
        case "6":
        ShowOthers.showOthers(Player);
        case "7":
        War.goToWar(Player);
        case "5":
        Homeland.setHomeland(Player);
        default: 
            welcomePage(Player);
        }
    } 
    public static void welcomePage(Player Player){
        displayProfile(Player);
        chooseAction(Player);
    }
    public static void createDefaultPlayers(){
        File folder = new File("Players");
        if (!folder.exists()) {
            boolean folderCreated = folder.mkdir();
        try {
            File file = new File("Players/whitewolf.txt");
            if (!file.exists()) {
                file.createNewFile();
            }
            BufferedWriter writer = new BufferedWriter(new FileWriter(file, true)); // Note the 'true' parameter
            writer.write("Name,GeraltofRivia,\nUser ID,1,\nGC,215,\nXP,32,\nArcher,Chainmail,None,None,Ranger,None,None,None,Ranger,0,\nKnight,None,None,Squire,None,None,None,None,Squire,0,\nMage,None,None,Warlock,None,None,None,None,Warlock,0,\nHealer,None,Amulet,None,Medic,None,None,None,Medic,0,\nCreature,None,None,Dragon,None,None,None,None,Dragon,0,\nWar,None,None,\nHomeground,Marshland,\n");
            writer.close();
        } catch (IOException e) {
        }
        try {
            File file = new File("Players/pari.txt");
            if (!file.exists()) {
                file.createNewFile();
            }
            BufferedWriter writer = new BufferedWriter(new FileWriter(file, true)); // Note the 'true' parameter
            writer.write("Name,Parishith,\nUser ID,2,\nGC,300,\nXP,10,\nArcher,None,None,Shooter,None,None,None,None,Shooter,0,\nKnight,None,None,Squire,None,None,None,None,Squire,0,\nMage,None,None,Warlock,None,None,None,None,Warlock,0,\nHealer,None,None,Soother,None,None,None,None,Soother,0,\nCreature,None,None,Dragon,None,None,None,None,Dragon,0,\nWar,None,None,\nHomeground,Marshland,\n");
            writer.close();
        } catch (IOException e) {
        }
        try {
            File file = new File("Players/Vithu.txt");
            if (!file.exists()) {
                file.createNewFile();
            }
            BufferedWriter writer = new BufferedWriter(new FileWriter(file, true)); // Note the 'true' parameter
            writer.write("Name,Vithusanaa,\nUser ID,5,\nGC,224,\nXP,45,\nArcher,None,None,Shooter,None,None,None,Saggitarius,Saggitarius,0,\nKnight,None,None,Squire,None,None,None,None,Squire,0,\nMage,None,None,Warlock,None,None,None,Eldritch,Eldritch,0,\nHealer,None,None,Soother,None,None,None,None,Soother,0,\nCreature,None,None,Dragon,None,None,None,None,Dragon,0,\nWar,None,None,\nHomeground,Arcane,");
            writer.close();
        } catch (IOException e) {
        }
        try {
            File file = new File("Players/kajali.txt");
            if (!file.exists()) {
                file.createNewFile();
            }
            BufferedWriter writer = new BufferedWriter(new FileWriter(file, true)); // Note the 'true' parameter
            writer.write("Name,Kajaluxan,\nUser ID,3,\nGC,400,\nXP,23,\nArcher,None,None,Shooter,Ranger,None,None,None,Shooter,0,\nKnight,None,None,Squire,None,None,None,None,Squire,0,\nMage,None,None,None,Illusionist,None,None,None,Illusionist,0,\nHealer,None,None,Soother,None,None,None,Lightbringer,Lightbringer,0,\nCreature,None,None,Dragon,None,None,None,None,Dragon,0,\nWar,None,None,\nHomeground,Desert,");
            writer.close();
        } catch (IOException e) {
        }
        try {
            File file = new File("Players/Suki.txt");
            if (!file.exists()) {
                file.createNewFile();
            }
            BufferedWriter writer = new BufferedWriter(new FileWriter(file, true)); // Note the 'true' parameter
            writer.write("Name,Sukithan,\nUser ID,4,\nGC,445,\nXP,12,\nArcher,None,None,Shooter,None,None,None,None,Shooter,0,\nKnight,None,None,Squire,None,None,Zoro,None,Zoro,0,\nMage,None,None,Warlock,None,None,None,None,Warlock,0,\nHealer,None,None,Soother,None,None,Saint,None,Saint,0,\nCreature,None,None,Dragon,None,None,None,None,Dragon,0,\nWar,None,None,\nHomeground,Marshland,"
            );
            writer.close();
        } catch (IOException e) {
        }}
        try{
        File file = new File("players.csv");
        if (!file.exists()) {
            file.createNewFile();
            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter("players.csv"));
                writer.write("1,GeraltofRivia,whitewolf,\n");
                writer.write("2,Parishith,pari,\n");
                writer.write("3,Kajaluxan,kajali,\n");
                writer.write("4,Sukithan,Suki,\n");
                writer.write("5,Vithursanaa,Vithu,\n");
                writer.close();
            } catch (IOException e) {
                // Handle any IOException that may occur during file writing
            }
        }}catch (IOException e) {
            //System.out.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }
}