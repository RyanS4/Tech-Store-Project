public class Customer {
  private String customerName;
  private String password;
  private double money;

  public Customer (String c, String p, double m) {
    customerName = c;
    password = p;
    money = m;
  }

  // getters 
  public String getCustomerName () {
    return customerName;
  }

  public String getPassword () {
    return password;
  }

  public double getMoney () {
    return money;
  }

  // setters
  public void setCustomerName (String a) {
    customerName = a;
  }

  public void setPassword (String a) {
    password = a;
  }

  public void setMoney (double a) {
    money = a;
  }

  // class functions
  public String toString () {
    return (
        "Customer Name: " + customerName + "\n" +
        "Budget: " + money + "\n"
        );
  }
}
