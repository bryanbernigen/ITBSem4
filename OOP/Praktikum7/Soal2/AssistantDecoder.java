package Soal2;

import java.lang.reflect.*;

public class AssistantDecoder {

    Assistant assistant;

    AssistantDecoder(Assistant assistant) {
        this.assistant = assistant;
    }

    public void addPersonToRecommendations(String name) throws Exception {
        Class assistantClass = assistant.getClass();
        Method method = assistantClass.getDeclaredMethod("addPersonToRecommendations", String.class);
        method.setAccessible(true);
        method.invoke(assistant, name);
    }

    public int getSalary() throws Exception {
        Class assistantClass = assistant.getClass();
        Field field = assistantClass.getDeclaredField("salary");
        field.setAccessible(true);
        return field.getInt(assistant);
    }
}
