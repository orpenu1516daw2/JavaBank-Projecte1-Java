/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entitatbancaria;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author oriol
 */
public class EntitatBancaria {

    /**
     * On s'inicia tot el programa, aquí setejem el valor inicial d'algunes variables importants
     * @param args
     */
    public static void main(String[] args) {
        boolean inici = true;
        ArrayList <Compte> compte = new ArrayList<>();
        ArrayList <Client> cli = new ArrayList<>();
        int IDc = 0, IDu = 0;
        
        creaAccount(compte,cli,inici,IDc,IDu);
    }

    /**
     * Crea un nou compte
     * @param compte paràmtre de tipus ArrayList que emmagatzema tots els comptes
     * @param client paràmtre de tipus ArrayList que emmagatzema tots els clients
     * @param inici paràmetre per indicar que és l'inici del programa (serveix per indicar si és el primer cop que posem en marxa el programa)
     * @param IDc índex de l'ArrayList de comptes
     * @param IDu índex de l'ArrayList d'usuaris
     */
    public static void creaAccount(ArrayList<Compte> compte, ArrayList<Client> client, boolean inici, int IDc, int IDu){
        Scanner line = new Scanner(System.in);
        Scanner lone = new Scanner(System.in);
        int c = 0;
        int n_comptes = 0;
        ArrayList <Client> particular;
        ArrayList <Client> empresa;
        
        String User = null;
        String Codi = null;
        String domicili = null;
        
        do{
            System.out.println("Benvingut a JavaBank");
            System.out.println("Crea un nou compte:\n\t1-Client particular\n\t2-Client empresa\n\t0-Sortir de l'aplicació");
            int sw = lone.nextInt();
            
            switch(sw){
                case 0:
                    System.exit(0);
                    break;
                case 1:
                    if(inici){
                        particular = new ArrayList<>();
                    }else{
                        particular = client;
                    }
                    c = 1;
                    System.out.println("\tNom: ");
                    String nom = line.nextLine();

                    System.out.println("\tCognom: ");
                    String cognom = line.nextLine();

                    System.out.println("\tDNI: ");
                    String DNI = line.nextLine();

                    System.out.println("\tDomicili: ");
                    domicili = line.nextLine();

                    creaCompteParticular(nom,cognom,DNI,domicili,n_comptes,compte,particular,IDc,IDu);
                    break;
                case 2:
                    if(inici){
                        empresa = new ArrayList<>();
                    }else{
                        empresa = client;
                    }
                    c = 2;
                    System.out.println("\tNom empresa: ");
                    String nom_empresa = line.nextLine();

                    System.out.println("\tCIF: ");
                    String CIF = line.nextLine();

                    System.out.println("\tDomicili: ");
                    domicili = line.nextLine();
                    
                    creaCompteEmpresa(nom_empresa,CIF,domicili,n_comptes,compte,empresa,IDc,IDu);
                    break;
                default:
                    System.out.println("Introdueïx un valor vàlid");
            }
        }while(true);
        
    }
    
    /**
     * Serveix per crear tant usuaris com comptes de clients particulars
     * @param nom paràmetre que indica el nom del cient
     * @param cognom paràmetre que indica el cognom del client
     * @param DNI paràmetre que indica el DNI del client
     * @param domicili paràmetre que indica el domicili del client
     * @param n_comptes paràmetre que indica el número de comptes del client
     * @param compte paràmtre de tipus ArrayList que emmagatzema tots els comptes
     * @param particular paràmtre de tipus ArrayList que emmagatzema tots els clients particulars
     * @param IDc índex de l'ArrayList de comptes
     * @param IDu índex de l'ArrayList de clients
     */
    public static void creaCompteParticular(String nom, String cognom, String DNI, String domicili, int n_comptes, ArrayList<Compte> compte, ArrayList<Client> particular, int IDc, int IDu){
        Scanner line = new Scanner(System.in);
        Scanner lone = new Scanner(System.in);
        int i = 0;
        n_comptes = n_comptes +1;
        int posArray = n_comptes -1;
        String n_compte = "JB" + DNI + n_comptes;

        compte.add(new Compte(n_compte, DNI, 20));
        if(posArray < 1){
            System.out.println("Creant nou client...");
            particular.add(new Particular(nom, cognom, DNI, domicili, compte));
            System.out.println("\n");
        }

        particular.get(IDu).setN_comptes(n_comptes);

        System.out.println("\nCompte creat correctament\n\tNom: " + nom + "\n\tCognom: " + cognom + "\n\tDNI: " + DNI + "\n\tDomicili: " + domicili + 
            "\n\tNúmero de comptes: " + particular.get(IDu).getN_comptes() + "\n\tNúmero de compte " + n_compte + "\n\tDiners actuals: " + compte.get(compte.size()-1).getDiners());

        Boolean exit = line.hasNextLine();
        
        if(exit){
            if(n_comptes < 2){
                login(nom,DNI,compte,particular,IDc,IDu);
            }else{
                logged(nom,DNI,compte,particular,IDc,IDu);
            }
        }  
    }
    
