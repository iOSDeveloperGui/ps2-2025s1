package ps2.lab07;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Musics{
    
    //Atributes
    @Id @GeneratedValue
    private Long id; 
    private String title;
    private String composer;
    private int year;
    
    //Main Constructor
    public Musics(String title, String composer, int year){
        this.title = title;
        this.composer = composer;
        this.year = year; 
    }

    //Getters
    public String getTitle(){
        return this.title;
    }

    public String getcomposer(){
        return this.composer;
    }

    public int getYear(){
        return this.year;
    }

    //Setters
    public void setTitle(String title){
        this.title = title;
    }
    
    public void setComposer(String composer){
        this.composer = composer;
    }

    public void setYear(int year){
        this.year = year; 
    }
}