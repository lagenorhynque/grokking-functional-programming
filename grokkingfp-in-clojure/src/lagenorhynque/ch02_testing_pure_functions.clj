(ns lagenorhynque.ch02-testing-pure-functions
  "第2章 純粋関数"
  (:require
   [clojure.spec.alpha :as s]))

;; 2.21 コーヒーブレイク：純粋関数のテスト

(s/fdef add
  :args (s/cat :a number?
               :b number?)
  :ret number?)

(defn add [a b]
  (+ a b))

(s/fdef get-first-character
  :args (s/cat :s string?)
  :ret char?)

(defn get-first-character [s]
  (if (empty? s)
    \space
    (first s)))