    /**
     * Serveix per crear tant usuaris com comptes de clients empresa
     * @param nom_empresa paràmetre que indica el nom de la empresa del cient
     * @param CIF paràmetre que indica el CIF del cient
     * @param domicili paràmetre que indica el domicili del cient
     * @param n_comptes paràmetre que indica el número de comptes del cient
     * @param compte paràmtre de tipus ArrayList que emmagatzema tots els comptes
     * @param empresa paràmtre de tipus ArrayList que emmagatzema tots els clients empresa
     * @param IDc índex de l'ArrayList de comptes
     * @param IDu índex de l'ArrayList de clients
     */
    public static void creaCompteEmpresa(String nom_empresa, String CIF, String domicili, int n_comptes, ArrayList<Compte> compte, ArrayList<Client> empresa, int IDc, int IDu){
        Scanner line = new Scanner(System.in);
        int c = 0;
        int i = 0;
        n_comptes = n_comptes +1;
        int posArray = n_comptes -1;
        String n_compte = "JB" + CIF + n_comptes;

        compte.add(new Compte(n_compte, CIF, 100));
        if(posArray < 1){
            System.out.println("Creant nou client...");
            empresa.add(new Empresa(nom_empresa, CIF, domicili, compte));
            System.out.println("\n");
        }
        empresa.get(IDu).setN_comptes(n_comptes);

        System.out.println("\nCompte creat correctament\n\tNom empresa: " + nom_empresa + "\n\tCIF: " + CIF + "\n\tDomicili: " + domicili + 
            "\n\tNúmero de comptes: " + empresa.get(IDu).getN_comptes() + "\n\tNúmero de compte " + n_compte + "\n\tDiners actuals: " + compte.get(compte.size()-1).getDiners());
        
        Boolean exit = line.hasNextLine();
        
        if(exit){
            if(n_comptes < 2){
                login(nom_empresa,CIF,compte,empresa,IDc,IDu);
            }else{
                logged(nom_empresa,CIF,compte,empresa,IDc,IDu);
            }
        }
    }

    /**
     * Serveix per ingressar o retirar diners del compte actual
     * @param compte paràmtre de tipus ArrayList que emmagatzema tots els comptes
     * @param client paràmtre de tipus ArrayList que emmagatzema tots els clients
     * @param msg paràmetre que contè el missatge per escollir si ingressar o retirar diners (serveix per printar-lo i per el switch)
     * @param IDc índex de l'ArrayList de comptes
     */
    public static void ingresRetirada(ArrayList <Compte> compte, ArrayList <Client> client, String msg, /*String user, String codi,*/ int IDc){
        Scanner line = new Scanner(System.in);

        System.out.println("Quantitat a " + msg);
        double m = line.nextDouble();
        switch (msg) {
            case "ingressar":
                compte.get(IDc).IngressarDiners(m);
                break;
            case "retirar":
                compte.get(IDc).RetirarDiners(m);
                break;
        }

        System.out.println("Diners al compte: " + compte.get(IDc).getDiners());
    }
    
