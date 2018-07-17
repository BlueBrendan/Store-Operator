import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main{
    
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        ArrayList<Customer> customers = new ArrayList<>();
        ArrayList<Employee> employees = new ArrayList<>();
        boolean quitProgram = false;
        while (quitProgram == false)
        {
        System.out.print("\nWhat would you like to do?  Select by number\n1. Add a new customer\n2. Add a preferred customer\n3. Add a new employee\n4. Change an employee's salary\n5. Pay all employees\n6. Record a purchase for a customer or a preferred customer\n7. Print out all customers\n8. Print out all employees\n9. Exit the simulation\n\nYour input: ");
        String response = kb.nextLine();
        if (response.equals("1"))
        {
            System.out.print("\nPlease enter the customer name: ");
            String name = kb.nextLine();
            System.out.print("Please enter the customer's phone number: ");
            String number = kb.nextLine();
            System.out.print("Please enter the customer's email: ");
            String mail = kb.nextLine();
            System.out.print("How much has the customer spent: $");
            double spent = kb.nextDouble();
            kb.nextLine();
            customers.add(new Customer (name, number, mail, spent));
            Collections.sort(customers);
        }
        
        else if (response.equals("2"))
        {
            System.out.print("\nPlease enter the preferred customer name: ");
            String name = kb.nextLine();
            System.out.print("Please enter the preferred customer's phone number: ");
            String number = kb.nextLine();
            System.out.print("Please enter the preferred customer's email: ");
            String mail = kb.nextLine();
            System.out.print("How much has the preferred customer spent (must be over $500): $");
            double spent = kb.nextDouble();
            kb.nextLine();
            while (spent < 500)
            {
                System.out.print("The preferred customer must have over $500 to receive benefits; try again: ");
                spent = kb.nextDouble();
                kb.nextLine();
            }
            customers.add(new PreferredCustomer (name, number, mail, spent));
            Collections.sort(customers);
        }
        
        else if (response.equals("3"))
        {
            System.out.print("\nPlease enter the employee name: ");
            String name = kb.nextLine();
            System.out.print("Please enter the employee's phone number: ");
            String number = kb.nextLine();
            System.out.print("Please enter the employee's email: ");
            String mail = kb.nextLine();
            System.out.print("Please enter the employee's ID (The first three values must be numbers and the last must be a letter from A-M: ");
            String ID = kb.nextLine();
            while (!Character.isDigit(ID.charAt(0)) || !Character.isDigit(ID.charAt(1)) || !Character.isDigit(ID.charAt(2)) || !Character.isLetter(ID.charAt(3)) || ID.charAt(3) > 'M')
            {
                System.out.print("The employee ID is formatted improperly: please make sure the first three values are numbers while the last is a letter from A-M: ");
                ID = kb.nextLine();
            }
            System.out.print("Please enter the employee's hire date: ");
            String hireDate = kb.nextLine();
            System.out.print("Please enter the employee's weekly salary: $");
            double weeklySalary = kb.nextDouble();
            kb.nextLine();
            employees.add(new Employee (name, number, mail, ID, hireDate, weeklySalary, 0));
            Collections.sort(employees);
        }
        
        else if (response.equals("4"))
        {
            if (employees.size() > 0)
            {
            System.out.println("\nWhich employee would you like to change the salary of? Select by number: ");
                for (int i = 0; i < employees.size(); i++)
                {
                    System.out.println(i+1 + ". " + employees.get(i) + "\n");
                }
                int input = kb.nextInt();
                kb.nextLine();
                while (input < 1 || input > employees.size())
                {
                    System.out.print("\nYour input is out of range; try again: ");
                    input = kb.nextInt();
                    kb.nextLine();
                }
                System.out.print(employees.get(input-1).getName() + " currently has a weekly salary of $" + employees.get(input-1).getWeeklySalary() + ".  What would you like to change it to? $");
                double newSalary = kb.nextDouble();
                kb.nextLine();
                employees.get(input-1).setWeeklySalary(newSalary);
                System.out.println(employees.get(input-1).getName() + "'s weekly salary has been changed to $" + newSalary + "!");
            }
            else
                System.out.println("\nYou have no employees! ");
        }
        
        else if (response.equals("5"))
        {
            if (employees.size() > 0)
            {
                System.out.println("\nPaying all employees their weekly salaries... ");
                for (int i = 0; i < employees.size(); i++)
                {
                    employees.get(i).payWeeklySalary();
                }
            }
            else
                System.out.println("\nYou have no employees!");

        }
        else if (response.equals("6"))
        {
            if (customers.size() > 0)
            {
                System.out.println("\nWhich customer would you like to record a purchase for? ");
                for (int i = 0; i < customers.size(); i++)
                {
                    System.out.println(i+1 + ". " + customers.get(i) + "\n");
                }
                int input = kb.nextInt();
                kb.nextLine();
                while (input < 1 || input > customers.size())
                {
                    System.out.print("\nYour input is out of range; try again: ");
                    input = kb.nextInt();
                    kb.nextLine();
                }
                System.out.print("How much does " + customers.get(input-1).getName() + "'s purchase cost? $");
                double cost = kb.nextDouble();
                kb.nextLine();
                customers.get(input-1).makePurchase(cost);
            }
            else
                System.out.println("\nYou have no customers!");
        }
        
        else if (response.equals("7"))
        {
            if (customers.size() > 0)
            {
                System.out.println("\nHere are all your customers: ");
                for (int i = 0; i < customers.size(); i++)
                    System.out.println(i+1 + ". " + customers.get(i) + "\n");
            }
            else 
                System.out.println("\nYou have no customers!");
        }
        
        else if (response.equals("8"))
        {
            if (employees.size() > 0)
            {
                System.out.println("\nHere are all your employees: ");
                for (int i = 0; i < employees.size(); i++)
                    System.out.println(i+1 + ". " + employees.get(i) + "\n");
            }
            else 
                System.out.println("\nYou have no employees!");
        }
        else if (response.equals("9"))
            quitProgram = true;
        else
            System.out.println("\nYour input is invalid; try again: ");
    }
    }
}
