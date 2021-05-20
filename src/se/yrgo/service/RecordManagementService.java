package se.yrgo.service;

/*
 * @author Alexander Gabay
 * */

import java.util.List;

import javax.ejb.Remote;

import se.yrgo.domain.Record;

@Remote
public interface RecordManagementService {
	
	public void registerRecord(Record record);
	public List<Record>getAllRecords ();
	public List<Record>searchByArtist(String artist);
	//jmlb
	public List<Record>searchByTitle(String title);

}


