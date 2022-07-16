package ru.LiessaDar.telegrambot.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
@RepositoryRestResource(collectionResourceRel = "clientOrders", path = "clientOrders")
public interface ClientOrderRepository extends JpaRepository<ClientOrder, Long> {
    @Query("SELECT  c FROM ClientOrder c WHERE c.status = :status")
    public List<ClientOrder> getOrderByStatus(@Param("status")int status);
    @Query("SELECT  c FROM ClientOrder c WHERE c.client = :client")
    public List<ClientOrder> getOrderByClient(@Param("client")Client client);

}

