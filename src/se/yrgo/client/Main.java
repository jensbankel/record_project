package se.yrgo.client;

import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import se.yrgo.domain.Record;
import se.yrgo.service.RecordManagementService;
import se.yrgo.service.RecordManagementServiceImplementation;

public class Main {

    public static void main(String[] args) throws NamingException {
        Properties jndiProperties = new Properties();
        jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY, 
                "org.jboss.naming.remote.client.InitialContextFactory");
        jndiProperties.put(Context.PROVIDER_URL,"http-remoting://localhost:8080"); 
        jndiProperties.put("jboss.naming.client.ejb.context",true);
        
        Context jndi = new InitialContext(jndiProperties);
        
        RecordManagementService service = 
                (RecordManagementService)jndi.lookup("RecordManagementServerApplication/"
                        + "RecordManagementServiceImplementation!se.yrgo.service."
                        + "RecordManagementService");
        
        Record rec1 = new Record("Abba", "Collected", "Pop", "0600753337776");
		Record rec2 = new Record("Charlie Parker", "Bird in LA", "Jazz", "0602507408459");
		Record rec3 = new Record("Nirvana", "Nevermind", "Rock", "0720642442517");
		
		
		//Regitrerar employeeer i databasen!
		service.registerRecord(rec1);
		service.registerRecord(rec2);
		service.registerRecord(rec3);

        List<Record> records = service.getAllRecords();
        for (Record r : records) {
            System.out.println(r);
        }
    }

}
