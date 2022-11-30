package Droids;
import static Fighth.Fighth.sb;
//загальний клас дроїдів
public class Droid {
    protected String name;
    protected int health;
    protected int damage;
    protected boolean isDamaged;
    //конструктор
    public Droid(int health, int damage, String name) {
        this.health = health;
        this.damage = damage;
        this.name = name;
        isDamaged = false;
    }

    public int attack()
    {
        return damage;
    }
    public String getName() {
        return name;
    }

    public int getDamage() {
        return damage;
    }

    public int getHealth() {
        return health;
    }
    public boolean isDamaged() {
        return isDamaged;
    }
    public void setHealth(int health){
        this.health = health;
    }
    public void getHit(int damage, Droid d)
    {

        System.out.println(name + " -" + damage);
        sb.append(name +" -" + damage + "\n");
        isDamaged = true;
    }

    //виведення даних в вигляді символьного рядка
    @Override
    public String toString(){
        String str = name + " (health: " + health + ", damage: " + damage;
        str += ")";
        return str;
    }
}


