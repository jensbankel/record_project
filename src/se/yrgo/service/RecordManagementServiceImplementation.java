package se.yrgo.service;

import java.util.ArrayList;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import se.yrgo.dataaccess.RecordDataAccess;
import se.yrgo.dataaccess.RecordsNotFoundException;
import se.yrgo.domain.Record;

/**
 * 
 * @author Jens Bankel
 * @author Naoya Irkikura
 * @author Alexander Gabay
 * 
 * The class provides a service layer for separating classes communicating with
 * external clients and classes communicating with the database
 * 
 * */

@Stateless
public class RecordManagementServiceImplementation 
    implements RecordManagementService, RecordManagementServiceLocal {

    @Inject
    private RecordDataAccess dao;

    @Override
	public void registerRecord(Record record) {
		dao.insert(record); 
	}

	@Override
	public List<Record> getAllRecords() {
		return dao.findAll();
	}

	@Override
	public List<Record> searchByArtist(String artist) 
	        throws RecordsNotFoundException {
		return dao.findByArtist(artist);
	}
	
    @Override
    public List<Record> searchByTitle(String title) 
            throws RecordsNotFoundException {
        return dao.findByTitle(title);
    }
    @Override
    public List<Record> searchByGenre(String genre) 
            throws RecordsNotFoundException {
    	return dao.findByGenre(genre);
    }
    @Override
    public List<Record> searchByBarCode(String barCode) 
            throws RecordsNotFoundException {
    	return dao.findByBarCode(barCode);
    }

	@Override
	public Record getById(int id) 
	        throws RecordsNotFoundException {
		return dao.findById(id);
	}
	
	@Override
	public void updateRecord(int id, String title, String artist, String genre, String barCode) 
	        throws RecordsNotFoundException {
	    dao.updateRecord(id, title, artist, genre, barCode);
	}
	
    @Override
	public void deleteRecord(int id) 
	        throws RecordsNotFoundException {
	    dao.deleteRecord(id);
	}
}