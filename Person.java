public class Person implements Comparable<Person>{

    private String name;
    private String phone;
    private String email;
    private static double totalMoney = 1000;
    
    //Setters and getters
    public String getName(){ return name; }
    public void setName(String nam) {name = nam;}
    public String getPhone(){ return phone; }
    public void setPhone(String phon) {phone = phon;}
    public String getEmail(){ return email; }
    public void setEmail(String emai) {email = emai;}
    public double getTotalMoney(){ return totalMoney; }
    public void setTotalMoney(double amount) {totalMoney = amount;}
    
    //Override
    public int compareTo(Person other)
    {
        if(!getName().equals(other.getName()))
        {
            if(getName().compareTo(other.getName()) > 0)
                return 1;
            else
                return -1;
        }
        else
            return 0;
    }
    
    public String toString() {return "Name: " + name + "\nEmail: " + email + "\nPhone: " + phone;}
    
}