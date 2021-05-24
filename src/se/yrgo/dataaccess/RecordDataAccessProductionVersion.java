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
		Query q = em.createQuery("select record from Record record where record.artist = :artist");
		q.setParameter("artist", artist);
		return q.getResultList();
	}

	@Override
	public List<Record> findByTitle(String title) throws RecordsNotFoundException{
		Query q = em.createQuery("select record from Record record where record.title = :title");
		q.setParameter("title", title);
		return q.getResultList();
	}

	@Override
	public Record findById(int id) throws RecordsNotFoundException {
		Query q = em.createQuery("select record from Record record where record.id = :id");
		q.setParameter("id", id);
		
		try {
			return (Record)q.getSingleResult();
		} catch (NoResultException e) {
			throw new RecordsNotFoundException();
		}
	}

	@Override
	public List<Record> findByGenre(String genre) throws RecordsNotFoundException{
		Query q = em.createQuery("select record from Record record where record.genre = :genre");
		q.setParameter("genre", genre);
		return q.getResultList();
	}

	@Override
	public List<Record> findByBarCode(String barCode) throws RecordsNotFoundException{
		Query q = em.createQuery("select record from Record record where record.barCode = :barCode");
		q.setParameter("barCode", barCode);
		return q.getResultList();
	}

}
