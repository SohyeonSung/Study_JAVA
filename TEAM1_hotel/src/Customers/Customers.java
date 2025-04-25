package Customers;

public class Customers {
    private int customerId;
    private String username;
    private String password;
    private String customerName;

    public Customers() {}

    public Customers(int customerId, String username, String password, String customerName) {
        this.customerId = customerId;
        this.username = username;
        this.password = password;
        this.customerName = customerName;
    }

    // Getter/Setter
    public int getCustomerId() { return customerId; }
    public void setCustomerId(int customerId) { this.customerId = customerId; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getCustomerName() { return customerName; }
    public void setCustomerName(String customerName) { this.customerName = customerName; }

    // 
    
    
    
    
}
