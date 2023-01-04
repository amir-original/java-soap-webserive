import com.keysoft.soapwebserivce.Application;
import com.keysoft.soapwebserivce.ApplicationSOAPService;
import com.keysoft.soapwebserivce.generated.ApplicationServiceSoap;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ApplicationClientShould {

    @Test
    void get_all() throws MalformedURLException {
        URL wsdURL = new URL("http://localhost:8080/soap-webserivce-1.0-SNAPSHOT/ApplicationServiceSOAP?wsdl");
        QName qualifiedName = new QName("http://soapwebserivce.keysoft.com/","ApplicationServiceSOAP");

        Service service = Service.create(wsdURL, qualifiedName);
        ApplicationSOAPService appService = service.getPort(ApplicationSOAPService.class);

        System.out.println(appService.getAll());

        List<Application> applications = appService.getAll();
        Optional<Application> first = applications.stream().filter(app -> app.getId() == 1).findFirst();

        assertEquals(getTrackzilla(), first.get());

    }

    @Test
    void get_by_id() {
        ApplicationServiceSoap serviceSoap = new ApplicationServiceSoap();

        ApplicationSOAPService proxy = serviceSoap.getApplicationServicePort();

        assertEquals(getTrackzilla(),proxy.getApplication(1));
    }

    private static Application getTrackzilla() {
        return new Application(1, "Trackzilla", "A bug tracking application");
    }
}
