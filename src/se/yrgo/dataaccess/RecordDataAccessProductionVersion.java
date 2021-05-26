package se.yrgo.dataaccess;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import se.yrgo.domain.Record;

/**
 * 
 * @author Jens Bankel
 * @author Naoya Irkikura
 * @author Alexander Gabay
 * 
 * The implementation of the interface RecordDataAccess and defining how the 
 * methods shall function 
 *
 * 
 */

@Stateless
@Default
public class RecordDataAccessProductionVersion implements RecordDataAccess {
	
	@PersistenceContext
	private EntityManager em;

	/**
	 * Adds a Record 
	 * 
	 * @param The Record to be added
	 */
	@Override
	public void insert(Record newRecord) {
		em.persist(newRecord);

	}
    /**
     * List all records in the database
     * 
     * @return a list of all records in the database 
     * 
     */
	@Override
	public List<Record> findAll() {
		Query q = em.createQuery("select record from Record record");
		List<Record> records = q.getResultList();
		return records;
	}

	/**
	 * Find records of an artist
	 * 
	 * @param The artist you want to find 
	 * @return A list containing the records matching the query
	 */
	@Override
	public List<Record> findByArtist(String artist) throws RecordsNotFoundException{
		Query q = em.createQuery("select record from Record record "
		                        + "where LOWER(record.artist) = LOWER(:artist)");
		q.setParameter("artist", artist);
		return q.getResultList();
	}
	
	 /**
	  * Find record by title
	  * 
     * @param The title you want to find
     * @return A list containing the records matching the query
     */
	@Override
	public List<Record> findByTitle(String title) throws RecordsNotFoundException{
		Query q = em.createQuery("select record from Record record "
		                        + "where LOWER(record.title) = LOWER(:title)");
		q.setParameter("title", title);
		return q.getResultList();
	}
	
    /**
     * Find a record by ID
     * 
     * @param The ID you want to find 
     * @return A list containing the records matching the query
     */	
	@Override
	public Record findById(int id) throws RecordsNotFoundException {
		Query q = em.createQuery("select record from Record record "
		                        + "where record.id = :id");
		q.setParameter("id", id);
		try {
			return (Record)q.getSingleResult();
		} catch (NoResultException e) {
			throw new RecordsNotFoundException();
		}
	}

    /**
     * List records by genre
     * 
     * @param The genre you want to look-up 
     * @return A list containing the records matching the query
     */ 
	@Override
	public List<Record> findByGenre(String genre) throws RecordsNotFoundException{
		Query q = em.createQuery("select record from Record record "
		                        + "where LOWER(record.genre) = LOWER(:genre)");
		q.setParameter("genre", genre);
		return q.getResultList();
	}

    /**
     * Find a record by barcode
     * 
     * @param The barcode of the record you want to find 
     * @return A list containing the records matching the query
     */ 	
	@Override
	public List<Record> findByBarCode(String barCode) throws RecordsNotFoundException{
		Query q = em.createQuery("select record from Record record "
		                        + "where record.barCode = :barCode");
		q.setParameter("barCode", barCode);
		return q.getResultList();
	}
	
    /**
     * This updates a record. the record is chosen by ID and the other parameters
     * given will update the changes you want to implement
     * 
     * @param The ID, title, artist, genre, barcode. 
     * 
     */ 
    @Override
	public void updateRecord(int id, String title, String artist, String genre,
	        String barCode) throws RecordsNotFoundException {
        Record record = findById(id);
        record.setTitle(title);
        record.setArtist(artist);
        record.setGenre(genre);
        record.setBarCode(barCode);
    }
    
    /**
     * This deletes a record
     * 
     * @param The ID of the record to be deleted
     */ 
    @Override
    public void deleteRecord(int id) throws RecordsNotFoundException {
        Record r = findById(id);
        em.remove(r);
    }

}
