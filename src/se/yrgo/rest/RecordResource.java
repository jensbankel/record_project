package se.yrgo.rest;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import se.yrgo.domain.Record;
import se.yrgo.service.RecordManagementService;

/*
 * @author Alexander Gabay
 * */


@Stateless
@Path("/records")
public class RecordResource {

		@GET
		@Produces("application/JSON")
		public List<Record> getAllRecords() {
			return service.getAllRecords();
		}
		
		@Inject
		private RecordManagementService service;
}
