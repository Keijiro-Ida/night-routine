# 眠活アプリ

最高の睡眠を取るための、ナイトルーティンの実行をサポートするアプリです。




## 作成した目的

私は、20代の時から浅い眠りに悩まされてきました。

30代に入り、これではまずいと思い、睡眠外来に診察してもらったところ、顎が細いことによる軽度の無呼吸症候群と言われました。　　　　　

マスクをして眠ることを義務とされてから、今までではありえない深い睡眠を手に入れました。　　　　　
この時、睡眠の大切さを身にしみて感じました。　　　　　
それから、私は睡眠のことを追い求めるようになりました。　　　　　


その中で、一つの気づきがありました。　　　　　
-起きている時間にどれだけ準備を行えるか　　　　　


睡眠の質は、起きている時間に何ができるか、で決まるということです。　　　　　
しかし、実際には以下の課題があります。　　　
-寝る直前までスマホをみてしまう。　　
-食事や風呂のの時間がどうしても遅くなってしまう。　　

この課題を解決するために、科学的に良いとされている、ナイトルーティンの時間を就寝時間から逆算して知らせてくれるアプリを作成しました。　　　　　




## URL
https://night-routine.herokuapp.com/





## 機能一覧
- ユーザー登録/ログイン機能
- ユーザーと習慣のCRUD
- SMTPプロトコルを用いたメール送信機能
- マルチスレッドを用いた設定時間でのスレッド実行
- 習慣削除による、スレッドのキャンセルと削除
- 習慣更新による、スレッドのキャンセルと始動
- アプリ停止の際のスレッド削除処理
- アプリ起動によるデータベース情報を元にスレッドの起動






## 使用技術
- Java SE1.8
- Servlet & JSP
- HTML/CSS
- Javascript
- jQuery
- MySQL 8.0
- Heroku
- Tomcat9
