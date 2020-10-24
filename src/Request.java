import java.util.Arrays;

public abstract class Request {

    private String type, response;
    private char[] services, questions;

    public Request(String type, String services, String questions, String response) {
        this.type = type;
        this.services = fromStringToCharArray(services);
        this.questions = fromStringToCharArray(questions);
        this.response = response;
    }

    public char[] fromStringToCharArray(String line) {
        String[] srtArr = line.split("\\.");
        char[] intArr = new char[srtArr.length];

        for (int i = 0; i < srtArr.length; ++i) {
            intArr[i] = srtArr[i].charAt(0);
        }
        return intArr;
    }

    public String getType() {
        return type;
    }

    public String getResponse() {
        return response;
    }

    public char[] getServices() {
        return services;
    }

    public char[] getQuestions() {
        return questions;
    }

    @Override
    public String toString() {
        return "type='" + type + '\'' +
                ", services=" + Arrays.toString(services) +
                ", questions=" + Arrays.toString(questions) +
                ", response='" + response + '\'';

    }
}
