import java.util.InputMismatchException;
import java.util.Scanner;

public class Day6ExceptionAssignment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Dice d = new Dice();
		Scanner scan = new Scanner(System.in);
		
		try {
			System.out.println("Try your luck.. Start rolling dice for number : ");
			int tryNum = scan.nextInt();
			System.out.println("Rolling Dice..");
			int diceNum = d.rollDice(tryNum);
		
			if(diceNum == tryNum) {
				System.out.println("You Won!!");
			}
			else {
				System.out.println("Better luck next time..");
			}
		
		} catch (InvalidDiceValueException e) {
			System.out.println(e);
		}catch (ZeroDiceValueException e) {
			System.out.println(e);
		}catch (NegativeDiceValueException e) {
			System.out.println(e);
		}catch (ZeroValueException e) {
			System.out.println(e);
		} catch(InputMismatchException e) {
			System.out.println("please enter only numbers: "+ e);
		}
		catch(RuntimeException e) {
			System.out.println("Some runtime exception occured: "+e);
		}
		catch(Exception e ) {
			System.out.println("Some exception occured: "+e);
		}
		catch(Throwable t) {
			System.out.println("Some error occured: "+t);
		}
	}

}

class Dice
{
	
	int rollDice(int tryNum) throws InvalidDiceValueException, ZeroDiceValueException, NegativeDiceValueException, ZeroValueException{
		int d;
		
		if (tryNum > 6) {
			throw new InvalidDiceValueException("Enter only dice values : ");
		}
		else if (tryNum == 0) {
			throw new ZeroDiceValueException("Zero not allowed _ Enter only dice values : ");
		}
		else if (tryNum < 0) {
			throw new NegativeDiceValueException("Negative values not allowed _ Enter only dice values : ");
		}
		
		int x = (int)(Math.random() * 10);
			
		if (x == 0 || x == 7) {
				throw new ZeroValueException("Try Again : ");
			}
		else {
			d = x % 7;
			//System.out.println(x);
			System.out.println("Dice Value: " + d);	
		}
	   return d;
	}
}

class ZeroValueException extends Exception {
	ZeroValueException(String str) {
		super(str);
	}
}

class InvalidDiceValueException extends Exception {
	InvalidDiceValueException(String str) {
		super(str);
	}
}

class ZeroDiceValueException extends Exception {
	ZeroDiceValueException(String str) {
		super(str);
	}
}

class NegativeDiceValueException extends Exception {
	NegativeDiceValueException(String str) {
		super(str);
	}
}
