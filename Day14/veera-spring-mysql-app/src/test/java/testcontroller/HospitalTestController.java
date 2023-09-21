package testcontroller;

import com.veera.app.veeraspringmysqlapp.controller.HospitalController;
import com.veera.app.veeraspringmysqlapp.model.Hospital;
import com.veera.app.veeraspringmysqlapp.repository.HospitalRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class HospitalTestController {


    @InjectMocks
    HospitalController hospitalController;

    @Mock
    HospitalRepository hospitalRepository;

    @Test
    public void getHospitalTest() {
        Hospital hospital = new Hospital(101, "hospital01", "address1");
        when(hospitalRepository.getHospital(anyString())).thenReturn(hospital);

    }

}
