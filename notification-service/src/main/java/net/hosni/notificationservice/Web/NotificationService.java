package net.hosni.notificationservice.Web;


import net.hosni.notificationservice.Entities.Notification;
import net.hosni.notificationservice.Repository.NotificationRepository;
import net.hosni.notificationservice.clients.CustomerRestClient;
import net.hosni.notificationservice.model.Customer;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Field;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

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


    @PatchMapping("/notifications/{id}")
    public Notification updateNotification(@PathVariable Long id , @RequestBody Map<String,Object> fields){
        Notification notif =notificationRepository.findById(id).get();

        fields.forEach((key,value)->{
            Field field = ReflectionUtils.findField(Notification.class, key);
            field.setAccessible(true);
            ReflectionUtils.setField(field,notif,value);
        });

        return notificationRepository.save(notif);

    }

    @DeleteMapping("/notifications/{id}")
    public String deleteNotification(@PathVariable Long id){
        notificationRepository.deleteById(id);
        return "deleted successfully";
    }


}
