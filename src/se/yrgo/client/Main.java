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

        List<Record> records = service.getAllRecords();
        for (Record r : records) {
            System.out.println(r);
        }
    }

}
