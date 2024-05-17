package net.hosni.notificationservice.Repository;

import net.hosni.notificationservice.Entities.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Notification,Long> {
}
