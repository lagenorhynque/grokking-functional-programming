(ns lagenorhynque.ch03-abbreviate-names
  "第3章 イミュータブルな値"
  (:require
   [clojure.spec.alpha :as s]
   [clojure.string :as str]))

;; 3.15 コーヒーブレイク：イミュータブルなString API

(s/fdef abbreviate
  :args (s/cat :name string?)
  :ret string?)

(defn abbreviate [name]
  (let [[first-name last-name] (str/split name #" ")
        initial (first first-name)]
    (str initial ". " last-name)))
