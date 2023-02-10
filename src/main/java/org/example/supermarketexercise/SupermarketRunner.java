package org.example.supermarketexercise;

import org.example.supermarketexercise.entities.Product;
import org.example.supermarketexercise.entities.Supermarket;
import org.example.supermarketexercise.entities.reparti.Macelleria;
import org.example.supermarketexercise.entities.reparti.Panetteria;
import org.example.supermarketexercise.entities.reparti.Pescheria;
import org.example.supermarketexercise.manager.SupermarketPrinter;

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
        Supermarket s1 = new Supermarket("Coop");
        Supermarket s2 = new Supermarket("Despar");

        Macelleria m = new Macelleria(s1);
        Product bistecca = new Product("bistecca", 4f, 20, m);
        Product wurstel = new Product("wurstel", 3f, 15, m);
        List<Product> pm = Arrays.asList(bistecca, wurstel);
        m.setProducts(pm);

        Panetteria pa = new Panetteria(s1);
        Product ciabatta = new Product("ciabatta", 2f, 30, pa);
        Product baguette = new Product("baguette", 3f, 15, pa);
        List<Product> ppa = Arrays.asList(ciabatta, baguette);
        pa.setProducts(ppa);

        s1.addReparto(m);
        s1.addReparto(pa);

        Pescheria pe = new Pescheria(s2);
        Product orata = new Product("orata", 10f, 10, pe);
        Product branzino = new Product("branzino", 8f, 9, pe);
        List<Product> pp = Arrays.asList(orata, branzino);
        pe.setProducts(pp);
        s2.addReparto(pe);

        supermarketList.add(s1);
        supermarketList.add(s2);

        SupermarketPrinter manager = new SupermarketPrinter(supermarketList);

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
                        manager.printGetSupermarketListByProductName(tokens[1]);
                        break;
                    case "S2":
                        manager.printGetProductByNameAndSupermarket(tokens[1], tokens[2]);
                        break;
                    case "S3":
                        manager.printGetListProductBySupermarket(tokens[1]);
                        break;
                    case "S4":
                        manager.printCheckRepartoInSupermarket(tokens[1], tokens[2]);
                        break;
                    case "BUY":
                        manager.printBuyProduct(tokens[1], Integer.parseInt(tokens[2]), tokens[3]);
                        break;
                    case "CARRELLO":
                        manager.printProductsInCarrello();
                        break;
                    case "REMOVE":
                        manager.printRemoveProductsFromCarrello(tokens[1], Integer.parseInt(tokens[2]));
                        break;
                    case "CHECKOUT":
                        manager.printCheckoutCarrello();
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
                manager.printNewUser(user);
            }
        }
    }
}
