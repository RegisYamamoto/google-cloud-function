package com.regis.googlecloudfunction.model;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LocalDateAdapter extends TypeAdapter<LocalDate> {

    @Override
    public void write(JsonWriter jsonWriter, LocalDate localDate) throws IOException {
        if (localDate != null) {
            jsonWriter.value(DateTimeFormatter.ISO_DATE.format(localDate));
        } else {
            jsonWriter.nullValue();
        }
    }

    @Override
    public LocalDate read(JsonReader jsonReader) throws IOException {
        try {
            return LocalDate.parse(jsonReader.nextString());
        } catch (IllegalStateException e) {
            jsonReader.nextNull();
            return null;
        }
    }

}
