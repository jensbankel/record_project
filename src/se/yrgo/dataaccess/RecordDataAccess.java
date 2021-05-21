package se.yrgo.dataaccess;

import java.util.List;

import javax.ejb.Local;

import se.yrgo.domain.Record;

/**
 * 
 * @author jmlb
 *
 */

@Local
public interface RecordDataAccess {
    public void insert(Record newRecord);
    public List<Record> findAll();
    public List<Record> findByArtist(String artist);
    public List<Record> findByTitle(String title);
    public Record findById(int id);

}
