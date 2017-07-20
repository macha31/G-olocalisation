package fr.app.geolocalisation;

import com.google.api.client.http.GenericUrl;
import com.google.api.client.json.gson.GsonFactory;
import com.octo.android.robospice.request.googlehttpclient.GoogleHttpClientSpiceRequest;

import java.io.IOException;

import roboguice.util.temp.Ln;

/**
 * Created by M.C on 13/07/2017.
 */

public class ForecastWeatherRequest extends GoogleHttpClientSpiceRequest<ForecastWeatherModel> {

    private String baseUrl;

    public ForecastWeatherRequest(double latitude, double longitude, String apiKey){
        super( ForecastWeatherModel.class);
        this.baseUrl = String.format("http://api.openweathermap.org/data/2.5/forecast?lat="+latitude+"&lon="+longitude+"&appid="+apiKey+"&lang=fr");

    }

    @Override
    public ForecastWeatherModel loadDataFromNetwork() throws Exception{
       Ln.d("Call web service" + baseUrl);
        ForecastWeatherModel request = getHttpRequestFactory()
                .buildGetRequest(new GenericUrl(baseUrl))
                .setParser(new GsonFactory().createJsonObjectParser())
                .execute()
                .parseAs(getResultType());
        return request;
    }

}
