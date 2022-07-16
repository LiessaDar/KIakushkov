package ru.LiessaDar.telegrambot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.LiessaDar.telegrambot.entity.*;


@SpringBootTest
public class FillingTests {
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ClientOrderRepository clientOrderRepository;
    @Autowired
    private OrderProductRepository orderProductRepository;
    @Autowired
    private ProductRepository productRepository;
    @Test
    public void FillingDataBase() {

            Client client1 = new Client();
            client1.setAddress("address1");
            client1.setExternalId(Long.valueOf(1));
            client1.setFullName("fullName1");
            client1.setPhoneNumber("8(978)100-10-10");
            clientRepository.save(client1);

            Client client2 = new Client();
            client2.setAddress("address2");
            client2.setExternalId(Long.valueOf(1));
            client2.setFullName("fullName2");
            client2.setPhoneNumber("8(978)100-10-11");
            clientRepository.save(client2);

//Creating parent categories
            Category rolls = new Category();
            rolls.setName("Rolls");
            rolls.setParent(null);
            categoryRepository.save(rolls);

            Category pizza = new Category();
            pizza.setName("Pizza");
            pizza.setParent(null);
            categoryRepository.save(pizza);

            Category burgers = new Category();
            burgers.setName("Burgers");
            burgers.setParent(null);
            categoryRepository.save(burgers);

            Category drinks = new Category();
            drinks.setName("Drinks");
            drinks.setParent(null);
            categoryRepository.save(drinks);
//Creating Subcategories
            //for rolls
            Category classicRolls = new Category();
            classicRolls.setName("ClassicRolls");
            classicRolls.setParent(rolls);
            categoryRepository.save(classicRolls);

            Category bakedRolls = new Category();
            bakedRolls.setName("BakedRolls");
            bakedRolls.setParent(rolls);
            categoryRepository.save(bakedRolls);

            Category sweetRolls = new Category();
            sweetRolls.setName("SweetRolls");
            sweetRolls.setParent(rolls);
            categoryRepository.save(sweetRolls);

            Category rollSets = new Category();
            rollSets.setName("RollSets");
            rollSets.setParent(rolls);
            categoryRepository.save(rollSets);

            //for burgers
            Category classicBurgers = new Category();
            classicBurgers.setName("ClassicBurgers");
            classicBurgers.setParent(burgers);
            categoryRepository.save(classicBurgers);

            Category spicyBurgers = new Category();
            spicyBurgers.setName("SpicyBurgers");
            spicyBurgers.setParent(burgers);
            categoryRepository.save(spicyBurgers);

            //for drinks
            Category carbonatedDrinks = new Category();
            carbonatedDrinks.setName("CarbonatedDrinks");
            carbonatedDrinks.setParent(drinks);
            categoryRepository.save(carbonatedDrinks);

            Category juices = new Category();
            juices.setName("Juices");
            juices.setParent(drinks);
            categoryRepository.save(juices);

            Category energyDrinks = new Category();
            energyDrinks.setName("EnergyDrinks");
            energyDrinks.setParent(drinks);
            categoryRepository.save(energyDrinks);

            Category otherDrinks = new Category();
            otherDrinks.setName("OtherDrinks");
            otherDrinks.setParent(drinks);
            categoryRepository.save(otherDrinks);
//Filling DB Products
            //for pizza
            Product syra3 = new Product();
            syra3.setName("Pizza 3 syra");
            syra3.setCategory(pizza);
            syra3.setDescription("Pizza 3 syra - ideal for vegetarian");
            syra3.setPrice(450.0);
            productRepository.save(syra3);

            Product zhylben = new Product();
            zhylben.setName("Pizza Zhulben");
            zhylben.setCategory(pizza);
            zhylben.setDescription("Pizza Zhulben - for those who love mushrooms");
            zhylben.setPrice(465.15);
            productRepository.save(zhylben);

            Product metsarella = new Product();
            metsarella.setName("Pizza Metsarella");
            metsarella.setCategory(pizza);
            metsarella.setDescription("Pizza Metsarella - for those who love vegetables");
            metsarella.setPrice(455.2);
            productRepository.save(metsarella);
            //for classic rolls
            Product r0llKS = new Product();
            r0llKS.setName("Roll classic size S");
            r0llKS.setCategory(classicRolls);
            r0llKS.setDescription("Small classic roll");
            r0llKS.setPrice(213.2);
            productRepository.save(r0llKS);

            Product r0llKM = new Product();
            r0llKM.setName("Roll classic size M");
            r0llKM.setCategory(classicRolls);
            r0llKM.setDescription("Medium classic roll");
            r0llKM.setPrice(223.5);
            productRepository.save(r0llKM);

            Product r0llKL = new Product();
            r0llKL.setName("Roll classic size L");
            r0llKL.setCategory(classicRolls);
            r0llKL.setDescription("Large classic roll");
            r0llKL.setPrice(250.0);
            productRepository.save(r0llKL);

            //for baked rolls
            Product r0llZS = new Product();
            r0llZS.setName("Roll baked size S");
            r0llZS.setCategory(bakedRolls);
            r0llZS.setDescription("Small baked roll");
            r0llZS.setPrice(213.2);
            productRepository.save(r0llZS);

            Product r0llZM = new Product();
            r0llZM.setName("Roll baked size M");
            r0llZM.setCategory(bakedRolls);
            r0llZM.setDescription("Medium baked roll");
            r0llZM.setPrice(223.5);
            productRepository.save(r0llZM);

            Product r0llZL = new Product();
            r0llZL.setName("Roll baked size L");
            r0llZL.setCategory(bakedRolls);
            r0llZL.setDescription("Large baked roll");
            r0llZL.setPrice(250.0);
            productRepository.save(r0llZL);

            //for sweet rolls
            Product r0llSS = new Product();
            r0llSS.setName("Roll sweet size S");
            r0llSS.setCategory(sweetRolls);
            r0llSS.setDescription("Small sweet roll");
            r0llSS.setPrice(213.2);
            productRepository.save(r0llSS);

            Product r0llSM = new Product();
            r0llSM.setName("Roll sweet size M");
            r0llSM.setCategory(sweetRolls);
            r0llSM.setDescription("Medium sweet roll");
            r0llSM.setPrice(223.5);
            productRepository.save(r0llSM);

            Product r0llSL = new Product();
            r0llSL.setName("Roll sweet size L");
            r0llSL.setCategory(sweetRolls);
            r0llSL.setDescription("Large sweet roll");
            r0llSL.setPrice(250.0);
            productRepository.save(r0llSL);

            //for roll sets
            Product r0llSet1 = new Product();
            r0llSet1.setName("Roll set size S");
            r0llSet1.setCategory(rollSets);
            r0llSet1.setDescription("Classic & sweet rolls");
            r0llSet1.setPrice(213.2);
            productRepository.save(r0llSet1);

            Product r0llSet2 = new Product();
            r0llSet2.setName("Roll set size M");
            r0llSet2.setCategory(rollSets);
            r0llSet2.setDescription("Classic & sweet & baked rolls");
            r0llSet2.setPrice(223.5);
            productRepository.save(r0llSet2);

            Product r0llSet3 = new Product();
            r0llSet3.setName("Roll set size L");
            r0llSet3.setCategory(rollSets);
            r0llSet3.setDescription("Set of all rolls' types");
            r0llSet3.setPrice(250.0);
            productRepository.save(r0llSet3);

            //for classic burgers
            Product burgerClassicS = new Product();
            burgerClassicS.setName("Burger clasic size S");
            burgerClassicS.setCategory(classicBurgers);
            burgerClassicS.setDescription("Burger clasic size S");
            burgerClassicS.setPrice(213.2);
            productRepository.save(burgerClassicS);

            Product burgerClassicM = new Product();
            burgerClassicM.setName("Burger clasic size M");
            burgerClassicM.setCategory(classicBurgers);
            burgerClassicM.setDescription("Burger clasic size M");
            burgerClassicM.setPrice(223.5);
            productRepository.save(burgerClassicM);

            Product burgerClassicL = new Product();
            burgerClassicL.setName("Burger clasic size L");
            burgerClassicL.setCategory(classicBurgers);
            burgerClassicL.setDescription("Burger clasic size L");
            burgerClassicL.setPrice(250.0);
            productRepository.save(burgerClassicL);

            //for spicy burgers
            Product burgerSpicyS = new Product();
            burgerSpicyS.setName("Burger spicy size S");
            burgerSpicyS.setCategory(spicyBurgers);
            burgerSpicyS.setDescription("Burger spicy size S");
            burgerSpicyS.setPrice(213.2);
            productRepository.save(burgerSpicyS);

            Product burgerSpicyM = new Product();
            burgerSpicyM.setName("Burger spicy size M");
            burgerSpicyM.setCategory(spicyBurgers);
            burgerSpicyM.setDescription("Burger spicy size M");
            burgerSpicyM.setPrice(223.5);
            productRepository.save(burgerSpicyM);

            Product burgerSpicyL = new Product();
            burgerSpicyL.setName("Burger spicy size L");
            burgerSpicyL.setCategory(spicyBurgers);
            burgerSpicyL.setDescription("Burger spicy size L");
            burgerSpicyL.setPrice(250.0);
            productRepository.save(burgerSpicyL);

//for carbonated drinks
            Product drinkC1 = new Product();
            drinkC1.setName("Carbonated drink 1");
            drinkC1.setCategory(carbonatedDrinks);
            drinkC1.setDescription("Carbonated drink 1");
            drinkC1.setPrice(213.2);
            productRepository.save(drinkC1);

            Product drinkC2 = new Product();
            drinkC2.setName("Carbonated drink 2");
            drinkC2.setCategory(carbonatedDrinks);
            drinkC2.setDescription("Carbonated drink 2");
            drinkC2.setPrice(223.5);
            productRepository.save(drinkC2);

            Product drinkC3 = new Product();
            drinkC3.setName("Carbonated drink 3");
            drinkC3.setCategory(carbonatedDrinks);
            drinkC3.setDescription("Carbonated drink 3");
            drinkC3.setPrice(250.0);
            productRepository.save(drinkC3);

//for energy drinks
            Product drinkE1 = new Product();
            drinkE1.setName("Energy drink 1");
            drinkE1.setCategory(energyDrinks);
            drinkE1.setDescription("Energy drink 1");
            drinkE1.setPrice(213.2);
            productRepository.save(drinkE1);

            Product drinkE2 = new Product();
            drinkE2.setName("Energy drink 2");
            drinkE2.setCategory(energyDrinks);
            drinkE2.setDescription("Energy drink 2");
            drinkE2.setPrice(223.5);
            productRepository.save(drinkE2);

            Product drinkE3 = new Product();
            drinkE3.setName("Energy drink 3");
            drinkE3.setCategory(energyDrinks);
            drinkE3.setDescription("Energy drink 3");
            drinkE3.setPrice(250.0);
            productRepository.save(drinkE3);

//for juices
            Product drinkJ1 = new Product();
            drinkJ1.setName("Juice 1");
            drinkJ1.setCategory(juices);
            drinkJ1.setDescription("Juice 1");
            drinkJ1.setPrice(213.2);
            productRepository.save(drinkJ1);

            Product drinkJ2 = new Product();
            drinkJ2.setName("Juice 2");
            drinkJ2.setCategory(juices);
            drinkJ2.setDescription("Juice 2");
            drinkJ2.setPrice(223.5);
            productRepository.save(drinkJ2);

            Product drinkJ3 = new Product();
            drinkJ3.setName("Juice 3");
            drinkJ3.setCategory(juices);
            drinkJ3.setDescription("Juice 3");
            drinkJ3.setPrice(250.0);
            productRepository.save(drinkJ3);

//for other drinks
            Product drinkO1 = new Product();
            drinkO1.setName("Other drink 1");
            drinkO1.setCategory(otherDrinks);
            drinkO1.setDescription("Other drink 1");
            drinkO1.setPrice(213.2);
            productRepository.save(drinkO1);

            Product drinkO2 = new Product();
            drinkO2.setName("Other drink 2");
            drinkO2.setCategory(otherDrinks);
            drinkO2.setDescription("Other drink 2");
            drinkO2.setPrice(223.5);
            productRepository.save(drinkO2);

            Product drinkO3 = new Product();
            drinkO3.setName("Other drink 3");
            drinkO3.setCategory(otherDrinks);
            drinkO3.setDescription("Other drink 3");
            drinkO3.setPrice(250.0);
            productRepository.save(drinkO3);
//Filling ClientOrder
            ClientOrder order1 = new ClientOrder();
            order1.setClient(client1);
            order1.setStatus(2);
            order1.setTotal(260.0);
            clientOrderRepository.save(order1);

            ClientOrder order2 = new ClientOrder();
            order2.setClient(client1);
            order2.setStatus(2);
            order2.setTotal(3000.0);
            clientOrderRepository.save(order2);

            ClientOrder order3 = new ClientOrder();
            order3.setClient(client2);
            order3.setStatus(2);
            order3.setTotal(280.0);
            clientOrderRepository.save(order3);

            ClientOrder order4 = new ClientOrder();
            order4.setClient(client2);
            order4.setStatus(0);
            order4.setTotal(150.0);
            clientOrderRepository.save(order4);
//Filling OrderProduct
            OrderProduct op1 = new OrderProduct();
            op1.setClientOrder(order1);
            op1.setCountProduct(Long.valueOf(2));
            op1.setProduct(burgerSpicyM);
            orderProductRepository.save(op1);

            OrderProduct op2 = new OrderProduct();
            op2.setClientOrder(order1);
            op2.setCountProduct(Long.valueOf(4));
            op2.setProduct(burgerSpicyS);
            orderProductRepository.save(op2);

            OrderProduct op3 = new OrderProduct();
            op3.setClientOrder(order2);
            op3.setCountProduct(Long.valueOf(2));
            op3.setProduct(burgerSpicyL);
            orderProductRepository.save(op3);

            OrderProduct op4 = new OrderProduct();
            op4.setClientOrder(order2);
            op4.setCountProduct(Long.valueOf(2));
            op4.setProduct(burgerSpicyM);
            orderProductRepository.save(op4);

            OrderProduct op5 = new OrderProduct();
            op5.setClientOrder(order3);
            op5.setCountProduct(Long.valueOf(10));
            op5.setProduct(burgerSpicyS);
            orderProductRepository.save(op5);

            OrderProduct op6 = new OrderProduct();
            op6.setClientOrder(order3);
            op6.setCountProduct(Long.valueOf(3));
            op6.setProduct(burgerSpicyM);
            orderProductRepository.save(op6);

            OrderProduct op7 = new OrderProduct();
            op7.setClientOrder(order4);
            op7.setCountProduct(Long.valueOf(1));
            op7.setProduct(burgerSpicyS);
            orderProductRepository.save(op7);

            OrderProduct op8 = new OrderProduct();
            op8.setClientOrder(order4);
            op8.setCountProduct(Long.valueOf(2));
            op8.setProduct(burgerSpicyL);
            orderProductRepository.save(op8);
    }
    }

