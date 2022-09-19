# StackOverflow - Android Questions

### Introduction

This is a sample Android app to demonstrate the use-case of Flow, and LiveData together. Previously, I was using Coroutines along with LiveData, but it was time to upgrade myself.

Regarding [Flow](https://developer.android.com/kotlin/flow), a flow is a type that can emit multiple values sequentially, as opposed to suspending functions that return only a single value. Flow is basically a **COLD** stream which means that it is on-demand and will emit the data when being observed or collected (`collect()`). On the other hand, Hot Flows as SharedFlow and StateFlow act differently. They are always **ACTIVE** regardless of being observed or not! More info: [StateFlow and SharedFlow](https://developer.android.com/kotlin/flow/stateflow-and-sharedflow)


### Preview

<img src="https://i.imgur.com/aLm0uGl.png" width="200" />

### Tech stacks & technologies

MVVM architecture | Hilt-dagger, LiveData, Flow, Retrofit, RecyclerView, DataBinding, Glide

