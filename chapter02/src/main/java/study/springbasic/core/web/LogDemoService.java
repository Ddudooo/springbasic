package study.springbasic.core.web;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Service;
import study.springbasic.core.common.MyLogger;

@Service
@RequiredArgsConstructor
public class LogDemoService {

	private final ObjectProvider<MyLogger> loggerProvider;

	public void logic(String id) {
		MyLogger logger = loggerProvider.getObject();
		logger.log("service id = " + id);
	}
}