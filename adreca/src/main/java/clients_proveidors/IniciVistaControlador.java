/*
TO DO:
Arreglar todas las entradas de datos que no funcionan (no funcionan pq si, no hay razon alguna)

COMENTARIOS GENERALES:

 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clients_proveidors;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;

import java.io.FileOutputStream;
import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;

import java.io.IOException;
import java.io.InvalidClassException;
import java.io.ObjectInputStream;
import java.time.LocalDate;
import java.util.Scanner;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Usuario
 */
public class IniciVistaControlador {

    public static Adreca demanarAdreca() {

        Scanner cin = new Scanner(System.in);
        String poblacio;
        String provincia;
        int CP;
        String domicili;

        System.out.println("Introdueix la teva poblacio:");
        poblacio = cin.nextLine();
        System.out.println("Introdueix la teva provincia:");
        provincia = cin.nextLine();
        System.out.println("Introdueix el teu CP:");
        CP = cin.nextInt();
        System.out.println("Introdueix el teu domicili:");
        domicili = cin.nextLine();
        domicili = cin.nextLine();

        Adreca adreca = new Adreca(poblacio, provincia, CP, domicili);

        return adreca;
    }

    public static void menu() {
        System.out.println("\n0. Sortir de tota l'aplicacio\n"
                + "1. Productes i packs\n"
                + "2. Clients\n"
                + "3. Proveïdors\n"
                + "Opció:");
    }

    public static void menu2_2() {
        System.out.println("\n0. Sortir\n"
                + "1. Productes\n"
                + "2. Packs\n"
                + "Opció:");
    }
    
     public static void menu2_ordre() {
        System.out.println("\n0. Sortir\n"
                + "1. Mostrar per nom\n"
                + "2. Mostrar per preu\n"
                + "3. Mostrar per stock\n"                
                + "Opció:");
    }

    public static void menu2() {
        System.out.println("\n0. Sortir\n"
                + "1. Afegir producte\n"
                + "2. Buscar producte o pack\n"
                + "3. Modificar producte\n"
                + "4. Esborrar producte o pack\n"
                + "5. Mostrar tots els productes i packs\n"
                + "6. Afegir o retirar stock d'un producte\n"    
                + "7. Afegir stock d'un producte a partir d'un \"fitxer.txt\" a escollir \n"    
                + "8. Crear fitxer de comanda\n"//sobreescriu els fitxers si tenen el mateix nom
                + "9. Llistar productes descatalogats\n"                 
                + "Opció:");
    }

    public static void menu2_1() {
        System.out.println("\n0. Sortir\n"
                + "1. Afegir pack\n"
                + "2. Buscar pack o producte\n"
                + "3. Modificar pack\n"
                + "4. Esborrar pack o producte\n"
                + "5. Mostrar tots pack i productes\n"
                + "6. Afegir productes a un pack\n"     
                + "7. Retirar productes d'un pack\n"        
                + "Opció:");
    }

    public static void menu3() {
        System.out.println("\n0. Sortir\n"
                + "1. Afegir client\n"
                + "2. Buscar client\n"
                + "3. Modificar client\n"
                + "4. Esborrar client\n"
                + "5. Mostrar tots els clients\n"
                + "Opció:");
    }

