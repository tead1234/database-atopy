package com.example.test;


import com.slack.api.app_backend.interactive_components.ActionResponseSender;
import com.slack.api.app_backend.interactive_components.payload.BlockActionPayload;
import com.slack.api.app_backend.interactive_components.response.ActionResponse;
import com.slack.api.model.block.LayoutBlock;
import com.slack.api.model.block.composition.OptionObject;
import com.slack.api.model.block.composition.PlainTextObject;
import com.slack.api.model.block.composition.TextObject;
import com.slack.api.util.json.GsonFactory;
import okhttp3.Response;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.slack.api.Slack;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.slack.api.model.Attachments.asList;
import static com.slack.api.model.block.Blocks.*;
import static com.slack.api.model.block.composition.BlockCompositions.markdownText;
import static com.slack.api.model.block.composition.BlockCompositions.plainText;
import static com.slack.api.model.block.element.BlockElements.*;
import static com.slack.api.webhook.WebhookPayloads.payload;

@RestController
public class mainController {
    Slack slack = Slack.getInstance();
    public void send() throws IOException {

        List<String> arr = new ArrayList<>(asList("민수 1", "미선 1", "석훈 2"));
        List<LayoutBlock> layoutBlocks = new ArrayList<>();
        List<TextObject> textObjects = new ArrayList<>();

        arr.forEach(a -> {
            textObjects.add(
                    new PlainTextObject(
                            a.split(" ")[0],
                            true
                    )
            );
        });
// 텍스트를 남길 SectionBlock 입니다.
        layoutBlocks.add(section(section -> section.text(markdownText("서버현황표."))));
        layoutBlocks.add(section(section ->
                section.fields(
                                textObjects
                        )
                )
        );


// Action과 텍스트를 구분하기 위한 Divider 입니다.
        layoutBlocks.add(divider());
        List<OptionObject> textArr = new ArrayList<>();
        OptionObject option = new OptionObject();
        option.setText(new PlainTextObject(
                        "74서버",
                        true
                ));
        textArr.add(
                option
    );
// ActionBlock에 승인 버튼과 거부 버튼을 추가 하였습니다.
        layoutBlocks.add(
                actions(actions -> actions
                        .elements(asElements(
                                button(b -> b.text(plainText(pt -> pt.emoji(true).text("승인")))
                                        .value("1")
                                        .style("primary")
                                        .actionId("action_approve")
                                ),
                                staticSelect(
                                        select -> select.actionId("get_message")
                                                .options(
                                                            textArr
                                                        )
                                                )
                                )
                                )
                        )
        );

        slack.send(
                "https://hooks.slack.com/services/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",
                payload(p -> p
                        .text("슬랙에 메시지를 출력하지 못했습니다.")
                        .blocks(layoutBlocks)
                )
        );
    }

    @RequestMapping(value = "/messgage", method = {RequestMethod.POST}, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public void approve(@RequestParam String payload) throws IOException {

        BlockActionPayload blockActionPayload =
                GsonFactory.createSnakeCase()
                        .fromJson(payload, BlockActionPayload.class);
        System.out.println(blockActionPayload);
        ActionResponse response =
                ActionResponse.builder()
                        .replaceOriginal(true)
                        .blocks(blockActionPayload.getMessage().getBlocks())
                        .build();
        ActionResponseSender sender = new ActionResponseSender(slack);
        sender.send(blockActionPayload.getResponseUrl(), response);
    }
}
