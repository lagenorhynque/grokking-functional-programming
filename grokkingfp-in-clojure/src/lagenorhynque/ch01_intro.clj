(ns lagenorhynque.ch01-intro
  "第1章 関数型プログラミングを学ぶ"
  (:require
   [clojure.spec.alpha :as s]))

;; 1.7 コーヒーブレイク：命令型と宣言型

(s/fdef calculate-score
  :args (s/cat :word string?)
  :ret number?)

(defn calculate-score [word]
  (loop [[c & cs] word
         score 0]
    (if c
      (recur cs
             (cond-> score
               (not= c \a) inc))
      score)))

(s/fdef word-score
  :args (s/cat :word string?)
  :ret number?)

(defn word-score [word]
  (->> word
       (remove #{\a})
       count))

(comment

  (calculate-score "imperative")
  (calculate-score "no")

  (word-score "declarative")
  (word-score "yes")

  )

;; 1.11 実習：Scalaで関数を書く

(s/fdef increment
  :args (s/cat :x number?)
  :ret number?)

(defn increment [x]
  (inc x))

(s/fdef get-first-character
  :args (s/cat :s string?)
  :ret char?)

(defn get-first-character [s]
  (first s))

(s/fdef word-score'
  :args (s/cat :word string?)
  :ret number?)

(defn word-score' [word]
  (count word))
