import java.util.Scanner;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class War {
    public static void goToWar(Player player) {
        String warWith = FileReadWrite.readNthLine(player.getUserName(),10)[1];
        String declaredBy = FileReadWrite.readNthLine(player.getUserName(),10)[2];
        Scanner scanner = new Scanner(System.in);
        if (warWith.equals("None")){
            System.out.println("--------------------------------------");
            System.out.println("You don't have war declarations or war invitations!");
            scanner.next();
            Main.welcomePage(player);
        }
        if ((!(warWith.equals(declaredBy))) && (declaredBy.equals(player.getUserName()))){
            System.out.println("--------------------------------------");
            System.out.println("Your war invitation is not accepted yet!");
            scanner.next();
            Main.welcomePage(player);
        }
        
        System.out.println("--------------------------------------");
        System.out.println("There is a war declaration from "+declaredBy+"!");
        System.out.println("Do you want to accept the war?");
        System.out.println("\t1. Yes");
        System.out.println("\t2. No");
        String choice = scanner.next();
        switch (choice) {
            case "1":
                Player challenger = new Player(declaredBy);
               
                battle(challenger,player);
                Main.welcomePage(player);
                break;
            case "2":
                FileReadWrite.writeNthLine(declaredBy, 10, 1, "None");
                FileReadWrite.writeNthLine(player.getUserName(), 10, 1,"None");
                FileReadWrite.writeNthLine(player.getUserName(), 10, 2, "None");
                FileReadWrite.writeNthLine(declaredBy, 10, 2,"None");
                System.out.println("War invitation is denied!");
                Main.welcomePage(player);
                break;
            default:
                Main.welcomePage(player);
                break;
        }

    }

    public static void battle(Player declarer, Player opponent){
        Player challenger = declarer;
        Player challenged = opponent;
        String homeland = opponent.getHomeland();


        challenger.getArcher().setCharacterForBattle(homeland);
        challenger.getKnight().setCharacterForBattle(homeland);
        challenger.getMage().setCharacterForBattle(homeland);
        challenger.getHealer().setCharacterForBattle(homeland);
        challenger.getCreature().setCharacterForBattle(homeland);

        challenged.getArcher().setCharacterForBattle(homeland);
        challenged.getKnight().setCharacterForBattle(homeland);
        challenged.getMage().setCharacterForBattle(homeland);
        challenged.getHealer().setCharacterForBattle(homeland);
        challenged.getCreature().setCharacterForBattle(homeland);

        ArrayList<Character> challegerArmy = attackArmy(challenger);
        ArrayList<Character> challengedArmy = attackArmy(challenged);

        int turn = 1;
        while (turn < 21){
 
            if ((declarer.getArcher().getHealth()<=0)&&
                (declarer.getKnight().getHealth()<=0)&&
                (declarer.getMage().getHealth()<=0)&&
                (declarer.getHealer().getHealth()<=0)&&
                (declarer.getCreature().getHealth()<=0)){
                System.out.println(opponent.getName()+" won!");
                int oGC= opponent.getGC();
                int oXP= opponent.getXP();
                int dGC= declarer.getGC();
                int dXP= declarer.getXP();
                int winningAmount =(int) Math.round((0.1)*dGC);
                opponent.addGC(winningAmount);
                declarer.deductGC(winningAmount);
                opponent.addXP(+1);
                System.out.println(challenger.getName()+" XP: "+challenger.getXP()+" gold coin: "+challenger.getGC());
                System.out.println(challenged.getName()+" XP: "+challenged.getXP()+" gold coin: "+challenged.getGC());
                FileReadWrite.writeNthLine(challenger.getUserName(),3,1,challenger.getGC()+"");
                FileReadWrite.writeNthLine(challenged.getUserName(),3,1,challenged.getGC()+"");
                FileReadWrite.writeNthLine(challenger.getUserName(),4,1,challenger.getXP()+"");
                System.exit(0);
                break;
            }
            if ((opponent.getArcher().getHealth() <= 0) && 
                (opponent.getKnight().getHealth() <= 0) && 
                (opponent.getMage().getHealth() <= 0) && 
                (opponent.getHealer().getHealth() <= 0) && 
                (opponent.getCreature().getHealth() <= 0)) {
                System.out.println(declarer.getName() + " won!");
                int oGC= opponent.getGC();
                int oXP= opponent.getXP();
                int dGC= declarer.getGC();
                int dXP= declarer.getXP();
                int winningAmount =(int) Math.round((0.1)*oGC);
                declarer.addGC(winningAmount);
                opponent.deductGC(winningAmount);
                declarer.addXP(+1);
                System.out.println(challenger.getName()+" XP: "+challenger.getXP()+" gold coin: "+challenger.getGC());
                System.out.println(challenged.getName()+" XP: "+challenged.getXP()+" gold coin: "+challenged.getGC());
                FileReadWrite.writeNthLine(challenger.getUserName(),3,1,challenger.getGC()+"");
                FileReadWrite.writeNthLine(challenged.getUserName(),3,1,challenged.getGC()+"");
                FileReadWrite.writeNthLine(challenger.getUserName(),4,1,challenger.getXP()+"");
                System.exit(0);
                break;
            }
            
            // if (turn%2 == 1){
            //     System.out.println("Turn "+turn+": "+ declarer.getName());
            //     attackOnTurn(declarer, opponent, homeland);
            // }
            // else{
            //     System.out.println("Turn "+turn+": "+ opponent.getName());
            //     attackOnTurn(opponent, declarer, homeland);
            // }
            System.out.println("--------------------------------------");
            System.out.println("Turn "+turn+": "+ declarer.getName());
            attackOnTurn(declarer, opponent, homeland, challegerArmy, challengedArmy);
        Player temp = opponent;
        opponent = declarer;
        declarer = temp;

        ArrayList<Character> tempArr;
        tempArr = challengedArmy;
        challengedArmy = challegerArmy;
        challegerArmy = tempArr;


        turn++;
        }
        if (turn == 21){
        System.out.println();
        System.out.println("Draw");
        System.out.println(challenger.getName()+" XP: "+challenger.getXP()+" gold coin: "+challenger.getGC());
        System.out.println(challenged.getName()+" XP: "+challenged.getXP()+" gold coin: "+challenged.getGC());
        }
        FileReadWrite.writeNthLine(challenger.getUserName(), 10, 1, "None");
        FileReadWrite.writeNthLine(challenger.getUserName(), 10, 2, "None");
        FileReadWrite.writeNthLine(challenged.getUserName(), 10, 1, "None");
        FileReadWrite.writeNthLine(challenged.getUserName(), 10, 2, "None");
        System.exit(0);
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();


    }
    // public static Character getAttacker(Player player){
    //     ArrayList<String> armys = new ArrayList<String>();
    //     ArrayList<Character> army = new ArrayList<Character>();
    //     if (!(player.getArcher().getCurrent().equals("None"))){
    //         army.add(player.getArcher());
    //     }
    //     if (!(player.getKnight().getCurrent().equals("None"))){
    //         army.add(player.getKnight());
    //     }
    //     if (!(player.getMage().getCurrent().equals("None"))){
    //         army.add(player.getMage());
    //     }
    //     if (!(player.getHealer().getCurrent().equals("None"))){
    //         army.add(player.getHealer());
    //     }
    //     if (!(player.getCreature().getCurrent().equals("None"))){
    //         army.add(player.getCreature());
    //     }
    //     ArrayList<Character> alive = new ArrayList<Character>();
    //     for (Character character: army){
    //         if (character.getHealth()>= 0){
    //             alive.add(character);
    //         }
    //     }
    //     Character CharacterWithHighSpeed = alive.get(0);

    //     for (Character character: alive){
    //         if (character.getSpeed() > CharacterWithHighSpeed.getSpeed()){
    //             CharacterWithHighSpeed = character;
    //         }else if (character.getSpeed()==CharacterWithHighSpeed.getSpeed()) {
    //             if (character.getCharacter().equals("Archer")){
    //                 CharacterWithHighSpeed = character;
    //             }else if (character.getCharacter().equals("Knight")){
    //                 CharacterWithHighSpeed = character;
    //             }else if (character.getCharacter().equals("Creature")){
    //                 CharacterWithHighSpeed = character;
    //             }else if (character.getCharacter().equals("Mage")){
    //                 CharacterWithHighSpeed = character;
    //             }else if (character.getCharacter().equals("Healer")){
    //                 CharacterWithHighSpeed = character;
    //             }
    //         }
    //     }
    //     return CharacterWithHighSpeed;
    // }
    public static ArrayList<Character> attackArmy(Player player){
        ArrayList<Character> army = new ArrayList<Character>();
        if (!(player.getArcher().getCurrent().equals("None"))){
            army.add(player.getArcher());
        }
        if (!(player.getKnight().getCurrent().equals("None"))){
            army.add(player.getKnight());
        }
        if (!(player.getMage().getCurrent().equals("None"))){
            army.add(player.getMage());
        }
        if (!(player.getHealer().getCurrent().equals("None"))){
            army.add(player.getHealer());
        }
        if (!(player.getCreature().getCurrent().equals("None"))){
            army.add(player.getCreature());
        }
        //print character in army
        // for (Character character: army){
        //     System.out.println(character.getCurrent()+character.getSpeed());
        // }

        int i=0;
        int size = army.size(); 
        ArrayList<Character> armyAccordingToSpeed = new ArrayList<Character>();
        while (i< size){
            Character CharacterWithHighSpeed = army.get(0);
            for (Character character: army){
                if (character.getSpeed() > CharacterWithHighSpeed.getSpeed()){
                    CharacterWithHighSpeed = character;
                }else if (character.getSpeed()==CharacterWithHighSpeed.getSpeed()) {
                    //create a new list
                    List<String> order = new ArrayList<String>();
                    order.add("Archer");
                    order.add("Knight");
                    order.add("Creature");
                    order.add("Mage");
                    order.add("Healer");
                    if (order.indexOf(character.getCharacter())<order.indexOf(CharacterWithHighSpeed.getCharacter())){
                        CharacterWithHighSpeed = character;
                    }
                }

            }
            armyAccordingToSpeed.add(CharacterWithHighSpeed);
            army.remove(CharacterWithHighSpeed);
            i++;
        }
        return armyAccordingToSpeed;
    }









    public static Character getDefender(Player player){
        ArrayList<Character> army = new ArrayList<Character>();
        if (!(player.getArcher().getCurrent().equals("None"))){
            army.add(player.getArcher());
        }
        if (!(player.getKnight().getCurrent().equals("None"))){
            army.add(player.getKnight());
        }
        if (!(player.getMage().getCurrent().equals("None"))){
            army.add(player.getMage());
        }
        if (!(player.getHealer().getCurrent().equals("None"))){
            army.add(player.getHealer());
        }
        if (!(player.getCreature().getCurrent().equals("None"))){
            army.add(player.getCreature());
        }
        ArrayList<Character> alive = new ArrayList<Character>();
        for (Character character: army){
            if (character.getHealth()> 0){
                alive.add(character);
            }
        }
        Character CharacterWithLowDefend = alive.get(0);
        for (Character character: alive){
            if (character.getDefence() < CharacterWithLowDefend.getDefence()){
                CharacterWithLowDefend = character;
            }else if (character.getDefence()==CharacterWithLowDefend.getDefence()) {
                List<String> order = new ArrayList<String>();
                order.add("Healer");
                order.add("Creature");
                order.add("Archer");
                order.add("Knight");
                order.add("Mage");
                if (order.indexOf(character.getCharacter())<order.indexOf(CharacterWithLowDefend.getCharacter())){
                    CharacterWithLowDefend= character;
                }
            }
        }
        return CharacterWithLowDefend;
    }
    public static Character getLowHealth(Player player){
        ArrayList<Character> army = new ArrayList<Character>();
        army.add(player.getArcher());
        army.add(player.getKnight());
        army.add(player.getMage());
        army.add(player.getHealer());
        army.add(player.getCreature());
        ArrayList<Character> alive = new ArrayList<Character>();
        for (Character character: army){
            if (character.getHealth()>= 0){
                alive.add(character);
            }
        }
        Character CharacterWithLowHealth = alive.get(0);
        for (Character character: alive){
            if (character.getHealth() < CharacterWithLowHealth.getDefence()){
                CharacterWithLowHealth = character;
            }else if (character.getDefence()==CharacterWithLowHealth.getDefence()) {
                if (character.getCharacter().equals("Healer")){
                    CharacterWithLowHealth = character;
                }else if (character.getCharacter().equals("Creature")){
                    CharacterWithLowHealth = character;
                }else if (character.getCharacter().equals("Archer")){
                    CharacterWithLowHealth = character;
                }else if (character.getCharacter().equals("Knight")){
                    CharacterWithLowHealth = character;
                }else if (character.getCharacter().equals("Mage")){
                    CharacterWithLowHealth = character;
                }
            }
        }
        return CharacterWithLowHealth;
    }
    public static Character getLowHealthForHealing(Player player){
        ArrayList<Character> army = new ArrayList<Character>();
        army.add(player.getArcher());
        army.add(player.getKnight());
        army.add(player.getMage());
        army.add(player.getHealer());
        army.add(player.getCreature());
        ArrayList<Character> alive = new ArrayList<Character>();
        for (Character character: army){
            if (character.getHealth()>= 0 && !(character.getCharacter().equals("Healer"))){
                alive.add(character);
            }
        }
        Character CharacterWithLowHealth = alive.get(0);
        for (Character character: alive){
            if (character.getHealth() < CharacterWithLowHealth.getDefence()){
                CharacterWithLowHealth = character;
            }else if (character.getDefence()==CharacterWithLowHealth.getDefence()) {
                if (character.getCharacter().equals("Healer")){
                    CharacterWithLowHealth = character;
                }else if (character.getCharacter().equals("Creature")){
                    CharacterWithLowHealth = character;
                }else if (character.getCharacter().equals("Archer")){
                    CharacterWithLowHealth = character;
                }else if (character.getCharacter().equals("Knight")){
                    CharacterWithLowHealth = character;
                }else if (character.getCharacter().equals("Mage")){
                    CharacterWithLowHealth = character;
                }
            }
        }
        return CharacterWithLowHealth;
    }
    public static void attackOnTurn(Player attacker, Player defender, String homeland, ArrayList<Character>  attackArmy, ArrayList<Character>defendArmy){
        DecimalFormat df = new DecimalFormat("#.#");
        //Character attackCharacter = getAttacker(attacker);
        Character attackCharacter = attackArmy.get(0);;
        Character defendCharacter = getDefender(defender);

        if (homeland.equals("Arcane")&&defendCharacter.getHomelandCategory().equals("Mystics")){
            double health = attackCharacter.getAttack()*(0.1);
            defendCharacter.addHealth(df.format(health));
        }
        if (attackCharacter.getCharacter().equals("Healer")){
            Character lowHealthCharacter = getLowHealth(attacker);
            double health = attackCharacter.getAttack()*(0.1);
            //System.out.println(lowHealthCharacter.getHealth());
            lowHealthCharacter.addHealth(Double.parseDouble(df.format(health)));
            System.out.println(attackCharacter.getCurrent()+" heals " + lowHealthCharacter.getCurrent());
            //System.out.println(lowHealthCharacter.getCurrent()+"'s healed health: " + (Double.parseDouble(df.format(lowHealthCharacter.getHealth()))));
            System.out.println(attackCharacter.getCurrent()+"'s health: " + (Double.parseDouble(df.format(attackCharacter.getHealth()))));
            System.out.println(lowHealthCharacter.getCurrent()+"'s health: " + (Double.parseDouble(df.format(lowHealthCharacter.getHealth()))));
            
        }else{
            System.out.println(attackCharacter.getCurrent()+" attacks " + defendCharacter.getCurrent());
            double health = attackCharacter.getAttack()*(0.5) - defendCharacter.getDefence()*(0.1);
            defendCharacter.subtractHealth(Double.parseDouble(df.format(health)));
            if (defendCharacter.getHealth()<=0){
                System.out.println(defendCharacter.getCurrent()+" died!");
                defendArmy.remove(defendCharacter);
            }else{
            System.out.println(defendCharacter.getCurrent()+"'s health: " + df.format(defendCharacter.getHealth()));
            }
            System.out.println(attackCharacter.getCurrent()+"'s health: " + df.format(attackCharacter.getHealth()));
        }

        if (homeland.equals("Hillcrest")&&attackCharacter.getHomelandCategory().equals("Highlanders")){
            System.out.println("--------------------------------------");
            System.out.println("Bonus turn");
            double attack = attackCharacter.getAttack()*(1.2);
            if (attackCharacter.getCharacter().equals("Healer")){
                Character lowHealthCharacter = getLowHealth(attacker);
                double health = attack*(0.1);
                lowHealthCharacter.addHealth(Double.parseDouble(df.format(health)));
                System.out.println(attackCharacter.getCurrent()+" heals " + (Double.parseDouble(df.format(lowHealthCharacter.getHealth()))));
                //System.out.println(defendCharacter.getCurrent()+"'s health: " + defendCharacter.getCurrent());
                System.out.println(attackCharacter.getCurrent()+"'s health: " + (Double.parseDouble(df.format(attackCharacter.getHealth()))));
                System.out.println(lowHealthCharacter.getCurrent()+"'s health: " + (Double.parseDouble(df.format(lowHealthCharacter.getHealth()))));
                
    
            }else{
                System.out.println(attackCharacter.getCurrent()+" attacks " + defendCharacter.getCurrent());
                double health = attack*(0.5) - defendCharacter.getDefence()*(0.1);
                defendCharacter.subtractHealth(Double.parseDouble(df.format(health)));
                if (defendCharacter.getHealth()<=0){
                    System.out.println(defendCharacter.getCurrent()+" died!");
                    defendArmy.remove(defendCharacter);
                }else{
                System.out.println(defendCharacter.getCurrent()+"'s health: " + df.format(defendCharacter.getHealth()));
                }
                System.out.println(attackCharacter.getCurrent()+"'s health: " + df.format(attackCharacter.getHealth()));
            }
        }
        attackArmy.remove(attackCharacter);
        attackArmy.add(attackCharacter);
    }

}
