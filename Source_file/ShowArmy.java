import java.util.Scanner;
public class ShowArmy {
    public static void showArmy(Player player) {
        try{
        Scanner scanner = new Scanner(System.in);
        System.out.println("--------------------------------------");
        System.out.println("Select an army catergory to veiw:");
        System.out.println("(Any other key to go back)");
        System.out.println("\t1. Archer");
        System.out.println("\t2. Knight");
        System.out.println("\t3. Mage");
        System.out.println("\t4. Healer");
        System.out.println("\t5. Creature");

        String choice = scanner.next();
        int line = Integer.parseInt(choice)+4;
        String[] getAllValues = FileReadWrite.readNthLine(player.getUserName(), line);
        String[] getChar = {getAllValues[3], getAllValues[4], getAllValues[5], getAllValues[6], getAllValues[7]};
        String currentChar = FileReadWrite.readNthLine(player.getUserName(), line)[8];
        int count = 1;
        for (String i: getChar) {
            if (!(i.equals("None"))){
                count++;
            }
        }
        if (count==1){
            System.out.println("You have no army of this category!");
            showArmy(player);
        }else{
            int count2 = 1;
            System.out.println("Here is your "+getAllValues[0]+" army!");
            for (String i: getChar) {
                if (!(i.equals("None"))){
                    System.out.println("\t"+count2+". "+i);
                    count2++;
                }
            }
        }
        System.out.println(""+currentChar+" is the current "+FileReadWrite.readNthLine(player.getUserName(), line)[0]);
        if ((( 
            !(getAllValues[0].equals("None"))||
            !(getAllValues[1].equals("None"))||
            !(getAllValues[2].equals("None"))||
            !(getAllValues[3].equals("None"))||
            !(getAllValues[4].equals("None"))
        )&&(FileReadWrite.readNthLine(player.getUserName(), line)[8].equals("None"))) || (count>2)){
            System.out.println("If you want to change the current "+getAllValues[0]+", Select new character :");
            System.out.println("Press any other to go back");
            String choice3 = scanner.next();
            try{
            int choice4 = Integer.parseInt(choice3);
            if ((choice4>0)&&(choice4<=count)){
                int count2 = 1;
                for (String i: getChar) {
                    if (count2 == choice4){
                        FileReadWrite.writeNthLine(player.getUserName(),line,8,i);
                        System.out.println("Your current character of this army successfully changed!");
                        Main.welcomePage(player);
                    }
                    if (!(i.equals("None"))){
                        count2++;
                    }

                }
                
            }
            }catch(Exception e){
                showArmy(player);
            }
        }
    }catch(Exception e){
        Main.welcomePage(player);
    }
    showArmy(player);
}
}
