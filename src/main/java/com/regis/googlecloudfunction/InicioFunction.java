package com.regis.googlecloudfunction;

import com.google.cloud.functions.Context;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.regis.googlecloudfunction.model.Cliente;
import com.regis.googlecloudfunction.model.LocalDateAdapter;
import com.regis.googlecloudfunction.model.PubSubMessage;
import com.google.cloud.functions.BackgroundFunction;

import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.Base64;

public class InicioFunction implements BackgroundFunction<PubSubMessage> {

    @Override
    public void accept(PubSubMessage pubSubMessage, Context context) throws Exception {
        Cliente cliente = getEvento(pubSubMessage);
        // chamar o service passando o cliente como parametro
    }

    private Cliente getEvento(PubSubMessage pubSubMessage) {
        String messageString = new String(Base64.getDecoder().decode(pubSubMessage.getData().getBytes(StandardCharsets.UTF_8)), StandardCharsets.UTF_8);
        String messageStringFormatada = "" + messageString + "";
        Cliente cliente = new Cliente();

        try {
            Gson gson = new GsonBuilder()
                    .setPrettyPrinting()
                    .registerTypeAdapter(LocalDate.class, new LocalDateAdapter())
                    .create();
            cliente = gson.fromJson(messageStringFormatada, Cliente.class);

        } catch (JsonSyntaxException e) {
            throw new JsonSyntaxException("erro ao converter mensagem", e);
        }

        return cliente;
    }

}
