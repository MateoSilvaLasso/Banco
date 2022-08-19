package ui;
import model.Bancolombia;
import java.util.Scanner;
public class BancoMain {
    public Bancolombia banco;

    public int cont;
    public Scanner sc;
    public BancoMain(){
        banco=new Bancolombia();
        sc= new Scanner(System.in);
        cont=1;
    }
    public static void main(String[] args) {
        BancoMain Main= new BancoMain();
        int option=0;
        do{
            option=Main.menu();
            Main.showMenu(option);
        }while(option!=0);
    }

    public int menu(){
        System.out.println("1: give a turn\n"+
                           "2: show actual turn\n"+
                           "3: pass turn\n"+
                           "4: delete actual turn and continue\n"+
                           "0: out");
        int option= sc.nextInt();
        while(option<0 || option>5){
            System.out.println("incorrect option, write again");
            System.out.println("1: give a turn\n"+
                    "2: show actual turn\n"+
                    "3: pass turn\n"+
                    "4: delete actual turn and continue\n"+
                    "0: out");
            option= sc.nextInt();
        }

        return option;
    }

    public void showMenu(int option){
        switch(option){
            case 1:
                giveTurn();
                break;
            case 2:
                if(banco.showTurn()==null){
                    System.out.println("aun no hay turno");
                }else{
                    System.out.println("The actual turn "+ banco.showTurn().getTurn());
                }
                break;
            case 3:
                if(banco.showTurn()==null){
                    System.out.println("aun no hay turno");
                    cont=1;
                }else
                    banco.nextTurn();
                break;
            case 4:
                if(banco.showTurn()==null){
                    System.out.println("aun no hay turno");
                }else
                    banco.deletePerson();
                    System.out.println("Persona atendida"); 
                break;
            case 5:
                banco.print();
                break;
            case 0:
                System.out.println("Bye");
                break;
            default:
                break;
        }
    }

    public void giveTurn(){
        banco.giveTurn(cont);
        cont++;
    }


}
