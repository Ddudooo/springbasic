package study.springbasic.core.common;

import java.util.UUID;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class MyLogger {

	private String uuid;
	private String requestUrl;

	public void setRequestUrl(String requestUrl) {
		this.requestUrl = requestUrl;
	}

	public void log(String message) {
		System.out.printf("[%s] [%s] : %s\n", uuid, requestUrl, message);
	}

	@PostConstruct
	public void init() {
		this.uuid = UUID.randomUUID().toString();
		System.out.printf("[%s] request scope bean created : %s\n", uuid, this);
	}

	@PreDestroy
	public void close() {
		System.out.printf("[%s] request scope bean close : %s\n", uuid, this);
	}
}