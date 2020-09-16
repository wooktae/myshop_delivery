package myShop;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import java.util.List;

@Entity
@Table(name="Delivery_table")
public class Delivery {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private Long orderId;
    private String status;

    @PrePersist
    public void onPostPersist(){
        Shipped shipped = new Shipped();
        BeanUtils.copyProperties(this, shipped);
        shipped.publishAfterCommit();


        myShop.external.Notice notice = new myShop.external.Notice();
        // mappings goes here
        notice.setOrderId(this.getOrderId());
        notice.setNotiStatus("Notice Send");

        DeliveryApplication.applicationContext.getBean(myShop.external.NoticeService.class)
                .noticeRequest(notice);
    }


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
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }




}
