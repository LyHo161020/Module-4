package service;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DictionaryService implements IDictionaryService{
    @Autowired
   private Map<String,String> dictionary;

    @Override
    public void getDictionary() {
        dictionary = new HashMap<>();
        dictionary.put("book","quyển vở");
        dictionary.put("serch","tìm kiếm");
        dictionary.put("library","thư viện");
        dictionary.put("red","màu đỏ");
    }

    @Override
    public String findDictionary(String name) {
//            List<String> translated = new ArrayList<>(dictionary.values());
//            for (String word : translated){
//                if(word.equals(name)){
//                    return word;
//                }
//            }

        for (Map.Entry<String, String> item : dictionary.entrySet()) {
            if(item.getKey().equals(name)){
                return item.getValue();
            }
        }
        return null;
    }
}
