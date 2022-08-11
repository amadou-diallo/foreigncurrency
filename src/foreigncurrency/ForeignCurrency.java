
package foreigncurrency;

import java.text.NumberFormat;
import java.util.Scanner;

/**
 *
 * @author amadou
 */
public class ForeignCurrency {

    static Scanner sc = new Scanner(System.in);
    static double rEUR, rGBP, rJPY, rCAD, rRUB;
    
    public static void main(String[] args) {
        System.out.println("Welcome  to the Foreign Currency Calculator ");
        
        getRates();
        doValuation();
        
        System.out.println("Thanks for using the Foreign Currency Calculator");
    }
    
    public static void getRates() {
        System.out.println(" Enter Currency per USD");
      
        rEUR = getOneRate("EUR");
        rGBP = getOneRate("GPB");
        rJPY = getOneRate("JPY");
        rCAD = getOneRate("CAD");
        rRUB = getOneRate("RUB");       
    }
    
    public static double getOneRate(String cCode ) {
        double rate = 0;
        do {
            try {
                System.out.print(cCode + ": ");
                rate = sc.nextDouble();
                if (rate <= 0) {
                    System.out.println(" must be > 0 ");
            }
        } catch(Exception e) {
            System.out.println("Illegal rate: non- numeric");
            sc.nextLine();
            rate = -1;
            
        }
            
     } while (rate <= 0);
     return rate;
}// end of getOneRate
    
    public static void doValuation() {
        int choice, qty;
        double cval=0,totcval=0;
       NumberFormat curr = NumberFormat.getCurrencyInstance();
       int[] units = new int [5]; // an erray of 5 positions each of which take an int
       for(int i=0; i < 5; i++) {
           units[i] = 0;
       }
       double[] ctot = { 0.0, 0.0, 0.0, 0.0, 0.0 };
       String[] cnm = {"EUR", "GBP", "JPY", "CAD", "RUB" };
        
        
        
        choice = getChoice();
        while (choice != 0) {
            cval = 0;
            qty = 0;
            double[] rates = {rEUR, rGBP, rJPY,rCAD,rRUB};
            switch (choice) {
                case 1:
                    qty = getQty("EUR");
                    //cval = qty * rEUR;
          /*System.out.println(qty +" Euros has a value of: "
                  + curr.format(cval) );*/
          
               break;
               
                case 2:
                     qty = getQty("GBP");
                     //cval = qty * rGBP;
            /* System.out.println(qty + " Pounds Sterling has a value of: "
                      + curr.format(cval) );*/
               
               break;
               
                case 3:
                    qty = getQty("JPY");
                   // cval = qty * rJPY;
                /*System.out.println(qty + " Yen has a value of: " +
                             curr.format(cval) );*/
                
                break;
                    
                case 4:
                    qty = getQty("CAD");
                    //cval = qty * rCAD;
                /*System.out.println(qty + " Canadien dollars has a value of: "
                        + curr.format(cval)); */
                
                     break;
                
                case 5:
                    qty = getQty("RUB");
                   // cval = qty * rRUB;
                /*System.out.println(qty + " Rubles at rate of: " + rRUB +  
                        " per Ruble has a value of: "
                       + curr.format(cval)); */
                  
                    break;
                    
                case 9:
                    getRates();
                    break;
                    
                    
                default:
                    System.out.println("Unknown or unimplemented operation ");
                    break;
            }//end of switch
            if (choice != 9) {
               cval = qty * rates[choice-1];
               System.out.println(qty + " " + cnm[choice-1] + " units has a value of: "
                  + curr.format(cval) );
               totcval += cval;
           
               units[choice-1] += qty;
               ctot[choice-1] += cval;
           }
            
               choice = getChoice();

     }//end of while
        
           for (int i=0; i<5; i++) {
              System.out.println(cnm[i] + 
                " units costing " + curr.format(ctot[i]));
             }
             System.out.println(
                "Total cost of purchases = " + curr.format(totcval));
    }// end of doValuation
     public static int getChoice() {
          int c = -1;
          do {
             try {
             System.out.print(
             "Currency? (1=EUR, 2=GPP, 3=JPY, 4=CAD, 5=RUB 9= New Rates, 0=Quit ");
              c = sc.nextInt();
         if (c < 0 || (c > 5 && c != 9) ) {
                  System.out.println("Error: 0-5 or 9 only");
                  c = -1;
              }
           
              
         } catch (Exception e) {
              System.out.println("Integers 0-5 or 9 only");
              sc.nextLine();
              c = -1;
          }
         } while (c < 0 );
        return c;
      }//end of getChoice
      public static int getQty(String ctype) {
          int q;
          do {
              try {
           System.out.print("How many " + ctype + " are you buying? ");
           q = sc.nextInt();
              
              
          } catch (Exception e) {
          System.out.println("Please enter a whole number for quantity ");
             sc.nextLine();
             q = -1;
          }

      } while (q < 0);
          return q;
}
}//end of ForeignCurrency

       

    

