package se.yrgo.service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import se.yrgo.domain.Record;

@Stateless
public class RecordManagementServiceImplementation implements RecordManagementService {


	public void registerRecord(Record record) {
		// TODO Auto-generated method stub

	}

	public List<Record> getAllRecords() {

		Record rec1 = new Record("Abba", "Collected", "Pop", "0600753337776");
		Record rec2 = new Record("Charlie Parker", "Bird in LA", "Jazz", "0602507408459");
		Record rec3 = new Record("Nirvana", "Nevermind", "Rock", "0720642442517");
		List<Record> records = new ArrayList<Record>();
		records.add(rec1);
		records.add(rec2);
		records.add(rec3);
		return records;
	}


	public List<Record> searchByArtist(String artist) {
		// TODO Auto-generated method stub
		return null;
	}

}
