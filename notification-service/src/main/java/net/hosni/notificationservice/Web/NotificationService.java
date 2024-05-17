package net.hosni.notificationservice.Web;


import net.hosni.notificationservice.Entities.Notification;
import net.hosni.notificationservice.Repository.NotificationRepository;
import net.hosni.notificationservice.clients.CustomerRestClient;
import net.hosni.notificationservice.model.Customer;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@CrossOrigin("*")
public class NotificationService {

    private NotificationRepository notificationRepository;
    private CustomerRestClient customerRestClient;

    public NotificationService(NotificationRepository notificationRepository, CustomerRestClient customerRestClient) {
        this.notificationRepository = notificationRepository;
        this.customerRestClient = customerRestClient;
    }


    @GetMapping("/notifications")
    public List<Notification> getAllNotifications(){
        List<Notification> notificationList=notificationRepository.findAll();

        notificationList.forEach(notification->{
            notification.setCustomer(customerRestClient.getCustomerById(notification.getCustomerId()));
        });

        return notificationList ;
    }


    @GetMapping("notifications/{id}")
    public Notification getNotificationById(@PathVariable long id){

        Notification notification=notificationRepository.findById(id).get();
        Customer customer=customerRestClient.getCustomerById(notification.getCustomerId());
        notification.setCustomer(customer);
        return notification;
    }

    @PostMapping("/notifications")
    public Notification createNotification(@RequestBody Notification notification){
        Customer customer=customerRestClient.getCustomerById(notification.getCustomerId());
        notification.setCreatedAt(LocalDate.now());
        notification.setCustomer(customer);
        return notificationRepository.save(notification);
    }


}
