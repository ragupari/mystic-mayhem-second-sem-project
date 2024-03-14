public class Knight extends Character {
    private String setArm;
    private String setArte;
    private int[] setKnightValues;

    public Knight(Player player, String homeland){
        super(getCurrent(player.getUserName()),getArmour(player.getUserName()),getArtefact(player.getUserName()),getStats(player.getUserName()),homeland,"Knight");
  }
  static String getCurrent(String userName){
      return FileReadWrite.readNthLine(userName, 6)[8];
  }
    static String getArmour(String userName) {
        return FileReadWrite.readNthLine(userName, 6)[1];
    }

    static String getArtefact(String userName) {
        return FileReadWrite.readNthLine(userName, 6)[2];
    }

    static int[] getStats(String userName) {
        String current = FileReadWrite.readNthLine(userName, 6)[8];
        int attack, defence, health, speed;
        switch (current) {
            case "Squire":
                int[] stats0 = {8, 9, 7, 8};
                return stats0;

            case "Cavalier":
                int[] stats1 = {10, 12, 7, 10};
                return stats1;

            case "Templar":
                int[] stats2 = {14, 16, 12, 12};
                return stats2;

            case "Zoro":
                int[] stats3 = {17, 16, 13, 14};
                return stats3;

            case "Swiftblade":
                int[] stats4 = {18, 20, 17, 13};
                return stats4;

            case "None":
                int[] stats5 = {0, 0, 0, 0};
                return stats5;
        }
        return null;
    }

    // public void setKnight(String userName) {
    //     this.setArm = FileReadWrite.readNthLine(userName, 6)[1];
    //     this.setArte = FileReadWrite.readNthLine(userName, 6)[2];
    //     this.setKnightValues = getStats(userName);
    //     setCharacter(this.setKnightValues, this.setArte, this.setArm);
    // }
    
}
