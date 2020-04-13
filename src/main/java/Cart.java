package main.java;

import java.util.ArrayList;
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
    public int cartStorage;

    /**
     * Calculates the final cost after all savings and tax has been applied. Also checks
     * that the user is of age to purchase alcohol if it is in their cart at checkout. Sales
     *  tax is always AZ tax.
     * Calculation is based off of the following prices and deals:
     * Dairy -> $3
     * Meat -> $10
     * Produce -> $2 or 3 for $5
     * Alcohol -> $8
     * Frozen Food -> $5
     * Alcohol + Frozen Food -> $10
     * If there is an alcohol product in the cart and the user is under 21, then an
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
                    if (userAge < 21) {
                        throw new UnderAgeException("User is underage,"
                                + " cannot purchase this product!");

                    
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
                        throw new UnderAgeException("User is underage, "
                                + "cannot purchase this product!");
                    
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

    // calculates how much was saved in the current shopping
    //cart based on the deals, returns the saved amount
    // throws exception if alcohol is bought from underage person
    // TODO: Create node graph for this method in assign 4: 
    //create white box tests and fix the method, reach at least 98% coverage
   
    /**
     * Underage Exception.
     * @return
     * 
     * @throws UnderAgeException
     * 
     */
    public int amountSaved() throws UnderAgeException {
        int subTotal = 0;
        int costAfterSavings = 0;

        double produceCounter = 0;
        int alcoholCounter = 0;
        int frozenFoodCounter = 0;
        for (int i = 0; i < cart.size(); i++) {
            subTotal += cart.get(i).getCost();
            costAfterSavings = costAfterSavings + cart.get(i).getCost();

            if (cart.get(i).getClass().toString() == Produce.class.toString()) {
                produceCounter++;

                if (produceCounter >= 3) {
                    costAfterSavings -= 1;
                    produceCounter = 0;
                }
            
            } else if (cart.get(i).getClass().toString() == Alcohol.class.toString()) {
                alcoholCounter++;
                if (userAge < 21) {

                    throw new UnderAgeException("The User is not of age to purchase alcohol!");
                }
            
            } else if (cart.get(i).getClass().toString() == Dairy.class.toString()) {
            
            }  else if (cart.get(i).getClass().toString() == FrozenFood.class.toString()) {
                frozenFoodCounter++;
            }

            if (alcoholCounter >= 1 && frozenFoodCounter >= 1) {
                costAfterSavings = costAfterSavings + 3;
                alcoholCounter--;
                frozenFoodCounter--;
            }
        }

        return subTotal - costAfterSavings;
    }

    // Gets the tax based on state and the total
    
    /**
     * Gets tax based on state and total.
     * @param totalBT
     * 
     * @param stateAbbreviation
     * 
     * @return
     */
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
        case "CO":
            newTotal = totalBT * .07;
            break;
        default:
            return totalBT;
        }
        return newTotal;
    }

    public void addItem(Product np) {
        cart.add(np);
    }

    /**
     * Removes Item.
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
