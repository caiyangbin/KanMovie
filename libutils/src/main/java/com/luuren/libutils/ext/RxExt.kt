//package com.egreat.movieposter.ext
//
//import io.reactivex.Observable
//import io.reactivex.android.schedulers.AndroidSchedulers
//import io.reactivex.disposables.Disposable
//import io.reactivex.schedulers.Schedulers
//
//typealias OnError = (Throwable) -> Unit
//typealias DoOnNext = (T:Any) -> Unit
//typealias OnCompile = () -> Unit
//typealias OnSubscribe = (Disposable) -> Unit
//
//fun <T:Any> doOnThread(next: () -> T, onNext: (T) -> Unit, doOnNext: DoOnNext? = null,
//                   onError: OnError? = null, onSubscribe: OnSubscribe? = null,
//                   onCompile: OnCompile? = null) {
//  Observable
//      .create<T> {
//        it.onNext(next.invoke())
//      }
//      .doOnNext {
//        doOnNext?.invoke(it)
//      }
//      .subscribeOn(Schedulers.io())
//      .observeOn(AndroidSchedulers.mainThread())
//      .subscribe({
//        onNext.invoke(it)
//      }, {
//        onError?.invoke(it)
//      }, {
//        onCompile?.invoke()
//      }, {
//        onSubscribe?.invoke(it)
//      })
//}
