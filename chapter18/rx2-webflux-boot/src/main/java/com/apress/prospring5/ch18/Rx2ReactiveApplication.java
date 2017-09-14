package com.apress.prospring5.ch18;

import com.apress.prospring5.ch18.entities.Singer;
import com.apress.prospring5.ch18.repos.Rx2SingerRepo;
import io.reactivex.Flowable;
import io.reactivex.Single;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

/**
 * Created by iuliana.cosmina on 7/16/17.
 */
@SpringBootApplication
@RestController
public class Rx2ReactiveApplication {

	private static Logger logger = LoggerFactory.getLogger(Rx2ReactiveApplication.class);

	@Bean WebClient client() {
		return WebClient.create("http://localhost:8080");
	}

	@Autowired Rx2SingerRepo rx2SingerRepo;

	@GetMapping(value = "/all", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flowable<Singer> all() {
		Flowable<Singer> singers = rx2SingerRepo.findAll();
		Flowable<Long> periodFlowable = Flowable.interval(2, TimeUnit.SECONDS);
		return singers.zipWith(periodFlowable, (singer, aLong) -> {
			Thread.sleep(aLong);
			return singer;
		});
	}

	@GetMapping(value = "/one/{id}")
	public Single<Singer> one(@PathVariable Long id) {
		return rx2SingerRepo.findById(id);
	}

	public static void main(String... args) throws Exception {
		ConfigurableApplicationContext ctx = new SpringApplicationBuilder(Rx2ReactiveApplication.class)
				.properties(
						new HashMap<String, Object>() {{
							put("server.port", "8080");
							put("spring.jpa.hibernate.ddl-auto", "create-drop");
						}}
				).run(args);
		assert (ctx != null);
		logger.info("Application started...");

/*		WebClient client = ctx.getBean(WebClient.class);

		client.get().uri("/one/1")
				.accept(MediaType.TEXT_EVENT_STREAM)
				.exchange().subscribe(cr -> {
			logger.info("Client RQ: " + cr.toString());
		});*/

		/*URI oneURI = new URI("http://localhost:8080/one/1");
		HttpClient client = HttpClient
				            .newBuilder()
				          .build();
		
		HttpRequest httpRequest = HttpRequest.newBuilder().GET().build();
		HttpResponse httpResponse = client.send(httpRequest, HttpResponse.BodyHandler.asString());

		System.out.println(httpResponse.statusCode());
		System.out.println(httpResponse.body());*/
		System.in.read();
		ctx.close();
	}

	@Bean CommandLineRunner clr(WebClient client) {
		return args -> {
			client.get().uri("/all")
					.accept(MediaType.TEXT_EVENT_STREAM)
					.exchange()
					.flatMapMany(cr -> cr.bodyToFlux(Singer.class)).subscribe(System.out::println);
		};
	}
}
