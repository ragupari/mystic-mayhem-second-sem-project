import java.util.Scanner;
public class Buy {

    static void buyArmy(Player player){
        Scanner scanner = new Scanner(System.in);
        System.out.println("--------------------------------------");
        System.out.println("Which category do you want to buy?");
        System.out.println("(Any other key too go back))");
        System.out.println("\t1. Archer");
        System.out.println("\t2. Knight");
        System.out.println("\t3. Mage");
        System.out.println("\t4. Healer");
        System.out.println("\t5. Mythical creatures");
        String choice = scanner.next();
        switch (choice){
            case "1":
                buyArcher(player);
            case "2":
                buyKnight(player);
            case "3":
                buyMage(player);
            case "4":
                buyHealer(player);
            case "5":
                buyCreature(player);
            default: 
                Main.welcomePage(player);
        }
}

    static void buyEquip(Player player){
        Scanner scanner = new Scanner(System.in);
        System.out.println("--------------------------------------");
        System.out.println("What equipment do you want to buy? (Choose from 1-2, Press any other key to go back)");
        System.out.println("(Any other key to go back)");
        System.out.println("\t1. Armour");
        System.out.println("\t2. Artefact");
        String choice = scanner.next();
        switch (choice){
            case "1":
                buyArmour(player);
            case "2":
                buyArtefact(player);
            default: 
                Main.welcomePage(player);
        }
    }
        static void buyArmour(Player player){
            Scanner scanner = new Scanner(System.in);
            System.out.println("--------------------------------------");
            System.out.println("For which character do you want to buy?");
            System.out.println("(Any other key to go back)");
            System.out.println("\t1. Archer");
            System.out.println("\t2. Knight");
            System.out.println("\t3. Mage");
            System.out.println("\t4. Healer");
            System.out.println("\t5. Mythical creatures");
            String choice = scanner.next();
            if (!((choice.equals("1"))||(choice.equals("2"))||(choice.equals("3"))||(choice.equals("4"))||(choice.equals("5")))){
                Main.welcomePage(player);
            }
            int character = Integer.parseInt(choice)+4;

            System.out.println("--------------------------------------");
            System.out.println("Which armour do you want to buy? (Choose from 1-3, Press any other key to go back)");
            System.out.println("\t1. Chainmail\t70 GC");
            System.out.println("\t2. Regalia\t105 GC");
            System.out.println("\t3. Fleece\t150GC");
            String choice2 = scanner.next();
            //int character = Integer.parseInt(choice)+4;
            switch (choice2){
                case "1":
                    buySelect(player, character, 1, "Chainmail", 70);
                case "2":
                    buySelect(player, character, 1, "Regalia", 105);
                case "3":
                    buySelect(player, character, 1, "Fleece", 150);
                default: 
                    buyEquip(player);
            }
        }
        static void buyArtefact(Player player){
            Scanner scanner = new Scanner(System.in);
            System.out.println("For which character do you want to buy? (Choose from 1-5, Press any other key to go back)");
            System.out.println("\t1. Archer");
            System.out.println("\t2. Knight");
            System.out.println("\t3. Mage");
            System.out.println("\t4. Healer");
            System.out.println("\t5. Mythical creatures");
            String choice = scanner.next();
            if (!((choice.equals("1"))||(choice.equals("2"))||(choice.equals("3"))||(choice.equals("4"))||(choice.equals("5")))){
                Main.welcomePage(player);
            }
            int character = Integer.parseInt(choice)+4;
            System.out.println("--------------------------------------");
            System.out.println("Which artefact do you want to buy? (Choose from 1-3, Press any other key to go back)");
            System.out.println("\t1. Excalibur\t150 GC");
            System.out.println("\t2. Amulet\t200 GC");
            System.out.println("\t3. Crystal\t210 GC");
            String choice2 = scanner.next();
            //int character = Integer.parseInt(choice)+4;
            switch (choice2){
                case "1":
                    buySelect(player, character, 2, "Excalibur", 70);
                case "2":
                    buySelect(player, character, 2, "Amulet", 105);
                case "3":
                    buySelect(player, character, 2, "Crystal", 150);
                default: 
                    buyEquip(player);
            }
        }


