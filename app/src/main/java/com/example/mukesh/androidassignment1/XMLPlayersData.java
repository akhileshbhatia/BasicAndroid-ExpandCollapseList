package com.example.mukesh.androidassignment1;

import android.content.Context;
import android.provider.DocumentsContract;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class XMLPlayersData {
    private Context context;
    public Players[] players;

    public XMLPlayersData(Context context){
        this.context = context;

        InputStream stream = this.context.getResources().openRawResource(R.raw.players);
        DocumentBuilder builder = null;
        Document document = null;
        try{
            builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            document = builder.parse(stream);
        }
        catch (Exception e){
         System.out.println("Exception in reading the document "+e.getMessage());
        }
        //extracting data and creating players item
        NodeList nameList = document.getElementsByTagName("name");
        NodeList countryList = document.getElementsByTagName("country");
        NodeList rankingList = document.getElementsByTagName("world-ranking");
        NodeList detailsList = document.getElementsByTagName("details");
        NodeList imageList = document.getElementsByTagName("image");
        NodeList urlList = document.getElementsByTagName("url");

        players = new Players[nameList.getLength()];

        for(int i=0; i<players.length; i++){
            String name = nameList.item(i).getFirstChild().getNodeValue();
            String country = countryList.item(i).getFirstChild().getNodeValue();
            int ranking = Integer.parseInt(rankingList.item(i).getFirstChild().getNodeValue());
            String completeInfo = detailsList.item(i).getFirstChild().getNodeValue().replace("\n","").trim();
            String shortInfo = completeInfo.substring(0,350) + "...";
            String image = imageList.item(i).getFirstChild().getNodeValue();
            String url = urlList.item(i).getFirstChild().getNodeValue();

            Players p = new Players(name,country,ranking,shortInfo,completeInfo,image,url);

            players[i] = p;
        }

    }

    public Players getPlayersData(int i){
        return players[i];
    }

    public String [] getNames(){

        String [] names = new String[players.length];
        for(int i = 0;i<players.length;i++){

            names[i] = players[i].getName();

        }
        return names;
    }
}
