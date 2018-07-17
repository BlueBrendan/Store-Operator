import java.util.ArrayList;

public class Customer extends Person{
    ArrayList<Double> purchases = new ArrayList<>();
    private double totalSpent;
    
    public Customer (String one, String two, String three, double four)
    {
        setName(one);
        setPhone(two);
        setEmail(three);
        totalSpent = four;
    }
    
    public void setTotalSpent (double amount){
        totalSpent = amount;
    }
    public double getTotalSpent(){
        return totalSpent;
    }
    public void makePurchase(double amount){
        purchases.add(amount);
        totalSpent+=amount;
        setTotalMoney(getTotalMoney() + amount);
        System.out.println(getName() + " has made a purchase of $" + amount + "!  The store now has $" + getTotalMoney() + " remaning in funds!");
    }
    
    public void showPurchase(){
        for (int i = 0; i < purchases.size(); i++)
        {
            System.out.println(purchases.get(i));
        }
    }
    
    public String toString()
    {
        String str = super.toString();
        str+= "\nTotal Spent: $" + totalSpent;
        return str;
    }
}
