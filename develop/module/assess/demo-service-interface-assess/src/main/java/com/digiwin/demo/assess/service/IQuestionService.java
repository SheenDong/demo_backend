package com.digiwin.demo.assess.service;

import com.digiwin.app.service.AllowAnonymous;
import com.digiwin.app.service.DWService;
import com.digiwin.app.service.DWServiceResult;
import com.digiwin.app.service.restful.DWRequestMapping;
import com.digiwin.app.service.restful.DWRequestMethod;
import com.digiwin.demo.assess.pojo.Question;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author sheen.dong
 * @since 2022/5/30 15:25
 */
public interface IQuestionService extends DWService {

    @AllowAnonymous
    DWServiceResult get(String id);

    // 问题确认
    @AllowAnonymous
    DWServiceResult post(@RequestBody Question question);
}