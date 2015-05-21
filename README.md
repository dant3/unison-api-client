Unison API client
=============

This is a client library that provides interaction with [unison.com service][1] via [it's public API][2].


Usage
-------------

Add a dependency to your project. Here is an example with gradle:

```groovy
repositories {
    maven { url 'https://jitpack.io' }
}

dependencies {
    compile 'com.github.dant3:unison-api-client:0.1'
}
```

Api is very simple and straightforward:

```java
String login = "hello";
String passwd = "world";

UnisonApi unisonApi = UnisonApiClient.create(login, passwd);
CurrentUser me = unisonApi.whoAmI();
```

See JavaDoc (TODO: add link) for complete API reference


[1]: https://unison.com/
[2]: https://developers.unison.com/