    /**
     * Serveix per transferir diners entre comptes, tant de l'usuari com d'altres clients
     * @param compte paràmtre de tipus ArrayList que emmagatzema tots els comptes
     * @param client paràmtre de tipus ArrayList que emmagatzema tots els clients
     * @param user paràmetre que indica l'usuari actual
     * @param codi paràmetre que indica el codi de l'usuari actual (DNI o CIF)
     * @param IDc índex de l'ArrayList de comptes
     */
    public static void transferencia(ArrayList <Compte> compte, ArrayList <Client> client, String user, String codi, int IDc){
        Scanner line = new Scanner(System.in);
        boolean verifi = false;
        String ing;
        double q;
        int i,a = 0;
        
        System.out.println("\nTransefir diners a un altre compte\n\tIntrodueix el número de compte de destí: ");
        ing = line.nextLine();
        if(compte.get(IDc).getN_compte().equalsIgnoreCase(ing)){
            System.out.println("Acció no permesa, el compte " + ing + " és igual a l'actual");
            transferencia(compte,client,user,codi,IDc);
        }
        
        for(i = 0; i < compte.size(); i++){
            if(ing.equalsIgnoreCase(compte.get(i).getN_compte())){
                verifi = true;
                a = i;
            } 
        }
        if(!verifi){
            System.out.println("No s'ha trobat cap compte com a: " + ing);
            transferencia(compte,client,user,codi,IDc);
        }else{
            System.out.println("Quantitat a transferir: ");
            q = line.nextDouble();
            compte.get(IDc).RetirarDiners(q);
            compte.get(a).IngressarDiners(q);
        }
        System.out.println("Diners al compte: " + compte.get(IDc).getDiners());        
    }
    
    /**
     * Serveix per loguejar-se com un usuari ja registrat al sistema
     * @param u paràmetre que indica l'usuari actual
     * @param d paràmetre que indica el codi (DNI o CIF) de l'usuari actual
     * @param co paràmetre de tipus ArrayList que contè tots els comptes
     * @param cl paràmetre de tipus ArrayList que contè tots els clients
     * @param IDc índex de l'ArrayList de comptes
     * @param IDu índex de l'ArrayList de clients
     */
    public static void login(String u, String d, ArrayList <Compte> co, ArrayList <Client> cl, int IDc, int IDu){
        Scanner lone = new Scanner(System.in);
        Scanner line = new Scanner(System.in);
        int c = 0;
        String user = null;
        String codi = null;
        boolean access = false;
        
        ArrayList<Compte> compte = co;
        ArrayList<Client> client = cl;
        
        do{
            System.out.println("Benvingut a JavaBank");
            System.out.println("Logueja't:\n\t1-Client particular\n\t2-Client empresa\n\t3-Crear nou client\n\t0-Sortir de l'aplicació");
            int sw = lone.nextInt();
            switch(sw){
                case 0:
                    System.exit(0);
                    break;
                case 1:
                    c = 1;                    
                    break;
                case 2:
                    c = 2;
                    break;
                case 3:
                    boolean init = false;
                    creaAccount(compte,client,init,IDc,IDu);
                    break;
                default:
                    System.out.println("Introdueïx un valor vàlid");
                    break;
            }
        }while(c <1 || c >2);
        
        if(c == 1){
            System.out.println("\nNom: ");
            user = line.nextLine();
            
            System.out.println("\nDNI: ");
            codi = line.nextLine();
            
            for( int i = 0 ; i  < client.size(); i++){
                if(user.equalsIgnoreCase(client.get(i).getNom()) && codi.equalsIgnoreCase(client.get(i).getDNI())){
                    IDu = i;
                    user = client.get(IDu).getNom();
                    access = true;
                }
            }
            
        }else if(c == 2){
            System.out.println("\nNom empresa: ");
            user = line.nextLine();
            
            System.out.println("\nCIF: ");
            codi = line.nextLine();
            
            for( int i = 0 ; i  < client.size(); i++){
                if(user.equalsIgnoreCase(client.get(i).getNom()) && codi.equalsIgnoreCase(client.get(i).getCIF())){
                    IDu = i;
                    user = client.get(IDu).getNom();
                    access = true;
                }
            }    
        }

        if(access != true){
            System.out.println("\n\n\n\n\n\n\n\n\n\n");
            System.out.println("Error d'autentificació, torna-ho a intentar\n\n");
            
            login(u,d,co,cl,IDc,IDu);
            
        }else{
            System.out.println("\n\n\n\n\n\n\n\n\n\n");
            System.out.println("Autentificació correcta!\n\n");

            swCount(compte,client,user,codi,IDu);
        }
    }
    
