package com.chipwaretechnologies.loginreg;

import com.google.gson.annotations.SerializedName;

/**
 * Created by likit on 5/9/2018.
 */

public class ServerResponse {

    @SerializedName("message")
    private String message;



    public String getMessage() {
        return message;
    }

}
