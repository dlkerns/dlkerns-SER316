package main.java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.List;

/**
 * Class: Cart
 * Description: This class properly calculates the total for all
 * items in a cart. 
 *
 */

public class Cart {

    protected int userAge;
    public List<Product> cart;
    
   
   // SER316 TASK 2 SPOTBUGS FIX
   // public int cartStorage;

    /**
     * Calculates the final cost after all savings and tax has been applied. Also checks
     * that the user is of age to purchase alcohol if it is in their cart at checkout. 
     * Sales tax is always AZ tax.
     *
     * <p>Calculation is based off of the following prices and deals:
     * Dairy -> $3
     * Meat -> $10
     * Produce -> $2 or 3 for $5
     * Alcohol -> $8
     * Frozen Food -> $5
     * Alcohol + Frozen Food -> $10
     *
     * <p>If there is an alcohol product in the cart and the user is under 21, then an
     * UnderAgeException should be thrown.
     *
     * @return double totalCost
     * @throws UnderAgeException
     * 
     */
    public double calcCost() throws UnderAgeException {
        double subTotal = 0;
        double total = 0;
        double produceDeal = 1.0;
        double frozenDeal = 3.0;

        int produceCounter = 0;
        int alcoholCounter = 0;
        int frozenFoodCounter = 0;
        int meatCounter = 0;
        int dairyCounter = 0;


        for (int i = 0; i < cart.size(); i++) {
            subTotal += cart.get(i).getCost();


            if (cart.get(i).getClass().toString().equals(Produce.class.toString())) {
                produceCounter++;


                if (produceCounter >= 3) {
                    subTotal = subTotal - produceDeal;
                    produceCounter = 0;
                }


            
            } else if (cart.get(i).getClass().toString().equals(Alcohol.class.toString())) {
                try {

                    if  (userAge < 21) {
                        throw new UnderAgeException("User is underage, "
                                + "cannot purchase this product!");


                    
                    } else {
                        alcoholCounter++;
                    }
                
                } catch (UnderAgeException ex) {
                    System.out.println(ex);
                }





            
            } else if (cart.get(i).getClass().toString().equals(Dairy.class.toString())) {
                dairyCounter++;



            
            } else if (cart.get(i).getClass().toString().equals(Meat.class.toString())) { 
                meatCounter++;


            


            } else if (cart.get(i).getClass().toString().equals(FrozenFood.class.toString())) {
                frozenFoodCounter++;
            }


            if (alcoholCounter >= 1 && frozenFoodCounter >= 1) {
                try {
                    if (userAge < 21) {

                        throw new UnderAgeException("User is underage,"
                                + " cannot purchase this product!");

                    
                    } else {

                        subTotal = subTotal - frozenDeal;
                        alcoholCounter--;
                        frozenFoodCounter--;
                    }
                
                } catch (UnderAgeException ex) {
                    System.out.println(ex);
                }
            }



            total = subTotal + (getTax(subTotal,"AZ"));
        }

        return total; 
    }


    // calculates how much was saved in the current shopping cart
    //based on the deals, returns the saved amount
    // throws exception if alcohol is bought from underage person
    // TODO: Create node graph for this method in assign 4: create 
    //white box tests and fix the method, reach at least 98% coverage

    //Change Amount_saved to amountSaved according to code style rules
    //Change int into a double because we are dealing with money
    /**
     * Returns amount saved.

     * @return
     * 
     * @throws UnderAgeException
     * 
     */

    public double amountSaved() throws UnderAgeException {

        //Change int into double for these since they are money values
        double subTotal = 0;
        double costAfterSavings = 0;

        //Change to an int and camel case because its a counter and style rules
        int produceCounter = 0;
        int alcoholCounter = 0;
        int frozenFoodCounter = 0;


        for (int i = 0; i < cart.size(); i++) {
            subTotal += cart.get(i).getCost();
            costAfterSavings = costAfterSavings + cart.get(i).getCost();


            //Use .equals to compare strings not a boolean comparison
            if (cart.get(i).getClass().toString().equals(Produce.class.toString())) {

                produceCounter++;

                if (produceCounter >= 3) {
                    costAfterSavings -= 1;
                    produceCounter = 0;
                }
            

            //Again use .equals for comparison of strings
            //Inserted a try/catch block to handle the exception
            } else if (cart.get(i).getClass().toString().equals(Alcohol.class.toString())) {
                try {
                    if (userAge < 21) {
                        throw new UnderAgeException("User is underage,"
                                + " cannot purchase this product!");

                    
                    } else {
                        alcoholCounter++;
                    }
                
                } catch (UnderAgeException ex) {
                    System.out.println(ex);
                }
            
            //Deleted Dairy since there is not deals in dairy
            //.equals
            } else if (cart.get(i).getClass().toString().equals(FrozenFood.class.toString())) {

                frozenFoodCounter++;
            }

            if (alcoholCounter >= 1 && frozenFoodCounter >= 1) {

                //Subtract the cost for savings dont add
                costAfterSavings = costAfterSavings - 3;

                alcoholCounter--;
                frozenFoodCounter--;
            }
        }

        return subTotal - costAfterSavings;
    }

    // Gets the tax based on state and the total

    
   
    /**
     * Returns tax based on state and total.
     * @param totalBT
     * 
     * @param stateAbbreviation
     * 
     * @return
     */
    public double getTax(double total, String stateAbbreviation) {
        HashMap<String, Double> stateTax = new HashMap<String, Double>();
      
        stateTax.put("AZ", new Double(0.08));
        stateTax.put("CA", new Double(0.09));
        stateTax.put("NY", new Double(0.1));
        stateTax.put("CO", new Double(0.07));
      
        double tax = stateTax.getOrDefault(stateAbbreviation, total);
      
        return tax * total;
    }
    /**  
   *
    public double getTax(double total, String stateAbbreviation) {
        double newTotal = 0;
        
        if (stateAbbreviation.equals("AZ")) {
            newTotal = total * .08;
            
        
        } else if (stateAbbreviation.equals("CA")) {
            newTotal = total * .09;
        
        } else if (stateAbbreviation.equals("NY")) {
            newTotal = total * .1;
        
        } else if (stateAbbreviation.equals("CO")) {
            newTotal  = total * .07;
        
        } else {
            return total;
        }
        
        return newTotal;
    }
    */
    /**
    public double getTax(double totalBT, String stateAbbreviation) {
        double newTotal = 0;
        switch (stateAbbreviation) {

            case "AZ":
                newTotal = totalBT * .08;
                break;
            case "CA":
                newTotal = totalBT * .09;
                break;
            case "NY":
                newTotal = totalBT * .1;
                //insert missing break statement
                break;
            case "CO":
                newTotal = totalBT * .07;
                break;
            default:
                return totalBT;

        }
        return newTotal;
    }
    */

    public void addItem(Product np) {
        cart.add(np);
    }


    //Reformat to lower case first letter of public function
    /**
     * Remove product.
     * @param productToRemove
     * 
     * @return
     * 
     */
    public boolean removeItem(Product productToRemove) {

        boolean test = false;
        for (int i = 0; i < cart.size(); i++) {
            if (cart.get(i) == productToRemove) {
                cart.remove(i);
                test = true;
                return test;
            }
        }
        return false;
    }

    public Cart(int age) {
        userAge = age;
        cart = new ArrayList<Product>();
    }
}
