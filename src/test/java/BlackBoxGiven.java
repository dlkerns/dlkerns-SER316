package test.java;

import main.java.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.lang.reflect.Constructor;
import java.util.Arrays;
import java.util.Collection;

import main.java.Cart;
import main.java.Cart1;
import main.java.Cart2;
import main.java.Cart3;
import main.java.Cart4;
import main.java.Cart5;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class BlackBoxGiven {

    private static final Class<? extends Throwable> UnderAgeException = null;
	private Class<Cart> classUnderTest;

    @SuppressWarnings("unchecked")
    public BlackBoxGiven(Object classUnderTest) {
        this.classUnderTest = (Class<Cart>) classUnderTest;
    }

    // Define all classes to be tested
    @Parameterized.Parameters
    public static Collection<Object[]> cartClassUnderTest() {
        Object[][] classes = {
            {Cart0.class},
            {Cart1.class},
            {Cart2.class},
            {Cart3.class},
            {Cart4.class},
            {Cart5.class}
        };
        return Arrays.asList(classes);
    }

    private Cart createCart(int age) throws Exception {
        Constructor<Cart> constructor = classUnderTest.getConstructor(Integer.TYPE);
        return constructor.newInstance(age);
    }

    // A sample Cart

    Cart cart1;
    double cart1Expected;


    @org.junit.Before
    public void setUp() throws Exception {

        // all carts should be set up like this

        // cart created with an age 40 shopper
        cart1 = createCart(40);
        for (int i = 0; i < 2; i++) {
            cart1.addItem(new Alcohol());
        }
        for(int i = 0; i < 3; i++) {
            cart1.addItem(new Dairy());
        }
        for(int i = 0; i < 4; i++) {
            cart1.addItem(new Meat());
        }

        cart1Expected = 70.2;
    }

    // sample test
    @Test
    public void calcCostCart1() throws UnderAgeException {
        double amount = cart1.calcCost();
        assertEquals(cart1Expected, amount, .01);
    }
    ///////////////////////////////////////////////////////////////
    //Test 1: Dairy should be $3, test that all carts, includes tax in
    //        expected final price
    ////////////////////////////////////////////////////////////////
    Cart dairy;
    double dairyExpected;
    
    @org.junit.Before
    public void setupDairy() throws Exception {
    	
    	dairy = createCart(40);
    	for(int i = 0; i < 1; i++) {
    		dairy.addItem(new Dairy());
    	}
    	dairyExpected = 3.24;
    }
    @Test
    public void checkDairyCost() throws UnderAgeException{
    	double amount = dairy.calcCost();
    	assertEquals(dairyExpected, amount, .01);
    }
    
    ////////////////////////////////////////////////////////////////
    //Test 2: Meat should be $10, test that all carts, includes tax in
    //        expected final price
    ////////////////////////////////////////////////////////////////
    Cart meat;
    double meatExpected;
    
    @org.junit.Before
    public void setupMeat() throws Exception {
    	
    	meat = createCart(40);
    	for(int i = 0; i < 1; i++) {
    		meat.addItem(new Meat());
    	}
    	meatExpected = 10.80;
    }
    @Test
    public void checkMeatCost() throws UnderAgeException{
    	double amount = meat.calcCost();
    	assertEquals(meatExpected, amount, .01);
    }
    
    /////////////////////////////////////////////////////////////////
    //Test 3: Produce should be $2, test that all carts, includes tax in
    //        expected final price
    ////////////////////////////////////////////////////////////////
    Cart produce;
    double produceExpected;
    
    @org.junit.Before
    public void setupProduce() throws Exception {
    	
    	produce = createCart(40);
    	for(int i = 0; i < 1; i++) {
    		produce.addItem(new Produce());
    	}
    	produceExpected = 2.16;
    }
    @Test
    public void checkProduceCost() throws UnderAgeException{
    	double amount = produce.calcCost();
    	assertEquals(produceExpected, amount, .01);
    }
    /////////////////////////////////////////////////////////////////
    //Test 4: Produce should be $2. Test that 2 are $4 test 
    //that all carts, includes tax in expected final price
    ////////////////////////////////////////////////////////////////
    Cart produceEdge1;
    double produceEdge1Expected;
    
    @org.junit.Before
    public void setupProduceEdge1() throws Exception {
    	
    	produceEdge1 = createCart(40);
    	for(int i = 0; i < 2; i++) {
    		produceEdge1.addItem(new Produce());
    	}
    	produceEdge1Expected = 4.32;
    }
    @Test
    public void checkProduceEdge1Cost() throws UnderAgeException{
    	double amount = produceEdge1.calcCost();
    	assertEquals(produceEdge1Expected, amount, .01);
    }
    
    /////////////////////////////////////////////////////////////////
    //Test 5: Produce should be $2 or 3 for $5. Test that 3 are $5 test 
    //that all carts, includes tax in expected final price
    ////////////////////////////////////////////////////////////////
    Cart produceEdge2;
    double produceEdge2Expected;
    
    @org.junit.Before
    public void setupProduceEdge2() throws Exception {
    	
    	produceEdge2 = createCart(40);
    	for(int i = 0; i < 3; i++) {
    		produceEdge2.addItem(new Produce());
    	}
    	produceEdge2Expected = 5.40;
    }
    @Test
    public void checkProduceEdge2Cost() throws UnderAgeException{
    	double amount = produceEdge2.calcCost();
    	assertEquals(produceEdge2Expected, amount, .01);
    }
    
    /////////////////////////////////////////////////////////////////
    //Test 6: Produce should be $2 or 3 for $5. Test that 4 are $7 test 
    //that all carts, includes tax in expected final price
    ////////////////////////////////////////////////////////////////
    Cart produceEdge3;
    double produceEdge3Expected;
    
    @org.junit.Before
    public void setupProduceEdge3() throws Exception {
    	
    	produceEdge3 = createCart(40);
    	for(int i = 0; i < 4; i++) {
    		produceEdge3.addItem(new Produce());
    	}
    	produceEdge3Expected = 7.56;
    }
    @Test
    public void checkProduceEdge3Cost() throws UnderAgeException{
    	double amount = produceEdge3.calcCost();
    	assertEquals(produceEdge3Expected, amount, .01);
    }
    
    /////////////////////////////////////////////////////////////////
    //Test 7: Produce should be $2 or 3 for $5. Test that 6 are $10 test 
    //that all carts, includes tax in expected final price
    ////////////////////////////////////////////////////////////////
    Cart produceEdge4;
    double produceEdge4Expected;
    
    @org.junit.Before
    public void setupProduceEdge4() throws Exception {
    	
    	produceEdge4 = createCart(40);
    	for(int i = 0; i < 6; i++) {
    		produceEdge4.addItem(new Produce());
    	}
    	produceEdge4Expected = 10.80;
    }
    @Test
    public void checkProduceEdge4Cost() throws UnderAgeException{
    	double amount = produceEdge4.calcCost();
    	assertEquals(produceEdge4Expected, amount, .01);
    }
    
    /////////////////////////////////////////////////////////////////
    //Test 8: Produce should be $2 or 3 for $5. Test that 8 are $14 test 
    //that all carts, includes tax in expected final price
    ////////////////////////////////////////////////////////////////
    Cart produceEdge5;
    double produceEdge5Expected;
    
    @org.junit.Before
    public void setupProduceEdge5() throws Exception {
    	
    	produceEdge5 = createCart(40);
    	for(int i = 0; i < 8; i++) {
    		produceEdge5.addItem(new Produce());
    	}
    	produceEdge5Expected = 15.12;
    }
    @Test
    public void checkProduceEdge5Cost() throws UnderAgeException{
    	double amount = produceEdge5.calcCost();
    	assertEquals(produceEdge5Expected, amount, .01);
    }
    
    /////////////////////////////////////////////////////////////////
    //Test 9: Alcohol should be $8 test that it is $8 test 
    // all carts, includes tax in expected final price
    ////////////////////////////////////////////////////////////////
    Cart alcohol;
    double alcoholExpected;
    
    @org.junit.Before
    public void setupAlcohol() throws Exception {
    	
    	alcohol = createCart(40);
    	for(int i = 0; i < 1; i++) {
    		alcohol.addItem(new Alcohol());
    	}
    	alcoholExpected = 8.64;
    }
    @Test
    public void checkAlcoholCost() throws UnderAgeException{
    	double amount = alcohol.calcCost();
    	assertEquals(alcoholExpected, amount, .01);
    }
    
    /////////////////////////////////////////////////////////////////
    //Test 10: Frozen Food should be $5 test that it is $5 test 
    // all carts, includes tax in expected final price
    ////////////////////////////////////////////////////////////////
    Cart frozen;
    double frozenExpected;
    
    @org.junit.Before
    public void setupFrozen() throws Exception {
    	
    	frozen = createCart(40);
    	for(int i = 0; i < 1; i++) {
    		frozen.addItem(new FrozenFood());
    	}
    	frozenExpected = 5.40;
    }
    @Test
    public void checkFrozenCost() throws UnderAgeException{
    	double amount = frozen.calcCost();
    	assertEquals(frozenExpected, amount, .01);
    }
    
    /////////////////////////////////////////////////////////////////
    //Test 11: One Frozen Food and One Alcohol should be $10 per the 
    //          deal test that it is $10, test 
    //          all carts, includes tax in expected final price
    ////////////////////////////////////////////////////////////////
    Cart frozenAlc;
    double frozenAlcExpected;
    
    @org.junit.Before
    public void setupFrozenAlc() throws Exception {
    	
    	frozenAlc = createCart(40);
    	for(int i = 0; i < 1; i++) {
    		frozenAlc.addItem(new FrozenFood());
    	}
    	for(int i = 0; i < 1; i++) {
    		frozenAlc.addItem(new Alcohol());
    	}
    	frozenAlcExpected = 10.80;
    }
    @Test
    public void checkFrozenAlcCost() throws UnderAgeException{
    	double amount = frozenAlc.calcCost();
    	assertEquals(frozenAlcExpected, amount, .01);
    }
    
    /////////////////////////////////////////////////////////////////
    //Test 11: One Frozen Food and One Alcohol should be $10 per the 
    //          deal test that it is $10,  test that 1 unit of
    //Alcohol and two frozen foods are $15, test all carts, includes 
    //tax in expected final price
    ////////////////////////////////////////////////////////////////
    Cart frozenAlc1;
    double frozenAlc1Expected;
    
    @org.junit.Before
    public void setupFrozenAlc1() throws Exception {
    	
    	frozenAlc1 = createCart(40);
    	for(int i = 0; i < 2; i++) {
    		frozenAlc1.addItem(new FrozenFood());
    	}
    	for(int i = 0; i < 1; i++) {
    		frozenAlc1.addItem(new Alcohol());
    	}
    	frozenAlc1Expected = 16.20;
    }
    @Test
    public void checkFrozenAlc1Cost() throws UnderAgeException{
    	double amount = frozenAlc1.calcCost();
    	assertEquals(frozenAlc1Expected, amount, .01);
    }
    
    /////////////////////////////////////////////////////////////////
    //Test 12: One Frozen Food and One Alcohol should be $10 per the 
    //          deal test that it is $10,  test that 2 units of
    //Alcohol and one frozen food is $18, test all carts, includes 
    //tax in expected final price
    ////////////////////////////////////////////////////////////////
    Cart frozenAlc2;
    double frozenAlc2Expected;
    
    @org.junit.Before
    public void setupFrozenAlc2() throws Exception {
    	
    	frozenAlc2 = createCart(40);
    	for(int i = 0; i < 1; i++) {
    		frozenAlc2.addItem(new FrozenFood());
    	}
    	for(int i = 0; i < 2; i++) {
    		frozenAlc2.addItem(new Alcohol());
    	}
    	frozenAlc2Expected = 19.44;
    }
    @Test
    public void checkFrozenAlc2Cost() throws UnderAgeException{
    	double amount = frozenAlc2.calcCost();
    	assertEquals(frozenAlc2Expected, amount, .01);
    }
    
    /////////////////////////////////////////////////////////////////
    //Test 12: One Frozen Food and One Alcohol should be $10 per the 
    //          deal test that it is $10,  test that 2 units of
    //Alcohol and two frozen foods are $20, test all carts, includes 
    //tax in expected final price
    ////////////////////////////////////////////////////////////////
    Cart frozenAlc3;
    double frozenAlc3Expected;
    
    @org.junit.Before
    public void setupFrozenAlc3() throws Exception {
    	
    	frozenAlc3 = createCart(40);
    	for(int i = 0; i < 2; i++) {
    		frozenAlc3.addItem(new FrozenFood());
    	}
    	for(int i = 0; i < 2; i++) {
    		frozenAlc3.addItem(new Alcohol());
    	}
    	frozenAlc3Expected = 21.60;
    }
    @Test
    public void checkFrozenAlc3Cost() throws UnderAgeException{
    	double amount = frozenAlc3.calcCost();
    	assertEquals(frozenAlc3Expected, amount, .01);
    
    
}
    /////////////////////////////////////////////////////////////////
    //Test 13: Alcohol should only be sold to people 21 or over
    //         tests should fail if age is under 21, test should
    //         display an error if this is not handled
    ////////////////////////////////////////////////////////////////
    Cart alcoholEx;
    double alcoholExExpected;
    
    @org.junit.Before
    public void setupAlcoholEx() throws Exception {
    	
    	alcoholEx = createCart(19);
    	for(int i = 0; i < 1; i++) {
    		alcoholEx.addItem(new Alcohol());
    	}
    	alcoholExExpected = 8.64;
    }
    @Test
    public void checkAlcoholExCost() throws UnderAgeException{
    	double amount = alcoholEx.calcCost();
    	assertEquals(alcoholExExpected, amount, .01);
    }
 
    /////////////////////////////////////////////////////////////////
    //Test 14: Alcohol should only be sold to people 21 or over
    //         tests should fail if age is exactly 21, test should
    //         display an error if this is not handled
    ////////////////////////////////////////////////////////////////
    Cart alcoholEx1;
    double alcoholEx1Expected;
    
    @org.junit.Before
    public void setupAlcoholEx1() throws Exception {
    	
    	alcoholEx1 = createCart(21);
    	for(int i = 0; i < 1; i++) {
    		alcoholEx1.addItem(new Alcohol());
    	}
    	alcoholEx1Expected = 8.64;
    }
    @Test
    public void checkAlcoholEx1Cost() throws UnderAgeException{
    	double amount = alcoholEx1.calcCost();
    	assertEquals(alcoholEx1Expected, amount, .01);
    }
    /////////////////////////////////////////////////////////////////
    //Test 15: Checks if an under age person is flagged if buying
    //         a non alcohoic item
    ////////////////////////////////////////////////////////////////
    Cart noAlcohol;
    double noAlcoholExpected;
    
    @org.junit.Before
    public void setupNoAlcohol() throws Exception {
    	
    	noAlcohol = createCart(19);
    	for(int i = 0; i < 1; i++) {
    		noAlcohol.addItem(new Meat());
    	}
    	noAlcoholExpected = 10.80;
    }
    @Test
    public void checkNoAlcoholCost() throws UnderAgeException{
    	double amount = noAlcohol.calcCost();
    	assertEquals(noAlcoholExpected, amount, .01);
    }
    
    /////////////////////////////////////////////////////////////////
    //Test 16: Checks if an under 21 aged person is given the Alcohol
    //         + Frozen Food deal. Result should be that the person does
    //         not get the deal but can still check out the Frozen food 
    //         item
    ////////////////////////////////////////////////////////////////
    Cart frozDealUnder;
    double frozDealUnderExpected;
    
    @org.junit.Before
    public void setupFrozDealUnder() throws Exception {
    	
    	frozDealUnder = createCart(18);
    	for(int i = 0; i < 1; i++) {
    		frozDealUnder.addItem(new FrozenFood());
    	}
    	for(int i = 0; i < 1; i++) {
    		frozDealUnder.addItem(new Alcohol());
    	}
    	frozDealUnderExpected = 5.40;
    }
    @Test
    public void checkFrozAlcDealUnderAgeCost() throws UnderAgeException{
    	double amount = frozDealUnder.calcCost();
    	assertEquals(frozDealUnderExpected, amount, .01);
    }
   
    /////////////////////////////////////////////////////////////////
    //Test 17: Produce should be $2 or 3 for $5. Test that 3 are $5,
    //         for an under age person as well, test 
    //that all carts, includes tax in expected final price
    ////////////////////////////////////////////////////////////////
    Cart produceDeal;
    double produceDealExpected;
    
    @org.junit.Before
    public void setupProduceDeal() throws Exception {
    	
    	produceDeal = createCart(6);
    	for(int i = 0; i < 3; i++) {
    		produceDeal.addItem(new Produce());
    	}
    	produceDealExpected = 5.40;
    }
    @Test
    public void checkUnderAgeProduceDealCost() throws UnderAgeException{
    	double amount = produceDeal.calcCost();
    	assertEquals(produceDealExpected, amount, .01);
    }
    
    /////////////////////////////////////////////////////////////////
    //Test 18: Checks if an under 21 aged person tries to buy Alcohol
    //         and a non deal item. Result should be that the person does
    //         not get the alcohol but can still check out the non deal 
    //         item
    ////////////////////////////////////////////////////////////////
    Cart nonDealUnder;
    double nonDealUnderExpected;
    
    @org.junit.Before
    public void setupNonDealUnder() throws Exception {
    	
    	nonDealUnder = createCart(18);
    	for(int i = 0; i < 1; i++) {
    		frozDealUnder.addItem(new Meat());
    	}
    	for(int i = 0; i < 1; i++) {
    		frozDealUnder.addItem(new Alcohol());
    	}
    	nonDealUnderExpected = 10.80;
    }
    @Test
    public void checkNonDealUnderAgeCost() throws UnderAgeException{
    	double amount = nonDealUnder.calcCost();
    	assertEquals(nonDealUnderExpected, amount, .01);
    }
    
    /////////////////////////////////////////////////////////////////
    //Test 19: Produce should be $2 or 3 for $5. Test that 3 are $5,
    //         for an under age person as well, test 
    //that all carts, includes tax in expected final price
    ////////////////////////////////////////////////////////////////
    Cart empty;
    double emptyExpected;
    
    @org.junit.Before
    public void setupEmpty() throws Exception {
    	
    	empty = createCart(12);
    	for(int i = 0; i < 1; i++) {
    		empty.addItem(new Alcohol());
    	
    	}
    	
    	emptyExpected = 8.64;
    }
    @Test
    public void checkEmptyCost() throws UnderAgeException{
    	double amount = empty.calcCost();
    	assertEquals(emptyExpected, amount, .01);
    }
 
}