        static void buySelect(Player player,int character, int type,String typeStr,int amount){
            String equip =FileReadWrite.readNthLine(player.getUserName(), character)[type];
            if (equip.equals(typeStr)){
                System.out.println(FileReadWrite.readNthLine(player.getUserName(), character)[0]+" already has "+typeStr+"!");
                buyArmour(player);
            }
            else{
                if (buy(player, amount)){
                    FileReadWrite.writeNthLine(player.getUserName(),character,type,typeStr);
                    int currentIncreaseValue = Integer.parseInt(FileReadWrite.readNthLine(player.getUserName(), character)[9]);
                    String increaseValue = ((int) Math.round(amount*(0.2)) + currentIncreaseValue)+"";
                    FileReadWrite.writeNthLine(player.getUserName(),character,9,increaseValue);
                }
                Main.welcomePage(player);
            }
            
        }
        




    static boolean buy(Player player,int amount){
        if (player.getGC()>=amount){
            player.deductGC(amount);
            String content = ""+player.getGC();
            FileReadWrite.writeNthLine(player.getUserName(),3,1,content);
            System.out.println("Purchase successful!");

            return true;
        }
        else{
            System.out.println("Not enough gold coins to buy!");
            return false;
        }

    }
    static boolean checkExist(Player player, String character, String typeNo){
        int n;
        switch (character){
            case "Archer":
                n=5;
                break;
            case "Knight":
                n=6;
                break;
            case "Mage":
                n=7;
                break;
            case "Healer":
                n=8;
                break;
            case "Creature":
                n=9;
                break;
            default:
                n=0;
                break;
        }
        if ((FileReadWrite.readNthLine(player.getUserName(), n)[Integer.parseInt(typeNo)+2]).equals("None")){
            return false;
        }else{
            System.out.println((FileReadWrite.readNthLine(player.getUserName(), n)[Integer.parseInt(typeNo)+2]));
            System.out.println("You already have this character in your army!");
            return true;
        }
    }
    static void defaultCharacterSet(Player player,int n, String set){
        if (FileReadWrite.readNthLine(player.getUserName(), n)[8].equals("None")){
            FileReadWrite.writeNthLine(player.getUserName(), n, 8, set);
            System.out.println("Your current "+FileReadWrite.readNthLine(player.getUserName(), n)[0]+" is set to "+ set);
        }
        else{
            System.out.println("Your current " + FileReadWrite.readNthLine(player.getUserName(),n)[0]+" is "+FileReadWrite.readNthLine(player.getUserName(),n)[8]);
            System.out.println("You can change it in Army");
        }
    }
    static void buyArcher(Player player){
        Scanner scanner = new Scanner(System.in);
        String character = "Archer";
        System.out.println("Which archer do you want to buy? (Choose from 1-5, Press any other key to go back)");
        System.out.println("\t1. Shooter\t80 GC");
        System.out.println("\t2. Ranger\t115 GC");
        System.out.println("\t3. Sunfire\t160 GC");
        System.out.println("\t4. Zing\t200 GC");
        System.out.println("\t5. Saggitarius\t230 GC");
        String choice = scanner.next();
        if (!((choice.equals("1"))||(choice.equals("2"))||(choice.equals("3"))||(choice.equals("4"))||(choice.equals("5")))){
            Main.welcomePage(player);
        }
        int n = Integer.parseInt(choice)+2;
        String value;
        switch (choice){
            case "1":
            value = "Shooter";
                if (!checkExist(player,character,choice)){
                    if (buy(player,80)){
                    defaultCharacterSet(player, 5, value);
                    FileReadWrite.writeNthLine(player.getUserName(),5,n,value);
                    Main.welcomePage(player);
                    }

                }
                buyArcher(player);
            case "2":
            value = "Ranger";
                if (!checkExist(player,character,choice)){
                    if (buy(player,115)){
                    defaultCharacterSet(player, 5, value);
                    FileReadWrite.writeNthLine(player.getUserName(),5,n,value);
                    Main.welcomePage(player);
                    }

                }
                buyArcher(player);
            case "3":
                value = "Sunfire";
                    if (!checkExist(player,character,choice)){
                        if (buy(player,160)){
                        defaultCharacterSet(player, 5, value);
                        FileReadWrite.writeNthLine(player.getUserName(),5,n,value);
                        Main.welcomePage(player);
                        }

                    }
                    buyArcher(player);
            case "4":
                value = "Zing";
                    if (!checkExist(player,character,choice)){
                        if (buy(player,200)){
                        defaultCharacterSet(player, 5, value);
                        FileReadWrite.writeNthLine(player.getUserName(),5,n,value);
                        Main.welcomePage(player);
                        }

                    }
                    buyArcher(player);
            case "5":
            value = "Saggitarius";
                if (!checkExist(player,character,choice)){
                    if (buy(player,230)){
                    defaultCharacterSet(player, 5, value);
                    FileReadWrite.writeNthLine(player.getUserName(),5,n,value);
                    Main.welcomePage(player);
                    }

                }
                buyArcher(player);
            
            default: 
                buyArcher(player);
        }
    }

