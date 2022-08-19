package model;

public class Bancolombia {

    private Person head;



    private Person actual;

    public Bancolombia() {

    }

    public void print(){
        print(head);
    }

    private void print(Person current){
        if(current==head.getPrevious()){
            System.out.println(current.getTurn()+" pasadas "+ current.getCount()+" ");
            return;
        }

        System.out.println(current.getTurn()+" pasadas "+ current.getCount()+" ");
        print(current.getNext());
    }

    public void giveTurn(int cont){
        Person current= new Person(cont);
        if(head==null){
            head=current;
            head.setNext(current);
            head.setPrevious(current);
            actual=head;
            return;
        }

        Person tail= head.getPrevious();
        tail.setNext(current);
        current.setNext(head);
        head.setPrevious(current);
        current.setPrevious(tail);
        return;

    }

    public Person showTurn(){
        if(head==null){
            return null;
        }

        return actual;

    }

    public void nextTurn(){
        actual.setCount(actual.getCount()+1);
        Person current=actual;
        if(actual.getCount()==3){
            Person adelante= current.getPrevious();
            Person atras= current.getNext();
            adelante.setNext(atras);
            atras.setPrevious(adelante);

            if(current==head){
                Person s= head;
                head= s.getNext();

            }

            if(current==head && (head.getNext()==head || head.getNext()==null)){
                head=null;
                return;
            }
        }
        actual=current.getNext();
        return;
    }

    public void deletePerson(){
        deletePerson(head, actual.getTurn());
    }

    private void deletePerson(Person current, int turn){
        if(head==null){
            return;
        }

        if(head.getNext()==head){
            head=null;
        }

        if(current.getTurn()!=turn){
            deletePerson(current.getNext(), turn);
        }

        if(current.getTurn()==turn){
            actual= current.getNext();
            Person adelante= current.getPrevious();
            Person atras= current.getNext();
            adelante.setNext(atras);
            atras.setPrevious(adelante);
            if(current==head){
                head=atras;
            }
            return;
        }

    }


}
