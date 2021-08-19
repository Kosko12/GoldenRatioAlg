import java.util.ArrayList;

//Pomocnicza klasa reprezentujaca wielomian
public class Funkcja {
    public ArrayList<Double> wspolczynniki = new ArrayList<>();
    public double fun(double x){
        double sum = 0.;

        for (int i = 0; i < wspolczynniki.size();i++){
            double multi = 1.;
            if(i != 0){
                for(int j = i; j > 0; j--) {
                    multi *= x;
                }
            }
            sum += wspolczynniki.get(i) * multi;
        }
        return sum;
    }

    @Override
    public String toString() {
        String msg = "Wielomian: ";
        for(int i = wspolczynniki.size()-1; i >= 0; i--){
            if(i == 0){
                msg += wspolczynniki.get(i);
            }
            else
                msg += wspolczynniki.get(i) + " * x^" + i + " + ";
        }
        return msg;
    }
}