    static void buyKnight(Player player){
        Scanner scanner = new Scanner(System.in);
        String character = "Knight";
        System.out.println("Which archer do you want to buy? (Choose from 1-5, Press any other key to go back)");
        System.out.println("\t1. Squire\t85 GC");
        System.out.println("\t2. Cavalier\t110 GC");
        System.out.println("\t3. Templar\t155 GC");
        System.out.println("\t4. Zoro\t\t180 GC");
        System.out.println("\t5. Swiftblade\t250 GC");
        String choice = scanner.next();
        if (!((choice.equals("1"))||(choice.equals("2"))||(choice.equals("3"))||(choice.equals("4"))||(choice.equals("5")))){
            Main.welcomePage(player);
        }
        int n = Integer.parseInt(choice)+2;
        String value;
        switch (choice){
            case "1":
            value = "Squire";
                if (!checkExist(player,character,choice)){
                    if (buy(player,85)){
                    defaultCharacterSet(player, 6, value);
                    FileReadWrite.writeNthLine(player.getUserName(),6,n,value);
                    }
                    Main.welcomePage(player);
                }
                buyKnight(player);
            case "2":
            value = "Cavalier";
                if (!checkExist(player,character,choice)){
                    if (buy(player,110)){
                    defaultCharacterSet(player, 6, value);
                    FileReadWrite.writeNthLine(player.getUserName(),6,n,value);
                    }
                    Main.welcomePage(player);
                }
                buyKnight(player);
            case "3":
                value = "Templar";
                    if (!checkExist(player,character,choice)){
                        if (buy(player,155)){
                        defaultCharacterSet(player, 6, value);
                        FileReadWrite.writeNthLine(player.getUserName(),6,n,value);
                        }
                        Main.welcomePage(player);
                    }
                    buyKnight(player);
            case "4":
                value = "Zoro";
                    if (!checkExist(player,character,choice)){
                        if (buy(player,180)){
                        defaultCharacterSet(player, 6, value);
                        FileReadWrite.writeNthLine(player.getUserName(),6,n,value);
                        }
                        Main.welcomePage(player);
                    }
                    buyKnight(player);
            case "5":
            value = "Swiftblade";
                if (!checkExist(player,character,choice)){
                    if (buy(player,250)){
                    defaultCharacterSet(player, 6, value);
                    FileReadWrite.writeNthLine(player.getUserName(),6,n,value);
                    }
                    Main.welcomePage(player);
                }
                buyKnight(player);
            
            default: 
                buyKnight(player);
        }
    }
    static void buyMage(Player player){
        Scanner scanner = new Scanner(System.in);
        String character = "Mage";
        System.out.println("Which mage do you want to buy? (Choose from 1-5, Press any other key to go back)");
        System.out.println("\t1. Warlock\t100 GC");
        System.out.println("\t2. Illusionist\t120 GC");
        System.out.println("\t3. Enchanter\t160 GC");
        System.out.println("\t4. Conjurer\t195 GC");
        System.out.println("\t5. Eldritch\t270 GC");
        String choice = scanner.next();
        if (!((choice.equals("1"))||(choice.equals("2"))||(choice.equals("3"))||(choice.equals("4"))||(choice.equals("5")))){
            Main.welcomePage(player);
        }
        int n = Integer.parseInt(choice)+2;
        String value;
        switch (choice){
            case "1":
            value = "Warlock";
                if (!checkExist(player,character,choice)){
                    if (buy(player,100)){
                    defaultCharacterSet(player, 7, value);
                    FileReadWrite.writeNthLine(player.getUserName(),7,n,value);
                    Main.welcomePage(player);
                    }
                    
                }
                buyMage(player);
            case "2":
            value = "Illusionist";
                if (!checkExist(player,character,choice)){
                    if (buy(player,120)){
                    defaultCharacterSet(player, 7, value);
                    FileReadWrite.writeNthLine(player.getUserName(),7,n,value);
                    Main.welcomePage(player);
                    }
                    
                }
                buyMage(player);
            case "3":
                value = "Enchanter";
                    if (!checkExist(player,character,choice)){
                        if (buy(player,160)){
                        defaultCharacterSet(player, 7, value);
                        FileReadWrite.writeNthLine(player.getUserName(),7,n,value);
                        }
                        Main.welcomePage(player);
                    }
                    buyMage(player);
            case "4":
                value = "Conjurer";
                    if (!checkExist(player,character,choice)){
                        if (buy(player,195)){
                        defaultCharacterSet(player, 7, value);
                        FileReadWrite.writeNthLine(player.getUserName(),7,n,value);
                        }
                        Main.welcomePage(player);
                    }
                    buyMage(player);
            case "5":
            value = "Eldritch";
                if (!checkExist(player,character,choice)){
                    if (buy(player,270)){
                    defaultCharacterSet(player, 7, value);
                    FileReadWrite.writeNthLine(player.getUserName(),7,n,value);
                    }
                    Main.welcomePage(player);
                }
                buyMage(player);
            
            default: 
                buyMage(player);
        }
    }
    
