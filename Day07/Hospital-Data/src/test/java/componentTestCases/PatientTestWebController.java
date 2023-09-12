package componentTestCases;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.veera.app.Controller.PatientController;
import com.veera.app.model.Patient;
import org.junit.Test;
import org.junit.runner.RunWith;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.web.bind.annotation.PostMapping;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest({PatientController.class})
@ActiveProfiles(value = "test")
public class PatientTestWebController {

    @Autowired
    MockMvc mockMvc;

    @Value("${patient.create.url}")
    String createurl;

    @Value("${patient.read.url}")
    String readurl;

    @Value("${patient.update.url}")
    String updateurl;

    @Value("${patient.delete.url}")
    String deleteurl;

    @Test
    public void test_web_addpatient() throws Exception{
        Patient patient=new Patient("abc",123,"prime","kukatpally");
        ResultActions resultActions= mockMvc.perform(post(createurl).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(patient)).accept(MediaType.APPLICATION_JSON));
        resultActions.andExpect(status().isOk());
        String result_string=resultActions.andReturn().getResponse().getContentAsString();
        assertNotNull(result_string);
        Gson g = new Gson();
       Patient result = g.fromJson(result_string, Patient.class);
        assertEquals("abc", result.getPatientname());
        assertEquals(123, result.getPatientid());
        assertEquals("holi", result.getHospitalname());
        assertEquals("yyy", result.getDisease());
    }

    @Test
    public void test_web_getpatient() throws Exception {
        Patient patient=new Patient("abc",123,"prime","kukatpally");
        ResultActions resultActions_create= mockMvc.perform(post(createurl).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(patient)).accept(MediaType.APPLICATION_JSON));
        resultActions_create.andExpect(status().isOk());
        ResultActions resultActions=mockMvc.perform(get("/read").param("patientname","abc").accept(MediaType.APPLICATION_JSON));
        resultActions.andExpect(status().isOk());
        String result_string=resultActions.andReturn().getResponse().getContentAsString();
        assertNotNull(result_string);
        Gson g = new Gson();
        Patient result = g.fromJson(result_string, Patient.class);
        assertEquals("abc", result.getPatientname());
        assertEquals(123, result.getPatientid());
        assertEquals("holi", result.getHospitalname());
        assertEquals("yyy", result.getDisease());
    }

    @Test
    public void test_web_updatepatient() throws Exception{
        Patient patient=new Patient("abc",123,"prime","yyy");
        ResultActions resultActions_create= mockMvc.perform(post(createurl).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(patient)).accept(MediaType.APPLICATION_JSON));
        resultActions_create.andExpect(status().isOk());
        ResultActions resultActions=mockMvc.perform(put("/update")
                .param("patientname","abc")
                .param("patientid","123")
                .param("hospitalname","holi")
                .param("disease","yyy")
                .accept(MediaType.APPLICATION_JSON));
        resultActions.andExpect(status().isOk());
        String result_string=resultActions.andReturn().getResponse().getContentAsString();
        assertNotNull(result_string);
        Gson g = new Gson();
        Patient result = g.fromJson(result_string, Patient.class);
        assertEquals("abc", result.getPatientname());
        assertEquals(123, result.getPatientid());
        assertEquals("holi", result.getHospitalname());
        assertEquals("yyy", result.getDisease());
    }

    public void test_web_deletepatient() throws Exception{
        Patient patient=new Patient("abc",123,"prime","yyy");
        ResultActions resultActions_create= mockMvc.perform(post(createurl).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(patient)).accept(MediaType.APPLICATION_JSON));
        resultActions_create.andExpect(status().isOk());
        ResultActions resultActions=mockMvc.perform(delete("/delete")
                .param("patientname","abc")
                .accept(MediaType.APPLICATION_JSON));
        resultActions.andExpect(status().isOk());
        String result_string=resultActions.andReturn().getResponse().getContentAsString();
        assertNotNull(result_string);
        Gson g = new Gson();
        Patient result = g.fromJson(result_string, Patient.class);
        assertEquals("abc", result.getPatientname());
        assertEquals(123, result.getPatientid());
        assertEquals("holi", result.getHospitalname());
        assertEquals("yyy", result.getDisease());
    }


    private String asJsonString(final Object obj) {
        try {
            final ObjectMapper mapper = new ObjectMapper();
            final String jsonContent = mapper.writeValueAsString(obj);
            return jsonContent;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}
