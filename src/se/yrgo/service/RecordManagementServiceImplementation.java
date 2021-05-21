package se.yrgo.service;

import java.util.ArrayList;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import se.yrgo.dataaccess.RecordDataAccess;
import se.yrgo.domain.Record;

/**
 * 
 * @author Alexander Gabay
 *
 */

@Stateless
public class RecordManagementServiceImplementation implements RecordManagementService, RecordManagementServiceLocal {

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
	public List<Record> searchByArtist(String artist) {
		return dao.findByArtist(artist);
	}
	
    @Override
    public List<Record> searchByTitle(String title) {
        return dao.findByTitle(title);
    }
}