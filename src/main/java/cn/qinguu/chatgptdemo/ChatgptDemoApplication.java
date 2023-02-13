package cn.qinguu.chatgptdemo;

import com.theokanning.openai.OpenAiService;
import com.theokanning.openai.completion.CompletionRequest;
import in.zhaoj.v2ray.V2RayApiClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ChatgptDemoApplication {

    public static void main(String[] args) {
//        System.setProperty("proxyHost","127.0.0.1");
//        System.setProperty("proxyPort","10809");
        SpringApplication.run(ChatgptDemoApplication.class, args);
//        OpenAiService service = new OpenAiService("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", 20);
//        CompletionRequest completionRequest = CompletionRequest.builder()
//                .prompt("### MySQL SQL tables, with their properties:\n" +
//                        "#\n" +
//                        "# gm_wg_info(wg_code, wg_name,is_delete)\n" +
//                        "# gm_w_wg_info(w_wg_code, w_wg_name,is_delete)\n" +
//                        "# gm_wg_wwg_ref(id, wg_code, w_wg_code)\n" +
//                        "#\n" +
//                        "### 请写出sql统计每个未删除的网格下有多少未删除的微网格，查询结果带上网格编码和网格名称\n" +
//                        "SELECT ")
//                .model("code-davinci-002")
//                .echo(true)
//                .temperature(0.6D)
//                .maxTokens(300)
//                .build();
//        service.createCompletion(completionRequest).getChoices().forEach(System.out::println);
    }


}
