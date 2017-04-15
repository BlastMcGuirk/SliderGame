package com.BGuirks.apps.Slider.saves;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.Base64Coder;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonWriter;
import com.badlogic.gdx.utils.ObjectMap;

public class SaveManager {

    private FileHandle file;
    private boolean encoded;
    private Save save;

    public SaveManager(boolean encoded, String fileName){
        this.encoded = encoded;
        file = Gdx.files.local("bin/" + fileName + ".json");
        save = getSave();
    }

    private Save getSave(){
        Save save = new Save();

        if (file.exists()){
            Json json = new Json();
            if (encoded) save = json.fromJson(Save.class, Base64Coder.decodeString(file.readString()));
            else save = json.fromJson(Save.class, file.readString());
        }
        return save;
    }

    public boolean isEmpty(){
        if (save.data.size == 0)
            return true;
        return false;
    }

    public void saveToJson(){
        Json json = new Json();
        json.setOutputType(JsonWriter.OutputType.json);
        if (encoded) file.writeString(Base64Coder.encodeString(json.prettyPrint(save)), false);
        else file.writeString(json.prettyPrint(save), false);
    }

    @SuppressWarnings("unchecked")
    public String loadDataValue(String key){
        if (save.data.containsKey(key))return save.data.get(key);
        else return null;
    }

    public void saveDataValue(String key, String info){
        save.data.put(key, info);
        saveToJson();
    }

    public static class Save{
        public ObjectMap<String, String> data = new ObjectMap<String, String>();
    }

}