       static void buyHealer(Player player){
        Scanner scanner = new Scanner(System.in);
        String character = "Healer";
        System.out.println("Which healer do you want to buy? (Choose from 1-5, Press any other key to go back)");
        System.out.println("\t1. Soother\t95 GC");
        System.out.println("\t2. Medic\t125 GC");
        System.out.println("\t3. Alchemist\t150 GC");
        System.out.println("\t4. Saint\t200 GC");
        System.out.println("\t5. Lightbringer\t260 GC");
        String choice = scanner.next();
        if (!((choice.equals("1"))||(choice.equals("2"))||(choice.equals("3"))||(choice.equals("4"))||(choice.equals("5")))){
            Main.welcomePage(player);
        }
        int n = Integer.parseInt(choice)+2;
        String value;
        switch (choice){
            case "1":
                value = "Soother";
                if (!checkExist(player, character, choice)){
                    if (buy(player, 95)){
                        defaultCharacterSet(player, 8, value);
                        FileReadWrite.writeNthLine(player.getUserName(), 8, n, value);
                    }
                    Main.welcomePage(player);
                }
                buyHealer(player);
            case "2":
                value = "Medic";
                if (!checkExist(player, character, choice)){
                    if (buy(player, 125)){
                        defaultCharacterSet(player, 8, value);
                        FileReadWrite.writeNthLine(player.getUserName(), 8, n, value);
                    }
                    Main.welcomePage(player);
                }
                buyHealer(player);
            case "3":
                value = "Alchemist";
                if (!checkExist(player, character, choice)){
                    if (buy(player, 150)){
                        defaultCharacterSet(player, 8, value);
                        FileReadWrite.writeNthLine(player.getUserName(), 8, n, value);
                    }
                    Main.welcomePage(player);
                }
                buyHealer(player);
            case "4":
                value = "Saint";
                if (!checkExist(player, character, choice)){
                    if (buy(player, 200)){
                        defaultCharacterSet(player, 8, value);
                        FileReadWrite.writeNthLine(player.getUserName(), 8, n, value);
                    }
                    Main.welcomePage(player);
                }
                buyHealer(player);
            case "5":
                value = "Lightbringer";
                if (!checkExist(player, character, choice)){
                    if (buy(player, 260)){
                        defaultCharacterSet(player, 8, value);
                        FileReadWrite.writeNthLine(player.getUserName(), 8, n, value);
                    }
                    Main.welcomePage(player);
                }
                buyHealer(player);
            default:
                buyHealer(player);
        }
    }
    static void buyCreature(Player player){
        Scanner scanner = new Scanner(System.in);
        String character = "Creature";
        System.out.println("Which creature do you want to buy? (Choose from 1-5, Press any other key to go back)");
        System.out.println("\t1. Dragon\t120 GC");
        System.out.println("\t2. Basilisk\t165 GC");
        System.out.println("\t3. Hydra\t205 GC");
        System.out.println("\t4. Phoenix\t275 GC");
        System.out.println("\t5. Pegasus\t340 GC");
        String choice = scanner.next();
        if (!((choice.equals("1"))||(choice.equals("2"))||(choice.equals("3"))||(choice.equals("4"))||(choice.equals("5")))){
            Main.welcomePage(player);
        }
        int n = Integer.parseInt(choice)+2;
        String value;
        switch (choice){
            case "1":
                value = "Dragon";
                if (!checkExist(player, character, choice)){
                    if (buy(player, 120)){
                        defaultCharacterSet(player, 9, value);
                        FileReadWrite.writeNthLine(player.getUserName(), 9, n, value);
                    }
                    Main.welcomePage(player);
                }
                buyCreature(player);
            case "2":
                value = "Basilisk";
                if (!checkExist(player, character, choice)){
                    if (buy(player, 165)){
                        defaultCharacterSet(player, 9, value);
                        FileReadWrite.writeNthLine(player.getUserName(), 9, n, value);
                    }
                    Main.welcomePage(player);
                }
                buyCreature(player);
            case "3":
                value = "Hydra";
                if (!checkExist(player, character, choice)){
                    if (buy(player, 205)){
                        defaultCharacterSet(player, 9, value);
                        FileReadWrite.writeNthLine(player.getUserName(), 9, n, value);
                    }
                    Main.welcomePage(player);
                }
                buyCreature(player);
            case "4":
                value = "Phoenix";
                if (!checkExist(player, character, choice)){
                    if (buy(player, 275)){
                        defaultCharacterSet(player, 9, value);
                        FileReadWrite.writeNthLine(player.getUserName(), 9, n, value);
                    }
                    Main.welcomePage(player);
                }
                buyCreature(player);
            case "5":
                value = "Pegasus";
                if (!checkExist(player, character, choice)){
                    if (buy(player, 340)){
                        defaultCharacterSet(player, 9, value);
                        FileReadWrite.writeNthLine(player.getUserName(), 9, n, value);
                    }
                    Main.welcomePage(player);
                }
                buyCreature(player);
            default:
                buyCreature(player);
        }
    }
    
    
    

}

