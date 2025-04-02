public class Customer {
  private String customerName;
  private double money;

  public Customer (String c, double m) {
    customerName = c;
    money = m;
  }

  // getters 
  public String getCustomerName () {
    return customerName;
  }

  public double getMoney () {
    return money;
  }

  // setters
  public void setCustomerName (String a) {
    customerName = a;
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
