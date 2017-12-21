# TDD_kotlin

[![CircleCI](https://circleci.com/gh/nashcft/TDD_kotlin.svg?style=svg)](https://circleci.com/gh/nashcft/TDD_kotlin)

## Part 1
### TODO List (Chapter 12~)

- [x] `$5 + 10CHF = $10` (レートが 2:1 の場合)
- [ ] `Money` の丸め処理をどうする?
- [x] $5 + $5 = $10
- [x] $5 + $5 = $10 が `Money` を返す
- [x] `Bank.reduce(Money)`
- [x] `Money` を変換して換算を行う
- [x] `Reduce(Bank, String)` 
- [x] `Sum.plus`
- [x] `Expression.times`
 
### TODO list (~Chapter 11)

- [x] `$5 * 2 = $10`
- [x] `amount` を private に
- [x] `Dollar` の副作用をどうする?
- [x] `equals()`
- [x] `hashCode()`
- [x] `null` との等値性比較
- [x] 他のオブジェクトとの等値性比較
- [x] 5CHF * 2 = 10CHF
- [x] `Dollar` と `Franc` の重複
- [x] `equals` の一般化
- [x] `times`  の一般化 (ほとんど)
- [x] `Franc` と `Dollar` を比較する
- [x] 通過の概念
- [x] `testFrancMultiplication` を削除する?

## Part 2
### TODO List

- [ ] テストメソッドを呼び出す
- [ ] `setUp` を最初に呼び出す
- [ ] `tearDown` を最後に呼び出す
- [ ] テストメソッドが失敗したとしても `tearDown` を呼び出す
- [ ] 複数のテストを走らせる
- [ ] 収集したテスト結果を出力する