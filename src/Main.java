import Fighth.Fighth;
import File.DroidFile;
import Team.Team;
import java.io.IOException;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int var;
        System.out.print(menu());
        while(true){
            System.out.print("\nChoose an option: ");
            var = sc.nextInt();
            switch (var) {
                case 1 -> System.out.println(droidsList());
                case 2 -> {
                    startFighting(1);
                    DroidFile.addToFile();
                }
                case 3 -> {
                    Scanner scan = new Scanner(System.in);
                    System.out.print("\nChoose the number of droids in the team: ");
                    int size = scan.nextInt();
                    startFighting(size);
                    DroidFile.addToFile();
                }
                case 4 -> DroidFile.readFile();
                case 5 -> {
                    System.out.println("The end!:)");
                    return;
                }
            }
        }
    }
    //створення команд
    public static void startFighting(int size){
        Team t1 = new Team(size);
        Team t2 = new Team(size);
        System.out.println("\nDroids: Doctor, FlyingMan, Killer");
        if(size == 1)System.out.print("Team 1, choose 1 droid: ");
        else System.out.print("Team 1, choose " + size + " droids: ");
        t1.createTeam();
        if(size == 1)System.out.print("Team 2, choose 1 droid: ");
        else System.out.print("Team 2, choose " + size + " droids: ");
        t2.createTeam();
        System.out.println("\nThe battle has begun!");
        Fighth.startWar(t1, t2, size);
    }
    //список дроїдів
    public static String droidsList(){
        return "\nDoctor: the doctor droid has the ability to treat other droids. " +
               "\nFlyingMan: the droid is able to fly. He has ability to avoid the damage. He can use magic attack" +
                "\nKiller: the killer droid is strong, has the best health and armor .";
    }
    //меню
    public static String menu(){
        return "It is recommended to check the list of drones before starting the battle." +
                "\n1. The list of all droids." +
                "\n2. One-on-one battle." +
                "\n3. Team battle." +
                "\n4. Reproduce the final fight." +
                "\n5. An exit from the game.";
    }
}

