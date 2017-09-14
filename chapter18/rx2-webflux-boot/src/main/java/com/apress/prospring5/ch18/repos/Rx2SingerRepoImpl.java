package com.apress.prospring5.ch18.repos;

import com.apress.prospring5.ch18.entities.Singer;
import io.reactivex.Flowable;
import io.reactivex.Single;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by iuliana.cosmina on 8/9/17.
 */
@Component
public class Rx2SingerRepoImpl implements Rx2SingerRepo {

	@Autowired
	SingerRepository singerRepository;

	@Override public Single<Singer> findById(Long id) {
		return Single.just(singerRepository.findById(id).get());
	}

	@Override public Flowable<Singer> findAll() {
		return Flowable.fromIterable(singerRepository.findAll());
	}

	@Override public Single<Void> save(Single<Singer> singerSingle) {
		  singerSingle.doOnSuccess(singer -> singerRepository.save(singer));
		return Single.just(null);
	}
}
