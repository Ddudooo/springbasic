package study.springbasic.core.web;

import javax.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import study.springbasic.core.common.MyLogger;

@Controller
@RequiredArgsConstructor
public class LogDemoController {

	private final LogDemoService logDemoService;
	private final ObjectProvider<MyLogger> loggerProvider;

	@ResponseBody
	@RequestMapping("log-demo")
	public ResponseEntity<String> logDemo(HttpServletRequest request) {
		MyLogger logger = loggerProvider.getObject();
		String requestURL = request.getRequestURL().toString();
		logger.setRequestUrl(requestURL);

		logger.log("controller test");
		logDemoService.logic("test Id");
		return ResponseEntity.status(HttpStatus.OK.value()).body("ok");
	}
}