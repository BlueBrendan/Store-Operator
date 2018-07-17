public class Employee extends Person {
    private String ID;
    private String hireDate;
    private double weeklySalary;
    private double totalPaid;
    
    public Employee (String one, String two, String three, String four, String five, double six, double seven)
    {
        setName(one);
        setPhone(two);
        setEmail(three);
        ID = four;
        hireDate = five;
        weeklySalary = six;
        totalPaid = seven;
    }
      
    //Setters and getters
    public String getID(){return ID;}
    public String getHireDate(){return hireDate;}
    public double getWeeklySalary(){return weeklySalary;}
    public double getTotalPaid(){return totalPaid;}
    public void setID(String info){ID = info;}
    public void setHireDate(String date){hireDate = date;}
    public void setWeeklySalary(double salary){weeklySalary = salary;}
    public void setTotalPaid(double paid){totalPaid = paid;}
    public void payWeeklySalary(){
   
        //Try/catch block to ensure funds do not become negative
        try
        {
        if (getTotalMoney()-weeklySalary < 0)
        {
            throw new IllegalArgumentException();
        }
        else
            setTotalMoney(getTotalMoney()-weeklySalary);
            totalPaid+=weeklySalary;
            System.out.println(getName() + " has received the weekly salary of $" + getWeeklySalary() + "!  There is $" + getTotalMoney() + " remaining in your funds. ");
        }
        catch (IllegalArgumentException e){
            System.out.println(getName() + " 's weekly salary is $" + getWeeklySalary() + " but you only have $" + getTotalMoney() + " left, so " + getName() + " did not receive the weekly salary.");
        }
    }
    public String toString()
    {
        String str = super.toString();
        str+= "\nID: " + ID + "\nHire Date: " + hireDate + "\nWeekly Salary: $" + weeklySalary + "\nTotal Paid: $" + totalPaid;
        return str;
    }
}
