package assignment;

import java.io.*;
import java.util.*;

import assignment.Critter.HungerLevel;

/**
 * Responsible for loading critter species from text files and interpreting the
 * simple Critter language.
 * 
 * For more information on the purpose of the below two methods, see the
 * included API/ folder and the project description.
 */
public class Interpreter implements CritterInterpreter {


	public void executeCritter(Critter c) {
		// obviously, your code should do something
		
		ArrayList<String> list2 = new ArrayList<>();
		for (int i = 0; i < c.getCode().size()-1; i++)
		{
			list2.add((String) c.getCode().get(i));
		}
		
		int line = c.getNextCodeLine();

		while (true) {
			if (list2.get(line).equals("hop"))
			{
				c.hop();
				c.setNextCodeLine(line + 1);
				System.out.println("testing hop");
				return;
			}

			else if (list2.get(line).equals("left")) {
				c.left();
				c.setNextCodeLine(line + 1);
				System.out.println("testing left");
				return;
			}

			else if (list2.get(line).equals("right")) {
				c.right();
				c.setNextCodeLine(line + 1);
				System.out.println("testing right");
				return;
			}

			else if (list2.get(line).equals("eat")) {
				c.eat();
				c.setNextCodeLine(line + 1);
				System.out.println("testing eat");
				return;
			}

			else if (list2.get(line).contains("infect")) {
				if (list2.get(line).length() == 6) {
					c.infect();
					c.setNextCodeLine(line + 1);
					System.out.println("testing if infect");
					return;
				}
				int space = list2.get(line).indexOf(" ");
				String order = list2.get(line).substring(0, space);
				String num = list2.get(line).substring(space + 1);
				c.infect(Integer.parseInt(num));
				c.setNextCodeLine(line + 1);
				System.out.println("testing infect w num");
				return;
			}

			else if (list2.get(line).contains("go")) {
				int space = list2.get(line).indexOf(" ");
				if (space != 2) {
					System.out.println("Invalid input. This command does not exist.");
					return;
				}
				String order = list2.get(line).substring(0, space);
				String num = list2.get(line).substring(space + 1);

				if (num.contains("+"))
					c.setNextCodeLine(line + Integer.parseInt(num.substring(1)));
					//i += Integer.parseInt(num.substring(1));
				else if (num.contains("-"))
					c.setNextCodeLine(line - Integer.parseInt(num.substring(1)));
					//i -= Integer.parseInt(num.substring(1));
				else if (num.contains("r")){
					int regTemp = Integer.parseInt(num.substring(2));
					int temp = c.getReg(regTemp);
					line = temp;
				}
				else
					c.setNextCodeLine(Integer.parseInt(num));
					//i = Integer.parseInt(num);
				System.out.println("testing go");
				//i++;
				return;
			}

			else if (list2.get(line).contains("ifrandom")) {
				int space = list2.get(line).indexOf(" ");
				if (space != 8) {
					System.out.println("Invalid input. This command does not exist.");
					return;
				}
				String order = list2.get(line).substring(0, space);
				String num = list2.get(line).substring(space + 1);

				if (num.contains("+"))
					c.setNextCodeLine(line + Integer.parseInt(num.substring(1)));
					//i += Integer.parseInt(num.substring(1));
				else if (num.contains("-"))
					c.setNextCodeLine(line - Integer.parseInt(num.substring(1)));
					//i -= Integer.parseInt(num.substring(1));
				else if (num.contains("r")){
					int regTemp = Integer.parseInt(num.substring(2));
					int temp = c.getReg(regTemp);
					line = temp;
				}
				else
					c.setNextCodeLine(Integer.parseInt(num));
				/*
				if (c.ifRandom())
					c.setNextCodeLine(Integer.parseInt(num));
					//i = Integer.parseInt(num);
				else
					c.setNextCodeLine(line + 1);
					//i = Integer.parseInt(num + 1);*/
			}

			else if (list2.get(line).contains("ifhungry")) {
				int space = list2.get(line).indexOf(" ");
				if (space != 8) {
					System.out.println("Invalid input. This command does not exist.");
					return;
				}
				String order = list2.get(line).substring(0, space);
				String num = list2.get(line).substring(space + 1);
				System.out.println("'" + num + "'");
				System.out.println(list2.get(Integer.parseInt(num)));
				if (c.getHungerLevel().equals(HungerLevel.HUNGRY) || c.getHungerLevel().equals(HungerLevel.STARVING))
				{
					if (num.contains("+"))
						c.setNextCodeLine(line + Integer.parseInt(num.substring(1)));
					//i += Integer.parseInt(num.substring(1));
					else if (num.contains("-"))
						c.setNextCodeLine(line - Integer.parseInt(num.substring(1)));
					//i -= Integer.parseInt(num.substring(1));
					else if (num.contains("r")){
						int regTemp = Integer.parseInt(num.substring(2));
						int temp = c.getReg(regTemp);
						line = temp;
					}
					else
						c.setNextCodeLine(Integer.parseInt(num));
						//System.out.println(list2.get(Integer.parseInt(num)));
						//c.setNextCodeLine(Integer.parseInt(num));
						//i = Integer.parseInt(num);
					//i++;
					}
				else
					c.setNextCodeLine(line + 1);
				System.out.println("testing ifhungry");
			}

			else if (list2.get(line).contains("ifstarving")) {
				int space = list2.get(line).indexOf(" ");
				if (space != 10) {
					System.out.println("Invalid input. This command does not exist.");
					return;
				}
				String order = list2.get(line).substring(0, space);
				String num = list2.get(line).substring(space + 1);

				if (c.getHungerLevel().equals(HungerLevel.STARVING))
				{
					if (num.contains("+"))
						c.setNextCodeLine(line + Integer.parseInt(num.substring(1)));
					//i += Integer.parseInt(num.substring(1));
					else if (num.contains("-"))
						c.setNextCodeLine(line - Integer.parseInt(num.substring(1)));
					//i -= Integer.parseInt(num.substring(1));
					else if (num.contains("r")){
						int regTemp = Integer.parseInt(num.substring(2));
						int temp = c.getReg(regTemp);
						line = temp;
					}
					else
						c.setNextCodeLine(Integer.parseInt(num));
					}
					//c.setNextCodeLine(Integer.parseInt(list2.get(Integer.parseInt(num))));
					//i = Integer.parseInt(num);
					//i++;

				else
					c.setNextCodeLine(line + 1);
				System.out.println("testing ifstarving");
			}

			else if (list2.get(line).contains("ifempty")) {
				int space = list2.get(line).indexOf(" ");
				if (space != 7) {
					System.out.println("Invalid input. This command does not exist.");
					return;
				}
				String order = list2.get(line).substring(0, space);
				String b = list2.get(line).substring(space + 1);
				int space2 = b.indexOf(" ");
				String num = b.substring(space2 + 1);
				b = b.substring(0, space2);

				if (c.getCellContent(Integer.parseInt(b))==(Critter.EMPTY))
				{
					//c.setNextCodeLine(Integer.parseInt(num));
					//System.out.println(b + "empty");
					//i = Integer.parseInt(num)-1;
					//i = 7;
					if (num.contains("+"))
						c.setNextCodeLine(line + Integer.parseInt(num.substring(1)));
						//i += Integer.parseInt(num.substring(1));
					else if (num.contains("-"))
						c.setNextCodeLine(line - Integer.parseInt(num.substring(1)));
						//i -= Integer.parseInt(num.substring(1));
					else if (num.contains("r")){
						int regTemp = Integer.parseInt(num.substring(2));
						int temp = c.getReg(regTemp);
						line = temp;
					}
					else
						c.setNextCodeLine(Integer.parseInt(num));
					}
				else
					//i++;
					c.setNextCodeLine(line + 1);
					//System.out.println("full");
				//i+=2;
				//System.out.println(i);
				//System.out.println(b);
				System.out.println("testing ifempty");
			}

			else if (list2.get(line).contains("ifally")) {
				int space = list2.get(line).indexOf(" ");
				if (space != 6) {
					System.out.println("Invalid input. This command does not exist.");
					return;
				}
				String order = list2.get(line).substring(0, space);
				String b = list2.get(line).substring(space + 1);
				int space2 = b.indexOf(" ");
				String num = b.substring(space2 + 1);
				b = b.substring(0, space2);

				if (c.getCellContent(Integer.parseInt(b))==(Critter.ALLY))
				{
					//c.setNextCodeLine(Integer.parseInt(num));
					//i = Integer.parseInt(num) -1;
					if (num.contains("+"))
						c.setNextCodeLine(line + Integer.parseInt(num.substring(1)));
						//i += Integer.parseInt(num.substring(1));
					else if (num.contains("-"))
						c.setNextCodeLine(line - Integer.parseInt(num.substring(1)));
						//i -= Integer.parseInt(num.substring(1));
					else if (num.contains("r")){
						int regTemp = Integer.parseInt(num.substring(2));
						int temp = c.getReg(regTemp);
						line = temp;
					}
					else
						c.setNextCodeLine(Integer.parseInt(num));
					}
				else
					c.setNextCodeLine(line + 1);
					//i++;
				//i+=2;
				System.out.println("testing ifally");
			}

			else if (list2.get(line).contains("ifenemy")) {
				int space = list2.get(line).indexOf(" ");
				if (space != 7) {
					System.out.println("Invalid input. This command does not exist.");
					return;
				}
				String order = list2.get(line).substring(0, space);
				String b = list2.get(line).substring(space + 1);
				int space2 = b.indexOf(" ");
				String num = b.substring(space2 + 1);
				b = b.substring(0, space2);

				if (c.getCellContent(Integer.parseInt(b))== (Critter.ENEMY))
				{
					System.out.println("there is an enemy");
					//c.setNextCodeLine(Integer.parseInt(num));
					//i = Integer.parseInt(num);
					if (num.contains("+"))
						c.setNextCodeLine(line + Integer.parseInt(num.substring(1)));
						//i += Integer.parseInt(num.substring(1));
					else if (num.contains("-"))
						c.setNextCodeLine(line - Integer.parseInt(num.substring(1)));
						//i -= Integer.parseInt(num.substring(1));
					else if (num.contains("r")){
						int regTemp = Integer.parseInt(num.substring(2));
						int temp = c.getReg(regTemp);
						line = temp;
					}
					else
						c.setNextCodeLine(Integer.parseInt(num));
					}
				else
					c.setNextCodeLine(line + 1);
				//i+=2;
				System.out.println("testing ifenemy");
			}

			else if (list2.get(line).contains("ifwall")) {
				int space = list2.get(line).indexOf(" ");
				if (space != 6) {
					System.out.println("Invalid input. This command does not exist.");
					return;
				}
				String order = list2.get(line).substring(0, space);
				String b = list2.get(line).substring(space + 1);
				int space2 = b.indexOf(" ");
				String num = b.substring(space2 + 1);
				b = b.substring(0, space2);

				if (c.getCellContent(Integer.parseInt(b))==(Critter.WALL))
				{
					//c.setNextCodeLine(Integer.parseInt(num));
					//i = Integer.parseInt(num);
					if (num.contains("+"))
						c.setNextCodeLine(line + Integer.parseInt(num.substring(1)));
						//i += Integer.parseInt(num.substring(1));
					else if (num.contains("-"))
						c.setNextCodeLine(line - Integer.parseInt(num.substring(1)));
						//i -= Integer.parseInt(num.substring(1));
					else if (num.contains("r")){
						int regTemp = Integer.parseInt(num.substring(2));
						int temp = c.getReg(regTemp);
						line = temp;
					}
					else
						c.setNextCodeLine(Integer.parseInt(num));
					}
				else
					c.setNextCodeLine(line + 1);
				//i+=2;
				System.out.println("testing ifwall");
			}

			else if (list2.get(line).contains("ifangle")) {
				int space = list2.get(line).indexOf(" ");
				if (space != 7) {
					System.out.println("Invalid input. This command does not exist.");
					return;
				}
				String order = list2.get(line).substring(0, space);
				String b = list2.get(line).substring(space + 1);
				int space2 = b.indexOf(" ");
				String num1 = b.substring(space2 + 1);
				b = b.substring(0, space2);
				int space3 = num1.indexOf(" ");
				String num2 = num1.substring(space3 + 1);
				num1 = num1.substring(0, space3);

				if (c.getOffAngle(Integer.parseInt(b))==c.getOffAngle(Integer.parseInt(num1)))
				{
					//c.setNextCodeLine(Integer.parseInt(num2));
					//i = Integer.parseInt(num2);
					if (num2.contains("+"))
						c.setNextCodeLine(line + Integer.parseInt(num2.substring(1)));
						//i += Integer.parseInt(num.substring(1));
					else if (num2.contains("-"))
						c.setNextCodeLine(line - Integer.parseInt(num2.substring(1)));
						//i -= Integer.parseInt(num.substring(1));
					else if (num2.contains("r")){
						int regTemp = Integer.parseInt(num2.substring(2));
						int temp = c.getReg(regTemp);
						line = temp;
					}
					else
						c.setNextCodeLine(Integer.parseInt(num2));
					}
				else
					c.setNextCodeLine(line + 1);
				//i+=3;
				System.out.println("testing ifangle");
			}

			else if (list2.get(line).contains("write")) {
				int space = list2.get(line).indexOf(" ");
				if (space != 5) {
					System.out.println("Invalid input. This command does not exist.");
					return;
				}
				String order = list2.get(line).substring(0, space);
				String r1 = list2.get(line).substring(space + 1);
				int space2 = r1.indexOf(" ");
				String v = r1.substring(space2 + 1);
				r1 = r1.substring(0, space2);
				if (!(Integer.parseInt(r1)<11 && Integer.parseInt(r1)>0))
				{
					return;
				}
				c.setReg(Integer.parseInt(r1),Integer.parseInt(v));
				//i+=2;
				c.setNextCodeLine(line + 1);
				System.out.println("testing write");
			}

			else if (list2.get(line).contains("add")) {
				int space = list2.get(line).indexOf(" ");
				if (space != 3) {
					System.out.println("Invalid input. This command does not exist.");
					return;
				}
				String order = list2.get(line).substring(0, space);
				String r1 = list2.get(line).substring(space + 2);
				int space2 = r1.indexOf(" ");
				String r2 = r1.substring(space2 + 2);
				r1 = r1.substring(0, space2);
				if (!(Integer.parseInt(r1)<11 && Integer.parseInt(r1)>0))
				{
					return;
				}
				if (!(Integer.parseInt(r2)<11 && Integer.parseInt(r2)>0))
				{
					return;
				}
				//int total = Integer.parseInt(r1)+Integer.parseInt(r2);
				int total = c.getReg(Integer.parseInt(r1)) + c.getReg(Integer.parseInt(r2));
				c.setReg(Integer.parseInt(r2), total);
				//i+=2;
				c.setNextCodeLine(line + 1);
				System.out.println("testing add");
			}

			else if (list2.get(line).contains("sub")) {
				int space = list2.get(line).indexOf(" ");
				if (space != 3) {
					System.out.println("Invalid input. This command does not exist.");
					return;
				}
				String order = list2.get(line).substring(0, space);
				String r1 = list2.get(line).substring(space + 2);
				int space2 = r1.indexOf(" ");
				String r2 = r1.substring(space2 + 2);
				r1 = r1.substring(0, space2);
				if (!(Integer.parseInt(r1)<11 && Integer.parseInt(r1)>0))
				{
					return;
				}
				if (!(Integer.parseInt(r2)<11 && Integer.parseInt(r2)>0))
				{
					return;
				}
				//int total = Integer.parseInt(r1)-Integer.parseInt(r2);
				int total = c.getReg(Integer.parseInt(r2)) - c.getReg(Integer.parseInt(r1));
				c.setReg(Integer.parseInt(r2), total);
				c.setNextCodeLine(line + 1);
				//i+=2;
				System.out.println("testing add");
			}

			else if (list2.get(line).contains("inc"))
			{
				int space = list2.get(line).indexOf(" ");
				if (space != 3) {
					System.out.println("Invalid input. This command does not exist.");
					return;
				}
				String order = list2.get(line).substring(0, space);
				String num = list2.get(line).substring(space + 2);
				if (!(Integer.parseInt(num)<11 && Integer.parseInt(num)>0))
				{
					return;
				}
				int register = c.getReg(Integer.parseInt(num));
				register++;
				c.setReg(Integer.parseInt(num), register);
				c.setNextCodeLine(line + 1);
			}

			else if (list2.get(line).contains("dec"))
			{
				int space = list2.get(line).indexOf(" ");
				if (space != 3) {
					System.out.println("Invalid input. This command does not exist.");
					return;
				}
				String order = list2.get(line).substring(0, space);
				String num = list2.get(line).substring(space + 2);
				if (!(Integer.parseInt(num)<11 && Integer.parseInt(num)>0))
				{
					return;
				}
				int register = c.getReg(Integer.parseInt(num));
				register--;
				c.setReg(Integer.parseInt(num), register);
				c.setNextCodeLine(line + 1);
			}

			else if (list2.get(line).contains("iflt"))
			{
				int space = list2.get(line).indexOf(" ");
				if (space != 4) {
					System.out.println("Invalid input. This command does not exist.");
					return;
				}
				String order = list2.get(line).substring(0, space);
				String b = list2.get(line).substring(space + 2);
				int space2 = b.indexOf(" ");
				String num1 = b.substring(space2 + 2);
				b = b.substring(0, space2);
				int space3 = num1.indexOf(" ");
				String num2 = num1.substring(space3 + 1);
				num1 = num1.substring(0, space3);
				if (!(Integer.parseInt(b)<11 && Integer.parseInt(num1)>0))
				{
					return;
				}
				if (!(Integer.parseInt(b)<11 && Integer.parseInt(num1)>0))
				{
					return;
				}
				if (Integer.parseInt(b)<Integer.parseInt(num1))
				{
					//i = Integer.parseInt(num2);
					//c.setNextCodeLine(Integer.parseInt(num2));
					if (num2.contains("+"))
						c.setNextCodeLine(line + Integer.parseInt(num2.substring(1)));
						//i += Integer.parseInt(num.substring(1));
					else if (num2.contains("-"))
						c.setNextCodeLine(line - Integer.parseInt(num2.substring(1)));
						//i -= Integer.parseInt(num.substring(1));
					else if (num2.contains("r")){
						int regTemp = Integer.parseInt(num2.substring(2));
						int temp = c.getReg(regTemp);
						line = temp;
					}
					else
						c.setNextCodeLine(Integer.parseInt(num2));
					}
				else
					c.setNextCodeLine(line + 1);
			}

			else if (list2.get(line).contains("ifeq"))
			{
				int space = list2.get(line).indexOf(" ");
				if (space != 4) {
					System.out.println("Invalid input. This command does not exist.");
					return;
				}
				String order = list2.get(line).substring(0, space);
				String b = list2.get(line).substring(space + 2);
				int space2 = b.indexOf(" ");
				String num1 = b.substring(space2 + 2);
				b = b.substring(0, space2);
				int space3 = num1.indexOf(" ");
				String num2 = num1.substring(space3 + 1);
				num1 = num1.substring(0, space3);
				if (!(Integer.parseInt(b)<11 && Integer.parseInt(num1)>0))
				{
					return;
				}
				if (!(Integer.parseInt(b)<11 && Integer.parseInt(num1)>0))
				{
					return;
				}
				if (Integer.parseInt(b)==Integer.parseInt(num1))
				{
					//i = Integer.parseInt(num2);
					//c.setNextCodeLine(Integer.parseInt(num2));
					if (num2.contains("+"))
						c.setNextCodeLine(line + Integer.parseInt(num2.substring(1)));
						//i += Integer.parseInt(num.substring(1));
					else if (num2.contains("-"))
						c.setNextCodeLine(line - Integer.parseInt(num2.substring(1)));
						//i -= Integer.parseInt(num.substring(1));
					else if (num2.contains("r")){
						int regTemp = Integer.parseInt(num2.substring(2));
						int temp = c.getReg(regTemp);
						line = temp;
					}
					else
						c.setNextCodeLine(Integer.parseInt(num2));
					}
				else
					c.setNextCodeLine(line + 1);
			}

			else if (list2.get(line).contains("ifgt"))
			{
				int space = list2.get(line).indexOf(" ");
				if (space != 4) {
					System.out.println("Invalid input. This command does not exist.");
					return;
				}
				String order = list2.get(line).substring(0, space);
				String b = list2.get(line).substring(space + 2);
				int space2 = b.indexOf(" ");
				String num1 = b.substring(space2 + 2);
				b = b.substring(0, space2);
				int space3 = num1.indexOf(" ");
				String num2 = num1.substring(space3 + 1);
				num1 = num1.substring(0, space3);
				if (!(Integer.parseInt(b)<11 && Integer.parseInt(num1)>0))
				{
					return;
				}
				if (!(Integer.parseInt(b)<11 && Integer.parseInt(num1)>0))
				{
					return;
				}
				if (Integer.parseInt(b)>Integer.parseInt(num1))
				{
					//i = Integer.parseInt(num2);
					//c.setNextCodeLine(Integer.parseInt(num2));
					if (num2.contains("+"))
						c.setNextCodeLine(line + Integer.parseInt(num2.substring(1)));
						//i += Integer.parseInt(num.substring(1));
					else if (num2.contains("-"))
						c.setNextCodeLine(line - Integer.parseInt(num2.substring(1)));
						//i -= Integer.parseInt(num.substring(1));
					else if (num2.contains("r")){
						int regTemp = Integer.parseInt(num2.substring(2));
						int temp = c.getReg(regTemp);
						line = temp;
					}
					else
						c.setNextCodeLine(Integer.parseInt(num2));
					}
				else
					c.setNextCodeLine(line + 1);
			}
			else {
				System.err.println("Invalid input. This command does not exist.");
				return;
			}
			return;
		}
		

		
		//return;
	}

