package Customers;

public class Customers {
    private String custId;
    private int password;
    private String customerName;

    public Customers() {}

    public Customers(String custId, int password, String customerName) {
        this.custId = custId;
        this.password = password;
        this.customerName = customerName;
    }

    public String getCustId() {
        return custId;
    }

    public void setCustId(String custId) {
        this.custId = custId;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
}
