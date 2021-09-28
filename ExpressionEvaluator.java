import java.util.Stack;
/**
 * Class ExpressionEvaluator here.
 *
 * @author Zoma Tessema
 * @version 9/21/21
 */
public class ExpressionEvaluator
{
    public static int evaluate (String infix)
    {
        if (infix.length()==0)
            throw new IllegalArgumentException("Put numbers");
            
        Stack<Integer> operands = new Stack<Integer>();
        Stack<String> operators = new Stack<String>();

        String num = "";

        for (int i=0; i<infix.length(); i++)
        {
            String op = infix.substring(i, i+1);
            if ("0123456789".indexOf(op)!=-1)
            {
                num+=op;
                if (i==infix.length()-1)
                    operands.push(Integer.parseInt(num));
                System.out.println(op);
            }
            else if ("^*/-+".indexOf(op)!=-1)
            {
                System.out.println(op);
                try {
                    operands.push(Integer.parseInt(num));
                }
                catch (NumberFormatException exc) {
                    throw new IllegalArgumentException("Need more numbers");
                }
                num="";

                if (operators.isEmpty()) //needed?
                {
                    operators.push(op);
                    continue;
                }
                String peek = operators.peek();
                if (peek.equals("^"))
                {
                    String popOp = operators.pop();
                    Integer popNum2 = operands.pop();
                    Integer popNum1 = operands.pop();
                    Integer computation = computation(popOp, popNum1, popNum2);

                    operators.push(op); //ASK
                    operands.push(computation);
                }
                else if (op.equals("^"))
                    operators.push(op);
                else if (peek.equals("*")||peek.equals("/"))
                {
                    String popOp = operators.pop();
                    Integer popNum2 = operands.pop();
                    Integer popNum1 = operands.pop();
                    Integer computation = computation(popOp, popNum1, popNum2);

                    operators.push(op); //ASK
                    operands.push(computation);

                }
                else if (peek.equals("+")||peek.equals("-"))
                {
                    if (op.equals("+")||op.equals("-"))
                    {
                        String popOp = operators.pop();
                        Integer popNum2 = operands.pop();
                        Integer popNum1 = operands.pop();
                        Integer computation = computation(popOp, popNum1, popNum2);

                        operators.push(op); //ASK
                        operands.push(computation);
                    }
                    else
                    {
                        operators.push(op);
                    }
                }
            }
            else
                throw new IllegalArgumentException(op+" is not supported");
        }
        if (operators.isEmpty())
            return Integer.parseInt(infix);
        if (operands.isEmpty() || operands.size()==1)
            throw new IllegalArgumentException("Need more numbers");
        
        String popOp = operators.pop();
        Integer popNum2 = operands.pop();
        Integer popNum1 = operands.pop();
        Integer computation = computation(popOp, popNum1, popNum2);
        return computation;
    }

    private static int computation (String operator, int num1, int num2)
    {
        if (operator.equals("^"))
            return (int)Math.pow(num1,num2); //num1 is base, num2 is exponent
        else if (operator.equals("*"))
            return num1*num2;
        else if (operator.equals("/"))
        {
            if (num2 == 0)
                throw new IllegalArgumentException("No division by 0");
            return (int)(num1/num2); //num1 is numerator, num2 is denominator
        }
        else if (operator.equals("+"))
            return num1+num2;
        else if (operator.equals("-"))
            return num1-num2; //num1 is nimuhend, num2 is subtrahend
        else
            System.out.println("Bad operator");
        return 0;
    }
}

