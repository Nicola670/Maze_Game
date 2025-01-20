
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.LinkedList;
import java.util.Scanner;

public class Labirinto
{

    public static LinkedList<Posizione> stack = new <Posizione>LinkedList();
    public static Posizione[][] m;
    public static Posizione inizio = new Posizione();
    public static Posizione fine = new Posizione();

    public static void CaricaLabirinto() throws FileNotFoundException
    {
        FileReader fileIn = new FileReader("labirinto.txt");
        Scanner s = new Scanner(fileIn);
        int j = 0, k = 0;
        m = new Posizione[s.nextInt()][s.nextInt()];
        //System.out.println(m.length);

        for (j = 0; j < m.length && s.hasNext(); j++)
        {
            for (k = 0; k < m[j].length && s.hasNext(); k++)
            {
                m[j][k] = new Posizione();
                m[j][k].n = s.nextInt();
                m[j][k].x = k;
                m[j][k].y = j;
                m[j][k].visitato = false;
            }
        }
        inizio.x = s.nextInt();
        inizio.y = s.nextInt();
        inizio.visitato = true;

        fine.x = s.nextInt();
        fine.y = s.nextInt();
        s.close();

        for (j = 0; j < m.length; j++)
        {
            for (k = 0; k < m[j].length; k++)
            {
                System.out.print(m[j][k].n + " ");
            }
            System.out.println();
        }

    }

    public static boolean TrovaStrada(Posizione p)
    {   
        p.visitato = true;
        if (p.x == fine.x && p.y == p.y)
        {
            return true;
        }
        if (p.x + 1 < m.length && m[p.y][p.x + 1].n == 0 && m[p.y][p.x + 1].visitato == false)
        {
            stack.push(m[p.y][p.x + 1]);
            return TrovaStrada(m[p.y][p.x + 1]);
        }

        if (p.y + 1 < m[0].length && m[p.y + 1][p.x].n == 0 && m[p.y + 1][p.x].visitato == false)
        {
            stack.push(m[p.y + 1][p.x]);
            return TrovaStrada(m[p.y + 1][p.x]);
        }

        if (p.y - 1 >= 0 && m[p.y - 1][p.x].n == 0 && m[p.y - 1][p.x].visitato == false)
        {
            stack.push(m[p.y-1][p.x]);
            return TrovaStrada(m[p.y - 1][p.x]);
        }

        if (p.x - 1 >= 0 && m[p.y][p.x - 1].n == 0 && m[p.y][p.x - 1].visitato == false)
        {
            stack.push(m[p.y][p.x - 1]);
            return TrovaStrada(m[p.y][p.x - 1]);
        }
        
        return TrovaStrada(stack.pop());      
    }

    public static void VisualizzaStack()
    {
        while(!stack.isEmpty())
        {
            Posizione p = stack.pop();
            System.out.println("X: "+ p.x+ " Y: " +p.y + " Visitato: "+ p.visitato);
            System.out.println("-------------");
        }
    }
    public static void main(String[] args) throws FileNotFoundException
    {
        CaricaLabirinto();
        System.out.println(TrovaStrada(inizio));
        
        VisualizzaStack();
    }

}
