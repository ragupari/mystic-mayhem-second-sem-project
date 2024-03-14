import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class ShowOthers {
    public static String getRandomUserName(Player player) {
        ArrayList<String> allUserNames = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("players.csv"));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                String userName = data[2].trim(); // Assuming username is at index 2
                if (!userName.equals(player.getUserName())) {
                    allUserNames.add(userName);
                }
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file: " + e.getMessage());
            e.printStackTrace();
        }

        int size = allUserNames.size();
        if (size == 0) {
            return null; // No usernames found
        }

        Random random = new Random();
        int randomNumber = random.nextInt(size);
        return allUserNames.get(randomNumber);
    }

    public static void showOthers(Player player) {
        String otherUser = getRandomUserName(player);
        Player otherPlayer = new Player(otherUser);
   
        System.out.println("--------------------------------------");
        System.out.println("Other player: "+otherPlayer.getName());

        System.out.println("\t * XP level :\t"+otherPlayer.getXP());
        System.out.println("\t 1. Archer :\t"+otherPlayer.getArcher().getCurrent(otherUser));
        System.out.println("\t 2. Knight :\t"+otherPlayer.getKnight().getCurrent(otherUser));
        System.out.println("\t 3. Mage :\t"+otherPlayer.getMage().getCurrent(otherUser));
        System.out.println("\t 4. Healer :\t"+otherPlayer.getHealer().getCurrent(otherUser));
        System.out.println("\t 5. Creature :\t"+otherPlayer.getCreature().getCurrent(otherUser));
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n1. Declare war with this player");
        System.out.println("2. Veiw next player");
        System.out.println("(Press any other key to go back)");
        String choice = scanner.nextLine();
        switch (choice) {
            case "1":
                decalreWar(player, otherPlayer);
                break;
            case "2":
                showOthers(player);
                break;

            default:
                Main.welcomePage(player);
                break;
        }

    }
    public static void decalreWar(Player player,Player otherPlayer) {
        String playerWar = FileReadWrite.readNthLine(player.getUserName(), 10)[1];
        String otherPlayerWar = FileReadWrite.readNthLine(otherPlayer.getUserName(), 10)[1];
        if (!(playerWar.equals("None"))){
            System.out.println("You have already declared a war. You can't declare another!");
            Main.welcomePage(player);
        }
        if (!(otherPlayerWar.equals("None"))){
            System.out.println("The other player already has a pending war declaration. You can't declare war on this player!");
            Main.welcomePage(player);
        }
        System.out.println("You have successfully declared the war. You can't see the war results till the other player accepts the war!");
        FileReadWrite.writeNthLine(player.getUserName(), 10, 1, otherPlayer.getUserName());
        FileReadWrite.writeNthLine(otherPlayer.getUserName(), 10, 1,player.getUserName());
        FileReadWrite.writeNthLine(player.getUserName(), 10, 2, player.getUserName());
        FileReadWrite.writeNthLine(otherPlayer.getUserName(), 10, 2,player.getUserName());
       
        
        
        Main.welcomePage(player);
    }




}
