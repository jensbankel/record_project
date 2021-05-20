package se.yrgo.dataaccess;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;

import se.yrgo.domain.Record;

/**
 * 
 * @author naoyairikura
 *
 */

@Stateless
@Default
public class RecordDataAccessProductionVersion implements RecordDataAccess {

	@Override
	public void insert(Record newRecord) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Record> findAll() {
		Record r1 = new Record("Eva", "A Song", "Pop", "0123456789");
		Record r2 = new Record("Adam", "B Song", "Pop", "1234567890");
		List<Record> records = new ArrayList<Record>();
		records.add(r1);
		records.add(r2);
		
		return records;
	}

	@Override
	public List<Record> findByArtist(String artist) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Record> findByTitle(String title) {
		// TODO Auto-generated method stub
		return null;
	}

}
