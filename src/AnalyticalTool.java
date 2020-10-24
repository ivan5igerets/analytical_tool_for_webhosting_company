import java.util.ArrayList;
import java.util.List;

public class AnalyticalTool {

    private List<Request_C> requests = new ArrayList<>();

    public AnalyticalTool(String input) {
        String[] requestsArray = input.split("\n");

        this.arrayProcessing(requestsArray);
    }

    private void arrayProcessing(String[] array) {
        // нулевой элемент массива - это число строк
        for (int i = 1; i < array.length; ++i) {
            this.typeDefinition(array[i]);
        }
    }

    private void typeDefinition(String line) {
        boolean timeLine = false;

        if (line.contains("D") && line.contains("-")) {
            line = line.replace('-', ' ');
            timeLine = true;
        }

        String[] requestParams = line.split(" ");

        if (requestParams[0].equals("C")) {
            // сократить код
            Request_C request = new Request_C(requestParams[0], requestParams[1], requestParams[2],
                    requestParams[3], requestParams[4], requestParams[5]);

            requests.add(request);
        } else {
            String auxiliaryVariable;

            if (timeLine) {
                 auxiliaryVariable = requestParams[5];
            } else {
                auxiliaryVariable = requestParams[4];
            }

            new Request_D(requestParams[0], requestParams[1], requestParams[2],
                    requestParams[3], timeLine, requestParams[4], auxiliaryVariable).analytical(requests);
        }
    }





    public static void main(String[] args) {

        String input = "7\n" +
                "C 1.1 8.15.1 P 15.10.2012 83\n" +
                "C 1 10.1 P 01.12.2012 65\n" +
                "C 1.1 5.5.1 P 01.11.2012 117\n" +
                "D 1.1 8 P 01.01.2012-01.12.2012\n" +
                "C 3 10.2 N 02.10.2012 100\n" +
                "D 1 * P 8.10.2012-20.11.2012\n" +
                "D 3 10 P 01.12.2012";

        AnalyticalTool analyticalTool = new AnalyticalTool(input);
    }

}
