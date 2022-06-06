package com.estg.mtsds.TicketHistory.model;

public class Seat {

    private String letter;
    private int number;

    public Seat(String letter, int number) {
        this.letter = letter;
        this.number = number;
    }

    public String getLetter() {
        return letter;
    }

    public void setLetter(String letter) {
        this.letter = letter;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Seat{" +
                "letter='" + letter + '\'' +
                ", number=" + number +
                '}';
    }

}
