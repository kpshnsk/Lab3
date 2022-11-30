package Fighth;
import Droids.Droid;
import Team.Team;
import java.util.List;
import java.util.Random;

public class Fighth {
    public static StringBuilder sb = new StringBuilder();//запис бою,який потім передається до файлу

 //битва команд
    public static void startWar(Team t1, Team t2, int size) {
        sb.delete(0, sb.length());
        int n1 = 0, n2 = 0;
        int i =1;
        Random r = new Random();
        while (true) {
            if(i == 1) {
                printOpponents(t1.droids().get(n1), t2.droids().get(n2), 1);
                fight(t1.droids().get(n1), t2.droids().get(n2));
                if(t2.droids().get(n2).isDamaged()) RecoverAndPrint(t2, n2, size, 2);

                if (isDead(t2.droids().get(n2))) {
                    printWhoIsKilled(t2.droids().get(n2),1);
                    if (n2 < size - 1) n2++;
                    else {
                        printResult(1);
                        break;
                    }
                }
                i++;
            }
            else {
                printOpponents(t2.droids().get(n2), t1.droids().get(n1), 2);
                fight(t2.droids().get(n2), t1.droids().get(n1));
                if(t1.droids().get(n1).isDamaged()) RecoverAndPrint(t1, n1, size, 1);
                if (isDead(t1.droids().get(n1))){
                    printWhoIsKilled(t1.droids().get(n1),2);
                    if (n1 < size - 1) n1++;
                    else{
                        printResult(2);
                        break;
                    }
                }
                i--;
            }
        }
    }

    //метод, що виносить суперників
    public static void printOpponents(Droid d1, Droid d2, int num) {
        if(num==1) {
            System.out.printf(d1.getName() + "1 VS " + d2.getName() + "2: ");
            sb.append(d1.getName() + "1 VS " + d2.getName() + "2: ");
        }
        else{
            System.out.printf(d1.getName() + "2 VS " + d2.getName() + "1: ");
            sb.append(d1.getName() + "2 VS " + d2.getName() + "1: ");
        }
    }

    //битва
    public static void fight(Droid d1, Droid d2){
        int damage;

        damage = d1.attack();
        if(d1.getHealth() < 1000 && d1.getHealth() > 0)damage -= 100;

        d2.getHit(damage,d1);
    }


     //метод, який перевіряє чи серед гравців команди є лікар

    public static boolean hasDoctor(List<Droid> list, int n, int size){
        for(int i = n+1; i < size; i++){
            if(list.get(i).getName().equals("Doctor"))return true;
        }
        return false;
    }

    //відновлення здоров'я
    public static void RecoverAndPrint(Team t2, int n2, int size, int n) {
        if (hasDoctor(t2.droids(), n2, size) && t2.droids().get(n2).getHealth() > 0) {
            t2.droids().get(n2).setHealth(t2.droids().get(n2).getHealth() + 100);
            if(n==1){
                System.out.println(t2.droids().get(n2).getName() + "1"+ " +100");
                sb.append(t2.droids().get(n2).getName() + "1"+" +100\n");
            }
            else{
                System.out.println(t2.droids().get(n2).getName() + "2" + " +100");
                sb.append(t2.droids().get(n2).getName() + "2" + " +100\n");
            }
        }
    }
    //Перевірка, чи живий дроїд
    public static boolean isDead(Droid d) {
        return d.getHealth() <= 0;
    }

   //виведення мертвого дроїда
    public static void printWhoIsKilled(Droid d,int num){
        if(num==1){
            System.out.println(d.getName() + "2 is killed");
            sb.append(d.getName() + "2 is killed\n");
        }
        else{
            System.out.println(d.getName() + "1 is killed");
            sb.append(d.getName() + "1 is killed\n");
        }
    }

   //результат битви
    public static void printResult(int num){
        if(num==1) {
            System.out.println("Team 2 has lost.");
            System.out.println("Team 1, congratulate you on your victory! :)");
            sb.append("Team 2 has lost.\n" +"Team 1, congratulate you on your victory! :)\n");
        }
        else{
            System.out.println("Team 1 has lost.");
            System.out.println("Team 2, congratulate you on your victory! :)");
            sb.append("Team 1 has lost.\n" + "Team 2, congratulate you on your victory! :)\n");
        }
    }
}
