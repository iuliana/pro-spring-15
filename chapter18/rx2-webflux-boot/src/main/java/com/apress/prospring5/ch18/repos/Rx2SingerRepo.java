package com.apress.prospring5.ch18.repos;

import com.apress.prospring5.ch18.entities.Singer;
import io.reactivex.Flowable;
import io.reactivex.Single;

/**
 * Created by iuliana.cosmina on 8/9/17.
 */
public interface Rx2SingerRepo {

	Single<Singer> findById(Long id);

	Flowable<Singer> findAll();

	Single<Void> save(Single<Singer> singer);

}
