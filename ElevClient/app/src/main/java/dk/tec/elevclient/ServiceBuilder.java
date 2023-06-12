package dk.tec.elevclient;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceBuilder
{
    // 10.0.2.2
    private static final String URL = "http://10.131.203.231:8080/MyWebApi/api/";
    private static Retrofit retrofit = new Retrofit.Builder().baseUrl(URL)
            .addConverterFactory(GsonConverterFactory.create()).build();

    public static <S> S buildService(Class<S> serviceType)
    {
        return retrofit.create(serviceType);
    }
}
