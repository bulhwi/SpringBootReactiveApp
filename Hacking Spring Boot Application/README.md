
```
도서 : 스프링부트 실전 활용 마스터
저자 : 그렉 턴키스트
옮김 : 오명운
감수 : 이일민
```

```
jdk 8
spring boot 2.4.6
maven 
```
### dependency
* spring-boot-starter-thymeleaf : 타임리프 템플릿 엔진
* spring-boot-starter-webflux : 스프링 웹플러스 리액티브 웹 스택

### spring-boot-starter-test
* AssertJ
* Hamcrest
* HTMLUnits
* JSONassert
* JsonPath
* JUnit 5
* Mockito
* Selenium
* Spring Test
* XMLUnit

**리액티브 프로그래밍**   
대규모서비스에서 비동기적으로 인입되는 데이터스트림을 논블로킹 방식으로 처리하기 위한 방식.

[리액티브 스트림 설명](http://www.reactive-streams.org/)

리액티브 스트림은 수요조절에 기반하고 있다.
성능을 획기적으로 개선시키는 것은 아니지만 트래픽을 잘 조절해서 관리할 수 있는 장점이 있다.
개발자가 직접 다루는 것은 추천하지 않는다.

프로젝트 리액터    
VM웨어에서 만든 리액티브 스트림 구현체다.
리액터를 사용하면 다음 특성을 따르는 리액티브 프로그래밍을 활용할 수 있게 된다.
* 논블로킹, 비동기프로그래밍 모델
* 함수형 프로그래밍 스타일
* 스레드를 신경 쓸 필요 없는 동시성     

프로젝트 리액터는 핵심 타입인 `Flux<T>`를 사용해서 수요조절을 구현한다.//..
