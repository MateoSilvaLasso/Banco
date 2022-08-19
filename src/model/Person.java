package model;

public class Person {
    private int turn;

    private int count;
    private Person next;
    private Person previous;

    public Person(int turn) {
        this.turn = turn;
        this.count=0;
    }

    public int getTurn() {
        return turn;
    }

    public void setTurn(int turn) {
        this.turn = turn;
    }

    public Person getNext() {
        return next;
    }

    public void setNext(Person next) {
        this.next = next;
    }

    public Person getPrevious() {
        return previous;
    }

    public void setPrevious(Person previous) {
        this.previous = previous;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