    /**
     * Serveix per canviar entre els comptes que té l'usuari actual
     * @param compte paràmtre de tipus ArrayList que emmagatzema tots els comptes
     * @param client paràmtre de tipus ArrayList que emmagatzema tots els clients
     * @param user paràmetre que indica l'usuari actual
     * @param codi paràmetre que indica el codi de l'usuari actual (DNI o CIF)
     * @param IDu índex de l'ArrayList de clients
     */
    public static void swCount(ArrayList<Compte> compte, ArrayList<Client> client, String user, String codi, int IDu){
        Scanner line = new Scanner(System.in);
        int i;
        int IDc;
        String ing;
        ArrayList <Integer> indx = new ArrayList<>();
        ArrayList <String> comp = new ArrayList<>();
        for(i = 0 ; i  < compte.size(); i++){
            if(codi.equalsIgnoreCase(compte.get(i).getDni_cif())){
                System.out.println("Compte: " + compte.get(i).getN_compte() + " Saldo: " + compte.get(i).getDiners());
                indx.add(i);
                comp.add(compte.get(i).getN_compte());
            }
        }
        System.out.println("Introdueix el compte: ");
        ing = line.nextLine();
        for(i = 0 ; i  < comp.size(); i++){
            if(comp.get(i).equalsIgnoreCase(ing)){
                IDc = indx.get(i);
                logged(user,codi,compte,client,IDc,IDu);
            }/*else{
                System.out.println("\nIntrodueix un valor vàlid\n\n");
            }*/
        }
        System.out.println("\nIntrodueix un valor vàlid\n\n");
        swCount(compte,client,user,codi,IDu);
    }
    
    /**
     * Serveix per crear un pin de segurtat per la tarjeta
     * @param pin paràmetre que contè el pin creat per l'usuari
     * @return retorna el pin creat per l'usuari
     */
    public static int pin(int pin){
        Scanner line = new Scanner(System.in);
        int lenght;
        do{
           System.out.println("Introdueix un pin de 4 dígits:");
            pin = line.nextInt();

            lenght = Integer.toString(pin).length(); 
            if(lenght != 4){
                System.out.println("El pin contè " + lenght + " dígits");
            }   
        }while(lenght != 4);

        return pin;
    }
    
    /**
     * Serveix per generar un número de tarjeta al atzar
     * @param n_tarjeta paràmetre que contè el número de tarjeta
     * @return retorna el número de tarjeta generat
     */
    public static long n_tarjeta(long n_tarjeta){
        Random  rnd = new Random();
        n_tarjeta = rnd.nextInt(900000-100000+1)+10; 
        
        return n_tarjeta;
    }
    
