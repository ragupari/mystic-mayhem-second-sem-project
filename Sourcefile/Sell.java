import java.util.Scanner;

public class Sell {
        
    static void sellArmy(Player player){
        String[][][] allCharacters = {
            // Archers
            {
                {"Shooter", "80"}, 
                {"Ranger", "115"}, 
                {"Sunfire", "160"}, 
                {"Zing","200"},
                {"Saggitarius", "230"}
            },
            // Knights
            {
                {"Squire", "85"}, 
                {"Cavalier", "110"}, 
                {"Templar", "155"}, 
                {"Zoro", "180"}, 
                {"Swiftblade", "250"}
            },
            // Mages
            {
                {"Apprentice", "75"}, 
                {"Wizard", "110"}, 
                {"Sorcerer", "150"}, 
                {"Warlock", "190"}, 
                {"Archmage", "240"}
            },
            // Healers
            {
                {"Soother", "95"}, 
                {"Medic", "125"}, 
                {"Alchemist", "150"}, 
                {"Saint", "200"}, 
                {"Lightbringer", "260"}
            },
            // Creatures
            {
                {"Dragon", "120"}, 
                {"Basilisk", "165"}, 
                {"Hydra", "205"}, 
                {"Phoenix", "275"}, 
                {"Pegasus", "340"}
            }
        };
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("From which category do you want to sell?");
        System.out.println("\t1. Archer");
        System.out.println("\t2. Knight");
        System.out.println("\t3. Mage");
        System.out.println("\t4. Healer");
        System.out.println("\t5. Creature");
        String choice0 = scanner.next();
        String category[][] = allCharacters[Integer.parseInt(choice0)-1];
        System.out.println("Which character do you want to sell?");
        int count = 1;
        for (String[] character : category){
            System.out.println("\t"+count+". "+character[0]);
            count++;
        }
        String choice1 = scanner.next();
        String characterSelected = category[Integer.parseInt(choice1)-1][0];
        int amount = Integer.parseInt(category[Integer.parseInt(choice1)-1][1]);
        int line = Integer.parseInt(choice0) + 4;
        String[] characterValues = FileReadWrite.readNthLine(player.getUserName(),line);
        String currentChar = characterValues[8];
        int increase =Integer.parseInt( characterValues[9]);
        int sellingprice = increase+amount;
        System.out.println(characterSelected+" can be sold for "+sellingprice+" GC.");
        System.out.println("\t1. Sell");
        System.out.println("\t2. Go back");
        String choice2 = scanner.next();
        switch (choice2){
            case "1":
            FileReadWrite.writeNthLine(player.getUserName(),3,1,sellingprice+"");
            FileReadWrite.writeNthLine(player.getUserName(),line,(Integer.parseInt(choice1)+2),"None");
            player.addGC(sellingprice);
            System.out.println(characterSelected+" is successfully sold!");
            if (currentChar.equals(characterSelected)){
                FileReadWrite.writeNthLine(player.getUserName(),line,8,"None");
                System.out.println("Select your current character in 'Show my arrmy'");
                Main.welcomePage(player);
            }
            break;
            case "2":
                sellArmy(player);
            break;
            default: 
                sellArmy(player);
        }

    }
    
}
