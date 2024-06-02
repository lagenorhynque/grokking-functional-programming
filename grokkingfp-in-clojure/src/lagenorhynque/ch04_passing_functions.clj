(ns lagenorhynque.ch04-passing-functions
  "第4章 値としての関数"
  (:require
   [clojure.spec.alpha :as s]))

;; 4.17 実習：関数を渡す

(s/fdef len
  :args (s/cat :s string?)
  :ret nat-int?)

(defn len [s]
  (count s))

(s/fdef number-of-s
  :args (s/cat :s string?)
  :ret nat-int?)

(defn number-of-s [s]
  (->> s
       (filter #{\s})
       count))

(s/fdef negative
  :args (s/cat :n number?)
  :ret number?)

(defn negative [n]
  (- n))

(s/def negative-number-of-s
  (s/fspec :args (s/cat :s string?)
           :ret (complement pos-int?)))

(defn negative-number-of-s [s]
  (-> s
      number-of-s
      negative))
