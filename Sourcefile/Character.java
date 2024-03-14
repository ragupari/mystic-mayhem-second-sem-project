public class Character {
    private double attack, defence, health, speed;
    private String artefact;
    private String armour;
    private String current, homelandCategory, character;
    public Character(String current,String arm,String arte,int[] charAttributes,String homeland,String character){
        this.current = current;//
        this.artefact = arte;
        this.armour = arm;
        this.character = character;
        this.homelandCategory = Homeland.getHomelandCategory(this.current);
        this.attack =(charAttributes[0]);
        this.defence = (charAttributes[1]);
        this.health =(charAttributes[2]);
        this.speed = (charAttributes[3]);

    }
    public void setCharacterForBattle(String homeland){
        int[] homelandEffect = Homeland.getStats4(this.current, homeland);
        this.attack += addAttack(homeland)+homelandEffect[0];
        this.defence += addDefence(homeland)+homelandEffect[1];
        this.health += addHealth(homeland)+homelandEffect[2];
        this.speed += addSpeed(homeland)+homelandEffect[3];
    }
    public int addAttack(String homeland) {
        int armAttack = Equipment.getStat("Armour",this.armour)[1];
        int arteAttack = Equipment.getStat("Artefact",this.artefact)[1];
        int attack = arteAttack+armAttack;
        return attack;
    }
    public int addDefence(String homeland) {
        int armDefence = Equipment.getStat("Armour",this.armour)[2];
        int arteDefence = Equipment.getStat("Artefact",this.artefact)[2];
        int defence = arteDefence+armDefence;
        return defence;
    }
    public int addHealth(String homeland) {
        int armHealth = Equipment.getStat("Armour",this.armour)[3];
        int arteHealth = Equipment.getStat("Artefact",this.artefact)[3];
        int health = arteHealth+armHealth;
        return health;
    }
    public int addSpeed(String homeland) {
        int armSpeed = Equipment.getStat("Armour",this.armour)[4];
        int arteSpeed = Equipment.getStat("Artefact",this.artefact)[4];
        int speed = arteSpeed+armSpeed;
        return speed;
    }
    
    public void addHealth(double value) {
        this.health += value;
    }
    public void subtractHealth(double value) {
        this.health -= value;
    }
    public void addAttack(double value) {
        this.attack += value;
    }
    public void subtractDefence(double value) {
        this.defence -= value;
    }
    public double getAttack() {
        
        return this.attack;
    }
    public double getDefence() {
        return this.defence;
    }
    public double getHealth() {
        return this.health;
    }
    public double getSpeed() {
        return this.speed;
    }
    public String getHomelandCategory(){
        return this.homelandCategory;
    }
    public String getCharacter() {
        return this.character;
    }
    public String getCurrent() {
        return this.current;
    }

}

