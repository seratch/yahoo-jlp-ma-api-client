# Yahoo!デベロッパーネットワーク 日本語形態素解析 API クライアント（Java）

Yahoo!デベロッパーネットワーク 日本語形態素解析APIのJavaクライアント実装です。

http://developer.yahoo.co.jp/webapi/jlp/ma/v1/parse.html

## インストール方法

### ダウンロード

    ./download/yahoo-jlp-ma-api-client-1.1.jar

### Maven

    <repositories>
      ...
      <repository>
        <id>yahoo-jlp-ma-api-client-releases</id>
        <url>https://github.com/seratch/yahoo-jlp-ma-api-client/raw/master/mvn-repo/releases</url>
      </repository>
      <repository>
        <id>yahoo-jlp-ma-api-client-snapshots</id>
        <url>https://github.com/seratch/yahoo-jlp-ma-api-client/raw/master/mvn-repo/snapshots</url>
      </repository>
      ...
    </repositories>

    <dependencies>
      ...
      <dependency>
        <groupId>com.github.seratch</groupId>
        <artifactId>yahoo-jlp-ma-api-client</artifactId>
        <version>1.1</version>
      </dependency>
      ...
    </dependencies>

## 実装サンプル

    YahooMAClient ma = new YahooMAClient(appid);
    String sentence = "庭には二羽ニワトリがいる。";
    List<YahooMAToken> resultList = ma.analyze(sentence);
    for (YahooMAToken token : resultList) {
        String result = "[表記:" + token.getSurface() 
                      + ",読み仮名:" + token.getReading()
                      + ",基本形表記:" + token.getBaseform() 
                      + ",品詞:" + token.getPos() + "]";
        System.out.println(result);
    }
    // [表記:庭,読み仮名:にわ,基本形表記:庭,品詞:名詞]
    // [表記:に,読み仮名:に,基本形表記:に,品詞:助詞]
    // [表記:は,読み仮名:は,基本形表記:は,品詞:助詞]
    // [表記:二,読み仮名:2,基本形表記:2,品詞:名詞]
    // [表記:羽,読み仮名:わ,基本形表記:羽,品詞:接尾辞]
    // [表記:ニワトリ,読み仮名:にわとり,基本形表記:ニワトリ,品詞:名詞]
    // [表記:が,読み仮名:が,基本形表記:が,品詞:助詞]
    // [表記:いる,読み仮名:いる,基本形表記:いる,品詞:動詞]
    // [表記:。,読み仮名:。,基本形表記:。,品詞:特殊]
