(ns lagenorhynque.ch04-returning-functions
  "第4章 値としての関数"
  (:require
   [clojure.spec.alpha :as s]
   [lagenorhynque.ch04-passing-functions :as pf]))

;; 4.41 コーヒーブレイク：関数を返す

(s/fdef larger-than
  :args (s/cat :n number?)
  :ret (s/fspec :args (s/cat :i number?)
                :ret boolean?))

(defn larger-than [n]
  (fn [i] (> i n)))

(s/fdef divisible-by
  :args (s/cat :n number?)
  :ret (s/fspec :args (s/cat :i number?)
                :ret boolean?))

(defn divisible-by [n]
  (fn [i] (zero? (mod i n))))

(s/fdef shorter-than
  :args (s/cat :n number?)
  :ret (s/fspec :args (s/cat :s string?)
                :ret boolean?))

(defn shorter-than [n]
  (fn [s] (< (count s) n)))

(s/fdef contains-s
  :args (s/cat :more-than number?)
  :ret (s/fspec :args (s/cat :s string?)
                :ret boolean?))

(defn contains-s [more-than]
  (fn [s] (> (pf/number-of-s s) more-than)))
