package Team;
import Droids.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//представлення команди
public class Team {
    private int size;
    private List<Droid> droidsList = new ArrayList<>();
    //конструктор
    public Team(int size){
        this.size = size;
    }
    //створення команди
    public void createTeam(){
        Scanner sc = new Scanner(System.in);
        for(int i = 0; i < size; i++)
            droidsList.add(getDroid(sc.next()));
    }

    //повернення дроїда
    public Droid getDroid(String name){
        if (name.equals("Doctor"))return new DoctorDroid();
        if (name.equals("FlyingMan"))return new PilotDroid();
        else return new KillerDroid();
    }

    //список дроїдів
    public List<Droid> droids(){
        return droidsList;
    }
}
