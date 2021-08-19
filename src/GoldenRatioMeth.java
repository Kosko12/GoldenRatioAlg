import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class GoldenRatioMeth {
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        //deklaracja potrzebnych zmiennych
        double epsilon = 0.;
        double k = (Math.sqrt(5.) - 1.) / 2.;
        double a = 0.;
        double b = 0.;
        Funkcja f = new Funkcja();
        //Wczytanie zmiennych z pliku
        try{
            BufferedReader br = new BufferedReader(new FileReader("GRdata.txt"));
            String linia = null;
            int iter = 0;
            while((linia = br.readLine()) != null){
                if(iter == 0){
                    String []dane = linia.split("\\ ");
                    for (String s:
                         dane) {
                        f.wspolczynniki.add(Double.parseDouble(s));
                    }

                }
                else if(iter == 1){
                    epsilon = Double.parseDouble(linia);
                }
                else if(iter == 2) {
                    a = Double.parseDouble(linia);
                }
                else{
                    b = Double.parseDouble(linia);
                }
                iter++;
            }
            br.close();
        }catch(Exception ex){
            System.err.println("Błąd przy obsłudze pliku " + ex.getMessage());
        }
        //Wyswietlenie danych:
        System.out.println("Dane: \n" + "epsilon = " + epsilon + "\na = " + a + "\nb = " +b);
        System.out.println(f.toString());
        // Wyznaczanie xL i xR
        double xL = b - (k * (b - a));
        double xR = a + (k * (b - a));

        //Algorytm
        while((b - a) > epsilon){
            if(f.fun(xL) < f.fun(xR)){ // wybierz przedział [a, xR]
                b = xR;
                xR = xL;
                xL = b - k * ( b - a );
            }
            else // wybierz przedział [xL, b]
            {

                a = xL;
                xL = xR;
                xR = a + k * ( b - a );
            }
        }
        //Wyswietlanie wyniku
        System.out.println("Minimum wynosi: " + (a + b) / 2);
        System.out.println("Wpisz dowolny znak w celu zakonczenia programu");
        String exit = scanner.next();
    }

    /*static boolean ifUnimodal(Funkcja f, double a, double b, double epsilon){
        int counter = 0;
        ArrayList<Double> min = new ArrayList<>();
        double iter = a;
        if(f.fun(iter - epsilon) > f.fun(iter)){
        while(iter < b){
            if(f.fun(iter) > f.fun(iter - epsilon)) {
                min.add(f.fun(iter));
                counter++;
            }
            if(counter > 1){
                return false;
            }
            iter += epsilon;
        }

        }
        else{
            min.add();
        }
        return true;
    }*/
}
