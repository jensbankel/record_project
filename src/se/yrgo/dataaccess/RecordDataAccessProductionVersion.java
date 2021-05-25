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
 * @author naoyairikura
 *
 */

@Stateless
@Default
public class RecordDataAccessProductionVersion implements RecordDataAccess {
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public void insert(Record newRecord) {
		em.persist(newRecord);

	}

	@Override
	public List<Record> findAll() {
		Query q = em.createQuery("select record from Record record");
		List<Record> records = q.getResultList();
		return records;
	}


	@Override
	public List<Record> findByArtist(String artist) throws RecordsNotFoundException{
		Query q = em.createQuery("select record from Record record "
		                        + "where LOWER(record.artist) = LOWER(:artist)");
		q.setParameter("artist", artist);
		return q.getResultList();
	}

	@Override
	public List<Record> findByTitle(String title) throws RecordsNotFoundException{
		Query q = em.createQuery("select record from Record record "
		                        + "where LOWER(record.title) = LOWER(:title)");
		q.setParameter("title", title);
		return q.getResultList();
	}

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

	@Override
	public List<Record> findByGenre(String genre) throws RecordsNotFoundException{
		Query q = em.createQuery("select record from Record record "
		                        + "where LOWER(record.genre) = LOWER(:genre)");
		q.setParameter("genre", genre);
		return q.getResultList();
	}

	@Override
	public List<Record> findByBarCode(String barCode) throws RecordsNotFoundException{
		Query q = em.createQuery("select record from Record record "
		                        + "where record.barCode = :barCode");
		q.setParameter("barCode", barCode);
		return q.getResultList();
	}
	
    @Override
	public void updateRecord(int id, String title, String artist, String genre,
	        String barCode) throws RecordsNotFoundException {
        Record record = findById(id);
        record.setTitle(title);
        record.setArtist(artist);
        record.setGenre(genre);
        record.setBarCode(barCode);
    }
    
    @Override
    public void deleteRecord(int id) throws RecordsNotFoundException {
        Record r = findById(id);
        em.remove(r);
    }

}
