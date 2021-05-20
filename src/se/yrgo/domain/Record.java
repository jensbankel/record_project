package se.yrgo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/*
 * @author Alexander Gabay
 * */

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




	@Override
	public String toString() {
		return "Record [artist=" + artist + ", title=" + title + ", genre=" + genre + ", barCode=" + barCode + "]";
	}
	
	
	
	
	

}
