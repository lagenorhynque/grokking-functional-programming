(ns lagenorhynque.ch04-word-scoring
  "第4章 値としての関数"
  (:require
   [clojure.spec.alpha :as s]))

;; 4.22 コーヒーブレイク：Scalaで関数を渡す

(s/fdef ranked-words
  :args (s/cat :word-score-fn (s/fspec :args (s/cat :word string?)
                                       :ret number?)
               :words (s/coll-of string?))
  :ret (s/coll-of string?))

(defn ranked-words [word-score-fn words]
  (->> words
       (sort-by word-score-fn)
       reverse))

(s/fdef score
  :args (s/cat :word string?)
  :ret number?)

(defn score [word]
  (->> word
       (remove #{\a})
       count))

(s/fdef bonus
  :args (s/cat :word string?)
  :ret number?)

(defn bonus [word]
  (if (some #{\c} word)
    5
    0))

(s/fdef penalty
  :args (s/cat :word string?)
  :ret number?)

(defn penalty [word]
  (if (some #{\s} word)
    7
    0))
