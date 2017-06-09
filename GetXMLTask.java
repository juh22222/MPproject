package com.example.thfad_000.myapplication;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import java.net.URL;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

/**
 * Created by JuheePark on 2017-06-08.
 */

public class GetXMLTask extends AsyncTask<String, Void, Document>{
    Document doc = null;
    private ArrayList<String> villName= new ArrayList<>();
    ReturnData mCallback;
    public GetXMLTask(Context context){
        mCallback = (ReturnData)context;
    }

    @Override
    protected Document doInBackground(String... urls) {

        URL url;
        try {
            url = new URL(urls[0]);
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db;

            db = dbf.newDocumentBuilder();
            doc = db.parse(new InputSource(url.openStream()));
            doc.getDocumentElement().normalize();

        } catch (Exception e) {
            Log.i("실패",e.getMessage());
        }
        return doc;
    }

    @Override
    protected void onPostExecute(Document doc) {
        String s = "";
        NodeList nodeList = doc.getElementsByTagName("row");

        if (nodeList.getLength() != 0) {
            for (int i = 0; i < nodeList.getLength(); i++) {

                s += "" + i + ": 마을 정보: ";
                Node node = nodeList.item(i);
                Element fstElmnt = (Element) node;
                NodeList nameList = fstElmnt.getElementsByTagName("VILL_NM");
                Element nameElement = (Element) nameList.item(0);
                nameList = nameElement.getChildNodes();
                //Log.i("머냐", i + ":"+((Node) nameList.item(0)).getNodeValue());

                villName.add(i,((Node) nameList.item(0)).getNodeValue());

                //s += "마을 이름 = " + ((Node) nameList.item(0)).getNodeValue() + " ,\n";

                /*NodeList websiteList = fstElmnt.getElementsByTagName("wfKor");
                Element websiteElement = (Element) websiteList.item(0);
                websiteList = websiteElement.getChildNodes();
                s += "마을이름 = " + ((Node) websiteList.item(0)).getNodeValue()
                        + "\n";*/
            }
        }

        for(int i=0; i<villName.size(); i++){
            Log.i("villName",i+" : "+villName.get(i));
        }

        if(mCallback!=null)
        {
            mCallback.Returnxml(villName);
        }
    }
}
