(ns lagenorhynque.ch03-slicing-and-appending
  "第3章 イミュータブルな値"
  (:require
   [clojure.spec.alpha :as s]))

;; 3.19 実習：イミュータブルなスライスとアペンド

(s/fdef first-two
  :args (s/cat :coll (s/coll-of any?))
  :ret (s/coll-of any?))

(defn first-two [coll]
  (take 2 coll))

(s/fdef last-two
  :args (s/cat :coll (s/coll-of any?))
  :ret (s/coll-of any?))

(defn last-two [coll]
  (take-last 2 coll))

(s/fdef moved-first-two-to-the-end
  :args (s/cat :coll (s/coll-of any?))
  :ret (s/coll-of any?))

(defn moved-first-two-to-the-end [coll]
  (let [[first-two after-first-two] (split-at 2 coll)]
    (concat after-first-two first-two)))

(s/fdef inserted-before-last
  :args (s/cat :coll (s/coll-of any?)
               :element any?)
  :ret (s/coll-of any?))

(defn inserted-before-last [coll elem]
  (let [[before-last last'] (split-at (dec (count coll)) coll)]
    (concat before-last (cons elem last'))))
