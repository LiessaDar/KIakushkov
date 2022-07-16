package ru.LiessaDar.telegrambot.entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "orderProducts", path = "orderProducts")
public interface OrderProductRepository extends JpaRepository<OrderProduct, Long> {
String GET_TOP_POPULAR_PRODUCT = "SELECT o.product from OrderProduct as o group by o.product.id order by "+ "sum(o.countProduct)desc";
    @Query("SELECT DISTINCT p.product FROM OrderProduct p WHERE p.clientOrder IN :orderList")
    public List<Product> getProductsByOrderList(@Param("orderList")List<ClientOrder> orderList);
    @Query(GET_TOP_POPULAR_PRODUCT)
    public List<Product> getMostPopularProducts();
}

