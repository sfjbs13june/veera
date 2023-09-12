package com.veera.app.componenttest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.veera.app.controller.HospitalController;
import com.veera.app.model.Hospital;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest({HospitalController.class})
@ActiveProfiles(value = "test")
public class HospitalTestWebController {

    @Autowired
    MockMvc mockMvc;

    @Value("${hospital.create.url}")
    String createurl;

    @Value("${hospital.read.url}")
    String readurl;

    @Value("${hospital.update.url}")
    String updateurl;

    @Value("${hospital.delete.url}")
    String deleteurl;

    @Test
    public void test_web_addhospital() throws Exception{
        Hospital hospital=new Hospital("prime","12345","kukatpally");
        ResultActions resultActions = mockMvc.perform(post(createurl).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(hospital)).accept(MediaType.APPLICATION_JSON));
        resultActions.andExpect(status().isOk());
        String result_string=resultActions.andReturn().getResponse().getContentAsString();
        assertNotNull(result_string);
        Gson g = new Gson();
        Hospital result = g.fromJson(result_string, Hospital.class);
        assertEquals("prime", result.getHospitalname());
        assertEquals("12345", result.getHospitalid());
        assertEquals("kukatpally", result.getAddress());
    }

    @Test
    public void test_web_getpatient() throws Exception{
        Hospital hospital=new Hospital("prime","12345","kukatpally");
        ResultActions resultActions_create = mockMvc.perform(post(createurl).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(hospital)).accept(MediaType.APPLICATION_JSON));
        resultActions_create.andExpect(status().isOk());
        ResultActions resultActions=mockMvc.perform(get("/readHos").param("hospitalname","prime").accept(MediaType.APPLICATION_JSON));
        resultActions.andExpect(status().isOk());
        String result_string=resultActions.andReturn().getResponse().getContentAsString();
        assertNotNull(result_string);
        Gson g = new Gson();
        Hospital result = g.fromJson(result_string, Hospital.class);
        assertEquals("prime", result.getHospitalname());
        assertEquals("12345", result.getHospitalid());
        assertEquals("kukatpally", result.getAddress());

    }

    @Test
    public void test_web_updatepatient() throws Exception{
        Hospital hospital=new Hospital("prime","12345","kukatpally");
        ResultActions resultActions_create= mockMvc.perform(post(createurl).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(hospital)).accept(MediaType.APPLICATION_JSON));
        resultActions_create.andExpect(status().isOk());
        ResultActions resultActions=mockMvc.perform(put("/updateHos")
                .param("hospitalname","prime")
                .param("hospitalid","12345")
                .param("address","Punjagutta")
                .accept(MediaType.APPLICATION_JSON));
        resultActions.andExpect(status().isOk());
        String result_string=resultActions.andReturn().getResponse().getContentAsString();
        assertNotNull(result_string);
        Gson g = new Gson();
        Hospital result = g.fromJson(result_string, Hospital.class);
        assertEquals("prime", result.getHospitalname());
        assertEquals("12345", result.getHospitalid());
        assertEquals("Punjagutta", result.getAddress());
    }

    public void test_web_deletepatient() throws Exception{
        Hospital hospital=new Hospital("prime","12345","kukatpally");
        ResultActions resultActions_create= mockMvc.perform(post(createurl).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(hospital)).accept(MediaType.APPLICATION_JSON));
        resultActions_create.andExpect(status().isOk());
        ResultActions resultActions=mockMvc.perform(delete("/delete")
                .param("hospitalname","prime")
                .accept(MediaType.APPLICATION_JSON));
        resultActions.andExpect(status().isOk());
        String result_string=resultActions.andReturn().getResponse().getContentAsString();
        assertNotNull(result_string);
        Gson g = new Gson();
        Hospital result = g.fromJson(result_string, Hospital.class);
        assertEquals("prime", result.getHospitalname());
        assertEquals("12345", result.getHospitalid());
        assertEquals("Punjagutta", result.getAddress());
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
