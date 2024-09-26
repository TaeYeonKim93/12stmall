package stmall.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import stmall.DeliveryApplication;
import stmall.domain.DeliveryCompleted;
import stmall.domain.DeliveryReturned;
import stmall.domain.DeliveryStarted;

@Entity
@Table(name = "Delievery_table")
@Data
//<<< DDD / Aggregate Root
public class Delievery {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long orderId;

    private String productName;

    private Long productId;

    private Integer qty;

    private String status;

    @PostPersist
    public void onPostPersist() {
        DeliveryStarted deliveryStarted = new DeliveryStarted(this);
        deliveryStarted.publishAfterCommit();

        DeliveryCompleted deliveryCompleted = new DeliveryCompleted(this);
        deliveryCompleted.publishAfterCommit();

        DeliveryReturned deliveryReturned = new DeliveryReturned(this);
        deliveryReturned.publishAfterCommit();
    }

    public static DelieveryRepository repository() {
        DelieveryRepository delieveryRepository = DeliveryApplication.applicationContext.getBean(
            DelieveryRepository.class
        );
        return delieveryRepository;
    }

    public void completeDelivery() {
        //implement business logic here:

    }

    public void completeReturn() {
        //implement business logic here:

    }

    //<<< Clean Arch / Port Method
    public static void startDelivery(OrderPlaced orderPlaced) {
        //implement business logic here:

        /** Example 1:  new item 
        Delievery delievery = new Delievery();
        repository().save(delievery);

        DeliveryStarted deliveryStarted = new DeliveryStarted(delievery);
        deliveryStarted.publishAfterCommit();
        DeliveryCompleted deliveryCompleted = new DeliveryCompleted(delievery);
        deliveryCompleted.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(orderPlaced.get???()).ifPresent(delievery->{
            
            delievery // do something
            repository().save(delievery);

            DeliveryStarted deliveryStarted = new DeliveryStarted(delievery);
            deliveryStarted.publishAfterCommit();
            DeliveryCompleted deliveryCompleted = new DeliveryCompleted(delievery);
            deliveryCompleted.publishAfterCommit();

         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void cancelDelivery(OrderCanceled orderCanceled) {
        //implement business logic here:

        /** Example 1:  new item 
        Delievery delievery = new Delievery();
        repository().save(delievery);

        */

        /** Example 2:  finding and process
        
        repository().findById(orderCanceled.get???()).ifPresent(delievery->{
            
            delievery // do something
            repository().save(delievery);


         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
