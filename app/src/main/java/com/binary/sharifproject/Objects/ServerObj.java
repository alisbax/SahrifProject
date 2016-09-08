package com.binary.sharifproject.Objects;

import com.google.gson.JsonObject;

/**
 * Created by R.Miri on 5/23/2016.
 */

public class ServerObj {
    JsonObject data = new JsonObject();
    String message;
    int status;

    public JsonObject getData() {
        return data;
    }

    public String getMessage() {
        return message;
    }

    public int getStatus() {
        return status;
    }
}

