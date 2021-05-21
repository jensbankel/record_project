package se.yrgo.dataaccess;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;

import se.yrgo.domain.Record;

@Stateless
@Alternative
public class RecordDataAccessTestingVersion implements RecordDataAccess {

    @Override
    public void insert(Record newRecord) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public List<Record> findAll() {
        Record r1 = new Record("Janne", "musik", "pop", "1212121");
        Record r2 = new Record("Bosse", "mucia", "rock", "223233");
        Record r3 = new Record("Bosson", "magi", "jazz", "242422");
        List<Record> records = new ArrayList<Record>();
        records.add(r3);
        records.add(r2);
        records.add(r1);
        Record r33 = new Record("B45sson", "magiskt", "jazz", "242422");
        records.add(r33);
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

	@Override
	public Record findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
    
}
