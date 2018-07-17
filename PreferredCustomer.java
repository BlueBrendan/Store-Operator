public class PreferredCustomer extends Customer{
    
    public PreferredCustomer(String one, String two, String three, double four)
    {
       super(one, two, three, four);
    }
    //Override
    public void makePurchase(double amount){
        double savings = amount;
        if (getTotalSpent()>2000)
        {
            purchases.add(amount*0.9);
            setTotalSpent(getTotalSpent()+amount*0.9);
            setTotalMoney(getTotalMoney()+amount*0.9);
            savings = amount*0.9;
        }
        else if (getTotalSpent()>1500)
        {
            purchases.add(amount*0.93);
            setTotalSpent(getTotalSpent()+amount*0.93);
            setTotalMoney(getTotalMoney()+amount*0.93);
            savings = amount*0.93;
        }
         else if (getTotalSpent()>1000)
        {
            purchases.add(amount*0.94);
            setTotalSpent(getTotalSpent()+amount*0.94);
            setTotalMoney(getTotalMoney()+amount*0.94);
            savings = amount*0.94;
        }
         else if (getTotalSpent()>500)
        {
            purchases.add(amount*0.95);
            setTotalSpent(getTotalSpent()+amount*0.95);
            setTotalMoney(getTotalMoney()+amount*0.95);
            savings = amount*0.95;
        }
        System.out.println(getName() + " has made a purchase of $" + amount + ", but was only charged $" + savings + " due to customer benefits!  The store now has $" + getTotalMoney() + " remaning in funds!");
    }
    public String toString()
    {
        String str = super.toString();
        if (getTotalSpent()>2000)
            str+="\nTotal Savings: 10%";
        else if (getTotalSpent()>1500)
            str+="\nTotal Savings: 7%";
        else if (getTotalSpent()>1000)
            str+="\nTotal Savings: 6%";
        else if (getTotalSpent()>500)
            str+="\nTotal Savings: 5%";
        return str;
    }
}
