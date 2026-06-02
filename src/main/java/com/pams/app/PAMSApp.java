package com.pams.app;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.pams.model.Patient;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Comparator;

public class PAMSApp {

    public static void main(String[] args) {
        Patient[] patients = {
            new Patient(1, "Daniel",  "Agar",       "(641) 123-0009", "dagar@m.as",      "1 N Street",        LocalDate.of(1987, 1, 19)),
            new Patient(2, "Ana",     "Smith",       null,             "amsith@te.edu",    null,                LocalDate.of(1948, 12, 5)),
            new Patient(3, "Marcus",  "Garvey",      "(123) 292-0018", null,               "4 East Ave",        LocalDate.of(2001, 9, 18)),
            new Patient(4, "Jeff",    "Goldbloom",   "(999) 165-1192", "jgold@es.co.za",  null,                LocalDate.of(1995, 2, 28)),
            new Patient(5, "Mary",    "Washington",  null,             null,               "30 W Burlington",   LocalDate.of(1932, 5, 31))
        };

        Arrays.sort(patients, Comparator.comparingInt(Patient::getAge).reversed());

        Gson gson = new GsonBuilder().setPrettyPrinting().serializeNulls().create();
        DateTimeFormatter dobFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        JsonObject root = new JsonObject();
        com.google.gson.JsonArray jsonArray = new com.google.gson.JsonArray();

        for (Patient p : patients) {
            JsonObject obj = new JsonObject();
            obj.addProperty("id", p.getId());
            obj.addProperty("firstName", p.getFirstName());
            obj.addProperty("lastName", p.getLastName());
            obj.addProperty("phoneNumber", p.getPhoneNumber());
            obj.addProperty("email", p.getEmail());
            obj.addProperty("mailingAddress", p.getMailingAddress());
            obj.addProperty("dateOfBirth", p.getDateOfBirth().format(dobFormatter));
            obj.addProperty("age", p.getAge());
            jsonArray.add(obj);
        }

        root.add("patients", jsonArray);
        System.out.println(gson.toJson(root));
    }
}
