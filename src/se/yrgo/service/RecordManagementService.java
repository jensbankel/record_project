package se.yrgo.service;

/**
 * 
 * @author Jens Bankel
 * @author Naoya Irkikura
 * @author Alexander Gabay
 * 
 * Interface defining a blueprint for communicating with classes directly in 
 * contact with external clients
 * 
 * */
import java.util.List;

import javax.ejb.Remote;

import se.yrgo.dataaccess.RecordsNotFoundException;
import se.yrgo.domain.Record;

@Remote
public interface RecordManagementService {
	
	public void registerRecord(Record record);
	public List<Record>getAllRecords ();
	public List<Record>searchByArtist(String artist) throws RecordsNotFoundException;
	public List<Record>searchByTitle(String title) throws RecordsNotFoundException;
	public List<Record>searchByGenre(String genre) throws RecordsNotFoundException;
	public List<Record>searchByBarCode(String barCode) throws RecordsNotFoundException;
    public void updateRecord(int id, String title, String artist, String genre, String barCode)
            throws RecordsNotFoundException;
    public void deleteRecord(int id) throws RecordsNotFoundException;

}


