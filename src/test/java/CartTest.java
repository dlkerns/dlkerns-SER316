package test.java;
import main.java.Alcohol;
import main.java.Cart;
import main.java.Produce;
import main.java.FrozenFood;
import main.java.UnderAgeException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CartTest {
///////////////////////////////////////////////////////////////////////////
	//Test method: checkProduceDealSavings()
	//Description:
	//This test method checkProduceDealSavings() test to see if the savings
	//expected are the actual savings. When the amount of produce is
	// 3, savings should be $1.
//////////////////////////////////////////////////////////////////////////
	    Cart produceDeal;
	    double savingsExpected;
	    
	    @org.junit.Before
	    public void setupProduceDeal() throws Exception {
	    	
	    	produceDeal = new Cart(25);
	    	for(int i = 0; i < 3; i++) {
	    		produceDeal.addItem(new Produce());
	    	}
	    	savingsExpected = 1.00;
	    }
	    
	    @After
	    public void tearDown() throws Exception {
	    }
	    
	    @Test
	    public void checkProduceDealSavings() throws UnderAgeException{
	    	double amount = produceDeal.amountSaved();
	    	assertEquals(savingsExpected, amount, .01);
	    }
	    
///////////////////////////////////////////////////////////////////////////
//Test method: checkProduceDeal1Savings()
//Description:
//This test method checkProduceDealSavings() test to see if the savings
//expected are the actual savings. When the amount of produce is 1,
// the savings should be $0.
//////////////////////////////////////////////////////////////////////////
Cart produceDeal1;
double savings1Expected;

@org.junit.Before
public void setupProduceDeal1() throws Exception {

produceDeal1 = new Cart(25);
for(int i = 0; i < 1; i++) {
produceDeal1.addItem(new Produce());
}
savings1Expected = 0.00;
}

@After
public void tearDown1() throws Exception {
}

@Test
public void checkProduceDeal1Savings() throws UnderAgeException{
double amount = produceDeal1.amountSaved();
assertEquals(savings1Expected, amount, .01);
}

///////////////////////////////////////////////////////////////////////////
//Test method: checkProduceDeal2Savings()
//Description:
//This test method checkProduceDealSavings() test to see if the savings
//expected are the actual savings. When the amount of produce is 4,
//the savings should be $1.
//////////////////////////////////////////////////////////////////////////
Cart produceDeal2;
double savings2Expected;

@org.junit.Before
public void setupProduceDeal2() throws Exception {

produceDeal2 = new Cart(25);
for(int i = 0; i < 1; i++) {
produceDeal2.addItem(new Produce());
}
savings2Expected = 0.00;
}

@After
public void tearDown2() throws Exception {
}

@Test
public void checkProduceDeal2Savings() throws UnderAgeException{
double amount = produceDeal2.amountSaved();
assertEquals(savings2Expected, amount, .01);
}

///////////////////////////////////////////////////////////////////////////
//Test method: checkProduceDeal3Savings()
//Description:
//This test method checkProduceDealSavings() test to see if the savings
//expected are the actual savings. When the amount of produce is 6,
//the savings should be $2.
//////////////////////////////////////////////////////////////////////////
Cart produceDeal3;
double savings3Expected;

@org.junit.Before
public void setupProduceDeal3() throws Exception {

produceDeal3 = new Cart(25);
for(int i = 0; i < 1; i++) {
produceDeal3.addItem(new Produce());
}
savings3Expected = 0.00;
}

@After
public void tearDown3() throws Exception {
}

@Test
public void checkProduceDeal3Savings() throws UnderAgeException{
double amount = produceDeal3.amountSaved();
assertEquals(savings3Expected, amount, .01);
}

///////////////////////////////////////////////////////////////////////////
//Test method: checkFrozenAlcSavings()
//Description:
//This test method checkFrozenAlcSavings() test to see if the savings
//expected are the actual savings. When the amount of alcohol/frozen food 
//is 1 each, the savings should be $3.
//////////////////////////////////////////////////////////////////////////
Cart frozenAlc;
double frozenAlcExpected;

@org.junit.Before
public void setupFrozenAlcDeal() throws Exception {

frozenAlc = new Cart(25);
for(int i = 0; i < 1; i++) {
frozenAlc.addItem(new Alcohol());
}
for(int i = 0; i < 1; i++) {
frozenAlc.addItem(new FrozenFood());
}
frozenAlcExpected = 3.00;
}

@After
public void tearDown4() throws Exception {
}

@Test
public void checkFrozenAlcSavings() throws UnderAgeException{
double amount = frozenAlc.amountSaved();
assertEquals(frozenAlcExpected, amount, .01);
}

///////////////////////////////////////////////////////////////////////////
//Test method: checkFrozenAlcSavings()
//Description:
//This test method checkFrozenSavings() test to see if the savings
//expected are the actual savings. When the amount of frozen food 
//is 1 each without alcohol, the savings should be $0.
//////////////////////////////////////////////////////////////////////////
Cart frozen;
double frozenExpected;

@org.junit.Before
public void setupFrozenDeal() throws Exception {

frozen = new Cart(25);

for(int i = 0; i < 1; i++) {
frozenAlc.addItem(new FrozenFood());
}
frozenExpected = 0.00;
}

@After
public void tearDown5() throws Exception {
}

@Test
public void checkFrozenSavings() throws UnderAgeException{
double amount = frozen.amountSaved();
assertEquals(frozenExpected, amount, .01);
}

///////////////////////////////////////////////////////////////////////////
//Test method: checkFrozenAlcSavings()
//Description:
//This test method checkAlcSavings() test to see if an under age person
//can purchase alcohol or not and if this exception is handled or not
//////////////////////////////////////////////////////////////////////////
Cart alc;
double alcExpected;

@org.junit.Before
public void setupAlcDeal() throws Exception {

alc = new Cart(19);
for(int i = 0; i < 1; i++) {
alc.addItem(new Alcohol());
}
alcExpected = 0.00;
}

@After
public void tearDown6() throws Exception {
}

@Test
public void checkAlcSavings() throws UnderAgeException{
double amount = alc.amountSaved();
assertEquals(alcExpected, amount, .01);
}

/////////////////////////////////////////////////////////////////////
//Test method: getAzTax()
//Description: Checks to see if Arizona tax is calculated correctly
//
/////////////////////////////////////////////////////////////////////
Cart azTax;

@Before
public void setUpAZ() throws Exception {
    azTax = new Cart(45);
}

@After
public void tearDown7() throws Exception {
}

@Test
public void getAzTax() {
    assertEquals(4.0, azTax.getTax(50, "AZ"), .01);
}
/////////////////////////////////////////////////////////////////////
//Test method: getCaTax()
//Description: Checks to see if California tax is calculated correctly
//
/////////////////////////////////////////////////////////////////////
Cart caTax;

@Before
public void setUpCA() throws Exception {
caTax = new Cart(45);
}

@After
public void tearDown8() throws Exception {
}

@Test
public void getCaTax() {
assertEquals(4.5, caTax.getTax(50, "CA"), .01);
}

/////////////////////////////////////////////////////////////////////
//Test method: getNyTax()
//Description: Checks to see if New York tax is calculated correctly
//
/////////////////////////////////////////////////////////////////////
Cart nyTax;

@Before
public void setUpNY() throws Exception {
nyTax = new Cart(45);
}

@After
public void tearDown9() throws Exception {
}

@Test
public void getNyTax() {
assertEquals(5.0, nyTax.getTax(50, "NY"), .01);
}
/////////////////////////////////////////////////////////////////////
//Test method: getCoTax()
//Description: Checks to see if Colorado tax is calculated correctly
//
/////////////////////////////////////////////////////////////////////
Cart coTax;

@Before
public void setUpCO() throws Exception {
coTax = new Cart(45);
}

@After
public void tearDown10() throws Exception {
}

@Test
public void getCoTax() {
assertEquals(3.5, coTax.getTax(50, "CO"), .01);
}
/////////////////////////////////////////////////////////////////////
//Test method: getDefTax()
//Description: Checks to see if default tax just returns the input 
//             amount without any taxes attached
//
/////////////////////////////////////////////////////////////////////
Cart dTax;

@Before
public void setUpDef() throws Exception {
dTax = new Cart(45);
}

@After
public void tearDown11() throws Exception {
}

@Test
public void getDefTax() {
assertEquals(50, dTax.getTax(50, "LA"), .01);
}

/////////////////////////////////////////////////////////////////////
//Test method: getRemoveIt()
//Description: Checks to see if removeIt() works properly
//
/////////////////////////////////////////////////////////////////////
Cart removeIt;

@Before
public void setUpRemoveItem() throws Exception {
removeIt= new Cart(45);
Produce apple = new Produce();
FrozenFood hotPockets = new FrozenFood();

for(int i = 0; i < 2; i++) {
removeIt.addItem(apple);
}
for(int i = 0; i < 2; i++) {
removeIt.addItem(hotPockets);
}

	
}

@After
public void tearDown12() throws Exception {
}

@Test
public void getRemoveIt() {
Produce apple = new Produce();
FrozenFood hotPockets = new FrozenFood();
for(int i = 0; i < 2; i++) {
removeIt.addItem(hotPockets);
}
for(int i = 0; i < 2; i++) {
removeIt.addItem(apple);
}
boolean removed = removeIt.removeItem(hotPockets);

assertTrue(removed);
}
}