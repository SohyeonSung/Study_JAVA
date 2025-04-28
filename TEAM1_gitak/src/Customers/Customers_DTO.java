package Customers;


// 고객 정보를 저장하기 위한 변수들
public class Customers_DTO {
    private String custId;
    private int password;
    private String customerName;

    // 기본 생성자
    public Customers_DTO() {}

    // 매개변수가 있는 생성자
    public Customers_DTO(String custId, int password, String customerName) {
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
