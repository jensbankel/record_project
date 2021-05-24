package se.yrgo.rest;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import se.yrgo.dataaccess.RecordsNotFoundException;
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
	
	@POST
	@Produces("application/JSON")
	@Consumes("application/JSON")
	public Record createRecord(Record record) {
	    service.registerRecord(record);
	    return record;
	}

	@GET
	@Produces("application/JSON")
	public List<Record> getAllRecords() {
		return service.getAllRecords();
	}
	
	@GET
	@Produces("application/JSON")
	public Response findRecordById(@QueryParam("recordNo")int id) {
		try {
			Record result = service.getById(id);
			return Response.ok(result).build();
		} catch (RecordsNotFoundException e) {
			return Response.status(404).build();
			//Meddelande bör visas
		}
	}
	
	@GET
	@Produces("application/JSON")
	public Response findRecordByArtist(@QueryParam("artist")String artist) {
		try {
			List<Record> result = service.searchByArtist(artist);
			return Response.ok(result).build();
		} catch (RecordsNotFoundException e) {
			return Response.status(404).build();
			//Meddelande bör visas
		}
	}
	@GET
	@Produces("application/JSON")
	@Path("{recordTitel}")
	public Response findRecordByTitle(@PathParam("recordTitle")String title) {
		try {
			List<Record> result = service.searchByTitle(title);
			return Response.ok(result).build();
		} catch (RecordsNotFoundException e) {
			return Response.status(404).build();
			//Meddelande bör visas
		}
	}
	@GET
	@Produces("application/JSON")
	@Path("{recordGenre}")
	public Response findRecordByGenre(@PathParam("recordGenre")String genre) {
		try {
			List<Record> result = service.searchByGenre(genre);
			return Response.ok(result).build();
		} catch (RecordsNotFoundException e) {
			return Response.status(404).build();
			//Meddelande bör visas
		}
	}
	@GET
	@Produces("application/JSON")
	@Path("{recordBar}")
	public Response findRecordByBarCode(@PathParam("recordBar")String barCode) {
		try {
			List<Record> result = service.searchByBarCode(barCode);
			return Response.ok(result).build();
		} catch (RecordsNotFoundException e) {
			return Response.status(404).build();
			//Meddelande bör visas
		}
	}

}
