package org.example.supermarketexercise.manager;

import org.example.supermarketexercise.entities.Carrello;
import org.example.supermarketexercise.exceptions.ProductNotFoundException;
import org.example.supermarketexercise.exceptions.SupermarketNotFoundException;
import org.example.supermarketexercise.exceptions.TipologiaRepartoNotFoundException;
import org.example.supermarketexercise.entities.Product;
import org.example.supermarketexercise.entities.TipologiaReparto;
import org.example.supermarketexercise.entities.Supermarket;

import java.util.List;
import java.util.stream.Collectors;

public class SupermarketManager {
    /*
            1) RICERCARE UN PRODOTTO E VEDERE IN QUALI SUPERMERCATI è PRESENTE
                1.1) RICERCARE UN PRODOTTO IN UN CERTO SUPERMERCATO
                1.2) STAMPARE TUTTI I PRODOTTI PRESENTI IN UN CERTO SUPERMERCATO
                1.3) RICERCARE SE UN REPARTO è PRESENTE IN UN CERTO SUPERMERCATO
                 USARE TOSTRING() PER STAMPARE LE INFO DEI PRODOTTI

            2) ACQUISTARE QUEL PRODOTTO DATA UNA CERTA QUANTITà (1 UNITà)
            3) CARRELLO --> L'UTENTE PUò STAMPARE E VEDERE IL SUO CARRELLO
            4) PUò RIMUOVERE UNO O PIù PRODOTTI
            5) CHECKOUT DEL CARRELLO -> STAMPA LISTA PRODOTTI + MOSTRO TOTALE DEI PRODOTTI
    */

    private final List<Supermarket> supermarketList;
    private Carrello carrello;

    public SupermarketManager(List<Supermarket> supermarketList) {
        this.supermarketList = supermarketList;
        this.carrello = new Carrello();
    }

    public List<Supermarket> getSupermarketListByProductName(String productName) {
        return supermarketList
                .stream().filter(supermarket -> supermarket.getReparti()
                        .stream().anyMatch(reparto -> reparto.getProducts()
                                .stream().anyMatch(product -> product.getName().equals(productName))))
                .collect(Collectors.toList());
    }

    public Product getProductByNameAndSupermarket(String productName, String supermarketName) throws SupermarketNotFoundException, ProductNotFoundException {
        Supermarket supermarket = getSupermarketByName(supermarketName);
        return supermarket.getReparti().stream()
                .flatMap(reparto -> reparto.getProducts().stream())
                .filter(product -> product.getName().equals(productName))
                .findAny()
                .orElseThrow(() -> new ProductNotFoundException("product " + productName + "not found"));
    }

    public List<Product> getListProductBySupermarket(String supermarketName) throws SupermarketNotFoundException {
        Supermarket supermarket = getSupermarketByName(supermarketName);
        return supermarket.getReparti().stream()
                .flatMap(reparto -> reparto.getProducts().stream())
                .collect(Collectors.toList());
    }

    public boolean checkRepartoInSupermarket(String reparto, String supermarketName) throws SupermarketNotFoundException, TipologiaRepartoNotFoundException {
        Supermarket supermarket = getSupermarketByName(supermarketName);
        TipologiaReparto tipologiaReparto;
        try {
            tipologiaReparto = TipologiaReparto.valueOf(reparto);
        } catch (IllegalArgumentException illegalArgumentException) {
            throw new TipologiaRepartoNotFoundException("type not exist with name: " + reparto);
        }
        return supermarket.getReparti().stream().anyMatch(rep -> rep.getTipologiaReparto().equals(tipologiaReparto));
    }

    public void buyProduct(String productName, int quantity, String supermarketName) throws SupermarketNotFoundException, ProductNotFoundException {
        Supermarket supermarket = getSupermarketByName(supermarketName);
        Product product = supermarket.getReparti().stream()
                .flatMap(reparto -> reparto.getProducts().stream())
                .filter(p -> p.getName().equals(productName) && p.getQuantity() >= quantity)
                .findAny()
                .orElseThrow(() -> new ProductNotFoundException("product not found or not available for this quantity"));
        int actualQuantity = product.getQuantity();
        product.setQuantity(actualQuantity - quantity);
        Product p = Product.ProductBuilder
                .builder()
                .setName(product.getName())
                .setPrice(product.getPrice())
                .setQuantity(actualQuantity - quantity)
                .setReparto(product.getReparto())
                .build();
        carrello.addProduct(p);
    }

    public void getNewCarrello() {
        carrello = new Carrello();
    }

    public List<Product> getProductsInCarrello() {
        return carrello.getProducts();
    }

    public void removeProductsFromCarrello(String productName, int quantity) throws ProductNotFoundException {
        Product product = carrello.getProducts().stream()
                .filter(p -> p.getName().equals(productName))
                .findAny()
                .orElseThrow(() -> new ProductNotFoundException("product not found in carrello"));
        carrello.remove(product, quantity);
    }

    public double checkoutCarrello() {
        return carrello.getTotalPrice();
    }

    private Supermarket getSupermarketByName(String supermarketName) throws SupermarketNotFoundException {
        return supermarketList.stream()
                .filter(sm -> sm.getName().equals(supermarketName))
                .findAny()
                .orElseThrow(() -> new SupermarketNotFoundException("supermarket" + supermarketName + " not found"));
    }
}
