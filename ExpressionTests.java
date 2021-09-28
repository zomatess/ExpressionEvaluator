import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class ExpressionTests.
 *
 * @author  Zoma T.
 * @version 9/24/21
 */
public class ExpressionTests
{
    /**
     * Default constructor for test class ExpressionTests
     */
    public ExpressionTests()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }

    @Test
    public void emptyString()
    {
        boolean success = false;
        try {
            ExpressionEvaluator.evaluate("");
        }
        catch (IllegalArgumentException exc) {
            success = true;
        }
        assertEquals(true, success);
    }

    @Test
    public void oneDigitNum()
    {
        assertEquals(1, ExpressionEvaluator.evaluate("1"));
    }

    @Test
    public void twoDigitNum()
    {
        assertEquals(12, ExpressionEvaluator.evaluate("12"));
    }

    @Test
    public void endDigitNum()
    {
        assertEquals(12483, ExpressionEvaluator.evaluate("12483"));
    }

    @Test
    public void unSupportedOperators()
    {
        boolean success = false;
        try {
            ExpressionEvaluator.evaluate("10%2");
        }
        catch (IllegalArgumentException exc) {
            success = true;
        }
        assertEquals(true, success);
    }

    @Test
    public void letOperators()
    {
        boolean success = false;
        try {
            ExpressionEvaluator.evaluate("a10b2");
        }
        catch (IllegalArgumentException exc) {
            success = true;
        }
        assertEquals(true, success);
    }

    @Test
    public void onlyOperators()
    {
        boolean success = false;
        try {
            ExpressionEvaluator.evaluate("+");
        }
        catch (IllegalArgumentException exc) {
            success = true;
        }

        assertEquals(true, success);
    }

    @Test
    public void preFixError()
    {
        boolean success = false;
        try {
            ExpressionEvaluator.evaluate("+23");
        }
        catch (IllegalArgumentException exc) {
            success = true;
        }
        assertEquals(true, success);
    }

    @Test
    public void postFixError()
    {
        boolean success = false;
        try {
            ExpressionEvaluator.evaluate("23+");
        }
        catch (IllegalArgumentException exc) {
            success = true;
        }
        assertEquals(true, success);
    }

    @Test
    public void add2OneDigit()
    {
        assertEquals(2, ExpressionEvaluator.evaluate("1+1"));
    }

    @Test
    public void addEndOneDigit()
    {
        assertEquals(16, ExpressionEvaluator.evaluate("1+8+5+2"));
    }

    @Test
    public void add2TwoDigit()
    {
        assertEquals(44, ExpressionEvaluator.evaluate("12+32"));
    }

    @Test
    public void addEndTwoDigit()
    {
        assertEquals(160, ExpressionEvaluator.evaluate("15+82+51+12"));
    }

    @Test
    public void add2ThreeDigit()
    {
        assertEquals(443, ExpressionEvaluator.evaluate("121+322"));
    }

    @Test
    public void addEndThreeDigit()
    {
        assertEquals(1619, ExpressionEvaluator.evaluate("105+892+510+112"));
    }

    @Test
    public void add2EndDigit()
    {
        assertEquals(334, ExpressionEvaluator.evaluate("12+322"));
    }

    @Test
    public void addEndDigit()
    {
        assertEquals(545, ExpressionEvaluator.evaluate("15+8+510+12"));
    }

    @Test
    public void sub2OneDigit()
    {
        assertEquals(0, ExpressionEvaluator.evaluate("1-1"));
    }

    @Test
    public void subEndOneDigit()
    {
        assertEquals(-9, ExpressionEvaluator.evaluate("1-3-5-2"));
    }

    @Test
    public void sub2TwoDigit()
    {
        assertEquals(-20, ExpressionEvaluator.evaluate("12-32"));
    }

    @Test
    public void subEndTwoDigit()
    {
        assertEquals(-130, ExpressionEvaluator.evaluate("15-82-51-12"));
    }

    @Test
    public void sub2ThreeDigit()
    {
        assertEquals(-201, ExpressionEvaluator.evaluate("121-322"));
    }

    @Test
    public void subEndThreeDigit()
    {
        assertEquals(-1409, ExpressionEvaluator.evaluate("105-892-510-112"));
    }

    @Test
    public void sub2EndDigit()
    {
        assertEquals(-310, ExpressionEvaluator.evaluate("12-322"));
    }

    @Test
    public void subEndDigit()
    {
        assertEquals(-515, ExpressionEvaluator.evaluate("15-8-510-12"));
    }

    @Test
    public void addSubOneDigit()
    {
        assertEquals(6, ExpressionEvaluator.evaluate("1+8-5+2"));
    }

    @Test
    public void addSubTwoDigit()
    {
        assertEquals(-28, ExpressionEvaluator.evaluate("15-82+51-12"));
    }

    @Test
    public void addSubThreeDigit()
    {
        assertEquals(-1185, ExpressionEvaluator.evaluate("105-892-510+112"));
    }

    @Test
    public void addSubDigit()
    {
        assertEquals(-475, ExpressionEvaluator.evaluate("15+8-510+12"));
    }

    @Test
    public void mul2OneDigit()
    {
        assertEquals(1, ExpressionEvaluator.evaluate("1*1"));
    }

    @Test
    public void mulEndOneDigit()
    {
        assertEquals(80, ExpressionEvaluator.evaluate("1*8*5*2"));
    }

    @Test
    public void mul2TwoDigit()
    {
        assertEquals(384, ExpressionEvaluator.evaluate("12*32"));
    }

    @Test
    public void mulEndTwoDigit()
    {
        assertEquals(0, ExpressionEvaluator.evaluate("0*82*51*12"));
    }

    @Test
    public void mul2ThreeDigit()
    {
        assertEquals(38962, ExpressionEvaluator.evaluate("121*322"));
    }

    /**
     *ASK ABOUT THIS
     **/

    @Test
    public void mulEndThreeDigit()
    {
        assertEquals(0, ExpressionEvaluator.evaluate("000*892*510*112"));
    }

    @Test
    public void mul2EndDigit()
    {
        assertEquals(3864, ExpressionEvaluator.evaluate("12*322"));
    }

    @Test
    public void mulEndDigit()
    {
        assertEquals(734400, ExpressionEvaluator.evaluate("15*8*510*12"));
    }

    @Test
    public void div2OneDigit()
    {
        assertEquals(1, ExpressionEvaluator.evaluate("1/1"));
    }

    @Test
    public void divEndOneDigit()
    {
        assertEquals(1, ExpressionEvaluator.evaluate("16/1/5/2"));
    }

    @Test
    public void div2TwoDigit()
    {
        assertEquals(3, ExpressionEvaluator.evaluate("32/10"));
    }

    @Test
    public void divEndTwoDigit()
    {
        assertEquals(5, ExpressionEvaluator.evaluate("164/3/5/2"));
    }

    @Test
    public void div2ThreeDigit()
    {
        assertEquals(161, ExpressionEvaluator.evaluate("322/2"));
    }

    @Test
    public void divEndThreeDigit()
    {
        assertEquals(333, ExpressionEvaluator.evaluate("10000/2/5/3"));
    }

    @Test
    public void div2EndDigit()
    {
        assertEquals(0, ExpressionEvaluator.evaluate("12/322"));
    }

    @Test
    public void divEndDigit()
    {
        assertEquals(5, ExpressionEvaluator.evaluate("510/5/4/5"));
    }

    @Test
    public void mulDivOneDigit()
    {
        assertEquals(0, ExpressionEvaluator.evaluate("1/8*5*2"));
    }

    @Test
    public void mulDivTwoDigit()
    {
        assertEquals(2, ExpressionEvaluator.evaluate("15*82/51/12"));
    }

    /*
     * ASK ABOUT BACKGROUND DECIMALS
     */
    @Test
    public void mulDivThreeDigit()
    {
        assertEquals(20496, ExpressionEvaluator.evaluate("105*892/510*112"));
    }

    @Test
    public void mulDivDigit()
    {
        assertEquals(5100, ExpressionEvaluator.evaluate("15*8*510/12"));
    }

    @Test
    public void div0Error()
    {
        boolean success = false;
        try { 
            assertEquals(0, ExpressionEvaluator.evaluate("9/0"));
        }
        catch (IllegalArgumentException exc) {
            success = true;
        }
        assertEquals(true, success);
    }
    
    @Test
    public void div0EndError()
    {
        boolean success = false;
        try { 
            assertEquals(0, ExpressionEvaluator.evaluate("8/1*7/0"));
        }
        catch (IllegalArgumentException exc) {
            success = true;
        }
        assertEquals(true, success);
    }
    
    @Test
    public void mixOneDigit()
    {
        assertEquals(6, ExpressionEvaluator.evaluate("1/8+5*2-4"));
    }

    @Test
    public void mixTwoDigit()
    {
        assertEquals(43, ExpressionEvaluator.evaluate("15*82/51-12+31"));
    }

    @Test
    public void mixThreeDigit()
    {
        assertEquals(402, ExpressionEvaluator.evaluate("105-892/510*112+409"));
    }

    @Test
    public void mixDigit()
    {
        assertEquals(-440, ExpressionEvaluator.evaluate("15*8+510/12-601"));
    }
    
}
