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
        
        Record record1 = new Record("Abba", "Collected", "Pop", "0600753337776");
        Record record2 = new Record("Charlie Parker", "Bird in LA", "Jazz", "0602507408459");
        Record record3 = new Record("Nirvana", "Nevermind", "Rock", "0720642442517");
        Record record4 = new Record("Carola", "Blott en dag", "Pop", "0044001660023");
        Record record5 = new Record("Arvingarna", "I do", "Pop", "0190759527627");
        Record record6 = new Record("Madonna", "Like A Virgin", "Pop", "0603497849284");
        Record record7 = new Record("Sun Ra", "Lanquidity", "Jazz", "4062548021080");
        Record record8 = new Record("Dropkick Murphys", "Turn up the dial", "Punk", "5400863049126");
        Record record9 = new Record("Nattskiftet", "Stämplar in", "Electronic", " 7393210769311");
        
        service.registerRecord(record1);
        service.registerRecord(record2);
        service.registerRecord(record3);
        service.registerRecord(record4);
        service.registerRecord(record5);
        service.registerRecord(record6);
        service.registerRecord(record7);
        service.registerRecord(record8);
        service.registerRecord(record9);

        List<Record> records = service.getAllRecords();
        for (Record r : records) {
            System.out.println(r);
        }
    }

}
