package pacman;
import java.util.*;
public class Pacman 
{
    public static void main(String[] args) 
    {
        Playman play = new Playman ();
        Scanner input = new Scanner (System.in);
        String p="s",in;
        while (p.equals("s")){
            System.out.print("Input s to start q to quit : ");
            p = input.next();
            if (p.equals("s"))
            {
                play.start();
                while (play.play()){
                    play.getStat();
                    System.out.print("Masukkan input (w,a,s,d) : ");
                    in = input.next();
                    switch (in){
                        case "w" : play.moveUp();break;
                        case "a" : play.moveLeft();break;
                        case "s" : play.moveDown();break;
                        case "d" : play.moveRight();break;
                    }
                }
                
            }
        }
    }    
}