// 학과: 컴퓨터공학전공
// 학번: 202334757
// 이름: 조은성

package project.project2;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class JsonMenuLoader implements MenuLoader {
  @Override
  public List<MenuItem> loadMenu() throws LoadMenuException {
    List<MenuItem> menu = new ArrayList<>();
    JSONParser parser = new JSONParser();

    try (BufferedReader br = new BufferedReader(new FileReader("menu.json"))) {
      JSONObject json = (JSONObject) parser.parse(br);
      JSONArray menuItems = (JSONArray) json.get("menu");

      for (Object obj : menuItems) {
        JSONObject menuItemNode = (JSONObject) obj;
        String name = (String) menuItemNode.get("name");
        int price = (int) (long) menuItemNode.get("price");

        MenuItem menuItem = new MenuItem(name, price);
        List<Option> options = new ArrayList<>();

        JSONArray optionsArray = (JSONArray) menuItemNode.get("options");
        for (Object optionObj : optionsArray) {
          JSONObject optionNode = (JSONObject) optionObj;
          String optionName = (String) optionNode.get("name");
          int optionPrice = (int) (long) optionNode.get("price");
          options.add(new Option(optionName, optionPrice));
        }

        menuItem.setOptions(options);
        menu.add(menuItem);
      }
    } catch (IOException e) {
      throw new LoadMenuException("파일을 읽는 중 오류가 발생했습니다: " + e.getMessage());
    } catch (ParseException e) {
      throw new LoadMenuException("JSON 파싱 중 오류가 발생했습니다: " + e.getMessage());
    }

    return menu;
  }
}