	//create methods for go, ifally, ifenemy, etc


	// public static void ifEmpty(Critter c, ) {

	// 	if (c.getHungerLevel().equals("HUNGRY"))

	// }

	public CritterSpecies loadSpecies(String filename) throws IOException {
		// obviously, your code should do something
		String name = readName(filename);
		ArrayList<String> details = readFile(filename);
		CritterSpecies critter = new CritterSpecies(name, details);
		return critter;
	}

	public static String readName (String filename) throws IOException
	{
		File f = new File(filename);
		if (!f.canRead())
		{
			System.err.println("Input file cannot be opened.");
			return null;
		}
		Scanner s = new Scanner(f);
		String name = "";
		name += (s.nextLine());
		s.close();
		return name;
	}

	public static ArrayList<String> readFile (String filename) throws IOException
	{
		File f = new File(filename);
		if (!f.canRead())
		{
			System.err.println("Input file cannot be opened.");
			return null;
		}
		Scanner s = new Scanner(f);
		ArrayList<String> details = new ArrayList<String>();
		
		// LOOK LATER TO MAKE SURE FIRST LINE IS NOT READ
		while (s.hasNext())
		{
			details.add(s.nextLine());
		}
		s.close();
		return details;
	}
	
}

/*
		for (int i = line; i < list2.size() -1; i++)
		{

			if (list2.get(i).contains("hop"))
			{
				c.hop();
				System.out.println("testing hop");
				return;
			}

			if (list2.get(i).contains("left")) {
				c.left();
				System.out.println("testing left");
				return;
			}

			if (list2.get(i).contains("right")) {
				c.right();
				System.out.println("testing right");
				return;
			}

			if (list2.get(i).contains("eat")) {
				c.eat();
				System.out.println("testing eat");
				return;
			}

			if (list2.get(i).contains("infect")) {
				if (list2.get(i).length() == 6) {
					c.infect();
					System.out.println("testing if infect");
					return;
				}
				int space = list2.get(i).indexOf(" ");
				String order = list2.get(i).substring(0, space);
				String num = list2.get(i).substring(space + 1);
				c.infect(Integer.parseInt(num));
				System.out.println("testing infect w num");
				return;
			}

			if (list2.get(i).contains("go")) {
				int space = list2.get(i).indexOf(" ");
				String order = list2.get(i).substring(0, space);
				String num = list2.get(i).substring(space + 1);

				if (num.contains("+"))
					//c.setNextCodeLine(i + Integer.parseInt(num.substring(1)));
					i += Integer.parseInt(num.substring(1));
				else if (num.contains("-"))
					//c.setNextCodeLine(i - Integer.parseInt(num.substring(1)));
					i -= Integer.parseInt(num.substring(1));
				else if (num.contains("r")){
					int regTemp = Integer.parseInt(num.substring(2));
					int temp = c.getReg(regTemp);
					i = temp;
				}
					
				else
					//c.setNextCodeLine(Integer.parseInt(num));
					i = Integer.parseInt(num);
				System.out.println("testing go");
				//i++;
				return;
			}

			if (list2.get(i).contains("ifrandom")) {
				int space = list2.get(i).indexOf(" ");
				String order = list2.get(i).substring(0, space);
				String num = list2.get(i).substring(space + 1);

				if (c.ifRandom())
					//c.setNextCodeLine(Integer.parseInt(num));
					i = Integer.parseInt(num);
				else
					//c.setNextCodeLine(i+1);
					i = Integer.parseInt(num + 1);
			}

			if (list2.get(i).contains("ifhungry")) {
				int space = list2.get(i).indexOf(" ");
				String order = list2.get(i).substring(0, space);
				String num = list2.get(i).substring(space + 1);

				if (c.getHungerLevel().equals(HungerLevel.HUNGRY) || c.getHungerLevel().equals(HungerLevel.STARVING))
					//c.setNextCodeLine(Integer.parseInt(list2.get(i+1)));
					i = Integer.parseInt(num);
				//i++;
				System.out.println("testing ifhungry");
			}

			if (list2.get(i).contains("ifstarving")) {
				int space = list2.get(i).indexOf(" ");
				String order = list2.get(i).substring(0, space);
				String num = list2.get(i).substring(space + 1);

				if (c.getHungerLevel().equals(HungerLevel.STARVING))
					//c.setNextCodeLine(Integer.parseInt(list2.get(i+1)));
					i = Integer.parseInt(num);
				//i++;
				System.out.println("testing ifstarving");
			}

			if (list2.get(i).contains("ifempty")) {
				int space = list2.get(i).indexOf(" ");
				String order = list2.get(i).substring(0, space);
				String b = list2.get(i).substring(space + 1);
				int space2 = b.indexOf(" ");
				String num = b.substring(space2 + 1);
				b = b.substring(0, space2);

				if (c.getCellContent(Integer.parseInt(b))==(Critter.EMPTY))
				{
					//c.setNextCodeLine(Integer.parseInt(num));
					//System.out.println(b + "empty");
					i = Integer.parseInt(num)-1;
					//i = 7;
				}
				else
					i++;
					//System.out.println("full");
				//i+=2;
				//System.out.println(i);
				//System.out.println(b);
				System.out.println("testing ifempty");
			}

			if (list2.get(i).contains("ifally")) {
				int space = list2.get(i).indexOf(" ");
				String order = list2.get(i).substring(0, space);
				String b = list2.get(i).substring(space + 1);
				int space2 = b.indexOf(" ");
				String num = b.substring(space2 + 1);
				b = b.substring(0, space2);

				if (c.getCellContent(Integer.parseInt(b))==(Critter.ALLY))
				{
					//c.setNextCodeLine(Integer.parseInt(num));
					i = Integer.parseInt(num) -1;
				}
				else
					i++;
				//i+=2;
				System.out.println("testing ifally");
			}

			if (list2.get(i).contains("ifenemy")) {
				int space = list2.get(i).indexOf(" ");
				String order = list2.get(i).substring(0, space);
				String b = list2.get(i).substring(space + 1);
				int space2 = b.indexOf(" ");
				String num = b.substring(space2 + 1);
				b = b.substring(0, space2);

				if (c.getCellContent(Integer.parseInt(b))== (Critter.ENEMY))
				{
					System.out.println("there is an enemy");
					//c.setNextCodeLine(Integer.parseInt(num));
					i = Integer.parseInt(num);
				}
				//i+=2;
				System.out.println("testing ifenemy");
			}

			if (list2.get(i).contains("ifwall")) {
				int space = list2.get(i).indexOf(" ");
				String order = list2.get(i).substring(0, space);
				String b = list2.get(i).substring(space + 1);
				int space2 = b.indexOf(" ");
				String num = b.substring(space2 + 1);
				b = b.substring(0, space2);

				if (c.getCellContent(Integer.parseInt(b))==(Critter.WALL))
				{
					//c.setNextCodeLine(Integer.parseInt(num));
					i = Integer.parseInt(num);
				}
				//i+=2;
				System.out.println("testing ifwall");
			}

			if (list2.get(i).contains("ifangle")) {
				int space = list2.get(i).indexOf(" ");
				String order = list2.get(i).substring(0, space);
				String b = list2.get(i).substring(space + 1);
				int space2 = b.indexOf(" ");
				String num1 = b.substring(space2 + 1);
				b = b.substring(0, space2);
				int space3 = num1.indexOf(" ");
				String num2 = num1.substring(space3 + 1);
				num1 = num1.substring(0, space3);

				if (c.getOffAngle(Integer.parseInt(b))==c.getOffAngle(Integer.parseInt(num1)))
				{
					//c.setNextCodeLine(Integer.parseInt(num2));
					i = Integer.parseInt(num2);
				}
				//i+=3;
				System.out.println("testing ifangle");
			}

			if (list2.get(i).contains("write")) {
				int space = list2.get(i).indexOf(" ");
				String order = list2.get(i).substring(0, space);
				String r1 = list2.get(i).substring(space + 1);
				int space2 = r1.indexOf(" ");
				String v = r1.substring(space2 + 1);
				r1 = r1.substring(0, space2);

				c.setReg(Integer.parseInt(r1),Integer.parseInt(v));
				//i+=2;
				System.out.println("testing write");
			}

			if (list2.get(i).contains("add")) {
				int space = list2.get(i).indexOf(" ");
				String order = list2.get(i).substring(0, space);
				String r1 = list2.get(i).substring(space + 2);
				int space2 = r1.indexOf(" ");
				String r2 = r1.substring(space2 + 2);
				r1 = r1.substring(0, space2);

				//int total = Integer.parseInt(r1)+Integer.parseInt(r2);
				int total = c.getReg(Integer.parseInt(r1)) + c.getReg(Integer.parseInt(r2));
				c.setReg(Integer.parseInt(r2), total);
				//i+=2;
				System.out.println("testing add");
			}

			if (list2.get(i).contains("sub")) {
				int space = list2.get(i).indexOf(" ");
				String order = list2.get(i).substring(0, space);
				String r1 = list2.get(i).substring(space + 2);
				int space2 = r1.indexOf(" ");
				String r2 = r1.substring(space2 + 2);
				r1 = r1.substring(0, space2);

				//int total = Integer.parseInt(r1)-Integer.parseInt(r2);
				int total = c.getReg(Integer.parseInt(r2)) - c.getReg(Integer.parseInt(r1));
				c.setReg(Integer.parseInt(r2), total);
				//i+=2;
				System.out.println("testing add");
			}

			if (list2.get(i).contains("inc"))
			{
				int space = list2.get(i).indexOf(" ");
				String order = list2.get(i).substring(0, space);
				String num = list2.get(i).substring(space + 2);

				int register = c.getReg(Integer.parseInt(num));
				register++;
				c.setReg(Integer.parseInt(num), register);
			}

			if (list2.get(i).contains("dec"))
			{
				int space = list2.get(i).indexOf(" ");
				String order = list2.get(i).substring(0, space);
				String num = list2.get(i).substring(space + 2);

				int register = c.getReg(Integer.parseInt(num));
				register--;
				c.setReg(Integer.parseInt(num), register);
			}

			if (list2.get(i).contains("iflt"))
			{
				int space = list2.get(i).indexOf(" ");
				String order = list2.get(i).substring(0, space);
				String b = list2.get(i).substring(space + 2);
				int space2 = b.indexOf(" ");
				String num1 = b.substring(space2 + 2);
				b = b.substring(0, space2);
				int space3 = num1.indexOf(" ");
				String num2 = num1.substring(space3 + 1);
				num1 = num1.substring(0, space3);

				if (Integer.parseInt(b)<Integer.parseInt(num1))
				{
					i = Integer.parseInt(num2);
				}
			}

			if (list2.get(i).contains("ifeq"))
			{
				int space = list2.get(i).indexOf(" ");
				String order = list2.get(i).substring(0, space);
				String b = list2.get(i).substring(space + 2);
				int space2 = b.indexOf(" ");
				String num1 = b.substring(space2 + 2);
				b = b.substring(0, space2);
				int space3 = num1.indexOf(" ");
				String num2 = num1.substring(space3 + 1);
				num1 = num1.substring(0, space3);

				if (Integer.parseInt(b)==Integer.parseInt(num1))
				{
					i = Integer.parseInt(num2);
				}
			}

			if (list2.get(i).contains("ifgt"))
			{
				int space = list2.get(i).indexOf(" ");
				String order = list2.get(i).substring(0, space);
				String b = list2.get(i).substring(space + 2);
				int space2 = b.indexOf(" ");
				String num1 = b.substring(space2 + 2);
				b = b.substring(0, space2);
				int space3 = num1.indexOf(" ");
				String num2 = num1.substring(space3 + 1);
				num1 = num1.substring(0, space3);

				if (Integer.parseInt(b)>Integer.parseInt(num1))
				{
					i = Integer.parseInt(num2);
				}
			}



			
		}*/

