package Droids;
import Fighth.Fighth;

import java.util.Random;
//лікар
public class DoctorDroid extends Droid {
    private final int criticalAttack;
    private final int chanceCriticalAttack;
    private final int chanceToEscape;

    //конструктор
    public DoctorDroid() {
        super(1000, 150, "Doctor");
        criticalAttack = 50;
        chanceCriticalAttack = 35;
        chanceToEscape = 45;

    }
    //атака
    public int attack() {

        Random random = new Random();
        if (random.nextInt(100) > chanceCriticalAttack) {
            System.out.println("Critical attack! " + criticalAttack);
            Fighth.sb.append("Critical attack! " +criticalAttack + "\n");
        }
        return damage;
    }
    public void getHit(int damage, Droid d) {
        Random random = new Random();
        if(random.nextInt(100) < chanceToEscape){
            System.out.println("Doctor isn`t damaged");
            Fighth.sb.append("Doctor isn`t damaged\n");
            isDamaged = false;
        }
        else {

            isDamaged = true;
        }
    }
}


