package Droids;

import java.util.Random;
import static Fighth.Fighth.sb;

//вбивця
public class KillerDroid extends Droid {
    private final int chanceCriticalAttack;
    private final int criticalAttack;
    private final int chanceToEscape;

//конструктор
    public KillerDroid() {
        super(1000, 300,"Killer");
        chanceCriticalAttack = 35;
        criticalAttack = 1000;
        chanceToEscape = 45;
    }

    //атака
    public int attack()
    {
        Random random = new Random();
        if (random.nextInt(100) > chanceCriticalAttack) return damage;
        else{
            System.out.println("Critical attack! " +criticalAttack);
            sb.append("Critical attack! ").append(criticalAttack).append("\n");
            return criticalAttack;
        }
    }
//отримання удару
    public void getHit(int damage, Droid d)
    {
        Random random = new Random();
        if(random.nextInt(100) < chanceToEscape){
            System.out.println("Killer has super armor that reflects the hit!");
            sb.append("Killer has super armor that reflects the hit!" + "\n");
            isDamaged = false;
        }
        else {

            isDamaged = true;
        }


    }
}

