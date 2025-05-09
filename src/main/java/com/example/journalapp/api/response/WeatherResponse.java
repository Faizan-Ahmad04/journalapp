package com.example.journalapp.api.response;


// import com.fasterxml.jackson.databind.ObjectMapper; // version 2.11.1
// import com.fasterxml.jackson.annotation.JsonProperty; // version 2.11.1
/* ObjectMapper om = new ObjectMapper();
Root root = om.readValue(myJsonString, Root.class); */


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WeatherResponse {
    public Current current;

    @Getter
    @Setter
    public class Current {

        @JsonProperty("observation_time")
        public String observation_time;
        public int temperature;
        public int wind_degree;
        public int humidity;
        @JsonProperty("is_day")
        public String is_day;
        public int feelslike;
    }

}
