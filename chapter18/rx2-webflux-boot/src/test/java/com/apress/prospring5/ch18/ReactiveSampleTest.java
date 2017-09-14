package com.apress.prospring5.ch18;

import io.reactivex.Flowable;
import org.junit.jupiter.api.Test;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Flow;
import java.util.concurrent.SubmissionPublisher;

import static java.lang.Thread.sleep;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

/**
 * Created by iuliana.cosmina on 8/5/17.
 */
public class ReactiveSampleTest {
	private final Logger logger = LoggerFactory.getLogger(ReactiveSampleTest.class);

	@Test
	public void flowableTest(){
		List<String> elements = new ArrayList<>();
		Flowable.just("hope", "sadness", "smile", "tear", "grin", "cry", "laugh").subscribe(
				new Subscriber<>() {

					private Subscription sub;
					int onNextAmount;

					@Override public void onSubscribe(Subscription s) {
						s.request(Long.MAX_VALUE);
						this.sub = s;
					}

					@Override public void onNext(String s) {
						String tmp = s.toUpperCase();
						elements.add(tmp);
						onNextAmount++;
						if (onNextAmount % 2 == 0) {
							sub.request(2);
						}
					}

					@Override public void onError(Throwable t) {
						logger.error("Unexpected issue!", t);
						fail("This Flux test failed!");
					}

					@Override public void onComplete() {
						logger.info("All done!");
						elements.forEach(logger::info);
						assertTrue(elements.size() == 7);
					}
				});
	}

	@Test
	public void  java9Streams() throws InterruptedException {
		List<String> elements = new ArrayList<>();
		final List<String> sample = List.of("hope", "sadness", "smile", "tear", "grin", "cry", "laugh");
		SubmissionPublisher<String> publisher = new SubmissionPublisher<>();
		publisher.subscribe(new Flow.Subscriber<>() {
			private Flow.Subscription sub;
			int onNextAmount;

			@Override public void onSubscribe(Flow.Subscription subscription) {
				subscription.request(Long.MAX_VALUE);
				this.sub = subscription;
			}

			@Override public void onNext(String s) {
				String tmp = s.toUpperCase();
				elements.add(tmp);
				onNextAmount++;
				if (onNextAmount % 2 == 0) {
					sub.request(2);
				}
			}

			@Override public void onError(Throwable t) {
				logger.error("Unexpected issue!", t);
				fail("This Flux test failed!");
			}

			@Override public void onComplete() {
				logger.info("All done!");
				elements.forEach(logger::info);
				assertTrue(elements.size() == 7);
			}
		});

		Thread t = new Thread(() -> {
			for (int i = 1; i < sample.size(); i++) {
				publisher.submit(sample.get(i));
				try {
					sleep(i);
				} catch (InterruptedException e) {
				}
			}

			// Close the publisher
			publisher.close();
		});
		t.start();
		t.join();
	}
}