    /**
     * Serveix per mostrar tot el menú d'opcions disponibles per a l'usuari actual un cop s'ha loguejat
     * @param User paràmetre que contè el nom o nom de la empresa de l'usuari actual
     * @param Codi paràmetre que contè el DNI o CIF de l'usuari actual
     * @param co paràmetre de tipus ArrayList que contè tots els comptes
     * @param cl paràmetre de tipus ArrayList que contè tots els clients
     * @param IDc índex de l'ArrayList de comptes
     * @param IDu índex de l'ArrayList de clients
     */
    public static void logged(String User, String Codi, ArrayList <Compte> co, ArrayList <Client> cl, int IDc, int IDu){
        String user = User;
        String codi = Codi;
        ArrayList<Compte> compte = co;
        ArrayList<Client> client = cl;
        int pin = 0000;
        long n_tarjeta = 0;
        long nTarjeta;
        int n_comptes = client.get(IDu).getN_comptes();
        String domicili = client.get(IDu).getDomicili();
        
        String msg;
        
        Scanner lone = new Scanner(System.in);
        Scanner line = new Scanner(System.in);

        do{
            System.out.println("Benvingut a JavaBank, " + user);
            System.out.println("\nQuè vols fer?\n\t1-Ingressar diners\n\t2-Retirar diners\n\t3-Transferir diners\n\t4-Obtenir préstec\n\t5-Consultar compte\n\t6-Crear targeta" +
                    "\n\t7-Crear nou compte\n\t8-Canviar de compte\n\t0-Tornar al login");
            int sw = lone.nextInt();

            switch(sw){
                case 0:
                    login(User, Codi, co, cl,IDc,IDu);
                    break;
                case 1:
                    msg = "ingressar";
                    ingresRetirada(compte,client,msg,IDc);
                    break;
                case 2:
                    msg = "retirar";
                    ingresRetirada(compte,client,msg,IDc);
                    break;
                case 3:
                    transferencia(compte,client,user,codi,IDc);
                    break;
                case 4:
                    double m = client.get(IDu).getPrestec();
                    compte.get(IDc).IngressarDiners(m);
                    System.out.println("Préstec obtingut de " + m + "\nDiners al compte: " + compte.get(IDc).getDiners());
                    break;
                case 5:
                    System.out.println("Informació del compte:\n\tNom propietari: " + user + "\n\tDNI/CIF: " + codi + "\n\tNúmero de compte: " + compte.get(IDc).getN_compte() 
                            + "\n\tDomicili: " + client.get(IDu).getDomicili() + "\n\tSaldo: " + compte.get(IDc).getDiners() + "\n\tNúmero de comptes: " + client.get(IDu).getN_comptes());

                    Boolean exit = line.hasNextLine();
                    
                    if(exit){
                        break;
                    }
                case 6:
                    int swT = 0;
                    int c = 0;
                    do{
                        System.out.println("Crear nova tarjeta\nEscull una opció:\n\t1-Tarjeta de crèdit\n\t2-Tarjeta de dèbit\n\t0-Cancel·lar");
                        swT = lone.nextInt();
                        switch(swT){
                            case 0:
                                logged(User,Codi,co,cl,IDc,IDu);
                                System.out.println("Operació cancel·lada\n\n");
                                break;
                            case 1:
                                c = 1;
                                pin = pin(pin);
                                nTarjeta = n_tarjeta(n_tarjeta); 
                                T_credit tCredit = new T_credit(nTarjeta, pin, compte.get(IDc).getN_compte(), codi, compte.get(IDc).getDiners());

                                System.out.println("Nova tarjeta de crèdit creada creada:\n\tNúmero de tarjeta: " + tCredit.getN_tarjeta() + "\n\tPin: " + tCredit.getPin() + 
                                        "\n\tNúmero de compte: " + tCredit.getN_compte() + "\n\tDiners: " + tCredit.getDiners());
                                break;
                            case 2:
                                c = 2;
                                pin = pin(pin);
                                nTarjeta = n_tarjeta(n_tarjeta);
                                T_debit tDebit = new T_debit(nTarjeta, pin, compte.get(IDc).getDiners(), compte.get(IDc).getN_compte(), codi, compte.get(IDc).getDiners());

                                System.out.println("Nova tarjeta de crèdit creada creada:\n\tNúmero de tarjeta: " + tDebit.getN_tarjeta() + "\n\tPin: " + tDebit.getPin() + 
                                        "\n\tNúmero de compte: " + tDebit.getN_compte() + "\n\tDiners: " + tDebit.getDiners());
                                break;
                            default:
                                System.out.println("Introdueïx un valor vàlid");
                                break;      
                        }
                    }while(c <1 || c >2);
                    break;
                case 7:
                    System.out.println("Crear nou compte:");
                    
                    if(user.equalsIgnoreCase(client.get(IDu).getNom()) && !client.get(IDu).getCognom().isEmpty()){
                        String cognom = client.get(IDu).getCognom();  
                        creaCompteParticular(user,cognom,codi,domicili,n_comptes,compte,client,IDc,IDu);
                    }else if(user.equalsIgnoreCase(client.get(IDu).getNom()) && client.get(IDu).getCognom().isEmpty()){
                        creaCompteEmpresa(user,codi,domicili,n_comptes,compte,client,IDc,IDu);
                    }
                    break;
                case 8:
                    System.out.println("Canviar de compte\n");
                    swCount(compte,client,user,codi,IDu);
                    break;
                default:
                    System.out.println("Introdueïx un valor vàlid");
                    break;
            }
        }while(true);
    }

}