    public static void menu4() {
        System.out.println("\n0. Sortir\n"
                + "1. Afegir proveïdors\n"
                + "2. Buscar proveïdors\n"
                + "3. Modificar proveïdors\n"
                + "4. Esborrar proveïdors\n"
                + "5. Mostrar tots els proveïdors\n"
                + "Opció:");
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException, FileNotFoundException, InvalidClassException {
       
        Scanner cin = new Scanner(System.in);
        int opcioMenu = 0;
        int opcio = 0;
        int opcioPack = 0;
        int opcio_ordre=0;

        //productes
        Object o = new Object();
        Productes producte = new Productes();
        Packs pack = new Packs();
        int idproducte = 0;
        String nom = "kola";
        int preuVenda = 0;
        int stock = 0;
        float dto = 0;
        LocalDate dataInici=LocalDate.now().minusYears(10), dataFinal=LocalDate.now(); //Per defecte -> inici: data actual -10 anys final:data actual
        //opcio 6 i 7 i 8 prod
        int s=0, quant=0;
        String nom_fitxer="nop";
        //opcio 6 packs
        int idpack=0;
        //ordenar
         ArrayList<Productes> prods = new ArrayList<Productes>();
        
        //clients i proveidors
        Clients client = new Clients();
        Proveidors proveidor = new Proveidors();
        int idpersona = 0;
        int dni = 0;
        //String nom; ja esta creada
        String cognoms = "nop";
        String data_tmp = "nop";
        LocalDate naixement;
        String mail = "nop";
        int tlf=0;
        Adreca adress; //pedirla a trvaes de la funcion creada
        int edat = 0;
        
        
        //DAO
        DAO<Productes> daoProd = new DAO<Productes>();
        DAO<Proveidors> daoProv = new DAO<Proveidors>();
        DAO<Clients> daoCli = new DAO<Clients>();
              
        //Hash
        HashMap<Integer, Productes> hashProductes = new HashMap<Integer, Productes>(); 
        HashMap<Integer, Clients> hashClients = new HashMap<Integer, Clients>();
        HashMap<Integer, Proveidors> hashProveidors = new HashMap<Integer, Proveidors>();
        
        HashMap<Integer, Productes> hashPacks = new HashMap<Integer, Productes>();

        
        System.out.println("Carregant dades...");
        daoProd.obrirFitxer();
       
        /*       
        daoProv.obrirFitxer();
        daoCli.obrirFitxer();        
        */
        
        do {

            menu();
            opcioMenu = cin.nextInt();

            switch (opcioMenu) {

                case 0:
                    
                    //daoProv.guardarFitxer();
                    //daoCli.guardarFitxer();
                    System.out.println("Guardant dades...");
                    daoProd.guardarFitxer();
                    System.out.println("Sortint de l'aplicacio ...");
                    
                    break;

                case 1:

                    do {
                        menu2_2();
                        opcioPack = cin.nextInt();

                        switch (opcioPack) {

                            case 0:
                                System.out.println("Tornant al menu principal...\n");
                                break;

                            case 1:

                                do {
                                    menu2();
                                    opcio = cin.nextInt();
                                    
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                                   //P R O D U C T E S
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

      
                                    
                                    switch (opcio) {
                                        case 0:
                                            System.out.println("Tornant al menu principal...\n");
                                            break;

                                        case 1:

                                            System.out.println("Introdueix l'ID del producte: ");
                                            idproducte = cin.nextInt();

                                            //em de buscar si l'ID ja existeix
                                            o = daoProd.search(idproducte);

                                            if (o != null) {
                                                System.out.println("No es pot afegir el producte, ID ja usat");
                                            } else {
                                                System.out.println("Introdueix el preu de venda del producte: ");
                                                preuVenda = cin.nextInt();

                                                System.out.println("Introdueix l'stock del producte: ");
                                                stock = cin.nextInt();

                                                System.out.println("Introdueix nom del producte: ");
                                                nom = cin.nextLine();
                                                cin.next();
                                                //Ho poso 3 cops pq sino NO EM FUNCIONA AGHHH

                                                System.out.println("Introdueix data inici del producte: (YYYY-MM-DD) ");
                                                try {
                                                    data_tmp = cin.nextLine();
                                                    cin.nextLine();
                                                    data_tmp = cin.nextLine();
                                                    

                                                    if (data_tmp.equals("")) {
                                                        dataInici = LocalDate.now().minusYears(10);
                                                    } else {
                                                        dataInici = LocalDate.parse(data_tmp);
                                                    }
                                                    
                                                } catch (Error e) { //DateTimeParseException
                                                    System.out.println("Data no introduida correctament");
                                                }
                                                
                                                 System.out.println("Introdueix data final del producte: (YYYY-MM-DD)1 ");
                                                try {
                                                    data_tmp = cin.nextLine();
                                                    cin.nextLine();

                                                    if (data_tmp.equals("")) {
                                                        dataFinal = LocalDate.now();
                                                    } else {
                                                        dataFinal = LocalDate.parse(data_tmp);
                                                    }
                                                    
                                                } catch (Error e) { //DateTimeParseException
                                                    System.out.println("Data no introduida correctament");
                                                }

                                                Productes prod = new Productes(idproducte, nom, preuVenda, stock, dataInici, dataFinal);

                                                daoProd.save(prod);

                                                System.out.println("Producte afegit amb exit\n");
                                            }

                                            break;

                                        case 2:

                                            System.out.println("Introdueix l'ID del producte o pack a buscar: ");
                                            idproducte = cin.nextInt();

                                            o = daoProd.search(idproducte);

                                            if (o != null) {

                                                if (o instanceof Packs) {
                                                    pack = (Packs) o;
                                                    System.out.println("Pack trobat: " + pack.toString());
                                                } else if (o instanceof Productes) {
                                                    producte = (Productes) o;
                                                    System.out.println("Producte trobat: " + producte.toString());
                                                }

                                            } else {
                                                System.out.println("Producte o pack no trobat");
                                            }
                                            break;

                                        case 3:

                                            System.out.println("Introdueix l'ID del producte a modificar: ");
                                            idproducte = cin.nextInt();

                                            //busquem si existeix
                                            o = daoProd.search(idproducte);

                                            if (o != null) {
                                                if (o instanceof Packs) {
                                                    System.out.println("L'ID introduit pertany a un pack, no a un producte");
                                                } else if (o instanceof Productes) {
                                                    System.out.println("Dades actuals del producte: \n" + o.toString());

                                                    System.out.println("\nIntrodueix el nou preu de venda del producte: ");
                                                    preuVenda = cin.nextInt();

                                                    System.out.println("Introdueix el nou stock del producte: ");
                                                    stock = cin.nextInt();

                                                    System.out.println("Introdueix el nou nom del producte: ");
                                                    nom = cin.nextLine();
                                                    cin.next();

                                                    System.out.println("Introdueix la nova data inici del producte: (YYYY-MM-DD) ");
                                                    try {
                                                        data_tmp = cin.nextLine();
                                                        data_tmp = cin.nextLine();

                                                        if (data_tmp.equals("")) {
                                                            dataInici = LocalDate.now().minusYears(10);
                                                        } else {
                                                            dataInici = LocalDate.parse(data_tmp);
                                                        }

                                                    } catch (Error e) { //DateTimeParseException
                                                        System.out.println("Data no introduida correctament");
                                                    }

                                                    System.out.println("Introdueix la nova data final del producte: (YYYY-MM-DD)1 ");
                                                    try {
                                                        data_tmp = cin.nextLine();
                                                        data_tmp = cin.nextLine();

                                                        if (data_tmp.equals("")) {
                                                            dataFinal = LocalDate.now();
                                                        } else {
                                                            dataFinal = LocalDate.parse(data_tmp);
                                                        }

                                                    } catch (Error e) { //DateTimeParseException
                                                        System.out.println("Data no introduida correctament");
                                                    }

                                                    Productes prod = new Productes(idproducte, nom, preuVenda, stock, dataInici, dataFinal);
                                                    daoProd.modify(prod);

                                                    System.out.println("Producte modificat amb exit, les noves dades són: \n" + prod.toString());
                                                }

                                            } else {
                                                System.out.println("Producte no trobat, no es pot modificar");
                                            }

                                            break;

                                        case 4:

                                            System.out.println("Introdueix l'ID del producte o pack a esborrar: ");
                                            idproducte = cin.nextInt();

                                            //busquem si existeix
                                            o = daoProd.search(idproducte);

                                            if (o != null) {
                                                daoProd.remove(idproducte);
                                                System.out.println("Producte o pack esborrat amb exit");
                                            } else {
                                                System.out.println("Producte o pack no trobat, no es pot esborrar");
                                            }

                                            break;

                                        case 5:

                                            hashProductes = daoProd.getMap();
                                            prods.clear();
                                            for (Integer clave : hashProductes.keySet()) {
                                                prods.add(hashProductes.get(clave));
                                            }

                                            do {
                                                menu2_ordre();
                                                opcio_ordre = cin.nextInt();

                                                switch (opcio_ordre) {
                                                    case 0:
                                                        System.out.println("Sortint...");
                                                        break;
                                                    case 1:
                                                        System.out.println("Llista de tots els productes i packs ordenats per NOM: \n");
                                                        Collections.sort(prods, new ComparadorNom());
                                                        prods.forEach(System.out::println);

                                                        break;
                                                    case 2:
                                                        System.out.println("Llista de tots els productes i packs ordenats per PREU: \n");
                                                        Collections.sort(prods, new ComparadorPreu());
                                                        prods.forEach(System.out::println);
                                                        break;
                                                    case 3:
                                                        System.out.println("Llista de tots els productes i packs ordenats per STOCK: \n");
                                                        Collections.sort(prods, new ComparadorStock());
                                                        prods.forEach(System.out::println);
                                                        break;
                                                    default:
                                                        System.out.println("Opcio invalida");
                                                        break;
                                                }

                                            } while (opcio_ordre != 0);

                                            break;

                                        case 6:
                                            System.out.println("Introdueix l'ID del producte que vols modificar l'stock");
                                            
                                            idproducte = cin.nextInt();

                                            //busquem si existeix
                                            o = daoProd.search(idproducte);

                                            if (o != null) {
                                               
                                                
                                                do{
                                                System.out.println("Vols retirar o afegir stock?");
                                                System.out.println("1- Retirar");
                                                System.out.println("2- Afegir");
                                                s=cin.nextInt();
                                                if(s!=1 && s!=2)
                                                System.out.println("Opcio no valida");
                                                }while(s!=1 && s!=2);
                                                
                                                do{
                                                System.out.println("Quina quantitat?");
                                                quant=cin.nextInt();
                                                if(quant<=0)
                                                System.out.println("Quantitat no valida");
                                                }while(quant<=0);

                                                 if(s==2){
                                                     daoProd.putStockDao(quant, idproducte);
                                                     System.out.println("Stock afegit amb exit");
                                                 }
                                                 else
                                                     if(s==1){
                                                     daoProd.takeStockDao(quant, idproducte);                                                
                                                     
                                                     }
                                     
                                            } else {
                                                System.out.println("Producte no trobat, no es pot modificar l'stock");
                                            }

                                            break;

                                        case 7:
                                            //este archivo tiene 2 columnas y 20 filas, la 1 columna es el id i es de tipo String, se lee con readUTF
                                            //la 2a columna es la cantidad de stock a añadir i es de tipo int, se lee con readInt. Si solo ejecutaramos readUTF
                                            //una i otra vez solo leeria los, id, no habria problema que por error leiera de`pues del id el int i diese algun tipo de error
                                            //lo que hara readUTF sera siempre leer el siguiente string disponible dentro del archivo indicado
                                            //hay que saber MUY IMPORTANTE que al leer (simplemente leer, es decir, usar readX), lo que lee
                                            //del archivo SE BORRA (no de vd) por lo que solo se puede leer una sola vez, por eso lee hasta que 
                                            // .available() > 0 ya que son los bits que quedan por leer (o algo asi)
                                            System.out.println("Introdueix nom del fitxer:");
                                            nom_fitxer=cin.nextLine();
                                            nom_fitxer=cin.nextLine();
                                            
                                            //habria que hacer un try catch por si no encuentra el archivo
                                            
                                            try {
                                                DataInputStream dis = new DataInputStream(new BufferedInputStream(new FileInputStream(nom_fitxer)));

                                                while (dis.available() > 0) {

                                                    idproducte = Integer.parseInt(dis.readUTF());
                                                    quant = dis.readInt();

                                                    //busquem si existeix
                                                    o = daoProd.search(idproducte);

                                                    if (o != null) {
                                                        daoProd.putStockDao(quant, idproducte);
                                                        System.out.println("Stock afegit amb exit");
                                                    } else {
                                                        System.out.println("Producte no trobat, no es pot modificar l'stock");
                                                    }
                                                }
                                                dis.close();

                                            } catch (FileNotFoundException fi) {
                                                System.out.println("Fitxer no trobat");
                                            }

                                            break;

                                        case 8:
                                            System.out.println("Introdueix el nom del fitxer a crear: ");
                                            nom_fitxer=cin.nextLine();
                                            nom_fitxer=cin.nextLine();
                                            nom_fitxer=nom_fitxer.replace(" ", "");
                                            
                                            do{
                                            System.out.println("Introdueix l'ID del producte a afegir: (introduir -1 per finalitzar comanda)  ");
                                                idproducte = cin.nextInt();

                                                o = daoProd.search(idproducte);

                                                if (o != null) {
                                                    System.out.println("Introdueix la quantitat del producte:");

                                                    do {
                                                        quant = cin.nextInt();
                                                        if (quant <= 0) {
                                                            System.out.println("Quantitat no valida");
                                                        }
                                                    } while (quant <= 0);

                                                    DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(nom_fitxer, true)));
                                                    dos.writeUTF(String.valueOf(idproducte));
                                                    dos.writeInt(quant);
                                                    dos.close();

                                                } else if (idproducte == -1) {
                                                    System.out.println("Acabant comanda...");
                                                } else {
                                                    System.out.println("Producte no trobat, no es pot demanar");
                                                }

                                            } while (idproducte != -1);
                                            System.out.println("Fitxer \"" + nom_fitxer + "\" creat");
                                            break;
                                            
                                            
                                        case 9: System.out.println("Introdueix la data a partir de la qual es mostren els productes descatalogats (YYYY-MM-DD): "); 
                                        
                                        try{
                                                data_tmp = cin.nextLine();
                                                data_tmp = cin.nextLine();   
                                                
                                                if(data_tmp.equals("")){
                                                    dataFinal= LocalDate.now();
                                                }
                                                else{
                                                dataFinal = LocalDate.parse(data_tmp);
                                                }
                                                
                                                  daoProd.mostrarDescatalogados(dataFinal); 
                                        }catch(Error e){ //DateTimeParseException
                                            System.out.println("Data no introduida correctament");
                                        }
                                          break;
                                            
                                            
                                        default:
                                            System.out.println("Opcio incorrecta, introdueix una opcio valida");
                                            break;
                                    }//fi swtich productes
                                } while (opcio != 0);
                                break;

                            case 2:

                                do {
                                    menu2_1();
                                    opcio = cin.nextInt();
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                                    //P A C K S   
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

                                            
                                    
                                    
                                    switch (opcio) {
                                        case 0:
                                            System.out.println("Tornant al menu principal...\n");
                                            break;

                                        case 1:

                                            System.out.println("Introdueix l'ID del pack: ");
                                            idproducte = cin.nextInt();

                                            //em de buscar si l'ID ja existeix
                                            o = daoProd.search(idproducte);

                                            if (o != null) {
                                                System.out.println("No es pot afegir el pack, ID ja usat");
                                            } else {
                                                System.out.println("Introdueix el preu de venda del pack: ");
                                                preuVenda = cin.nextInt();

                                                System.out.println("Introdueix l'stock del pack: ");
                                                stock = cin.nextInt();

                                                System.out.println("Introdueix nom del pack: ");
                                                nom = cin.nextLine();
                                                cin.next();
                                                

                                                System.out.println("Introdueix el percentatge de descompte del pack: ");
                                                dto = cin.nextInt();

                                                Packs pac = new Packs(idproducte, nom, preuVenda, stock, dto);

                                                daoProd.save(pac);

                                                System.out.println("Pack afegit amb exit\n");
                                            }

                                            break;

                                        case 2:

                                            System.out.println("Introdueix l'ID del pack o producte a buscar: ");
                                            idproducte = cin.nextInt();

                                            o = daoProd.search(idproducte);
                                            if (o != null) {
                                                if (o instanceof Packs) {
                                                    pack = (Packs) o;
                                                    System.out.println("Pack trobat: " + pack.toString());
                                                } else if (o instanceof Productes) {
                                                    producte = (Productes) o;
                                                    System.out.println("Producte trobat: " + producte.toString());
                                                }
                                            } else {
                                                System.out.println("Producte o pack no trobat");
                                            }
                                            break;

                                        case 3:

                                            System.out.println("Introdueix l'ID del pack a modificar: ");
                                            idproducte = cin.nextInt();

                                            //busquem si existeix
                                            o = daoProd.search(idproducte);

                                            if (o != null) {
                                                if (o instanceof Packs) {
                                                    System.out.println("Dades actuals del pack: \n" + o.toString());

                                                    System.out.println("\nIntrodueix el preu de venda del pack: ");
                                                    preuVenda = cin.nextInt();

                                                    System.out.println("Introdueix l'stock del pack: ");
                                                    stock = cin.nextInt();

                                                    System.out.println("Introdueix nom del pack: ");
                                                    nom = cin.nextLine();
                                                    cin.next();
                                                   

                                                    System.out.println("Introdueix el percentatge de descompte del pack: ");
                                                    dto = cin.nextInt();                                                 
                                                   
                                                    Packs pac = new Packs(idproducte, nom, preuVenda, stock, dto);
                                                    daoProd.modify(pac);

                                                    System.out.println("Pack modificat amb exit, les noves dades son:\n" + pac.toString());
                                                    
                                                } else if (o instanceof Productes) {
                                                    System.out.println("L'ID introduit pertany a un producte, no a un pack");
                                                }

                                            } else {
                                                System.out.println("Pack no trobat, no es pot modificar");
                                            }

                                            break;

                                        case 4:

                                            System.out.println("Introdueix l'ID del pack o producte a esborrar: ");
                                            idproducte = cin.nextInt();

                                            //busquem si existeix
                                            o = daoProd.search(idproducte);

                                            if (o != null) {
                                                daoProd.remove(idproducte);
                                                System.out.println("Pack o producte esborrat amb exit");
                                            } else {
                                                System.out.println("Pack o producte no trobat, no es pot esborrar");
                                            }

                                            break;

                                        case 5:
                                            hashProductes = daoProd.getMap();
                                            prods.clear();
                                            for (Integer clave : hashProductes.keySet()) {
                                                prods.add(hashProductes.get(clave));
                                            }

                                            do {
                                                menu2_ordre();
                                                opcio_ordre = cin.nextInt();

                                                switch (opcio_ordre) {
                                                    case 0:
                                                        System.out.println("Sortint...");
                                                        break;
                                                    case 1:
                                                        System.out.println("Llista de tots els productes i packs ordenats per NOM: \n");
                                                        Collections.sort(prods, new ComparadorNom());
                                                        prods.forEach(System.out::println);

                                                        break;
                                                    case 2:
                                                        System.out.println("Llista de tots els productes i packs ordenats per PREU: \n");
                                                        Collections.sort(prods, new ComparadorPreu());
                                                        prods.forEach(System.out::println);
                                                        break;
                                                    case 3:
                                                        System.out.println("Llista de tots els productes i packs ordenats per STOCK: \n");
                                                        Collections.sort(prods, new ComparadorStock());
                                                        prods.forEach(System.out::println);
                                                        break;
                                                    default:
                                                        System.out.println("Opcio invalida");
                                                        break;
                                                }

                                            } while (opcio_ordre != 0);

                                            break;

                                        case 6:

                                            System.out.println("Introdueix l'ID del pack al que vols afegir productes: ");
                                            idproducte = cin.nextInt();

                                            //busquem si existeix
                                            o = daoProd.search(idproducte);

                                            //comprovem que existeix i que es un pack
                                            if (o != null && (o instanceof Packs)) {

                                                idpack = idproducte;

                                                do { //es poden afegir multiples productes sense haver dentrar en el menu un altre cop
                                                    System.out.println("Introdueix l'ID del producte que vols afegir: (-1 per sortir)");
                                                    idproducte = cin.nextInt();

                                                    //busquem si existeix
                                                    o = daoProd.search(idproducte);

                                                    //comprobar que el prod no esta ja inclos en el pack
                                                    if (o != null && (o instanceof Productes)) {
                                                        
                                                        hashProductes = daoProd.getMap();//para mantenerlo actualizado  
                                                        
                                                        hashPacks=((Packs)(hashProductes.get(idpack))).getPacks();
                                                        if(hashPacks.containsKey(idproducte)){
                                                            System.out.println("El pack ja conté aquest producte, no s'afegira");
                                                        }
                                                        else

                                                        if (hashProductes.get(idpack) instanceof Packs) {
                                                            ((Packs) (hashProductes.get(idpack))).afegirProducte((Productes) o);
                                                            
                                                             System.out.println("Producte afegit amb exit");
                                                        }

                                                       
                                                    } else if (idproducte == -1) {

                                                    } else {
                                                        System.out.println("Producte no trobat, no es pot afegir");
                                                    }

                                                } while (idproducte != -1);

                                                System.out.println("Accio finalitzada:");
                                                System.out.println(hashProductes.get(idpack));

                                            } else {
                                                System.out.println("Pack no trobat, no es poden afegir productes");
                                            }

                                            break;
                                            
                                           case 7: 

                                            System.out.println("Introdueix l'ID del pack al que vols retirar productes: ");
                                            idproducte = cin.nextInt();

                                            //busquem si existeix
                                            o = daoProd.search(idproducte);

                                            //comprovem que existeix i que es un pack
                                            if (o != null && (o instanceof Packs)) {

                                                idpack = idproducte;

                                                do { //es poden afegir multiples productes sense haver dentrar en el menu un altre cop
                                                    System.out.println("Introdueix l'ID del producte que vols retirar: (-1 per sortir)");
                                                    idproducte = cin.nextInt();

                                                    //busquem si existeix
                                                    o = daoProd.search(idproducte);

                                                    //comprobar que el prod no esta ja inclos en el pack
                                                    if (o != null && (o instanceof Productes)) {

                                                        hashProductes = daoProd.getMap();//para mantenerlo actualizado  

                                                        hashPacks = ((Packs) (hashProductes.get(idpack))).getPacks();
                                                        if (hashPacks.containsKey(idproducte)) {
                                                            
                                                            ((Packs) (hashProductes.get(idpack))).retirarProducte((Productes) o);

                                                            System.out.println("Producte retirat amb exit");
                                                            
                                                             } else if (hashProductes.get(idpack) instanceof Packs) {
                                                             System.out.println("El pack no conté aquest producte, no es pot retirar");                                                      
                                                        }

                                                    } else 
                                                        if (idproducte == -1) {
                                                            //solo salir del bucle
                                                    } else {
                                                        System.out.println("Producte no existent, no es pot retirar");
                                                    }

                                                } while (idproducte != -1);

                                                System.out.println("Accio finalitzada:");
                                                System.out.println(hashProductes.get(idpack));

                                            } else {
                                                System.out.println("Pack no trobat, no es poden afegir productes");
                                            }

                                            break;

                                        default:
                                            System.out.println("Opcio incorrecta, introdueix una opcio valida");
                                            break;
                                    }//fi swtich packs
                                } while (opcio != 0);

                                break;

                            default:
                                System.out.println("Opcio incorrecta, introdueix una opcio valida");
                                break;

                        }//fi switch pack + producte
                    } while (opcioPack != 0);

                    break;

                case 2:
                    do {
                        menu3();
                        opcio = cin.nextInt();

                        switch (opcio) {
                            case 0:
                                System.out.println("Tornant al menu principal...\n");
                                break;

                            case 1:

                                System.out.println("Introdueix l'ID del client: ");
                                idpersona = cin.nextInt();

                                //em de buscar si l'ID ja existeix
                                client = daoCli.search(idpersona);
                                if (client != null) {
                                    System.out.println("No es pot afegir el client, ID ja usat");
                                } else {
                                    System.out.println("Introdueix el DNI del client: ");
                                    dni = cin.nextInt();

                                    System.out.println("Introdueix el nom del client: ");
                                    nom = cin.nextLine();
                                    cin.next();
                                   

                                    System.out.println("Introdueix els cognoms del client: ");
                                    cognoms = cin.nextLine();

                                    System.out.println("Introdueix la data de naixement del client (YYYY-MM-DD): "); 
                                    data_tmp = cin.nextLine();
                                    naixement = LocalDate.parse(data_tmp);

                                    System.out.println("Introdueix el telefon del client: ");
                                    tlf = cin.nextInt();

                                    System.out.println("Introdueix el mail del client: ");
                                    mail = cin.nextLine();
                                    mail = cin.nextLine();

                                    System.out.println("Introdueix l'adreca del client: ");
                                    adress = demanarAdreca();

                                    System.out.println("Introdueix l'edat del client: ");
                                    edat = cin.nextInt();
                                    
                                    Clients clie = new Clients(idpersona, dni, nom, cognoms, naixement, tlf, mail, adress, edat);

                                    daoCli.save(clie);

                                    System.out.println("Client afegit amb exit\n");
                                }

                                break;

                            case 2:

                                System.out.println("Introdueix l'ID del client a buscar: ");
                                idpersona = cin.nextInt();

                                client = daoCli.search(idpersona);
                                if (client != null) {
                                    System.out.println("Client trobat: \n" + client.toString());
                                } else {
                                    System.out.println("Client no trobat");
                                }
                                break;

                            case 3:

                                System.out.println("Introdueix l'ID del client a modificar: ");
                                idpersona = cin.nextInt();

                                //busquem si existeix
                                client = daoCli.search(idpersona);
                                if (client != null) {
                                    System.out.println("Dades actuals del client: \n" + client.toString());

                                    System.out.println("Introdueix el DNI del client: ");
                                    dni = cin.nextInt();

                                    System.out.println("Introdueix el nom del client: ");
                                    nom = cin.nextLine();
                                    cin.next();
                                   

                                    System.out.println("Introdueix els cognoms del client: ");
                                    cognoms = cin.nextLine();

                                    System.out.println("Introdueix la data de naixement del client (YYYY-MM-DD): "); 
                                    data_tmp = cin.nextLine();
                                    naixement = LocalDate.parse(data_tmp);

                                    System.out.println("Introdueix el telefon del client: ");
                                    tlf = cin.nextInt();

                                    System.out.println("Introdueix el mail del client: ");
                                    mail = cin.nextLine();
                                    mail = cin.nextLine();

                                    System.out.println("Introdueix l'adreca del client: ");
                                    adress = demanarAdreca();

                                    System.out.println("Introdueix l'edat del client: ");
                                    edat = cin.nextInt();
                                    
                                    Clients clie= new Clients(idpersona, dni, nom, cognoms, naixement, tlf, mail, adress, edat);

                                    daoCli.modify(clie);
                                   
                                    client = daoCli.search(idpersona);
                                    System.out.println("Client modificat amb exit, les noves dades son:\n" + client.toString());

                                } else {
                                    System.out.println("Client no trobat, no es pot modificar");
                                }

                                break;

                            case 4:

                                System.out.println("Introdueix l'ID del client a esborrar: ");
                                idpersona = cin.nextInt();

                                //busquem si existeix
                                client = daoCli.search(idpersona);
                                if (client != null) {
                                    daoCli.remove(idpersona);
                                    System.out.println("Client esborrat amb exit");
                                } else {
                                    System.out.println("Client no trobat, no es pot esborrar");
                                }
                                break;

                            case 5:

                                hashClients = daoCli.getMap();
                                System.out.println("Llista de tots els clients i les seves dades: \n");

                                for (Integer clave : hashClients.keySet()) {
                                    System.out.println(hashClients.get(clave).toString());
                                }
                                break;

                            default:
                                System.out.println("Opcio incorrecta, introdueix una opcio valida");
                                break;
                        }
                    } while (opcio != 0);
                    break;

                case 3:
                    do {
                        menu4();
                        opcio = cin.nextInt();

                        switch (opcio) {
                            case 0:
                                System.out.println("Tornant al menu principal...\n");
                                break;

                            case 1:

                                System.out.println("Introdueix l'ID del proveidor: ");
                                idpersona = cin.nextInt();

                                //em de buscar si l'ID ja existeix
                                proveidor = daoProv.search(idpersona);
                                if (proveidor != null) {
                                    System.out.println("No es pot afegir el proveidor, ID ja usat");
                                } else {
                                    System.out.println("Introdueix el DNI del proveidor: ");
                                    dni = cin.nextInt();

                                    System.out.println("Introdueix el nom del proveidor: ");
                                    nom = cin.nextLine();
                                    cin.next();
                                   

                                    System.out.println("Introdueix els cognoms del proveidor: ");
                                    cognoms = cin.nextLine();

                                    System.out.println("Introdueix la data de naixement del proveidor (YYYY-MM-DD): "); 
                                    data_tmp = cin.nextLine();
                                    naixement = LocalDate.parse(data_tmp);

                                    System.out.println("Introdueix el telefon del proveidor: ");
                                    tlf = cin.nextInt();

                                    System.out.println("Introdueix el mail del proveidor: ");
                                    mail = cin.nextLine();
                                    mail = cin.nextLine();

                                    System.out.println("Introdueix l'adreca del proveidor: ");
                                    adress = demanarAdreca();

                                    System.out.println("Introdueix l'edat del proveidor: ");
                                    edat = cin.nextInt();
                                    
                                    Proveidors prov = new Proveidors(idpersona, dni, nom, cognoms, naixement, tlf, mail, adress, edat);

                                    daoProv.save(prov);

                                    System.out.println("Proveidor afegit amb exit\n");
                                }

                                break;

                            case 2:

                                System.out.println("Introdueix l'ID del proveidor a buscar: ");
                                idpersona = cin.nextInt();

                                proveidor = daoProv.search(idpersona);
                                if (proveidor != null) {
                                    System.out.println("Proveidor trobat: \n" + proveidor.toString());
                                } else {
                                    System.out.println("Proveidor no trobat");
                                }
                                break;

                            case 3:

                                System.out.println("Introdueix l'ID del proveidor a modificar: ");
                                idpersona = cin.nextInt();

                                //busquem si existeix
                                proveidor = daoProv.search(idpersona);
                                if (proveidor != null) {
                                    System.out.println("Dades actuals del proveidor: \n" + proveidor.toString());

                                    System.out.println("Introdueix el DNI del proveidor: ");
                                    dni = cin.nextInt();

                                    System.out.println("Introdueix el nom del proveidor: ");
                                    nom = cin.nextLine();
                                    cin.next();
                                    

                                    System.out.println("Introdueix els cognoms del proveidor: ");
                                    cognoms = cin.nextLine();

                                    System.out.println("Introdueix la data de naixement del proveidor (YYYY-MM-DD): "); 
                                    data_tmp = cin.nextLine();
                                    naixement = LocalDate.parse(data_tmp);

                                    System.out.println("Introdueix el telefon del proveidor: ");
                                    tlf = cin.nextInt();

                                    System.out.println("Introdueix el mail del proveidor: ");
                                    mail = cin.nextLine();
                                    mail = cin.nextLine();

                                    System.out.println("Introdueix l'adreca del proveidor: ");
                                    adress = demanarAdreca();

                                    System.out.println("Introdueix l'edat del proveidor: ");
                                    edat = cin.nextInt();
                                    
                                    Proveidors prov = new Proveidors(idpersona, dni, nom, cognoms, naixement, tlf, mail, adress, edat);

                                    daoProv.modify(prov);

                                    //este proceso de mostrar el resultado lo hago diferente a productes, pero el resultado es el mismo
                                    proveidor = daoProv.search(idpersona);
                                    System.out.println("Proveidor modificat amb exit, les noves dades son:\n" + proveidor.toString());

                                } else {
                                    System.out.println("Proveidor no trobat, no es pot modificar");
                                }

                                break;

                            case 4:

                                System.out.println("Introdueix l'ID del proveidor a esborrar: ");
                                idpersona = cin.nextInt();

                                //busquem si existeix
                                proveidor = daoProv.search(idpersona);
                                if (proveidor != null) {
                                    daoProv.remove(idpersona);
                                    System.out.println("Proveidor esborrat amb exit");
                                } else {
                                    System.out.println("Proveidor no trobat, no es pot esborrar");
                                }
                                break;

                            case 5:

                                hashProveidors = daoProv.getMap();
                                System.out.println("Llista de tots els proveidors i les seves dades: \n");

                                for (Integer clave : hashProveidors.keySet()) {
                                    System.out.println(hashProveidors.get(clave).toString());
                                }
                                break;

                            default:
                                System.out.println("Opcio incorrecta, introdueix una opcio valida");
                                break;
                        }
                    } while (opcio != 0);
                    break;

                default:
                    System.out.println("Opcio incorrecta, introdueix una de valida:\n");
                    break;

            }//fi switch case

        } while (opcioMenu != 0);

    }
}
