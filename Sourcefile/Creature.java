public class Creature extends Character {
    private String setArm;
    private String setArte;
    private int[] setCreatureValues;

    public Creature(Player player,String homeland){
        super(getCurrent(player.getUserName()),getArmour(player.getUserName()),getArtefact(player.getUserName()),getStats(player.getUserName()),homeland,"Creature");
  }
  static String getCurrent(String userName){
      return FileReadWrite.readNthLine(userName, 9)[8];
  }

    static String getArmour(String userName) {
        return FileReadWrite.readNthLine(userName, 9)[1];
    }

    static String getArtefact(String userName) {
        return FileReadWrite.readNthLine(userName, 9)[2];
    }

    static int[] getStats(String userName) {
        String current = FileReadWrite.readNthLine(userName, 9)[8];
        int attack, defence, health, speed;
        switch (current) {
            case "Dragon":
                int[] stats0 = {12, 14, 15, 8};
                return stats0;

            case "Basilisk":
                int[] stats1 = {15, 11, 10, 12};
                return stats1;

            case "Hydra":
                int[] stats2 = {12, 16, 15, 11};
                return stats2;

            case "Phoenix":
                int[] stats3 = {17, 13, 17, 19};
                return stats3;

            case "Pegasus":
                int[] stats4 = {14, 18, 20, 20};
                return stats4;

            case "None":
                int[] stats5 = {0, 0, 0, 0};
                return stats5;
        }
        return null;
    }

    // public void setCreature(String userName) {
    //     this.setArm = FileReadWrite.readNthLine(userName, 9)[1];
    //     this.setArte = FileReadWrite.readNthLine(userName, 9)[2];
    //     this.setCreatureValues = getStats(userName);
    //     setCharacter(this.setCreatureValues, this.setArte, this.setArm);
    // }

}
