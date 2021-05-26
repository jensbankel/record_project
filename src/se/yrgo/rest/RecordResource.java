package se.yrgo.rest;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.sql.rowset.serial.SerialException;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import se.yrgo.dataaccess.RecordsNotFoundException;
import se.yrgo.domain.Record;
import se.yrgo.service.RecordManagementServiceLocal;

/**
 * 
 * @author Jens Bankel
 * @author Naoya Irkikura
 * @author Alexander Gabay
 * 
 * The class provides a layer for communicating with external clients
 * 
 * */


@Stateless
@Path("/records")
public class RecordResource {

	@Inject
	private RecordManagementServiceLocal service;
	
	/**
	 * Takes a record passing it along to be registered in the database
	 * 
	 * @param Takes a record object to be registered
	 * @return Returns the registered record 
	 */
	@POST
	@Produces("application/JSON")
	@Consumes("application/JSON")
	public Record createRecord(Record record) {
	    service.registerRecord(record);
	    return record;
	}
	/**
	 * Find a record by use of ID
	 * 
	 * @param ID to the record to be found
	 * @return A response object indicating success or failure of query
	 */
	@GET 
	@Produces("application/JSON")
	@Path("{recordNo}")
	public Response findRecordById(@PathParam("recordNo")int id) {
		try {
			Record result = service.getById(id);
			return Response.ok(result).build();
		} catch (RecordsNotFoundException e) {
			return Response.status(404).build();
		}
	}

	/**
	 * Search for records by providing a parameter
	 * 
	 * @param artist 
	 * @param title
	 * @param genre 
	 * @param barCode
	 * @return A response object indicating success or failure of query
	 */
	@GET
	@Produces("application/JSON")
	public Response retrieveData(@QueryParam("artist")String artist, 
	                             @QueryParam("title")String title, 
	                             @QueryParam("genre")String genre, 
	                             @QueryParam("barCode")String barCode) {
		String choice = null;
		if(artist == null && title == null && genre == null && barCode == null) {
			choice = "all"; 
		} else if (artist != null && title == null && genre == null && barCode == null) {
			choice = "artist";
		} else if (artist == null && title != null && genre == null && barCode == null) {
			choice = "title";
		} else if (artist == null && title == null && genre != null && barCode == null) {
			choice = "genre";
		} else if (artist == null && title == null && genre == null && barCode != null) {
			choice = "barCode";
		}
		
		List<Record> result;
		try {
			switch(choice) {

			case "all":  
				result = service.getAllRecords();
				return Response.ok(result).build();
			case "artist":
				result = service.searchByArtist(artist);
				return Response.ok(result).build();

			case "title": 
				result = service.searchByTitle(title);
				return Response.ok(result).build();
			case "genre":
				result = service.searchByGenre(genre);
				return Response.ok(result).build();
			case "barCode":
				result = service.searchByBarCode(barCode);
				return Response.ok(result).build();
			default: return Response.status(400).build();

			}

		} catch (RecordsNotFoundException e) {
			return Response.status(404).build();
		}
		
	}
	
	/**
	 * Updates a record
	 * 
	 * @param id for the record to be updated
	 * @param r object for the record to be updated
	 * @return A response object indicating success or failure of query
	 */
	@PUT
	@Path("{recordNo}")
	@Produces("application/JSON")
	@Consumes("application/JSON")
	public Response updateRecord(@PathParam("recordNo") int id, Record r) {
	    try {
            service.updateRecord(id, r.getTitle(), r.getArtist(), r.getGenre(), r.getBarCode());
            return Response.ok(service.getById(id)).build();
        } catch (RecordsNotFoundException e) {
            return Response.status(404).build();
        }
	}
	
	/**
	 * Deletes a record 
	 * 
	 * @param id of record to be deleted
	 * @return A response object indicating success or failure of query
	 */
	@DELETE
	@Path("{recordNo}")
	public Response deleteRecord(@PathParam("recordNo") int id) {
	    try {
            service.deleteRecord(id);
            return Response.status(204).build();
        } catch (RecordsNotFoundException e) {
            return Response.status(404).build();
        }
	}

}
