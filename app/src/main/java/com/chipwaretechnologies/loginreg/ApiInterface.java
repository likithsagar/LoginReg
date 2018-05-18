package com.chipwaretechnologies.loginreg;



import java.util.List;
import java.util.concurrent.ScheduledExecutorService;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;


/**
 * Created by likit on 5/8/2018.
 */

public interface ApiInterface {

    @FormUrlEncoded
    @POST("registration_api")
    Call<ServerResponse> operation(@Field("username_reg") String username,
                                   @Field("password_reg") String password,
                                   @Field("access_id_reg") String accessid,
                                   @Field("security_question_reg") String securityq,
                                   @Field("answer_reg") String answer);

    @FormUrlEncoded
    @POST("login_api")
    Call<ServerResponse> performUserLogin(@Field("username") String userName,
                                          @Field("password") String userPass);


    @FormUrlEncoded
    @POST("timesheet_emp_api")
    Call<List<User>> fetchDetails(@Field("username") String userName,
                                  @Field("password") String userPass);
}
