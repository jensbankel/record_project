package se.yrgo.dataaccess;

import java.util.List;

import javax.ejb.Local;

import se.yrgo.domain.Record;

/**
 * 
 * @author Jens Bankel
 * @author Naoya Irkikura
 * @author Alexander Gabay
 * 
 * Interface to provide a blueprint for talking to the database
 *
 */

@Local
public interface RecordDataAccess {
    public void insert(Record newRecord);
    public List<Record> findAll();
    public List<Record> findByArtist(String artist) throws RecordsNotFoundException;
    public List<Record> findByTitle(String title) throws RecordsNotFoundException;
    public Record findById(int id) throws RecordsNotFoundException;
    public List<Record> findByGenre(String genre) throws RecordsNotFoundException;
	public List<Record> findByBarCode(String barCode) throws RecordsNotFoundException;
    public void updateRecord(int id, String title, String artist, String genre, String barCode)
            throws RecordsNotFoundException;
    public void deleteRecord(int id) throws RecordsNotFoundException;
	
	

}
