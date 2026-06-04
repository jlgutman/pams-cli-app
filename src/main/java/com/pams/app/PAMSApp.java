package com.pams.app;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.pams.dto.PatientDTO;
import com.pams.service.PatientService;
import com.pams.service.PatientServiceImpl;

import java.util.List;

public class PAMSApp {

    public static void main(String[] args) {
        PatientService service = new PatientServiceImpl();
        List<PatientDTO> patients = service.getAllPatientsSortedByAgeDesc();

        Gson gson = new GsonBuilder().setPrettyPrinting().serializeNulls().create();
        System.out.println(gson.toJson(patients));
    }
}
