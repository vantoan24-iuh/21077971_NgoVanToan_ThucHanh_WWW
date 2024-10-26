package vn.edu.iuh.fit.exercise.frontend.models;

import jakarta.json.*;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.Response;
import vn.edu.iuh.fit.exercise.backend.dots.LoaithuocDto;
import vn.edu.iuh.fit.exercise.backend.dots.ThuocDto;
import vn.edu.iuh.fit.exercise.backend.repositories.entities.Thuoc;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

public class ThuocModel {
    private final String ADD_URL = "http://localhost:8080/Exercise-1.0-SNAPSHOT/api/thuoc";

    public void createThuoc(Thuoc thuoc) {
        try(Client client= ClientBuilder.newClient()){
            WebTarget target = client.target(ADD_URL);

            Response response = target.request().post(Entity.json(thuoc));
            if(response.getStatus() == Response.Status.CREATED.getStatusCode()){
                System.out.println("Thuoc added successfully");
            }else{
                System.out.println("Failed to add thuoc");
            }
            response.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public List<ThuocDto> getALLThuoc() {
        List<ThuocDto> thuocDtos = new ArrayList<>();
        try (Client client = ClientBuilder.newClient()) {
            WebTarget target = client.target(ADD_URL);

            Response response = target.request().accept("application/json").get();

            if (response.getStatus() == Response.Status.OK.getStatusCode()) {
                String jsonResponse = response.readEntity(String.class);
                System.out.println("Response JSON: " + jsonResponse);

                try (JsonReader jsonReader = Json.createReader(new StringReader(jsonResponse))) {
                    JsonArray jsonArray = jsonReader.readArray();
                    for (JsonValue jsonValue : jsonArray) {
                        JsonObject jsonObject = (JsonObject) jsonValue;
                        LoaithuocDto loaithuocDto = new LoaithuocDto(
                                jsonObject.getJsonNumber("maLoai").intValue(),
                                jsonObject.getString("tenLoai")
                        );
                        ThuocDto thuocDto = new ThuocDto(
                                jsonObject.getJsonNumber("id").intValue(),
                                jsonObject.getString("tenThuoc"),
                                jsonObject.getJsonNumber("gia").doubleValue(),
                                jsonObject.getJsonNumber("namSX").intValue(),
                                loaithuocDto
                        );
                        thuocDtos.add(thuocDto);
                    }
                }
            }
        }
        return thuocDtos;
    }
}
