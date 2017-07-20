package fr.app.geolocalisation;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import pl.droidsonroids.gif.GifTextView;

/**
 * Created by M.C on 17/07/2017.
 */

public class WeatherAdapter extends BaseAdapter {

    private Context mContext;
    private ArrayList<List> mForecastModelList;

    public WeatherAdapter (Context context, ArrayList<List> forecastModelList){
        mContext = context;
        mForecastModelList = forecastModelList;
    }


    @Override
    public int getCount() {
        return mForecastModelList.size();
    }

    @Override
    public Object getItem(int position) {
        return mForecastModelList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null){
            convertView = LayoutInflater.from(mContext).
                    inflate(R.layout.weather_item, parent, false);
        }

        List currentModel = (List)getItem(position);
        double cTemp = currentModel.getMain().getTemp()-273.15;
        String weather = currentModel.getWeather().get(0).getDescription();

        TextView textViewDate = (TextView)convertView.findViewById(R.id.textViewDate);
        TextView textViewTemp = (TextView)convertView.findViewById(R.id.textViewTemp);
        TextView textViewWeather = (TextView)convertView.findViewById(R.id.textViewWeather);
        GifTextView gifTextViewWeather = (GifTextView)convertView.findViewById(R.id.gifTextViewWeather);

        textViewDate.setText(getDate(currentModel.getDt(),"dd/MM/yyyy HH:mm "));
        textViewTemp.setText(String.valueOf((int)(cTemp)+ " Degrès"));
        textViewWeather.setText(currentModel.getWeather().get(0).getDescription());

        switch (weather){
            case ("ciel dégagé"):
                gifTextViewWeather.setBackgroundResource(R.drawable.sun);
                convertView.setBackgroundResource(R.drawable.itemsun);
                break;
            case ("peu nuageux"):
                gifTextViewWeather.setBackgroundResource(R.drawable.suncloud);
                convertView.setBackgroundResource(R.drawable.itemsuncloud);
                break;
            case ("nuageux"):
                gifTextViewWeather.setBackgroundResource(R.drawable.cloud);
                convertView.setBackgroundResource(R.drawable.itemcloud);
                break;
            case ("Pluie"):
                gifTextViewWeather.setBackgroundResource(R.drawable.rain);
                convertView.setBackgroundResource(R.drawable.itemrain);
                break;
            case ("Orageux"):
                gifTextViewWeather.setBackgroundResource(R.drawable.orage);
                convertView.setBackgroundResource(R.drawable.itemorage);
                break;
            default:
                gifTextViewWeather.setBackgroundResource(R.drawable.sun);
        }

        return convertView;
    }

    public static String getDate(long milliSeconds, String dateFormat) {

        SimpleDateFormat formatter = new SimpleDateFormat(dateFormat);

        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(milliSeconds*1000);
        return formatter.format(calendar.getTime());
    }


}
