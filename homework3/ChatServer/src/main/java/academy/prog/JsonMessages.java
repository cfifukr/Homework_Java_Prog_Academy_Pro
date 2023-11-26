package academy.prog;

import java.util.ArrayList;
import java.util.List;

public class JsonMessages {
    private final List<Message> list = new ArrayList<>();

    public JsonMessages(List<Message> sourceList, int fromIndex, String user) {
        for (int i = fromIndex; i < sourceList.size(); i++){
            Message mes = sourceList.get(i);
            if (mes.getTo().compareTo(user) == 0){
                list.add(mes);
            }
            if (mes.getTo().compareTo("ALL") == 0){
                list.add(mes);
            }

        }
    }

    public JsonMessages(List<Message> sourceList, int fromIndex) {
        for (int i = fromIndex; i < sourceList.size(); i++){
            Message mes = (Message) sourceList.get(i);
            list.add(mes);

        }
    }
}
