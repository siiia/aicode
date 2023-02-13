package cn.qinguu.chatgptdemo.controller;

import com.theokanning.openai.OpenAiService;
import com.theokanning.openai.completion.CompletionChoice;
import com.theokanning.openai.completion.CompletionRequest;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("code")
public class CodeController {
    @PostMapping("sqlGenerate")
    public Map sqlGenerate(@RequestBody Map param) {
        Map<String,Object> result = new HashMap<>();
        List<List<Map>> data = (List<List<Map>>) param.get("data");
        String text = (String) param.get("text");
        System.setProperty("proxyHost", "127.0.0.1");
        System.setProperty("proxyPort", "10809");
        OpenAiService service = new OpenAiService("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", 60);
        StringBuffer table = new StringBuffer("");
        for (int i = 0; i < data.size(); i++) {
            List<Map> line = data.get(i);
            table.append("# "+line.get(0) + "(");
            for (int j = 1; j < line.size(); j++) {
                table.append(line.get(j) + (j == (line.size() - 1) ? ")\n" : ","));
            }
        }
        CompletionRequest completionRequest = CompletionRequest.builder()
                .prompt("### MySQL SQL tables, with their properties:\n" +
                        "#\n" +
                        table +
                        "#\n" +
                        "### " + text + "\n" +
                        "SELECT ")
                .model("code-davinci-002")
                .echo(true).
                maxTokens(1000)
                .temperature(0D)
                .stop(Arrays.asList("#",";") )
                .build();
        List<CompletionChoice> choices = service.createCompletion(completionRequest).getChoices();
        String resultText = choices.get(0).getText();
        result.put("result",resultText.substring(resultText.indexOf("SELECT")));
        return result;
    }
}
