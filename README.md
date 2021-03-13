# cdktf-sample-app

## 概要
ブログ「AWSへのデプロイ自動化と、CDK for Terraformでの管理」用のサンプルアプリ

## 実行環境
- [Scala: v2.13.3](https://medium.com/r/?url=https%3A%2F%2Fgithub.com%2Fscala%2Fscala)
- [Play Framework: v2.7.*](https://medium.com/r/?url=https%3A%2F%2Fgithub.com%2Fplayframework%2Fplayframework)
- [sbt: v1.3.13](https://medium.com/r/?url=https%3A%2F%2Fgithub.com%2Fsbt%2Fsbt)
- [sbt-native-packager: v1.7.6](https://medium.com/r/?url=https%3A%2F%2Fgithub.com%2Fsbt%2Fsbt-native-packager)
- [sbt-release: v1.0.13](https://medium.com/r/?url=https%3A%2F%2Fgithub.com%2Fsbt%2Fsbt-release)
- [sbt-ecr: v0.15.0](https://medium.com/r/?url=https%3A%2F%2Fgithub.com%2Fsjednac%2Fsbt-ecr)

## 構成図
![image](https://user-images.githubusercontent.com/57429437/111021925-ee773680-8412-11eb-81bc-e587134ef492.png)

## ブログ
[[1章] AWSへのデプロイ自動化と、CDK for Terraformでの管理](https://medium.com/nextbeat-engineering/1%E7%AB%A0-aws%E3%81%B8%E3%81%AE%E3%83%87%E3%83%97%E3%83%AD%E3%82%A4%E8%87%AA%E5%8B%95%E5%8C%96%E3%81%A8-cdk-for-terraform%E3%81%A7%E3%81%AE%E7%AE%A1%E7%90%86-425aaf06757e)

[[2章] Github Actionsでdocker imageを、AWS ECRへPUSHする](https://medium.com/@easygoing_mint_wombat_223/2%E7%AB%A0-github-actions%E3%81%A7docker-image%E3%82%92-aws-ecr%E3%81%B8push%E3%81%99%E3%82%8B-8d83a2e24c39)

[[3章] AWS ECRへのPUSH内容を、Slackへ通知する]()

[[4章] CDK for Terraformで、AWS Fargateの環境構築]()

[[5章] SlackからAWS ECSを更新させる]()

[[6章] AWS ECSの更新内容を、Slackへ通知する]()

## 初期化
```
$ git clone git@github.com:takapi327/cdktf-sample-app.git
```

### 設定
build.sbtの以下該当箇所を自分用に修正
```sbt
maintainer in Docker := "自分のメールアドレスに変更"
...
repositoryName in Ecr := "PUSHしたいECRリポジトリ"
```

.github/workflows/develop.ymlを修正
```yml
  run: |
    git config --global user.email "自分のメールアドレスに変更"
    git config --global user.name ${{ github.actor }}
    sbt "release with-defaults"

```
