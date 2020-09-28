/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.cinema.model;

import edu.eci.arsw.cinema.persistence.CinemaException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author cristian
 */
public class CinemaFunction {
    
    private Movie movie;
    private List<List<Boolean>> seats = new ArrayList<>();
    private String date;
    
    public CinemaFunction(){}
    public CinemaFunction(Movie movie, String date){
        this.movie=movie;
        this.date=date;
        List<List<Boolean>> seats = new ArrayList<>();
        for (int i=0;i<7;i++){
            List<Boolean> row= new ArrayList<>(Arrays.asList(new Boolean[12]));
            for(int j=0;j<12;j++){
                row.set(j,true);
            }
            seats.add(row);
        }
        this.seats = seats;

    }
    public CinemaFunction(Movie movie, String date,List<List<Boolean>> seats){
        this.movie=movie;
        this.date=date;
        for (int i=0;i<7;i++){
            List<Boolean> row= new ArrayList<>(Arrays.asList(new Boolean[12]));
            for(int j=0;j<12;j++){
                row.set(j,true);
            }
            seats.add(row);
        }
        this.seats = seats;

    }
    
    public void buyTicket(int row,int col) throws CinemaException{
        if (seats.get(row).get(col).equals(true)){
            seats.get(row).set(col,Boolean.FALSE);
        }
        else{
            throw new CinemaException("Seat booked");
        }
    }
    
    public List<List<Boolean>> getSeats() {
        return this.seats;
    }
    
    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int movieAvailability(){
        int availability = 0;
        for (List<Boolean> lists : this.getSeats()) {
            for (Boolean b:lists) {
                if(b){
                    availability++;
                }
            }
        }
        return availability;
    }

    public void setSeats(List<List<Boolean>> seats) {
        this.seats = seats;
    }
}
