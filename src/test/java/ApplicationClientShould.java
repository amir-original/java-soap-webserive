import com.keysoft.soapwebserivce.Application;
import com.keysoft.soapwebserivce.ApplicationSOAPService;
import com.keysoft.soapwebserivce.generated.ApplicationServiceSoap;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ApplicationClientShould {

    private static final int FACEID_APP_ID = 400;
    private ApplicationSOAPService servicePort;

    @BeforeEach
    void setUp() {
        ApplicationServiceSoap serviceSoap = new ApplicationServiceSoap();
        servicePort = serviceSoap.getApplicationServicePort();
    }

    @Test
    void get_all() {

        System.out.println(servicePort.getAll());

        List<Application> applications = servicePort.getAll();
        Optional<Application> first = applications.stream().filter(app -> app.getId() == 1).findFirst();

        assertEquals(getTrackzilla(), first.get());

    }

    @Test
    void get_by_id() {
        ApplicationSOAPService proxy = servicePort;

        assertEquals(getTrackzilla(), proxy.getApplication(1));
    }

    @Test
    void return_true_when_add_application_for_first_times() {
        Application app = new Application(FACEID_APP_ID, "FaceId",
                "keep users face to authorizing");

        assertTrue(servicePort.addApplication(app));
    }

    @Test
    void update_application() {
        Application app = new Application(FACEID_APP_ID, "update: FaceId",
                "update: keep users face to authorizing");
        boolean result = servicePort.updateApplication(app);
        assertTrue(result);
    }

    @Test
    void delete_application() {
        assertTrue(servicePort.delete(FACEID_APP_ID));
    }

    private static Application getTrackzilla() {
        return new Application(1, "Trackzilla", "A bug tracking application");
    }
}
