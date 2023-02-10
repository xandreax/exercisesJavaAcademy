package org.example.supermarketexercise.manager;

import org.example.supermarketexercise.entities.Product;
import org.example.supermarketexercise.entities.Supermarket;
import org.example.supermarketexercise.exceptions.ProductNotFoundException;
import org.example.supermarketexercise.exceptions.SupermarketNotFoundException;
import org.example.supermarketexercise.exceptions.TipologiaRepartoNotFoundException;

import java.util.List;

public class SupermarketPrinter {

    private SupermarketManager manager;

    public SupermarketPrinter(List<Supermarket> supermarketList) {
        this.manager = new SupermarketManager(supermarketList);
    }

    public void printGetSupermarketListByProductName(String productName) {
        List<Supermarket> supermarketList = manager.getSupermarketListByProductName(productName);
        supermarketList.forEach(System.out::println);
    }

    public void printGetProductByNameAndSupermarket(String productName, String supermarketName) {
        try {
            Product p = manager.getProductByNameAndSupermarket(productName, supermarketName);
            System.out.println("Product " + p.getName() + " is availaible");
        } catch (SupermarketNotFoundException | ProductNotFoundException e) {
            printError(e);
        }
    }

    public void printGetListProductBySupermarket(String supermarketName){
        try {
            List<Product> products = manager.getListProductBySupermarket(supermarketName);
            if(products.isEmpty()){
                System.out.println("There are no products in this supermarket");
            } else {
                System.out.println("Products in supermarket "+ supermarketName);
                products.forEach(System.out::println);
            }
        } catch (SupermarketNotFoundException e) {
            printError(e);
        }
    }

    public void printCheckRepartoInSupermarket(String reparto, String supermarketName){
        try {
            if (manager.checkRepartoInSupermarket(reparto,supermarketName)){
                System.out.println("il reparto " + reparto + " è presente nel supermercato " + supermarketName);
            }
            else{
                System.out.println("il reparto " + reparto + " non è presente nel supermercato " + supermarketName);
            }
        } catch (SupermarketNotFoundException | TipologiaRepartoNotFoundException e) {
            printError(e);
        }
    }

    public void printBuyProduct(String productName, int quantity, String supermarketName){
        try {
            manager.buyProduct(productName, quantity, supermarketName);
            System.out.println("prodotto inserito nel carrello");
        } catch (SupermarketNotFoundException | ProductNotFoundException e) {
            printError(e);
        }
    }

    public void printProductsInCarrello(){
        List<Product> products = manager.getProductsInCarrello();
        System.out.println("Products in carrello");
        if(products.isEmpty()){
            System.out.println("There are no products in your shopping cart");
        } else{
            products.forEach(System.out::println);
        }
    }

    public void printRemoveProductsFromCarrello(String productName, int quantity){
        try {
            manager.removeProductsFromCarrello(productName, quantity);
            System.out.println("Eliminati " + quantity + " " + productName + "  dal carrello");
        } catch (ProductNotFoundException e) {
            printError(e);
        }
    }

    public void printCheckoutCarrello(){
        printProductsInCarrello();
        System.out.println("Totale spesa: " + manager.checkoutCarrello());
    }

    public void printNewUser(String user){
        manager.getNewCarrello();
        System.out.println("Benvenuto " + user);
    }

    private void printError(Exception e){
        System.out.println(e.getMessage());
    }
}