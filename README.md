# 眠活アプリ

最高の睡眠を取るための、ナイトルーティンの実行をサポートするアプリです。




## 作成した目的

『毎日を最高の状態で送りたい』  
というテーマに質の良い睡眠は不可欠です。  
質の良い睡眠を取るためには  

-起きている時間にどれだけ準備を行えるか　  

がポイントになります。

しかし、実際には以下の課題があります。    
-寝る直前までスマホをみてしまう。  
-食事や風呂の時間がどうしても遅くなってしまう。　　  


この課題を解決するために
ナイトルーティンの時間を就寝時間から逆算して知らせてくれるアプリを作成しました。　　　　　


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
