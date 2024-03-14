import java.util.Scanner;

public class Homeland {
    public static int[] getStats(String character, String homeland) {
        System.out.println(homeland);
        int[] stats = {02,02,0,0};
        String category = getHomelandCategory(character);
        switch (homeland) {
            case "Hillcrest":
                switch (category) {
                    case "Highlanders":
                        stats[0] = 1;
                        stats[1] = 1;
                        break;
                    case "Marshlanders":
                    case "Sunchildren":
                        stats[3] = -1;
                        break;
                }
                break;
            case "Marshland":
                switch (category) {
                    case "Marshlanders":
                        stats[1] = 2;
                        break;
                    case "Sunchildren":
                        stats[0] = -1;
                        break;
                }
                break;
            case "Desert":
                switch (category) {
                    case "Marshlanders":
                        stats[2] = -1;
                        break;
                    case "Sunchildren":
                        stats[0] = 1;
                        break;
                }
                break;
            case "Arcane":
                switch (category) {
                    case "Highlanders":
                    case "Marshlanders":
                        stats[0] = -1;
                        stats[1] = -1;
                        break;
                    case "Mystics":
                        stats[0] = 2;
                        break;
                }
                break;
        }
        return stats;
    }
    public static int[] getStats4(String character, String homeland) {
        String category = getHomelandCategory(character);
    
        if (homeland.equals("Hillcrest")) {
            if (category.equals("Highlanders")) {
                int[] stats = {1, 1, 0, 0};
                return stats;
            } else if (category.equals("Marshlanders") || category.equals("Sunchildren")) {
                int[] stats = {0, 0, 0, -1};
                return stats;
            }
        } else if (homeland.equals("Marshland")) {
            if (category.equals("Marshlanders")) {
                int[] stats = {0, 2, 0, 0};
                return stats;
            } else if (category.equals("Sunchildren")) {
                int[] stats = {-1, 0, 0, 0};
                return stats;
            }
        } else if (homeland.equals("Desert")) {
            if (category.equals("Marshlanders")) {
                int[] stats = {0, 0, -1, 0};
                return stats;
            } else if (category.equals("Sunchildren")) {
                int[] stats = {1, 0, 0, 0};
                return stats;
            }
        } else if (homeland.equals("Arcane")) {
            if (category.equals("Highlanders") || category.equals("Marshlanders")) {
                int[] stats = {-1, -1, 0, 0};
                return stats;
            } else if (category.equals("Mystics")) {
                int[] stats = {2, 0, 0, 0};
                return stats;
            }
        }
    
        int[] stats = {0,0,0,0}; // Default stats
        return stats;
    }
    

    public static String getHomelandCategory(String character){
        String category;
        switch (character) {
            case "Shooter":
            case "Ranger":
            case "Cavalier":
            case "Zoro":
            case "Enchanter":
            case "Conjurer":
            case "Medic":
                category = "Highlanders";
                break;
            case "Squire":
            case "Swiftblade":
            case "Warlock":
            case "Alchemist": 
            case "Basilisk": 
            case "Hydra":
                category = "Marshlanders";
                break;
            case "Sunfire":
            case "Zing":
            case "Templar":
            case "Soother":
            case "Lightbringer":
            case "Dragon":
            case "Phoenix":
                category = "Sunchildren";
                break;
            case "Saggitarius":
            case "Illusionist":
            case "Eldritch":
            case "Saint":
            case "Pegasus":
                category = "Mystics";
                break;
            default:
                category = "None";
        }
    return category;
    }
    public static void setHomeland(Player player){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Your current homeland is " + FileReadWrite.readNthLine(player.getUserName(), 11)[1]);
        System.out.println("Select the homeland to change your current");
        System.out.println("(Any other key to go back)");
        System.out.println("\t1. Hillcrest");
        System.out.println("\t2. Marshland");
        System.out.println("\t3. Desert");
        System.out.println("\t4. Arcane");
        String choice = scanner.next();
        switch (choice) {
            case "1":
                FileReadWrite.writeNthLine(player.getUserName(), 11, 1, "Hillcrest");
                System.out.println("Your home land is set to "+FileReadWrite.readNthLine(player.getUserName(), 11)[1]);
                break;
            case "2":
                FileReadWrite.writeNthLine(player.getUserName(), 11, 1, "Marshland");
                System.out.println("Your home land is set to "+FileReadWrite.readNthLine(player.getUserName(), 11)[1]);
                break;
            case "3":
                FileReadWrite.writeNthLine(player.getUserName(), 11, 1, "Desert");
                System.out.println("Your home land is set to "+FileReadWrite.readNthLine(player.getUserName(), 11)[1]);
                break;
            case "4":
                FileReadWrite.writeNthLine(player.getUserName(), 11, 1, "Arcane");
                System.out.println("Your home land is set to "+FileReadWrite.readNthLine(player.getUserName(), 11)[1]);
                break;
            default:
                Main.welcomePage(player);
        }

    }


}