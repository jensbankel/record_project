package se.yrgo.service;

/**
 * 
 * @author Jens Bankel
 * @author Naoya Irkikura
 * @author Alexander Gabay
 * 
 * Interface defining a blueprint for communicating with classes directly in 
 * contact with a database
 * 
 * */

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Remote;

import se.yrgo.dataaccess.RecordsNotFoundException;
import se.yrgo.domain.Record;

@Local
public interface RecordManagementServiceLocal {
	
	public void registerRecord(Record record);
	public List<Record>getAllRecords ();
	public List<Record>searchByArtist(String artist) throws RecordsNotFoundException;
	public List<Record>searchByTitle(String title) throws RecordsNotFoundException;
	public List<Record>searchByGenre(String genre) throws RecordsNotFoundException;
	public List<Record>searchByBarCode(String barCode) throws RecordsNotFoundException;
	public Record getById(int id) throws RecordsNotFoundException;
	public void updateRecord(int id, String title, String artist, String genre, String barCode)
            throws RecordsNotFoundException;
	public void deleteRecord(int id) throws RecordsNotFoundException;

}


