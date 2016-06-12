package hackerrank;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Created by shah_ on 6/11/2016.
 */
public class CurrencyArbitrage {

    public void solution(){
        Scanner in = new Scanner(System.in);

        int t = in.nextInt();
        DecimalFormat df = new DecimalFormat("#.####");
        df.setRoundingMode(RoundingMode.CEILING);
        for (int i=0;i<t;i++){
            double usd = in.nextDouble();
            double eur = in.nextDouble();
            double gbp = in.nextDouble();
            double usdtoeur = 100000.0 /usd;
            //usdtoeur = getCeil(usdtoeur);
            double eurtogbp = usdtoeur / eur;
            //eurtogbp = getCeil(eurtogbp);
            double gbptousd = eurtogbp / gbp;
            //gbptousd = getCeil(gbptousd);
            int ans = (int) gbptousd - 100000;
            if (ans>0){
                System.out.println(ans);
            }else{
                System.out.println("0");
            }
        }
    }

    public double getCeil(double d){
        double temp1 = d * 10000.0;
        double temp2 = Math.ceil(temp1);
        return temp2/10000.0;
    }
    public static void main(String[] args) {
        CurrencyArbitrage C = new CurrencyArbitrage();
        C.solution();
    }
}
