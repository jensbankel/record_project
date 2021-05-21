package se.yrgo.rest;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import se.yrgo.domain.Record;
import se.yrgo.service.RecordManagementServiceLocal;

/*
 * @author Alexander Gabay
 * */


@Stateless
@Path("/records")
public class RecordResource {

	@Inject
	private RecordManagementServiceLocal service;

	@GET
	@Produces("application/JSON")
	public List<Record> getAllRecords() {
		return service.getAllRecords();
	}
	
	@GET
	@Produces("application/JSON")
	@Path("{recordNo}")
	public Record findRecordById(@PathParam("recordNo")int id) {
		return service.getById(id);
	}

}
