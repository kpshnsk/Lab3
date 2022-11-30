package Droids;
import java.util.Random;
import Fighth.Fighth;

    public class  PilotDroid extends Droid {
        private final int chanceMagicAttack;
        private final int magicAttack;
        private final int chanceCriticalAttack;
        private final int criticalAttack;
        private final int chanceToEscape;

        //конструктор
        public PilotDroid() {
            super(1000, 250, "FlyingMan");
            chanceMagicAttack = 35;
            magicAttack = 1500;
            chanceCriticalAttack = 35;
            criticalAttack = 1000;
            chanceToEscape = 45;
        }
        //атака
        public int attack()
        {
            Random random = new Random();
            if (random.nextInt(100) < chanceCriticalAttack){
                System.out.println("Critical attack! " + criticalAttack);
                Fighth.sb.append("Critical attack! " +criticalAttack + "\n");
                return criticalAttack;
            }
            else{
                if (random.nextInt(100) < chanceMagicAttack){
                    System.out.println("Magic attack! " +magicAttack);
                    Fighth.sb.append("Magic attack! " +magicAttack+"\n");
                    return magicAttack;
                }
                else return damage;
            }
        }
    //отримання атаки
        public void getHit(int damage, Droid d) {
            Random random = new Random();
            if(random.nextInt(100) < chanceToEscape){
                System.out.println("FlyingMan isn`t damaged");
                Fighth.sb.append("FlyingMan isn`t damaged\n");
                isDamaged = false;
            }
            else {

                isDamaged = true;
            }
        }
    }



