package se.yrgo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 
 * @author Jens Bankel
 * @author Naoya Irkikura
 * @author Alexander Gabay
 * 
 * The class represents a record object. 
 *
 */

@Entity
public class Record implements java.io.Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String artist;
	private String title;
	private String genre;
	private String barCode;
	
	public Record() {};
	
	public Record(String artist, String title, String genre, String barCode) {
		this.artist = artist;
		this.title = title;
		this.genre = genre;
		this.barCode = barCode;
	}
	
	public int getId() {
        return id;
    }

	public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
	public String toString() {
		return "Record [artist=" + artist + ", title=" + title + ", "
		        + "genre=" + genre + ", barCode=" + barCode + "]";
	}
	
	
	
	
	

}
