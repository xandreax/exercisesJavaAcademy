package org.example.supermarketexercise;

import org.example.supermarketexercise.entities.Product;
import org.example.supermarketexercise.entities.Supermarket;
import org.example.supermarketexercise.entities.Reparto;
import org.example.supermarketexercise.entities.TipologiaReparto;
import org.example.supermarketexercise.manager.SupermarketUI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class SupermarketRunner {

    /*
        CREARE UN'APPLICAZIONE CHE POSSA GESTIRE UNA LISTA DI SUPERMARKET

        SUPERMERCATI DIVISI IN REPARTI -> OGNI REPARTO HA UNA LISTA DI PRODOTTI

        UTENTE
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

    public static void main(String[] args) {
        boolean flag = true;
        boolean logged = false;
        String user = null;
        Scanner scanner = new Scanner(System.in);

        List<Supermarket> supermarketList = new ArrayList<>();
        Supermarket s1 = Supermarket.SupermarketBuilder.builder().setName("Coop").build();
        Supermarket s2 = Supermarket.SupermarketBuilder.builder().setName("Despar").build();

        Reparto m = Reparto.RepartoBuilder.builder().setSupermarket(s1).setTipologia(TipologiaReparto.MACELLERIA).build();
        Product bistecca = Product.ProductBuilder.builder().setName("bistecca").setPrice(3f).setQuantity(15).setReparto(m).build();
        Product cotoletta = Product.ProductBuilder.builder().setName("cotoletta").setPrice(4f).setQuantity(15).setReparto(m).build();
        List<Product> pm = Arrays.asList(bistecca, cotoletta);
        m.setProducts(pm);

        Reparto pa = Reparto.RepartoBuilder.builder().setSupermarket(s1).setTipologia(TipologiaReparto.PANETTERIA).build();
        Product ciabatta = Product.ProductBuilder.builder().setName("ciabatta").setPrice(2f).setQuantity(30).setReparto(pa).build();
        Product baguette = Product.ProductBuilder.builder().setName("baguette").setPrice(3f).setQuantity(15).setReparto(pa).build();
        List<Product> ppa = Arrays.asList(ciabatta, baguette);
        pa.setProducts(ppa);

        s1.addReparto(m);
        s1.addReparto(pa);

        Reparto pe = Reparto.RepartoBuilder.builder().setSupermarket(s2).setTipologia(TipologiaReparto.PESCHERIA).build();
        Product orata = Product.ProductBuilder.builder().setName("orata").setPrice(10f).setQuantity(10).setReparto(pe).build();
        Product branzino = Product.ProductBuilder.builder().setName("branzino").setPrice(8f).setQuantity(9).setReparto(pe).build();
        List<Product> pp = Arrays.asList(orata, branzino);
        pe.setProducts(pp);
        s2.addReparto(pe);

        supermarketList.add(s1);
        supermarketList.add(s2);

        SupermarketUI managerUI = SupermarketUI.newInstance(supermarketList);

        while (flag) {
            if (logged) {
                System.out.println("Insert a command:");
            /*
                uso come delimitatore lo spazio
                COMANDI:
                - EXIT -> uscire dal programma
                - LOGOUT -> logout dell'utente
                - S1 productName
                - S2 productName + supermarketName
                - S3 supermaketName
                - S4 reparto supermaketName
                - BUY productName + quantity + supermarketName
                - CARRELLO
                - REMOVE productName + quantity
                - CHECHKOUT
             */
                String line = scanner.nextLine();
                String[] tokens = line.split(" ");
                String command = tokens[0].toUpperCase();
                switch (command) {
                    case "LOGOUT":
                        logged = false;
                        System.out.println("Goodbye " + user);
                        break;
                    case "EXIT":
                        flag = false;
                        break;
                    case "S1":
                        managerUI.printGetSupermarketListByProductName(tokens[1]);
                        break;
                    case "S2":
                        managerUI.printGetProductByNameAndSupermarket(tokens[1], tokens[2]);
                        break;
                    case "S3":
                        managerUI.printGetListProductBySupermarket(tokens[1]);
                        break;
                    case "S4":
                        managerUI.printCheckRepartoInSupermarket(tokens[1], tokens[2]);
                        break;
                    case "BUY":
                        managerUI.printBuyProduct(tokens[1], Integer.parseInt(tokens[2]), tokens[3]);
                        break;
                    case "CARRELLO":
                        managerUI.printProductsInCarrello();
                        break;
                    case "REMOVE":
                        managerUI.printRemoveProductsFromCarrello(tokens[1], Integer.parseInt(tokens[2]));
                        break;
                    case "CHECKOUT":
                        managerUI.printCheckoutCarrello();
                        break;
                    default:
                        System.out.println("Unknown command, please use one of these: EXIT - LOGOUT - S1 - S2 - S3 - S4 -" +
                                " BUY - CARRELLO - REMOVE - CHECKOUT");
                        break;
                }
            } else {
                System.out.println("Please insert a username:");
                user = scanner.nextLine();
                logged = true;
                managerUI.printNewUser(user);
            }
        }
    }
}
