package com.example.nimmy.jsontask4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    private  String strJson ="\n" +
            "{\n" +
            "    \"glossary\": {\n" +
            "        \"title\": \"example glossary\",\n" +
            "\t\t\"GlossDiv\": {\n" +
            "            \"title\": \"S\",\n" +
            "\t\t\t\"GlossList\": {\n" +
            "                \"GlossEntry\": {\n" +
            "                    \"ID\": \"SGML\",\n" +
            "\t\t\t\t\t\"SortAs\": \"SGML\",\n" +
            "\t\t\t\t\t\"GlossTerm\": \"Standard Generalized Markup Language\",\n" +
            "\t\t\t\t\t\"Acronym\": \"SGML\",\n" +
            "\t\t\t\t\t\"Abbrev\": \"ISO 8879:1986\",\n" +
            "\t\t\t\t\t\"GlossDef\": {\n" +
            "                        \"para\": \"A meta-markup language, used to create markup languages such as DocBook.\",\n" +
            "\t\t\t\t\t\t\"GlossSeeAlso\": [\"GML\", \"XML\"]\n" +
            "                    },\n" +
            "\t\t\t\t\t\"GlossSee\": \"markup\"\n" +
            "                }\n" +
            "            }\n" +
            "        }\n" +
            "    }\n" +
            "}";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            JSONObject jsonRootObject = new JSONObject(strJson);
            JSONObject glossaryObject = jsonRootObject.getJSONObject("glossary");
            //JSONObject titleObject = glossaryObject.getJSONObject("title");
            String title = glossaryObject.getString("title");
            Log.d("tag", "onCreate: "+title);
            JSONObject GlossDivObject = glossaryObject.getJSONObject("GlossDiv");
            String title1 = GlossDivObject.getString("title");
            Log.d("tag", "onCreate: "+title1);
            JSONObject GlossListObject = GlossDivObject.getJSONObject("GlossList");
            JSONObject GlossEntryObject = GlossListObject.getJSONObject("GlossEntry");
            String ID = GlossEntryObject.getString("ID");
            Log.d("tag", "onCreate: "+ID);
            String SortAs = GlossEntryObject.getString("SortAs");
            Log.d("tag", "onCreate: "+SortAs);
            String GlossTerm = GlossEntryObject.getString("GlossTerm");
            Log.d("tag", "onCreate: "+GlossTerm);
            String Acronym = GlossEntryObject.getString("Acronym");
            Log.d("tag", "onCreate: "+Acronym);
            String Abbrev = GlossEntryObject.getString("Abbrev");
            Log.d("tag", "onCreate: "+Abbrev);
            JSONObject GlossDefObject = GlossEntryObject.getJSONObject("GlossDef");
            String para = GlossDefObject.getString("para");
            Log.d("tag", "onCreate: "+para);
            JSONArray jsonArray = GlossDefObject.getJSONArray("GlossSeeAlso");
            for (int i = 0; i <jsonArray.length() ; i++) {
//                String GlossSeeAlso = jsonArray.getString(Integer.parseInt("GlossDef")).toString();
                String GlossSeeAlso="\n"+jsonArray.getString(i);
                Log.d("tag", "onCreate: "+GlossSeeAlso);
            }
            String GlossSee = GlossEntryObject.getString("GlossSee");
            Log.d("tag","Gloss See:"+GlossSee);

            glossaryObject.get("Glossary");

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}
