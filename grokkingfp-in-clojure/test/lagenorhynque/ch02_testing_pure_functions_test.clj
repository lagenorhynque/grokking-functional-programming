(ns lagenorhynque.ch02-testing-pure-functions-test
  "第2章 純粋関数"
  (:require
   [clojure.test :as t]
   [lagenorhynque.ch01-intro :as intro]
   [lagenorhynque.ch02-testing-pure-functions :as tpf]
   [lagenorhynque.ch02-tip-calculator :as tip-calculator]))

;; 2.21 コーヒーブレイク：純粋関数のテスト

(t/deftest test-increment
  (t/testing "increments a number"
    (t/is (= 1 (intro/increment 0)))
    (t/is (= 0 (intro/increment -1)))
    (t/is (= 3 (intro/increment 2)))
    (t/is (= -2 (intro/increment -3)))))

(t/deftest test-add
  (t/testing "adds two numbers"
    (t/is (= 3 (tpf/add 1 2)))
    (t/is (= 0 (tpf/add 0 0)))
    (t/is (= -1 (tpf/add 1 -2)))
    (t/is (= 1 (tpf/add -1 2)))))

(t/deftest test-word-score
  (t/testing "calculates the score of a word"
    (t/is (= 3 (intro/word-score "Scala")))
    (t/is (= 7 (intro/word-score "Clojure")))
    (t/is (= 6 (intro/word-score "Haskell")))
    (t/is (= 0 (intro/word-score "")))))

(t/deftest test-get-tip-percentage
  (t/testing "gets the tip percentage"
    (t/is (= 0 (tip-calculator/get-tip-percentage [])))
    (t/is (= 10 (tip-calculator/get-tip-percentage ["Alice" "Bob" "Charlie" "David" "Eve"])))
    (t/is (= 20 (tip-calculator/get-tip-percentage ["Alice" "Bob" "Charlie" "David" "Eve" "Frank"])))))

(t/deftest test-get-first-character
  (t/testing "gets the first character of a string"
    (t/is (= \S (tpf/get-first-character "Scala")))
    (t/is (= \C (tpf/get-first-character "Clojure")))
    (t/is (= \H (tpf/get-first-character "Haskell")))
    (t/is (= \space (tpf/get-first-character "")))))
