package myShop.external;

public class Notice {

    private Long id;
    private Long orderId;
    private String notiStatus;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getOrderId() {
        return orderId;
    }
    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }
    public String getNotiStatus() {
        return notiStatus;
    }
    public void setNotiStatus(String notiStatus) {
        this.notiStatus = notiStatus;
    }

}