// String direction = list2.get(i);
			// if (direction.equals("hop"))
			// 	c.hop();
			// else if (direction.equals("left"))
			// 	c.left();
			// else if (direction.equals("right"))
			// 	c.right();
			// else if (direction.equals("eat"))
			// 	c.eat();
			// else if (direction.equals("infect"));
			// 	c.infect();
			// if (direction.substring(0, 2).equals("go")) {
			// 	if (direction.substring(3).equals("+"))
			// 		i += Integer.parseInt(direction.substring(4));
			// 	else if (direction.substring(3).equals("-"))
			// 		i -= Integer.parseInt(direction.substring(4));
			// 	else
			// 		i = Integer.parseInt(direction.substring(3));
			// }
			// else if (direction.substring(0, 8).equals("ifhungry"))
			// {
			// 	if (c.getHungerLevel().equals(HungerLevel.HUNGRY) || c.getHungerLevel().equals(HungerLevel.STARVING))
			// 		i = Integer.parseInt(direction.substring(9));
			// }
			// else if (direction.substring(0, 10).equals("ifstarving")) {
			// 	if (c.getHungerLevel().equals(HungerLevel.STARVING))
			// 		i = Integer.parseInt(direction.substring(11));
			// }

			// if (direction.substring(0, 7).equals("ifempty")) {
			// 	String bearing = direction.substring(direction.indexOf(" "));
			// 	int b = direction.indexOf("");
			// 	String bear = direction.substring(b);
			// 	int bearing = if (c.getCellContent(bearing) == Critter.EMPTY)
			// 		i = num;
			// }



			// switch (list2.get(i)) {
				// case "hop":
				// 	c.hop();
				// 	System.out.println("testing hop");
				// 	return;
				// case "left":
				// 	c.left();
				// 	System.out.println("testing left");
				// 	return;
				// case "right":
				// 	c.right();
				// 	System.out.println("testing right");
				// 	return;
				// case "eat":
				// 	c.eat();
				// 	System.out.println("testing eat");
				// 	return;
				// case "infect":
				// 	System.out.println("testing infect");
				// 	c.infect();
				// 	return;

				// case "go":
				// 	//if (list2.get(i).substring(3).equals("+"))
				// 	if(list2.get(i+1).substring(0,1).equals("+"))
				// 		//i += Integer.parseInt(list.get(i).substring(4));
						
				// 		c.setNextCodeLine(i + Integer.parseInt(list2.get(i+1).substring(1)));
				// 	else if (list2.get(i+1).substring(0,1).equals("-"))
				// 		//i -= Integer.parseInt(list.get(i).substring(4));

				// 		//c.setNextCodeLine(i+1 - Integer.parseInt(list2.get(i+1).substring(1)));
				// 	else if (list2.get(i+1).substring(0,1).equals("r"))
						
				// 		//c.setNextCodeLine(1 + Integer.parseInt(list2.get(i+1)));
				// 	else 

				// 	System.out.println("testing go");
				// 	i++;
				// 	break;


				// case "ifrandom":
				// 	int n0 = Integer.parseInt(list2.get(i+1));
				// 	if(Math.random() < 0.5)
				// 	{
				// 		System.out.println("random true");
				// 		c.setNextCodeLine(n0);
				// 	}
				// 	else
				// 	{
				// 		i++;
				// 	}
				// 	System.out.println("testing ifrandom");
				// 	break;


				// case "ifhungry":
				// 	if (c.getHungerLevel().equals(HungerLevel.HUNGRY) || c.getHungerLevel().equals(HungerLevel.STARVING))
				// 		c.setNextCodeLine(Integer.parseInt(list2.get(i+1)));
				// 	i++;
				// 	System.out.println("testing ifhungry");
				// 	break;


				// case "ifstarving":
				// 	if (c.getHungerLevel().equals(HungerLevel.STARVING))
				// 		c.setNextCodeLine(Integer.parseInt(list2.get(i+1)));
				// 	i++;
				// 	System.out.println("testing ifstarving");
				// 	break;


				// case "ifempty":
				// 	int b = Integer.parseInt(list2.get(i+1));
				// 	int n = Integer.parseInt(list2.get(i+2));
				// 	if (c.getCellContent(b)==c.EMPTY)
				// 	{
				// 		c.setNextCodeLine(n);
				// 	}
				// 	i+=2;
				// 	System.out.println("testing ifempty");
				// 	break;


				// case "ifally":
				// 	int b1 = Integer.parseInt(list2.get(i+1));
				// 	int n1 = Integer.parseInt(list2.get(i+2));
				// 	if (c.getCellContent(b1)==c.ALLY)
				// 	{
				// 		c.setNextCodeLine(n1);
				// 	}
				// 	i+=2;
				// 	System.out.println("testing ifally");
				// 	break;

				// case "ifenemy":
				// 	int b2 = Integer.parseInt(list2.get(i+1));
				// 	int n2 = Integer.parseInt(list2.get(i+2));
				// 	System.out.println("switch enemy works");
				// 	//System.out.println(b2);
				// 	//System.out.println(n2);
				// 	if (c.getCellContent(b2)==c.ENEMY)
				// 	{
				// 		c.setNextCodeLine(n2);
				// 	}
				// 	i+=2;
				// 	System.out.println("testing ifenemy");
				// 	break;


				// case "ifwall":
				// 	int b3 = Integer.parseInt(list2.get(i+1));
				// 	int n3 = Integer.parseInt(list2.get(i+2));
				// 	if (c.getCellContent(b3)==c.WALL)
				// 	{
				// 		c.setNextCodeLine(n3);
				// 	}
				// 	i+=2;
				// 	System.out.println("testing ifwall");
				// 	break;


				// case "ifangle":
				// 	int b4 = Integer.parseInt(list2.get(i+1));
				// 	int b5 = Integer.parseInt(list2.get(i+2));
				// 	int n4 = Integer.parseInt(list2.get(i+3));
				// 	if (c.getOffAngle(b4)==c.getOffAngle(b5))
				// 	{
				// 		c.setNextCodeLine(n4);
				// 	}
				// 	i+=3;
				// 	System.out.println("testing ifangle");
				// 	break;

				// case "write":
				// 	int r = Integer.parseInt(list2.get(i+1));
				// 	int v = Integer.parseInt(list2.get(i+2));
				// 	c.setReg(r,v);
				// 	i+=2;
				// 	System.out.println("testing write");
				// 	break;

				// case "add":
				// 	int r1 = c.getReg(1);
				// 	int r2 = c.getReg(2);
				// 	int total = r1+r2;
				// 	c.setReg(2, total);
				// 	i+=2;
				// 	System.out.println("testing add");
				// 	break;


				// case "sub":
				// 	int reg1 = c.getReg(1);
				// 	int reg2 = c.getReg(2);
				// 	int total1 = reg2-reg1;
				// 	c.setReg(2, total1);
				// 	i+=2;
				// 	System.out.println("testing sub");
				// 	break;

				// case "inc":
				// 	int register = c.getReg(1);
				// 	register++;
				// 	c.setReg(1,register);
				// 	i++;
				// 	System.out.println("testing inc");
				// 	break;
				// case "dec":
				// 	int register1 = c.getReg(1);
				// 	register1++;
				// 	c.setReg(1,register1);
				// 	i++;
				// 	System.out.println("testing dec");
				// 	break;
				// case "iflt":
				// 	int regis1 = Integer.parseInt(list2.get(i+1));
				// 	int regis2 = Integer.parseInt(list2.get(i+2));
				// 	int instruct = Integer.parseInt(list2.get(i+3));
				// 	if (regis1<regis2)
				// 	{
				// 		c.setNextCodeLine(instruct);
				// 	}
				// 	i+=3;
				// 	System.out.println("testing iflt");
				// 	break;
				// case "ifeq":
				// 	int re1 = Integer.parseInt(list2.get(i+1));
				// 	int re2 = Integer.parseInt(list2.get(i+2));
				// 	int instr = Integer.parseInt(list2.get(i+3));
				// 	if (re1>re2)
				// 	{
				// 		c.setNextCodeLine(instr);
				// 	}
				// 	i+=3;
				// 	System.out.println("testing ifeq");
				// 	break;
				// case "ifgt":
				// 	int regi1 = Integer.parseInt(list2.get(i+1));
				// 	int regi2 = Integer.parseInt(list2.get(i+2));
				// 	int instruc = Integer.parseInt(list2.get(i+3));
				// 	if (regi1>regi2)
				// 	{
				// 		c.setNextCodeLine(instruc);
				// 	}
				// 	i+=3;
				// 	System.out.println("testing ifgt");
				// 	break;
			//}