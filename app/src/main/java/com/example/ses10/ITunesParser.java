package com.example.ses10;

import android.content.Context;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ITunesParser {

    public ArrayList<Song> parseJsonToSongs(Context ctx, JSONObject source){
        ArrayList<Song> songs = new ArrayList<>();
        try{
            JSONArray jArrSongs = source.getJSONArray("results");
            for(int i=0;i<jArrSongs.length();i++){
                Song song = new Song();
                song.title = ((JSONObject)jArrSongs.get(i)).getString("trackName");
                song.artist = ((JSONObject)jArrSongs.get(i)).getString("artistName");
                song.url = ((JSONObject)jArrSongs.get(i)).getString("previewUrl");
                songs.add(song);
            }
        }catch(JSONException e){
            e.printStackTrace();
        }
        return songs;
    }
}
